package com.obric.capabilitykit.entity.app;

import android.os.Parcel;
import com.android.vcard.VCardConstants;
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
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b+\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R%\u0010/\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u0002020100¢\u0006\b\n\u0000\u001a\u0004\b3\u00104¨\u00065"}, d2 = {"Lcom/obric/capabilitykit/entity/app/EntityType;", "", "()V", "ALARM", "", "ALBUM", "AUDITORY_RECORDING", "BROWSER_BOOKMARK", "CALENDAR_EVENT", "CALL_HISTORY", "CLOUD_DOCUMENT", "CONTACT", "COUNTDOWN", "DOUBAO_ACCOUNT", "EVENT_TASK", "FILE", "GROUP_CHAT", "ICALENDAR_PROTOCOL", "IM_CONTACT", "INVALIDATE_ENTITY_TYPE", "LIFE_LOG", "MEMORY_COLLECT_CONTENT", "MEMORY_COLLECT_STORE", "MEMORY_COMMON_TEXT", "MEMORY_EVENT_SCHEDULE", "MEMORY_EVENT_TODO", "MEMORY_INFO_ADDRESS", "MEMORY_INFO_ANNIVERSARY", "MEMORY_INFO_COMMON", "MEMORY_INFO_DOCUMENTS", "MEMORY_INFO_RELATIONSHIP", "MEMORY_ORDER_COMMON", "MEMORY_ORDER_FLIGHT", "MEMORY_ORDER_HOTEL", "MEMORY_ORDER_MOVIE_TICKET", "MEMORY_ORDER_TICKET", "MEMORY_ORDER_TRAIN", "MESSAGE", VCardConstants.PROPERTY_NOTE, VCardConstants.PROPERTY_PHOTO, "PHOTO_FACE", "PROACTIVE_MEMORY", "RECORDING", "SCHEDULE", "STOCK", "USER_PROFILE", "WEBSITE", "classMap", "", "Lcom/obric/capabilitykit/entity/app/EntityClassData;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "getClassMap", "()Ljava/util/Map;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EntityType {
    public static final int ALARM = 701;
    public static final int ALBUM = 302;
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
    public static final int NOTE = 601;
    public static final int PHOTO = 301;
    public static final int PHOTO_FACE = 303;
    public static final int PROACTIVE_MEMORY = 20001;
    public static final int RECORDING = 501;
    public static final int SCHEDULE = 401;
    public static final int STOCK = 1101;
    public static final int USER_PROFILE = 1501;
    public static final int WEBSITE = 901;
    private static final Map<Integer, EntityClassData<? extends AppEntity>> classMap = null;

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/CountdownEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function1<Parcel, CountdownEntity> {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
            super(1);
        }

        public final CountdownEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new CountdownEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ CountdownEntity invoke(Parcel r1) {
            return a(r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/memory/CommonTextMemoryEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a0 extends Lambda implements Function1<Parcel, CommonTextMemoryEntity> {
        public static final a0 a = null;

        static {
            a = new a0();
        }

        public a0() {
            super(1);
        }

        public final CommonTextMemoryEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new CommonTextMemoryEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ CommonTextMemoryEntity invoke(Parcel r1) {
            return a(r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/FileEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class b extends Lambda implements Function1<Parcel, FileEntity> {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
            super(1);
        }

        public final FileEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new FileEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ FileEntity invoke(Parcel r1) {
            return a(r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/ProactiveMemoryEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class b0 extends Lambda implements Function1<Parcel, ProactiveMemoryEntity> {
        public static final b0 a = null;

        static {
            a = new b0();
        }

        public b0() {
            super(1);
        }

        public final ProactiveMemoryEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new ProactiveMemoryEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ ProactiveMemoryEntity invoke(Parcel r1) {
            return a(r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/WebsiteEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class c extends Lambda implements Function1<Parcel, WebsiteEntity> {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
            super(1);
        }

        public final WebsiteEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new WebsiteEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ WebsiteEntity invoke(Parcel r1) {
            return a(r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/ICSProtocolEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class c0 extends Lambda implements Function1<Parcel, ICSProtocolEntity> {
        public static final c0 a = null;

        static {
            a = new c0();
        }

        public c0() {
            super(1);
        }

        public final ICSProtocolEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new ICSProtocolEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ ICSProtocolEntity invoke(Parcel r1) {
            return a(r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/BrowserBookmarkEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class d extends Lambda implements Function1<Parcel, BrowserBookmarkEntity> {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
            super(1);
        }

        public final BrowserBookmarkEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new BrowserBookmarkEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ BrowserBookmarkEntity invoke(Parcel r1) {
            return a(r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/DoubaoAccountEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class d0 extends Lambda implements Function1<Parcel, DoubaoAccountEntity> {
        public static final d0 a = null;

        static {
            a = new d0();
        }

        public d0() {
            super(1);
        }

        public final DoubaoAccountEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new DoubaoAccountEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ DoubaoAccountEntity invoke(Parcel r1) {
            return a(r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/GroupChatEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class e extends Lambda implements Function1<Parcel, GroupChatEntity> {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
            super(1);
        }

        public final GroupChatEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new GroupChatEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ GroupChatEntity invoke(Parcel r1) {
            return a(r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/LifeLogEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class e0 extends Lambda implements Function1<Parcel, LifeLogEntity> {
        public static final e0 a = null;

        static {
            a = new e0();
        }

        public e0() {
            super(1);
        }

        public final LifeLogEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new LifeLogEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ LifeLogEntity invoke(Parcel r1) {
            return a(r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/CloudDocumentEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class f extends Lambda implements Function1<Parcel, CloudDocumentEntity> {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
            super(1);
        }

        public final CloudDocumentEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new CloudDocumentEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ CloudDocumentEntity invoke(Parcel r1) {
            return a(r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/UserProfileEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class f0 extends Lambda implements Function1<Parcel, UserProfileEntity> {
        public static final f0 a = null;

        static {
            a = new f0();
        }

        public f0() {
            super(1);
        }

        public final UserProfileEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new UserProfileEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ UserProfileEntity invoke(Parcel r1) {
            return a(r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/StockEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class g extends Lambda implements Function1<Parcel, StockEntity> {
        public static final g a = null;

        static {
            a = new g();
        }

        public g() {
            super(1);
        }

        public final StockEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new StockEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ StockEntity invoke(Parcel r1) {
            return a(r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/CallHistoryEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class g0 extends Lambda implements Function1<Parcel, CallHistoryEntity> {
        public static final g0 a = null;

        static {
            a = new g0();
        }

        public g0() {
            super(1);
        }

        public final CallHistoryEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new CallHistoryEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ CallHistoryEntity invoke(Parcel r1) {
            return a(r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/PhotoFaceEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class h extends Lambda implements Function1<Parcel, PhotoFaceEntity> {
        public static final h a = null;

        static {
            a = new h();
        }

        public h() {
            super(1);
        }

        public final PhotoFaceEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new PhotoFaceEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ PhotoFaceEntity invoke(Parcel r1) {
            return a(r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/EventTaskEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class h0 extends Lambda implements Function1<Parcel, EventTaskEntity> {
        public static final h0 a = null;

        static {
            a = new h0();
        }

        public h0() {
            super(1);
        }

        public final EventTaskEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new EventTaskEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ EventTaskEntity invoke(Parcel r1) {
            return a(r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/AuditoryRecordingEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class i extends Lambda implements Function1<Parcel, AuditoryRecordingEntity> {
        public static final i a = null;

        static {
            a = new i();
        }

        public i() {
            super(1);
        }

        public final AuditoryRecordingEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new AuditoryRecordingEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ AuditoryRecordingEntity invoke(Parcel r1) {
            return a(r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class i0 extends Lambda implements Function1<Parcel, PhotoEntity> {
        public static final i0 a = null;

        static {
            a = new i0();
        }

        public i0() {
            super(1);
        }

        public final PhotoEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new PhotoEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ PhotoEntity invoke(Parcel r1) {
            return a(r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/memory/OrderFlightMemoryEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class j extends Lambda implements Function1<Parcel, OrderFlightMemoryEntity> {
        public static final j a = null;

        static {
            a = new j();
        }

        public j() {
            super(1);
        }

        public final OrderFlightMemoryEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new OrderFlightMemoryEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ OrderFlightMemoryEntity invoke(Parcel r1) {
            return a(r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/AlbumEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class j0 extends Lambda implements Function1<Parcel, AlbumEntity> {
        public static final j0 a = null;

        static {
            a = new j0();
        }

        public j0() {
            super(1);
        }

        public final AlbumEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new AlbumEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ AlbumEntity invoke(Parcel r1) {
            return a(r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/MessageEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class k extends Lambda implements Function1<Parcel, MessageEntity> {
        public static final k a = null;

        static {
            a = new k();
        }

        public k() {
            super(1);
        }

        public final MessageEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new MessageEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ MessageEntity invoke(Parcel r1) {
            return a(r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/ScheduleEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class k0 extends Lambda implements Function1<Parcel, ScheduleEntity> {
        public static final k0 a = null;

        static {
            a = new k0();
        }

        public k0() {
            super(1);
        }

        public final ScheduleEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new ScheduleEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ ScheduleEntity invoke(Parcel r1) {
            return a(r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/memory/OrderTrainMemoryEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class l extends Lambda implements Function1<Parcel, OrderTrainMemoryEntity> {
        public static final l a = null;

        static {
            a = new l();
        }

        public l() {
            super(1);
        }

        public final OrderTrainMemoryEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new OrderTrainMemoryEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ OrderTrainMemoryEntity invoke(Parcel r1) {
            return a(r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/RecordingEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class l0 extends Lambda implements Function1<Parcel, RecordingEntity> {
        public static final l0 a = null;

        static {
            a = new l0();
        }

        public l0() {
            super(1);
        }

        public final RecordingEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new RecordingEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ RecordingEntity invoke(Parcel r1) {
            return a(r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/memory/OrderMovieTicketMemoryEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class m extends Lambda implements Function1<Parcel, OrderMovieTicketMemoryEntity> {
        public static final m a = null;

        static {
            a = new m();
        }

        public m() {
            super(1);
        }

        public final OrderMovieTicketMemoryEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new OrderMovieTicketMemoryEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ OrderMovieTicketMemoryEntity invoke(Parcel r1) {
            return a(r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/NoteEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class m0 extends Lambda implements Function1<Parcel, NoteEntity> {
        public static final m0 a = null;

        static {
            a = new m0();
        }

        public m0() {
            super(1);
        }

        public final NoteEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new NoteEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ NoteEntity invoke(Parcel r1) {
            return a(r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/memory/OrderTicketMemoryEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class n extends Lambda implements Function1<Parcel, OrderTicketMemoryEntity> {
        public static final n a = null;

        static {
            a = new n();
        }

        public n() {
            super(1);
        }

        public final OrderTicketMemoryEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new OrderTicketMemoryEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ OrderTicketMemoryEntity invoke(Parcel r1) {
            return a(r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/AlarmEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class n0 extends Lambda implements Function1<Parcel, AlarmEntity> {
        public static final n0 a = null;

        static {
            a = new n0();
        }

        public n0() {
            super(1);
        }

        public final AlarmEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new AlarmEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ AlarmEntity invoke(Parcel r1) {
            return a(r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/memory/OrderHotelMemoryEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class o extends Lambda implements Function1<Parcel, OrderHotelMemoryEntity> {
        public static final o a = null;

        static {
            a = new o();
        }

        public o() {
            super(1);
        }

        public final OrderHotelMemoryEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new OrderHotelMemoryEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ OrderHotelMemoryEntity invoke(Parcel r1) {
            return a(r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/memory/OrderCommonMemoryEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class p extends Lambda implements Function1<Parcel, OrderCommonMemoryEntity> {
        public static final p a = null;

        static {
            a = new p();
        }

        public p() {
            super(1);
        }

        public final OrderCommonMemoryEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new OrderCommonMemoryEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ OrderCommonMemoryEntity invoke(Parcel r1) {
            return a(r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/memory/InfoDocumentsMemoryEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class q extends Lambda implements Function1<Parcel, InfoDocumentsMemoryEntity> {
        public static final q a = null;

        static {
            a = new q();
        }

        public q() {
            super(1);
        }

        public final InfoDocumentsMemoryEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new InfoDocumentsMemoryEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ InfoDocumentsMemoryEntity invoke(Parcel r1) {
            return a(r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/memory/InfoAddressMemoryEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class r extends Lambda implements Function1<Parcel, InfoAddressMemoryEntity> {
        public static final r a = null;

        static {
            a = new r();
        }

        public r() {
            super(1);
        }

        public final InfoAddressMemoryEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new InfoAddressMemoryEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ InfoAddressMemoryEntity invoke(Parcel r1) {
            return a(r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/memory/InfoAnniversaryMemoryEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class s extends Lambda implements Function1<Parcel, InfoAnniversaryMemoryEntity> {
        public static final s a = null;

        static {
            a = new s();
        }

        public s() {
            super(1);
        }

        public final InfoAnniversaryMemoryEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new InfoAnniversaryMemoryEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ InfoAnniversaryMemoryEntity invoke(Parcel r1) {
            return a(r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/memory/InfoRelationshipMemoryEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class t extends Lambda implements Function1<Parcel, InfoRelationshipMemoryEntity> {
        public static final t a = null;

        static {
            a = new t();
        }

        public t() {
            super(1);
        }

        public final InfoRelationshipMemoryEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new InfoRelationshipMemoryEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ InfoRelationshipMemoryEntity invoke(Parcel r1) {
            return a(r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/memory/InfoCommonMemoryEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class u extends Lambda implements Function1<Parcel, InfoCommonMemoryEntity> {
        public static final u a = null;

        static {
            a = new u();
        }

        public u() {
            super(1);
        }

        public final InfoCommonMemoryEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new InfoCommonMemoryEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ InfoCommonMemoryEntity invoke(Parcel r1) {
            return a(r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/ContactEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class v extends Lambda implements Function1<Parcel, ContactEntity> {
        public static final v a = null;

        static {
            a = new v();
        }

        public v() {
            super(1);
        }

        public final ContactEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new ContactEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ ContactEntity invoke(Parcel r1) {
            return a(r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/memory/CollectContentMemoryEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class w extends Lambda implements Function1<Parcel, CollectContentMemoryEntity> {
        public static final w a = null;

        static {
            a = new w();
        }

        public w() {
            super(1);
        }

        public final CollectContentMemoryEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new CollectContentMemoryEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ CollectContentMemoryEntity invoke(Parcel r1) {
            return a(r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/memory/CollectStoreMemoryEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class x extends Lambda implements Function1<Parcel, CollectStoreMemoryEntity> {
        public static final x a = null;

        static {
            a = new x();
        }

        public x() {
            super(1);
        }

        public final CollectStoreMemoryEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new CollectStoreMemoryEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ CollectStoreMemoryEntity invoke(Parcel r1) {
            return a(r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/memory/EventScheduleMemoryEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class y extends Lambda implements Function1<Parcel, EventScheduleMemoryEntity> {
        public static final y a = null;

        static {
            a = new y();
        }

        public y() {
            super(1);
        }

        public final EventScheduleMemoryEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new EventScheduleMemoryEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ EventScheduleMemoryEntity invoke(Parcel r1) {
            return a(r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/memory/EventTodoMemoryEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class z extends Lambda implements Function1<Parcel, EventTodoMemoryEntity> {
        public static final z a = null;

        static {
            a = new z();
        }

        public z() {
            super(1);
        }

        public final EventTodoMemoryEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new EventTodoMemoryEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ EventTodoMemoryEntity invoke(Parcel r1) {
            return a(r1);
        }
    }

    static {
        INSTANCE = new EntityType();
        classMap = MapsKt.mapOf(new Pair[]{TuplesKt.to(101, new EntityClassData(MessageEntity.class, MessageEntity.CREATOR.getVersion(), k.a)), TuplesKt.to(201, new EntityClassData(ContactEntity.class, ContactEntity.CREATOR.getVersion(), v.a)), TuplesKt.to(202, new EntityClassData(CallHistoryEntity.class, CallHistoryEntity.CREATOR.getVersion(), g0.a)), TuplesKt.to(301, new EntityClassData(PhotoEntity.class, PhotoEntity.CREATOR.getVersion(), i0.a)), TuplesKt.to(302, new EntityClassData(AlbumEntity.class, AlbumEntity.CREATOR.getVersion(), j0.a)), TuplesKt.to(401, new EntityClassData(ScheduleEntity.class, ScheduleEntity.CREATOR.getVersion(), k0.a)), TuplesKt.to(501, new EntityClassData(RecordingEntity.class, RecordingEntity.CREATOR.getVersion(), l0.a)), TuplesKt.to(601, new EntityClassData(NoteEntity.class, NoteEntity.CREATOR.getVersion(), m0.a)), TuplesKt.to(701, new EntityClassData(AlarmEntity.class, AlarmEntity.CREATOR.getVersion(), n0.a)), TuplesKt.to(702, new EntityClassData(CountdownEntity.class, CountdownEntity.CREATOR.getVersion(), a.a)), TuplesKt.to(Integer.valueOf(FILE), new EntityClassData(FileEntity.class, FileEntity.CREATOR.getVersion(), b.a)), TuplesKt.to(901, new EntityClassData(WebsiteEntity.class, WebsiteEntity.CREATOR.getVersion(), c.a)), TuplesKt.to(902, new EntityClassData(BrowserBookmarkEntity.class, BrowserBookmarkEntity.CREATOR.getVersion(), d.a)), TuplesKt.to(203, new EntityClassData(GroupChatEntity.class, GroupChatEntity.CREATOR.getVersion(), e.a)), TuplesKt.to(1001, new EntityClassData(CloudDocumentEntity.class, CloudDocumentEntity.CREATOR.getVersion(), f.a)), TuplesKt.to(Integer.valueOf(STOCK), new EntityClassData(StockEntity.class, StockEntity.CREATOR.getVersion(), g.a)), TuplesKt.to(303, new EntityClassData(PhotoFaceEntity.class, PhotoFaceEntity.CREATOR.getVersion(), h.a)), TuplesKt.to(502, new EntityClassData(AuditoryRecordingEntity.class, AuditoryRecordingEntity.CREATOR.getVersion(), i.a)), TuplesKt.to(10001, new EntityClassData(OrderFlightMemoryEntity.class, OrderFlightMemoryEntity.CREATOR.getVersion(), j.a)), TuplesKt.to(10002, new EntityClassData(OrderTrainMemoryEntity.class, OrderTrainMemoryEntity.CREATOR.getVersion(), l.a)), TuplesKt.to(10003, new EntityClassData(OrderMovieTicketMemoryEntity.class, OrderMovieTicketMemoryEntity.CREATOR.getVersion(), m.a)), TuplesKt.to(10006, new EntityClassData(OrderTicketMemoryEntity.class, OrderTicketMemoryEntity.CREATOR.getVersion(), n.a)), TuplesKt.to(10004, new EntityClassData(OrderHotelMemoryEntity.class, OrderHotelMemoryEntity.CREATOR.getVersion(), o.a)), TuplesKt.to(10005, new EntityClassData(OrderCommonMemoryEntity.class, OrderCommonMemoryEntity.CREATOR.getVersion(), p.a)), TuplesKt.to(Integer.valueOf(MEMORY_INFO_DOCUMENTS), new EntityClassData(InfoDocumentsMemoryEntity.class, InfoDocumentsMemoryEntity.CREATOR.getVersion(), q.a)), TuplesKt.to(Integer.valueOf(MEMORY_INFO_ADDRESS), new EntityClassData(InfoAddressMemoryEntity.class, InfoAddressMemoryEntity.CREATOR.getVersion(), r.a)), TuplesKt.to(Integer.valueOf(MEMORY_INFO_ANNIVERSARY), new EntityClassData(InfoAnniversaryMemoryEntity.class, InfoAnniversaryMemoryEntity.CREATOR.getVersion(), s.a)), TuplesKt.to(Integer.valueOf(MEMORY_INFO_RELATIONSHIP), new EntityClassData(InfoRelationshipMemoryEntity.class, InfoRelationshipMemoryEntity.CREATOR.getVersion(), t.a)), TuplesKt.to(Integer.valueOf(MEMORY_INFO_COMMON), new EntityClassData(InfoCommonMemoryEntity.class, InfoCommonMemoryEntity.CREATOR.getVersion(), u.a)), TuplesKt.to(Integer.valueOf(MEMORY_COLLECT_CONTENT), new EntityClassData(CollectContentMemoryEntity.class, CollectContentMemoryEntity.CREATOR.getVersion(), w.a)), TuplesKt.to(Integer.valueOf(MEMORY_COLLECT_STORE), new EntityClassData(CollectStoreMemoryEntity.class, CollectStoreMemoryEntity.CREATOR.getVersion(), x.a)), TuplesKt.to(Integer.valueOf(MEMORY_EVENT_SCHEDULE), new EntityClassData(EventScheduleMemoryEntity.class, EventScheduleMemoryEntity.CREATOR.getVersion(), y.a)), TuplesKt.to(Integer.valueOf(MEMORY_EVENT_TODO), new EntityClassData(EventTodoMemoryEntity.class, EventTodoMemoryEntity.CREATOR.getVersion(), z.a)), TuplesKt.to(Integer.valueOf(MEMORY_COMMON_TEXT), new EntityClassData(CommonTextMemoryEntity.class, CommonTextMemoryEntity.CREATOR.getVersion(), a0.a)), TuplesKt.to(Integer.valueOf(PROACTIVE_MEMORY), new EntityClassData(ProactiveMemoryEntity.class, ProactiveMemoryEntity.CREATOR.getVersion(), b0.a)), TuplesKt.to(402, new EntityClassData(ICSProtocolEntity.class, ICSProtocolEntity.CREATOR.getVersion(), c0.a)), TuplesKt.to(Integer.valueOf(DOUBAO_ACCOUNT), new EntityClassData(DoubaoAccountEntity.class, DoubaoAccountEntity.CREATOR.getVersion(), d0.a)), TuplesKt.to(Integer.valueOf(LIFE_LOG), new EntityClassData(LifeLogEntity.class, LifeLogEntity.CREATOR.getVersion(), e0.a)), TuplesKt.to(Integer.valueOf(USER_PROFILE), new EntityClassData(UserProfileEntity.class, UserProfileEntity.CREATOR.getVersion(), f0.a)), TuplesKt.to(Integer.valueOf(EVENT_TASK), new EntityClassData(EventTaskEntity.class, EventTaskEntity.CREATOR.getVersion(), h0.a))});
    }

    private EntityType() {
    }

    public final Map<Integer, EntityClassData<? extends AppEntity>> getClassMap() {
        return classMap;
    }
}
