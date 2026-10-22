package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = new a();
    final List<String> mFragments;
    final List<BackStackRecordState> mTransactions;

    public class a implements Parcelable.Creator<BackStackState> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BackStackState createFromParcel(Parcel parcel) {
            return new BackStackState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public BackStackState[] newArray(int i10) {
            return new BackStackState[i10];
        }
    }

    public BackStackState(List<String> list, List<BackStackRecordState> list2) {
        this.mFragments = list;
        this.mTransactions = list2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<C1363a> instantiate(FragmentManager fragmentManager, Map<String, Fragment> map) {
        HashMap map2 = new HashMap(this.mFragments.size());
        for (String str : this.mFragments) {
            Fragment fragment = map.get(str);
            if (fragment != null) {
                map2.put(fragment.mWho, fragment);
            } else {
                Bundle bundleB = fragmentManager.y0().B(str, null);
                if (bundleB != null) {
                    ClassLoader classLoader = fragmentManager.A0().getContext().getClassLoader();
                    Fragment fragmentInstantiate = ((FragmentState) bundleB.getParcelable(VoiceWakeupReceiver.EXTRA_STATE)).instantiate(fragmentManager.x0(), classLoader);
                    fragmentInstantiate.mSavedFragmentState = bundleB;
                    if (bundleB.getBundle("savedInstanceState") == null) {
                        fragmentInstantiate.mSavedFragmentState.putBundle("savedInstanceState", new Bundle());
                    }
                    Bundle bundle = bundleB.getBundle("arguments");
                    if (bundle != null) {
                        bundle.setClassLoader(classLoader);
                    }
                    fragmentInstantiate.setArguments(bundle);
                    map2.put(fragmentInstantiate.mWho, fragmentInstantiate);
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        Iterator<BackStackRecordState> it = this.mTransactions.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().instantiate(fragmentManager, map2));
        }
        return arrayList;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeStringList(this.mFragments);
        parcel.writeTypedList(this.mTransactions);
    }

    public BackStackState(Parcel parcel) {
        this.mFragments = parcel.createStringArrayList();
        this.mTransactions = parcel.createTypedArrayList(BackStackRecordState.CREATOR);
    }
}
