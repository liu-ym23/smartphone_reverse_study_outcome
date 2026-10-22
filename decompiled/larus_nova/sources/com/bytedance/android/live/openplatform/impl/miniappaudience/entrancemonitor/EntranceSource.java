package com.bytedance.android.live.openplatform.impl.miniappaudience.entrancemonitor;

import com.ss.android.lark.url.card.UrlCardProperty;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappaudience/entrancemonitor/EntranceSource;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "EnterRoom", "ImMessage", "Invalid", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum EntranceSource extends Enum<EntranceSource> {
    public static final EntranceSource EnterRoom = null;
    public static final EntranceSource ImMessage = null;
    public static final EntranceSource Invalid = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EntranceSource[] f84791a = null;
    private final String value;

    static {
        EntranceSource r100 = new EntranceSource("EnterRoom", 0, "enter_room");
        EnterRoom = r100;
        EntranceSource r101 = new EntranceSource("ImMessage", 1, UrlCardProperty.URL_PREVIEW_BUSINESS_HOST);
        ImMessage = r101;
        EntranceSource r102 = new EntranceSource("Invalid", 2, "invalid");
        Invalid = r102;
        f84791a = new EntranceSource[]{r100, r101, r102};
    }

    public static EntranceSource valueOf(String r100) {
        return (EntranceSource) a.a(EntranceSource.class, r100);
    }

    public static EntranceSource[] values() {
        return (EntranceSource[]) f84791a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public EntranceSource(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
