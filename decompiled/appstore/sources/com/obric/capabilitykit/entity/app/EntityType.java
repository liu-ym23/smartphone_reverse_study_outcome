package com.obric.capabilitykit.entity.app;

import android.os.Parcel;
import androidx.annotation.Keep;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b,\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R%\u00100\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u0002030201¢\u0006\b\n\u0000\u001a\u0004\b4\u00105¨\u00066"}, d2 = {"Lcom/obric/capabilitykit/entity/app/EntityType;", "", "()V", "ALARM", "", "ALBUM", "APP_INFO", "AUDITORY_RECORDING", "BROWSER_BOOKMARK", "CALENDAR_EVENT", "CALL_HISTORY", "CLOUD_DOCUMENT", "CONTACT", "COUNTDOWN", "DOUBAO_ACCOUNT", "EVENT_TASK", "FILE", "GROUP_CHAT", "ICALENDAR_PROTOCOL", "IM_CONTACT", "INVALIDATE_ENTITY_TYPE", "LIFE_LOG", "MEMORY_COLLECT_CONTENT", "MEMORY_COLLECT_STORE", "MEMORY_COMMON_TEXT", "MEMORY_EVENT_SCHEDULE", "MEMORY_EVENT_TODO", "MEMORY_INFO_ADDRESS", "MEMORY_INFO_ANNIVERSARY", "MEMORY_INFO_COMMON", "MEMORY_INFO_DOCUMENTS", "MEMORY_INFO_RELATIONSHIP", "MEMORY_ORDER_COMMON", "MEMORY_ORDER_FLIGHT", "MEMORY_ORDER_HOTEL", "MEMORY_ORDER_MOVIE_TICKET", "MEMORY_ORDER_TICKET", "MEMORY_ORDER_TRAIN", "MESSAGE", "NOTE", "PHOTO", "PHOTO_FACE", "PROACTIVE_MEMORY", "RECORDING", "SCHEDULE", "STOCK", "USER_PROFILE", "WEBSITE", "classMap", "", "Lcom/obric/capabilitykit/entity/app/EntityClassData;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "getClassMap", "()Ljava/util/Map;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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

    @NotNull
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

    @NotNull
    private static final Map<Integer, EntityClassData<? extends AppEntity>> classMap = null;

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/CountdownEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function1<Parcel, CountdownEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f11324a = null;

        static {
            f11324a = new a();
        }

        public a() {
            super(1);
        }

        @NotNull
        public final CountdownEntity a(@NotNull Parcel r10) {
            kotlin.jvm.internal.q.g(r10, "parcel");
            return new CountdownEntity(r10);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ CountdownEntity invoke(Parcel r10) {
            return a(r10);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/memory/CommonTextMemoryEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a0 extends Lambda implements Function1<Parcel, CommonTextMemoryEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a0 f11325a = null;

        static {
            f11325a = new a0();
        }

        public a0() {
            super(1);
        }

        @NotNull
        public final CommonTextMemoryEntity a(@NotNull Parcel r10) {
            kotlin.jvm.internal.q.g(r10, "parcel");
            return new CommonTextMemoryEntity(r10);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ CommonTextMemoryEntity invoke(Parcel r10) {
            return a(r10);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/FileEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class b extends Lambda implements Function1<Parcel, FileEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f11326a = null;

        static {
            f11326a = new b();
        }

        public b() {
            super(1);
        }

        @NotNull
        public final FileEntity a(@NotNull Parcel r10) {
            kotlin.jvm.internal.q.g(r10, "parcel");
            return new FileEntity(r10);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ FileEntity invoke(Parcel r10) {
            return a(r10);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/ProactiveMemoryEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class b0 extends Lambda implements Function1<Parcel, ProactiveMemoryEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b0 f11327a = null;

        static {
            f11327a = new b0();
        }

        public b0() {
            super(1);
        }

        @NotNull
        public final ProactiveMemoryEntity a(@NotNull Parcel r10) {
            kotlin.jvm.internal.q.g(r10, "parcel");
            return new ProactiveMemoryEntity(r10);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ ProactiveMemoryEntity invoke(Parcel r10) {
            return a(r10);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/WebsiteEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class c extends Lambda implements Function1<Parcel, WebsiteEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f11328a = null;

        static {
            f11328a = new c();
        }

        public c() {
            super(1);
        }

        @NotNull
        public final WebsiteEntity a(@NotNull Parcel r10) {
            kotlin.jvm.internal.q.g(r10, "parcel");
            return new WebsiteEntity(r10);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ WebsiteEntity invoke(Parcel r10) {
            return a(r10);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/ICSProtocolEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class c0 extends Lambda implements Function1<Parcel, ICSProtocolEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c0 f11329a = null;

        static {
            f11329a = new c0();
        }

        public c0() {
            super(1);
        }

        @NotNull
        public final ICSProtocolEntity a(@NotNull Parcel r10) {
            kotlin.jvm.internal.q.g(r10, "parcel");
            return new ICSProtocolEntity(r10);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ ICSProtocolEntity invoke(Parcel r10) {
            return a(r10);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/BrowserBookmarkEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class d extends Lambda implements Function1<Parcel, BrowserBookmarkEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f11330a = null;

        static {
            f11330a = new d();
        }

        public d() {
            super(1);
        }

        @NotNull
        public final BrowserBookmarkEntity a(@NotNull Parcel r10) {
            kotlin.jvm.internal.q.g(r10, "parcel");
            return new BrowserBookmarkEntity(r10);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ BrowserBookmarkEntity invoke(Parcel r10) {
            return a(r10);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/DoubaoAccountEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class d0 extends Lambda implements Function1<Parcel, DoubaoAccountEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d0 f11331a = null;

        static {
            f11331a = new d0();
        }

        public d0() {
            super(1);
        }

        @NotNull
        public final DoubaoAccountEntity a(@NotNull Parcel r10) {
            kotlin.jvm.internal.q.g(r10, "parcel");
            return new DoubaoAccountEntity(r10);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ DoubaoAccountEntity invoke(Parcel r10) {
            return a(r10);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/GroupChatEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class e extends Lambda implements Function1<Parcel, GroupChatEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f11332a = null;

        static {
            f11332a = new e();
        }

        public e() {
            super(1);
        }

        @NotNull
        public final GroupChatEntity a(@NotNull Parcel r10) {
            kotlin.jvm.internal.q.g(r10, "parcel");
            return new GroupChatEntity(r10);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ GroupChatEntity invoke(Parcel r10) {
            return a(r10);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/LifeLogEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class e0 extends Lambda implements Function1<Parcel, LifeLogEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e0 f11333a = null;

        static {
            f11333a = new e0();
        }

        public e0() {
            super(1);
        }

        @NotNull
        public final LifeLogEntity a(@NotNull Parcel r10) {
            kotlin.jvm.internal.q.g(r10, "parcel");
            return new LifeLogEntity(r10);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ LifeLogEntity invoke(Parcel r10) {
            return a(r10);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/CloudDocumentEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class f extends Lambda implements Function1<Parcel, CloudDocumentEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f11334a = null;

        static {
            f11334a = new f();
        }

        public f() {
            super(1);
        }

        @NotNull
        public final CloudDocumentEntity a(@NotNull Parcel r10) {
            kotlin.jvm.internal.q.g(r10, "parcel");
            return new CloudDocumentEntity(r10);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ CloudDocumentEntity invoke(Parcel r10) {
            return a(r10);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/UserProfileEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class f0 extends Lambda implements Function1<Parcel, UserProfileEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f0 f11335a = null;

        static {
            f11335a = new f0();
        }

        public f0() {
            super(1);
        }

        @NotNull
        public final UserProfileEntity a(@NotNull Parcel r10) {
            kotlin.jvm.internal.q.g(r10, "parcel");
            return new UserProfileEntity(r10);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ UserProfileEntity invoke(Parcel r10) {
            return a(r10);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/StockEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class g extends Lambda implements Function1<Parcel, StockEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f11336a = null;

        static {
            f11336a = new g();
        }

        public g() {
            super(1);
        }

        @NotNull
        public final StockEntity a(@NotNull Parcel r10) {
            kotlin.jvm.internal.q.g(r10, "parcel");
            return new StockEntity(r10);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ StockEntity invoke(Parcel r10) {
            return a(r10);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/CallHistoryEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class g0 extends Lambda implements Function1<Parcel, CallHistoryEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g0 f11337a = null;

        static {
            f11337a = new g0();
        }

        public g0() {
            super(1);
        }

        @NotNull
        public final CallHistoryEntity a(@NotNull Parcel r10) {
            kotlin.jvm.internal.q.g(r10, "parcel");
            return new CallHistoryEntity(r10);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ CallHistoryEntity invoke(Parcel r10) {
            return a(r10);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/PhotoFaceEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class h extends Lambda implements Function1<Parcel, PhotoFaceEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f11338a = null;

        static {
            f11338a = new h();
        }

        public h() {
            super(1);
        }

        @NotNull
        public final PhotoFaceEntity a(@NotNull Parcel r10) {
            kotlin.jvm.internal.q.g(r10, "parcel");
            return new PhotoFaceEntity(r10);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ PhotoFaceEntity invoke(Parcel r10) {
            return a(r10);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/EventTaskEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class h0 extends Lambda implements Function1<Parcel, EventTaskEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h0 f11339a = null;

        static {
            f11339a = new h0();
        }

        public h0() {
            super(1);
        }

        @NotNull
        public final EventTaskEntity a(@NotNull Parcel r10) {
            kotlin.jvm.internal.q.g(r10, "parcel");
            return new EventTaskEntity(r10);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ EventTaskEntity invoke(Parcel r10) {
            return a(r10);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/AuditoryRecordingEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class i extends Lambda implements Function1<Parcel, AuditoryRecordingEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i f11340a = null;

        static {
            f11340a = new i();
        }

        public i() {
            super(1);
        }

        @NotNull
        public final AuditoryRecordingEntity a(@NotNull Parcel r10) {
            kotlin.jvm.internal.q.g(r10, "parcel");
            return new AuditoryRecordingEntity(r10);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ AuditoryRecordingEntity invoke(Parcel r10) {
            return a(r10);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/AppInfoEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class i0 extends Lambda implements Function1<Parcel, AppInfoEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i0 f11341a = null;

        static {
            f11341a = new i0();
        }

        public i0() {
            super(1);
        }

        @NotNull
        public final AppInfoEntity a(@NotNull Parcel r10) {
            kotlin.jvm.internal.q.g(r10, "parcel");
            return new AppInfoEntity(r10);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ AppInfoEntity invoke(Parcel r10) {
            return a(r10);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/memory/OrderFlightMemoryEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class j extends Lambda implements Function1<Parcel, OrderFlightMemoryEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j f11342a = null;

        static {
            f11342a = new j();
        }

        public j() {
            super(1);
        }

        @NotNull
        public final OrderFlightMemoryEntity a(@NotNull Parcel r10) {
            kotlin.jvm.internal.q.g(r10, "parcel");
            return new OrderFlightMemoryEntity(r10);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ OrderFlightMemoryEntity invoke(Parcel r10) {
            return a(r10);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class j0 extends Lambda implements Function1<Parcel, PhotoEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j0 f11343a = null;

        static {
            f11343a = new j0();
        }

        public j0() {
            super(1);
        }

        @NotNull
        public final PhotoEntity a(@NotNull Parcel r10) {
            kotlin.jvm.internal.q.g(r10, "parcel");
            return new PhotoEntity(r10);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ PhotoEntity invoke(Parcel r10) {
            return a(r10);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/MessageEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class k extends Lambda implements Function1<Parcel, MessageEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final k f11344a = null;

        static {
            f11344a = new k();
        }

        public k() {
            super(1);
        }

        @NotNull
        public final MessageEntity a(@NotNull Parcel r10) {
            kotlin.jvm.internal.q.g(r10, "parcel");
            return new MessageEntity(r10);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ MessageEntity invoke(Parcel r10) {
            return a(r10);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/AlbumEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class k0 extends Lambda implements Function1<Parcel, AlbumEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final k0 f11345a = null;

        static {
            f11345a = new k0();
        }

        public k0() {
            super(1);
        }

        @NotNull
        public final AlbumEntity a(@NotNull Parcel r10) {
            kotlin.jvm.internal.q.g(r10, "parcel");
            return new AlbumEntity(r10);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ AlbumEntity invoke(Parcel r10) {
            return a(r10);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/memory/OrderTrainMemoryEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class l extends Lambda implements Function1<Parcel, OrderTrainMemoryEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final l f11346a = null;

        static {
            f11346a = new l();
        }

        public l() {
            super(1);
        }

        @NotNull
        public final OrderTrainMemoryEntity a(@NotNull Parcel r10) {
            kotlin.jvm.internal.q.g(r10, "parcel");
            return new OrderTrainMemoryEntity(r10);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ OrderTrainMemoryEntity invoke(Parcel r10) {
            return a(r10);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/ScheduleEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class l0 extends Lambda implements Function1<Parcel, ScheduleEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final l0 f11347a = null;

        static {
            f11347a = new l0();
        }

        public l0() {
            super(1);
        }

        @NotNull
        public final ScheduleEntity a(@NotNull Parcel r10) {
            kotlin.jvm.internal.q.g(r10, "parcel");
            return new ScheduleEntity(r10);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ ScheduleEntity invoke(Parcel r10) {
            return a(r10);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/memory/OrderMovieTicketMemoryEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class m extends Lambda implements Function1<Parcel, OrderMovieTicketMemoryEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final m f11348a = null;

        static {
            f11348a = new m();
        }

        public m() {
            super(1);
        }

        @NotNull
        public final OrderMovieTicketMemoryEntity a(@NotNull Parcel r10) {
            kotlin.jvm.internal.q.g(r10, "parcel");
            return new OrderMovieTicketMemoryEntity(r10);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ OrderMovieTicketMemoryEntity invoke(Parcel r10) {
            return a(r10);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/RecordingEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class m0 extends Lambda implements Function1<Parcel, RecordingEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final m0 f11349a = null;

        static {
            f11349a = new m0();
        }

        public m0() {
            super(1);
        }

        @NotNull
        public final RecordingEntity a(@NotNull Parcel r10) {
            kotlin.jvm.internal.q.g(r10, "parcel");
            return new RecordingEntity(r10);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ RecordingEntity invoke(Parcel r10) {
            return a(r10);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/memory/OrderTicketMemoryEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class n extends Lambda implements Function1<Parcel, OrderTicketMemoryEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final n f11350a = null;

        static {
            f11350a = new n();
        }

        public n() {
            super(1);
        }

        @NotNull
        public final OrderTicketMemoryEntity a(@NotNull Parcel r10) {
            kotlin.jvm.internal.q.g(r10, "parcel");
            return new OrderTicketMemoryEntity(r10);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ OrderTicketMemoryEntity invoke(Parcel r10) {
            return a(r10);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/NoteEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class n0 extends Lambda implements Function1<Parcel, NoteEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final n0 f11351a = null;

        static {
            f11351a = new n0();
        }

        public n0() {
            super(1);
        }

        @NotNull
        public final NoteEntity a(@NotNull Parcel r10) {
            kotlin.jvm.internal.q.g(r10, "parcel");
            return new NoteEntity(r10);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ NoteEntity invoke(Parcel r10) {
            return a(r10);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/memory/OrderHotelMemoryEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class o extends Lambda implements Function1<Parcel, OrderHotelMemoryEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final o f11352a = null;

        static {
            f11352a = new o();
        }

        public o() {
            super(1);
        }

        @NotNull
        public final OrderHotelMemoryEntity a(@NotNull Parcel r10) {
            kotlin.jvm.internal.q.g(r10, "parcel");
            return new OrderHotelMemoryEntity(r10);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ OrderHotelMemoryEntity invoke(Parcel r10) {
            return a(r10);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/AlarmEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class o0 extends Lambda implements Function1<Parcel, AlarmEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final o0 f11353a = null;

        static {
            f11353a = new o0();
        }

        public o0() {
            super(1);
        }

        @NotNull
        public final AlarmEntity a(@NotNull Parcel r10) {
            kotlin.jvm.internal.q.g(r10, "parcel");
            return new AlarmEntity(r10);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ AlarmEntity invoke(Parcel r10) {
            return a(r10);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/memory/OrderCommonMemoryEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class p extends Lambda implements Function1<Parcel, OrderCommonMemoryEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final p f11354a = null;

        static {
            f11354a = new p();
        }

        public p() {
            super(1);
        }

        @NotNull
        public final OrderCommonMemoryEntity a(@NotNull Parcel r10) {
            kotlin.jvm.internal.q.g(r10, "parcel");
            return new OrderCommonMemoryEntity(r10);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ OrderCommonMemoryEntity invoke(Parcel r10) {
            return a(r10);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/memory/InfoDocumentsMemoryEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class q extends Lambda implements Function1<Parcel, InfoDocumentsMemoryEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final q f11355a = null;

        static {
            f11355a = new q();
        }

        public q() {
            super(1);
        }

        @NotNull
        public final InfoDocumentsMemoryEntity a(@NotNull Parcel r10) {
            kotlin.jvm.internal.q.g(r10, "parcel");
            return new InfoDocumentsMemoryEntity(r10);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ InfoDocumentsMemoryEntity invoke(Parcel r10) {
            return a(r10);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/memory/InfoAddressMemoryEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class r extends Lambda implements Function1<Parcel, InfoAddressMemoryEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final r f11356a = null;

        static {
            f11356a = new r();
        }

        public r() {
            super(1);
        }

        @NotNull
        public final InfoAddressMemoryEntity a(@NotNull Parcel r10) {
            kotlin.jvm.internal.q.g(r10, "parcel");
            return new InfoAddressMemoryEntity(r10);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ InfoAddressMemoryEntity invoke(Parcel r10) {
            return a(r10);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/memory/InfoAnniversaryMemoryEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class s extends Lambda implements Function1<Parcel, InfoAnniversaryMemoryEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final s f11357a = null;

        static {
            f11357a = new s();
        }

        public s() {
            super(1);
        }

        @NotNull
        public final InfoAnniversaryMemoryEntity a(@NotNull Parcel r10) {
            kotlin.jvm.internal.q.g(r10, "parcel");
            return new InfoAnniversaryMemoryEntity(r10);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ InfoAnniversaryMemoryEntity invoke(Parcel r10) {
            return a(r10);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/memory/InfoRelationshipMemoryEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class t extends Lambda implements Function1<Parcel, InfoRelationshipMemoryEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final t f11358a = null;

        static {
            f11358a = new t();
        }

        public t() {
            super(1);
        }

        @NotNull
        public final InfoRelationshipMemoryEntity a(@NotNull Parcel r10) {
            kotlin.jvm.internal.q.g(r10, "parcel");
            return new InfoRelationshipMemoryEntity(r10);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ InfoRelationshipMemoryEntity invoke(Parcel r10) {
            return a(r10);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/memory/InfoCommonMemoryEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class u extends Lambda implements Function1<Parcel, InfoCommonMemoryEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final u f11359a = null;

        static {
            f11359a = new u();
        }

        public u() {
            super(1);
        }

        @NotNull
        public final InfoCommonMemoryEntity a(@NotNull Parcel r10) {
            kotlin.jvm.internal.q.g(r10, "parcel");
            return new InfoCommonMemoryEntity(r10);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ InfoCommonMemoryEntity invoke(Parcel r10) {
            return a(r10);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/ContactEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class v extends Lambda implements Function1<Parcel, ContactEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final v f11360a = null;

        static {
            f11360a = new v();
        }

        public v() {
            super(1);
        }

        @NotNull
        public final ContactEntity a(@NotNull Parcel r10) {
            kotlin.jvm.internal.q.g(r10, "parcel");
            return new ContactEntity(r10);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ ContactEntity invoke(Parcel r10) {
            return a(r10);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/memory/CollectContentMemoryEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class w extends Lambda implements Function1<Parcel, CollectContentMemoryEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final w f11361a = null;

        static {
            f11361a = new w();
        }

        public w() {
            super(1);
        }

        @NotNull
        public final CollectContentMemoryEntity a(@NotNull Parcel r10) {
            kotlin.jvm.internal.q.g(r10, "parcel");
            return new CollectContentMemoryEntity(r10);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ CollectContentMemoryEntity invoke(Parcel r10) {
            return a(r10);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/memory/CollectStoreMemoryEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class x extends Lambda implements Function1<Parcel, CollectStoreMemoryEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final x f11362a = null;

        static {
            f11362a = new x();
        }

        public x() {
            super(1);
        }

        @NotNull
        public final CollectStoreMemoryEntity a(@NotNull Parcel r10) {
            kotlin.jvm.internal.q.g(r10, "parcel");
            return new CollectStoreMemoryEntity(r10);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ CollectStoreMemoryEntity invoke(Parcel r10) {
            return a(r10);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/memory/EventScheduleMemoryEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class y extends Lambda implements Function1<Parcel, EventScheduleMemoryEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final y f11363a = null;

        static {
            f11363a = new y();
        }

        public y() {
            super(1);
        }

        @NotNull
        public final EventScheduleMemoryEntity a(@NotNull Parcel r10) {
            kotlin.jvm.internal.q.g(r10, "parcel");
            return new EventScheduleMemoryEntity(r10);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ EventScheduleMemoryEntity invoke(Parcel r10) {
            return a(r10);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/memory/EventTodoMemoryEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class z extends Lambda implements Function1<Parcel, EventTodoMemoryEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final z f11364a = null;

        static {
            f11364a = new z();
        }

        public z() {
            super(1);
        }

        @NotNull
        public final EventTodoMemoryEntity a(@NotNull Parcel r10) {
            kotlin.jvm.internal.q.g(r10, "parcel");
            return new EventTodoMemoryEntity(r10);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ EventTodoMemoryEntity invoke(Parcel r10) {
            return a(r10);
        }
    }

    static {
        INSTANCE = new EntityType();
        classMap = kotlin.collections.k0.j(new Pair[]{kotlin.d.a(101, new EntityClassData(MessageEntity.class, MessageEntity.CREATOR.getVersion(), k.f11344a)), kotlin.d.a(201, new EntityClassData(ContactEntity.class, ContactEntity.CREATOR.getVersion(), v.f11360a)), kotlin.d.a(202, new EntityClassData(CallHistoryEntity.class, CallHistoryEntity.CREATOR.getVersion(), g0.f11337a)), kotlin.d.a(301, new EntityClassData(PhotoEntity.class, PhotoEntity.CREATOR.getVersion(), j0.f11343a)), kotlin.d.a(302, new EntityClassData(AlbumEntity.class, AlbumEntity.CREATOR.getVersion(), k0.f11345a)), kotlin.d.a(401, new EntityClassData(ScheduleEntity.class, ScheduleEntity.CREATOR.getVersion(), l0.f11347a)), kotlin.d.a(501, new EntityClassData(RecordingEntity.class, RecordingEntity.CREATOR.getVersion(), m0.f11349a)), kotlin.d.a(601, new EntityClassData(NoteEntity.class, NoteEntity.CREATOR.getVersion(), n0.f11351a)), kotlin.d.a(701, new EntityClassData(AlarmEntity.class, AlarmEntity.CREATOR.getVersion(), o0.f11353a)), kotlin.d.a(702, new EntityClassData(CountdownEntity.class, CountdownEntity.CREATOR.getVersion(), a.f11324a)), kotlin.d.a(Integer.valueOf(FILE), new EntityClassData(FileEntity.class, FileEntity.CREATOR.getVersion(), b.f11326a)), kotlin.d.a(901, new EntityClassData(WebsiteEntity.class, WebsiteEntity.CREATOR.getVersion(), c.f11328a)), kotlin.d.a(902, new EntityClassData(BrowserBookmarkEntity.class, BrowserBookmarkEntity.CREATOR.getVersion(), d.f11330a)), kotlin.d.a(203, new EntityClassData(GroupChatEntity.class, GroupChatEntity.CREATOR.getVersion(), e.f11332a)), kotlin.d.a(1001, new EntityClassData(CloudDocumentEntity.class, CloudDocumentEntity.CREATOR.getVersion(), f.f11334a)), kotlin.d.a(Integer.valueOf(STOCK), new EntityClassData(StockEntity.class, StockEntity.CREATOR.getVersion(), g.f11336a)), kotlin.d.a(303, new EntityClassData(PhotoFaceEntity.class, PhotoFaceEntity.CREATOR.getVersion(), h.f11338a)), kotlin.d.a(502, new EntityClassData(AuditoryRecordingEntity.class, AuditoryRecordingEntity.CREATOR.getVersion(), i.f11340a)), kotlin.d.a(10001, new EntityClassData(OrderFlightMemoryEntity.class, OrderFlightMemoryEntity.CREATOR.getVersion(), j.f11342a)), kotlin.d.a(10002, new EntityClassData(OrderTrainMemoryEntity.class, OrderTrainMemoryEntity.CREATOR.getVersion(), l.f11346a)), kotlin.d.a(10003, new EntityClassData(OrderMovieTicketMemoryEntity.class, OrderMovieTicketMemoryEntity.CREATOR.getVersion(), m.f11348a)), kotlin.d.a(10006, new EntityClassData(OrderTicketMemoryEntity.class, OrderTicketMemoryEntity.CREATOR.getVersion(), n.f11350a)), kotlin.d.a(10004, new EntityClassData(OrderHotelMemoryEntity.class, OrderHotelMemoryEntity.CREATOR.getVersion(), o.f11352a)), kotlin.d.a(10005, new EntityClassData(OrderCommonMemoryEntity.class, OrderCommonMemoryEntity.CREATOR.getVersion(), p.f11354a)), kotlin.d.a(Integer.valueOf(MEMORY_INFO_DOCUMENTS), new EntityClassData(InfoDocumentsMemoryEntity.class, InfoDocumentsMemoryEntity.CREATOR.getVersion(), q.f11355a)), kotlin.d.a(Integer.valueOf(MEMORY_INFO_ADDRESS), new EntityClassData(InfoAddressMemoryEntity.class, InfoAddressMemoryEntity.CREATOR.getVersion(), r.f11356a)), kotlin.d.a(Integer.valueOf(MEMORY_INFO_ANNIVERSARY), new EntityClassData(InfoAnniversaryMemoryEntity.class, InfoAnniversaryMemoryEntity.CREATOR.getVersion(), s.f11357a)), kotlin.d.a(Integer.valueOf(MEMORY_INFO_RELATIONSHIP), new EntityClassData(InfoRelationshipMemoryEntity.class, InfoRelationshipMemoryEntity.CREATOR.getVersion(), t.f11358a)), kotlin.d.a(Integer.valueOf(MEMORY_INFO_COMMON), new EntityClassData(InfoCommonMemoryEntity.class, InfoCommonMemoryEntity.CREATOR.getVersion(), u.f11359a)), kotlin.d.a(Integer.valueOf(MEMORY_COLLECT_CONTENT), new EntityClassData(CollectContentMemoryEntity.class, CollectContentMemoryEntity.CREATOR.getVersion(), w.f11361a)), kotlin.d.a(Integer.valueOf(MEMORY_COLLECT_STORE), new EntityClassData(CollectStoreMemoryEntity.class, CollectStoreMemoryEntity.CREATOR.getVersion(), x.f11362a)), kotlin.d.a(Integer.valueOf(MEMORY_EVENT_SCHEDULE), new EntityClassData(EventScheduleMemoryEntity.class, EventScheduleMemoryEntity.CREATOR.getVersion(), y.f11363a)), kotlin.d.a(Integer.valueOf(MEMORY_EVENT_TODO), new EntityClassData(EventTodoMemoryEntity.class, EventTodoMemoryEntity.CREATOR.getVersion(), z.f11364a)), kotlin.d.a(Integer.valueOf(MEMORY_COMMON_TEXT), new EntityClassData(CommonTextMemoryEntity.class, CommonTextMemoryEntity.CREATOR.getVersion(), a0.f11325a)), kotlin.d.a(Integer.valueOf(PROACTIVE_MEMORY), new EntityClassData(ProactiveMemoryEntity.class, ProactiveMemoryEntity.CREATOR.getVersion(), b0.f11327a)), kotlin.d.a(402, new EntityClassData(ICSProtocolEntity.class, ICSProtocolEntity.CREATOR.getVersion(), c0.f11329a)), kotlin.d.a(Integer.valueOf(DOUBAO_ACCOUNT), new EntityClassData(DoubaoAccountEntity.class, DoubaoAccountEntity.CREATOR.getVersion(), d0.f11331a)), kotlin.d.a(Integer.valueOf(LIFE_LOG), new EntityClassData(LifeLogEntity.class, LifeLogEntity.CREATOR.getVersion(), e0.f11333a)), kotlin.d.a(Integer.valueOf(USER_PROFILE), new EntityClassData(UserProfileEntity.class, UserProfileEntity.CREATOR.getVersion(), f0.f11335a)), kotlin.d.a(Integer.valueOf(EVENT_TASK), new EntityClassData(EventTaskEntity.class, EventTaskEntity.CREATOR.getVersion(), h0.f11339a)), kotlin.d.a(Integer.valueOf(APP_INFO), new EntityClassData(AppInfoEntity.class, AppInfoEntity.CREATOR.getVersion(), i0.f11341a))});
    }

    private EntityType() {
    }

    @NotNull
    public final Map<Integer, EntityClassData<? extends AppEntity>> getClassMap() {
        return classMap;
    }
}
