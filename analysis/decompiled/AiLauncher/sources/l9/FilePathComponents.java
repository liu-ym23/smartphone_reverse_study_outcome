package l9;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import io.ktor.http.ContentDisposition;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014R\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017R\u0011\u0010\u0019\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\r¨\u0006\u001a"}, d2 = {"Ll9/e;", "", "Ljava/io/File;", Parameters.ROOT, "", "segments", "<init>", "(Ljava/io/File;Ljava/util/List;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Ljava/io/File;", "()Ljava/io/File;", Const.INTENT_KEY_PKGNAME, "Ljava/util/List;", "()Ljava/util/List;", "c", ContentDisposition.Parameters.Size, "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: l9.e, reason: from toString */
/* loaded from: classes4.dex */
public final /* data */ class FilePathComponents {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final File root;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final List<File> segments;

    /* JADX WARN: Multi-variable type inference failed */
    public FilePathComponents(File root, List<? extends File> segments) {
        p.i(root, "root");
        p.i(segments, "segments");
        this.root = root;
        this.segments = segments;
    }

    /* renamed from: a, reason: from getter */
    public final File getRoot() {
        return this.root;
    }

    public final List<File> b() {
        return this.segments;
    }

    public final int c() {
        return this.segments.size();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FilePathComponents)) {
            return false;
        }
        FilePathComponents filePathComponents = (FilePathComponents) other;
        return p.d(this.root, filePathComponents.root) && p.d(this.segments, filePathComponents.segments);
    }

    public int hashCode() {
        return (this.root.hashCode() * 31) + this.segments.hashCode();
    }

    public String toString() {
        return "FilePathComponents(root=" + this.root + ", segments=" + this.segments + ')';
    }
}
