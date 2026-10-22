package io.ktor.server.http.content;

import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0007\u001a\u0004\b\n\u0010\tj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lio/ktor/server/http/content/CompressedFileType;", "", "", "extension", "encoding", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "Ljava/lang/String;", "getExtension", "()Ljava/lang/String;", "getEncoding", "BROTLI", "GZIP", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CompressedFileType {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ CompressedFileType[] $VALUES;
    public static final CompressedFileType BROTLI = new CompressedFileType("BROTLI", 0, "br", null, 2, null);
    public static final CompressedFileType GZIP = new CompressedFileType("GZIP", 1, "gz", "gzip");
    private final String encoding;
    private final String extension;

    private static final /* synthetic */ CompressedFileType[] $values() {
        return new CompressedFileType[]{BROTLI, GZIP};
    }

    static {
        CompressedFileType[] compressedFileTypeArr$values = $values();
        $VALUES = compressedFileTypeArr$values;
        $ENTRIES = kotlin.enums.a.a(compressedFileTypeArr$values);
    }

    private CompressedFileType(String str, int i10, String str2, String str3) {
        this.extension = str2;
        this.encoding = str3;
    }

    public static InterfaceC4149a<CompressedFileType> getEntries() {
        return $ENTRIES;
    }

    public static CompressedFileType valueOf(String str) {
        return (CompressedFileType) Enum.valueOf(CompressedFileType.class, str);
    }

    public static CompressedFileType[] values() {
        return (CompressedFileType[]) $VALUES.clone();
    }

    public final String getEncoding() {
        return this.encoding;
    }

    public final String getExtension() {
        return this.extension;
    }

    public /* synthetic */ CompressedFileType(String str, int i10, String str2, String str3, int i11, kotlin.jvm.internal.i iVar) {
        this(str, i10, str2, (i11 & 2) != 0 ? str2 : str3);
    }
}
