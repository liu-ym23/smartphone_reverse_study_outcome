package com.stepos.agentframework.chatcore.session;

import Z8.C1173v;
import Z8.C1174w;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.intent.AgentTool;
import com.stepos.agentframework.chatcore.session.ToolDedupSignature;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIsland;
import h8.C4148a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReferenceSource;
import p9.InterfaceC5074l;
import u4.AgentMessage;
import w4.ChatMessage;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001:\u0003\t\f\u000eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/ToolDedupSignature;", "", "<init>", "()V", "Lw4/c;", "message", "Lcom/stepos/agentframework/chatcore/intent/e;", "tool", "Lcom/stepos/agentframework/chatcore/session/ToolDedupSignature$a;", Const.INTENT_KEY_APIKEY, "(Lw4/c;Lcom/stepos/agentframework/chatcore/intent/e;)Lcom/stepos/agentframework/chatcore/session/ToolDedupSignature$a;", "Lcom/stepos/agentframework/chatcore/session/ToolDedupSignature$b;", Const.INTENT_KEY_PKGNAME, "(Lw4/c;)Lcom/stepos/agentframework/chatcore/session/ToolDedupSignature$b;", "LruDedupCache", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ToolDedupSignature {
    public static final ToolDedupSignature INSTANCE = new ToolDedupSignature();

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\b\u0003\n\u0002\b\u0004*\u0002$'\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0010\u001a\u00020\f2\u0006\u0010\t\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0097\u0001\u0010\u001c\u001a\u00020\f\"\b\b\u0001\u0010\u0012*\u00020\u00022\"\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0013j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u00142\u0006\u0010\t\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00028\u00012\u0006\u0010\u0016\u001a\u00020\u00032\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00050\u00172\u0018\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\f0\u00192\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00030\u0017H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJK\u0010\u001e\u001a\u00020\f2\"\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0\u0013j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n`\u00142\u0006\u0010\t\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJK\u0010 \u001a\u00020\f2\"\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000f0\u0013j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000f`\u00142\u0006\u0010\t\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b \u0010!R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\"R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010#R\u0014\u0010%\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010(\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006*"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/ToolDedupSignature$LruDedupCache;", "K", "", "", "tag", "", "capacity", "<init>", "(Ljava/lang/String;I)V", "key", "Lcom/stepos/agentframework/chatcore/session/ToolDedupSignature$a;", "signature", "", "q", "(Ljava/lang/Object;Lcom/stepos/agentframework/chatcore/session/ToolDedupSignature$a;)Z", "Lcom/stepos/agentframework/chatcore/session/ToolDedupSignature$b;", "r", "(Ljava/lang/Object;Lcom/stepos/agentframework/chatcore/session/ToolDedupSignature$b;)Z", ExifInterface.LATITUDE_SOUTH, "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", C3081a.FOCUS_MAP_NAME, "logTag", "Lkotlin/Function1;", "compact", "Lkotlin/Function2;", AlipayXuiIsland.REASON_SAME, "describe", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/util/LinkedHashMap;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;Lp9/l;Lp9/p;Lp9/l;)Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/util/LinkedHashMap;Ljava/lang/Object;Lcom/stepos/agentframework/chatcore/session/ToolDedupSignature$a;Ljava/lang/String;)Z", "m", "(Ljava/util/LinkedHashMap;Ljava/lang/Object;Lcom/stepos/agentframework/chatcore/session/ToolDedupSignature$b;Ljava/lang/String;)Z", "Ljava/lang/String;", "I", "com/stepos/agentframework/chatcore/session/ToolDedupSignature$LruDedupCache$store$1", "store", "Lcom/stepos/agentframework/chatcore/session/ToolDedupSignature$LruDedupCache$store$1;", "com/stepos/agentframework/chatcore/session/ToolDedupSignature$LruDedupCache$toolStore$1", "toolStore", "Lcom/stepos/agentframework/chatcore/session/ToolDedupSignature$LruDedupCache$toolStore$1;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class LruDedupCache<K> {
        private final int capacity;
        private final ToolDedupSignature$LruDedupCache$store$1 store;
        private final String tag;
        private final ToolDedupSignature$LruDedupCache$toolStore$1 toolStore;

        public LruDedupCache(String tag, int i10) {
            kotlin.jvm.internal.p.i(tag, "tag");
            this.tag = tag;
            this.capacity = i10;
            this.store = new LinkedHashMap<K, ToolUpsertSig>(this) { // from class: com.stepos.agentframework.chatcore.session.ToolDedupSignature$LruDedupCache$store$1
                final /* synthetic */ ToolDedupSignature.LruDedupCache<K> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(64, 0.75f, true);
                    this.this$0 = this;
                }

                @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ boolean containsValue(Object obj) {
                    if (obj instanceof ToolDedupSignature.ToolUpsertSig) {
                        return d((ToolDedupSignature.ToolUpsertSig) obj);
                    }
                    return false;
                }

                public /* bridge */ boolean d(ToolDedupSignature.ToolUpsertSig toolUpsertSig) {
                    return super.containsValue(toolUpsertSig);
                }

                @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ Set<Map.Entry<K, ToolDedupSignature.ToolUpsertSig>> entrySet() {
                    return (Set<Map.Entry<K, ToolDedupSignature.ToolUpsertSig>>) g();
                }

                public /* bridge */ Set<Map.Entry<Object, ToolDedupSignature.ToolUpsertSig>> g() {
                    return super.entrySet();
                }

                public /* bridge */ Set<Object> h() {
                    return super.keySet();
                }

                public /* bridge */ int i() {
                    return super.size();
                }

                public /* bridge */ Collection<ToolDedupSignature.ToolUpsertSig> j() {
                    return super.values();
                }

                @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ Set<K> keySet() {
                    return (Set<K>) h();
                }

                public /* bridge */ boolean n(Object obj, ToolDedupSignature.ToolUpsertSig toolUpsertSig) {
                    return super.remove(obj, toolUpsertSig);
                }

                @Override // java.util.HashMap, java.util.Map
                public final /* bridge */ boolean remove(Object obj, Object obj2) {
                    if (obj2 instanceof ToolDedupSignature.ToolUpsertSig) {
                        return n(obj, (ToolDedupSignature.ToolUpsertSig) obj2);
                    }
                    return false;
                }

                @Override // java.util.LinkedHashMap
                public boolean removeEldestEntry(Map.Entry<K, ToolDedupSignature.ToolUpsertSig> eldest) {
                    return size() > ((ToolDedupSignature.LruDedupCache) this.this$0).capacity;
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ int size() {
                    return i();
                }

                @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ Collection<ToolDedupSignature.ToolUpsertSig> values() {
                    return j();
                }
            };
            this.toolStore = new LinkedHashMap<K, ToolFrameSig>(this) { // from class: com.stepos.agentframework.chatcore.session.ToolDedupSignature$LruDedupCache$toolStore$1
                final /* synthetic */ ToolDedupSignature.LruDedupCache<K> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(64, 0.75f, true);
                    this.this$0 = this;
                }

                @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ boolean containsValue(Object obj) {
                    if (obj instanceof ToolDedupSignature.ToolFrameSig) {
                        return d((ToolDedupSignature.ToolFrameSig) obj);
                    }
                    return false;
                }

                public /* bridge */ boolean d(ToolDedupSignature.ToolFrameSig toolFrameSig) {
                    return super.containsValue(toolFrameSig);
                }

                @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ Set<Map.Entry<K, ToolDedupSignature.ToolFrameSig>> entrySet() {
                    return (Set<Map.Entry<K, ToolDedupSignature.ToolFrameSig>>) g();
                }

                public /* bridge */ Set<Map.Entry<Object, ToolDedupSignature.ToolFrameSig>> g() {
                    return super.entrySet();
                }

                public /* bridge */ Set<Object> h() {
                    return super.keySet();
                }

                public /* bridge */ int i() {
                    return super.size();
                }

                public /* bridge */ Collection<ToolDedupSignature.ToolFrameSig> j() {
                    return super.values();
                }

                @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ Set<K> keySet() {
                    return (Set<K>) h();
                }

                public /* bridge */ boolean n(Object obj, ToolDedupSignature.ToolFrameSig toolFrameSig) {
                    return super.remove(obj, toolFrameSig);
                }

                @Override // java.util.HashMap, java.util.Map
                public final /* bridge */ boolean remove(Object obj, Object obj2) {
                    if (obj2 instanceof ToolDedupSignature.ToolFrameSig) {
                        return n(obj, (ToolDedupSignature.ToolFrameSig) obj2);
                    }
                    return false;
                }

                @Override // java.util.LinkedHashMap
                public boolean removeEldestEntry(Map.Entry<K, ToolDedupSignature.ToolFrameSig> eldest) {
                    return size() > ((ToolDedupSignature.LruDedupCache) this.this$0).capacity;
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ int size() {
                    return i();
                }

                @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ Collection<ToolDedupSignature.ToolFrameSig> values() {
                    return j();
                }
            };
        }

        public static final int j(ToolFrameSig it) {
            kotlin.jvm.internal.p.i(it, "it");
            return it.getCompactHash();
        }

        public static final boolean k(ToolFrameSig a10, ToolFrameSig b10) {
            kotlin.jvm.internal.p.i(a10, "a");
            kotlin.jvm.internal.p.i(b10, "b");
            return a10.b(b10);
        }

        public static final String l(ToolFrameSig it) {
            kotlin.jvm.internal.p.i(it, "it");
            return it.toString();
        }

        public static final int n(ToolUpsertSig it) {
            kotlin.jvm.internal.p.i(it, "it");
            return it.getCompactHash();
        }

        public static final boolean o(ToolUpsertSig a10, ToolUpsertSig b10) {
            kotlin.jvm.internal.p.i(a10, "a");
            kotlin.jvm.internal.p.i(b10, "b");
            return a10.b(b10);
        }

        public static final String p(ToolUpsertSig it) {
            kotlin.jvm.internal.p.i(it, "it");
            return it.toString();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final boolean h(LinkedHashMap<K, ToolFrameSig> map, K key, ToolFrameSig signature, String logTag) {
            return i(map, key, signature, logTag, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.b1
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return Integer.valueOf(ToolDedupSignature.LruDedupCache.j((ToolDedupSignature.ToolFrameSig) obj));
                }
            }, new p9.p() { // from class: com.stepos.agentframework.chatcore.session.c1
                @Override // p9.p
                public final Object invoke(Object obj, Object obj2) {
                    return Boolean.valueOf(ToolDedupSignature.LruDedupCache.k((ToolDedupSignature.ToolFrameSig) obj, (ToolDedupSignature.ToolFrameSig) obj2));
                }
            }, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.d1
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return ToolDedupSignature.LruDedupCache.l((ToolDedupSignature.ToolFrameSig) obj);
                }
            });
        }

        public final <S> boolean i(LinkedHashMap<K, S> map, K key, S signature, String logTag, InterfaceC5074l<? super S, Integer> compact, p9.p<? super S, ? super S, Boolean> same, InterfaceC5074l<? super S, String> describe) {
            S s10 = map.get(key);
            if (s10 == null) {
                map.put(key, signature);
                return false;
            }
            if (compact.invoke(s10).intValue() != compact.invoke(signature).intValue()) {
                map.put(key, signature);
                return false;
            }
            if (same.invoke(s10, signature).booleanValue()) {
                return true;
            }
            C4148a.u(logTag, "tool dedup hash collision key=" + key + " prev=" + ((Object) describe.invoke(s10)) + " new=" + ((Object) describe.invoke(signature)), false, 4, null);
            map.put(key, signature);
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final boolean m(LinkedHashMap<K, ToolUpsertSig> map, K key, ToolUpsertSig signature, String logTag) {
            return i(map, key, signature, logTag, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.Y0
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return Integer.valueOf(ToolDedupSignature.LruDedupCache.n((ToolDedupSignature.ToolUpsertSig) obj));
                }
            }, new p9.p() { // from class: com.stepos.agentframework.chatcore.session.Z0
                @Override // p9.p
                public final Object invoke(Object obj, Object obj2) {
                    return Boolean.valueOf(ToolDedupSignature.LruDedupCache.o((ToolDedupSignature.ToolUpsertSig) obj, (ToolDedupSignature.ToolUpsertSig) obj2));
                }
            }, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.a1
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return ToolDedupSignature.LruDedupCache.p((ToolDedupSignature.ToolUpsertSig) obj);
                }
            });
        }

        public final boolean q(K key, ToolFrameSig signature) {
            boolean zH;
            kotlin.jvm.internal.p.i(signature, "signature");
            synchronized (this.toolStore) {
                zH = h(this.toolStore, key, signature, this.tag);
            }
            return zH;
        }

        public final boolean r(K key, ToolUpsertSig signature) {
            boolean zM;
            kotlin.jvm.internal.p.i(signature, "signature");
            synchronized (this.store) {
                zM = m(this.store, key, signature, this.tag);
            }
            return zM;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b!\b\u0086\b\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001b\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010 \u001a\u0004\b!\u0010\u0018R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\"\u001a\u0004\b\u0007\u0010#R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010 \u001a\u0004\b$\u0010\u0018R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010 \u001a\u0004\b%\u0010\u0018R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010&\u001a\u0004\b'\u0010\u001aR\u0017\u0010\f\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\f\u0010&\u001a\u0004\b(\u0010\u001aR\u0017\u0010\r\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\r\u0010&\u001a\u0004\b)\u0010\u001aR\u0017\u0010\u000e\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000e\u0010&\u001a\u0004\b*\u0010\u001aR\u0017\u0010\u000f\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000f\u0010&\u001a\u0004\b+\u0010\u001aR\u0017\u0010\u0011\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010,\u001a\u0004\b-\u0010.R\u0017\u0010/\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b/\u0010&\u001a\u0004\b0\u0010\u001a¨\u00061"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/ToolDedupSignature$a;", "", "Lcom/stepos/agentframework/chatcore/session/EReplyStatus;", "messageStatus", "", "toolCallId", "", "isFinished", "name", "apiName", "", "parameterLen", "resultLen", "parameterHash", "resultHash", "progressPercent", "", "progressDurationMs", "<init>", "(Lcom/stepos/agentframework/chatcore/session/EReplyStatus;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;IIIIIJ)V", "other", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/agentframework/chatcore/session/ToolDedupSignature$a;)Z", "toString", "()Ljava/lang/String;", "hashCode", "()I", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/agentframework/chatcore/session/EReplyStatus;", "getMessageStatus", "()Lcom/stepos/agentframework/chatcore/session/EReplyStatus;", "Ljava/lang/String;", "getToolCallId", "Z", "()Z", "getName", "getApiName", "I", "getParameterLen", "getResultLen", "getParameterHash", "getResultHash", "getProgressPercent", "J", "getProgressDurationMs", "()J", "compactHash", Const.INTENT_KEY_APIKEY, "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatcore.session.ToolDedupSignature$a, reason: from toString */
    public static final /* data */ class ToolFrameSig {
        private final String apiName;
        private final int compactHash;
        private final boolean isFinished;

        /* renamed from: messageStatus, reason: from kotlin metadata and from toString */
        private final EReplyStatus status;
        private final String name;
        private final int parameterHash;
        private final int parameterLen;
        private final long progressDurationMs;
        private final int progressPercent;
        private final int resultHash;
        private final int resultLen;
        private final String toolCallId;

        public ToolFrameSig(EReplyStatus messageStatus, String toolCallId, boolean z10, String str, String str2, int i10, int i11, int i12, int i13, int i14, long j10) {
            kotlin.jvm.internal.p.i(messageStatus, "messageStatus");
            kotlin.jvm.internal.p.i(toolCallId, "toolCallId");
            this.status = messageStatus;
            this.toolCallId = toolCallId;
            this.isFinished = z10;
            this.name = str;
            this.apiName = str2;
            this.parameterLen = i10;
            this.resultLen = i11;
            this.parameterHash = i12;
            this.resultHash = i13;
            this.progressPercent = i14;
            this.progressDurationMs = j10;
            this.compactHash = C1173v.p(messageStatus, toolCallId, Boolean.valueOf(z10), str, str2, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14), Long.valueOf(j10)).hashCode();
        }

        /* renamed from: a, reason: from getter */
        public final int getCompactHash() {
            return this.compactHash;
        }

        public final boolean b(ToolFrameSig other) {
            kotlin.jvm.internal.p.i(other, "other");
            return this.status == other.status && kotlin.jvm.internal.p.d(this.toolCallId, other.toolCallId) && this.isFinished == other.isFinished && kotlin.jvm.internal.p.d(this.name, other.name) && kotlin.jvm.internal.p.d(this.apiName, other.apiName) && this.parameterLen == other.parameterLen && this.resultLen == other.resultLen && this.parameterHash == other.parameterHash && this.resultHash == other.resultHash && this.progressPercent == other.progressPercent && this.progressDurationMs == other.progressDurationMs;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ToolFrameSig)) {
                return false;
            }
            ToolFrameSig toolFrameSig = (ToolFrameSig) other;
            return this.status == toolFrameSig.status && kotlin.jvm.internal.p.d(this.toolCallId, toolFrameSig.toolCallId) && this.isFinished == toolFrameSig.isFinished && kotlin.jvm.internal.p.d(this.name, toolFrameSig.name) && kotlin.jvm.internal.p.d(this.apiName, toolFrameSig.apiName) && this.parameterLen == toolFrameSig.parameterLen && this.resultLen == toolFrameSig.resultLen && this.parameterHash == toolFrameSig.parameterHash && this.resultHash == toolFrameSig.resultHash && this.progressPercent == toolFrameSig.progressPercent && this.progressDurationMs == toolFrameSig.progressDurationMs;
        }

        public int hashCode() {
            int iHashCode = ((((this.status.hashCode() * 31) + this.toolCallId.hashCode()) * 31) + Boolean.hashCode(this.isFinished)) * 31;
            String str = this.name;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.apiName;
            return ((((((((((((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + Integer.hashCode(this.parameterLen)) * 31) + Integer.hashCode(this.resultLen)) * 31) + Integer.hashCode(this.parameterHash)) * 31) + Integer.hashCode(this.resultHash)) * 31) + Integer.hashCode(this.progressPercent)) * 31) + Long.hashCode(this.progressDurationMs);
        }

        public String toString() {
            return "ToolFrameSig(status=" + this.status + " toolCallId=" + this.toolCallId + " finished=" + this.isFinished + " name=" + this.name + " apiName=" + this.apiName + " paramLen=" + this.parameterLen + " resultLen=" + this.resultLen + " paramHash=" + this.parameterHash + " resultHash=" + this.resultHash + " progress=" + this.progressPercent + " durationMs=" + this.progressDurationMs + " compact=" + this.compactHash + ")";
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0016\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u0013R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010 \u001a\u0004\b!\u0010\u0015R\u0017\u0010\u000b\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010 \u001a\u0004\b\"\u0010\u0015R\u0017\u0010#\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b#\u0010 \u001a\u0004\b$\u0010\u0015¨\u0006%"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/ToolDedupSignature$b;", "", "", "messageId", "Lcom/stepos/agentframework/chatcore/session/EReplyStatus;", "messageStatus", "", "Lcom/stepos/agentframework/chatcore/session/ToolDedupSignature$a;", "tools", "", "sourcesCount", "sourcesHash", "<init>", "(Ljava/lang/String;Lcom/stepos/agentframework/chatcore/session/EReplyStatus;Ljava/util/List;II)V", "other", "", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/agentframework/chatcore/session/ToolDedupSignature$b;)Z", "toString", "()Ljava/lang/String;", "hashCode", "()I", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getMessageId", "Lcom/stepos/agentframework/chatcore/session/EReplyStatus;", "getMessageStatus", "()Lcom/stepos/agentframework/chatcore/session/EReplyStatus;", "Ljava/util/List;", "getTools", "()Ljava/util/List;", "I", "getSourcesCount", "getSourcesHash", "compactHash", Const.INTENT_KEY_APIKEY, "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatcore.session.ToolDedupSignature$b, reason: from toString */
    public static final /* data */ class ToolUpsertSig {
        private final int compactHash;
        private final String messageId;
        private final EReplyStatus messageStatus;
        private final int sourcesCount;
        private final int sourcesHash;
        private final List<ToolFrameSig> tools;

        public ToolUpsertSig(String messageId, EReplyStatus messageStatus, List<ToolFrameSig> tools, int i10, int i11) {
            kotlin.jvm.internal.p.i(messageId, "messageId");
            kotlin.jvm.internal.p.i(messageStatus, "messageStatus");
            kotlin.jvm.internal.p.i(tools, "tools");
            this.messageId = messageId;
            this.messageStatus = messageStatus;
            this.tools = tools;
            this.sourcesCount = i10;
            this.sourcesHash = i11;
            List<ToolFrameSig> list = tools;
            ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf(((ToolFrameSig) it.next()).getCompactHash()));
            }
            this.compactHash = C1173v.p(messageId, messageStatus, arrayList, Integer.valueOf(this.sourcesCount), Integer.valueOf(this.sourcesHash)).hashCode();
        }

        /* renamed from: a, reason: from getter */
        public final int getCompactHash() {
            return this.compactHash;
        }

        public final boolean b(ToolUpsertSig other) {
            kotlin.jvm.internal.p.i(other, "other");
            if (!kotlin.jvm.internal.p.d(this.messageId, other.messageId) || this.messageStatus != other.messageStatus || this.sourcesCount != other.sourcesCount || this.sourcesHash != other.sourcesHash || this.tools.size() != other.tools.size()) {
                return false;
            }
            List<Pair> listW1 = Z8.F.w1(this.tools, other.tools);
            if ((listW1 instanceof Collection) && listW1.isEmpty()) {
                return true;
            }
            for (Pair pair : listW1) {
                if (!((ToolFrameSig) pair.a()).b((ToolFrameSig) pair.b())) {
                    return false;
                }
            }
            return true;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ToolUpsertSig)) {
                return false;
            }
            ToolUpsertSig toolUpsertSig = (ToolUpsertSig) other;
            return kotlin.jvm.internal.p.d(this.messageId, toolUpsertSig.messageId) && this.messageStatus == toolUpsertSig.messageStatus && kotlin.jvm.internal.p.d(this.tools, toolUpsertSig.tools) && this.sourcesCount == toolUpsertSig.sourcesCount && this.sourcesHash == toolUpsertSig.sourcesHash;
        }

        public int hashCode() {
            return (((((((this.messageId.hashCode() * 31) + this.messageStatus.hashCode()) * 31) + this.tools.hashCode()) * 31) + Integer.hashCode(this.sourcesCount)) * 31) + Integer.hashCode(this.sourcesHash);
        }

        public String toString() {
            return "ToolUpsertSig(messageId=" + this.messageId + " status=" + this.messageStatus + " tools=" + this.tools.size() + " sources=" + this.sourcesCount + "/" + this.sourcesHash + " compact=" + this.compactHash + ")";
        }
    }

    public final ToolFrameSig a(ChatMessage message, AgentTool tool) {
        kotlin.jvm.internal.p.i(message, "message");
        kotlin.jvm.internal.p.i(tool, "tool");
        String parameter = tool.getParameter();
        String result = tool.getResult();
        return new ToolFrameSig(message.getStatus(), tool.getToolCallId(), tool.getIsFinished(), tool.getName(), tool.getApiName(), parameter != null ? parameter.length() : 0, result != null ? result.length() : 0, parameter != null ? parameter.hashCode() : 0, result != null ? result.hashCode() : 0, tool.getProgressPercent(), tool.getProgressDurationMs());
    }

    public final ToolUpsertSig b(ChatMessage message) {
        kotlin.jvm.internal.p.i(message, "message");
        List<AgentMessage> listI = message.i();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = listI.iterator();
        while (it.hasNext()) {
            List<AgentTool> listG = ((AgentMessage) it.next()).g();
            if (listG == null) {
                listG = C1173v.m();
            }
            List<AgentTool> list = listG;
            ArrayList arrayList2 = new ArrayList(C1174w.x(list, 10));
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                arrayList2.add(INSTANCE.a(message, (AgentTool) it2.next()));
            }
            Z8.A.E(arrayList, arrayList2);
        }
        List<ReferenceSource> listS = message.s();
        return new ToolUpsertSig(message.getMessageId(), message.getStatus(), arrayList, listS != null ? listS.size() : 0, listS != null ? listS.hashCode() : 0);
    }
}
