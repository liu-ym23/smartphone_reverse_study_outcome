package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/gallery/State;", "", "", "value", "I", "getValue", "()I", "HIDE", "SHOW", "ANIM_END", EffectConstants.NORMAL, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum State extends Enum<State> {
    public static final State ANIM_END = null;
    public static final State HIDE = null;
    public static final State NORMAL = null;
    public static final State SHOW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ State[] f169273a = null;
    private final int value;

    static {
        State r100 = new State("HIDE", 0, 0);
        HIDE = r100;
        State r101 = new State("SHOW", 1, 1);
        SHOW = r101;
        State r102 = new State("ANIM_END", 2, 2);
        ANIM_END = r102;
        State r103 = new State(EffectConstants.NORMAL, 3, 3);
        NORMAL = r103;
        f169273a = new State[]{r100, r101, r102, r103};
    }

    public static State valueOf(String r100) {
        return (State) r27.a.a(State.class, r100);
    }

    public static State[] values() {
        return (State[]) f169273a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public State(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
