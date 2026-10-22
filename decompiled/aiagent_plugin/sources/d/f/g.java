package d.f;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.List;

/* JADX INFO: compiled from: FilePathComponents.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final File f38436a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<File> f38437b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, g.class) == true) goto L8;
        return false;
    L8:
        g r6 = (g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f38436a, r6.f38436a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f38437b, r6.f38437b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f38436a.hashCode() * 31) + this.f38437b.hashCode();
    }

    public String toString() {
        return "FilePathComponents(root=" + this.f38436a + ", segments=" + this.f38437b + ')';
    }

    public g(File r3, List<? extends File> r4) {
        List<File> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "root");
        d.h.b.o.e(r5, DBDefinition.SEGMENT_TABLE_NAME);
        this.f38436a = r3;
        this.f38437b = r5;
    }

    public final File a() {
        return this.f38436a;
    }

    public final List<File> b() {
        return this.f38437b;
    }

    public final int c() {
        return this.f38437b.size();
    }
}
