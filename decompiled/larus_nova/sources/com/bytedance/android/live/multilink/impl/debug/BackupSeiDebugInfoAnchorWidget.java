package com.bytedance.android.live.multilink.impl.debug;

import android.widget.TextView;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.liveinteract.linkpanel.util.o;
import com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget;
import com.bytedance.android.livesdk.message.model.BackupSeiMessage;
import com.bytedance.android.livesdk.message.model.BackupSeiModel;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.google.gson.reflect.TypeToken;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import vlc.d;
import vlc.l;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/multilink/impl/debug/BackupSeiDebugInfoAnchorWidget;", "Lcom/bytedance/android/live/liveinteract/linkpanel/widget/PlatformMultiLinkWidget;", "Lvlc/l;", "<init>", "()V", "multilink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class BackupSeiDebugInfoAnchorWidget extends PlatformMultiLinkWidget implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f83413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f83414b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f83415c;

    public static final class a<T> implements Comparator<T> {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Long.valueOf(((BackupSeiModel) r100).getPts()), Long.valueOf(((BackupSeiModel) r101).getPts()));
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/bytedance/android/live/multilink/impl/debug/BackupSeiDebugInfoAnchorWidget$b", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/bytedance/android/livesdk/message/model/BackupSeiModel;", "multilink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class b extends TypeToken<List<? extends BackupSeiModel>> {
        public b() {
        }
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_view_backup_sei_anchor_debug_info;
    }

    @Override // com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final int getScene() {
        return o.c();
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget, com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget, com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onCreate() {
        super.onCreate();
        this.f83414b = (TextView) this.containerView.findViewById(R.id.tv_livecore_pts);
        this.f83415c = (TextView) this.containerView.findViewById(R.id.tv_backup_msg_hit_rate);
        d r100 = (d) this.dataCenter.get("data_message_manager");
        this.f83413a = r100;
        if (r100 == null) goto L7;
        if (r100 == null) goto L8;
        r100.addMessageListener(MessageType.BACKUP_SEI_MESSAGE.getIntType(), this);
        return;
    L8:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget, com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onDestroy() {
        super.onDestroy();
        d r100 = this.f83413a;
        if (r100 == null) goto L6;
        r100.removeMessageListener(this);
        return;
    }

    public BackupSeiDebugInfoAnchorWidget() {
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        if ((r100 instanceof BackupSeiMessage) == false) goto L23;
        List r101 = new ArrayList();
        r101 = (List) GsonHelper.getDefault().fromJson(((BackupSeiMessage) r100).getBackupSeiListStr(), new b().getType());     // Catch: Exception -> L7
    L9:
        List r102 = CollectionsKt.sortedWith(r101, new a());
        BackupSeiModel r103 = (BackupSeiModel) CollectionsKt.firstOrNull(r102);
        long r104 = -1;
        if (r103 == null) goto L12;
        long r105 = r103.getPts();
    L13:
        BackupSeiModel r106 = (BackupSeiModel) CollectionsKt.lastOrNull(r102);
        if (r106 == null) goto L16;
        r104 = r106.getPts();
    L16:
        int r107 = r102.size();
        TextView r108 = this.f83415c;
        if (r108 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("backupMsgHitRate");
    L19:
        r108.setText("backupMsg: \n  listSize = " + r107 + "\n  msgPtsRange = [" + r105 + ", " + r104 + ']');
        return;
    L12:
        r105 = -1;
    L7:
        e = move-exception;
        ((BackupSeiMessage) r100).getBackupSeiListStr();
        e.toString();
        goto L9
    }
}
