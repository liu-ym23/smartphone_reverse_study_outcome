package com.bytedance.android.live.network.impl.interceptor;

import com.bytedance.android.live.base.model.NameValuePair;
import com.bytedance.android.livesdkapi.util.url.BasicNameValuePair;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class RequestInterceptorConstants {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, String> f83856a = null;

    static {
        f83856a = MapsKt.mapOf(new Pair[]{new Pair("anchor_id", "anchor_open_id"), new Pair(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, "to_user_open_id"), new Pair("from_user_id", "from_user_open_id"), new Pair("user_id", "open_user_id"), new Pair("rival_user_id", "rival_open_id"), new Pair("rival_user_id_str", "rival_open_id_str"), new Pair("invite_user_id", "invite_open_id"), new Pair("source_user_id", "source_user_open_id"), new Pair("invite_uid", "invite_open_id"), new Pair("control_user_id", "control_open_id"), new Pair("mvp_uid", "mvp_open_id"), new Pair("loser_id", "loser_open_id"), new Pair("singer_id", "singer_open_id"), new Pair("mock_user_id", "mock_open_id"), new Pair("lucky_user_id", "lucky_user_open_id"), new Pair("target_uid", "target_open_id")});
    }

    @JvmStatic
    public static final JsonObject a(JsonObject r100) {
        Intrinsics.checkNotNullParameter(r100, "inArgs");
        final JsonObject r101 = r100.deepCopy();
        final Set<String> r102 = r100.keySet();
        Iterator<T> r103 = r100.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        final Map.Entry r104 = (Map.Entry) r103.next();
        e(r102, (String) r104.getKey(), new RequestInterceptorConstants$appendFuseParams$$inlined$forEach$lambda$1(r104, r102, r101));
        goto L4
    L6:
        return r101;
    }

    @JvmStatic
    public static final List<NameValuePair> b(List<? extends NameValuePair> r100) {
        Intrinsics.checkNotNullParameter(r100, "inArgs");
        final ArrayList r101 = new ArrayList();
        r101.addAll(r100);
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r102.add(((NameValuePair) r103.next()).getName());
        goto L4
    L6:
        Set r104 = CollectionsKt.toSet(r102);
        Iterator r105 = ((ArrayList) r100).iterator();
    L8:
        if (r105.hasNext() == false) goto L10;
        final NameValuePair r106 = (NameValuePair) r105.next();
        e(r104, r106.getName(), new RequestInterceptorConstants$appendFuseParams$1(r101, r106));
        goto L8
    L10:
        return r101;
    }

    @JvmStatic
    public static final JSONObject c(final JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "inArgs");
        final JSONObject r101 = new JSONObject();
        final Set r102 = SequencesKt.toSet(SequencesKt.asSequence(r100.keys()));
        Iterator<String> r103 = r100.keys();
    L4:
        if (r103.hasNext() == false) goto L6;
        String r104 = r103.next();
        final Object r105 = r100.get(r104);
        r101.put(r104, r105);
        e(r102, r104, new RequestInterceptorConstants$appendFuseParams$$inlined$forEach$lambda$2(r105, r100, r101, r102));
        goto L4
    L6:
        return r101;
    }

    @JvmStatic
    public static final List<BasicNameValuePair> d(List<? extends BasicNameValuePair> r100) {
        Intrinsics.checkNotNullParameter(r100, "inArgs");
        final ArrayList r101 = new ArrayList();
        r101.addAll(r100);
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r102.add(((BasicNameValuePair) r103.next()).getName());
        goto L4
    L6:
        Set r104 = CollectionsKt.toSet(r102);
        Iterator r105 = ((ArrayList) r100).iterator();
    L8:
        if (r105.hasNext() == false) goto L10;
        final BasicNameValuePair r106 = (BasicNameValuePair) r105.next();
        e(r104, r106.getName(), new RequestInterceptorConstants$appendFuseParamsBasic$1(r101, r106));
        goto L8
    L10:
        return r101;
    }

    public static void e(Set r100, String r101, Function2 r102) {
        Map<String, String> r103 = f83856a;
        if (r103.containsKey(r101) == false) goto L10;
        String r104 = r103.get(r101);
        if (r104 != null) goto L7;
        return;
    L7:
        if (r100.contains(r104) == true) goto L12;
        r102.invoke(r101, r104);
        return;
    L12:
        return;
    }
}
