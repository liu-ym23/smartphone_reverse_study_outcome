package com.bytedance.android.live.broadcast.api.model;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.gson.BooleanTypeAdapter;
import com.bytedance.android.live.gson.FeedItemTypeAdapter;
import com.bytedance.android.live.gson.RoomTypeAdapter;
import com.bytedance.android.livesdkapi.config.FastStartLiveConfig;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\bj\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\bF\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 ¦\u00022\u00020\u0001:\u0002§\u0002B\t¢\u0006\u0006\b¤\u0002\u0010¥\u0002J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007J\u0006\u0010\t\u001a\u00020\u0002J\u0010\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0000R\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00058\u0006@BX\u0087\u000e¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017\"\u0004\b\u001a\u0010\u001bR$\u0010\u001c\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0015\u001a\u0004\b\u001d\u0010\u0017\"\u0004\b\u001e\u0010\u001bR$\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010&\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010!\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%R$\u0010)\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010!\u001a\u0004\b*\u0010#\"\u0004\b+\u0010%R$\u0010,\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010\u0015\u001a\u0004\b-\u0010\u0017\"\u0004\b.\u0010\u001bR$\u0010/\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u0010\u0015\u001a\u0004\b0\u0010\u0017\"\u0004\b1\u0010\u001bR$\u00102\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u0010!\u001a\u0004\b3\u0010#\"\u0004\b4\u0010%R$\u00105\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R$\u0010;\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b;\u0010\u0015\u001a\u0004\b<\u0010\u0017\"\u0004\b=\u0010\u001bR$\u0010>\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b>\u0010\u0015\u001a\u0004\b?\u0010\u0017\"\u0004\b@\u0010\u001bR$\u0010A\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bA\u0010\u0015\u001a\u0004\bB\u0010\u0017\"\u0004\bC\u0010\u001bR$\u0010D\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bD\u0010\u0015\u001a\u0004\bE\u0010\u0017\"\u0004\bF\u0010\u001bR$\u0010G\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bG\u00106\u001a\u0004\bH\u00108\"\u0004\bI\u0010:R$\u0010J\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bJ\u0010\u0015\u001a\u0004\bK\u0010\u0017\"\u0004\bL\u0010\u001bR$\u0010M\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bM\u00106\u001a\u0004\bN\u00108\"\u0004\bO\u0010:R$\u0010P\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bP\u00106\u001a\u0004\bQ\u00108\"\u0004\bR\u0010:R$\u0010S\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bS\u00106\u001a\u0004\bT\u00108\"\u0004\bU\u0010:R$\u0010V\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bV\u0010\u0015\u001a\u0004\bW\u0010\u0017\"\u0004\bX\u0010\u001bR$\u0010Y\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bY\u0010\u0015\u001a\u0004\bZ\u0010\u0017\"\u0004\b[\u0010\u001bR$\u0010\\\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\\\u0010\u0015\u001a\u0004\b]\u0010\u0017\"\u0004\b^\u0010\u001bR$\u0010_\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b_\u0010\u0015\u001a\u0004\b`\u0010\u0017\"\u0004\ba\u0010\u001bR$\u0010b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bb\u00106\u001a\u0004\bb\u00108\"\u0004\bc\u0010:R$\u0010d\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bd\u0010\u0015\u001a\u0004\be\u0010\u0017\"\u0004\bf\u0010\u001bR$\u0010g\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bg\u0010!\u001a\u0004\bh\u0010#\"\u0004\bi\u0010%R$\u0010j\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bj\u00106\u001a\u0004\bj\u00108\"\u0004\bk\u0010:R$\u0010l\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bl\u0010\u0015\u001a\u0004\bm\u0010\u0017\"\u0004\bn\u0010\u001bR$\u0010o\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bo\u0010\u0015\u001a\u0004\bp\u0010\u0017\"\u0004\bq\u0010\u001bR$\u0010r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\br\u0010\u0015\u001a\u0004\bs\u0010\u0017\"\u0004\bt\u0010\u001bR$\u0010u\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bu\u0010\u0015\u001a\u0004\bv\u0010\u0017\"\u0004\bw\u0010\u001bR$\u0010x\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bx\u0010\u0015\u001a\u0004\by\u0010\u0017\"\u0004\bz\u0010\u001bR$\u0010{\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b{\u0010!\u001a\u0004\b|\u0010#\"\u0004\b}\u0010%R%\u0010~\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0013\n\u0004\b~\u0010\u0015\u001a\u0004\b\u007f\u0010\u0017\"\u0005\b\u0080\u0001\u0010\u001bR(\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0081\u0001\u00106\u001a\u0005\b\u0082\u0001\u00108\"\u0005\b\u0083\u0001\u0010:R(\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0084\u0001\u0010\u0015\u001a\u0005\b\u0085\u0001\u0010\u0017\"\u0005\b\u0086\u0001\u0010\u001bR(\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0087\u0001\u0010\u0015\u001a\u0005\b\u0088\u0001\u0010\u0017\"\u0005\b\u0089\u0001\u0010\u001bR!\u0010\u008f\u0001\u001a\u00030\u008a\u00018FX\u0086\u0084\u0002¢\u0006\u0010\n\u0006\b\u008b\u0001\u0010\u008c\u0001\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001R(\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0090\u0001\u0010\u0015\u001a\u0005\b\u0091\u0001\u0010\u0017\"\u0005\b\u0092\u0001\u0010\u001bR(\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0093\u0001\u0010\u0015\u001a\u0005\b\u0094\u0001\u0010\u0017\"\u0005\b\u0095\u0001\u0010\u001bR(\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0096\u0001\u0010\u0015\u001a\u0005\b\u0097\u0001\u0010\u0017\"\u0005\b\u0098\u0001\u0010\u001bR(\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0099\u0001\u0010\u0015\u001a\u0005\b\u009a\u0001\u0010\u0017\"\u0005\b\u009b\u0001\u0010\u001bR?\u0010\u009e\u0001\u001a\u0018\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u009c\u0001j\u000b\u0012\u0004\u0012\u00020\u001f\u0018\u0001`\u009d\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u009e\u0001\u0010\u009f\u0001\u001a\u0006\b \u0001\u0010¡\u0001\"\u0006\b¢\u0001\u0010£\u0001R(\u0010¤\u0001\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b¤\u0001\u0010!\u001a\u0005\b¥\u0001\u0010#\"\u0005\b¦\u0001\u0010%R(\u0010§\u0001\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b§\u0001\u0010\u0015\u001a\u0005\b¨\u0001\u0010\u0017\"\u0005\b©\u0001\u0010\u001bR(\u0010ª\u0001\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bª\u0001\u0010!\u001a\u0005\b«\u0001\u0010#\"\u0005\b¬\u0001\u0010%R(\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u00ad\u0001\u0010!\u001a\u0005\b®\u0001\u0010#\"\u0005\b¯\u0001\u0010%R(\u0010°\u0001\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b°\u0001\u0010\u0015\u001a\u0005\b±\u0001\u0010\u0017\"\u0005\b²\u0001\u0010\u001bR(\u0010³\u0001\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b³\u0001\u0010\u0015\u001a\u0005\b´\u0001\u0010\u0017\"\u0005\bµ\u0001\u0010\u001bR(\u0010¶\u0001\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b¶\u0001\u0010\u0015\u001a\u0005\b·\u0001\u0010\u0017\"\u0005\b¸\u0001\u0010\u001bR(\u0010¹\u0001\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b¹\u0001\u0010\u0015\u001a\u0005\bº\u0001\u0010\u0017\"\u0005\b»\u0001\u0010\u001bR,\u0010½\u0001\u001a\u0005\u0018\u00010¼\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b½\u0001\u0010¾\u0001\u001a\u0006\b¿\u0001\u0010À\u0001\"\u0006\bÁ\u0001\u0010Â\u0001R,\u0010Ä\u0001\u001a\u0005\u0018\u00010Ã\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\bÄ\u0001\u0010Å\u0001\u001a\u0006\bÆ\u0001\u0010Ç\u0001\"\u0006\bÈ\u0001\u0010É\u0001R,\u0010Ë\u0001\u001a\u0005\u0018\u00010Ê\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\bË\u0001\u0010Ì\u0001\u001a\u0006\bÍ\u0001\u0010Î\u0001\"\u0006\bÏ\u0001\u0010Ð\u0001R,\u0010Ò\u0001\u001a\u0005\u0018\u00010Ñ\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\bÒ\u0001\u0010Ó\u0001\u001a\u0006\bÔ\u0001\u0010Õ\u0001\"\u0006\bÖ\u0001\u0010×\u0001R(\u0010Ø\u0001\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bØ\u0001\u0010!\u001a\u0005\bÙ\u0001\u0010#\"\u0005\bÚ\u0001\u0010%R(\u0010Û\u0001\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bÛ\u0001\u0010!\u001a\u0005\bÜ\u0001\u0010#\"\u0005\bÝ\u0001\u0010%R%\u0010\u0003\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0013\n\u0004\b\u0003\u0010!\u001a\u0004\b\u0003\u0010#\"\u0005\bÞ\u0001\u0010%R(\u0010ß\u0001\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bß\u0001\u0010!\u001a\u0005\bß\u0001\u0010#\"\u0005\bà\u0001\u0010%R(\u0010á\u0001\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bá\u0001\u0010!\u001a\u0005\bá\u0001\u0010#\"\u0005\bâ\u0001\u0010%R(\u0010ã\u0001\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bã\u0001\u0010!\u001a\u0005\bã\u0001\u0010#\"\u0005\bä\u0001\u0010%R(\u0010å\u0001\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bå\u0001\u0010\u0015\u001a\u0005\bæ\u0001\u0010\u0017\"\u0005\bç\u0001\u0010\u001bR(\u0010è\u0001\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bè\u0001\u0010!\u001a\u0005\bé\u0001\u0010#\"\u0005\bê\u0001\u0010%R(\u0010ë\u0001\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bë\u0001\u0010\u0015\u001a\u0005\bì\u0001\u0010\u0017\"\u0005\bí\u0001\u0010\u001bR(\u0010î\u0001\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bî\u0001\u0010\u0015\u001a\u0005\bï\u0001\u0010\u0017\"\u0005\bð\u0001\u0010\u001bR(\u0010ñ\u0001\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bñ\u0001\u0010\u0015\u001a\u0005\bò\u0001\u0010\u0017\"\u0005\bó\u0001\u0010\u001bR(\u0010ô\u0001\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bô\u0001\u0010\u0015\u001a\u0005\bõ\u0001\u0010\u0017\"\u0005\bö\u0001\u0010\u001bR(\u0010÷\u0001\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b÷\u0001\u0010!\u001a\u0005\b÷\u0001\u0010#\"\u0005\bø\u0001\u0010%R(\u0010ù\u0001\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bù\u0001\u0010!\u001a\u0005\bù\u0001\u0010#\"\u0005\bú\u0001\u0010%R(\u0010û\u0001\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bû\u0001\u0010\u0015\u001a\u0005\bü\u0001\u0010\u0017\"\u0005\bý\u0001\u0010\u001bR(\u0010þ\u0001\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bþ\u0001\u0010\u0015\u001a\u0005\bÿ\u0001\u0010\u0017\"\u0005\b\u0080\u0002\u0010\u001bR(\u0010\u0081\u0002\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0081\u0002\u0010\u0015\u001a\u0005\b\u0082\u0002\u0010\u0017\"\u0005\b\u0083\u0002\u0010\u001bR(\u0010\u0084\u0002\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0084\u0002\u0010\u0015\u001a\u0005\b\u0085\u0002\u0010\u0017\"\u0005\b\u0086\u0002\u0010\u001bR(\u0010\u0087\u0002\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0087\u0002\u0010!\u001a\u0005\b\u0088\u0002\u0010#\"\u0005\b\u0089\u0002\u0010%R(\u0010\u008a\u0002\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u008a\u0002\u0010\u0015\u001a\u0005\b\u008b\u0002\u0010\u0017\"\u0005\b\u008c\u0002\u0010\u001bR(\u0010\u008d\u0002\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u008d\u0002\u0010\u0015\u001a\u0005\b\u008e\u0002\u0010\u0017\"\u0005\b\u008f\u0002\u0010\u001bR(\u0010\u0090\u0002\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0090\u0002\u0010!\u001a\u0005\b\u0090\u0002\u0010#\"\u0005\b\u0091\u0002\u0010%R(\u0010\u0092\u0002\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0092\u0002\u0010\u0015\u001a\u0005\b\u0093\u0002\u0010\u0017\"\u0005\b\u0094\u0002\u0010\u001bR(\u0010\u0095\u0002\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0095\u0002\u0010\u0015\u001a\u0005\b\u0096\u0002\u0010\u0017\"\u0005\b\u0097\u0002\u0010\u001bR,\u0010\u0099\u0002\u001a\u0005\u0018\u00010\u0098\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u0099\u0002\u0010\u009a\u0002\u001a\u0006\b\u009b\u0002\u0010\u009c\u0002\"\u0006\b\u009d\u0002\u0010\u009e\u0002R(\u0010\u009f\u0002\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u009f\u0002\u0010!\u001a\u0005\b\u009f\u0002\u0010#\"\u0005\b \u0002\u0010%R(\u0010¡\u0002\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b¡\u0002\u0010!\u001a\u0005\b¢\u0002\u0010#\"\u0005\b£\u0002\u0010%¨\u0006¨\u0002"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/PreviewSourceParam;", "Ljava/io/Serializable;", "", "isNoneVipTrailOpen", "isSubscribeLive", "", "toString", "", "toMap", "needSellShareTicket", "previewSourceParam", "", "update", "hasInit", "Z", "getHasInit", "()Z", "setHasInit", "(Z)V", "<set-?>", "originalRawString", "Ljava/lang/String;", "getOriginalRawString", "()Ljava/lang/String;", "liveScene", "getLiveScene", "setLiveScene", "(Ljava/lang/String;)V", "liveType", "getLiveType", "setLiveType", "", "scene", "Ljava/lang/Integer;", "getScene", "()Ljava/lang/Integer;", "setScene", "(Ljava/lang/Integer;)V", "propsActivityType", "getPropsActivityType", "setPropsActivityType", "openPanelType", "getOpenPanelType", "setOpenPanelType", "title", "getTitle", com.alipay.sdk.m.x.d.f25925o, "platformActivityId", "getPlatformActivityId", "setPlatformActivityId", "checkFirstChatGroupLive", "getCheckFirstChatGroupLive", "setCheckFirstChatGroupLive", "recreateEnable", "Ljava/lang/Boolean;", "getRecreateEnable", "()Ljava/lang/Boolean;", "setRecreateEnable", "(Ljava/lang/Boolean;)V", "createScene", "getCreateScene", "setCreateScene", "enterFrom", "getEnterFrom", "setEnterFrom", "enterFromMerge", "getEnterFromMerge", "setEnterFromMerge", "shootWay", "getShootWay", "setShootWay", "needInvite", "getNeedInvite", "setNeedInvite", "challengeId", "getChallengeId", "setChallengeId", "challengeTaskOptional", "getChallengeTaskOptional", "setChallengeTaskOptional", "openPaidLivePanel", "getOpenPaidLivePanel", "setOpenPaidLivePanel", "enterWithPaidLiveInfo", "getEnterWithPaidLiveInfo", "setEnterWithPaidLiveInfo", "paidLiveImg", "getPaidLiveImg", "setPaidLiveImg", "paidLiveCoverUri", "getPaidLiveCoverUri", "setPaidLiveCoverUri", "paidLiveTitle", "getPaidLiveTitle", "setPaidLiveTitle", "uploadTime", "getUploadTime", "setUploadTime", "isReplay", "setReplay", "toastContent", "getToastContent", "setToastContent", "paidLiveStatus", "getPaidLiveStatus", "setPaidLiveStatus", "isDailyMode", "setDailyMode", "action", "getAction", "setAction", "ticketId", "getTicketId", "setTicketId", "ticketFrom", "getTicketFrom", "setTicketFrom", "ownerId", "getOwnerId", "setOwnerId", "ticketFromPage", "getTicketFromPage", "setTicketFromPage", "paidLiveVisibilityRange", "getPaidLiveVisibilityRange", "setPaidLiveVisibilityRange", "stickerId", "getStickerId", "setStickerId", "stickerTaskOptional", "getStickerTaskOptional", "setStickerTaskOptional", "commerceTaskId", "getCommerceTaskId", "setCommerceTaskId", "payLoad", "getPayLoad", "setPayLoad", "Lcom/bytedance/android/live/broadcast/api/model/PreviewSourcePayLoad;", "payLoadArray$delegate", "Lkotlin/Lazy;", "getPayLoadArray", "()Lcom/bytedance/android/live/broadcast/api/model/PreviewSourcePayLoad;", "payLoadArray", "guideParam", "getGuideParam", "setGuideParam", "enableShowChatTip", "getEnableShowChatTip", "setEnableShowChatTip", "miniAppSchema", "getMiniAppSchema", "setMiniAppSchema", "openType", "getOpenType", "setOpenType", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", Keys.API_EVENT_KEY_PLAY_MODE, "Ljava/util/ArrayList;", "getPlayMode", "()Ljava/util/ArrayList;", "setPlayMode", "(Ljava/util/ArrayList;)V", "ktvType", "getKtvType", "setKtvType", "ktvOrderLabelName", "getKtvOrderLabelName", "setKtvOrderLabelName", "ktvOrderFirstTab", "getKtvOrderFirstTab", "setKtvOrderFirstTab", "uiLayout", "getUiLayout", "setUiLayout", "multiLinkGameId", "getMultiLinkGameId", "setMultiLinkGameId", "multiLinkGameName", "getMultiLinkGameName", "setMultiLinkGameName", "activitySchema", "getActivitySchema", "setActivitySchema", "enterMethod", "getEnterMethod", "setEnterMethod", "Lcom/bytedance/android/live/broadcast/api/model/CategoryNode;", "liveGameCategory", "Lcom/bytedance/android/live/broadcast/api/model/CategoryNode;", "getLiveGameCategory", "()Lcom/bytedance/android/live/broadcast/api/model/CategoryNode;", "setLiveGameCategory", "(Lcom/bytedance/android/live/broadcast/api/model/CategoryNode;)V", "Lcom/bytedance/android/live/broadcast/api/model/m0;", "guideToolbarBubbleTip", "Lcom/bytedance/android/live/broadcast/api/model/m0;", "getGuideToolbarBubbleTip", "()Lcom/bytedance/android/live/broadcast/api/model/m0;", "setGuideToolbarBubbleTip", "(Lcom/bytedance/android/live/broadcast/api/model/m0;)V", "Lcom/bytedance/android/live/broadcast/api/model/u0;", "openPlatform", "Lcom/bytedance/android/live/broadcast/api/model/u0;", "getOpenPlatform", "()Lcom/bytedance/android/live/broadcast/api/model/u0;", "setOpenPlatform", "(Lcom/bytedance/android/live/broadcast/api/model/u0;)V", "Lcom/bytedance/android/live/broadcast/api/model/OpenPlatformMgInfoModel;", "openPlatformMg", "Lcom/bytedance/android/live/broadcast/api/model/OpenPlatformMgInfoModel;", "getOpenPlatformMg", "()Lcom/bytedance/android/live/broadcast/api/model/OpenPlatformMgInfoModel;", "setOpenPlatformMg", "(Lcom/bytedance/android/live/broadcast/api/model/OpenPlatformMgInfoModel;)V", "subscribeLive", "getSubscribeLive", "setSubscribeLive", "userCustomBackground", "getUserCustomBackground", "setUserCustomBackground", "setNoneVipTrailOpen", "isVisibilityTryLive", "setVisibilityTryLive", "isChatGroupLive", "setChatGroupLive", "isDirectRoomContinue", "setDirectRoomContinue", "autoStartLiveHintText", "getAutoStartLiveHintText", "setAutoStartLiveHintText", "connectStatus", "getConnectStatus", "setConnectStatus", "cameraModel", "getCameraModel", "setCameraModel", "cameraName", "getCameraName", "setCameraName", "cameraSource", "getCameraSource", "setCameraSource", "groupLiveIdList", "getGroupLiveIdList", "setGroupLiveIdList", "isGroupLiveGame", "setGroupLiveGame", "isGroupLiveChorus", "setGroupLiveChorus", "groupLiveGameId", "getGroupLiveGameId", "setGroupLiveGameId", "groupLiveGameName", "getGroupLiveGameName", "setGroupLiveGameName", "groupLiveGameSource", "getGroupLiveGameSource", "setGroupLiveGameSource", "conversationId", "getConversationId", "setConversationId", "visibilityRange", "getVisibilityRange", "setVisibilityRange", "gamePromoteSceneSub", "getGamePromoteSceneSub", "setGamePromoteSceneSub", "previousPage", "getPreviousPage", "setPreviousPage", "isFromUrgeUpdate", "setFromUrgeUpdate", "quickLiveSource", "getQuickLiveSource", "setQuickLiveSource", "quickStartBizParams", "getQuickStartBizParams", "setQuickStartBizParams", "Lcom/google/gson/JsonElement;", "shortTouchParams", "Lcom/google/gson/JsonElement;", "getShortTouchParams", "()Lcom/google/gson/JsonElement;", "setShortTouchParams", "(Lcom/google/gson/JsonElement;)V", "isVirtualLive", "setVirtualLive", "autoOpenVirtualLive", "getAutoOpenVirtualLive", "setAutoOpenVirtualLive", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreviewSourceParam implements Serializable {
    public static final a Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Gson f59017a = null;

    @SerializedName("action")
    @Expose
    private String action;

    @SerializedName("activity_schema")
    @Expose
    private String activitySchema;

    @SerializedName("auto_open")
    @Expose
    private Integer autoOpenVirtualLive;

    @SerializedName("auto_start_live_hint_text")
    @Expose
    private String autoStartLiveHintText;

    @SerializedName("camera_model")
    @Expose
    private String cameraModel;

    @SerializedName("camera_name")
    @Expose
    private String cameraName;

    @SerializedName("camera_source")
    @Expose
    private String cameraSource;

    @SerializedName("challenge_id")
    @Expose
    private String challengeId;

    @SerializedName("optional_challenge")
    @Expose
    private Boolean challengeTaskOptional;

    @SerializedName("check_first_chat_group_live")
    @Expose
    private Integer checkFirstChatGroupLive;

    @SerializedName("task_id")
    @Expose
    private String commerceTaskId;

    @SerializedName("connect_status")
    @Expose
    private Integer connectStatus;

    @SerializedName("conversation_id")
    @Expose
    private String conversationId;

    @SerializedName("create_scene")
    @Expose
    private String createScene;

    @SerializedName("enable_show_chat_tip")
    @Expose
    private String enableShowChatTip;

    @SerializedName("enter_from")
    @Expose
    private String enterFrom;

    @SerializedName("enter_from_merge")
    @Expose
    private String enterFromMerge;

    @SerializedName("enter_method")
    @Expose
    private String enterMethod;

    @SerializedName("enter_with_paid_live_info")
    @Expose
    private Boolean enterWithPaidLiveInfo;

    @SerializedName("promote_scene_sub")
    @Expose
    private String gamePromoteSceneSub;

    @SerializedName("group_live_game_id")
    @Expose
    private String groupLiveGameId;

    @SerializedName("group_live_game_name")
    @Expose
    private String groupLiveGameName;

    @SerializedName("group_live_game_source")
    @Expose
    private String groupLiveGameSource;

    @SerializedName("group_id_list")
    @Expose
    private String groupLiveIdList;

    @SerializedName("guide_params")
    @Expose
    private String guideParam;

    @SerializedName("guide_toolbar_bubble_tip")
    @Expose
    private m0 guideToolbarBubbleTip;

    @Expose(deserialize = false, serialize = false)
    private boolean hasInit;

    @SerializedName("is_chat_group_live")
    @Expose
    private Integer isChatGroupLive;

    @SerializedName("is_daily_mode")
    @Expose
    private Boolean isDailyMode;

    @SerializedName("is_direct_room_continue")
    @Expose
    private Integer isDirectRoomContinue;

    @SerializedName("is_from_urge_update")
    @Expose
    private Integer isFromUrgeUpdate;

    @SerializedName("is_group_live_chorus")
    @Expose
    private Integer isGroupLiveChorus;

    @SerializedName("is_group_live_game")
    @Expose
    private Integer isGroupLiveGame;

    @SerializedName("is_none_vip_trail_open")
    @Expose
    private Integer isNoneVipTrailOpen;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_IS_REPLAY)
    @Expose
    private Boolean isReplay;

    @SerializedName("is_virtual_live")
    @Expose
    private Integer isVirtualLive;

    @SerializedName("is_visibility_try_live")
    @Expose
    private Integer isVisibilityTryLive;

    @SerializedName("first_level_tab_ser")
    @Expose
    private Integer ktvOrderFirstTab;

    @SerializedName("ktv_order_label_name")
    @Expose
    private String ktvOrderLabelName;

    @SerializedName("ktv_type")
    @Expose
    private Integer ktvType;

    @SerializedName("live_game_category")
    @Expose
    private CategoryNode liveGameCategory;

    @SerializedName("live_scene")
    @Expose
    private String liveScene;

    @SerializedName("live_type")
    @Expose
    private String liveType;

    @SerializedName("timor_schema")
    @Expose
    private String miniAppSchema;

    @SerializedName("multi_link_game_id")
    @Expose
    private String multiLinkGameId;

    @SerializedName("multi_link_game_name")
    @Expose
    private String multiLinkGameName;

    @SerializedName("need_invite")
    @Expose
    private Boolean needInvite;

    @SerializedName("open_paid_live_panel")
    @Expose
    private Boolean openPaidLivePanel;

    @SerializedName("open_panel_type")
    @Expose
    private Integer openPanelType;

    @SerializedName("open_platform")
    @Expose
    private u0 openPlatform;

    @SerializedName("open_platform_mg")
    @Expose
    private OpenPlatformMgInfoModel openPlatformMg;

    @SerializedName("open_type")
    @Expose
    private String openType;

    @Expose(deserialize = false, serialize = false)
    private String originalRawString;

    @SerializedName("owner_id")
    @Expose
    private String ownerId;

    @SerializedName("paid_live_cover_uri")
    @Expose
    private String paidLiveCoverUri;

    @SerializedName("paid_live_img")
    @Expose
    private String paidLiveImg;

    @SerializedName("paid_live_status")
    @Expose
    private Integer paidLiveStatus;

    @SerializedName("paid_live_title")
    @Expose
    private String paidLiveTitle;

    @SerializedName("paid_live_visibility_range")
    @Expose
    private Integer paidLiveVisibilityRange;

    @SerializedName(WsConstants.KEY_PAYLOAD)
    @Expose(serialize = false)
    private String payLoad;
    private final Lazy payLoadArray$delegate;

    @SerializedName("platform_activity_id")
    @Expose
    private String platformActivityId;

    @SerializedName(FastStartLiveConfig.PLAY_MODE)
    @Expose
    private ArrayList<Integer> playMode;

    @SerializedName("previous_page")
    @Expose
    private String previousPage;

    @SerializedName("props_activity_type")
    @Expose
    private Integer propsActivityType;

    @SerializedName("quick_live_source")
    @Expose
    private String quickLiveSource;

    @SerializedName("quick_live_biz_params")
    @Expose
    private String quickStartBizParams;

    @SerializedName("recreate_enable")
    @Expose
    private Boolean recreateEnable;

    @SerializedName("scene")
    @Expose
    private Integer scene;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SHOOT_WAY)
    @Expose
    private String shootWay;

    @SerializedName("short_touch_params")
    @Expose
    private JsonElement shortTouchParams;

    @SerializedName("live_sticker_id")
    @Expose
    private String stickerId;

    @SerializedName("optional_sticker")
    @Expose
    private Boolean stickerTaskOptional;

    @SerializedName("is_subscribe_live")
    @Expose
    private Integer subscribeLive;

    @SerializedName("ticket_from")
    @Expose
    private String ticketFrom;

    @SerializedName("ticket_from_page")
    @Expose
    private String ticketFromPage;

    @SerializedName("ticket_id")
    @Expose
    private String ticketId;

    @SerializedName("start_preview_title")
    @Expose
    private String title;

    @SerializedName("toast_content")
    @Expose
    private String toastContent;

    @SerializedName("uilayout")
    @Expose
    private Integer uiLayout;

    @SerializedName("upload_time")
    @Expose
    private String uploadTime;

    @SerializedName("use_custom_background_bitmap")
    private Integer userCustomBackground;

    @SerializedName("visibility_range")
    @Expose
    private Integer visibilityRange;

    public static final class a {
        public a() {
        }
    }

    public final PreviewSourcePayLoad getPayLoadArray() {
        return (PreviewSourcePayLoad) this.payLoadArray$delegate.getValue();
    }

    static {
        Companion = new a();
        GsonBuilder r100 = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).registerTypeAdapter(Room.class, new RoomTypeAdapter()).registerTypeAdapter(FeedItem.class, new FeedItemTypeAdapter());
        Class r101 = Boolean.TYPE;
        f59017a = r100.registerTypeAdapter(r101, new BooleanTypeAdapter()).registerTypeAdapter(r101, new BooleanTypeAdapter()).create();
    }

    /* JADX INFO: renamed from: isNoneVipTrailOpen, reason: collision with other method in class */
    public final boolean m8167isNoneVipTrailOpen() {
        Integer r100 = this.isNoneVipTrailOpen;
        if (r100 != null) goto L6;
    L7:
        return true;
    L6:
        if (r100.intValue() != 0) goto L7;
        return false;
    }

    public final boolean isSubscribeLive() {
        Integer r100 = this.subscribeLive;
        if (r100 != null) goto L6;
    L8:
        return false;
    L6:
        if (r100.intValue() != 1) goto L8;
        return true;
    }

    public final boolean needSellShareTicket() {
        if (TextUtils.equals(this.action, "add") == true) goto L5;
    L11:
        return false;
    L5:
        if (TextUtils.isEmpty(this.ticketId) == true) goto L11;
        if (TextUtils.equals(this.ticketFromPage, "invite_page") == false) goto L9;
    L10:
        return true;
    L9:
        if (TextUtils.equals(this.ticketFromPage, "sale_manage_page") == false) goto L11;
        goto L10
    }

    public final Map<String, String> toMap() {
        LinkedHashMap r100 = new LinkedHashMap();
        JSONObject r101 = new JSONObject(toString());     // Catch: JSONException -> L30
        Iterator<String> r102 = r101.keys();     // Catch: JSONException -> L30
    L5:
        if (r102.hasNext() == false) goto L12;
        String r103 = r102.next();     // Catch: JSONException -> L30
        if (Intrinsics.areEqual(r103, "pay_load_array$delegate") == true) goto L5;
        Object r104 = r101.get(r103);     // Catch: JSONException -> L30
        if (r104 == null) goto L5;
        r100.put(r103, r104.toString());     // Catch: JSONException -> L30
        goto L5
    L12:
        boolean r105 = true;
        if ((!getPayLoadArray().f59019a.isEmpty()) == false) goto L16;
        r100.put(WsConstants.KEY_PAYLOAD, getPayLoadArray().toString());     // Catch: JSONException -> L30
    L16:
        if (this.originalRawString.length() > 0) goto L19;
        r105 = false;
    L19:
        if (r105 == false) goto L32;
        JSONObject r106 = new JSONObject(this.originalRawString);     // Catch: JSONException -> L30
        Iterator<String> r107 = r106.keys();     // Catch: JSONException -> L30
    L21:
        if (r107.hasNext() == false) goto L32;
        String r108 = r107.next();     // Catch: JSONException -> L30
        if (r100.containsKey(r108) == true) goto L21;
        Object r109 = r106.get(r108);     // Catch: JSONException -> L30
        if (r109 == null) goto L21;
        r100.put(r108, r109.toString());     // Catch: JSONException -> L30
        ALogger.w("PreviewSourceParam", "add key:{" + r108 + "}-value:{" + r109 + "} to map which is not deserialized");     // Catch: JSONException -> L30
    L32:
        return r100;
    L30:
        e = move-exception;
        ALogger.e("PreviewSourceParam", "sourceParam to Map:" + e.getMessage(), e);
        goto L32
    }

    public String toString() {
        return GsonProtectorUtils.toJson(f59017a, this);
    }

    public PreviewSourceParam() {
        this.originalRawString = "";
        Boolean r100 = Boolean.FALSE;
        this.recreateEnable = r100;
        this.isDailyMode = r100;
        this.payLoadArray$delegate = LazyKt.lazy(new PreviewSourceParam$payLoadArray$2(this));
        this.multiLinkGameId = "";
        this.multiLinkGameName = "";
        this.isDirectRoomContinue = 0;
        this.quickLiveSource = "";
        this.quickStartBizParams = "";
    }

    public static final /* synthetic */ Gson access$getGsonInstance$cp() {
        return f59017a;
    }

    public final String getAction() {
        return this.action;
    }

    public final String getActivitySchema() {
        return this.activitySchema;
    }

    public final Integer getAutoOpenVirtualLive() {
        return this.autoOpenVirtualLive;
    }

    public final String getAutoStartLiveHintText() {
        return this.autoStartLiveHintText;
    }

    public final String getCameraModel() {
        return this.cameraModel;
    }

    public final String getCameraName() {
        return this.cameraName;
    }

    public final String getCameraSource() {
        return this.cameraSource;
    }

    public final String getChallengeId() {
        return this.challengeId;
    }

    public final Boolean getChallengeTaskOptional() {
        return this.challengeTaskOptional;
    }

    public final Integer getCheckFirstChatGroupLive() {
        return this.checkFirstChatGroupLive;
    }

    public final String getCommerceTaskId() {
        return this.commerceTaskId;
    }

    public final Integer getConnectStatus() {
        return this.connectStatus;
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final String getCreateScene() {
        return this.createScene;
    }

    public final String getEnableShowChatTip() {
        return this.enableShowChatTip;
    }

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public final String getEnterFromMerge() {
        return this.enterFromMerge;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final Boolean getEnterWithPaidLiveInfo() {
        return this.enterWithPaidLiveInfo;
    }

    public final String getGamePromoteSceneSub() {
        return this.gamePromoteSceneSub;
    }

    public final String getGroupLiveGameId() {
        return this.groupLiveGameId;
    }

    public final String getGroupLiveGameName() {
        return this.groupLiveGameName;
    }

    public final String getGroupLiveGameSource() {
        return this.groupLiveGameSource;
    }

    public final String getGroupLiveIdList() {
        return this.groupLiveIdList;
    }

    public final String getGuideParam() {
        return this.guideParam;
    }

    public final m0 getGuideToolbarBubbleTip() {
        return this.guideToolbarBubbleTip;
    }

    public final boolean getHasInit() {
        return this.hasInit;
    }

    public final Integer getKtvOrderFirstTab() {
        return this.ktvOrderFirstTab;
    }

    public final String getKtvOrderLabelName() {
        return this.ktvOrderLabelName;
    }

    public final Integer getKtvType() {
        return this.ktvType;
    }

    public final CategoryNode getLiveGameCategory() {
        return this.liveGameCategory;
    }

    public final String getLiveScene() {
        return this.liveScene;
    }

    public final String getLiveType() {
        return this.liveType;
    }

    public final String getMiniAppSchema() {
        return this.miniAppSchema;
    }

    public final String getMultiLinkGameId() {
        return this.multiLinkGameId;
    }

    public final String getMultiLinkGameName() {
        return this.multiLinkGameName;
    }

    public final Boolean getNeedInvite() {
        return this.needInvite;
    }

    public final Boolean getOpenPaidLivePanel() {
        return this.openPaidLivePanel;
    }

    public final Integer getOpenPanelType() {
        return this.openPanelType;
    }

    public final u0 getOpenPlatform() {
        return this.openPlatform;
    }

    public final OpenPlatformMgInfoModel getOpenPlatformMg() {
        return this.openPlatformMg;
    }

    public final String getOpenType() {
        return this.openType;
    }

    public final String getOriginalRawString() {
        return this.originalRawString;
    }

    public final String getOwnerId() {
        return this.ownerId;
    }

    public final String getPaidLiveCoverUri() {
        return this.paidLiveCoverUri;
    }

    public final String getPaidLiveImg() {
        return this.paidLiveImg;
    }

    public final Integer getPaidLiveStatus() {
        return this.paidLiveStatus;
    }

    public final String getPaidLiveTitle() {
        return this.paidLiveTitle;
    }

    public final Integer getPaidLiveVisibilityRange() {
        return this.paidLiveVisibilityRange;
    }

    public final String getPayLoad() {
        return this.payLoad;
    }

    public final String getPlatformActivityId() {
        return this.platformActivityId;
    }

    public final ArrayList<Integer> getPlayMode() {
        return this.playMode;
    }

    public final String getPreviousPage() {
        return this.previousPage;
    }

    public final Integer getPropsActivityType() {
        return this.propsActivityType;
    }

    public final String getQuickLiveSource() {
        return this.quickLiveSource;
    }

    public final String getQuickStartBizParams() {
        return this.quickStartBizParams;
    }

    public final Boolean getRecreateEnable() {
        return this.recreateEnable;
    }

    public final Integer getScene() {
        return this.scene;
    }

    public final String getShootWay() {
        return this.shootWay;
    }

    public final JsonElement getShortTouchParams() {
        return this.shortTouchParams;
    }

    public final String getStickerId() {
        return this.stickerId;
    }

    public final Boolean getStickerTaskOptional() {
        return this.stickerTaskOptional;
    }

    public final Integer getSubscribeLive() {
        return this.subscribeLive;
    }

    public final String getTicketFrom() {
        return this.ticketFrom;
    }

    public final String getTicketFromPage() {
        return this.ticketFromPage;
    }

    public final String getTicketId() {
        return this.ticketId;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getToastContent() {
        return this.toastContent;
    }

    public final Integer getUiLayout() {
        return this.uiLayout;
    }

    public final String getUploadTime() {
        return this.uploadTime;
    }

    public final Integer getUserCustomBackground() {
        return this.userCustomBackground;
    }

    public final Integer getVisibilityRange() {
        return this.visibilityRange;
    }

    public final Integer isChatGroupLive() {
        return this.isChatGroupLive;
    }

    public final Boolean isDailyMode() {
        return this.isDailyMode;
    }

    public final Integer isDirectRoomContinue() {
        return this.isDirectRoomContinue;
    }

    public final Integer isFromUrgeUpdate() {
        return this.isFromUrgeUpdate;
    }

    public final Integer isGroupLiveChorus() {
        return this.isGroupLiveChorus;
    }

    public final Integer isGroupLiveGame() {
        return this.isGroupLiveGame;
    }

    public final Boolean isReplay() {
        return this.isReplay;
    }

    public final Integer isVirtualLive() {
        return this.isVirtualLive;
    }

    public final Integer isVisibilityTryLive() {
        return this.isVisibilityTryLive;
    }

    public final Integer isNoneVipTrailOpen() {
        return this.isNoneVipTrailOpen;
    }

    public static final /* synthetic */ String access$getOriginalRawString$p(PreviewSourceParam r100) {
        return r100.originalRawString;
    }

    public final void setAction(String r100) {
        this.action = r100;
    }

    public final void setActivitySchema(String r100) {
        this.activitySchema = r100;
    }

    public final void setAutoOpenVirtualLive(Integer r100) {
        this.autoOpenVirtualLive = r100;
    }

    public final void setAutoStartLiveHintText(String r100) {
        this.autoStartLiveHintText = r100;
    }

    public final void setCameraModel(String r100) {
        this.cameraModel = r100;
    }

    public final void setCameraName(String r100) {
        this.cameraName = r100;
    }

    public final void setCameraSource(String r100) {
        this.cameraSource = r100;
    }

    public final void setChallengeId(String r100) {
        this.challengeId = r100;
    }

    public final void setChallengeTaskOptional(Boolean r100) {
        this.challengeTaskOptional = r100;
    }

    public final void setChatGroupLive(Integer r100) {
        this.isChatGroupLive = r100;
    }

    public final void setCheckFirstChatGroupLive(Integer r100) {
        this.checkFirstChatGroupLive = r100;
    }

    public final void setCommerceTaskId(String r100) {
        this.commerceTaskId = r100;
    }

    public final void setConnectStatus(Integer r100) {
        this.connectStatus = r100;
    }

    public final void setConversationId(String r100) {
        this.conversationId = r100;
    }

    public final void setCreateScene(String r100) {
        this.createScene = r100;
    }

    public final void setDailyMode(Boolean r100) {
        this.isDailyMode = r100;
    }

    public final void setDirectRoomContinue(Integer r100) {
        this.isDirectRoomContinue = r100;
    }

    public final void setEnableShowChatTip(String r100) {
        this.enableShowChatTip = r100;
    }

    public final void setEnterFrom(String r100) {
        this.enterFrom = r100;
    }

    public final void setEnterFromMerge(String r100) {
        this.enterFromMerge = r100;
    }

    public final void setEnterMethod(String r100) {
        this.enterMethod = r100;
    }

    public final void setEnterWithPaidLiveInfo(Boolean r100) {
        this.enterWithPaidLiveInfo = r100;
    }

    public final void setFromUrgeUpdate(Integer r100) {
        this.isFromUrgeUpdate = r100;
    }

    public final void setGamePromoteSceneSub(String r100) {
        this.gamePromoteSceneSub = r100;
    }

    public final void setGroupLiveChorus(Integer r100) {
        this.isGroupLiveChorus = r100;
    }

    public final void setGroupLiveGame(Integer r100) {
        this.isGroupLiveGame = r100;
    }

    public final void setGroupLiveGameId(String r100) {
        this.groupLiveGameId = r100;
    }

    public final void setGroupLiveGameName(String r100) {
        this.groupLiveGameName = r100;
    }

    public final void setGroupLiveGameSource(String r100) {
        this.groupLiveGameSource = r100;
    }

    public final void setGroupLiveIdList(String r100) {
        this.groupLiveIdList = r100;
    }

    public final void setGuideParam(String r100) {
        this.guideParam = r100;
    }

    public final void setGuideToolbarBubbleTip(m0 r100) {
        this.guideToolbarBubbleTip = r100;
    }

    public final void setHasInit(boolean r100) {
        this.hasInit = r100;
    }

    public final void setKtvOrderFirstTab(Integer r100) {
        this.ktvOrderFirstTab = r100;
    }

    public final void setKtvOrderLabelName(String r100) {
        this.ktvOrderLabelName = r100;
    }

    public final void setKtvType(Integer r100) {
        this.ktvType = r100;
    }

    public final void setLiveGameCategory(CategoryNode r100) {
        this.liveGameCategory = r100;
    }

    public final void setLiveScene(String r100) {
        this.liveScene = r100;
    }

    public final void setLiveType(String r100) {
        this.liveType = r100;
    }

    public final void setMiniAppSchema(String r100) {
        this.miniAppSchema = r100;
    }

    public final void setMultiLinkGameId(String r100) {
        this.multiLinkGameId = r100;
    }

    public final void setMultiLinkGameName(String r100) {
        this.multiLinkGameName = r100;
    }

    public final void setNeedInvite(Boolean r100) {
        this.needInvite = r100;
    }

    public final void setNoneVipTrailOpen(Integer r100) {
        this.isNoneVipTrailOpen = r100;
    }

    public final void setOpenPaidLivePanel(Boolean r100) {
        this.openPaidLivePanel = r100;
    }

    public final void setOpenPanelType(Integer r100) {
        this.openPanelType = r100;
    }

    public final void setOpenPlatform(u0 r100) {
        this.openPlatform = r100;
    }

    public final void setOpenPlatformMg(OpenPlatformMgInfoModel r100) {
        this.openPlatformMg = r100;
    }

    public final void setOpenType(String r100) {
        this.openType = r100;
    }

    public final void setOwnerId(String r100) {
        this.ownerId = r100;
    }

    public final void setPaidLiveCoverUri(String r100) {
        this.paidLiveCoverUri = r100;
    }

    public final void setPaidLiveImg(String r100) {
        this.paidLiveImg = r100;
    }

    public final void setPaidLiveStatus(Integer r100) {
        this.paidLiveStatus = r100;
    }

    public final void setPaidLiveTitle(String r100) {
        this.paidLiveTitle = r100;
    }

    public final void setPaidLiveVisibilityRange(Integer r100) {
        this.paidLiveVisibilityRange = r100;
    }

    public final void setPayLoad(String r100) {
        this.payLoad = r100;
    }

    public final void setPlatformActivityId(String r100) {
        this.platformActivityId = r100;
    }

    public final void setPlayMode(ArrayList<Integer> r100) {
        this.playMode = r100;
    }

    public final void setPreviousPage(String r100) {
        this.previousPage = r100;
    }

    public final void setPropsActivityType(Integer r100) {
        this.propsActivityType = r100;
    }

    public final void setQuickLiveSource(String r100) {
        this.quickLiveSource = r100;
    }

    public final void setQuickStartBizParams(String r100) {
        this.quickStartBizParams = r100;
    }

    public final void setRecreateEnable(Boolean r100) {
        this.recreateEnable = r100;
    }

    public final void setReplay(Boolean r100) {
        this.isReplay = r100;
    }

    public final void setScene(Integer r100) {
        this.scene = r100;
    }

    public final void setShootWay(String r100) {
        this.shootWay = r100;
    }

    public final void setShortTouchParams(JsonElement r100) {
        this.shortTouchParams = r100;
    }

    public final void setStickerId(String r100) {
        this.stickerId = r100;
    }

    public final void setStickerTaskOptional(Boolean r100) {
        this.stickerTaskOptional = r100;
    }

    public final void setSubscribeLive(Integer r100) {
        this.subscribeLive = r100;
    }

    public final void setTicketFrom(String r100) {
        this.ticketFrom = r100;
    }

    public final void setTicketFromPage(String r100) {
        this.ticketFromPage = r100;
    }

    public final void setTicketId(String r100) {
        this.ticketId = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }

    public final void setToastContent(String r100) {
        this.toastContent = r100;
    }

    public final void setUiLayout(Integer r100) {
        this.uiLayout = r100;
    }

    public final void setUploadTime(String r100) {
        this.uploadTime = r100;
    }

    public final void setUserCustomBackground(Integer r100) {
        this.userCustomBackground = r100;
    }

    public final void setVirtualLive(Integer r100) {
        this.isVirtualLive = r100;
    }

    public final void setVisibilityRange(Integer r100) {
        this.visibilityRange = r100;
    }

    public final void setVisibilityTryLive(Integer r100) {
        this.isVisibilityTryLive = r100;
    }

    public final void update(PreviewSourceParam r100) {
        String r101 = null;
        if (r100 == null) goto L5;
        Integer r102 = r100.isVisibilityTryLive;
    L6:
        this.isVisibilityTryLive = r102;
        if (r100 == null) goto L9;
        Integer r103 = r100.connectStatus;
    L10:
        this.connectStatus = r103;
        if (r100 == null) goto L13;
        String r104 = r100.cameraModel;
    L14:
        this.cameraModel = r104;
        if (r100 == null) goto L17;
        String r105 = r100.cameraName;
    L18:
        this.cameraName = r105;
        if (r100 == null) goto L21;
        r101 = r100.cameraSource;
    L21:
        this.cameraSource = r101;
        return;
    L17:
        r105 = null;
        goto L18
    L13:
        r104 = null;
        goto L14
    L9:
        r103 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    public static final /* synthetic */ void access$setOriginalRawString$p(PreviewSourceParam r100, String r101) {
        r100.originalRawString = r101;
    }
}
