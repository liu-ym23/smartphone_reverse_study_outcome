package ch.qos.logback.core.joran.spi;

import ch.qos.logback.core.joran.action.Action;
import ch.qos.logback.core.spi.ContextAwareBase;
import java.io.File;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ConfigurationWatchList extends ContextAwareBase {
    List<File> fileWatchList = new ArrayList();
    List<Long> lastModifiedList = new ArrayList();
    URL mainURL;

    private void addAsFileToWatch(URL url) {
        File fileConvertToFile = convertToFile(url);
        if (fileConvertToFile != null) {
            this.fileWatchList.add(fileConvertToFile);
            this.lastModifiedList.add(Long.valueOf(fileConvertToFile.lastModified()));
        }
    }

    public void addToWatchList(URL url) {
        addAsFileToWatch(url);
    }

    public boolean changeDetected() {
        int size = this.fileWatchList.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (this.lastModifiedList.get(i4).longValue() != this.fileWatchList.get(i4).lastModified()) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        this.mainURL = null;
        this.lastModifiedList.clear();
        this.fileWatchList.clear();
    }

    public File convertToFile(URL url) {
        if (Action.FILE_ATTRIBUTE.equals(url.getProtocol())) {
            return new File(URLDecoder.decode(url.getFile()));
        }
        addInfo("URL [" + url + "] is not of type file");
        return null;
    }

    public List<File> getCopyOfFileWatchList() {
        return new ArrayList(this.fileWatchList);
    }

    public URL getMainURL() {
        return this.mainURL;
    }

    public void setMainURL(URL url) {
        this.mainURL = url;
        if (url != null) {
            addAsFileToWatch(url);
        }
    }
}
