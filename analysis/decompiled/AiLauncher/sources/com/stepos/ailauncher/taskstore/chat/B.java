package com.stepos.ailauncher.taskstore.chat;

import Z8.C1173v;
import Z8.C1174w;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.receiver.SystemDeleteBroadcastReceiver;
import com.stepos.ailauncher.taskstore.artifact.TaskArtifactPartMerger;
import com.stepos.ailauncher.taskstore.chat.B;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCard;
import com.stepos.ailauncher.taskstore.entity.TaskInfoPart;
import com.stepos.ailauncher.taskstore.entity.TaskInfoPartType;
import com.stepos.ailauncher.taskstore.widget.TextToImageCardView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001VB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\f\u0010\rJ!\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\tJ'\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J-\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J)\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u001a\u0010\u0011J\u0015\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ)\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u001f\u0010 J/\u0010\"\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\"\u0010#J7\u0010%\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010$\u001a\u00020\u000b2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b%\u0010&J'\u0010(\u001a\b\u0012\u0004\u0012\u00020'0\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b(\u0010\u0011J!\u0010)\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b)\u0010*J=\u0010,\u001a\b\u0012\u0004\u0012\u00020'0\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\f\u0010+\u001a\b\u0012\u0004\u0012\u00020'0\u000f2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b,\u0010-J!\u0010.\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b.\u0010/J#\u00100\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b0\u00101J'\u00102\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b2\u00103J!\u00104\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b4\u00105J#\u00106\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b6\u00101J\u001f\u00107\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b7\u00101J\u0017\u00108\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b8\u00109J+\u0010;\u001a\u00020\u00172\b\u0010:\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b;\u0010 J\u0017\u0010<\u001a\u0004\u0018\u00010\u00042\u0006\u0010:\u001a\u00020\u0004¢\u0006\u0004\b<\u0010=J\u0017\u0010>\u001a\u0004\u0018\u00010\u00042\u0006\u0010:\u001a\u00020\u0004¢\u0006\u0004\b>\u0010=J)\u0010?\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b?\u0010 J\u0017\u0010@\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u0004¢\u0006\u0004\b@\u0010=J\u0017\u0010A\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u0004¢\u0006\u0004\bA\u0010=J\u0017\u0010B\u001a\u0004\u0018\u00010\u00152\u0006\u0010:\u001a\u00020\u0004¢\u0006\u0004\bB\u00109J\u0017\u0010C\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0012\u001a\u00020\u0004¢\u0006\u0004\bC\u00109J\u0017\u0010D\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\bD\u00109J\u0015\u0010E\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0004¢\u0006\u0004\bE\u0010FR&\u0010I\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150H0G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010JR \u0010K\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010JR&\u0010L\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0\u000f0G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010JR \u0010M\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001b0G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010JR&\u0010O\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040N0G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010JR \u0010P\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010JR \u0010Q\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010JRT\u0010T\u001aB\u0012\f\u0012\n S*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n S*\u0004\u0018\u00010\u000b0\u000b S* \u0012\f\u0012\n S*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n S*\u0004\u0018\u00010\u000b0\u000b\u0018\u00010R0R8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010U¨\u0006W"}, d2 = {"Lcom/stepos/ailauncher/taskstore/chat/B;", "", "<init>", "()V", "", "taskId", "versionId", "Lcom/stepos/ailauncher/taskstore/chat/B$a;", "v0", "(Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/ailauncher/taskstore/chat/B$a;", "candidate", "", "w0", "(Ljava/lang/String;Lcom/stepos/ailauncher/taskstore/chat/B$a;)Z", ExifInterface.LONGITUDE_WEST, "", "I", "(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;", "toolCallId", "u0", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/ailauncher/taskstore/chat/B$a;", "Lcom/stepos/ailauncher/taskstore/widget/TextToImageCardView;", "view", "LY8/t;", "a0", "(Ljava/lang/String;Ljava/lang/String;Lcom/stepos/ailauncher/taskstore/widget/TextToImageCardView;)V", "J", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "card", "e0", "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;)V", "x", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toolCallIds", "b0", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "restorePreviousCard", "C", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoPart;", "L", "X", "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;Ljava/lang/String;)Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "parts", "x0", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)Ljava/util/List;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/lang/String;Ljava/lang/String;)V", "Q", "(Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/ailauncher/taskstore/widget/TextToImageCardView;", ExifInterface.GPS_DIRECTION_TRUE, "(Ljava/lang/String;Ljava/lang/String;Lcom/stepos/ailauncher/taskstore/widget/TextToImageCardView;)Z", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(Ljava/lang/String;Ljava/lang/String;)Z", "t0", "o0", "f0", "(Ljava/lang/String;)Lcom/stepos/ailauncher/taskstore/widget/TextToImageCardView;", SystemDeleteBroadcastReceiver.EXTRA_SESSION_KEY, "Y", "M", "(Ljava/lang/String;)Ljava/lang/String;", "O", "Z", "N", "P", "R", ExifInterface.LATITUDE_SOUTH, "w", "U", "(Ljava/lang/String;)Z", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/lang/ref/WeakReference;", "taskCardViewList", "Ljava/util/concurrent/ConcurrentHashMap;", "activeCardKeyByTaskId", "standaloneArtifacts", "lastImageCardByTaskId", "", "activeGenerationToolCalls", "toolCallIdToCardKeyMap", "sessionIdToCardKeyMap", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "kotlin.jvm.PlatformType", "abortedToolCallIds", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", Const.INTENT_KEY_APIKEY, "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class B {
    public static final B INSTANCE = new B();
    private static final ConcurrentHashMap<CardKey, WeakReference<TextToImageCardView>> taskCardViewList = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, CardKey> activeCardKeyByTaskId = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<CardKey, List<TaskInfoPart>> standaloneArtifacts = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, TaskInfoCard> lastImageCardByTaskId = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<CardKey, List<String>> activeGenerationToolCalls = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, CardKey> toolCallIdToCardKeyMap = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, CardKey> sessionIdToCardKeyMap = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap.KeySetView<String, Boolean> abortedToolCallIds = ConcurrentHashMap.newKeySet();

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\bR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0012\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/stepos/ailauncher/taskstore/chat/B$a;", "", "", "taskId", "versionId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.taskstore.chat.B$a, reason: from toString */
    public static final /* data */ class CardKey {
        private final String taskId;
        private final String versionId;

        public CardKey(String taskId, String str) {
            kotlin.jvm.internal.p.i(taskId, "taskId");
            this.taskId = taskId;
            this.versionId = str;
        }

        /* renamed from: a, reason: from getter */
        public final String getTaskId() {
            return this.taskId;
        }

        /* renamed from: b, reason: from getter */
        public final String getVersionId() {
            return this.versionId;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CardKey)) {
                return false;
            }
            CardKey cardKey = (CardKey) other;
            return kotlin.jvm.internal.p.d(this.taskId, cardKey.taskId) && kotlin.jvm.internal.p.d(this.versionId, cardKey.versionId);
        }

        public int hashCode() {
            int iHashCode = this.taskId.hashCode() * 31;
            String str = this.versionId;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "CardKey(taskId=" + this.taskId + ", versionId=" + this.versionId + ")";
        }
    }

    public static /* synthetic */ void B(B b10, String str, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        b10.A(str, str2);
    }

    public static /* synthetic */ void D(B b10, String str, String str2, boolean z10, String str3, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        if ((i10 & 4) != 0) {
            z10 = true;
        }
        if ((i10 & 8) != 0) {
            str3 = null;
        }
        b10.C(str, str2, z10, str3);
    }

    public static final boolean E(CardKey cardKey, Map.Entry it) {
        kotlin.jvm.internal.p.i(it, "it");
        return kotlin.jvm.internal.p.d(it.getValue(), cardKey);
    }

    public static final boolean F(InterfaceC5074l interfaceC5074l, Object obj) {
        return ((Boolean) interfaceC5074l.invoke(obj)).booleanValue();
    }

    public static final List G(Ref$BooleanRef ref$BooleanRef, String str, CardKey cardKey, List calls) {
        List list;
        kotlin.jvm.internal.p.i(cardKey, "<unused var>");
        kotlin.jvm.internal.p.i(calls, "calls");
        synchronized (calls) {
            ref$BooleanRef.f34815a = calls.remove(str);
            list = !calls.isEmpty() ? calls : null;
        }
        return list;
    }

    public static final List H(p9.p pVar, Object obj, Object obj2) {
        return (List) pVar.invoke(obj, obj2);
    }

    public static /* synthetic */ List K(B b10, String str, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        return b10.J(str, str2);
    }

    public static final List c0(List list, CardKey cardKey, List list2) {
        kotlin.jvm.internal.p.i(cardKey, "<unused var>");
        if (list2 == null) {
            list2 = Collections.synchronizedList(new ArrayList());
        }
        kotlin.jvm.internal.p.f(list2);
        synchronized (list2) {
            try {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    if (!list2.contains(str)) {
                        list2.add(str);
                    }
                }
                Y8.t tVar = Y8.t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return list2;
    }

    public static final List d0(p9.p pVar, Object obj, Object obj2) {
        return (List) pVar.invoke(obj, obj2);
    }

    public static final boolean g0(String str, CardKey it) {
        kotlin.jvm.internal.p.i(it, "it");
        return kotlin.jvm.internal.p.d(it.getTaskId(), str);
    }

    public static final boolean h0(InterfaceC5074l interfaceC5074l, Object obj) {
        return ((Boolean) interfaceC5074l.invoke(obj)).booleanValue();
    }

    public static final boolean i0(String str, CardKey it) {
        kotlin.jvm.internal.p.i(it, "it");
        return kotlin.jvm.internal.p.d(it.getTaskId(), str);
    }

    public static final boolean j0(InterfaceC5074l interfaceC5074l, Object obj) {
        return ((Boolean) interfaceC5074l.invoke(obj)).booleanValue();
    }

    public static final boolean k0(String str, Map.Entry it) {
        kotlin.jvm.internal.p.i(it, "it");
        return kotlin.jvm.internal.p.d(((CardKey) it.getValue()).getTaskId(), str);
    }

    public static final boolean l0(InterfaceC5074l interfaceC5074l, Object obj) {
        return ((Boolean) interfaceC5074l.invoke(obj)).booleanValue();
    }

    public static final boolean m0(String str, Map.Entry it) {
        kotlin.jvm.internal.p.i(it, "it");
        return kotlin.jvm.internal.p.d(((CardKey) it.getValue()).getTaskId(), str);
    }

    public static final boolean n0(InterfaceC5074l interfaceC5074l, Object obj) {
        return ((Boolean) interfaceC5074l.invoke(obj)).booleanValue();
    }

    public static final boolean p0(CardKey cardKey, Map.Entry it) {
        kotlin.jvm.internal.p.i(it, "it");
        return kotlin.jvm.internal.p.d(it.getValue(), cardKey);
    }

    public static final boolean q0(InterfaceC5074l interfaceC5074l, Object obj) {
        return ((Boolean) interfaceC5074l.invoke(obj)).booleanValue();
    }

    public static final boolean r0(CardKey cardKey, Map.Entry it) {
        kotlin.jvm.internal.p.i(it, "it");
        return kotlin.jvm.internal.p.d(it.getValue(), cardKey);
    }

    public static final boolean s0(InterfaceC5074l interfaceC5074l, Object obj) {
        return ((Boolean) interfaceC5074l.invoke(obj)).booleanValue();
    }

    public static final List y(String str, Ref$BooleanRef ref$BooleanRef, Ref$IntRef ref$IntRef, CardKey cardKey, List list) {
        kotlin.jvm.internal.p.i(cardKey, "<unused var>");
        if (list == null) {
            list = Collections.synchronizedList(new ArrayList());
        }
        kotlin.jvm.internal.p.f(list);
        synchronized (list) {
            try {
                if (!list.contains(str)) {
                    list.add(str);
                    ref$BooleanRef.f34815a = true;
                }
                ref$IntRef.f34818a = list.size();
                Y8.t tVar = Y8.t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [T, java.util.List] */
    public static final List y0(List list, Ref$ObjectRef ref$ObjectRef, Ref$BooleanRef ref$BooleanRef, CardKey cardKey, List list2) {
        kotlin.jvm.internal.p.i(cardKey, "<unused var>");
        List listM = list2 == null ? C1173v.m() : list2;
        TaskArtifactPartMerger.PartsMerge cVarG = TaskArtifactPartMerger.INSTANCE.g(listM, list);
        ref$ObjectRef.f34820a = cVarG.a();
        boolean zD = kotlin.jvm.internal.p.d(cVarG.b(), listM);
        ref$BooleanRef.f34815a = !zD;
        return !zD ? cVarG.b() : list2;
    }

    public static final List z(p9.p pVar, Object obj, Object obj2) {
        return (List) pVar.invoke(obj, obj2);
    }

    public static final List z0(p9.p pVar, Object obj, Object obj2) {
        return (List) pVar.invoke(obj, obj2);
    }

    public final void A(String taskId, String versionId) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        standaloneArtifacts.remove(W(taskId, versionId));
    }

    public final void C(String taskId, final String toolCallId, boolean restorePreviousCard, String versionId) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        if (toolCallId == null) {
            for (final CardKey cardKey : I(taskId, versionId)) {
                activeGenerationToolCalls.remove(cardKey);
                Set<Map.Entry<String, CardKey>> setEntrySet = toolCallIdToCardKeyMap.entrySet();
                final InterfaceC5074l interfaceC5074l = new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.chat.v
                    @Override // p9.InterfaceC5074l
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(B.E(cardKey, (Map.Entry) obj));
                    }
                };
                setEntrySet.removeIf(new Predicate() { // from class: com.stepos.ailauncher.taskstore.chat.w
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return B.F(interfaceC5074l, obj);
                    }
                });
            }
            TextToImageCardView textToImageCardViewQ = Q(taskId, versionId);
            if (textToImageCardViewQ != null) {
                textToImageCardViewQ.e0(restorePreviousCard);
                return;
            }
            return;
        }
        CardKey cardKeyU0 = u0(taskId, versionId, toolCallId);
        TextToImageCardView textToImageCardViewQ2 = Q(taskId, cardKeyU0.getVersionId());
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        ConcurrentHashMap<CardKey, List<String>> concurrentHashMap = activeGenerationToolCalls;
        final p9.p pVar = new p9.p() { // from class: com.stepos.ailauncher.taskstore.chat.x
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return B.G(ref$BooleanRef, toolCallId, (B.CardKey) obj, (List) obj2);
            }
        };
        concurrentHashMap.computeIfPresent(cardKeyU0, new BiFunction() { // from class: com.stepos.ailauncher.taskstore.chat.y
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return B.H(pVar, obj, obj2);
            }
        });
        toolCallIdToCardKeyMap.remove(toolCallId, cardKeyU0);
        if (ref$BooleanRef.f34815a) {
            if (textToImageCardViewQ2 != null) {
                textToImageCardViewQ2.A0(toolCallId);
            }
            List<CardKey> listI = I(taskId, versionId);
            if (!(listI instanceof Collection) || !listI.isEmpty()) {
                Iterator<T> it = listI.iterator();
                while (it.hasNext()) {
                    if (activeGenerationToolCalls.containsKey((CardKey) it.next())) {
                        return;
                    }
                }
            }
            if (textToImageCardViewQ2 != null) {
                textToImageCardViewQ2.e0(restorePreviousCard);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.stepos.ailauncher.taskstore.chat.B.CardKey> I(java.lang.String r3, java.lang.String r4) {
        /*
            r2 = this;
            r0 = 0
            if (r4 == 0) goto L14
            boolean r1 = La.H.x0(r4)
            if (r1 != 0) goto La
            goto Lb
        La:
            r4 = r0
        Lb:
            if (r4 == 0) goto L14
            com.stepos.ailauncher.taskstore.chat.B r1 = com.stepos.ailauncher.taskstore.chat.B.INSTANCE
            com.stepos.ailauncher.taskstore.chat.B$a r4 = r1.W(r3, r4)
            goto L15
        L14:
            r4 = r0
        L15:
            com.stepos.ailauncher.taskstore.chat.B$a r2 = r2.W(r3, r0)
            if (r4 == 0) goto L24
            com.stepos.ailauncher.taskstore.chat.B$a[] r2 = new com.stepos.ailauncher.taskstore.chat.B.CardKey[]{r4, r2}
            java.util.List r2 = Z8.C1173v.p(r2)
            return r2
        L24:
            r4 = 2
            com.stepos.ailauncher.taskstore.chat.B$a[] r4 = new com.stepos.ailauncher.taskstore.chat.B.CardKey[r4]
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.stepos.ailauncher.taskstore.chat.B$a> r0 = com.stepos.ailauncher.taskstore.chat.B.activeCardKeyByTaskId
            java.lang.Object r3 = r0.get(r3)
            r0 = 0
            r4[r0] = r3
            r3 = 1
            r4[r3] = r2
            java.util.List r2 = Z8.C1173v.r(r4)
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.List r2 = Z8.F.g0(r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.chat.B.I(java.lang.String, java.lang.String):java.util.List");
    }

    public final List<String> J(String taskId, String versionId) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        if (La.H.x0(taskId)) {
            return C1173v.m();
        }
        Iterator<CardKey> it = I(taskId, versionId).iterator();
        while (it.hasNext()) {
            List<String> list = activeGenerationToolCalls.get(it.next());
            if (list != null) {
                synchronized (list) {
                    if (!list.isEmpty()) {
                        return Z8.F.m1(list);
                    }
                    Y8.t tVar = Y8.t.f7040a;
                }
            }
        }
        return C1173v.m();
    }

    public final List<TaskInfoPart> L(String taskId, String versionId) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        List<TaskInfoPart> list = standaloneArtifacts.get(W(taskId, versionId));
        return list == null ? C1173v.m() : list;
    }

    public final String M(String sessionKey) {
        kotlin.jvm.internal.p.i(sessionKey, "sessionKey");
        CardKey cardKey = sessionIdToCardKeyMap.get(sessionKey);
        if (cardKey != null) {
            return cardKey.getTaskId();
        }
        return null;
    }

    public final String N(String toolCallId) {
        kotlin.jvm.internal.p.i(toolCallId, "toolCallId");
        CardKey cardKey = toolCallIdToCardKeyMap.get(toolCallId);
        if (cardKey != null) {
            return cardKey.getTaskId();
        }
        return null;
    }

    public final String O(String sessionKey) {
        kotlin.jvm.internal.p.i(sessionKey, "sessionKey");
        CardKey cardKey = sessionIdToCardKeyMap.get(sessionKey);
        if (cardKey != null) {
            return cardKey.getVersionId();
        }
        return null;
    }

    public final String P(String toolCallId) {
        kotlin.jvm.internal.p.i(toolCallId, "toolCallId");
        CardKey cardKey = toolCallIdToCardKeyMap.get(toolCallId);
        if (cardKey != null) {
            return cardKey.getVersionId();
        }
        return null;
    }

    public final TextToImageCardView Q(String taskId, String versionId) {
        TextToImageCardView textToImageCardView;
        kotlin.jvm.internal.p.i(taskId, "taskId");
        Iterator<CardKey> it = I(taskId, versionId).iterator();
        while (true) {
            if (!it.hasNext()) {
                CardKey cardKeyV0 = v0(taskId, versionId);
                ConcurrentHashMap<CardKey, WeakReference<TextToImageCardView>> concurrentHashMap = taskCardViewList;
                WeakReference<TextToImageCardView> weakReference = concurrentHashMap.get(cardKeyV0);
                textToImageCardView = weakReference != null ? weakReference.get() : null;
                if (textToImageCardView == null && concurrentHashMap.containsKey(cardKeyV0)) {
                    concurrentHashMap.remove(cardKeyV0);
                    ConcurrentHashMap<String, CardKey> concurrentHashMap2 = activeCardKeyByTaskId;
                    if (kotlin.jvm.internal.p.d(concurrentHashMap2.get(taskId), cardKeyV0)) {
                        concurrentHashMap2.remove(taskId);
                    }
                }
                return textToImageCardView;
            }
            CardKey next = it.next();
            ConcurrentHashMap<CardKey, WeakReference<TextToImageCardView>> concurrentHashMap3 = taskCardViewList;
            WeakReference<TextToImageCardView> weakReference2 = concurrentHashMap3.get(next);
            textToImageCardView = weakReference2 != null ? weakReference2.get() : null;
            if (textToImageCardView != null) {
                return textToImageCardView;
            }
            if (concurrentHashMap3.containsKey(next)) {
                concurrentHashMap3.remove(next);
                ConcurrentHashMap<String, CardKey> concurrentHashMap4 = activeCardKeyByTaskId;
                if (kotlin.jvm.internal.p.d(concurrentHashMap4.get(taskId), next)) {
                    concurrentHashMap4.remove(taskId);
                }
            }
        }
    }

    public final TextToImageCardView R(String sessionKey) {
        kotlin.jvm.internal.p.i(sessionKey, "sessionKey");
        CardKey cardKey = sessionIdToCardKeyMap.get(sessionKey);
        if (cardKey == null) {
            return null;
        }
        return Q(cardKey.getTaskId(), cardKey.getVersionId());
    }

    public final TextToImageCardView S(String toolCallId) {
        kotlin.jvm.internal.p.i(toolCallId, "toolCallId");
        CardKey cardKey = toolCallIdToCardKeyMap.get(toolCallId);
        if (cardKey == null) {
            return null;
        }
        return Q(cardKey.getTaskId(), cardKey.getVersionId());
    }

    public final boolean T(String taskId, String versionId, TextToImageCardView view) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        kotlin.jvm.internal.p.i(view, "view");
        CardKey cardKeyV0 = v0(taskId, versionId);
        CardKey cardKey = activeCardKeyByTaskId.get(taskId);
        if (cardKey != null) {
            cardKeyV0 = cardKey;
        }
        WeakReference<TextToImageCardView> weakReference = taskCardViewList.get(cardKeyV0);
        return (weakReference != null ? weakReference.get() : null) == view;
    }

    public final boolean U(String toolCallId) {
        kotlin.jvm.internal.p.i(toolCallId, "toolCallId");
        return !La.H.x0(toolCallId) && abortedToolCallIds.contains(toolCallId);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean V(java.lang.String r7, java.lang.String r8) {
        /*
            r6 = this;
            java.lang.String r0 = "taskId"
            kotlin.jvm.internal.p.i(r7, r0)
            r0 = 0
            r1 = 1
            if (r8 == 0) goto L1c
            boolean r2 = La.H.x0(r8)
            if (r2 == 0) goto L11
            goto L1c
        L11:
            java.util.List r2 = r6.J(r7, r8)
            int r2 = r2.size()
            if (r2 <= r1) goto L73
            goto L7f
        L1c:
            java.util.concurrent.ConcurrentHashMap<com.stepos.ailauncher.taskstore.chat.B$a, java.util.List<java.lang.String>> r2 = com.stepos.ailauncher.taskstore.chat.B.activeGenerationToolCalls
            java.util.LinkedHashMap r3 = new java.util.LinkedHashMap
            r3.<init>()
            java.util.Set r2 = r2.entrySet()
            java.util.Iterator r2 = r2.iterator()
        L2b:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L53
            java.lang.Object r4 = r2.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r5 = r4.getKey()
            com.stepos.ailauncher.taskstore.chat.B$a r5 = (com.stepos.ailauncher.taskstore.chat.B.CardKey) r5
            java.lang.String r5 = r5.getTaskId()
            boolean r5 = kotlin.jvm.internal.p.d(r5, r7)
            if (r5 == 0) goto L2b
            java.lang.Object r5 = r4.getKey()
            java.lang.Object r4 = r4.getValue()
            r3.put(r5, r4)
            goto L2b
        L53:
            java.util.Collection r2 = r3.values()
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
            r3 = r0
        L5e:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L70
            java.lang.Object r4 = r2.next()
            java.util.List r4 = (java.util.List) r4
            int r4 = r4.size()
            int r3 = r3 + r4
            goto L5e
        L70:
            if (r3 <= r1) goto L73
            goto L7f
        L73:
            com.stepos.ailauncher.taskstore.widget.TextToImageCardView r6 = r6.Q(r7, r8)
            if (r6 == 0) goto L80
            boolean r6 = r6.u0()
            if (r6 != r1) goto L80
        L7f:
            return r1
        L80:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.chat.B.V(java.lang.String, java.lang.String):boolean");
    }

    public final CardKey W(String taskId, String versionId) {
        if (versionId == null || La.H.x0(versionId)) {
            versionId = null;
        }
        return new CardKey(taskId, versionId);
    }

    public final TaskInfoCard X(TaskInfoCard card, String versionId) {
        kotlin.jvm.internal.p.i(card, "card");
        List<TaskInfoPart> listL = L(card.getTaskId(), versionId);
        return listL.isEmpty() ? card : TaskInfoCard.copy$default(card, null, null, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, null, null, null, 0L, null, null, 0L, TaskArtifactPartMerger.INSTANCE.f(card.getResult(), listL), null, null, null, null, null, null, null, -67108865, 3, null);
    }

    public final void Y(String sessionKey, String taskId, String versionId) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        if (sessionKey == null || La.H.x0(sessionKey)) {
            return;
        }
        sessionIdToCardKeyMap.put(sessionKey, W(taskId, versionId));
    }

    public final void Z(String toolCallId, String taskId, String versionId) {
        kotlin.jvm.internal.p.i(toolCallId, "toolCallId");
        kotlin.jvm.internal.p.i(taskId, "taskId");
        if (La.H.x0(toolCallId) || La.H.x0(taskId)) {
            return;
        }
        ConcurrentHashMap<String, CardKey> concurrentHashMap = toolCallIdToCardKeyMap;
        CardKey cardKey = concurrentHashMap.get(toolCallId);
        if (cardKey != null && kotlin.jvm.internal.p.d(cardKey.getTaskId(), taskId) && cardKey.getVersionId() == null) {
            return;
        }
        concurrentHashMap.put(toolCallId, W(taskId, versionId));
    }

    public final void a0(String taskId, String versionId, TextToImageCardView view) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        kotlin.jvm.internal.p.i(view, "view");
        CardKey cardKeyV0 = v0(taskId, versionId);
        taskCardViewList.put(cardKeyV0, new WeakReference<>(view));
        List<String> listJ = J(taskId, cardKeyV0.getVersionId());
        if (!listJ.isEmpty()) {
            view.v1(listJ, lastImageCardByTaskId.get(taskId));
            activeCardKeyByTaskId.put(taskId, cardKeyV0);
        } else if (w0(taskId, cardKeyV0)) {
            activeCardKeyByTaskId.put(taskId, cardKeyV0);
        } else {
            activeCardKeyByTaskId.putIfAbsent(taskId, cardKeyV0);
        }
        List<TaskInfoPart> list = standaloneArtifacts.get(cardKeyV0);
        if (list != null) {
            view.Y(list);
        }
    }

    public final void b0(String taskId, List<String> toolCallIds, String versionId) {
        TextToImageCardView textToImageCardViewQ;
        kotlin.jvm.internal.p.i(taskId, "taskId");
        kotlin.jvm.internal.p.i(toolCallIds, "toolCallIds");
        if (La.H.x0(taskId)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : toolCallIds) {
            String str = (String) obj;
            if (!La.H.x0(str) && !abortedToolCallIds.contains(str)) {
                arrayList.add(obj);
            }
        }
        final List listG0 = Z8.F.g0(arrayList);
        if (listG0.isEmpty()) {
            return;
        }
        List<String> listJ = J(taskId, versionId);
        CardKey cardKeyV0 = v0(taskId, versionId);
        if (versionId != null && !La.H.x0(versionId)) {
            activeCardKeyByTaskId.put(taskId, cardKeyV0);
        }
        ConcurrentHashMap<CardKey, List<String>> concurrentHashMap = activeGenerationToolCalls;
        final p9.p pVar = new p9.p() { // from class: com.stepos.ailauncher.taskstore.chat.r
            @Override // p9.p
            public final Object invoke(Object obj2, Object obj3) {
                return B.c0(listG0, (B.CardKey) obj2, (List) obj3);
            }
        };
        concurrentHashMap.compute(cardKeyV0, new BiFunction() { // from class: com.stepos.ailauncher.taskstore.chat.s
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj2, Object obj3) {
                return B.d0(pVar, obj2, obj3);
            }
        });
        Iterator it = listG0.iterator();
        while (it.hasNext()) {
            INSTANCE.Z((String) it.next(), taskId, versionId);
        }
        List<String> listJ2 = J(taskId, versionId);
        if (kotlin.jvm.internal.p.d(listJ2, listJ) || (textToImageCardViewQ = Q(taskId, versionId)) == null) {
            return;
        }
        TextToImageCardView.w1(textToImageCardViewQ, listJ2, null, 2, null);
    }

    public final void e0(TaskInfoCard card) {
        kotlin.jvm.internal.p.i(card, "card");
        if (La.H.x0(card.getTaskId())) {
            return;
        }
        List<TaskInfoPart> result = card.getResult();
        if (result == null) {
            result = C1173v.m();
        }
        List<TaskInfoPart> list = result;
        if ((list instanceof Collection) && list.isEmpty()) {
            return;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (((TaskInfoPart) it.next()).getType() == TaskInfoPartType.IMAGE) {
                lastImageCardByTaskId.put(card.getTaskId(), card);
                return;
            }
        }
    }

    public final TextToImageCardView f0(final String taskId) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        Set<CardKey> setKeySet = activeGenerationToolCalls.keySet();
        final InterfaceC5074l interfaceC5074l = new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.chat.i
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(B.g0(taskId, (B.CardKey) obj));
            }
        };
        setKeySet.removeIf(new Predicate() { // from class: com.stepos.ailauncher.taskstore.chat.j
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return B.h0(interfaceC5074l, obj);
            }
        });
        Set<CardKey> setKeySet2 = standaloneArtifacts.keySet();
        final InterfaceC5074l interfaceC5074l2 = new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.chat.k
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(B.i0(taskId, (B.CardKey) obj));
            }
        };
        setKeySet2.removeIf(new Predicate() { // from class: com.stepos.ailauncher.taskstore.chat.l
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return B.j0(interfaceC5074l2, obj);
            }
        });
        lastImageCardByTaskId.remove(taskId);
        Set<Map.Entry<String, CardKey>> setEntrySet = sessionIdToCardKeyMap.entrySet();
        final InterfaceC5074l interfaceC5074l3 = new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.chat.m
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(B.k0(taskId, (Map.Entry) obj));
            }
        };
        setEntrySet.removeIf(new Predicate() { // from class: com.stepos.ailauncher.taskstore.chat.n
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return B.l0(interfaceC5074l3, obj);
            }
        });
        Set<Map.Entry<String, CardKey>> setEntrySet2 = toolCallIdToCardKeyMap.entrySet();
        final InterfaceC5074l interfaceC5074l4 = new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.chat.o
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(B.m0(taskId, (Map.Entry) obj));
            }
        };
        setEntrySet2.removeIf(new Predicate() { // from class: com.stepos.ailauncher.taskstore.chat.p
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return B.n0(interfaceC5074l4, obj);
            }
        });
        activeCardKeyByTaskId.remove(taskId);
        Set<Map.Entry<CardKey, WeakReference<TextToImageCardView>>> setEntrySet3 = taskCardViewList.entrySet();
        kotlin.jvm.internal.p.h(setEntrySet3, "<get-entries>(...)");
        ArrayList arrayList = new ArrayList();
        for (Object obj : setEntrySet3) {
            if (kotlin.jvm.internal.p.d(((CardKey) ((Map.Entry) obj).getKey()).getTaskId(), taskId)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            WeakReference<TextToImageCardView> weakReferenceRemove = taskCardViewList.remove(((Map.Entry) it.next()).getKey());
            TextToImageCardView textToImageCardView = weakReferenceRemove != null ? weakReferenceRemove.get() : null;
            if (textToImageCardView != null) {
                arrayList2.add(textToImageCardView);
            }
        }
        return (TextToImageCardView) Z8.F.s0(arrayList2);
    }

    public final TextToImageCardView o0(String taskId, String versionId) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        kotlin.jvm.internal.p.i(versionId, "versionId");
        final CardKey cardKeyW = W(taskId, versionId);
        activeGenerationToolCalls.remove(cardKeyW);
        standaloneArtifacts.remove(cardKeyW);
        lastImageCardByTaskId.remove(taskId);
        Set<Map.Entry<String, CardKey>> setEntrySet = sessionIdToCardKeyMap.entrySet();
        final InterfaceC5074l interfaceC5074l = new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.chat.z
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(B.p0(cardKeyW, (Map.Entry) obj));
            }
        };
        setEntrySet.removeIf(new Predicate() { // from class: com.stepos.ailauncher.taskstore.chat.A
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return B.q0(interfaceC5074l, obj);
            }
        });
        Set<Map.Entry<String, CardKey>> setEntrySet2 = toolCallIdToCardKeyMap.entrySet();
        final InterfaceC5074l interfaceC5074l2 = new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.chat.g
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(B.r0(cardKeyW, (Map.Entry) obj));
            }
        };
        setEntrySet2.removeIf(new Predicate() { // from class: com.stepos.ailauncher.taskstore.chat.h
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return B.s0(interfaceC5074l2, obj);
            }
        });
        ConcurrentHashMap<String, CardKey> concurrentHashMap = activeCardKeyByTaskId;
        if (kotlin.jvm.internal.p.d(concurrentHashMap.get(taskId), cardKeyW)) {
            concurrentHashMap.remove(taskId);
        }
        WeakReference<TextToImageCardView> weakReferenceRemove = taskCardViewList.remove(cardKeyW);
        if (weakReferenceRemove != null) {
            return weakReferenceRemove.get();
        }
        return null;
    }

    public final TextToImageCardView t0(String taskId, String versionId) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        CardKey cardKeyV0 = v0(taskId, versionId);
        ConcurrentHashMap<String, CardKey> concurrentHashMap = activeCardKeyByTaskId;
        if (kotlin.jvm.internal.p.d(concurrentHashMap.get(taskId), cardKeyV0)) {
            concurrentHashMap.remove(taskId);
        }
        WeakReference<TextToImageCardView> weakReferenceRemove = taskCardViewList.remove(cardKeyV0);
        if (weakReferenceRemove != null) {
            return weakReferenceRemove.get();
        }
        return null;
    }

    public final CardKey u0(String taskId, String versionId, String toolCallId) {
        Object next;
        Object next2;
        boolean zContains;
        CardKey cardKey;
        Object obj = null;
        if (toolCallId != null && (cardKey = toolCallIdToCardKeyMap.get(toolCallId)) != null) {
            if (!kotlin.jvm.internal.p.d(cardKey.getTaskId(), taskId)) {
                cardKey = null;
            }
            if (cardKey != null) {
                return cardKey;
            }
        }
        List<CardKey> listI = I(taskId, versionId);
        if (toolCallId != null) {
            Iterator<T> it = listI.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next2 = null;
                    break;
                }
                next2 = it.next();
                List<String> list = activeGenerationToolCalls.get((CardKey) next2);
                if (list != null) {
                    synchronized (list) {
                        zContains = list.contains(toolCallId);
                    }
                    if (zContains) {
                        break;
                    }
                }
            }
            CardKey cardKey2 = (CardKey) next2;
            if (cardKey2 != null) {
                return cardKey2;
            }
        }
        List<CardKey> list2 = listI;
        Iterator<T> it2 = list2.iterator();
        while (true) {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
            if (activeGenerationToolCalls.containsKey((CardKey) next)) {
                break;
            }
        }
        CardKey cardKey3 = (CardKey) next;
        if (cardKey3 != null) {
            return cardKey3;
        }
        Iterator<T> it3 = list2.iterator();
        while (true) {
            if (!it3.hasNext()) {
                break;
            }
            Object next3 = it3.next();
            WeakReference<TextToImageCardView> weakReference = taskCardViewList.get((CardKey) next3);
            if ((weakReference != null ? weakReference.get() : null) != null) {
                obj = next3;
                break;
            }
        }
        CardKey cardKey4 = (CardKey) obj;
        return cardKey4 != null ? cardKey4 : (CardKey) Z8.F.q0(listI);
    }

    public final CardKey v0(String taskId, String versionId) {
        CardKey cardKeyW = W(taskId, versionId);
        if (versionId != null && !La.H.x0(versionId)) {
            return cardKeyW;
        }
        Set<CardKey> setKeySet = activeGenerationToolCalls.keySet();
        kotlin.jvm.internal.p.h(setKeySet, "<get-keys>(...)");
        ArrayList arrayList = new ArrayList();
        for (Object obj : setKeySet) {
            if (kotlin.jvm.internal.p.d(((CardKey) obj).getTaskId(), taskId)) {
                arrayList.add(obj);
            }
        }
        List listG0 = Z8.F.g0(arrayList);
        if (listG0.size() == 1) {
            return (CardKey) Z8.F.X0(listG0);
        }
        CardKey cardKey = activeCardKeyByTaskId.get(taskId);
        return cardKey == null ? cardKeyW : cardKey;
    }

    public final TextToImageCardView w(String taskId) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        if (La.H.x0(taskId)) {
            return null;
        }
        Iterator it = K(this, taskId, null, 2, null).iterator();
        while (it.hasNext()) {
            abortedToolCallIds.add((String) it.next());
        }
        Set<Map.Entry<String, CardKey>> setEntrySet = toolCallIdToCardKeyMap.entrySet();
        kotlin.jvm.internal.p.h(setEntrySet, "<get-entries>(...)");
        ArrayList arrayList = new ArrayList();
        for (Object obj : setEntrySet) {
            if (kotlin.jvm.internal.p.d(((CardKey) ((Map.Entry) obj).getValue()).getTaskId(), taskId)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(C1174w.x(arrayList, 10));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add((String) ((Map.Entry) it2.next()).getKey());
        }
        Iterator it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            abortedToolCallIds.add((String) it3.next());
        }
        return f0(taskId);
    }

    public final boolean w0(String taskId, CardKey candidate) {
        CardKey cardKey = activeCardKeyByTaskId.get(taskId);
        if (cardKey == null) {
            return true;
        }
        if (kotlin.jvm.internal.p.d(cardKey, candidate)) {
            return false;
        }
        String versionId = cardKey.getVersionId();
        Long lY = versionId != null ? La.C.y(versionId) : null;
        String versionId2 = candidate.getVersionId();
        Long lY2 = versionId2 != null ? La.C.y(versionId2) : null;
        return (lY == null || lY2 == null || lY2.longValue() <= lY.longValue()) ? false : true;
    }

    public final void x(String taskId, final String toolCallId, String versionId) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        kotlin.jvm.internal.p.i(toolCallId, "toolCallId");
        if (La.H.x0(taskId) || La.H.x0(toolCallId) || abortedToolCallIds.contains(toolCallId)) {
            return;
        }
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        final Ref$IntRef ref$IntRef = new Ref$IntRef();
        CardKey cardKeyV0 = v0(taskId, versionId);
        ConcurrentHashMap<CardKey, List<String>> concurrentHashMap = activeGenerationToolCalls;
        final p9.p pVar = new p9.p() { // from class: com.stepos.ailauncher.taskstore.chat.f
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return B.y(toolCallId, ref$BooleanRef, ref$IntRef, (B.CardKey) obj, (List) obj2);
            }
        };
        concurrentHashMap.compute(cardKeyV0, new BiFunction() { // from class: com.stepos.ailauncher.taskstore.chat.q
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return B.z(pVar, obj, obj2);
            }
        });
        if (ref$BooleanRef.f34815a) {
            Z(toolCallId, taskId, versionId);
            TextToImageCardView textToImageCardViewQ = Q(taskId, versionId);
            if (textToImageCardViewQ != null) {
                textToImageCardViewQ.W(toolCallId, ref$IntRef.f34818a);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [T, java.util.List] */
    public final List<TaskInfoPart> x0(String taskId, String toolCallId, final List<TaskInfoPart> parts, String versionId) {
        List<TaskInfoPart> list;
        TextToImageCardView textToImageCardViewQ;
        kotlin.jvm.internal.p.i(taskId, "taskId");
        kotlin.jvm.internal.p.i(toolCallId, "toolCallId");
        kotlin.jvm.internal.p.i(parts, "parts");
        if (La.H.x0(taskId) || parts.isEmpty()) {
            return C1173v.m();
        }
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.f34820a = C1173v.m();
        CardKey cardKeyW = W(taskId, versionId);
        ConcurrentHashMap<CardKey, List<TaskInfoPart>> concurrentHashMap = standaloneArtifacts;
        final p9.p pVar = new p9.p() { // from class: com.stepos.ailauncher.taskstore.chat.t
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return B.y0(parts, ref$ObjectRef, ref$BooleanRef, (B.CardKey) obj, (List) obj2);
            }
        };
        concurrentHashMap.compute(cardKeyW, new BiFunction() { // from class: com.stepos.ailauncher.taskstore.chat.u
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return B.z0(pVar, obj, obj2);
            }
        });
        C(taskId, toolCallId, false, versionId);
        if (ref$BooleanRef.f34815a && (list = concurrentHashMap.get(cardKeyW)) != null && (textToImageCardViewQ = INSTANCE.Q(taskId, versionId)) != null) {
            textToImageCardViewQ.Y(list);
        }
        return (List) ref$ObjectRef.f34820a;
    }
}
