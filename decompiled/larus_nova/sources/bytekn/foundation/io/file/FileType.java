package bytekn.foundation.io.file;

import com.bytedance.speech.speechengine.SpeechEngineDefines;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lbytekn/foundation/io/file/FileType;", "", "Regular", SpeechEngineDefines.RECORDER_TYPE_DIRECTORY, "Unknown", "kn_io_release"}, k = 1, mv = {1, 4, 0})
public final enum FileType extends Enum<FileType> {
    public static final FileType Directory = null;
    public static final FileType Regular = null;
    public static final FileType Unknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FileType[] f21783a = null;

    static {
        FileType r100 = new FileType("Regular", 0);
        Regular = r100;
        FileType r101 = new FileType(SpeechEngineDefines.RECORDER_TYPE_DIRECTORY, 1);
        Directory = r101;
        FileType r102 = new FileType("Unknown", 2);
        Unknown = r102;
        f21783a = new FileType[]{r100, r101, r102};
    }

    public static FileType valueOf(String r100) {
        return (FileType) r27.a.a(FileType.class, r100);
    }

    public static FileType[] values() {
        return (FileType[]) f21783a.clone();
    }

    public FileType(String r100, int r101) {
        super(r100, r101);
    }
}
