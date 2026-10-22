package com.obric.capabilitykit.entity.app;

import android.os.Parcel;
import com.obric.capabilitykit.entity.memory.CollectContentMemoryEntity;
import com.obric.capabilitykit.entity.memory.CollectStoreMemoryEntity;
import com.obric.capabilitykit.entity.memory.CommonTextMemoryEntity;
import com.obric.capabilitykit.entity.memory.EventScheduleMemoryEntity;
import com.obric.capabilitykit.entity.memory.EventTodoMemoryEntity;
import com.obric.capabilitykit.entity.memory.InfoAddressMemoryEntity;
import com.obric.capabilitykit.entity.memory.InfoAnniversaryMemoryEntity;
import com.obric.capabilitykit.entity.memory.InfoCommonMemoryEntity;
import com.obric.capabilitykit.entity.memory.InfoDocumentsMemoryEntity;
import com.obric.capabilitykit.entity.memory.InfoRelationshipMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderCommonMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderFlightMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderHotelMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderMovieTicketMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderTicketMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderTrainMemoryEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class EntityType {
    public static final int ALARM = 701;
    public static final int ALBUM = 302;
    public static final int APP_INFO = 1701;
    public static final int AUDITORY_RECORDING = 502;
    public static final int BROWSER_BOOKMARK = 902;
    public static final int CALENDAR_EVENT = 403;
    public static final int CALL_HISTORY = 202;
    public static final int CLOUD_DOCUMENT = 1001;
    public static final int CONTACT = 201;
    public static final int COUNTDOWN = 702;
    public static final int DOUBAO_ACCOUNT = 1301;
    public static final int EVENT_TASK = 1601;
    public static final int FILE = 801;
    public static final int GROUP_CHAT = 203;
    public static final int ICALENDAR_PROTOCOL = 402;
    public static final int IM_CONTACT = 1201;
    public static final EntityType INSTANCE = null;
    public static final int INVALIDATE_ENTITY_TYPE = -1;
    public static final int LIFE_LOG = 1401;
    public static final int MEMORY_COLLECT_CONTENT = 10201;
    public static final int MEMORY_COLLECT_STORE = 10202;
    public static final int MEMORY_COMMON_TEXT = 10401;
    public static final int MEMORY_EVENT_SCHEDULE = 10301;
    public static final int MEMORY_EVENT_TODO = 10302;
    public static final int MEMORY_INFO_ADDRESS = 10102;
    public static final int MEMORY_INFO_ANNIVERSARY = 10103;
    public static final int MEMORY_INFO_COMMON = 10105;
    public static final int MEMORY_INFO_DOCUMENTS = 10101;
    public static final int MEMORY_INFO_RELATIONSHIP = 10104;
    public static final int MEMORY_ORDER_COMMON = 10005;
    public static final int MEMORY_ORDER_FLIGHT = 10001;
    public static final int MEMORY_ORDER_HOTEL = 10004;
    public static final int MEMORY_ORDER_MOVIE_TICKET = 10003;
    public static final int MEMORY_ORDER_TICKET = 10006;
    public static final int MEMORY_ORDER_TRAIN = 10002;
    public static final int MESSAGE = 101;
    public static final int MUSIC = 1801;
    public static final int NOTE = 601;
    public static final int PHOTO = 301;
    public static final int PHOTO_FACE = 303;
    public static final int PROACTIVE_MEMORY = 20001;
    public static final int RECORDING = 501;
    public static final int SCHEDULE = 401;
    public static final int SIM_CARD = 204;
    public static final int STOCK = 1101;
    public static final int USER_PROFILE = 1501;
    public static final int WEBSITE = 901;
    private static final Map<Integer, EntityClassData<? extends AppEntity>> classMap = null;

    public static final class a extends d.h.b.p implements d.h.a.b<Parcel, AlarmEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f32091a = null;

        static {
            f32091a = new a();
        }

        public a() {
            super(1);
        }

        public final AlarmEntity a(Parcel r1) {
            d.h.b.o.e(r1, "parcel");
            return new AlarmEntity(r1);
        }

        @Override // d.h.a.b
        public /* synthetic */ AlarmEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.aiagent.plugin"));
        }
    }

    public static final class aa extends d.h.b.p implements d.h.a.b<Parcel, OrderMovieTicketMemoryEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final aa f32092a = null;

        static {
            f32092a = new aa();
        }

        public aa() {
            super(1);
        }

        public final OrderMovieTicketMemoryEntity a(Parcel r1) {
            d.h.b.o.e(r1, "parcel");
            return new OrderMovieTicketMemoryEntity(r1);
        }

        @Override // d.h.a.b
        public /* synthetic */ OrderMovieTicketMemoryEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.aiagent.plugin"));
        }
    }

    public static final class ab extends d.h.b.p implements d.h.a.b<Parcel, AlbumEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ab f32093a = null;

        static {
            f32093a = new ab();
        }

        public ab() {
            super(1);
        }

        public final AlbumEntity a(Parcel r1) {
            d.h.b.o.e(r1, "parcel");
            return new AlbumEntity(r1);
        }

        @Override // d.h.a.b
        public /* synthetic */ AlbumEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.aiagent.plugin"));
        }
    }

    public static final class ac extends d.h.b.p implements d.h.a.b<Parcel, OrderTicketMemoryEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ac f32094a = null;

        static {
            f32094a = new ac();
        }

        public ac() {
            super(1);
        }

        public final OrderTicketMemoryEntity a(Parcel r1) {
            d.h.b.o.e(r1, "parcel");
            return new OrderTicketMemoryEntity(r1);
        }

        @Override // d.h.a.b
        public /* synthetic */ OrderTicketMemoryEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.aiagent.plugin"));
        }
    }

    public static final class ad extends d.h.b.p implements d.h.a.b<Parcel, ScheduleEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ad f32095a = null;

        static {
            f32095a = new ad();
        }

        public ad() {
            super(1);
        }

        public final ScheduleEntity a(Parcel r1) {
            d.h.b.o.e(r1, "parcel");
            return new ScheduleEntity(r1);
        }

        @Override // d.h.a.b
        public /* synthetic */ ScheduleEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.aiagent.plugin"));
        }
    }

    public static final class ae extends d.h.b.p implements d.h.a.b<Parcel, OrderHotelMemoryEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ae f32096a = null;

        static {
            f32096a = new ae();
        }

        public ae() {
            super(1);
        }

        public final OrderHotelMemoryEntity a(Parcel r1) {
            d.h.b.o.e(r1, "parcel");
            return new OrderHotelMemoryEntity(r1);
        }

        @Override // d.h.a.b
        public /* synthetic */ OrderHotelMemoryEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.aiagent.plugin"));
        }
    }

    public static final class af extends d.h.b.p implements d.h.a.b<Parcel, RecordingEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final af f32097a = null;

        static {
            f32097a = new af();
        }

        public af() {
            super(1);
        }

        public final RecordingEntity a(Parcel r1) {
            d.h.b.o.e(r1, "parcel");
            return new RecordingEntity(r1);
        }

        @Override // d.h.a.b
        public /* synthetic */ RecordingEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.aiagent.plugin"));
        }
    }

    public static final class ag extends d.h.b.p implements d.h.a.b<Parcel, OrderCommonMemoryEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ag f32098a = null;

        static {
            f32098a = new ag();
        }

        public ag() {
            super(1);
        }

        public final OrderCommonMemoryEntity a(Parcel r1) {
            d.h.b.o.e(r1, "parcel");
            return new OrderCommonMemoryEntity(r1);
        }

        @Override // d.h.a.b
        public /* synthetic */ OrderCommonMemoryEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.aiagent.plugin"));
        }
    }

    public static final class ah extends d.h.b.p implements d.h.a.b<Parcel, NoteEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ah f32099a = null;

        static {
            f32099a = new ah();
        }

        public ah() {
            super(1);
        }

        public final NoteEntity a(Parcel r1) {
            d.h.b.o.e(r1, "parcel");
            return new NoteEntity(r1);
        }

        @Override // d.h.a.b
        public /* synthetic */ NoteEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.aiagent.plugin"));
        }
    }

    public static final class ai extends d.h.b.p implements d.h.a.b<Parcel, InfoDocumentsMemoryEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ai f32100a = null;

        static {
            f32100a = new ai();
        }

        public ai() {
            super(1);
        }

        public final InfoDocumentsMemoryEntity a(Parcel r1) {
            d.h.b.o.e(r1, "parcel");
            return new InfoDocumentsMemoryEntity(r1);
        }

        @Override // d.h.a.b
        public /* synthetic */ InfoDocumentsMemoryEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.aiagent.plugin"));
        }
    }

    public static final class aj extends d.h.b.p implements d.h.a.b<Parcel, InfoAddressMemoryEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final aj f32101a = null;

        static {
            f32101a = new aj();
        }

        public aj() {
            super(1);
        }

        public final InfoAddressMemoryEntity a(Parcel r1) {
            d.h.b.o.e(r1, "parcel");
            return new InfoAddressMemoryEntity(r1);
        }

        @Override // d.h.a.b
        public /* synthetic */ InfoAddressMemoryEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.aiagent.plugin"));
        }
    }

    public static final class ak extends d.h.b.p implements d.h.a.b<Parcel, InfoAnniversaryMemoryEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ak f32102a = null;

        static {
            f32102a = new ak();
        }

        public ak() {
            super(1);
        }

        public final InfoAnniversaryMemoryEntity a(Parcel r1) {
            d.h.b.o.e(r1, "parcel");
            return new InfoAnniversaryMemoryEntity(r1);
        }

        @Override // d.h.a.b
        public /* synthetic */ InfoAnniversaryMemoryEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.aiagent.plugin"));
        }
    }

    public static final class al extends d.h.b.p implements d.h.a.b<Parcel, InfoRelationshipMemoryEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final al f32103a = null;

        static {
            f32103a = new al();
        }

        public al() {
            super(1);
        }

        public final InfoRelationshipMemoryEntity a(Parcel r1) {
            d.h.b.o.e(r1, "parcel");
            return new InfoRelationshipMemoryEntity(r1);
        }

        @Override // d.h.a.b
        public /* synthetic */ InfoRelationshipMemoryEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.aiagent.plugin"));
        }
    }

    public static final class am extends d.h.b.p implements d.h.a.b<Parcel, ContactEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final am f32104a = null;

        static {
            f32104a = new am();
        }

        public am() {
            super(1);
        }

        public final ContactEntity a(Parcel r1) {
            d.h.b.o.e(r1, "parcel");
            return new ContactEntity(r1);
        }

        @Override // d.h.a.b
        public /* synthetic */ ContactEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.aiagent.plugin"));
        }
    }

    public static final class an extends d.h.b.p implements d.h.a.b<Parcel, InfoCommonMemoryEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final an f32105a = null;

        static {
            f32105a = new an();
        }

        public an() {
            super(1);
        }

        public final InfoCommonMemoryEntity a(Parcel r1) {
            d.h.b.o.e(r1, "parcel");
            return new InfoCommonMemoryEntity(r1);
        }

        @Override // d.h.a.b
        public /* synthetic */ InfoCommonMemoryEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.aiagent.plugin"));
        }
    }

    public static final class ao extends d.h.b.p implements d.h.a.b<Parcel, CollectContentMemoryEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ao f32106a = null;

        static {
            f32106a = new ao();
        }

        public ao() {
            super(1);
        }

        public final CollectContentMemoryEntity a(Parcel r1) {
            d.h.b.o.e(r1, "parcel");
            return new CollectContentMemoryEntity(r1);
        }

        @Override // d.h.a.b
        public /* synthetic */ CollectContentMemoryEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.aiagent.plugin"));
        }
    }

    public static final class ap extends d.h.b.p implements d.h.a.b<Parcel, CollectStoreMemoryEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ap f32107a = null;

        static {
            f32107a = new ap();
        }

        public ap() {
            super(1);
        }

        public final CollectStoreMemoryEntity a(Parcel r1) {
            d.h.b.o.e(r1, "parcel");
            return new CollectStoreMemoryEntity(r1);
        }

        @Override // d.h.a.b
        public /* synthetic */ CollectStoreMemoryEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.aiagent.plugin"));
        }
    }

    public static final class aq extends d.h.b.p implements d.h.a.b<Parcel, EventScheduleMemoryEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final aq f32108a = null;

        static {
            f32108a = new aq();
        }

        public aq() {
            super(1);
        }

        public final EventScheduleMemoryEntity a(Parcel r1) {
            d.h.b.o.e(r1, "parcel");
            return new EventScheduleMemoryEntity(r1);
        }

        @Override // d.h.a.b
        public /* synthetic */ EventScheduleMemoryEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.aiagent.plugin"));
        }
    }

    public static final class b extends d.h.b.p implements d.h.a.b<Parcel, EventTodoMemoryEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f32109a = null;

        static {
            f32109a = new b();
        }

        public b() {
            super(1);
        }

        public final EventTodoMemoryEntity a(Parcel r1) {
            d.h.b.o.e(r1, "parcel");
            return new EventTodoMemoryEntity(r1);
        }

        @Override // d.h.a.b
        public /* synthetic */ EventTodoMemoryEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.aiagent.plugin"));
        }
    }

    public static final class c extends d.h.b.p implements d.h.a.b<Parcel, CountdownEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f32110a = null;

        static {
            f32110a = new c();
        }

        public c() {
            super(1);
        }

        public final CountdownEntity a(Parcel r1) {
            d.h.b.o.e(r1, "parcel");
            return new CountdownEntity(r1);
        }

        @Override // d.h.a.b
        public /* synthetic */ CountdownEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.aiagent.plugin"));
        }
    }

    public static final class d extends d.h.b.p implements d.h.a.b<Parcel, CommonTextMemoryEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f32111a = null;

        static {
            f32111a = new d();
        }

        public d() {
            super(1);
        }

        public final CommonTextMemoryEntity a(Parcel r1) {
            d.h.b.o.e(r1, "parcel");
            return new CommonTextMemoryEntity(r1);
        }

        @Override // d.h.a.b
        public /* synthetic */ CommonTextMemoryEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.aiagent.plugin"));
        }
    }

    public static final class e extends d.h.b.p implements d.h.a.b<Parcel, FileEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f32112a = null;

        static {
            f32112a = new e();
        }

        public e() {
            super(1);
        }

        public final FileEntity a(Parcel r1) {
            d.h.b.o.e(r1, "parcel");
            return new FileEntity(r1);
        }

        @Override // d.h.a.b
        public /* synthetic */ FileEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.aiagent.plugin"));
        }
    }

    public static final class f extends d.h.b.p implements d.h.a.b<Parcel, ProactiveMemoryEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f32113a = null;

        static {
            f32113a = new f();
        }

        public f() {
            super(1);
        }

        public final ProactiveMemoryEntity a(Parcel r1) {
            d.h.b.o.e(r1, "parcel");
            return new ProactiveMemoryEntity(r1);
        }

        @Override // d.h.a.b
        public /* synthetic */ ProactiveMemoryEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.aiagent.plugin"));
        }
    }

    public static final class g extends d.h.b.p implements d.h.a.b<Parcel, WebsiteEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f32114a = null;

        static {
            f32114a = new g();
        }

        public g() {
            super(1);
        }

        public final WebsiteEntity a(Parcel r1) {
            d.h.b.o.e(r1, "parcel");
            return new WebsiteEntity(r1);
        }

        @Override // d.h.a.b
        public /* synthetic */ WebsiteEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.aiagent.plugin"));
        }
    }

    public static final class h extends d.h.b.p implements d.h.a.b<Parcel, ICSProtocolEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f32115a = null;

        static {
            f32115a = new h();
        }

        public h() {
            super(1);
        }

        public final ICSProtocolEntity a(Parcel r1) {
            d.h.b.o.e(r1, "parcel");
            return new ICSProtocolEntity(r1);
        }

        @Override // d.h.a.b
        public /* synthetic */ ICSProtocolEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.aiagent.plugin"));
        }
    }

    public static final class i extends d.h.b.p implements d.h.a.b<Parcel, BrowserBookmarkEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i f32116a = null;

        static {
            f32116a = new i();
        }

        public i() {
            super(1);
        }

        public final BrowserBookmarkEntity a(Parcel r1) {
            d.h.b.o.e(r1, "parcel");
            return new BrowserBookmarkEntity(r1);
        }

        @Override // d.h.a.b
        public /* synthetic */ BrowserBookmarkEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.aiagent.plugin"));
        }
    }

    public static final class j extends d.h.b.p implements d.h.a.b<Parcel, DoubaoAccountEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j f32117a = null;

        static {
            f32117a = new j();
        }

        public j() {
            super(1);
        }

        public final DoubaoAccountEntity a(Parcel r1) {
            d.h.b.o.e(r1, "parcel");
            return new DoubaoAccountEntity(r1);
        }

        @Override // d.h.a.b
        public /* synthetic */ DoubaoAccountEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.aiagent.plugin"));
        }
    }

    public static final class k extends d.h.b.p implements d.h.a.b<Parcel, GroupChatEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final k f32118a = null;

        static {
            f32118a = new k();
        }

        public k() {
            super(1);
        }

        public final GroupChatEntity a(Parcel r1) {
            d.h.b.o.e(r1, "parcel");
            return new GroupChatEntity(r1);
        }

        @Override // d.h.a.b
        public /* synthetic */ GroupChatEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.aiagent.plugin"));
        }
    }

    public static final class l extends d.h.b.p implements d.h.a.b<Parcel, LifeLogEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final l f32119a = null;

        static {
            f32119a = new l();
        }

        public l() {
            super(1);
        }

        public final LifeLogEntity a(Parcel r1) {
            d.h.b.o.e(r1, "parcel");
            return new LifeLogEntity(r1);
        }

        @Override // d.h.a.b
        public /* synthetic */ LifeLogEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.aiagent.plugin"));
        }
    }

    public static final class m extends d.h.b.p implements d.h.a.b<Parcel, CloudDocumentEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final m f32120a = null;

        static {
            f32120a = new m();
        }

        public m() {
            super(1);
        }

        public final CloudDocumentEntity a(Parcel r1) {
            d.h.b.o.e(r1, "parcel");
            return new CloudDocumentEntity(r1);
        }

        @Override // d.h.a.b
        public /* synthetic */ CloudDocumentEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.aiagent.plugin"));
        }
    }

    public static final class n extends d.h.b.p implements d.h.a.b<Parcel, CallHistoryEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final n f32121a = null;

        static {
            f32121a = new n();
        }

        public n() {
            super(1);
        }

        public final CallHistoryEntity a(Parcel r1) {
            d.h.b.o.e(r1, "parcel");
            return new CallHistoryEntity(r1);
        }

        @Override // d.h.a.b
        public /* synthetic */ CallHistoryEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.aiagent.plugin"));
        }
    }

    public static final class o extends d.h.b.p implements d.h.a.b<Parcel, StockEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final o f32122a = null;

        static {
            f32122a = new o();
        }

        public o() {
            super(1);
        }

        public final StockEntity a(Parcel r1) {
            d.h.b.o.e(r1, "parcel");
            return new StockEntity(r1);
        }

        @Override // d.h.a.b
        public /* synthetic */ StockEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.aiagent.plugin"));
        }
    }

    public static final class p extends d.h.b.p implements d.h.a.b<Parcel, UserProfileEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final p f32123a = null;

        static {
            f32123a = new p();
        }

        public p() {
            super(1);
        }

        public final UserProfileEntity a(Parcel r1) {
            d.h.b.o.e(r1, "parcel");
            return new UserProfileEntity(r1);
        }

        @Override // d.h.a.b
        public /* synthetic */ UserProfileEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.aiagent.plugin"));
        }
    }

    public static final class q extends d.h.b.p implements d.h.a.b<Parcel, PhotoFaceEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final q f32124a = null;

        static {
            f32124a = new q();
        }

        public q() {
            super(1);
        }

        public final PhotoFaceEntity a(Parcel r1) {
            d.h.b.o.e(r1, "parcel");
            return new PhotoFaceEntity(r1);
        }

        @Override // d.h.a.b
        public /* synthetic */ PhotoFaceEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.aiagent.plugin"));
        }
    }

    public static final class r extends d.h.b.p implements d.h.a.b<Parcel, EventTaskEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final r f32125a = null;

        static {
            f32125a = new r();
        }

        public r() {
            super(1);
        }

        public final EventTaskEntity a(Parcel r1) {
            d.h.b.o.e(r1, "parcel");
            return new EventTaskEntity(r1);
        }

        @Override // d.h.a.b
        public /* synthetic */ EventTaskEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.aiagent.plugin"));
        }
    }

    public static final class s extends d.h.b.p implements d.h.a.b<Parcel, AuditoryRecordingEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final s f32126a = null;

        static {
            f32126a = new s();
        }

        public s() {
            super(1);
        }

        public final AuditoryRecordingEntity a(Parcel r1) {
            d.h.b.o.e(r1, "parcel");
            return new AuditoryRecordingEntity(r1);
        }

        @Override // d.h.a.b
        public /* synthetic */ AuditoryRecordingEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.aiagent.plugin"));
        }
    }

    public static final class t extends d.h.b.p implements d.h.a.b<Parcel, AppInfoEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final t f32127a = null;

        static {
            f32127a = new t();
        }

        public t() {
            super(1);
        }

        public final AppInfoEntity a(Parcel r1) {
            d.h.b.o.e(r1, "parcel");
            return new AppInfoEntity(r1);
        }

        @Override // d.h.a.b
        public /* synthetic */ AppInfoEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.aiagent.plugin"));
        }
    }

    public static final class u extends d.h.b.p implements d.h.a.b<Parcel, MessageEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final u f32128a = null;

        static {
            f32128a = new u();
        }

        public u() {
            super(1);
        }

        public final MessageEntity a(Parcel r1) {
            d.h.b.o.e(r1, "parcel");
            return new MessageEntity(r1);
        }

        @Override // d.h.a.b
        public /* synthetic */ MessageEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.aiagent.plugin"));
        }
    }

    public static final class v extends d.h.b.p implements d.h.a.b<Parcel, MusicEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final v f32129a = null;

        static {
            f32129a = new v();
        }

        public v() {
            super(1);
        }

        public final MusicEntity a(Parcel r1) {
            d.h.b.o.e(r1, "parcel");
            return new MusicEntity(r1);
        }

        @Override // d.h.a.b
        public /* synthetic */ MusicEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.aiagent.plugin"));
        }
    }

    public static final class w extends d.h.b.p implements d.h.a.b<Parcel, OrderFlightMemoryEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final w f32130a = null;

        static {
            f32130a = new w();
        }

        public w() {
            super(1);
        }

        public final OrderFlightMemoryEntity a(Parcel r1) {
            d.h.b.o.e(r1, "parcel");
            return new OrderFlightMemoryEntity(r1);
        }

        @Override // d.h.a.b
        public /* synthetic */ OrderFlightMemoryEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.aiagent.plugin"));
        }
    }

    public static final class x extends d.h.b.p implements d.h.a.b<Parcel, SimCardEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final x f32131a = null;

        static {
            f32131a = new x();
        }

        public x() {
            super(1);
        }

        public final SimCardEntity a(Parcel r1) {
            d.h.b.o.e(r1, "parcel");
            return new SimCardEntity(r1);
        }

        @Override // d.h.a.b
        public /* synthetic */ SimCardEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.aiagent.plugin"));
        }
    }

    public static final class y extends d.h.b.p implements d.h.a.b<Parcel, OrderTrainMemoryEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final y f32132a = null;

        static {
            f32132a = new y();
        }

        public y() {
            super(1);
        }

        public final OrderTrainMemoryEntity a(Parcel r1) {
            d.h.b.o.e(r1, "parcel");
            return new OrderTrainMemoryEntity(r1);
        }

        @Override // d.h.a.b
        public /* synthetic */ OrderTrainMemoryEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.aiagent.plugin"));
        }
    }

    public static final class z extends d.h.b.p implements d.h.a.b<Parcel, PhotoEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final z f32133a = null;

        static {
            f32133a = new z();
        }

        public z() {
            super(1);
        }

        public final PhotoEntity a(Parcel r1) {
            d.h.b.o.e(r1, "parcel");
            return new PhotoEntity(r1);
        }

        @Override // d.h.a.b
        public /* synthetic */ PhotoEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        INSTANCE = new EntityType();
        classMap = d.a.ao.a(new d.m[]{d.s.a(101, new EntityClassData(MessageEntity.class, MessageEntity.CREATOR.getVersion(), u.f32128a)), d.s.a(201, new EntityClassData(ContactEntity.class, ContactEntity.CREATOR.getVersion(), am.f32104a)), d.s.a(202, new EntityClassData(CallHistoryEntity.class, CallHistoryEntity.CREATOR.getVersion(), n.f32121a)), d.s.a(Integer.valueOf(SIM_CARD), new EntityClassData(SimCardEntity.class, SimCardEntity.CREATOR.getVersion(), x.f32131a)), d.s.a(301, new EntityClassData(PhotoEntity.class, PhotoEntity.CREATOR.getVersion(), z.f32133a)), d.s.a(302, new EntityClassData(AlbumEntity.class, AlbumEntity.CREATOR.getVersion(), ab.f32093a)), d.s.a(401, new EntityClassData(ScheduleEntity.class, ScheduleEntity.CREATOR.getVersion(), ad.f32095a)), d.s.a(501, new EntityClassData(RecordingEntity.class, RecordingEntity.CREATOR.getVersion(), af.f32097a)), d.s.a(Integer.valueOf(NOTE), new EntityClassData(NoteEntity.class, NoteEntity.CREATOR.getVersion(), ah.f32099a)), d.s.a(Integer.valueOf(ALARM), new EntityClassData(AlarmEntity.class, AlarmEntity.CREATOR.getVersion(), a.f32091a)), d.s.a(Integer.valueOf(COUNTDOWN), new EntityClassData(CountdownEntity.class, CountdownEntity.CREATOR.getVersion(), c.f32110a)), d.s.a(Integer.valueOf(FILE), new EntityClassData(FileEntity.class, FileEntity.CREATOR.getVersion(), e.f32112a)), d.s.a(Integer.valueOf(WEBSITE), new EntityClassData(WebsiteEntity.class, WebsiteEntity.CREATOR.getVersion(), g.f32114a)), d.s.a(Integer.valueOf(BROWSER_BOOKMARK), new EntityClassData(BrowserBookmarkEntity.class, BrowserBookmarkEntity.CREATOR.getVersion(), i.f32116a)), d.s.a(203, new EntityClassData(GroupChatEntity.class, GroupChatEntity.CREATOR.getVersion(), k.f32118a)), d.s.a(1001, new EntityClassData(CloudDocumentEntity.class, CloudDocumentEntity.CREATOR.getVersion(), m.f32120a)), d.s.a(1101, new EntityClassData(StockEntity.class, StockEntity.CREATOR.getVersion(), o.f32122a)), d.s.a(303, new EntityClassData(PhotoFaceEntity.class, PhotoFaceEntity.CREATOR.getVersion(), q.f32124a)), d.s.a(Integer.valueOf(AUDITORY_RECORDING), new EntityClassData(AuditoryRecordingEntity.class, AuditoryRecordingEntity.CREATOR.getVersion(), s.f32126a)), d.s.a(10001, new EntityClassData(OrderFlightMemoryEntity.class, OrderFlightMemoryEntity.CREATOR.getVersion(), w.f32130a)), d.s.a(10002, new EntityClassData(OrderTrainMemoryEntity.class, OrderTrainMemoryEntity.CREATOR.getVersion(), y.f32132a)), d.s.a(10003, new EntityClassData(OrderMovieTicketMemoryEntity.class, OrderMovieTicketMemoryEntity.CREATOR.getVersion(), aa.f32092a)), d.s.a(10006, new EntityClassData(OrderTicketMemoryEntity.class, OrderTicketMemoryEntity.CREATOR.getVersion(), ac.f32094a)), d.s.a(10004, new EntityClassData(OrderHotelMemoryEntity.class, OrderHotelMemoryEntity.CREATOR.getVersion(), ae.f32096a)), d.s.a(10005, new EntityClassData(OrderCommonMemoryEntity.class, OrderCommonMemoryEntity.CREATOR.getVersion(), ag.f32098a)), d.s.a(Integer.valueOf(MEMORY_INFO_DOCUMENTS), new EntityClassData(InfoDocumentsMemoryEntity.class, InfoDocumentsMemoryEntity.CREATOR.getVersion(), ai.f32100a)), d.s.a(Integer.valueOf(MEMORY_INFO_ADDRESS), new EntityClassData(InfoAddressMemoryEntity.class, InfoAddressMemoryEntity.CREATOR.getVersion(), aj.f32101a)), d.s.a(Integer.valueOf(MEMORY_INFO_ANNIVERSARY), new EntityClassData(InfoAnniversaryMemoryEntity.class, InfoAnniversaryMemoryEntity.CREATOR.getVersion(), ak.f32102a)), d.s.a(Integer.valueOf(MEMORY_INFO_RELATIONSHIP), new EntityClassData(InfoRelationshipMemoryEntity.class, InfoRelationshipMemoryEntity.CREATOR.getVersion(), al.f32103a)), d.s.a(Integer.valueOf(MEMORY_INFO_COMMON), new EntityClassData(InfoCommonMemoryEntity.class, InfoCommonMemoryEntity.CREATOR.getVersion(), an.f32105a)), d.s.a(Integer.valueOf(MEMORY_COLLECT_CONTENT), new EntityClassData(CollectContentMemoryEntity.class, CollectContentMemoryEntity.CREATOR.getVersion(), ao.f32106a)), d.s.a(Integer.valueOf(MEMORY_COLLECT_STORE), new EntityClassData(CollectStoreMemoryEntity.class, CollectStoreMemoryEntity.CREATOR.getVersion(), ap.f32107a)), d.s.a(Integer.valueOf(MEMORY_EVENT_SCHEDULE), new EntityClassData(EventScheduleMemoryEntity.class, EventScheduleMemoryEntity.CREATOR.getVersion(), aq.f32108a)), d.s.a(Integer.valueOf(MEMORY_EVENT_TODO), new EntityClassData(EventTodoMemoryEntity.class, EventTodoMemoryEntity.CREATOR.getVersion(), b.f32109a)), d.s.a(Integer.valueOf(MEMORY_COMMON_TEXT), new EntityClassData(CommonTextMemoryEntity.class, CommonTextMemoryEntity.CREATOR.getVersion(), d.f32111a)), d.s.a(Integer.valueOf(PROACTIVE_MEMORY), new EntityClassData(ProactiveMemoryEntity.class, ProactiveMemoryEntity.CREATOR.getVersion(), f.f32113a)), d.s.a(402, new EntityClassData(ICSProtocolEntity.class, ICSProtocolEntity.CREATOR.getVersion(), h.f32115a)), d.s.a(1301, new EntityClassData(DoubaoAccountEntity.class, DoubaoAccountEntity.CREATOR.getVersion(), j.f32117a)), d.s.a(1401, new EntityClassData(LifeLogEntity.class, LifeLogEntity.CREATOR.getVersion(), l.f32119a)), d.s.a(Integer.valueOf(USER_PROFILE), new EntityClassData(UserProfileEntity.class, UserProfileEntity.CREATOR.getVersion(), p.f32123a)), d.s.a(Integer.valueOf(EVENT_TASK), new EntityClassData(EventTaskEntity.class, EventTaskEntity.CREATOR.getVersion(), r.f32125a)), d.s.a(Integer.valueOf(APP_INFO), new EntityClassData(AppInfoEntity.class, AppInfoEntity.CREATOR.getVersion(), t.f32127a)), d.s.a(Integer.valueOf(MUSIC), new EntityClassData(MusicEntity.class, MusicEntity.CREATOR.getVersion(), v.f32129a))});
    }

    private EntityType() {
    }

    public final Map<Integer, EntityClassData<? extends AppEntity>> getClassMap() {
        return classMap;
    }
}
