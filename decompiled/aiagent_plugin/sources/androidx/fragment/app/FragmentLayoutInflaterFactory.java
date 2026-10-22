package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
class FragmentLayoutInflaterFactory implements LayoutInflater.Factory2 {
    private static final String TAG = "FragmentManager";
    final FragmentManager mFragmentManager;

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.v(r0, r1);
    }

    FragmentLayoutInflaterFactory(FragmentManager r1) {
        this.mFragmentManager = r1;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String r3, Context r4, AttributeSet r5) {
        return onCreateView(null, r3, (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin"));
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View r10, String r11, Context r12, AttributeSet r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r15 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r13, AttributeSet.class, "com.obric.aiagent.plugin");
        if (FragmentContainerView.class.getName().equals(r11) == true) goto L5;
        Fragment r0 = null;
        if ("fragment".equals(r11) == true) goto L9;
        return null;
    L9:
        String r16 = r15.getAttributeValue(null, "class");
        TypedArray r2 = r14.obtainStyledAttributes(r15, R.styleable.Fragment);
        if (r16 != null) goto L12;
        r16 = r2.getString(ZeusTransformUtils.mapRes(R.styleable.Fragment_android_name, "styleable", "Fragment_android_name"));
    L12:
        int r4 = r2.getResourceId(ZeusTransformUtils.mapRes(R.styleable.Fragment_android_id, "styleable", "Fragment_android_id"), -1);
        String r3 = r2.getString(ZeusTransformUtils.mapRes(R.styleable.Fragment_android_tag, "styleable", "Fragment_android_tag"));
        r2.recycle();
        if (r16 != null) goto L15;
    L61:
        return null;
    L15:
        if (FragmentFactory.a(r14.getClassLoader(), r16) == false) goto L61;
        if (r10 == null) goto L19;
        int r5 = r10.getId();
    L20:
        if (r5 != (-1)) goto L26;
        if (r4 != (-1)) goto L26;
        if (r3 != null) goto L26;
        throw new IllegalArgumentException(r15.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + r16);
    L26:
        if (r4 == (-1)) goto L28;
        r0 = this.mFragmentManager.c(r4);
    L28:
        if (r0 != null) goto L31;
        if (r3 == null) goto L31;
        r0 = this.mFragmentManager.b(r3);
    L31:
        if (r0 != null) goto L35;
        if (r5 == (-1)) goto L35;
        r0 = this.mFragmentManager.c(r5);
    L35:
        if (r0 != null) goto L44;
        r0 = this.mFragmentManager.D().c(r14.getClassLoader(), r16);
        r0.mFromLayout = true;
        if (r4 == 0) goto L39;
        int r17 = r4;
    L40:
        r0.mFragmentId = r17;
        r0.mContainerId = r5;
        r0.mTag = r3;
        r0.mInLayout = true;
        r0.mFragmentManager = this.mFragmentManager;
        r0.mHost = this.mFragmentManager.l();
        r0.onInflate((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mFragmentManager.l().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r15, r0.mSavedFragmentState);
        final k r18 = this.mFragmentManager.j(r0);
        if (FragmentManager.a(2) == false) goto L48;
        INVOKESTATIC_androidx_fragment_app_FragmentLayoutInflaterFactory_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_v(TAG, "Fragment " + r0 + " has been inflated via the <fragment> tag: id=0x" + Integer.toHexString(r4));
    L48:
        r0.mContainer = (ViewGroup) ZeusTransformUtils.preCheckCast(r10, ViewGroup.class, "com.obric.aiagent.plugin");
        r18.c();
        r18.d();
        if (r0.mView == null) goto L58;
        if (r4 == 0) goto L53;
        r0.mView.setId(r4);
    L53:
        if (r0.mView.getTag() != null) goto L55;
        r0.mView.setTag(r3);
    L55:
        r0.mView.addOnAttachStateChangeListener(new AnonymousClass1(this, r18));
        return r0.mView;
    L58:
        throw new IllegalStateException("Fragment " + r16 + " did not create a view.");
    L39:
        r17 = r5;
        goto L40
    L44:
        if (r0.mInLayout == true) goto L60;
        r0.mInLayout = true;
        r0.mFragmentManager = this.mFragmentManager;
        r0.mHost = this.mFragmentManager.l();
        r0.onInflate((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mFragmentManager.l().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r15, r0.mSavedFragmentState);
        r18 = this.mFragmentManager.i(r0);
        if (FragmentManager.a(2) == false) goto L48;
        INVOKESTATIC_androidx_fragment_app_FragmentLayoutInflaterFactory_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_v(TAG, "Retained Fragment " + r0 + " has been re-attached via the <fragment> tag: id=0x" + Integer.toHexString(r4));
        goto L48
    L60:
        throw new IllegalArgumentException(r15.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(r4) + ", tag " + r3 + ", or parent id 0x" + Integer.toHexString(r5) + " with another fragment for " + r16);
    L19:
        r5 = 0;
        goto L20
    L5:
        return new FragmentContainerView(r14, r15, this.mFragmentManager);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_androidx_fragment_app_FragmentLayoutInflaterFactory_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_v(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.v(r1, r2);
    }
}
