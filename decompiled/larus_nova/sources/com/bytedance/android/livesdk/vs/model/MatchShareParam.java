package com.bytedance.android.livesdk.vs.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.livesdk.chatroom.ui.VideoViewParams;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.match.CollectionItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/vs/model/MatchShareParam;", "Landroid/os/Parcelable;", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MatchShareParam implements Parcelable {
    public static final Parcelable.Creator<MatchShareParam> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f159378a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f159379b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f159380c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<CollectionItem> f159381d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public VideoViewParams f159382e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public IRoom f159383f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Episode f159384g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f159385h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f159386i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public SearchPanelParam f159387j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f159388k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public PublishParam f159389l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f159390m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public HashMap<String, String> f159391n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f159392o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final long f159393p;

    public static class a implements Parcelable.Creator<MatchShareParam> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final MatchShareParam createFromParcel(Parcel r210) {
            Intrinsics.checkNotNullParameter(r210, "in");
            String r100 = r210.readString();
            String r101 = r210.readString();
            String r102 = r210.readString();
            if (r210.readInt() == 0) goto L7;
            int r103 = r210.readInt();
            ArrayList r104 = new ArrayList(r103);
        L5:
            if (r103 == 0) goto L9;
            r104.add(CollectionItem.CREATOR.createFromParcel(r210));
            r103 = r103 - 1;
        L9:
            if (r210.readInt() == 0) goto L11;
            VideoViewParams r105 = VideoViewParams.CREATOR.createFromParcel(r210);
        L12:
            IRoom r106 = (IRoom) r210.readSerializable();
            Episode r110 = (Episode) r210.readSerializable();
            long r111 = r210.readLong();
            String r112 = r210.readString();
            if (r210.readInt() == 0) goto L15;
            SearchPanelParam r113 = SearchPanelParam.CREATOR.createFromParcel(r210);
        L16:
            int r114 = r210.readInt();
            PublishParam r115 = PublishParam.CREATOR.createFromParcel(r210);
            String r116 = r210.readString();
            int r107 = r210.readInt();
            HashMap r108 = new HashMap(r107);
        L17:
            if (r107 == 0) goto L19;
            r108.put(r210.readString(), r210.readString());
            r107 = r107 - 1;
            r114 = r114;
            goto L17
        L19:
            int r117 = r114;
            if (r210.readInt() == 0) goto L22;
            boolean r109 = true;
        L24:
            return new MatchShareParam(r100, r101, r102, r104, r105, r106, r110, r111, r112, r113, r117, r115, r116, r108, r109, r210.readLong());
        L22:
            r109 = false;
            goto L24
        L15:
            r113 = null;
            goto L16
        L11:
            r105 = null;
            goto L12
        L7:
            r104 = null;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public final MatchShareParam[] newArray(int r100) {
            return new MatchShareParam[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public MatchShareParam() {
        this(null, null, null, null, null, null, 0, null, null, null, false, 0, 65535);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof MatchShareParam) == false) goto L38;
        MatchShareParam r101 = (MatchShareParam) r100;
        if (Intrinsics.areEqual(this.f159378a, r101.f159378a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f159379b, r101.f159379b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f159380c, r101.f159380c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f159381d, r101.f159381d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f159382e, r101.f159382e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f159383f, r101.f159383f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f159384g, r101.f159384g) == true) goto L20;
        return false;
    L20:
        if (this.f159385h == r101.f159385h) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f159386i, r101.f159386i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f159387j, r101.f159387j) == true) goto L26;
        return false;
    L26:
        if (this.f159388k == r101.f159388k) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f159389l, r101.f159389l) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f159390m, r101.f159390m) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.f159391n, r101.f159391n) == true) goto L34;
        return false;
    L34:
        if (this.f159392o == r101.f159392o) goto L36;
        return false;
    L36:
        if (this.f159393p == r101.f159393p) goto L58;
        return false;
    L58:
        return true;
    L38:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v30, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8 */
    public final int hashCode() {
        String r100 = this.f159378a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f159379b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f159380c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<CollectionItem> r110 = this.f159381d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        VideoViewParams r113 = this.f159382e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        IRoom r116 = this.f159383f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Episode r119 = this.f159384g;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        long r122 = this.f159385h;
        int r123 = (r121 + ((int) (r122 ^ (r122 >>> 32)))) * 31;
        String r124 = this.f159386i;
        if (r124 == null) goto L33;
        int r125 = r124.hashCode();
    L34:
        int r126 = (r123 + r125) * 31;
        SearchPanelParam r127 = this.f159387j;
        if (r127 == null) goto L37;
        int r128 = r127.hashCode();
    L38:
        int r129 = (((r126 + r128) * 31) + this.f159388k) * 31;
        PublishParam r130 = this.f159389l;
        if (r130 == null) goto L41;
        int r131 = r130.hashCode();
    L42:
        int r132 = (r129 + r131) * 31;
        String r133 = this.f159390m;
        if (r133 == null) goto L45;
        int r134 = r133.hashCode();
    L46:
        int r135 = (r132 + r134) * 31;
        HashMap<String, String> r136 = this.f159391n;
        if (r136 == null) goto L49;
        r101 = r136.hashCode();
    L49:
        int r137 = (r135 + r101) * 31;
        boolean r138 = this.f159392o;
        ?? r139 = r138;
        if (r138 == false) goto L52;
        r139 = 1;
    L52:
        int r140 = (r137 + r139) * 31;
        long r141 = this.f159393p;
        return r140 + ((int) (r141 ^ (r141 >>> 32)));
    L45:
        r134 = 0;
        goto L46
    L41:
        r131 = 0;
        goto L42
    L37:
        r128 = 0;
        goto L38
    L33:
        r125 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "MatchShareParam(enterFrom=" + this.f159378a + ", originTargetCollectionId=" + this.f159379b + ", finalShareCollectionId=" + this.f159380c + ", totalcollectionInfo=" + this.f159381d + ", videoParam=" + this.f159382e + ", room=" + this.f159383f + ", episode=" + this.f159384g + ", recordVideoDuration=" + this.f159385h + ", roomOrEpisodeId=" + this.f159386i + ", searchPanelParam=" + this.f159387j + ", currentIndex=" + this.f159388k + ", publishParam=" + this.f159389l + ", contentType=" + this.f159390m + ", shareLogParam=" + this.f159391n + ", isScreenShotShare=" + this.f159392o + ", clickTime=" + this.f159393p + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.f159378a);
        r100.writeString(this.f159379b);
        r100.writeString(this.f159380c);
        List<CollectionItem> r102 = this.f159381d;
        if (r102 == null) goto L8;
        r100.writeInt(1);
        r100.writeInt(r102.size());
        Iterator<CollectionItem> r103 = r102.iterator();
    L6:
        if (r103.hasNext() == false) goto L9;
        r103.next().writeToParcel(r100, 0);
    L9:
        VideoViewParams r104 = this.f159382e;
        if (r104 == null) goto L12;
        r100.writeInt(1);
        r104.writeToParcel(r100, 0);
    L13:
        r100.writeSerializable(this.f159383f);
        r100.writeSerializable(this.f159384g);
        r100.writeLong(this.f159385h);
        r100.writeString(this.f159386i);
        SearchPanelParam r105 = this.f159387j;
        if (r105 == null) goto L16;
        r100.writeInt(1);
        r105.writeToParcel(r100, 0);
    L17:
        r100.writeInt(this.f159388k);
        this.f159389l.writeToParcel(r100, 0);
        r100.writeString(this.f159390m);
        HashMap<String, String> r106 = this.f159391n;
        r100.writeInt(r106.size());
        Iterator<Map.Entry<String, String>> r107 = r106.entrySet().iterator();
    L19:
        if (r107.hasNext() == false) goto L21;
        Map.Entry<String, String> r108 = r107.next();
        r100.writeString(r108.getKey());
        r100.writeString(r108.getValue());
        goto L19
    L21:
        r100.writeInt(this.f159392o ? 1 : 0);
        r100.writeLong(this.f159393p);
        return;
    L16:
        r100.writeInt(0);
        goto L17
    L12:
        r100.writeInt(0);
        goto L13
    L8:
        r100.writeInt(0);
        goto L9
    }

    public /* synthetic */ MatchShareParam(String r210, String r211, String r212, List r213, VideoViewParams r214, IRoom r310, long r311, PublishParam r312, String r313, HashMap r314, boolean r315, long r316, int r317) {
        String r100 = "";
        if ((r317 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r317 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r317 & 4) == 0) goto L13;
        String r103 = "";
    L15:
        if ((r317 & 8) == 0) goto L17;
        List r104 = new ArrayList();
    L18:
        int r105 = 0;
        if ((r317 & 16) == 0) goto L21;
        VideoViewParams r106 = new VideoViewParams(0, 0, 0, 0.0f);
    L23:
        if ((r317 & 32) == 0) goto L25;
        IRoom r107 = null;
    L27:
        if ((r317 & 128) == 0) goto L29;
        long r110 = 0;
    L31:
        if ((r317 & 256) == 0) goto L33;
        String r111 = "";
    L35:
        if ((r317 & 2048) == 0) goto L37;
        PublishParam r112 = new PublishParam(r100, r100, 4, r105);
    L39:
        if ((r317 & 4096) != 0) goto L43;
        r100 = r313;
    L43:
        if ((r317 & 8192) == 0) goto L45;
        HashMap r215 = new HashMap();
    L47:
        if ((r317 & 16384) == 0) goto L49;
        boolean r216 = false;
    L51:
        if ((r317 & 32768) == 0) goto L53;
        long r217 = 0;
    L54:
        this(r101, r102, r103, r104, r106, r107, null, r110, r111, null, 0, r112, r100, r215, r216, r217);
        return;
    L53:
        r217 = r316;
        goto L54
    L49:
        r216 = r315;
        goto L51
    L45:
        r215 = r314;
        goto L47
    L37:
        r112 = r312;
        goto L39
    L33:
        r111 = null;
        goto L35
    L29:
        r110 = r311;
        goto L31
    L25:
        r107 = r310;
        goto L27
    L21:
        r106 = r214;
        goto L23
    L17:
        r104 = r213;
        goto L18
    L13:
        r103 = r212;
        goto L15
    L9:
        r102 = r211;
        goto L11
    L5:
        r101 = r210;
        goto L7
    }

    public MatchShareParam(String r100, String r101, String r102, List<CollectionItem> r110, VideoViewParams r111, IRoom r112, Episode r113, long r114, String r115, SearchPanelParam r116, int r117, PublishParam r118, String r210, HashMap<String, String> r211, boolean r212, long r213) {
        Intrinsics.checkNotNullParameter(r118, "publishParam");
        Intrinsics.checkNotNullParameter(r210, "contentType");
        Intrinsics.checkNotNullParameter(r211, "shareLogParam");
        this.f159378a = r100;
        this.f159379b = r101;
        this.f159380c = r102;
        this.f159381d = r110;
        this.f159382e = r111;
        this.f159383f = r112;
        this.f159384g = r113;
        this.f159385h = r114;
        this.f159386i = r115;
        this.f159387j = r116;
        this.f159388k = r117;
        this.f159389l = r118;
        this.f159390m = r210;
        this.f159391n = r211;
        this.f159392o = r212;
        this.f159393p = r213;
    }
}
