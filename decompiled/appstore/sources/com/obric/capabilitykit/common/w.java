package com.obric.capabilitykit.common;

import com.obric.capabilitykit.entity.app.AlarmEntity;
import com.obric.capabilitykit.entity.app.AlbumEntity;
import com.obric.capabilitykit.entity.app.AppInfoEntity;
import com.obric.capabilitykit.entity.app.AuditoryRecordingEntity;
import com.obric.capabilitykit.entity.app.BrowserBookmarkEntity;
import com.obric.capabilitykit.entity.app.CallHistoryEntity;
import com.obric.capabilitykit.entity.app.CloudDocumentEntity;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.app.CountdownEntity;
import com.obric.capabilitykit.entity.app.DoubaoAccountEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.app.GroupChatEntity;
import com.obric.capabilitykit.entity.app.ICSProtocolEntity;
import com.obric.capabilitykit.entity.app.LifeLogEntity;
import com.obric.capabilitykit.entity.app.MessageEntity;
import com.obric.capabilitykit.entity.app.NoteEntity;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import com.obric.capabilitykit.entity.app.PhotoFaceEntity;
import com.obric.capabilitykit.entity.app.ProactiveMemoryEntity;
import com.obric.capabilitykit.entity.app.RecordingEntity;
import com.obric.capabilitykit.entity.app.ScheduleEntity;
import com.obric.capabilitykit.entity.app.StockEntity;
import com.obric.capabilitykit.entity.app.UserProfileEntity;
import com.obric.capabilitykit.entity.app.WebsiteEntity;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/obric/capabilitykit/entity/app/EntityHashCodeGeneratorMapping;", "", "()V", "hashCodeMapping", "", "", "Lcom/obric/capabilitykit/entity/app/IEntityHashCodeGenerator;", "getHashCodeMapping$capabilitykitcommon_release", "()Ljava/util/Map;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final w f11308a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Map<String, b0> f11309b = null;

    static {
        f11308a = new w();
        LinkedHashMap r10 = new LinkedHashMap();
        f11309b = r10;
        String r11 = ContactEntity.class.getName();
        kotlin.jvm.internal.q.f(r11, "ContactEntity::class.java.name");
        r10.put(r11, t.f11305a);
        String r12 = AppInfoEntity.class.getName();
        kotlin.jvm.internal.q.f(r12, "AppInfoEntity::class.java.name");
        r10.put(r12, m.f11295a);
        String r13 = RecordingEntity.class.getName();
        kotlin.jvm.internal.q.f(r13, "RecordingEntity::class.java.name");
        r10.put(r13, i0.f11286a);
        String r14 = LifeLogEntity.class.getName();
        kotlin.jvm.internal.q.f(r14, "LifeLogEntity::class.java.name");
        r10.put(r14, c0.f11264a);
        String r15 = AuditoryRecordingEntity.class.getName();
        kotlin.jvm.internal.q.f(r15, "AuditoryRecordingEntity::class.java.name");
        r10.put(r15, n.f11297a);
        String r16 = ScheduleEntity.class.getName();
        kotlin.jvm.internal.q.f(r16, "ScheduleEntity::class.java.name");
        r10.put(r16, j0.f11290a);
        String r17 = ICSProtocolEntity.class.getName();
        kotlin.jvm.internal.q.f(r17, "ICSProtocolEntity::class.java.name");
        r10.put(r17, a0.f11258a);
        String r18 = NoteEntity.class.getName();
        kotlin.jvm.internal.q.f(r18, "NoteEntity::class.java.name");
        r10.put(r18, e0.f11273a);
        String r19 = BrowserBookmarkEntity.class.getName();
        kotlin.jvm.internal.q.f(r19, "BrowserBookmarkEntity::class.java.name");
        r10.put(r19, o.f11298a);
        String r20 = ProactiveMemoryEntity.class.getName();
        kotlin.jvm.internal.q.f(r20, "ProactiveMemoryEntity::class.java.name");
        r10.put(r20, h0.f11285a);
        String r21 = DoubaoAccountEntity.class.getName();
        kotlin.jvm.internal.q.f(r21, "DoubaoAccountEntity::class.java.name");
        r10.put(r21, v.f11307a);
        String r22 = CloudDocumentEntity.class.getName();
        kotlin.jvm.internal.q.f(r22, "CloudDocumentEntity::class.java.name");
        r10.put(r22, q.f11300a);
        String r23 = AlbumEntity.class.getName();
        kotlin.jvm.internal.q.f(r23, "AlbumEntity::class.java.name");
        r10.put(r23, k.f11291a);
        String r24 = GroupChatEntity.class.getName();
        kotlin.jvm.internal.q.f(r24, "GroupChatEntity::class.java.name");
        r10.put(r24, z.f11313a);
        String r25 = StockEntity.class.getName();
        kotlin.jvm.internal.q.f(r25, "StockEntity::class.java.name");
        r10.put(r25, k0.f11292a);
        String r26 = PhotoEntity.class.getName();
        kotlin.jvm.internal.q.f(r26, "PhotoEntity::class.java.name");
        r10.put(r26, f0.f11275a);
        String r27 = AlarmEntity.class.getName();
        kotlin.jvm.internal.q.f(r27, "AlarmEntity::class.java.name");
        r10.put(r27, j.f11289a);
        String r28 = FileEntity.class.getName();
        kotlin.jvm.internal.q.f(r28, "FileEntity::class.java.name");
        r10.put(r28, y.f11312a);
        String r29 = WebsiteEntity.class.getName();
        kotlin.jvm.internal.q.f(r29, "WebsiteEntity::class.java.name");
        r10.put(r29, m0.f11296a);
        String r30 = MessageEntity.class.getName();
        kotlin.jvm.internal.q.f(r30, "MessageEntity::class.java.name");
        r10.put(r30, d0.f11272a);
        String r31 = CountdownEntity.class.getName();
        kotlin.jvm.internal.q.f(r31, "CountdownEntity::class.java.name");
        r10.put(r31, u.f11306a);
        String r32 = UserProfileEntity.class.getName();
        kotlin.jvm.internal.q.f(r32, "UserProfileEntity::class.java.name");
        r10.put(r32, l0.f11294a);
        String r33 = PhotoFaceEntity.class.getName();
        kotlin.jvm.internal.q.f(r33, "PhotoFaceEntity::class.java.name");
        r10.put(r33, g0.f11284a);
        String r34 = CallHistoryEntity.class.getName();
        kotlin.jvm.internal.q.f(r34, "CallHistoryEntity::class.java.name");
        r10.put(r34, p.f11299a);
    }

    private w() {
    }

    @NotNull
    public final Map<String, b0> a() {
        return f11309b;
    }
}
