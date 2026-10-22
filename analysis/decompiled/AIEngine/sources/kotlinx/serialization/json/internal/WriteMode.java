package kotlinx.serialization.json.internal;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class WriteMode {

    /* renamed from: c, reason: collision with root package name */
    public static final WriteMode f10136c;

    /* renamed from: d, reason: collision with root package name */
    public static final WriteMode f10137d;

    /* renamed from: e, reason: collision with root package name */
    public static final WriteMode f10138e;
    public static final WriteMode h;

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ WriteMode[] f10139j;

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ sb.a f10140k;

    /* renamed from: a, reason: collision with root package name */
    public final char f10141a;

    /* renamed from: b, reason: collision with root package name */
    public final char f10142b;

    static {
        WriteMode writeMode = new WriteMode("OBJ", 0, '{', '}');
        f10136c = writeMode;
        WriteMode writeMode2 = new WriteMode("LIST", 1, '[', ']');
        f10137d = writeMode2;
        WriteMode writeMode3 = new WriteMode("MAP", 2, '{', '}');
        f10138e = writeMode3;
        WriteMode writeMode4 = new WriteMode("POLY_OBJ", 3, '[', ']');
        h = writeMode4;
        WriteMode[] writeModeArr = {writeMode, writeMode2, writeMode3, writeMode4};
        f10139j = writeModeArr;
        f10140k = kotlin.enums.a.a(writeModeArr);
    }

    public WriteMode(String str, int i10, char c9, char c10) {
        this.f10141a = c9;
        this.f10142b = c10;
    }

    public static WriteMode valueOf(String str) {
        return (WriteMode) Enum.valueOf(WriteMode.class, str);
    }

    public static WriteMode[] values() {
        return (WriteMode[]) f10139j.clone();
    }
}
