package com.obric.oui.common.style;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.obric.oui.common.SdkInit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OUIStyleProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/oui/common/style/OUIStyleProvider;", "Lcom/obric/oui/common/style/IOUIStyleProvider;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "derStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mAlphaHelper", "Lcom/obric/oui/common/style/OUIAlphaHelper;", "mLayoutHelper", "Lcom/obric/oui/common/style/OUILayoutHelper;", "mOUIEffectHelper", "Lcom/obric/oui/common/style/OUIEffectHelper;", "getAlphaHelper", "Lcom/obric/oui/common/style/IOUIAlpha;", "getEffectHelper", "getLayoutHelper", "Lcom/obric/oui/common/style/IOUILayout;", "initView", "", "owner", "Landroid/view/View;", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OUIStyleProvider implements IOUIStyleProvider {
    public static final Companion Companion = null;
    private static final SdkInit sdkInit = null;
    private final OUIAlphaHelper mAlphaHelper;
    private final OUILayoutHelper mLayoutHelper;
    private OUIEffectHelper mOUIEffectHelper;

    /* JADX INFO: compiled from: OUIStyleProvider.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/common/style/OUIStyleProvider$Companion;", "", "()V", "sdkInit", "Lcom/obric/oui/common/SdkInit;", "getSdkInit$annotations", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private static /* synthetic */ void getSdkInit$annotations() {
        }

        private Companion() {
        }
    }

    public OUIStyleProvider(Context r2, AttributeSet r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.mLayoutHelper = new OUILayoutHelper(r2, r3, r4, r5);
        this.mAlphaHelper = new OUIAlphaHelper(r2, r3, r4, r5);
    }

    public final void initView(View r2) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        this.mLayoutHelper.initView(r2);
        this.mAlphaHelper.initView(r2);
        this.mOUIEffectHelper = new OUIEffectHelper(r2);
    }

    @Override // com.obric.oui.common.style.IOUIStyleProvider
    public IOUIAlpha getAlphaHelper() {
        return this.mAlphaHelper;
    }

    @Override // com.obric.oui.common.style.IOUIStyleProvider
    public IOUILayout getLayoutHelper() {
        return this.mLayoutHelper;
    }

    @Override // com.obric.oui.common.style.IOUIStyleProvider
    public OUIEffectHelper getEffectHelper() {
        OUIEffectHelper r0 = this.mOUIEffectHelper;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mOUIEffectHelper");
        return null;
    L6:
        return r0;
    }

    static {
        Companion = new Companion(null);
        sdkInit = new SdkInit();
    }
}
