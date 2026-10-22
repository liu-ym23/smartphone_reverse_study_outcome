package com.bytedance.android.livesdk.ktvimpl.base.controlnode;

import android.content.Context;
import android.graphics.Rect;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.karaokestation.model.g;
import com.bytedance.android.live.ktv.common.model.bean.DownloadResourceType;
import com.bytedance.android.live.ktv.common.music.download.KtvMusicManager;
import com.bytedance.android.live.ktv.common.music.download.m;
import com.bytedance.android.live.ktv.common.music.download.p;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.live.ktv.common.util.i;
import com.bytedance.android.live.multilink.ktv.SongUniqueInfo;
import com.bytedance.android.livesdk.chatroom.u;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.efffectselect.EffectMusicSelectDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.KtvComponentOrderSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.KtvModeOrderSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.OrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.util.e;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.api.KtvComponentApi;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.previewsongs.KtvPreviewSongsViewHolder;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.WantListenInfo;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.ModeType;
import com.bytedance.live.datacontext.j;
import com.bytedance.livesdk.ktvcommon.download.model.DownloadPriority;
import com.bytedance.livesdk.ktvcommon.download.model.l;
import com.larus.nova.R;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mb0.f;
import vm2.h;

/* JADX INFO: loaded from: classes10.dex */
public final class AddMusicControlNode extends com.bytedance.android.live.ktv.common.music.control.b {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f142465q = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Map<String, Long> f142466l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map<String, Long> f142467m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final b f142468n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final c f142469o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final RecyclerView.ViewHolder f142470p;

    public static final class a {
    }

    public static final class b implements p.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AddMusicControlNode f142471a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MusicPanel f142472b;

        public b(AddMusicControlNode r100, MusicPanel r101) {
            this.f142471a = r100;
            this.f142472b = r101;
        }

        @Override // com.bytedance.android.live.ktv.common.music.download.p.a
        public final void c(MusicPanel r100, int r101) {
            if (r100 != null) goto L4;
            return;
        L4:
            r100.f153578b = 2;
            r100.f153595s = r101;
            this.f142471a.j(1, r100);
            i.a(r100.f153577a.getMId(), r101);
        }

        @Override // com.bytedance.android.live.ktv.common.music.download.p.a
        public final void a(MusicPanel r100, String r101, String r102) {
            if (r100 != null) goto L4;
            return;
        L4:
            pd2.d.f528658n.getClass();
            pd2.d.B("choose_download_success", r100, null);
            int r103 = f.f512760a;
            f.i(this.f142472b);
            AddMusicControlNode.l(this.f142471a, r100);
            i.a(r100.f153577a.getMId(), 100);
            Long r104 = KtvLoggerHelper.f142994a;
            KtvLoggerHelper.O(r100, "1", AddMusicControlNode.k(this.f142471a, r100));
        }

        @Override // com.bytedance.android.live.ktv.common.music.download.p.a
        public final void b(MusicPanel r100, int r101, String r102) {
            if (r100 != null) goto L4;
            return;
        L4:
            r100.f153595s = 0;
            pd2.d r103 = pd2.d.f528658n;
            HashMap r104 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("err_code", String.valueOf(r101))});
            r103.getClass();
            pd2.d.B("choose_download_fail", r100, r104);
            int r105 = f.f512760a;
            MusicPanel r106 = this.f142472b;
            if (r102 != null) goto L7;
            String r107 = "";
        L8:
            f.h(r106, r101, r107);
            Function1<String, Boolean> r108 = KtvMusicManager.f70041j;
            if (r102 != null) goto L12;
            r102 = "";
        L12:
            if (r108.invoke(r102).booleanValue() == false) goto L14;
            f2.b(R.string.ttlive_ktv_order_song_failed, 0);
        L15:
            this.f142471a.g(r100);
            i.a(r100.f153577a.getMId(), -1);
            Long r109 = KtvLoggerHelper.f142994a;
            KtvLoggerHelper.O(r100, "0", AddMusicControlNode.k(this.f142471a, r100));
            return;
        L14:
            f2.b(R.string.ttlive_ktv_download_failed, 0);
            goto L15
        L7:
            r107 = r102;
            goto L8
        }
    }

    public static final class c implements p.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AddMusicControlNode f142473a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MusicPanel f142474b;

        public c(AddMusicControlNode r100, MusicPanel r101) {
            this.f142473a = r100;
            this.f142474b = r101;
        }

        @Override // com.bytedance.android.live.ktv.common.music.download.p.a
        public final void c(MusicPanel r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "panel");
            r100.f153578b = 2;
            r100.f153595s = r101;
            this.f142473a.j(1, r100);
            i.a(r100.f153577a.getMId(), r101);
        }

        @Override // com.bytedance.android.live.ktv.common.music.download.p.a
        public final void a(MusicPanel r110, String r111, String r112) {
            if (r110 != null) goto L4;
            return;
        L4:
            Long r113 = (Long) ((LinkedHashMap) this.f142473a.f142466l).get(String.valueOf(r110.f153577a.getId()));
            long r100 = 0;
            if (r113 == null) goto L7;
            long r114 = r113.longValue();
        L8:
            Object r101 = null;
            if (r114 != 0) goto L98;
            ALogger.i("ktv_music_resource_download_opt_tag", "repeat main_resource success callback ;; songName == " + r110.f153577a.getMTitle() + ' ');
            KtvComponentOrderSongDataContext.Companion.getClass();
            KtvComponentOrderSongDataContext r115 = KtvComponentOrderSongDataContext.Companion.d();
            if (r115 == null) goto L15;
            j<com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d> r116 = r115.m8248getBusinessOrderSongViewModel();
            if (r116 == null) goto L15;
            com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r117 = r116.getValue();
        L16:
            KtvModeOrderSongDataContext.Companion.getClass();
            KtvModeOrderSongDataContext r118 = KtvModeOrderSongDataContext.Companion.d();
            if (r118 == null) goto L21;
            j<com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d> r119 = r118.m8252getBusinessOrderSongViewModel();
            if (r119 == null) goto L21;
            com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r120 = r119.getValue();
        L22:
            EffectMusicSelectDataContext.Companion.getClass();
            EffectMusicSelectDataContext r102 = EffectMusicSelectDataContext.Companion.d();
            if (r102 == null) goto L27;
            j<com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d> r103 = r102.m8244getBusinessOrderSongViewModel();
            if (r103 == null) goto L27;
            com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r104 = r103.getValue();
        L28:
            if (r117 == null) goto L51;
            OrderedSongDataContext r121 = r117.getOrderedSongDataContext();
            if (r121 == null) goto L45;
            List<SongUniqueInfo> r122 = r121.m8258getKtvSongUniqueInfoList();
            if (r122 == null) goto L45;
            Iterator<T> r123 = r122.iterator();
        L35:
            if (r123.hasNext() == false) goto L44;
            Object r105 = r123.next();
            SongUniqueInfo r106 = (SongUniqueInfo) r105;
            if (r106.getSongId() == r110.c()) goto L39;
        L41:
            boolean r107 = false;
        L42:
            if (r107 == false) goto L35;
            r101 = r105;
            goto L44
        L39:
            if (Intrinsics.areEqual(r106.getUserId(), r110.f153577a.getOrderUserIdString()) == false) goto L41;
            r107 = true;
        L44:
            r101 = (SongUniqueInfo) r101;
        L45:
            if (r101 == null) goto L47;
            return;
        L47:
            if (KtvUtilsKt.m(r110) == true) goto L49;
            return;
        L49:
            if (r117.inSelfDownloadMusicById(r110.f153577a.getMIdStr()) == false) goto L128;
            AddMusicControlNode.l(this.f142473a, r110);
            r117.deleteSelfDownloadMusicById(r110.f153577a.getMIdStr());
            return;
        L128:
            return;
        L51:
            if (r120 == null) goto L74;
            OrderedSongDataContext r124 = r120.getOrderedSongDataContext();
            if (r124 == null) goto L68;
            List<SongUniqueInfo> r125 = r124.m8258getKtvSongUniqueInfoList();
            if (r125 == null) goto L68;
            Iterator<T> r126 = r125.iterator();
        L58:
            if (r126.hasNext() == false) goto L67;
            Object r108 = r126.next();
            SongUniqueInfo r109 = (SongUniqueInfo) r108;
            if (r109.getSongId() == r110.c()) goto L62;
        L64:
            boolean r127 = false;
        L65:
            if (r127 == false) goto L58;
            r101 = r108;
            goto L67
        L62:
            if (Intrinsics.areEqual(r109.getUserId(), r110.f153577a.getOrderUserIdString()) == false) goto L64;
            r127 = true;
        L67:
            r101 = (SongUniqueInfo) r101;
        L68:
            if (r101 == null) goto L70;
            return;
        L70:
            if (KtvUtilsKt.m(r110) == true) goto L72;
            return;
        L72:
            if (r120.inSelfDownloadMusicById(r110.f153577a.getMIdStr()) == false) goto L132;
            AddMusicControlNode.l(this.f142473a, r110);
            r120.deleteSelfDownloadMusicById(r110.f153577a.getMIdStr());
            return;
        L132:
            return;
        L74:
            if (r104 == null) goto L134;
            OrderedSongDataContext r128 = r104.getOrderedSongDataContext();
            if (r128 == null) goto L91;
            List<SongUniqueInfo> r129 = r128.m8258getKtvSongUniqueInfoList();
            if (r129 == null) goto L91;
            Iterator<T> r130 = r129.iterator();
        L81:
            if (r130.hasNext() == false) goto L90;
            Object r131 = r130.next();
            SongUniqueInfo r132 = (SongUniqueInfo) r131;
            if (r132.getSongId() == r110.c()) goto L85;
        L87:
            boolean r133 = false;
        L88:
            if (r133 == false) goto L81;
            r101 = r131;
            goto L90
        L85:
            if (Intrinsics.areEqual(r132.getUserId(), r110.f153577a.getOrderUserIdString()) == false) goto L87;
            r133 = true;
        L90:
            r101 = (SongUniqueInfo) r101;
        L91:
            if (r101 == null) goto L93;
            return;
        L93:
            if (KtvUtilsKt.m(r110) == true) goto L95;
            return;
        L95:
            if (r104.inSelfDownloadMusicById(r110.f153577a.getMIdStr()) == false) goto L137;
            AddMusicControlNode.l(this.f142473a, r110);
            r104.deleteSelfDownloadMusicById(r110.f153577a.getMIdStr());
            return;
        L137:
            return;
        L134:
            return;
        L27:
            r104 = null;
        L21:
            r120 = null;
        L15:
            r117 = null;
            goto L16
        L98:
            pd2.d.f528658n.getClass();
            pd2.d.B("choose_download_success", r110, null);
            int r134 = f.f512760a;
            f.i(this.f142474b);
            AddMusicControlNode.l(this.f142473a, r110);
            i.a(r110.f153577a.getMId(), 100);
            Long r135 = KtvLoggerHelper.f142994a;
            KtvLoggerHelper.O(r110, "1", AddMusicControlNode.k(this.f142473a, r110));
            StringBuilder r136 = new StringBuilder("main_resource download success duration == ");
            long r137 = System.currentTimeMillis();
            Long r138 = (Long) ((LinkedHashMap) this.f142473a.f142466l).get(String.valueOf(r110.f153577a.getId()));
            if (r138 == null) goto L101;
            long r139 = r138.longValue();
        L102:
            r136.append(r137 - r139);
            r136.append(" ;; songName == ");
            r136.append(r110.f153577a.getMTitle());
            ALogger.i("ktv_music_resource_download_opt_tag", r136.toString());
            this.f142473a.f142466l.remove(String.valueOf(r110.f153577a.getId()));
            this.f142473a.f142467m.put(String.valueOf(r110.f153577a.getId()), Long.valueOf(System.currentTimeMillis()));
            if (KtvUtilsKt.E(r110) == true) goto L109;
            StringBuilder r140 = new StringBuilder("other_resource not need download duration == ");
            long r141 = System.currentTimeMillis();
            Long r142 = (Long) ((LinkedHashMap) this.f142473a.f142467m).get(String.valueOf(r110.f153577a.getId()));
            if (r142 == null) goto L107;
            r100 = r142.longValue();
        L107:
            r140.append(r141 - r100);
            r140.append(" ;; songName == ");
            r140.append(r110.f153577a.getMTitle());
            ALogger.i("ktv_music_resource_download_opt_tag", r140.toString());
            AddMusicControlNode r143 = this.f142473a;
            com.bytedance.android.live.ktv.common.model.bean.f r144 = new com.bytedance.android.live.ktv.common.model.bean.f(DownloadResourceType.OTHER_RESOURCE, false);
            r143.getClass();
            AddMusicControlNode.n(r110, r144);
            this.f142473a.f142467m.remove(String.valueOf(r110.f153577a.getId()));
            return;
        L109:
            AddMusicControlNode r145 = this.f142473a;
            com.bytedance.android.live.ktv.common.model.bean.f r146 = new com.bytedance.android.live.ktv.common.model.bean.f(DownloadResourceType.OTHER_RESOURCE, true);
            r145.getClass();
            AddMusicControlNode.n(r110, r146);
            AddMusicControlNode r147 = this.f142473a;
            r147.getClass();
            KtvMusicManager.e(KtvMusicManager.f70044m, r110, new com.bytedance.android.livesdk.ktvimpl.base.controlnode.c(r147), false, null, false, 28);
            return;
        L101:
            r139 = 0;
            goto L102
        L7:
            r114 = 0;
            goto L8
        }

        @Override // com.bytedance.android.live.ktv.common.music.download.p.a
        public final void b(MusicPanel r100, int r101, String r102) {
            Intrinsics.checkNotNullParameter(r102, "errorMsg");
            if (r100 != null) goto L5;
            return;
        L5:
            r100.f153595s = 0;
            pd2.d r103 = pd2.d.f528658n;
            HashMap r104 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("err_code", String.valueOf(r101))});
            r103.getClass();
            pd2.d.B("choose_download_fail", r100, r104);
            int r105 = f.f512760a;
            f.h(this.f142474b, r101, r102);
            if (KtvMusicManager.f70041j.invoke(r102).booleanValue() == false) goto L8;
            f2.b(R.string.ttlive_ktv_order_song_failed, 0);
        L9:
            this.f142473a.g(r100);
            i.a(r100.f153577a.getMId(), -1);
            Long r106 = KtvLoggerHelper.f142994a;
            KtvLoggerHelper.O(r100, "0", AddMusicControlNode.k(this.f142473a, r100));
            StringBuilder r107 = new StringBuilder("main_resource download fail duration == ");
            long r108 = System.currentTimeMillis();
            Long r109 = (Long) ((LinkedHashMap) this.f142473a.f142466l).get(String.valueOf(r100.f153577a.getId()));
            if (r109 == null) goto L12;
            long r110 = r109.longValue();
        L13:
            r107.append(r108 - r110);
            r107.append(" ;; songName == ");
            r107.append(r100.f153577a.getMTitle());
            ALogger.i("ktv_music_resource_download_opt_tag", r107.toString());
            AddMusicControlNode r111 = this.f142473a;
            com.bytedance.android.live.ktv.common.model.bean.f r112 = new com.bytedance.android.live.ktv.common.model.bean.f(DownloadResourceType.OTHER_RESOURCE, false);
            r111.getClass();
            AddMusicControlNode.n(r100, r112);
            this.f142473a.f142466l.remove(String.valueOf(r100.f153577a.getId()));
            this.f142473a.f142467m.remove(String.valueOf(r100.f153577a.getId()));
            return;
        L12:
            r110 = 0;
            goto L13
        L8:
            f2.b(R.string.ttlive_ktv_download_failed, 0);
            goto L9
        }
    }

    public static final class d implements rj0.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AddMusicControlNode f142475a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MusicPanel f142476b;

        @Override // rj0.b
        public final void onSuccess() {
            this.f142475a.m(this.f142476b);
        }

        @Override // rj0.b
        public final void onFailed(Exception r100) {
            ALogger.i(bb0.b.b(), "selectMultiKtvMusicPanel checkPermision fail, invoke class :".concat(d.class.getSimpleName()));
            AddMusicControlNode r101 = this.f142475a;
            MusicPanel r102 = this.f142476b;
            int r103 = AddMusicControlNode.f142465q;
            r101.g(r102);
            pd2.d.f528658n.b("choose_check_permission_fail", this.f142476b, null);
        }

        public d(AddMusicControlNode r100, MusicPanel r101) {
            this.f142475a = r100;
            this.f142476b = r101;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.ktv.common.music.control.d, com.bytedance.android.live.ktv.common.music.control.IMusicControlNode
    public final void a() {
        super.a();
        KtvContext.Companion.getClass();
        KtvContext.a.g().getMusicDownloadResourceMap().setValue(new LinkedHashMap());
    }

    @Override // com.bytedance.android.live.ktv.common.music.control.d
    public final void d() {
        super.d();
        pd2.d r100 = pd2.d.f528658n;
        MusicPanel r101 = this.f70024d;
        r100.getClass();
        pd2.d.s(r101, pd2.d.f528653i);
    }

    @Override // com.bytedance.android.live.ktv.common.music.control.b
    public final void f(MusicPanel r110) {
        Intrinsics.checkNotNullParameter(r110, "panel");
        boolean r100 = true;
        if (h.a() == false) goto L13;
        b r101 = this.f142468n;
        r110.f153595s = 0;
        r110.f153578b = 2;
        j(1, r110);
        boolean r102 = com.bytedance.android.livesdk.ktvimpl.base.util.KtvUtilsKt.a(r110, true);
        n(r110, new com.bytedance.android.live.ktv.common.model.bean.f(DownloadResourceType.MAIN_RESOURCE, true));
        com.bytedance.android.livesdk.ktvimpl.base.controlnode.b r103 = new com.bytedance.android.livesdk.ktvimpl.base.controlnode.b(this, r110, r101);
        com.bytedance.livesdk.ktvimpl.base.download.a r104 = com.bytedance.livesdk.ktvimpl.base.download.a.f256305c;
        KtvMusic r105 = r110.f153577a;
        if (this.f70025e == ModeType.MUSIC_EFFECT) goto L8;
        r100 = false;
    L8:
        l r106 = new l(r102, r100, 60);
        DownloadPriority r107 = DownloadPriority.NORMAL;
        r104.getClass();
        com.bytedance.livesdk.ktvimpl.base.download.a.c(r105, r106, r103, r107, "AddMusicNode");
        if (h.o() == false) goto L11;
        pd2.d.f528658n.getClass();
        pd2.d.f528656l.f("download", new pd2.b(r110, null));
        return;
    L11:
        pd2.d.f528658n.getClass();
        pd2.d.t("download", r110, null);
        return;
    L13:
        r110.f153578b = 2;
        j(1, r110);
        this.f142466l.put(String.valueOf(r110.f153577a.getId()), Long.valueOf(System.currentTimeMillis()));
        boolean r108 = com.bytedance.android.livesdk.ktvimpl.base.util.KtvUtilsKt.a(r110, true);
        n(r110, new com.bytedance.android.live.ktv.common.model.bean.f(DownloadResourceType.MAIN_RESOURCE, true));
        if (this.f70025e != ModeType.MUSIC_EFFECT) goto L16;
        KtvMusicManager.e(KtvMusicManager.f70044m, r110, this.f142469o, false, null, false, 28);
    L18:
        if (h.o() == false) goto L20;
        pd2.d.f528658n.getClass();
        pd2.d.f528656l.f("download", new pd2.b(r110, null));
        return;
    L20:
        pd2.d.f528658n.getClass();
        pd2.d.t("download", r110, null);
        return;
    L16:
        KtvMusicManager.e(KtvMusicManager.f70044m, r110, this.f142469o, false, new m(r108, !r108, 57), false, 20);
        goto L18
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.ktv.common.music.control.b
    public final void i(MusicPanel r100) {
        Intrinsics.checkNotNullParameter(r100, "panel");
        if (getContext() != null) goto L5;
    L28:
        ALogger.i(bb0.b.b(), "selectMultiKtvMusicPanel fail, context or room is null, invoke class :".concat(AddMusicControlNode.class.getSimpleName()));
        g(r100);
        pd2.d r101 = pd2.d.f528658n;
        MusicPanel r102 = this.f70024d;
        r101.getClass();
        pd2.d.s(r102, pd2.d.f528654j);
        return;
    L5:
        if (this.f70016k == null) goto L28;
        if (com.bytedance.android.live.ktv.common.util.j.i() == true) goto L26;
        Integer r103 = (Integer) hd0.c.f().f481009b;
        if (r103 == null) goto L26;
        if (r103.intValue() != 0) goto L26;
        IRoom r104 = this.f70016k;
        if (r104 != null) goto L18;
        return;
    L18:
        KtvContext.Companion.getClass();
        KtvContext r105 = KtvContext.a.g();
        if (r105 == null) goto L23;
        com.bytedance.live.datacontext.m<e> r106 = r105.getKtvRoomStrategy();
        if (r106 == null) goto L23;
        e r107 = r106.getValue();
    L24:
        if (r107 == null) goto L30;
        Context r108 = getContext();
        Intrinsics.checkNotNull(r108);
        r107.checkPermision(r108, r104, new d(this, r100));
        return;
    L30:
        return;
    L23:
        r107 = null;
    L26:
        m(r100);
    }

    public final void m(final MusicPanel r210) {
        Intrinsics.checkNotNullParameter(r210, "panel");
        if (this.f70016k == null) goto L68;
        String r100 = this.f70014i;
        boolean r101 = true;
        if (r100 != null) goto L7;
    L10:
        boolean r102 = true;
    L11:
        if (r102 == true) goto L68;
        long r103 = System.currentTimeMillis();
        String r104 = bb0.b.b();
        ALogger.i(r104, ("addMusic, panel=" + r210) + ", invoke class :" + AddMusicControlNode.class.getSimpleName());
        Long r105 = null;
        Disposable r106 = null;
        r106 = null;
        r106 = null;
        if (this.f70025e != ModeType.MUSIC_EFFECT) goto L29;
        int r107 = rd2.a.f537206a;
        rd2.a r108 = rd2.a.b.f537207a;
        IRoom r109 = this.f70016k;
        if (r109 == null) goto L18;
        Long r110 = Long.valueOf(r109.getId());
    L19:
        long r111 = r110.longValue();
        long r112 = r210.c();
        Function1<com.bytedance.android.live.network.response.e<Object>, Unit> r113 = new AddMusicControlNode$addMusic$1(this, r210);
        Function1<Throwable, Unit> r114 = new AddMusicControlNode$addMusic$2(this, r210);
        r108.getClass();
        Intrinsics.checkNotNullParameter(r113, "successCallBack");
        Intrinsics.checkNotNullParameter(r114, "failCallBack");
        KtvComponentApi r115 = (KtvComponentApi) com.bytedance.android.live.network.c.b().e(KtvComponentApi.class);
        if (r115 == null) goto L26;
        Observable<com.bytedance.android.live.network.response.e<Object>> r116 = r115.chooseSong(r111, r112, 7);
        if (r116 == null) goto L26;
        Observable<R> r117 = r116.compose(RxUtil.rxSchedulerHelper());
        if (r117 == 0) goto L26;
        r106 = r117.subscribe(new rd2.d(r103, r113), new rd2.e(r103, r114));
    L26:
        if (r106 == null) goto L70;
        RxUtilKt.c(r106, this.f70021a);
        return;
    L70:
        return;
    L18:
        r110 = null;
        goto L19
    L29:
        String r118 = com.bytedance.android.live.ktv.common.util.a.b(r210.f153577a);
        u r119 = com.bytedance.android.live.liveinteract.api.utils.m.d();
        if (r119 == null) goto L32;
        String r120 = r119.w();
    L33:
        r210.f153583g = r120;
        int r121 = g.f69505a;
        g r122 = g.b.f69506a;
        IRoom r123 = this.f70016k;
        if (r123 == null) goto L36;
        Long r124 = Long.valueOf(r123.getId());
    L37:
        long r125 = r124.longValue();
        IRoom r126 = this.f70016k;
        if (r126 == null) goto L40;
        r105 = Long.valueOf(r126.getId());
    L40:
        long r127 = r105.longValue();
        long r128 = r210.f153577a.getMId();
        int r129 = r210.f153577a.getSongType();
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L49;
        WantListenInfo r130 = r210.f153577a.getWantListenInfo();
        if (r130 == null) goto L45;
        long r131 = r130.getWantListenCount().longValue();
    L47:
        if (r131 <= 0) goto L49;
    L50:
        if (r101 == false) goto L54;
        String r132 = "permit_want_to_listen";
    L52:
        String r133 = r132;
    L64:
        Disposable r134 = r122.b(r103, r125, r127, r128, r129, r133, r210.b(), r118, null, new AddMusicControlNode$addMusic$3(this, r210), new AddMusicControlNode$addMusic$4(this, r210));
        if (r134 == null) goto L71;
        RxUtilKt.c(r134, this.f70021a);
        return;
    L71:
        return;
    L54:
        if (r2.a(r210.f153601y) == false) goto L59;
        if (r2.a(r210.f153602z) == false) goto L59;
        r132 = "search";
    L59:
        if (Intrinsics.areEqual(r210.f153580d, "冷启推荐") == false) goto L61;
        r133 = "冷启推荐";
        goto L64
    L61:
        r132 = this.f70014i;
        if (r132 != null) goto L52;
        r132 = "";
        goto L52
    L45:
        r131 = 0;
    L49:
        r101 = false;
        goto L50
    L36:
        r124 = null;
        goto L37
    L32:
        r120 = null;
        goto L33
    L7:
        if (r100.length() == 0) goto L10;
        r102 = false;
    L68:
        ALogger.i(bb0.b.b(), "selectMultiKtvMusicPanel fail, songSource or room is null, invoke class :".concat(AddMusicControlNode.class.getSimpleName()));
        g(r210);
        pd2.d r135 = pd2.d.f528658n;
        MusicPanel r136 = this.f70024d;
        r135.getClass();
        pd2.d.s(r136, pd2.d.f528654j);
    }

    public static final long k(AddMusicControlNode r100, MusicPanel r101) {
        r100.getClass();
        long r102 = System.currentTimeMillis();
        Map<String, Long> r103 = r100.f142466l;
        LinkedHashMap r104 = (LinkedHashMap) r103;
        Long r105 = (Long) r104.get(String.valueOf(r101.f153577a.getId()));
        if (r105 == null) goto L5;
        long r106 = r105.longValue();
    L7:
        return r102 - r106;
    L5:
        r106 = 0;
        goto L7
    }

    public static final void l(AddMusicControlNode r100, MusicPanel r101) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "panel");
        r100.i(r101);
    }

    public static void n(MusicPanel r100, com.bytedance.android.live.ktv.common.model.bean.f r101) {
        KtvContext.Companion.getClass();
        Map<String, com.bytedance.android.live.ktv.common.model.bean.f> r102 = KtvContext.a.g().getMusicDownloadResourceMap().getValue();
        r102.put(com.bytedance.android.livesdk.ktvimpl.base.util.KtvUtilsKt.c(r100), r101);
        ALogger.i("ktv_music_resource_download_opt_tag", r101.toString());
        KtvContext.a.g().getMusicDownloadResourceMap().setValue(r102);
    }

    @Override // com.bytedance.android.live.ktv.common.music.control.b
    public final void j(int r100, MusicPanel r101) {
        Intrinsics.checkNotNullParameter(r101, "panel");
        Object r102 = this.f142470p;
        if ((r102 instanceof KtvPreviewSongsViewHolder) == false) goto L18;
        if (((KtvPreviewSongsViewHolder) r102).f145241d == r101.f153577a.getMId()) goto L8;
        return;
    L8:
        if (r100 != 0) goto L10;
        KtvPreviewSongsViewHolder r103 = (KtvPreviewSongsViewHolder) this.f142470p;
        r103.f145240c.setText(s1.B(R.string.ttlive_ktv_tab_selected));
        r103.f145240c.setClickable(false);
        return;
    L10:
        if (r100 != 1) goto L12;
        KtvPreviewSongsViewHolder r104 = (KtvPreviewSongsViewHolder) this.f142470p;
        r104.f145240c.setText(s1.C(R.string.ttlive_ktv_download_progress, new Object[]{Integer.valueOf(r101.f153595s)}));
        r104.f145240c.setClickable(false);
        return;
    L12:
        if (r100 != 2) goto L27;
        ((KtvPreviewSongsViewHolder) this.f142470p).T3();
        return;
    L27:
        return;
    L18:
        if ((r102 instanceof com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.f) == false) goto L26;
        if (r100 != 0) goto L21;
        Rect r105 = ((com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.f) r102).J3();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        r101.f153598v = r105;
        String r106 = "toggleSelected true:" + r101.f153577a.getMTitle() + ", state = " + r101.f153578b + ", progress = " + r101.f153595s;
        ALogger.i(bb0.b.b(), r106 + ", invoke class :" + AddMusicControlNode.class.getSimpleName());
    L21:
        ((com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.f) this.f142470p).v0(r101);
        return;
    }

    public AddMusicControlNode(MusicPanel r100, RecyclerView.ViewHolder r101, ModeType r102) {
        Intrinsics.checkNotNullParameter(r100, "musicPanel");
        Intrinsics.checkNotNullParameter(r102, "modeType");
        super(r100, r102);
        this.f142470p = r101;
        this.f142466l = new LinkedHashMap();
        this.f142467m = new LinkedHashMap();
        this.f142468n = new b(this, r100);
        this.f142469o = new c(this, r100);
    }

    public /* synthetic */ AddMusicControlNode(MusicPanel r100, KtvPreviewSongsViewHolder r101, int r102) {
        ModeType r103 = null;
        if ((r102 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r102 & 4) == 0) goto L8;
        r103 = ModeType.KTV_MODE;
    L8:
        this(r100, r101, r103);
    }
}
