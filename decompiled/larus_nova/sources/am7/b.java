package am7;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.segment.Segment;
import java.util.List;
import java.util.Objects;
import org.json.JSONObject;
import zl7.l;

/* JADX INFO: loaded from: classes3.dex */
public class b {

    @SerializedName("dg")
    private a mDg;

    @SerializedName("meta")
    private C0088b mMeta;

    @SerializedName("activity")
    private List<c> mStageConfigList;

    /* JADX INFO: loaded from: classes22.dex */
    public class a {

        @SerializedName("ap")
        private int mAp;

        @SerializedName("ext")
        private JSONObject mExt;

        @SerializedName("fp")
        private int mFeed;

        @SerializedName("f2_hb")
        private int mFireworks;

        @SerializedName("f2_yh")
        private int mRedpacket;

        public final String toString() {
            String r100 = "f2_hb: " + this.mFireworks + " f2_yh: " + this.mRedpacket + " fp: " + this.mFeed + " ap: " + this.mAp;
            if (this.mExt != null) goto L5;
            return r100;
        L5:
            return r100 + " ext: " + this.mExt;
        }

        public final int a() {
            return this.mAp;
        }

        public final void b(JSONObject r100) {
            this.mExt = r100;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof a) == true) goto L5;
            return false;
        L5:
            a r101 = (a) r100;
            if (r101 != null) goto L9;
            return false;
        L9:
            if (r101.mFireworks == this.mFireworks) goto L13;
            return false;
        L13:
            if (r101.mRedpacket == this.mRedpacket) goto L17;
            return false;
        L17:
            if (r101.mFeed == this.mFeed) goto L21;
            return false;
        L21:
            if (r101.mAp != this.mAp) goto L23;
            JSONObject r102 = this.mExt;
            if (r102 == null) goto L27;
        L29:
            if (r102 != null) goto L31;
        L32:
            if (r102 != null) goto L38;
            if (r101.mExt == null) goto L38;
        L36:
            return false;
        L38:
            if (l.c(r102.toString(), r101.mExt.toString()) == true) goto L41;
            Objects.toString(this.mExt);
            Objects.toString(r101.mExt);
            return false;
        L41:
            return true;
        L31:
            if (r101.mExt == null) goto L36;
        L27:
            if (r101.mExt != null) goto L29;
            return true;
        L23:
            return false;
        }
    }

    /* JADX INFO: renamed from: am7.b$b, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes22.dex */
    public class C0088b {

        @SerializedName("polling_interval")
        private int mPollingInterval;

        @SerializedName("version")
        private int mVersion;

        public final String toString() {
            return "polling_interval: " + this.mPollingInterval + " version: " + this.mVersion;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof C0088b) == true) goto L5;
            return false;
        L5:
            C0088b r101 = (C0088b) r100;
            if (r101 != null) goto L9;
            return false;
        L9:
            if (r101.mPollingInterval == this.mPollingInterval) goto L13;
            return false;
        L13:
            if (r101.mVersion != this.mVersion) goto L15;
            return true;
        L15:
            return false;
        }
    }

    /* JADX INFO: loaded from: classes22.dex */
    public class c {

        @SerializedName("bk")
        private int mBk;

        @SerializedName("cid")
        private int mCid;

        @SerializedName("et")
        private long mEndTime;

        @SerializedName("et_pp")
        private long mEndTimePp;

        @SerializedName("ext")
        private JSONObject mExt;

        @SerializedName("f2")
        private String mF2;

        @SerializedName("fp")
        private int mFp;

        @SerializedName(com.alipay.sdk.m.s.a.f25763u)
        private String mStageName;

        @SerializedName(Segment.JsonKey.START)
        private long mStartTime;

        @SerializedName("st_pp")
        private long mStartTimePp;

        public final String toString() {
            String r100 = "an: " + this.mStageName + " cid: " + this.mCid + " st: " + this.mStartTime + " et: " + this.mEndTime + " st_pp: " + this.mStartTimePp + " et_pp: " + this.mEndTimePp + " fp: " + this.mFp + " bk: " + this.mBk + " f2: " + this.mF2;
            if (this.mExt != null) goto L5;
            return r100;
        L5:
            return r100 + " ext: " + this.mExt;
        }

        public final int a() {
            return this.mBk;
        }

        public final int b() {
            return this.mCid;
        }

        public final long c() {
            return this.mEndTime;
        }

        public final long d() {
            return this.mEndTimePp;
        }

        public final JSONObject e() {
            return this.mExt;
        }

        public final String f() {
            return this.mStageName;
        }

        public final long g() {
            return this.mStartTime;
        }

        public final long h() {
            return this.mStartTimePp;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof c) == true) goto L5;
            return false;
        L5:
            c r101 = (c) r100;
            if (r101 != null) goto L9;
            return false;
        L9:
            if (TextUtils.equals(r101.mStageName, this.mStageName) == true) goto L13;
            return false;
        L13:
            if (TextUtils.equals(r101.mF2, this.mF2) == true) goto L17;
            return false;
        L17:
            if (r101.mCid == this.mCid) goto L21;
            return false;
        L21:
            if (r101.mStartTime == this.mStartTime) goto L25;
            return false;
        L25:
            if (r101.mEndTime == this.mEndTime) goto L29;
            return false;
        L29:
            if (r101.mStartTimePp == this.mStartTimePp) goto L33;
            return false;
        L33:
            if (r101.mEndTimePp == this.mEndTimePp) goto L37;
            return false;
        L37:
            if (r101.mFp == this.mFp) goto L41;
            return false;
        L41:
            if (r101.mBk != this.mBk) goto L43;
            JSONObject r102 = this.mExt;
            if (r102 == null) goto L47;
        L49:
            if (r102 != null) goto L51;
        L52:
            if (r102 != null) goto L58;
            if (r101.mExt == null) goto L58;
        L56:
            return false;
        L58:
            if (l.c(r102.toString(), r101.mExt.toString()) == true) goto L61;
            Objects.toString(this.mExt);
            Objects.toString(r101.mExt);
            return false;
        L61:
            return true;
        L51:
            if (r101.mExt == null) goto L56;
        L47:
            if (r101.mExt != null) goto L49;
            return true;
        L43:
            return false;
        }

        public final void i(JSONObject r100) {
            this.mExt = r100;
        }
    }

    public b() {
    }

    public final List<c> a() {
        return this.mStageConfigList;
    }

    public final a b() {
        return this.mDg;
    }

    public final List<c> c() {
        return this.mStageConfigList;
    }

    public final void d(a r100) {
        this.mDg = r100;
    }

    public final boolean equals(Object r100) {
        boolean r101 = false;
        if ((r100 instanceof b) == true) goto L5;
        return false;
    L5:
        b r102 = (b) r100;
        if (r102 != null) goto L9;
        return false;
    L9:
        if (this.mDg.equals(r102.mDg) == false) goto L40;
        if (this.mMeta.equals(r102.mMeta) == false) goto L40;
        List<c> r103 = this.mStageConfigList;
        List<c> r104 = r102.mStageConfigList;
        if (r103 != null) goto L16;
        if (r104 != null) goto L16;
    L36:
        boolean r105 = true;
    L37:
        if (r105 == false) goto L40;
        r101 = true;
    L16:
        if (r103 == null) goto L18;
        if (r104 != null) goto L18;
    L34:
        r105 = false;
    L18:
        if (r103 != null) goto L22;
        if (r104 != null) goto L34;
    L22:
        if (r103.size() == r104.size()) goto L24;
        r103.size();
        r104.size();
        goto L34
    L24:
        int r106 = r103.size();
        int r107 = 0;
    L25:
        if (r107 >= r106) goto L36;
        int r108 = 0;
    L27:
        if (r108 >= r106) goto L32;
        c r109 = (c) ListProtector.get(r103, r107);
        Object r110 = ListProtector.get(r104, r108);
        r109.getClass();
        if (r109.equals(r110) == true) goto L30;
        r108 = r108 + 1;
        goto L27
    L30:
        boolean r111 = true;
    L33:
        if (r111 == false) goto L34;
        r107 = r107 + 1;
        goto L25
    L32:
        r111 = false;
    L40:
        return r101;
    }
}
