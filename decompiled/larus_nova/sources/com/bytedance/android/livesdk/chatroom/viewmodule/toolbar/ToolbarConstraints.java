package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdk.config.e81;
import com.bytedance.android.livesdk.utils.r6;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\b\u0010\tR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/ToolbarConstraints;", "", "", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/ToolbarSlot;", "slots", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "<init>", "()V", "Companion", "liveroom-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ToolbarConstraints {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<String, WeakReference<ToolbarConstraints>> f115726e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f115727f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, ToolbarSlot> f115728a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DataCenter f115729b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, h2> f115730c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<ToolbarSlot> f115731d;

    @SerializedName("slots")
    private final List<ToolbarSlot> slots;

    public static final class Companion {
        public Companion() {
        }

        public static void a(ToolbarConstraints r110) {
            Map<String, h2> r100 = r110.f115730c;
            Map<String, ToolbarSlot> r101 = r110.f115728a;
            Iterator<T> r102 = r110.a().iterator();
        L4:
            if (r102.hasNext() == false) goto L22;
            ToolbarSlot r103 = (ToolbarSlot) r102.next();
            if (r103.c() == true) goto L7;
            Iterator<T> r104 = r103.d().iterator();
            int r105 = 0;
        L10:
            if (r104.hasNext() == false) goto L4;
            Object r106 = r104.next();
            int r107 = r105 + 1;
            if (r105 >= 0) goto L14;
            CollectionsKt.throwIndexOverflow();
        L14:
            int r108 = r103.d().size() - r105;
            Iterator r109 = ((List) r106).iterator();
            int r111 = 0;
        L16:
            if (r109.hasNext() == false) goto L21;
            Object r112 = r109.next();
            int r113 = r111 + 1;
            if (r111 >= 0) goto L20;
            CollectionsKt.throwIndexOverflow();
        L20:
            String r114 = (String) r112;
            r100.put(r114, new h2.a((r103.getPriority() << 16) | (r108 << 8)));
            r101.put(r114, r103);
            r111 = r113;
            goto L16
        L21:
            r105 = r107;
            goto L10
        L7:
            ((ArrayList) r110.f115731d).add(r103);
            goto L4
        }

        public static void b(final ToolbarConstraints r110) {
            int r100 = u3.f116787a;
            StringBuilder r101 = new StringBuilder("Constraint AB, sort: ");
            SettingKey<Integer> r102 = e81.f120099e;
            r101.append(r102.getValue());
            u3.a(r101.toString());
            Integer r103 = r102.getValue();
            if (r103 == null) goto L9;
            if (r103.intValue() != 0) goto L9;
            return;
        L9:
            if (r103 != null) goto L12;
        L14:
            if (r103 != null) goto L17;
            return;
        L17:
            if (r103.intValue() != 2) goto L74;
            final int r104 = d4.a((h2) ((LinkedHashMap) r110.f115730c).get(ToolbarButton.GIFT.name()));
            ToolbarSlot r105 = (ToolbarSlot) ((LinkedHashMap) r110.f115728a).get(ToolbarButton.FAST_GIFT.name());
            int r106 = r6.f159155a;
            if (LiveInfraSettingKeys.LIVE_TOOLBAR_RAISE_PRIORITY_FAST_GIFT_SLOT.getValue().booleanValue() != true) goto L29;
            if (r105 == null) goto L29;
            List<List<String>> r107 = r105.d();
            if (r107 == null) goto L29;
            List r108 = CollectionsKt.flatten(r107);
            if (r108 == null) goto L29;
            Iterator r109 = r108.iterator();
        L27:
            if (r109.hasNext() == false) goto L29;
            String r111 = (String) r109.next();
            final int r112 = d4.a((h2) ((LinkedHashMap) r110.f115730c).get(r111));
            final int r113 = (2147418112 & r104) + (r112 & 65280);
            r110.f115730c.put(r111, new h2.b(new ToolbarConstraints$Companion$transformConstraintWithSortingAb$$inlined$forEach$lambda$1(r113, r112, r110, r104)));
        L29:
            ToolbarSlot r114 = (ToolbarSlot) ((LinkedHashMap) r110.f115728a).get(ToolbarButton.INTERACTION.name());
            if (r114 == null) goto L39;
            List<List<String>> r115 = r114.d();
            if (r115 == null) goto L39;
            List r116 = CollectionsKt.flatten(r115);
            if (r116 == null) goto L39;
            Iterator r117 = r116.iterator();
        L37:
            if (r117.hasNext() == false) goto L39;
            String r118 = (String) r117.next();
            final int r119 = d4.a((h2) ((LinkedHashMap) r110.f115730c).get(r118));
            final int r120 = (r119 & 65280) + 0;
            r110.f115730c.put(r118, new h2.b(new ToolbarConstraints$Companion$transformConstraintWithSortingAb$$inlined$forEach$lambda$2(r119, r120, r110)));
        L39:
            Iterator<T> r121 = r110.a().iterator();
        L40:
            Object r122 = null;
            if (r121.hasNext() == false) goto L45;
            Object r123 = r121.next();
            if (((ToolbarSlot) r123).c() == false) goto L40;
        L46:
            ToolbarSlot r124 = (ToolbarSlot) r123;
            if (r124 != null) goto L49;
            return;
        L49:
            Iterator<T> r125 = r124.d().iterator();
        L51:
            if (r125.hasNext() == false) goto L60;
            Object r126 = r125.next();
            List r127 = (List) r126;
            if (r127.size() == 1) goto L55;
        L57:
            boolean r128 = false;
        L58:
            if (r128 == false) goto L51;
            r122 = r126;
            goto L60
        L55:
            if (Intrinsics.areEqual((String) CollectionsKt.first(r127), ToolbarButton.INTERACTION_ROOM.name()) == false) goto L57;
            r128 = true;
        L60:
            List r129 = (List) r122;
            if (r129 == null) goto L75;
            r124.d().remove(r129);
            return;
        L75:
            return;
        L45:
            r123 = null;
            goto L46
        L74:
            return;
        L12:
            if (r103.intValue() != 1) goto L14;
        }
    }

    static {
        f115727f = new Companion();
        f115726e = new LinkedHashMap();
    }

    public ToolbarConstraints() {
        this.slots = CollectionsKt.emptyList();
        this.f115728a = new LinkedHashMap();
        this.f115730c = new LinkedHashMap();
        this.f115731d = new ArrayList();
    }

    public List<ToolbarSlot> a() {
        return this.slots;
    }
}
