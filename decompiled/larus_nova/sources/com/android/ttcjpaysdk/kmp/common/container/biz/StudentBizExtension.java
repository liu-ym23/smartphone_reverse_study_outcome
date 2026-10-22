package com.android.ttcjpaysdk.kmp.common.container.biz;

import com.android.ttcjpaysdk.kmp.common.container.caijingbid.IContainerContext;
import com.android.ttcjpaysdk.kmp.common.container.caijingbid.IContainerLifecycle;
import com.android.ttcjpaysdk.kmp.common.container.caijingbid.IFloatingLynxView;
import com.android.ttcjpaysdk.kmp.common.container.caijingbid.IKmpBizExtension;
import com.android.ttcjpaysdk.kmp.common.container.caijingbid.IWebviewLifecycle;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0004*\u0002\u000f\u0012\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0015\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010\u0010J\u0015\u0010\u0011\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010\u0013R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/container/biz/StudentBizExtension;", "Lcom/android/ttcjpaysdk/kmp/common/container/caijingbid/IKmpBizExtension;", "<init>", "()V", "floatingView", "Lcom/android/ttcjpaysdk/kmp/common/container/caijingbid/IFloatingLynxView;", "getBizName", "", "getContainerLifecycle", "Lcom/android/ttcjpaysdk/kmp/common/container/caijingbid/IContainerLifecycle;", "containerContext", "Lcom/android/ttcjpaysdk/kmp/common/container/caijingbid/IContainerContext;", "getWebviewLifecycle", "Lcom/android/ttcjpaysdk/kmp/common/container/caijingbid/IWebviewLifecycle;", "getHtmlJsb", "com/android/ttcjpaysdk/kmp/common/container/biz/StudentBizExtension$getHtmlJsb$1", "(Lcom/android/ttcjpaysdk/kmp/common/container/caijingbid/IContainerContext;)Lcom/android/ttcjpaysdk/kmp/common/container/biz/StudentBizExtension$getHtmlJsb$1;", "closeHostPageJsb", "com/android/ttcjpaysdk/kmp/common/container/biz/StudentBizExtension$closeHostPageJsb$1", "(Lcom/android/ttcjpaysdk/kmp/common/container/caijingbid/IContainerContext;)Lcom/android/ttcjpaysdk/kmp/common/container/biz/StudentBizExtension$closeHostPageJsb$1;", "Companion", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StudentBizExtension implements IKmpBizExtension {
    public static final int $stable = 0;
    public static final String BIZ_NAME = "student_verify";
    public static final String CJ_FLOATING_VIEW_SCHEMA = "cj_floating_view_schema";
    public static final Companion Companion = null;
    private IFloatingLynxView floatingView;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/container/biz/StudentBizExtension$Companion;", "", "<init>", "()V", "BIZ_NAME", "", "CJ_FLOATING_VIEW_SCHEMA", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
    }

    public StudentBizExtension() {
    }

    @Override // com.android.ttcjpaysdk.kmp.common.container.caijingbid.IKmpBizExtension
    public String getBizName() {
        return BIZ_NAME;
    }

    public static final /* synthetic */ IFloatingLynxView access$getFloatingView$p(StudentBizExtension r100) {
        return r100.floatingView;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.android.ttcjpaysdk.kmp.common.container.biz.StudentBizExtension$closeHostPageJsb$1] */
    private final AnonymousClass1 closeHostPageJsb(final IContainerContext r100) {
        return new AnonymousClass1(r100);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.android.ttcjpaysdk.kmp.common.container.biz.StudentBizExtension$getHtmlJsb$1] */
    private final C92761 getHtmlJsb(final IContainerContext r100) {
        return new C92761(r100);
    }

    @Override // com.android.ttcjpaysdk.kmp.common.container.caijingbid.IKmpBizExtension
    public IContainerLifecycle getContainerLifecycle(final IContainerContext r100) {
        Intrinsics.checkNotNullParameter(r100, "containerContext");
        return new C92751(r100, this);
    }

    @Override // com.android.ttcjpaysdk.kmp.common.container.caijingbid.IKmpBizExtension
    public IWebviewLifecycle getWebviewLifecycle(IContainerContext r100) {
        Intrinsics.checkNotNullParameter(r100, "containerContext");
        return new C92771(this);
    }

    public static final /* synthetic */ AnonymousClass1 access$closeHostPageJsb(StudentBizExtension r100, IContainerContext r101) {
        return r100.closeHostPageJsb(r101);
    }

    public static final /* synthetic */ C92761 access$getHtmlJsb(StudentBizExtension r100, IContainerContext r101) {
        return r100.getHtmlJsb(r101);
    }

    public static final /* synthetic */ void access$setFloatingView$p(StudentBizExtension r100, IFloatingLynxView r101) {
        r100.floatingView = r101;
    }
}
