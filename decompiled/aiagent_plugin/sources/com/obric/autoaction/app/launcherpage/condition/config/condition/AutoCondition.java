package com.obric.autoaction.app.launcherpage.condition.config.condition;

import android.content.Context;
import android.os.Parcelable;
import android.view.View;
import com.obric.eventkit.task.model.Condition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: AutoCondition.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AutoCondition implements Parcelable {
    public static final a Companion = null;
    public static final int SENTENCE_DISPLAY = 2;
    public static final int SINGLE_DISPLAY = 1;
    private boolean active;
    private com.obric.autoaction.app.launcherpage.condition.config.condition.a autoConditionContext;
    private final GroupInfo groupInfo;
    private final boolean isPrimary;

    /* JADX INFO: compiled from: AutoCondition.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    public /* synthetic */ AutoCondition(GroupInfo r1, boolean r2, boolean r3, d.h.b.h r4) {
        this(r1, r2, r3);
    }

    public static /* synthetic */ void getAutoConditionContext$annotations() {
    }

    public abstract Condition buildCondition();

    public abstract CharSequence getDisplayEllipsizeText(Context r1, int r2);

    public abstract CharSequence getDisplayText(Context r1, int r2);

    public abstract boolean isSame(AutoCondition r1);

    public abstract Object updateCondition(Context r1, View r2, d.c.d<? super Boolean> r3);

    private AutoCondition(GroupInfo r1, boolean r2, boolean r3) {
        this.groupInfo = r1;
        this.active = r2;
        this.isPrimary = r3;
    }

    public /* synthetic */ AutoCondition(GroupInfo r1, boolean r2, boolean r3, int r4, d.h.b.h r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = false;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = true;
    L8:
        this(r1, r2, r3, null);
    }

    public final GroupInfo getGroupInfo() {
        return this.groupInfo;
    }

    public final boolean getActive() {
        return this.active;
    }

    public final void setActive(boolean r1) {
        this.active = r1;
    }

    public final boolean isPrimary() {
        return this.isPrimary;
    }

    public final com.obric.autoaction.app.launcherpage.condition.config.condition.a getAutoConditionContext() {
        return this.autoConditionContext;
    }

    public final void setAutoConditionContext(com.obric.autoaction.app.launcherpage.condition.config.condition.a r1) {
        this.autoConditionContext = r1;
    }

    public final void initAutoConditionContext(com.obric.autoaction.app.launcherpage.condition.config.condition.a r2) {
        o.e(r2, "context");
        this.autoConditionContext = r2;
    }

    public Condition configCondition(Condition r3) {
        o.e((Condition) ZeusTransformUtils.wrapperContextForParams(r3, Condition.class, "com.obric.aiagent.plugin"), "condition");
        return buildCondition();
    }
}
