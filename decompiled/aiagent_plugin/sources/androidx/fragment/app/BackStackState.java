package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
final class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = null;
    private static final String TAG = "FragmentManager";
    final int mBreadCrumbShortTitleRes;
    final CharSequence mBreadCrumbShortTitleText;
    final int mBreadCrumbTitleRes;
    final CharSequence mBreadCrumbTitleText;
    final int[] mCurrentMaxLifecycleStates;
    final ArrayList<String> mFragmentWhos;
    final int mIndex;
    final String mName;
    final int[] mOldMaxLifecycleStates;
    final int[] mOps;
    final boolean mReorderingAllowed;
    final ArrayList<String> mSharedElementSourceNames;
    final ArrayList<String> mSharedElementTargetNames;
    final int mTransition;

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.v(r0, r1);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public BackStackState(a r8) {
        int r0 = r8.f1826d.size();
        this.mOps = new int[r0 * 5];
        if (r8.j == false) goto L14;
        this.mFragmentWhos = new ArrayList(r0);
        this.mOldMaxLifecycleStates = new int[r0];
        this.mCurrentMaxLifecycleStates = new int[r0];
        int r1 = 0;
        int r2 = 0;
    L5:
        if (r1 >= r0) goto L11;
        m.a r3 = (m.a) ZeusTransformUtils.preCheckCast(r8.f1826d.get(r1), m.a.class, "com.obric.aiagent.plugin");
        int r5 = r2 + 1;
        this.mOps[r2] = r3.f1828a;
        ArrayList<String> r4 = this.mFragmentWhos;
        if (r3.f1829b == null) goto L9;
        String r6 = r3.f1829b.mWho;
    L10:
        r4.add(r6);
        int r7 = r5 + 1;
        this.mOps[r5] = r3.f1830c;
        int r9 = r7 + 1;
        this.mOps[r7] = r3.f1831d;
        int r10 = r9 + 1;
        this.mOps[r9] = r3.f1832e;
        this.mOps[r10] = r3.f;
        this.mOldMaxLifecycleStates[r1] = r3.g.ordinal();
        this.mCurrentMaxLifecycleStates[r1] = r3.h.ordinal();
        r1 = r1 + 1;
        r2 = r10 + 1;
        goto L5
    L9:
        r6 = null;
        goto L10
    L11:
        this.mTransition = r8.i;
        this.mName = r8.l;
        this.mIndex = r8.f1768c;
        this.mBreadCrumbTitleRes = r8.m;
        this.mBreadCrumbTitleText = r8.n;
        this.mBreadCrumbShortTitleRes = r8.o;
        this.mBreadCrumbShortTitleText = r8.p;
        this.mSharedElementSourceNames = r8.q;
        this.mSharedElementTargetNames = r8.r;
        this.mReorderingAllowed = r8.s;
        return;
    L14:
        throw new IllegalStateException("Not on back stack");
    }

    public BackStackState(Parcel r4) {
        this.mOps = r4.createIntArray();
        this.mFragmentWhos = r4.createStringArrayList();
        this.mOldMaxLifecycleStates = r4.createIntArray();
        this.mCurrentMaxLifecycleStates = r4.createIntArray();
        this.mTransition = r4.readInt();
        this.mName = r4.readString();
        this.mIndex = r4.readInt();
        this.mBreadCrumbTitleRes = r4.readInt();
        this.mBreadCrumbTitleText = (CharSequence) ZeusTransformUtils.preCheckCast(TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r4), CharSequence.class, "com.obric.aiagent.plugin");
        this.mBreadCrumbShortTitleRes = r4.readInt();
        this.mBreadCrumbShortTitleText = (CharSequence) ZeusTransformUtils.preCheckCast(TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r4), CharSequence.class, "com.obric.aiagent.plugin");
        this.mSharedElementSourceNames = r4.createStringArrayList();
        this.mSharedElementTargetNames = r4.createStringArrayList();
        if (r4.readInt() == 0) goto L5;
        boolean r5 = true;
    L6:
        this.mReorderingAllowed = r5;
        return;
    L5:
        r5 = false;
        goto L6
    }

    public a instantiate(FragmentManager r8) {
        a r0 = new a(r8);
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r1 >= this.mOps.length) goto L13;
        m.a r3 = new m.a();
        int r5 = r1 + 1;
        r3.f1828a = this.mOps[r1];
        if (FragmentManager.a(2) == false) goto L8;
        INVOKESTATIC_androidx_fragment_app_BackStackState_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_v(TAG, "Instantiate " + r0 + " op #" + r2 + " base fragment #" + this.mOps[r5]);
    L8:
        String r4 = (String) ZeusTransformUtils.preCheckCast(this.mFragmentWhos.get(r2), String.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L11;
        r3.f1829b = r8.d(r4);
    L12:
        r3.g = androidx.lifecycle.i.b.values()[this.mOldMaxLifecycleStates[r2]];
        r3.h = androidx.lifecycle.i.b.values()[this.mCurrentMaxLifecycleStates[r2]];
        int r6 = r5 + 1;
        r3.f1830c = this.mOps[r5];
        int r7 = r6 + 1;
        r3.f1831d = this.mOps[r6];
        int r9 = r7 + 1;
        r3.f1832e = this.mOps[r7];
        r3.f = this.mOps[r9];
        r0.f1827e = r3.f1830c;
        r0.f = r3.f1831d;
        r0.g = r3.f1832e;
        r0.h = r3.f;
        r0.a(r3);
        r2 = r2 + 1;
        r1 = r9 + 1;
        goto L4
    L11:
        r3.f1829b = null;
        goto L12
    L13:
        r0.i = this.mTransition;
        r0.l = this.mName;
        r0.f1768c = this.mIndex;
        r0.j = true;
        r0.m = this.mBreadCrumbTitleRes;
        r0.n = this.mBreadCrumbTitleText;
        r0.o = this.mBreadCrumbShortTitleRes;
        r0.p = this.mBreadCrumbShortTitleText;
        r0.q = this.mSharedElementSourceNames;
        r0.r = this.mSharedElementTargetNames;
        r0.s = this.mReorderingAllowed;
        r0.a(1);
        return r0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        r2.writeIntArray(this.mOps);
        r2.writeStringList(this.mFragmentWhos);
        r2.writeIntArray(this.mOldMaxLifecycleStates);
        r2.writeIntArray(this.mCurrentMaxLifecycleStates);
        r2.writeInt(this.mTransition);
        r2.writeString(this.mName);
        r2.writeInt(this.mIndex);
        r2.writeInt(this.mBreadCrumbTitleRes);
        TextUtils.writeToParcel(this.mBreadCrumbTitleText, r2, 0);
        r2.writeInt(this.mBreadCrumbShortTitleRes);
        TextUtils.writeToParcel(this.mBreadCrumbShortTitleText, r2, 0);
        r2.writeStringList(this.mSharedElementSourceNames);
        r2.writeStringList(this.mSharedElementTargetNames);
        r2.writeInt(this.mReorderingAllowed ? 1 : 0);
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_androidx_fragment_app_BackStackState_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_v(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.v(r1, r2);
    }
}
