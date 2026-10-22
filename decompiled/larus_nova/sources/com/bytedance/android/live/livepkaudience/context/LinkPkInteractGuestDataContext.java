package com.bytedance.android.live.livepkaudience.context;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.model.RoomLinkerContent;
import com.bytedance.android.live.liveinteract.service.f;
import com.bytedance.android.live.livepkaudience.service.c;
import com.bytedance.android.livesdk.chatroom.interact.model.LinkInviteResult;
import com.bytedance.android.livesdk.chatroom.model.interact.LinkReplyResult;
import com.bytedance.android.livesdk.message.model.Cif;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerInviteContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerReplyContent;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import ey.d;
import ey.g;
import ey.l;
import fy.e;
import fy.j;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001D\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010H\u001a\u00020G¢\u0006\u0004\bL\u0010MJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0005H\u0016J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010H\u0016J\u0012\u0010\u0012\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0016J\u0011\u0010\u0013\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u0006\u0010\u0017\u001a\u00020\u0005J\u0006\u0010\u0018\u001a\u00020\u0003J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001b\u001a\u00020\nH\u0016J\u0006\u0010\u001c\u001a\u00020\nR\u0016\u0010\u001d\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u001eR\u0016\u0010 \u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010\u001eR\u0016\u0010\u0017\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u001eR\u0016\u0010!\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R$\u0010&\u001a\u0010\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010(\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010\"R\u0016\u0010)\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010\"R\u0016\u0010\u000e\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u001eR!\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00030*8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R!\u00102\u001a\b\u0012\u0004\u0012\u00020$0*8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b0\u0010,\u001a\u0004\b1\u0010.R!\u00105\u001a\b\u0012\u0004\u0012\u00020$0*8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b3\u0010,\u001a\u0004\b4\u0010.R!\u00108\u001a\b\u0012\u0004\u0012\u00020\u00030*8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b6\u0010,\u001a\u0004\b7\u0010.R!\u0010;\u001a\b\u0012\u0004\u0012\u00020$0*8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b9\u0010,\u001a\u0004\b:\u0010.R\u0016\u0010=\u001a\u00020<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010@\u001a\u0004\u0018\u00010?8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u001c\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00050\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0014\u0010E\u001a\u00020D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0017\u0010H\u001a\u00020G8\u0006¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K¨\u0006N"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/context/LinkPkInteractGuestDataContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/android/live/livepkaudience/service/c;", "", "isLinkWithAudience", "", "getSelfAnchorLinkMicId", "getGuestAnchorLinkMicId", "getAudienceSelfLinkMicId", "linkId", "", "setSelfAnchorLinkMicId", "src", "setGuestAnchorLinkMicId", "gameExtra", "setGameData", "Landroidx/lifecycle/MutableLiveData;", "getGuestLynxListData", "setAudienceSelfLinkMicId", "hasAudienceJoinSelfAnchorLink", "()Ljava/lang/Boolean;", "Lcom/bytedance/android/live/pkaudience/api/d;", "getPkAudienceLogData", "kickedUsersUniqueId", "getSelfHasAudienceBeforePk", "Lcom/bytedance/android/live/livepkaudience/service/g;", "getPkInteractAudienceParams", "resetLinkData", "resetLogData", "audienceLinkMicId", "Ljava/lang/String;", "linkMicId", "guestLinkMicId", "mySelfHasAudience", "Z", "", "", "Lcom/bytedance/android/live/liveinteract/plantform/model/RoomLinkerContent;", "linkerContentMap", "Ljava/util/Map;", "inviterWithAudience", "inviteeWithAudience", "Lcom/bytedance/live/datacontext/m;", "hasAudienceJoin4Pk$delegate", "Lcom/bytedance/live/datacontext/p;", "getHasAudienceJoin4Pk", "()Lcom/bytedance/live/datacontext/m;", "hasAudienceJoin4Pk", "hasAudienceOnlineTime4Pk$delegate", "getHasAudienceOnlineTime4Pk", "hasAudienceOnlineTime4Pk", "hasAudienceOnlineTime$delegate", "getHasAudienceOnlineTime", "hasAudienceOnlineTime", "hasAudienceJoin4Penalty$delegate", "getHasAudienceJoin4Penalty", "hasAudienceJoin4Penalty", "hasAudienceOnlineTime4Penalty$delegate", "getHasAudienceOnlineTime4Penalty", "hasAudienceOnlineTime4Penalty", "Lio/reactivex/disposables/CompositeDisposable;", "cd", "Lio/reactivex/disposables/CompositeDisposable;", "Ley/g;", "connectService", "Ley/g;", "linkGuestLynxData", "Landroidx/lifecycle/MutableLiveData;", "com/bytedance/android/live/livepkaudience/context/LinkPkInteractGuestDataContext$b", "linkListener", "Lcom/bytedance/android/live/livepkaudience/context/LinkPkInteractGuestDataContext$b;", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "getDataCenter", "()Lcom/bytedance/ies/sdk/widgets/DataCenter;", "<init>", "(Lcom/bytedance/ies/sdk/widgets/DataCenter;)V", "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkPkInteractGuestDataContext extends DataContext implements c {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private String audienceLinkMicId;

    /* JADX INFO: renamed from: cd, reason: collision with root package name */
    private CompositeDisposable f81575cd;
    private final g connectService;
    private final DataCenter dataCenter;
    private String gameExtra;
    private String guestLinkMicId;
    private final p hasAudienceJoin4Penalty$delegate;
    private final p hasAudienceJoin4Pk$delegate;
    private final p hasAudienceOnlineTime$delegate;
    private final p hasAudienceOnlineTime4Penalty$delegate;
    private final p hasAudienceOnlineTime4Pk$delegate;
    private boolean inviteeWithAudience;
    private boolean inviterWithAudience;
    private String kickedUsersUniqueId;
    private MutableLiveData<String> linkGuestLynxData;
    private final b linkListener;
    private String linkMicId;
    private Map<Long, ? extends RoomLinkerContent> linkerContentMap;
    private boolean mySelfHasAudience;

    public static final class a implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LinkPkInteractGuestDataContext f81576a;

        public a(LinkPkInteractGuestDataContext r100) {
            this.f81576a = r100;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            g r100 = LinkPkInteractGuestDataContext.access$getConnectService$p(this.f81576a);
            if (r100 == null) goto L6;
            r100.a(1, LinkPkInteractGuestDataContext.access$getLinkListener$p(this.f81576a));
            r100.a(7, LinkPkInteractGuestDataContext.access$getLinkListener$p(this.f81576a));
            return;
        }
    }

    public static final class b extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LinkPkInteractGuestDataContext f81577a;

        public b(LinkPkInteractGuestDataContext r100) {
            this.f81577a = r100;
        }

        @Override // ey.d, ey.j
        public final void P5(Cif r100) {
            Intrinsics.checkNotNullParameter(r100, "linkerMessage");
            Intrinsics.checkNotNullParameter(r100, "linkerMessage");
            LinkPkInteractGuestDataContext r101 = this.f81577a;
            LinkPkInteractGuestDataContext.access$setMySelfHasAudience$p(r101, LinkPkInteractGuestDataContext.access$isLinkWithAudience(r101));
            LinkPkInteractGuestDataContext r102 = this.f81577a;
            LinkerInviteContent r103 = r100.mInvite;
            if (r103 == null) goto L5;
            boolean r104 = r103.getInviterWithAudience();
        L6:
            LinkPkInteractGuestDataContext.access$setInviterWithAudience$p(r102, r104);
            return;
        L5:
            r104 = false;
            goto L6
        }

        @Override // ey.d, ey.j
        public final void qe(Cif r100) {
            Intrinsics.checkNotNullParameter(r100, "linkerMessage");
            Intrinsics.checkNotNullParameter(r100, "linkerMessage");
            LinkerReplyContent r101 = r100.mReply;
            Map<Long, ? extends RoomLinkerContent> r102 = null;
            if (r101 == null) goto L5;
            Integer r103 = Integer.valueOf(r101.replyStatus);
        L6:
            if (r103 != null) goto L9;
            return;
        L9:
            if (r103.intValue() != 1) goto L20;
            LinkPkInteractGuestDataContext r104 = this.f81577a;
            LinkerReplyContent r105 = r100.mReply;
            if (r105 == null) goto L14;
            String r106 = r105.kickedUsersniqueId;
            if (r106 == null) goto L14;
        L15:
            LinkPkInteractGuestDataContext.access$setKickedUsersUniqueId$p(r104, r106);
            LinkPkInteractGuestDataContext r107 = this.f81577a;
            LinkerReplyContent r108 = r100.mReply;
            if (r108 == null) goto L18;
            r102 = r108.linkerContentMap;
        L18:
            LinkPkInteractGuestDataContext.access$setLinkerContentMap$p(r107, r102);
            return;
        L14:
            r106 = "";
            goto L15
        L20:
            return;
        L5:
            r103 = null;
            goto L6
        }

        @Override // ey.d, ey.j
        public final void Ah(j r100, LinkReplyResult r101, long r102) {
            Intrinsics.checkNotNullParameter(r100, "params");
            Intrinsics.checkNotNullParameter(r101, "replyResult");
            super.Ah(r100, r101, r102);
            if (r100.f479226d != 1) goto L10;
            LinkPkInteractGuestDataContext r103 = this.f81577a;
            String r104 = r101.getKickedUsersniqueId();
            if (r104 != null) goto L8;
            r104 = "";
        L8:
            LinkPkInteractGuestDataContext.access$setKickedUsersUniqueId$p(r103, r104);
            LinkPkInteractGuestDataContext.access$setLinkerContentMap$p(this.f81577a, r101.getMLinkerContentMap());
            return;
        }

        @Override // ey.d, ey.j
        public final void zm(e r100, long r101, LinkInviteResult r102, l r103) {
            Intrinsics.checkNotNullParameter(r100, "params");
            Intrinsics.checkNotNullParameter(r102, "inviteResult");
            super.zm(r100, r101, r102, r103);
            LinkPkInteractGuestDataContext r104 = this.f81577a;
            LinkPkInteractGuestDataContext.access$setMySelfHasAudience$p(r104, LinkPkInteractGuestDataContext.access$isLinkWithAudience(r104));
            LinkPkInteractGuestDataContext.access$setInviteeWithAudience$p(this.f81577a, r102.getInviteeWithAudience());
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(LinkPkInteractGuestDataContext.class, "hasAudienceJoin4Pk", "getHasAudienceJoin4Pk()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(LinkPkInteractGuestDataContext.class, "hasAudienceOnlineTime4Pk", "getHasAudienceOnlineTime4Pk()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(LinkPkInteractGuestDataContext.class, "hasAudienceOnlineTime", "getHasAudienceOnlineTime()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(LinkPkInteractGuestDataContext.class, "hasAudienceJoin4Penalty", "getHasAudienceJoin4Penalty()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(LinkPkInteractGuestDataContext.class, "hasAudienceOnlineTime4Penalty", "getHasAudienceOnlineTime4Penalty()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
    }

    public final m<Boolean> getHasAudienceJoin4Penalty() {
        return (m) this.hasAudienceJoin4Penalty$delegate.a(this, $$delegatedProperties[3]);
    }

    public final m<Boolean> getHasAudienceJoin4Pk() {
        return (m) this.hasAudienceJoin4Pk$delegate.a(this, $$delegatedProperties[0]);
    }

    public final m<Long> getHasAudienceOnlineTime() {
        return (m) this.hasAudienceOnlineTime$delegate.a(this, $$delegatedProperties[2]);
    }

    public final m<Long> getHasAudienceOnlineTime4Penalty() {
        return (m) this.hasAudienceOnlineTime4Penalty$delegate.a(this, $$delegatedProperties[4]);
    }

    public final m<Long> getHasAudienceOnlineTime4Pk() {
        return (m) this.hasAudienceOnlineTime4Pk$delegate.a(this, $$delegatedProperties[1]);
    }

    @Override // com.bytedance.android.live.livepkaudience.service.c
    public void resetLinkData() {
        this.linkerContentMap = null;
        this.kickedUsersUniqueId = "";
        this.inviterWithAudience = false;
        this.inviteeWithAudience = false;
    }

    private final boolean isLinkWithAudience() {
        if (((f) ((IInteractService) k.n(IInteractService.class)).getInteractAudienceService()).P() == false) goto L5;
    L8:
        return true;
    L5:
        if (((IInteractService) k.n(IInteractService.class)).getVideoTalkService().t() > 0) goto L8;
        return false;
    }

    @Override // com.bytedance.android.live.livepkaudience.service.c
    public com.bytedance.android.live.pkaudience.api.d getPkAudienceLogData() {
        return new com.bytedance.android.live.pkaudience.api.d(getHasAudienceJoin4Pk().getValue().booleanValue(), getHasAudienceOnlineTime4Pk().getValue().longValue(), getHasAudienceOnlineTime().getValue().longValue(), getHasAudienceJoin4Penalty().getValue().booleanValue(), getHasAudienceOnlineTime4Penalty().getValue().longValue());
    }

    public com.bytedance.android.live.livepkaudience.service.g getPkInteractAudienceParams() {
        return new com.bytedance.android.live.livepkaudience.service.g(this.linkerContentMap, this.inviterWithAudience, this.inviteeWithAudience);
    }

    @Override // com.bytedance.android.live.livepkaudience.service.c
    public Boolean hasAudienceJoinSelfAnchorLink() {
        return (Boolean) this.dataCenter.get("cmd_what_audience_join_self_link", Boolean.FALSE);
    }

    public final void resetLogData() {
        m<Boolean> r100 = getHasAudienceJoin4Pk();
        Boolean r101 = Boolean.FALSE;
        r100.setValue(r101);
        getHasAudienceOnlineTime4Pk().setValue(0L);
        getHasAudienceJoin4Penalty().setValue(r101);
        getHasAudienceOnlineTime4Penalty().setValue(0L);
        getHasAudienceOnlineTime().setValue(0L);
    }

    @Override // com.bytedance.android.live.livepkaudience.service.c
    public String getAudienceSelfLinkMicId() {
        return this.audienceLinkMicId;
    }

    public final DataCenter getDataCenter() {
        return this.dataCenter;
    }

    @Override // com.bytedance.android.live.livepkaudience.service.c
    public String getGuestAnchorLinkMicId() {
        return this.guestLinkMicId;
    }

    @Override // com.bytedance.android.live.livepkaudience.service.c
    public MutableLiveData<String> getGuestLynxListData() {
        return this.linkGuestLynxData;
    }

    @Override // com.bytedance.android.live.livepkaudience.service.c
    public String getSelfAnchorLinkMicId() {
        return this.linkMicId;
    }

    public final boolean getSelfHasAudienceBeforePk() {
        return this.mySelfHasAudience;
    }

    public final String kickedUsersUniqueId() {
        return this.kickedUsersUniqueId;
    }

    public LinkPkInteractGuestDataContext(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        this.dataCenter = r100;
        this.audienceLinkMicId = "";
        this.linkMicId = "";
        this.guestLinkMicId = "";
        this.kickedUsersUniqueId = "";
        this.gameExtra = "";
        Boolean r101 = Boolean.FALSE;
        this.hasAudienceJoin4Pk$delegate = q.d(this, r101);
        this.hasAudienceOnlineTime4Pk$delegate = q.d(this, 0L);
        this.hasAudienceOnlineTime$delegate = q.d(this, 0L);
        this.hasAudienceJoin4Penalty$delegate = q.d(this, r101);
        this.hasAudienceOnlineTime4Penalty$delegate = q.d(this, 0L);
        this.f81575cd = new CompositeDisposable();
        g.f474778a.getClass();
        nc0.b r102 = g.a.a();
        this.connectService = r102;
        this.linkGuestLynxData = new MutableLiveData();
        b r103 = new b(this);
        this.linkListener = r103;
        RxUtilKt.c(getOnCleared().subscribe(new a(this)), this.f81575cd);
        if (r102 == null) goto L6;
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        Intrinsics.checkNotNullParameter(r102.f518605d.linkOutManager(), "real");
        r102.b(1, r103);
        r102.b(7, r103);
        return;
    }

    public static final /* synthetic */ g access$getConnectService$p(LinkPkInteractGuestDataContext r100) {
        return r100.connectService;
    }

    public static final /* synthetic */ boolean access$getInviteeWithAudience$p(LinkPkInteractGuestDataContext r100) {
        return r100.inviteeWithAudience;
    }

    public static final /* synthetic */ boolean access$getInviterWithAudience$p(LinkPkInteractGuestDataContext r100) {
        return r100.inviterWithAudience;
    }

    public static final /* synthetic */ String access$getKickedUsersUniqueId$p(LinkPkInteractGuestDataContext r100) {
        return r100.kickedUsersUniqueId;
    }

    public static final /* synthetic */ b access$getLinkListener$p(LinkPkInteractGuestDataContext r100) {
        return r100.linkListener;
    }

    public static final /* synthetic */ Map access$getLinkerContentMap$p(LinkPkInteractGuestDataContext r100) {
        return r100.linkerContentMap;
    }

    public static final /* synthetic */ boolean access$getMySelfHasAudience$p(LinkPkInteractGuestDataContext r100) {
        return r100.mySelfHasAudience;
    }

    public static final /* synthetic */ boolean access$isLinkWithAudience(LinkPkInteractGuestDataContext r100) {
        return r100.isLinkWithAudience();
    }

    @Override // com.bytedance.android.live.livepkaudience.service.c
    public void setAudienceSelfLinkMicId(String r100) {
        if (r100 != null) goto L4;
        r100 = "";
    L4:
        this.audienceLinkMicId = r100;
    }

    @Override // com.bytedance.android.live.livepkaudience.service.c
    public void setGameData(String r100) {
        Intrinsics.checkNotNullParameter(r100, "gameExtra");
        this.gameExtra = r100;
    }

    @Override // com.bytedance.android.live.livepkaudience.service.c
    public void setSelfAnchorLinkMicId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "linkId");
        this.linkMicId = r100;
    }

    public static final /* synthetic */ void access$setInviteeWithAudience$p(LinkPkInteractGuestDataContext r100, boolean r101) {
        r100.inviteeWithAudience = r101;
    }

    public static final /* synthetic */ void access$setInviterWithAudience$p(LinkPkInteractGuestDataContext r100, boolean r101) {
        r100.inviterWithAudience = r101;
    }

    public static final /* synthetic */ void access$setKickedUsersUniqueId$p(LinkPkInteractGuestDataContext r100, String r101) {
        r100.kickedUsersUniqueId = r101;
    }

    public static final /* synthetic */ void access$setLinkerContentMap$p(LinkPkInteractGuestDataContext r100, Map r101) {
        r100.linkerContentMap = r101;
    }

    public static final /* synthetic */ void access$setMySelfHasAudience$p(LinkPkInteractGuestDataContext r100, boolean r101) {
        r100.mySelfHasAudience = r101;
    }

    @Override // com.bytedance.android.live.livepkaudience.service.c
    public void setGuestAnchorLinkMicId(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "linkId");
        Intrinsics.checkNotNullParameter(r101, "src");
        ALogger.i("LinkPkInteract", "LinkPkInteractGuestDataContext setGuestAnchorLinkMicId linkId = " + r100 + ", src = " + r101);
        this.guestLinkMicId = r100;
    }
}
