package com.obric.structure.omvvm.core.insight;

import android.text.TextUtils;
import com.obric.structure.omvvm.core.Q;
import com.obric.structure.omvvm.core.ui.QUIManager;
import com.obric.structure.omvvm.core.ui.QUIModule;
import com.obric.structure.omvvm.core.util.QExecutor;
import java.util.HashMap;
import java.util.Vector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: QInsight.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ0\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\u0016J\u0014\u0010\u0017\u001a\u00020\r2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\u0019J\u000e\u0010\u001a\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R*\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000R6\u0010\t\u001a*\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0006j\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n`\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/obric/structure/omvvm/core/insight/QInsight;", "", "()V", "TAG", "", "data", "Ljava/util/HashMap;", "Lcom/obric/structure/omvvm/core/ui/QUIModule;", "Lkotlin/collections/HashMap;", "records", "Ljava/util/Vector;", "Lcom/obric/structure/omvvm/core/insight/QInsightRecord;", "bind", "", "uiManager", "Lcom/obric/structure/omvvm/core/ui/QUIManager;", "record", "uiManagerKey", "uiModuleKey", "type", "message", "cost", "", "runIfEnabled", "block", "Lkotlin/Function0;", "unbind", "omvvm-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class QInsight {
    public static final QInsight INSTANCE = null;
    public static final String TAG = "QInsight";
    private static final HashMap<String, QUIModule> data = null;
    private static final HashMap<String, Vector<QInsightRecord>> records = null;

    /* JADX INFO: renamed from: $r8$lambda$fHUHPp6mOmQDEuJ4lYFu-0A6kOo, reason: not valid java name */
    public static /* synthetic */ void m771$r8$lambda$fHUHPp6mOmQDEuJ4lYFu0A6kOo(QUIManager r0) {
        unbind$lambda$0(r0);
    }

    private QInsight() {
    }

    static {
        INSTANCE = new QInsight();
        records = new HashMap();
        data = new HashMap();
    }

    public final void bind(QUIManager r2) {
        Intrinsics.checkNotNullParameter(r2, "uiManager");
        if (r2.getInsight() == true) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r2.getUiManagerKey()) == true) goto L9;
        data.put(r2.getUiManagerKey(), r2.getRootModule());
        return;
    }

    public final void unbind(final QUIManager r2) {
        Intrinsics.checkNotNullParameter(r2, "uiManager");
        QExecutor.INSTANCE.work().post(new QInsight$$ExternalSyntheticLambda0(r2));
    }

    private static final void unbind$lambda$0(QUIManager r1) {
        Intrinsics.checkNotNullParameter(r1, "$uiManager");
        if (r1.getInsight() == true) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r1.getUiManagerKey()) == true) goto L9;
        data.remove(r1.getUiManagerKey());
        return;
    }

    public static /* synthetic */ void record$default(QInsight r7, String r8, String r9, String r10, String r11, long r12, int r14, Object r15) {
        if ((r14 & 16) == 0) goto L5;
        r12 = 0;
    L5:
        r7.record(r8, r9, r10, r11, r12);
    }

    public final void record(String r14, String r15, String r16, String r17, long r18) {
        Intrinsics.checkNotNullParameter(r14, "uiManagerKey");
        Intrinsics.checkNotNullParameter(r15, "uiModuleKey");
        Intrinsics.checkNotNullParameter(r16, "type");
        Intrinsics.checkNotNullParameter(r17, "message");
        HashMap<String, Vector<QInsightRecord>> r0 = records;
        Vector<QInsightRecord> r5 = r0.get(r14);
        if (r5 != null) goto L5;
        r0.put(r14, new Vector());
        r5 = r0.get(r14);
    L5:
        Vector<QInsightRecord> r11 = r5;
        if (r11 == null) goto L9;
        r11.add(new QInsightRecord(r14, r15, r16, r17, r18, 0, 32, null));
        return;
    }

    public final void runIfEnabled(Function0<Unit> r1) {
        Intrinsics.checkNotNullParameter(r1, "block");
        if (Q.INSTANCE.isInsightEnabled() == false) goto L6;
        r1.invoke();
        return;
    }
}
