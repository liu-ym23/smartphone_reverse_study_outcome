package ch.qos.logback.core;

import ch.qos.logback.core.recovery.ResilientFileOutputStream;
import ch.qos.logback.core.util.FileUtil;
import java.io.File;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* loaded from: classes.dex */
public class FileAppender<E> extends OutputStreamAppender<E> {
    protected boolean append = true;
    protected String fileName = null;
    private boolean prudent = false;

    private void safeWrite(E e4) throws Throwable {
        FileLock fileLockLock;
        FileChannel channel = ((ResilientFileOutputStream) getOutputStream()).getChannel();
        if (channel == null) {
            return;
        }
        try {
            fileLockLock = channel.lock();
            try {
                long jPosition = channel.position();
                long size = channel.size();
                if (size != jPosition) {
                    channel.position(size);
                }
                super.writeOut(e4);
                if (fileLockLock != null) {
                    fileLockLock.release();
                }
            } catch (Throwable th) {
                th = th;
                if (fileLockLock != null) {
                    fileLockLock.release();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileLockLock = null;
        }
    }

    public String getFile() {
        return this.fileName;
    }

    public boolean isAppend() {
        return this.append;
    }

    public boolean isPrudent() {
        return this.prudent;
    }

    public void openFile(String str) throws IOException {
        this.lock.lock();
        try {
            File file = new File(str);
            if (FileUtil.isParentDirectoryCreationRequired(file) && !FileUtil.createMissingParentDirectories(file)) {
                addError("Failed to create parent directories for [" + file.getAbsolutePath() + "]");
            }
            ResilientFileOutputStream resilientFileOutputStream = new ResilientFileOutputStream(file, this.append);
            resilientFileOutputStream.setContext(this.context);
            setOutputStream(resilientFileOutputStream);
            this.lock.unlock();
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }

    public final String rawFileProperty() {
        return this.fileName;
    }

    public void setAppend(boolean z4) {
        this.append = z4;
    }

    public void setFile(String str) {
        if (str == null) {
            this.fileName = str;
        } else {
            this.fileName = str.trim();
        }
    }

    public void setPrudent(boolean z4) {
        this.prudent = z4;
    }

    @Override // ch.qos.logback.core.OutputStreamAppender, ch.qos.logback.core.UnsynchronizedAppenderBase, ch.qos.logback.core.spi.LifeCycle
    public void start() {
        if (getFile() == null) {
            addError("\"File\" property not set for appender named [" + this.name + "].");
            return;
        }
        addInfo("File property is set to [" + this.fileName + "]");
        if (this.prudent && !isAppend()) {
            setAppend(true);
            addWarn("Setting \"Append\" property to true on account of \"Prudent\" mode");
        }
        try {
            openFile(getFile());
            super.start();
        } catch (IOException e4) {
            addError("openFile(" + this.fileName + "," + this.append + ") call failed.", e4);
        }
    }

    @Override // ch.qos.logback.core.OutputStreamAppender
    public void writeOut(E e4) throws Throwable {
        if (this.prudent) {
            safeWrite(e4);
        } else {
            super.writeOut(e4);
        }
    }
}
