package com.android.ttcjpaysdk.base.serverevent;

import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/base/serverevent/Action;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", FeatureConfigInfo.PUSH_FEATURE_TYPE_ID, "POP", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum Action extends Enum<Action> {
    private static final /* synthetic */ Action[] $VALUES = null;
    public static final Action POP = null;
    public static final Action PUSH = null;
    private final String value;

    private static final /* synthetic */ Action[] $values() {
        return new Action[]{PUSH, POP};
    }

    public static Action valueOf(String r100) {
        return (Action) a.a(Action.class, r100);
    }

    public static Action[] values() {
        return (Action[]) $VALUES.clone();
    }

    static {
        PUSH = new Action(FeatureConfigInfo.PUSH_FEATURE_TYPE_ID, 0, "push");
        POP = new Action("POP", 1, "pop");
        $VALUES = $values();
    }

    public final String getValue() {
        return this.value;
    }

    private Action(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
