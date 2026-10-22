package kotlinx.serialization.json.internal;

import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lkotlinx/serialization/json/internal/WriteMode;", "", "kotlinx-serialization-json"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class WriteMode {
    public static final WriteMode c;
    public static final WriteMode d;
    public static final WriteMode e;
    public static final WriteMode f;
    public static final /* synthetic */ WriteMode[] g;
    public static final /* synthetic */ K7.a h;

    /* renamed from: a, reason: collision with root package name */
    public final char f5266a;
    public final char b;

    static {
        WriteMode writeMode = new WriteMode("OBJ", 0, '{', '}');
        c = writeMode;
        WriteMode writeMode2 = new WriteMode("LIST", 1, '[', ']');
        d = writeMode2;
        WriteMode writeMode3 = new WriteMode("MAP", 2, '{', '}');
        e = writeMode3;
        WriteMode writeMode4 = new WriteMode("POLY_OBJ", 3, '[', ']');
        f = writeMode4;
        WriteMode[] writeModeArr = {writeMode, writeMode2, writeMode3, writeMode4};
        g = writeModeArr;
        h = kotlin.enums.a.a(writeModeArr);
    }

    public WriteMode(String str, int i, char c2, char c5) {
        this.f5266a = c2;
        this.b = c5;
    }

    public static WriteMode valueOf(String str) {
        return (WriteMode) Enum.valueOf(WriteMode.class, str);
    }

    public static WriteMode[] values() {
        return (WriteMode[]) g.clone();
    }
}
