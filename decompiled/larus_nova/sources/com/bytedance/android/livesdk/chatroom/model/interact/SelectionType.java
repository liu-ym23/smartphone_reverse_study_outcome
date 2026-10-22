package com.bytedance.android.livesdk.chatroom.model.interact;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/SelectionType;", "", "", "value", "I", "getValue", "()I", "UNKNOWN", EffectConstants.NORMAL, "SCORING", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum SelectionType extends Enum<SelectionType> {
    public static final SelectionType NORMAL = null;
    public static final SelectionType SCORING = null;
    public static final SelectionType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SelectionType[] f106939a = null;
    private final int value;

    static {
        SelectionType r100 = new SelectionType("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        SelectionType r101 = new SelectionType(EffectConstants.NORMAL, 1, 1);
        NORMAL = r101;
        SelectionType r102 = new SelectionType("SCORING", 2, 2);
        SCORING = r102;
        f106939a = new SelectionType[]{r100, r101, r102};
    }

    public static SelectionType valueOf(String r100) {
        return (SelectionType) r27.a.a(SelectionType.class, r100);
    }

    public static SelectionType[] values() {
        return (SelectionType[]) f106939a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public SelectionType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
