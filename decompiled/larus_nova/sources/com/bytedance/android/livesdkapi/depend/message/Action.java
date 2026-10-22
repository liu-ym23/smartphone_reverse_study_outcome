package com.bytedance.android.livesdkapi.depend.message;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/Action;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "ACTION_START", "ACTION_FINISH", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum Action extends Enum<Action> {
    private static final /* synthetic */ Action[] $VALUES = null;
    public static final Action ACTION_FINISH = null;
    public static final Action ACTION_START = null;
    private final int value;

    static {
        Action r100 = new Action("ACTION_START", 0, 0);
        ACTION_START = r100;
        Action r101 = new Action("ACTION_FINISH", 1, 1);
        ACTION_FINISH = r101;
        $VALUES = new Action[]{r100, r101};
    }

    public static Action valueOf(String r100) {
        return (Action) a.a(Action.class, r100);
    }

    public static Action[] values() {
        return (Action[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    private Action(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
