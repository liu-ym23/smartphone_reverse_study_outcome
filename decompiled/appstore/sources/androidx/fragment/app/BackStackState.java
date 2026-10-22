package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.bytedance.common.wschannel.WsConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = null;
    final List<String> mFragments;
    final List<BackStackRecordState> mTransactions;

    public class a implements Parcelable.Creator {
        public a() {
        }

        public BackStackState a(Parcel r10) {
            return new BackStackState(r10);
        }

        public BackStackState[] b(int r10) {
            return new BackStackState[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r10) {
            return a(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object[] newArray(int r10) {
            return b(r10);
        }
    }

    static {
        CREATOR = new a();
    }

    public BackStackState(List<String> r10, List<BackStackRecordState> r11) {
        this.mFragments = r10;
        this.mTransactions = r11;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NonNull
    public List<androidx.fragment.app.a> instantiate(@NonNull FragmentManager r10, Map<String, Fragment> r11) {
        HashMap r12 = new HashMap(this.mFragments.size());
        Iterator<String> r13 = this.mFragments.iterator();
    L4:
        if (r13.hasNext() == false) goto L17;
        String r14 = r13.next();
        Fragment r15 = r11.get(r14);
        if (r15 != null) goto L7;
        Bundle r16 = r10.w0().B(r14, null);
        if (r16 == null) goto L4;
        ClassLoader r17 = r10.y0().e().getClassLoader();
        Fragment r18 = ((FragmentState) r16.getParcelable(WsConstants.KEY_CONNECTION_STATE)).instantiate(r10.v0(), r17);
        r18.mSavedFragmentState = r16;
        if (r16.getBundle("savedInstanceState") != null) goto L13;
        r18.mSavedFragmentState.putBundle("savedInstanceState", new Bundle());
    L13:
        Bundle r19 = r16.getBundle("arguments");
        if (r19 == null) goto L16;
        r19.setClassLoader(r17);
    L16:
        r18.setArguments(r19);
        r12.put(r18.mWho, r18);
        goto L4
    L7:
        r12.put(r15.mWho, r15);
        goto L4
    L17:
        ArrayList r110 = new ArrayList();
        Iterator<BackStackRecordState> r20 = this.mTransactions.iterator();
    L19:
        if (r20.hasNext() == false) goto L21;
        r110.add(r20.next().instantiate(r10, r12));
        goto L19
    L21:
        return r110;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel r10, int r11) {
        r10.writeStringList(this.mFragments);
        r10.writeTypedList(this.mTransactions);
    }

    public BackStackState(@NonNull Parcel r10) {
        this.mFragments = r10.createStringArrayList();
        this.mTransactions = r10.createTypedArrayList(BackStackRecordState.CREATOR);
    }
}
