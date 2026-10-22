package com.bytedance.android.livesdk.livecommerce.intro.card.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.ec.core.utils.c0;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import oh2.e;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0004B'\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aR$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/card/widget/IntroCardTitleComponent;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "Loh2/e;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Loh2/e;", "getArgument", "()Loh2/e;", "setArgument", "(Loh2/e;)V", "argument", "Loh2/c;", "b", "Loh2/c;", "getContainerAbility", "()Loh2/c;", "setContainerAbility", "(Loh2/c;)V", "containerAbility", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IntroCardTitleComponent extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f147989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public oh2.c f147990b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f147991c;

    public static final class a {
    }

    static {
    }

    public IntroCardTitleComponent(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public IntroCardTitleComponent(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public e getArgument() {
        return this.f147989a;
    }

    public oh2.c getContainerAbility() {
        return this.f147990b;
    }

    public void setArgument(e r100) {
        this.f147989a = r100;
    }

    public void setContainerAbility(oh2.c r100) {
        this.f147990b = r100;
    }

    public IntroCardTitleComponent(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        c0.b(this, 500);
    }

    public /* synthetic */ IntroCardTitleComponent(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
