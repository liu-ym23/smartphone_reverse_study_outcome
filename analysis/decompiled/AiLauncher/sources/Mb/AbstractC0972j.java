package Mb;

import Z8.C1177z;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J'\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u00122\u0006\u0010\u0011\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010\"\u001a\u00020\u001e2\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\"\u0010 J\u001f\u0010$\u001a\u00020#2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b$\u0010%J\u001f\u0010(\u001a\u00020#2\u0006\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0005H\u0016¢\u0006\u0004\b(\u0010)J\u001f\u0010*\u001a\u00020#2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u001cH\u0016¢\u0006\u0004\b*\u0010%J\u000f\u0010+\u001a\u00020#H\u0016¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0007H\u0016¢\u0006\u0004\b-\u0010.R\u0017\u0010\u0002\u001a\u00020\u00018\u0007¢\u0006\f\n\u0004\b\"\u0010/\u001a\u0004\b\u0002\u00100¨\u00061"}, d2 = {"LMb/j;", "LMb/i;", "delegate", "<init>", "(LMb/i;)V", "LMb/z;", "path", "", "functionName", "parameterName", "D0", "(LMb/z;Ljava/lang/String;Ljava/lang/String;)LMb/z;", "I0", "(LMb/z;Ljava/lang/String;)LMb/z;", "LMb/h;", "Y", "(LMb/z;)LMb/h;", Const.JSON_KEY_DIR, "", "U", "(LMb/z;)Ljava/util/List;", Const.STR_FILE, "LMb/g;", "e0", "(LMb/z;)LMb/g;", "LMb/I;", "v0", "(LMb/z;)LMb/I;", "", "mustCreate", "LMb/G;", "k0", "(LMb/z;Z)LMb/G;", "mustExist", "e", "LY8/t;", "m", "(LMb/z;Z)V", "source", "target", Const.INTENT_KEY_BACKGROUND_COMMAND, "(LMb/z;LMb/z;)V", "G", "close", "()V", "toString", "()Ljava/lang/String;", "LMb/i;", "()LMb/i;", "okio"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: Mb.j, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0972j extends AbstractC0971i {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final AbstractC0971i delegate;

    public AbstractC0972j(AbstractC0971i delegate) {
        kotlin.jvm.internal.p.i(delegate, "delegate");
        this.delegate = delegate;
    }

    public z D0(z path, String functionName, String parameterName) {
        kotlin.jvm.internal.p.i(path, "path");
        kotlin.jvm.internal.p.i(functionName, "functionName");
        kotlin.jvm.internal.p.i(parameterName, "parameterName");
        return path;
    }

    @Override // Mb.AbstractC0971i
    public void G(z path, boolean mustExist) throws IOException {
        kotlin.jvm.internal.p.i(path, "path");
        this.delegate.G(D0(path, ChatTracker.CLICK_DELETE, "path"), mustExist);
    }

    public z I0(z path, String functionName) {
        kotlin.jvm.internal.p.i(path, "path");
        kotlin.jvm.internal.p.i(functionName, "functionName");
        return path;
    }

    @Override // Mb.AbstractC0971i
    public List<z> U(z dir) throws IOException {
        kotlin.jvm.internal.p.i(dir, "dir");
        List<z> listU = this.delegate.U(D0(dir, "list", Const.JSON_KEY_DIR));
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = listU.iterator();
        while (it.hasNext()) {
            arrayList.add(I0((z) it.next(), "list"));
        }
        C1177z.B(arrayList);
        return arrayList;
    }

    @Override // Mb.AbstractC0971i
    public C0970h Y(z path) throws IOException {
        kotlin.jvm.internal.p.i(path, "path");
        C0970h c0970hY = this.delegate.Y(D0(path, "metadataOrNull", "path"));
        if (c0970hY == null) {
            return null;
        }
        return c0970hY.getSymlinkTarget() == null ? c0970hY : C0970h.b(c0970hY, false, false, I0(c0970hY.getSymlinkTarget(), "metadataOrNull"), null, null, null, null, null, 251, null);
    }

    @Override // Mb.AbstractC0971i, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    @Override // Mb.AbstractC0971i
    public G e(z file, boolean mustExist) throws IOException {
        kotlin.jvm.internal.p.i(file, "file");
        return this.delegate.e(D0(file, "appendingSink", Const.STR_FILE), mustExist);
    }

    @Override // Mb.AbstractC0971i
    public AbstractC0969g e0(z file) throws IOException {
        kotlin.jvm.internal.p.i(file, "file");
        return this.delegate.e0(D0(file, "openReadOnly", Const.STR_FILE));
    }

    @Override // Mb.AbstractC0971i
    public void g(z source, z target) throws IOException {
        kotlin.jvm.internal.p.i(source, "source");
        kotlin.jvm.internal.p.i(target, "target");
        this.delegate.g(D0(source, "atomicMove", "source"), D0(target, "atomicMove", "target"));
    }

    @Override // Mb.AbstractC0971i
    public G k0(z file, boolean mustCreate) throws IOException {
        kotlin.jvm.internal.p.i(file, "file");
        return this.delegate.k0(D0(file, "sink", Const.STR_FILE), mustCreate);
    }

    @Override // Mb.AbstractC0971i
    public void m(z dir, boolean mustCreate) throws IOException {
        kotlin.jvm.internal.p.i(dir, "dir");
        this.delegate.m(D0(dir, "createDirectory", Const.JSON_KEY_DIR), mustCreate);
    }

    public String toString() {
        return kotlin.jvm.internal.t.b(getClass()).t() + '(' + this.delegate + ')';
    }

    @Override // Mb.AbstractC0971i
    public I v0(z file) throws IOException {
        kotlin.jvm.internal.p.i(file, "file");
        return this.delegate.v0(D0(file, "source", Const.STR_FILE));
    }
}
