package com.stepos.ability.appfunctions;

import B7.a;
import D7.q;
import D7.v;
import D7.w;
import H4.o;
import J7.c;
import android.app.appsearch.AppSearchManager;
import android.app.appsearch.AppSearchResult;
import android.app.appsearch.GenericDocument;
import android.app.appsearch.GlobalSearchSession;
import android.app.appsearch.SearchResult;
import android.app.appsearch.SearchResults;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import android.util.Log;
import androidx.autofill.HintConstants;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import j9.m;
import j9.t;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.b;
import kotlin.collections.EmptyList;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import kotlin.text.Regex;
import m9.C1718k;
import m9.InterfaceC1717j;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000ò\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b3\n\u0002\u0010\u0011\n\u0002\b\u0013\n\u0002\u0010\u0018\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0013\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\"\n\u0002\b\u0019\bÆ\u0002\u0018\u00002\u00020\u0001:\né\u0001ê\u0001ë\u0001ì\u0001í\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0086@¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u000e\u001a\u00020\r*\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u0010*\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u00182\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u0019\u0010\u001aJ\u0013\u0010\u001b\u001a\u0004\u0018\u00010\r*\u00020\t¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010 \u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001f\u001a\u00020\t¢\u0006\u0004\b \u0010!J\u001f\u0010#\u001a\u00020\"2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001f\u001a\u00020\t¢\u0006\u0004\b#\u0010$JF\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001d0(2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\t2\u0014\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00182\b\b\u0002\u0010'\u001a\u00020&H\u0086@¢\u0006\u0004\b)\u0010*J@\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001d0(2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010-\u001a\u00020,2\b\b\u0002\u0010'\u001a\u00020&H\u0086@¢\u0006\u0004\b.\u0010/JE\u00104\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u001d2\b\u00101\u001a\u0004\u0018\u00010\u001d2\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002020\u0018H\u0002¢\u0006\u0004\b4\u00105J\u0019\u00108\u001a\u0004\u0018\u0001072\u0006\u00106\u001a\u00020\u001dH\u0002¢\u0006\u0004\b8\u00109J#\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002020\u00182\u0006\u0010:\u001a\u00020\u001dH\u0002¢\u0006\u0004\b;\u0010<J%\u0010@\u001a\u0004\u0018\u00010?2\u0006\u0010=\u001a\u00020\u001d2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b@\u0010AJ'\u0010D\u001a\u0004\u0018\u00010\u00062\u0006\u0010B\u001a\u00020\u001d2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0002¢\u0006\u0004\bD\u0010EJ\u0017\u0010G\u001a\u00020\u00062\u0006\u0010F\u001a\u00020\u0006H\u0002¢\u0006\u0004\bG\u0010HJ+\u0010J\u001a\u00020\r2\u0006\u0010I\u001a\u0002072\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002020\u0018H\u0002¢\u0006\u0004\bJ\u0010KJG\u0010P\u001a\u00020\r2\u0006\u0010L\u001a\u00020&2\u0006\u0010M\u001a\u00020,2\b\u0010N\u001a\u0004\u0018\u00010\u00062\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002020\u00182\b\b\u0002\u0010O\u001a\u00020&H\u0002¢\u0006\u0004\bP\u0010QJ3\u0010S\u001a\u00020\r2\u0006\u0010R\u001a\u0002022\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002020\u00182\u0006\u0010O\u001a\u00020&H\u0002¢\u0006\u0004\bS\u0010TJC\u0010X\u001a\u00020\r2\u0006\u0010U\u001a\u00020\u00062\u0006\u0010V\u001a\u00020?2\u0006\u0010W\u001a\u0002022\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002020\u00182\u0006\u0010O\u001a\u00020&H\u0002¢\u0006\u0004\bX\u0010YJE\u0010[\u001a\u0004\u0018\u0001022\u0006\u0010Z\u001a\u00020?2\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002020\u00182\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010W\u001a\u0004\u0018\u000102H\u0002¢\u0006\u0004\b[\u0010\\J5\u0010]\u001a\u0004\u0018\u00010\u00062\u0006\u0010W\u001a\u0002022\u0006\u0010Z\u001a\u00020?2\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002020\u0018H\u0002¢\u0006\u0004\b]\u0010^J-\u0010_\u001a\u0004\u0018\u0001022\u0006\u00106\u001a\u00020\u001d2\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002020\u0018H\u0002¢\u0006\u0004\b_\u0010`J\u001b\u0010a\u001a\u0004\u0018\u00010\u001d2\b\u00106\u001a\u0004\u0018\u00010\u001dH\u0002¢\u0006\u0004\ba\u0010bJ\u0017\u0010d\u001a\u00020\r2\u0006\u0010c\u001a\u00020\rH\u0002¢\u0006\u0004\bd\u0010eJ!\u0010f\u001a\u00020\r2\b\u00106\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001f\u001a\u00020\tH\u0002¢\u0006\u0004\bf\u0010gJ3\u0010i\u001a\u00020\r2\u0006\u00106\u001a\u00020\u001d2\u0006\u0010h\u001a\u0002022\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002020\u0018H\u0002¢\u0006\u0004\bi\u0010jJ\u0017\u0010k\u001a\u00020\r2\u0006\u00106\u001a\u00020\u001dH\u0002¢\u0006\u0004\bk\u0010lJE\u0010o\u001a\u0004\u0018\u00010\u00012\b\u0010m\u001a\u0004\u0018\u00010\u00012\b\u0010n\u001a\u0004\u0018\u00010?2\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002020\u00182\n\b\u0002\u0010W\u001a\u0004\u0018\u000102H\u0002¢\u0006\u0004\bo\u0010pJO\u0010q\u001a\u0004\u0018\u00010\u00012\u0006\u0010m\u001a\u00020\u00012\b\u0010n\u001a\u0004\u0018\u00010?2\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002020\u00182\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010W\u001a\u0004\u0018\u000102H\u0002¢\u0006\u0004\bq\u0010rJG\u0010u\u001a\u0004\u0018\u00010\u00012\n\u0010m\u001a\u0006\u0012\u0002\b\u00030s2\b\u0010n\u001a\u0004\u0018\u00010?2\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002020\u00182\n\b\u0002\u0010t\u001a\u0004\u0018\u000102H\u0002¢\u0006\u0004\bu\u0010vJE\u0010w\u001a\u00020\u00012\u0006\u00106\u001a\u00020\u001d2\n\b\u0002\u0010n\u001a\u0004\u0018\u00010?2\u0014\b\u0002\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002020\u00182\n\b\u0002\u0010t\u001a\u0004\u0018\u000102H\u0002¢\u0006\u0004\bw\u0010xJ9\u0010z\u001a\u00020\u00102\u0006\u00106\u001a\u00020\u001d2\n\b\u0002\u0010y\u001a\u0004\u0018\u0001022\u0014\b\u0002\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002020\u0018H\u0002¢\u0006\u0004\bz\u0010{J!\u0010~\u001a\u0004\u0018\u00010\u00012\u0006\u0010|\u001a\u00020\u00012\u0006\u0010}\u001a\u00020&H\u0002¢\u0006\u0004\b~\u0010\u007fJ\u001a\u0010\u0080\u0001\u001a\u00020,2\u0006\u00106\u001a\u00020\u001dH\u0002¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J\u001c\u0010\u0082\u0001\u001a\u00020,2\b\u0010m\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001J\u001a\u0010\u0084\u0001\u001a\u00020&2\u0006\u0010m\u001a\u00020\u0001H\u0002¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J#\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u00012\u0006\u0010m\u001a\u00020\u00012\u0006\u0010}\u001a\u00020&H\u0002¢\u0006\u0005\b\u0086\u0001\u0010\u007fJ\u001b\u0010\u0088\u0001\u001a\u00020\u00102\u0007\u0010m\u001a\u00030\u0087\u0001H\u0002¢\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001J\u001b\u0010\u008b\u0001\u001a\u00020\u00102\u0007\u0010m\u001a\u00030\u008a\u0001H\u0002¢\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001J\u001b\u0010\u008e\u0001\u001a\u00020\u00102\u0007\u0010m\u001a\u00030\u008d\u0001H\u0002¢\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001J\u001b\u0010\u0091\u0001\u001a\u00020\u00102\u0007\u0010m\u001a\u00030\u0090\u0001H\u0002¢\u0006\u0006\b\u0091\u0001\u0010\u0092\u0001J\u001b\u0010\u0094\u0001\u001a\u00020\u00102\u0007\u0010m\u001a\u00030\u0093\u0001H\u0002¢\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001J\u001c\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u001d2\u0006\u0010m\u001a\u00020\u0001H\u0002¢\u0006\u0006\b\u0096\u0001\u0010\u0097\u0001J%\u0010\u0099\u0001\u001a\u00020,2\u0006\u0010c\u001a\u00020\r2\t\u0010\u0098\u0001\u001a\u0004\u0018\u000102H\u0002¢\u0006\u0006\b\u0099\u0001\u0010\u009a\u0001J#\u0010\u009c\u0001\u001a\u00020,2\u0006\u0010c\u001a\u00020\r2\u0007\u0010\u009b\u0001\u001a\u00020\u0006H\u0002¢\u0006\u0006\b\u009c\u0001\u0010\u009d\u0001J$\u0010\u009f\u0001\u001a\u00030\u009e\u00012\u0006\u0010c\u001a\u00020\r2\u0007\u0010\u009b\u0001\u001a\u00020\u0006H\u0002¢\u0006\u0006\b\u009f\u0001\u0010 \u0001J'\u0010¡\u0001\u001a\u0004\u0018\u00010\u00062\u0006\u0010c\u001a\u00020\r2\t\u0010\u0098\u0001\u001a\u0004\u0018\u000102H\u0002¢\u0006\u0006\b¡\u0001\u0010¢\u0001J%\u0010£\u0001\u001a\u0004\u0018\u00010\u00062\u0006\u0010c\u001a\u00020\r2\u0007\u0010\u009b\u0001\u001a\u00020\u0006H\u0002¢\u0006\u0006\b£\u0001\u0010¤\u0001J\u001b\u0010¦\u0001\u001a\u00020,2\u0007\u0010¥\u0001\u001a\u00020\u0006H\u0002¢\u0006\u0006\b¦\u0001\u0010§\u0001J0\u0010¨\u0001\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\t2\u0014\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0018H\u0002¢\u0006\u0006\b¨\u0001\u0010©\u0001J\u001b\u0010«\u0001\u001a\u00020,2\u0007\u0010ª\u0001\u001a\u00020\u0001H\u0002¢\u0006\u0006\b«\u0001\u0010\u0083\u0001J;\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\u001d2\u0007\u0010¬\u0001\u001a\u00020\u00012\b\u0010N\u001a\u0004\u0018\u00010\u00062\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002020\u0018H\u0002¢\u0006\u0006\b\u00ad\u0001\u0010®\u0001J7\u0010·\u0001\u001a\b\u0012\u0004\u0012\u00020\u001d0(2\b\u0010°\u0001\u001a\u00030¯\u00012\b\u0010²\u0001\u001a\u00030±\u00012\b\u0010´\u0001\u001a\u00030³\u0001H\u0082@¢\u0006\u0006\bµ\u0001\u0010¶\u0001J#\u0010¹\u0001\u001a\u00030¸\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0006H\u0002¢\u0006\u0006\b¹\u0001\u0010º\u0001J(\u0010¾\u0001\u001a\u00030½\u00012\b\u0010¼\u0001\u001a\u00030»\u00012\b\u0010´\u0001\u001a\u00030³\u0001H\u0082@¢\u0006\u0006\b¾\u0001\u0010¿\u0001J.\u0010Ã\u0001\u001a\t\u0012\u0005\u0012\u00030Â\u00010\b2\b\u0010Á\u0001\u001a\u00030À\u00012\b\u0010´\u0001\u001a\u00030³\u0001H\u0082@¢\u0006\u0006\bÃ\u0001\u0010Ä\u0001J \u0010Å\u0001\u001a\u0004\u0018\u00010\u0006*\u00020\u001d2\u0006\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0006\bÅ\u0001\u0010Æ\u0001J&\u0010Ç\u0001\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010s*\u00020\u001d2\u0006\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0006\bÇ\u0001\u0010È\u0001J!\u0010É\u0001\u001a\u0005\u0018\u00010\u008a\u0001*\u00020\u001d2\u0006\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0006\bÉ\u0001\u0010Ê\u0001J!\u0010Ë\u0001\u001a\u0005\u0018\u00010\u0087\u0001*\u00020\u001d2\u0006\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0006\bË\u0001\u0010Ì\u0001R\u0017\u0010Í\u0001\u001a\u00020\u00068\u0002X\u0082T¢\u0006\b\n\u0006\bÍ\u0001\u0010Î\u0001R\u0017\u0010Ï\u0001\u001a\u00020\u00068\u0002X\u0082T¢\u0006\b\n\u0006\bÏ\u0001\u0010Î\u0001R\u0017\u0010Ð\u0001\u001a\u00020\u00068\u0002X\u0082T¢\u0006\b\n\u0006\bÐ\u0001\u0010Î\u0001R\u0017\u0010Ñ\u0001\u001a\u00020\u00068\u0002X\u0082T¢\u0006\b\n\u0006\bÑ\u0001\u0010Î\u0001R\u0017\u0010Ò\u0001\u001a\u00020\u00068\u0002X\u0082T¢\u0006\b\n\u0006\bÒ\u0001\u0010Î\u0001R\u001d\u0010Ó\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060\b8\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÓ\u0001\u0010Ô\u0001R\u001e\u0010Ö\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060Õ\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÖ\u0001\u0010×\u0001R\u001e\u0010Ø\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060Õ\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bØ\u0001\u0010×\u0001R\u001d\u0010Ù\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060\b8\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÙ\u0001\u0010Ô\u0001R\u0017\u0010Ú\u0001\u001a\u00020&8\u0002X\u0082T¢\u0006\b\n\u0006\bÚ\u0001\u0010Û\u0001R\u0017\u0010Ü\u0001\u001a\u00020&8\u0002X\u0082T¢\u0006\b\n\u0006\bÜ\u0001\u0010Û\u0001R\u0017\u0010Ý\u0001\u001a\u00020&8\u0002X\u0082T¢\u0006\b\n\u0006\bÝ\u0001\u0010Û\u0001R\u0017\u0010Þ\u0001\u001a\u00020&8\u0002X\u0082T¢\u0006\b\n\u0006\bÞ\u0001\u0010Û\u0001R\u0017\u0010ß\u0001\u001a\u00020&8\u0002X\u0082T¢\u0006\b\n\u0006\bß\u0001\u0010Û\u0001R\u0017\u0010à\u0001\u001a\u00020&8\u0002X\u0082T¢\u0006\b\n\u0006\bà\u0001\u0010Û\u0001R\u0017\u0010á\u0001\u001a\u00020&8\u0002X\u0082T¢\u0006\b\n\u0006\bá\u0001\u0010Û\u0001R\u0017\u0010â\u0001\u001a\u00020&8\u0002X\u0082T¢\u0006\b\n\u0006\bâ\u0001\u0010Û\u0001R\u0017\u0010ã\u0001\u001a\u00020&8\u0002X\u0082T¢\u0006\b\n\u0006\bã\u0001\u0010Û\u0001R\u0017\u0010ä\u0001\u001a\u00020&8\u0002X\u0082T¢\u0006\b\n\u0006\bä\u0001\u0010Û\u0001R\u0017\u0010å\u0001\u001a\u00020&8\u0002X\u0082T¢\u0006\b\n\u0006\bå\u0001\u0010Û\u0001R\u0017\u0010æ\u0001\u001a\u00020&8\u0002X\u0082T¢\u0006\b\n\u0006\bæ\u0001\u0010Û\u0001R\u0017\u0010ç\u0001\u001a\u00020&8\u0002X\u0082T¢\u0006\b\n\u0006\bç\u0001\u0010Û\u0001R\u0017\u0010è\u0001\u001a\u00020&8\u0002X\u0082T¢\u0006\b\n\u0006\bè\u0001\u0010Û\u0001¨\u0006î\u0001"}, d2 = {"Lcom/stepos/ability/appfunctions/DirectAppFunctions;", "", AppAgent.CONSTRUCT, "()V", "Landroid/content/Context;", "context", "", "targetPackage", "", "Lcom/stepos/ability/appfunctions/DirectAppFunctions$Entry;", "scan", "(Landroid/content/Context;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", HintConstants.AUTOFILL_HINT_NAME, "Lorg/json/JSONObject;", "toAnthropicTool", "(Lcom/stepos/ability/appfunctions/DirectAppFunctions$Entry;Ljava/lang/String;)Lorg/json/JSONObject;", "Lorg/json/JSONArray;", "toAnthropicTools", "(Ljava/util/List;)Lorg/json/JSONArray;", "pkg", "functionId", "encodeToolName", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "entries", "", "buildToolNameIndex", "(Ljava/util/List;)Ljava/util/Map;", "toOutputSchemaJson", "(Lcom/stepos/ability/appfunctions/DirectAppFunctions$Entry;)Lorg/json/JSONObject;", "Landroid/app/appsearch/GenericDocument;", "gd", "entry", "summarize", "(Landroid/app/appsearch/GenericDocument;Lcom/stepos/ability/appfunctions/DirectAppFunctions$Entry;)Ljava/lang/String;", "Lcom/stepos/ability/appfunctions/DirectAppFunctions$AppFunctionBusinessResult;", "interpretBusinessResult", "(Landroid/app/appsearch/GenericDocument;Lcom/stepos/ability/appfunctions/DirectAppFunctions$Entry;)Lcom/stepos/ability/appfunctions/DirectAppFunctions$AppFunctionBusinessResult;", "args", "", "attempts", "Lkotlin/Result;", "execute-yxL6bBk", "(Landroid/content/Context;Lcom/stepos/ability/appfunctions/DirectAppFunctions$Entry;Ljava/util/Map;ILH7/c;)Ljava/lang/Object;", "execute", "", "enable", "execute-hUnOzRk", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ZILH7/c;)Ljava/lang/Object;", "runtimeDoc", "staticDoc", "Lcom/stepos/ability/appfunctions/DirectAppFunctions$ObjectSchema;", "components", "buildEntry", "(Ljava/lang/String;Ljava/lang/String;Landroid/app/appsearch/GenericDocument;Landroid/app/appsearch/GenericDocument;Ljava/util/Map;)Lcom/stepos/ability/appfunctions/DirectAppFunctions$Entry;", "doc", "Lcom/stepos/ability/appfunctions/DirectAppFunctions$Param;", "parseParam", "(Landroid/app/appsearch/GenericDocument;)Lcom/stepos/ability/appfunctions/DirectAppFunctions$Param;", "componentsDoc", "parseComponents", "(Landroid/app/appsearch/GenericDocument;)Ljava/util/Map;", "dataTypeMeta", "description", "Lcom/stepos/ability/appfunctions/DirectAppFunctions$PropertySchema;", "parseDataTypeMetadata", "(Landroid/app/appsearch/GenericDocument;Ljava/lang/String;)Lcom/stepos/ability/appfunctions/DirectAppFunctions$PropertySchema;", "meta", "nestedKeys", "resolveQualifiedNameFromTypeMetadata", "(Landroid/app/appsearch/GenericDocument;Ljava/util/List;)Ljava/lang/String;", "s", "identifierCamelToSnake", "(Ljava/lang/String;)Ljava/lang/String;", "p", "paramJsonSchema", "(Lcom/stepos/ability/appfunctions/DirectAppFunctions$Param;Ljava/util/Map;)Lorg/json/JSONObject;", "type", "isNullable", "refQualifiedName", "depth", "typeIdToJsonSchema", "(IZLjava/lang/String;Ljava/util/Map;I)Lorg/json/JSONObject;", "obj", "inlineObjectSchema", "(Lcom/stepos/ability/appfunctions/DirectAppFunctions$ObjectSchema;Ljava/util/Map;I)Lorg/json/JSONObject;", "propName", "prop", "parentSchema", "propertySchemaToJson", "(Ljava/lang/String;Lcom/stepos/ability/appfunctions/DirectAppFunctions$PropertySchema;Lcom/stepos/ability/appfunctions/DirectAppFunctions$ObjectSchema;Ljava/util/Map;I)Lorg/json/JSONObject;", "propertySchema", "resolveArrayItemSchema", "(Lcom/stepos/ability/appfunctions/DirectAppFunctions$PropertySchema;Ljava/util/Map;Landroid/app/appsearch/GenericDocument;Lcom/stepos/ability/appfunctions/DirectAppFunctions$ObjectSchema;)Lcom/stepos/ability/appfunctions/DirectAppFunctions$ObjectSchema;", "inferArrayItemQualifiedName", "(Lcom/stepos/ability/appfunctions/DirectAppFunctions$ObjectSchema;Lcom/stepos/ability/appfunctions/DirectAppFunctions$PropertySchema;Ljava/util/Map;)Ljava/lang/String;", "matchComponentByFieldNames", "(Landroid/app/appsearch/GenericDocument;Ljava/util/Map;)Lcom/stepos/ability/appfunctions/DirectAppFunctions$ObjectSchema;", "unwrapReturnDocument", "(Landroid/app/appsearch/GenericDocument;)Landroid/app/appsearch/GenericDocument;", "payload", "normalizeResultPayload", "(Lorg/json/JSONObject;)Lorg/json/JSONObject;", "documentToJson", "(Landroid/app/appsearch/GenericDocument;Lcom/stepos/ability/appfunctions/DirectAppFunctions$Entry;)Lorg/json/JSONObject;", "schema", "objectDocumentToJson", "(Landroid/app/appsearch/GenericDocument;Lcom/stepos/ability/appfunctions/DirectAppFunctions$ObjectSchema;Ljava/util/Map;)Lorg/json/JSONObject;", "genericDocumentToJson", "(Landroid/app/appsearch/GenericDocument;)Lorg/json/JSONObject;", "value", "propSchema", "propertyValueToJson", "(Ljava/lang/Object;Lcom/stepos/ability/appfunctions/DirectAppFunctions$PropertySchema;Ljava/util/Map;Lcom/stepos/ability/appfunctions/DirectAppFunctions$ObjectSchema;)Ljava/lang/Object;", "convertAppSearchValue", "(Ljava/lang/Object;Lcom/stepos/ability/appfunctions/DirectAppFunctions$PropertySchema;Ljava/util/Map;Landroid/app/appsearch/GenericDocument;Lcom/stepos/ability/appfunctions/DirectAppFunctions$ObjectSchema;)Ljava/lang/Object;", "", "arrayItemSchema", "convertObjectArray", "([Ljava/lang/Object;Lcom/stepos/ability/appfunctions/DirectAppFunctions$PropertySchema;Ljava/util/Map;Lcom/stepos/ability/appfunctions/DirectAppFunctions$ObjectSchema;)Ljava/lang/Object;", "documentToJsonObject", "(Landroid/app/appsearch/GenericDocument;Lcom/stepos/ability/appfunctions/DirectAppFunctions$PropertySchema;Ljava/util/Map;Lcom/stepos/ability/appfunctions/DirectAppFunctions$ObjectSchema;)Ljava/lang/Object;", "itemSchema", "columnarDocumentToJsonArray", "(Landroid/app/appsearch/GenericDocument;Lcom/stepos/ability/appfunctions/DirectAppFunctions$ObjectSchema;Ljava/util/Map;)Lorg/json/JSONArray;", "column", "index", "wrapIndexValue", "(Ljava/lang/Object;I)Ljava/lang/Object;", "isColumnarArrayDocument", "(Landroid/app/appsearch/GenericDocument;)Z", "isArrayLike", "(Ljava/lang/Object;)Z", "arrayLikeSize", "(Ljava/lang/Object;)I", "arrayLikeElementToJson", "", "booleanArrayToJsonArray", "([Z)Lorg/json/JSONArray;", "", "longArrayToJsonArray", "([J)Lorg/json/JSONArray;", "", "intArrayToJsonArray", "([I)Lorg/json/JSONArray;", "", "doubleArrayToJsonArray", "([D)Lorg/json/JSONArray;", "", "floatArrayToJsonArray", "([F)Lorg/json/JSONArray;", "readDocumentValue", "(Ljava/lang/Object;)Landroid/app/appsearch/GenericDocument;", "responseSchema", "evaluateBusinessSuccess", "(Lorg/json/JSONObject;Lcom/stepos/ability/appfunctions/DirectAppFunctions$ObjectSchema;)Z", "field", "readJsonBoolean", "(Lorg/json/JSONObject;Ljava/lang/String;)Z", "", "readJsonLong", "(Lorg/json/JSONObject;Ljava/lang/String;)J", "extractErrorMessage", "(Lorg/json/JSONObject;Lcom/stepos/ability/appfunctions/DirectAppFunctions$ObjectSchema;)Ljava/lang/String;", "jsonFieldAsDisplayString", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;", "text", "isJvmArrayDump", "(Ljava/lang/String;)Z", "buildParamsDocument", "(Lcom/stepos/ability/appfunctions/DirectAppFunctions$Entry;Ljava/util/Map;)Landroid/app/appsearch/GenericDocument;", "v", "coerceBoolean", "raw", "jsonLikeToGenericDocument", "(Ljava/lang/Object;Ljava/lang/String;Ljava/util/Map;)Landroid/app/appsearch/GenericDocument;", "Landroid/app/appfunctions/AppFunctionManager;", "mgr", "Landroid/app/appfunctions/ExecuteAppFunctionRequest;", "req", "Ljava/util/concurrent/Executor;", "executor", "executeOnce-BWLJW6A", "(Landroid/app/appfunctions/AppFunctionManager;Landroid/app/appfunctions/ExecuteAppFunctionRequest;Ljava/util/concurrent/Executor;LH7/c;)Ljava/lang/Object;", "executeOnce", "LC7/r;", "wakeUp", "(Landroid/content/Context;Ljava/lang/String;)V", "Landroid/app/appsearch/AppSearchManager;", "asm", "Landroid/app/appsearch/GlobalSearchSession;", "openGlobalSession", "(Landroid/app/appsearch/AppSearchManager;Ljava/util/concurrent/Executor;LH7/c;)Ljava/lang/Object;", "Landroid/app/appsearch/SearchResults;", "results", "Landroid/app/appsearch/SearchResult;", "nextPage", "(Landroid/app/appsearch/SearchResults;Ljava/util/concurrent/Executor;LH7/c;)Ljava/lang/Object;", "optString", "(Landroid/app/appsearch/GenericDocument;Ljava/lang/String;)Ljava/lang/String;", "optStringArray", "(Landroid/app/appsearch/GenericDocument;Ljava/lang/String;)[Ljava/lang/String;", "optLongArray", "(Landroid/app/appsearch/GenericDocument;Ljava/lang/String;)[J", "optBooleanArray", "(Landroid/app/appsearch/GenericDocument;Ljava/lang/String;)[Z", "TAG", "Ljava/lang/String;", "NS_RUNTIME", "NS_STATIC", "PROPERTY_RETURN_VALUE", "PROPERTY_ANDROID_RETURN_VALUE", "RETURN_DOCUMENT_KEYS", "Ljava/util/List;", "", "SUCCESS_FIELD_NAMES", "Ljava/util/Set;", "STATUS_CODE_FIELD_NAMES", "ERROR_MESSAGE_FIELD_NAMES", "TYPE_UNIT", "I", "TYPE_BOOLEAN", "TYPE_BYTES", "TYPE_OBJECT", "TYPE_DOUBLE", "TYPE_FLOAT", "TYPE_LONG", "TYPE_INT", "TYPE_STRING", "TYPE_ARRAY", "TYPE_REFERENCE", "TYPE_ALL_OF", "TYPE_PENDING_INTENT", "TYPE_ONE_OF", "AppFunctionBusinessResult", "Entry", "Param", "ObjectSchema", "PropertySchema", "appfunctions_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DirectAppFunctions {
    private static final String NS_RUNTIME = "app_functions_runtime";
    private static final String NS_STATIC = "app_functions";
    private static final String PROPERTY_ANDROID_RETURN_VALUE = "androidAppfunctionsReturnValue";
    private static final String TAG = "DirectAppFunctions";
    private static final int TYPE_ALL_OF = 12;
    private static final int TYPE_ARRAY = 10;
    private static final int TYPE_BOOLEAN = 1;
    private static final int TYPE_BYTES = 2;
    private static final int TYPE_DOUBLE = 4;
    private static final int TYPE_FLOAT = 5;
    private static final int TYPE_INT = 7;
    private static final int TYPE_LONG = 6;
    private static final int TYPE_OBJECT = 3;
    private static final int TYPE_ONE_OF = 14;
    private static final int TYPE_PENDING_INTENT = 13;
    private static final int TYPE_REFERENCE = 11;
    private static final int TYPE_STRING = 8;
    private static final int TYPE_UNIT = 0;
    public static final DirectAppFunctions INSTANCE = new DirectAppFunctions();
    private static final String PROPERTY_RETURN_VALUE = "returnValue";
    private static final List<String> RETURN_DOCUMENT_KEYS = o.N(PROPERTY_RETURN_VALUE, "androidAppfunctionsReturnValue");
    private static final Set<String> SUCCESS_FIELD_NAMES = q.K0(new String[]{"success", "isSuccess", "ok"});
    private static final Set<String> STATUS_CODE_FIELD_NAMES = q.K0(new String[]{"code", "errorCode", "statusCode", "errno"});
    private static final List<String> ERROR_MESSAGE_FIELD_NAMES = o.N("errorMessage", "message", "error", "reason");

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/stepos/ability/appfunctions/DirectAppFunctions$AppFunctionBusinessResult;", "", "success", "", "payload", "Lorg/json/JSONObject;", "errorMessage", "", AppAgent.CONSTRUCT, "(ZLorg/json/JSONObject;Ljava/lang/String;)V", "getSuccess", "()Z", "getPayload", "()Lorg/json/JSONObject;", "getErrorMessage", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "appfunctions_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class AppFunctionBusinessResult {
        private final String errorMessage;
        private final JSONObject payload;
        private final boolean success;

        public AppFunctionBusinessResult(boolean z10, JSONObject payload, String str) {
            k.f(payload, "payload");
            this.success = z10;
            this.payload = payload;
            this.errorMessage = str;
        }

        public static /* synthetic */ AppFunctionBusinessResult copy$default(AppFunctionBusinessResult appFunctionBusinessResult, boolean z10, JSONObject jSONObject, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                z10 = appFunctionBusinessResult.success;
            }
            if ((i & 2) != 0) {
                jSONObject = appFunctionBusinessResult.payload;
            }
            if ((i & 4) != 0) {
                str = appFunctionBusinessResult.errorMessage;
            }
            return appFunctionBusinessResult.copy(z10, jSONObject, str);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getSuccess() {
            return this.success;
        }

        /* renamed from: component2, reason: from getter */
        public final JSONObject getPayload() {
            return this.payload;
        }

        /* renamed from: component3, reason: from getter */
        public final String getErrorMessage() {
            return this.errorMessage;
        }

        public final AppFunctionBusinessResult copy(boolean success, JSONObject payload, String errorMessage) {
            k.f(payload, "payload");
            return new AppFunctionBusinessResult(success, payload, errorMessage);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AppFunctionBusinessResult)) {
                return false;
            }
            AppFunctionBusinessResult appFunctionBusinessResult = (AppFunctionBusinessResult) other;
            return this.success == appFunctionBusinessResult.success && k.b(this.payload, appFunctionBusinessResult.payload) && k.b(this.errorMessage, appFunctionBusinessResult.errorMessage);
        }

        public final String getErrorMessage() {
            return this.errorMessage;
        }

        public final JSONObject getPayload() {
            return this.payload;
        }

        public final boolean getSuccess() {
            return this.success;
        }

        public int hashCode() {
            int iHashCode = (this.payload.hashCode() + (Boolean.hashCode(this.success) * 31)) * 31;
            String str = this.errorMessage;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            boolean z10 = this.success;
            JSONObject jSONObject = this.payload;
            String str = this.errorMessage;
            StringBuilder sb = new StringBuilder("AppFunctionBusinessResult(success=");
            sb.append(z10);
            sb.append(", payload=");
            sb.append(jSONObject);
            sb.append(", errorMessage=");
            return a.q(sb, str, ")");
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\bHÆ\u0003J\t\u0010\u0017\u001a\u00020\nHÆ\u0003JC\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/stepos/ability/appfunctions/DirectAppFunctions$ObjectSchema;", "", "qualifiedName", "", "properties", "", "Lcom/stepos/ability/appfunctions/DirectAppFunctions$PropertySchema;", "required", "", "isNullable", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/util/Map;Ljava/util/List;Z)V", "getQualifiedName", "()Ljava/lang/String;", "getProperties", "()Ljava/util/Map;", "getRequired", "()Ljava/util/List;", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "appfunctions_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ObjectSchema {
        private final boolean isNullable;
        private final Map<String, PropertySchema> properties;
        private final String qualifiedName;
        private final List<String> required;

        public ObjectSchema(String qualifiedName, Map<String, PropertySchema> properties, List<String> required, boolean z10) {
            k.f(qualifiedName, "qualifiedName");
            k.f(properties, "properties");
            k.f(required, "required");
            this.qualifiedName = qualifiedName;
            this.properties = properties;
            this.required = required;
            this.isNullable = z10;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ObjectSchema copy$default(ObjectSchema objectSchema, String str, Map map, List list, boolean z10, int i, Object obj) {
            if ((i & 1) != 0) {
                str = objectSchema.qualifiedName;
            }
            if ((i & 2) != 0) {
                map = objectSchema.properties;
            }
            if ((i & 4) != 0) {
                list = objectSchema.required;
            }
            if ((i & 8) != 0) {
                z10 = objectSchema.isNullable;
            }
            return objectSchema.copy(str, map, list, z10);
        }

        /* renamed from: component1, reason: from getter */
        public final String getQualifiedName() {
            return this.qualifiedName;
        }

        public final Map<String, PropertySchema> component2() {
            return this.properties;
        }

        public final List<String> component3() {
            return this.required;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getIsNullable() {
            return this.isNullable;
        }

        public final ObjectSchema copy(String qualifiedName, Map<String, PropertySchema> properties, List<String> required, boolean isNullable) {
            k.f(qualifiedName, "qualifiedName");
            k.f(properties, "properties");
            k.f(required, "required");
            return new ObjectSchema(qualifiedName, properties, required, isNullable);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ObjectSchema)) {
                return false;
            }
            ObjectSchema objectSchema = (ObjectSchema) other;
            return k.b(this.qualifiedName, objectSchema.qualifiedName) && k.b(this.properties, objectSchema.properties) && k.b(this.required, objectSchema.required) && this.isNullable == objectSchema.isNullable;
        }

        public final Map<String, PropertySchema> getProperties() {
            return this.properties;
        }

        public final String getQualifiedName() {
            return this.qualifiedName;
        }

        public final List<String> getRequired() {
            return this.required;
        }

        public int hashCode() {
            return Boolean.hashCode(this.isNullable) + androidx.appfunctions.metadata.a.e(this.required, androidx.appfunctions.metadata.a.f(this.properties, this.qualifiedName.hashCode() * 31, 31), 31);
        }

        public final boolean isNullable() {
            return this.isNullable;
        }

        public String toString() {
            return "ObjectSchema(qualifiedName=" + this.qualifiedName + ", properties=" + this.properties + ", required=" + this.required + ", isNullable=" + this.isNullable + ")";
        }
    }

    @c(c = "com.stepos.ability.appfunctions.DirectAppFunctions", f = "DirectAppFunctions.kt", l = {159, 171}, m = "scan", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ability.appfunctions.DirectAppFunctions$scan$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DirectAppFunctions.this.scan(null, null, this);
        }
    }

    private DirectAppFunctions() {
    }

    private final Object arrayLikeElementToJson(Object value, int index) {
        if (value instanceof boolean[]) {
            if (index < 0 || index >= ((boolean[]) value).length) {
                return null;
            }
            return Boolean.valueOf(((boolean[]) value)[index]);
        }
        if (value instanceof long[]) {
            if (index < 0 || index >= ((long[]) value).length) {
                return null;
            }
            return Long.valueOf(((long[]) value)[index]);
        }
        if (value instanceof int[]) {
            if (index < 0 || index >= ((int[]) value).length) {
                return null;
            }
            return Integer.valueOf(((int[]) value)[index]);
        }
        if (value instanceof double[]) {
            if (index < 0 || index >= ((double[]) value).length) {
                return null;
            }
            return Double.valueOf(((double[]) value)[index]);
        }
        if (value instanceof float[]) {
            if (index < 0 || index >= ((float[]) value).length) {
                return null;
            }
            return Float.valueOf(((float[]) value)[index]);
        }
        if (!(value instanceof Object[]) || index < 0 || index >= ((Object[]) value).length) {
            return null;
        }
        Object obj = ((Object[]) value)[index];
        if (obj instanceof GenericDocument) {
            return genericDocumentToJson((GenericDocument) obj);
        }
        if ((obj instanceof String) || (obj instanceof Boolean) || (obj instanceof Number)) {
            return obj;
        }
        if (obj != null) {
            return obj.toString();
        }
        return null;
    }

    private final int arrayLikeSize(Object value) {
        if (value instanceof boolean[]) {
            return ((boolean[]) value).length;
        }
        if (value instanceof long[]) {
            return ((long[]) value).length;
        }
        if (value instanceof int[]) {
            return ((int[]) value).length;
        }
        if (value instanceof double[]) {
            return ((double[]) value).length;
        }
        if (value instanceof float[]) {
            return ((float[]) value).length;
        }
        if (value instanceof byte[]) {
            return ((byte[]) value).length;
        }
        if (value instanceof Object[]) {
            return ((Object[]) value).length;
        }
        return 0;
    }

    private final JSONArray booleanArrayToJsonArray(boolean[] value) {
        JSONArray jSONArray = new JSONArray();
        for (boolean z10 : value) {
            jSONArray.put(z10);
        }
        return jSONArray;
    }

    /* JADX WARN: Removed duplicated region for block: B:79:0x0136  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.stepos.ability.appfunctions.DirectAppFunctions.Entry buildEntry(java.lang.String r19, java.lang.String r20, android.app.appsearch.GenericDocument r21, android.app.appsearch.GenericDocument r22, java.util.Map<java.lang.String, com.stepos.ability.appfunctions.DirectAppFunctions.ObjectSchema> r23) {
        /*
            Method dump skipped, instructions count: 330
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.appfunctions.DirectAppFunctions.buildEntry(java.lang.String, java.lang.String, android.app.appsearch.GenericDocument, android.app.appsearch.GenericDocument, java.util.Map):com.stepos.ability.appfunctions.DirectAppFunctions$Entry");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final GenericDocument buildParamsDocument(Entry entry, Map<String, ? extends Object> args) {
        GenericDocument.Builder builder = new GenericDocument.Builder("", "", "");
        for (Param param : entry.getParameters()) {
            Object obj = args.get(param.getName());
            if (obj != null) {
                try {
                    switch (param.getType()) {
                        case 1:
                            k.e(builder.setPropertyBoolean(param.getName(), INSTANCE.coerceBoolean(obj)), "setPropertyBoolean(...)");
                            break;
                        case 2:
                            if (obj instanceof byte[]) {
                                k.e(builder.setPropertyBytes(param.getName(), obj), "setPropertyBytes(...)");
                                break;
                            } else if (obj instanceof String) {
                                k.e(builder.setPropertyBytes(param.getName(), Base64.decode((String) obj, 0)), "setPropertyBytes(...)");
                                break;
                            } else {
                                Log.w(TAG, "execute: param '" + param.getName() + "' bytes expects ByteArray/Base64 string, got " + obj.getClass());
                                break;
                            }
                        case 3:
                        case 11:
                        case 12:
                        case 14:
                            GenericDocument genericDocumentJsonLikeToGenericDocument = INSTANCE.jsonLikeToGenericDocument(obj, param.getRefQualifiedName(), entry.getComponents());
                            if (genericDocumentJsonLikeToGenericDocument != null) {
                                k.e(builder.setPropertyDocument(param.getName(), genericDocumentJsonLikeToGenericDocument), "setPropertyDocument(...)");
                                break;
                            } else {
                                Log.w(TAG, "execute: param '" + param.getName() + "' object/ref needs Map but got " + obj.getClass());
                                break;
                            }
                        case 4:
                        case 5:
                            k.e(builder.setPropertyDouble(param.getName(), ((Number) obj).doubleValue()), "setPropertyDouble(...)");
                            break;
                        case 6:
                        case 7:
                            k.e(builder.setPropertyLong(param.getName(), ((Number) obj).longValue()), "setPropertyLong(...)");
                            break;
                        case 8:
                            k.e(builder.setPropertyString(param.getName(), obj.toString()), "setPropertyString(...)");
                            break;
                        case 9:
                        default:
                            Log.w(TAG, "execute: param '" + param.getName() + "' unsupported type " + param.getType());
                            break;
                        case 10:
                            if (obj instanceof List) {
                                ArrayList arrayList = new ArrayList();
                                for (Object obj2 : (Iterable) obj) {
                                    if (obj2 instanceof String) {
                                        arrayList.add(obj2);
                                    }
                                }
                                if (arrayList.size() == ((List) obj).size()) {
                                    String name = param.getName();
                                    String[] strArr = (String[]) arrayList.toArray(new String[0]);
                                    k.c(builder.setPropertyString(name, (String[]) Arrays.copyOf(strArr, strArr.length)));
                                    break;
                                } else {
                                    Log.w(TAG, "execute: param '" + param.getName() + "' array expects List<String>");
                                    break;
                                }
                            } else {
                                Log.w(TAG, "execute: param '" + param.getName() + "' TYPE_ARRAY expects List, got " + obj.getClass());
                                break;
                            }
                        case 13:
                            k.e(builder.setPropertyString(param.getName(), obj.toString()), "setPropertyString(...)");
                            break;
                    }
                } catch (Throwable th) {
                    Log.w(TAG, "execute: failed to set param '" + param.getName() + "': " + th);
                }
            } else if (param.isRequired() && !param.isNullable()) {
                androidx.constraintlayout.core.dsl.a.x("execute: required param '", param.getName(), "' missing for ", entry.getFunctionId(), TAG);
            }
        }
        GenericDocument genericDocumentBuild = builder.build();
        k.e(genericDocumentBuild, "build(...)");
        return genericDocumentBuild;
    }

    private final boolean coerceBoolean(Object v10) {
        if (v10 instanceof Boolean) {
            return ((Boolean) v10).booleanValue();
        }
        if (v10 instanceof Number) {
            return ((Number) v10).intValue() != 0;
        }
        if (v10 instanceof String) {
            return t.X((String) v10, "true") || k.b(v10, "1");
        }
        throw new IllegalArgumentException(androidx.appfunctions.metadata.a.j(v10, "cannot coerce to boolean: "));
    }

    private final JSONArray columnarDocumentToJsonArray(GenericDocument doc, ObjectSchema itemSchema, Map<String, ObjectSchema> components) throws JSONException {
        Map<String, PropertySchema> properties;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str : doc.getPropertyNames()) {
            Object property = doc.getProperty(str);
            if (property != null && isArrayLike(property)) {
                linkedHashMap.put(str, property);
            }
        }
        if (linkedHashMap.isEmpty()) {
            JSONArray jSONArrayPut = new JSONArray().put(genericDocumentToJson(doc));
            k.e(jSONArrayPut, "put(...)");
            return jSONArrayPut;
        }
        Collection collectionValues = linkedHashMap.values();
        k.e(collectionValues, "<get-values>(...)");
        Iterator it = collectionValues.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        Object next = it.next();
        DirectAppFunctions directAppFunctions = INSTANCE;
        k.c(next);
        int iArrayLikeSize = directAppFunctions.arrayLikeSize(next);
        while (it.hasNext()) {
            Object next2 = it.next();
            DirectAppFunctions directAppFunctions2 = INSTANCE;
            k.c(next2);
            int iArrayLikeSize2 = directAppFunctions2.arrayLikeSize(next2);
            if (iArrayLikeSize < iArrayLikeSize2) {
                iArrayLikeSize = iArrayLikeSize2;
            }
        }
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < iArrayLikeSize; i++) {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                String str2 = (String) entry.getKey();
                Object value = entry.getValue();
                Object objArrayLikeElementToJson = null;
                PropertySchema propertySchema = (itemSchema == null || (properties = itemSchema.getProperties()) == null) ? null : properties.get(str2);
                if (propertySchema != null) {
                    DirectAppFunctions directAppFunctions3 = INSTANCE;
                    Object objWrapIndexValue = directAppFunctions3.wrapIndexValue(value, i);
                    if (objWrapIndexValue != null) {
                        objArrayLikeElementToJson = propertyValueToJson$default(directAppFunctions3, objWrapIndexValue, propertySchema, components, null, 8, null);
                    }
                } else {
                    objArrayLikeElementToJson = INSTANCE.arrayLikeElementToJson(value, i);
                }
                if (objArrayLikeElementToJson != null) {
                    jSONObject.put(str2, objArrayLikeElementToJson);
                }
            }
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ JSONArray columnarDocumentToJsonArray$default(DirectAppFunctions directAppFunctions, GenericDocument genericDocument, ObjectSchema objectSchema, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            objectSchema = null;
        }
        if ((i & 4) != 0) {
            map = kotlin.collections.a.M();
        }
        return directAppFunctions.columnarDocumentToJsonArray(genericDocument, objectSchema, map);
    }

    private final Object convertAppSearchValue(Object value, PropertySchema propSchema, Map<String, ObjectSchema> components, GenericDocument runtimeDoc, ObjectSchema parentSchema) {
        ObjectSchema objectSchemaResolveArrayItemSchema;
        boolean z10 = propSchema != null && propSchema.getType() == 10;
        if (propSchema != null) {
            DirectAppFunctions directAppFunctions = INSTANCE;
            if (runtimeDoc == null) {
                runtimeDoc = directAppFunctions.readDocumentValue(value);
            }
            objectSchemaResolveArrayItemSchema = directAppFunctions.resolveArrayItemSchema(propSchema, components, runtimeDoc, parentSchema);
        } else {
            objectSchemaResolveArrayItemSchema = null;
        }
        if (value instanceof Boolean) {
            return value;
        }
        if (value instanceof boolean[]) {
            boolean[] zArr = (boolean[]) value;
            return z10 ? booleanArrayToJsonArray(zArr) : q.l0(zArr);
        }
        if (value instanceof Long) {
            return value;
        }
        if (value instanceof long[]) {
            long[] jArr = (long[]) value;
            return z10 ? longArrayToJsonArray(jArr) : q.m0(jArr);
        }
        if (value instanceof Integer) {
            return value;
        }
        if (value instanceof int[]) {
            int[] iArr = (int[]) value;
            if (z10) {
                return intArrayToJsonArray(iArr);
            }
            k.f(iArr, "<this>");
            if (iArr.length == 0) {
                return null;
            }
            return Integer.valueOf(iArr[0]);
        }
        if (value instanceof Double) {
            return value;
        }
        if (value instanceof double[]) {
            double[] dArr = (double[]) value;
            if (z10) {
                return doubleArrayToJsonArray(dArr);
            }
            k.f(dArr, "<this>");
            if (dArr.length != 0) {
                return Double.valueOf(dArr[0]);
            }
        } else {
            if (value instanceof Float) {
                return value;
            }
            if (value instanceof float[]) {
                float[] fArr = (float[]) value;
                if (z10) {
                    return floatArrayToJsonArray(fArr);
                }
                k.f(fArr, "<this>");
                if (fArr.length != 0) {
                    return Float.valueOf(fArr[0]);
                }
            } else {
                if (value instanceof String) {
                    return value;
                }
                if (value instanceof byte[]) {
                    return z10 ? new JSONArray().put(Base64.encodeToString((byte[]) value, 2)) : Base64.encodeToString((byte[]) value, 2);
                }
                if (value instanceof GenericDocument) {
                    return documentToJsonObject((GenericDocument) value, propSchema, components, objectSchemaResolveArrayItemSchema);
                }
                if (value instanceof Object[]) {
                    return convertObjectArray((Object[]) value, propSchema, components, objectSchemaResolveArrayItemSchema);
                }
            }
        }
        return null;
    }

    public static /* synthetic */ Object convertAppSearchValue$default(DirectAppFunctions directAppFunctions, Object obj, PropertySchema propertySchema, Map map, GenericDocument genericDocument, ObjectSchema objectSchema, int i, Object obj2) {
        if ((i & 8) != 0) {
            genericDocument = null;
        }
        if ((i & 16) != 0) {
            objectSchema = null;
        }
        return directAppFunctions.convertAppSearchValue(obj, propertySchema, map, genericDocument, objectSchema);
    }

    private final Object convertObjectArray(Object[] value, PropertySchema propSchema, Map<String, ObjectSchema> components, ObjectSchema arrayItemSchema) throws JSONException {
        PropertySchema propertySchema;
        Map<String, ObjectSchema> map;
        Object objGenericDocumentToJson;
        int i = 0;
        if (value instanceof GenericDocument[]) {
            GenericDocument[] genericDocumentArr = (GenericDocument[]) value;
            if (arrayItemSchema != null) {
                propertySchema = propSchema;
                map = components;
            } else if (propSchema != null) {
                propertySchema = propSchema;
                map = components;
                arrayItemSchema = resolveArrayItemSchema$default(INSTANCE, propertySchema, map, null, null, 12, null);
            } else {
                propertySchema = propSchema;
                map = components;
                arrayItemSchema = null;
            }
            if (propertySchema == null || propertySchema.getType() != 10) {
                GenericDocument genericDocument = (GenericDocument) q.n0(genericDocumentArr);
                if (genericDocument != null) {
                    return INSTANCE.documentToJsonObject(genericDocument, propertySchema, map, arrayItemSchema);
                }
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            int length = genericDocumentArr.length;
            while (i < length) {
                GenericDocument genericDocument2 = genericDocumentArr[i];
                if (arrayItemSchema != null) {
                    objGenericDocumentToJson = INSTANCE.objectDocumentToJson(genericDocument2, arrayItemSchema, map);
                } else {
                    DirectAppFunctions directAppFunctions = INSTANCE;
                    Object objDocumentToJsonObject = directAppFunctions.documentToJsonObject(genericDocument2, propertySchema, map, null);
                    objGenericDocumentToJson = ((objDocumentToJsonObject instanceof JSONObject) && ((JSONObject) objDocumentToJsonObject).length() == 0) ? directAppFunctions.genericDocumentToJson(genericDocument2) : objDocumentToJsonObject;
                }
                jSONArray.put(objGenericDocumentToJson);
                i++;
            }
            return jSONArray;
        }
        if (value instanceof String[]) {
            String[] strArr = (String[]) value;
            if (propSchema == null || propSchema.getType() != 10) {
                return q.n0(strArr);
            }
            JSONArray jSONArray2 = new JSONArray();
            int length2 = strArr.length;
            while (i < length2) {
                jSONArray2.put(strArr[i]);
                i++;
            }
            return jSONArray2;
        }
        if (value instanceof Boolean[]) {
            Boolean[] boolArr = (Boolean[]) value;
            if (propSchema == null || propSchema.getType() != 10) {
                return q.n0(boolArr);
            }
            JSONArray jSONArray3 = new JSONArray();
            int length3 = boolArr.length;
            while (i < length3) {
                jSONArray3.put(boolArr[i].booleanValue());
                i++;
            }
            return jSONArray3;
        }
        if (!(value instanceof Long[]) && !(value instanceof Integer[]) && !(value instanceof Double[])) {
            return null;
        }
        JSONArray jSONArray4 = new JSONArray();
        for (Object obj : value) {
            if (obj instanceof Number) {
                jSONArray4.put(obj);
            } else {
                jSONArray4.put(String.valueOf(obj));
            }
        }
        return (propSchema == null || propSchema.getType() != 10) ? jSONArray4.opt(0) : jSONArray4;
    }

    public static /* synthetic */ Object convertObjectArray$default(DirectAppFunctions directAppFunctions, Object[] objArr, PropertySchema propertySchema, Map map, ObjectSchema objectSchema, int i, Object obj) {
        if ((i & 8) != 0) {
            objectSchema = null;
        }
        return directAppFunctions.convertObjectArray(objArr, propertySchema, map, objectSchema);
    }

    private final JSONObject documentToJson(GenericDocument doc, Entry entry) {
        GenericDocument genericDocumentUnwrapReturnDocument = unwrapReturnDocument(doc);
        if (genericDocumentUnwrapReturnDocument == null) {
            return new JSONObject();
        }
        String responseTypeRef = entry.getResponseTypeRef();
        ObjectSchema objectSchema = responseTypeRef != null ? entry.getComponents().get(responseTypeRef) : null;
        return objectSchema != null ? objectDocumentToJson(genericDocumentUnwrapReturnDocument, objectSchema, entry.getComponents()) : genericDocumentToJson(genericDocumentUnwrapReturnDocument);
    }

    private final Object documentToJsonObject(GenericDocument doc, PropertySchema propSchema, Map<String, ObjectSchema> components, ObjectSchema arrayItemSchema) {
        String refQualifiedName;
        ObjectSchema objectSchema;
        if ((propSchema != null && propSchema.getType() == 10) || arrayItemSchema != null) {
            if (isColumnarArrayDocument(doc)) {
                return columnarDocumentToJsonArray(doc, arrayItemSchema, components);
            }
            if (arrayItemSchema != null) {
                return INSTANCE.objectDocumentToJson(doc, arrayItemSchema, components);
            }
        }
        if (propSchema != null && (refQualifiedName = propSchema.getRefQualifiedName()) != null && (objectSchema = components.get(refQualifiedName)) != null) {
            arrayItemSchema = objectSchema;
        }
        return arrayItemSchema != null ? objectDocumentToJson(doc, arrayItemSchema, components) : genericDocumentToJson(doc);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object documentToJsonObject$default(DirectAppFunctions directAppFunctions, GenericDocument genericDocument, PropertySchema propertySchema, Map map, ObjectSchema objectSchema, int i, Object obj) {
        if ((i & 2) != 0) {
            propertySchema = null;
        }
        if ((i & 4) != 0) {
            map = kotlin.collections.a.M();
        }
        if ((i & 8) != 0) {
            objectSchema = null;
        }
        return directAppFunctions.documentToJsonObject(genericDocument, propertySchema, map, objectSchema);
    }

    private final JSONArray doubleArrayToJsonArray(double[] value) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (double d : value) {
            jSONArray.put(d);
        }
        return jSONArray;
    }

    private final boolean evaluateBusinessSuccess(JSONObject payload, ObjectSchema responseSchema) {
        if (responseSchema == null) {
            return true;
        }
        for (Map.Entry<String, PropertySchema> entry : responseSchema.getProperties().entrySet()) {
            String key = entry.getKey();
            PropertySchema value = entry.getValue();
            if (value.getType() == 1 && SUCCESS_FIELD_NAMES.contains(key)) {
                if (responseSchema.getRequired().contains(key) || payload.has(key)) {
                    if (!readJsonBoolean(payload, key)) {
                        return false;
                    }
                }
            } else if (value.getType() == 7 || value.getType() == 6) {
                if (STATUS_CODE_FIELD_NAMES.contains(key) && (responseSchema.getRequired().contains(key) || payload.has(key))) {
                    if (readJsonLong(payload, key) != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /* renamed from: execute-hUnOzRk$default, reason: not valid java name */
    public static /* synthetic */ Object m7332executehUnOzRk$default(DirectAppFunctions directAppFunctions, Context context, String str, String str2, boolean z10, int i, H7.c cVar, int i6, Object obj) {
        if ((i6 & 16) != 0) {
            i = 2;
        }
        return directAppFunctions.m7335executehUnOzRk(context, str, str2, z10, i, cVar);
    }

    /* renamed from: execute-yxL6bBk$default, reason: not valid java name */
    public static /* synthetic */ Object m7333executeyxL6bBk$default(DirectAppFunctions directAppFunctions, Context context, Entry entry, Map map, int i, H7.c cVar, int i6, Object obj) {
        if ((i6 & 8) != 0) {
            i = 2;
        }
        return directAppFunctions.m7336executeyxL6bBk(context, entry, map, i, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.stepos.ability.appfunctions.DirectAppFunctions$executeOnce$2$1] */
    /* renamed from: executeOnce-BWLJW6A, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m7334executeOnceBWLJW6A(android.app.appfunctions.AppFunctionManager r5, android.app.appfunctions.ExecuteAppFunctionRequest r6, java.util.concurrent.Executor r7, H7.c<? super kotlin.Result<? extends android.app.appsearch.GenericDocument>> r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof com.stepos.ability.appfunctions.DirectAppFunctions$executeOnce$1
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.ability.appfunctions.DirectAppFunctions$executeOnce$1 r0 = (com.stepos.ability.appfunctions.DirectAppFunctions$executeOnce$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ability.appfunctions.DirectAppFunctions$executeOnce$1 r0 = new com.stepos.ability.appfunctions.DirectAppFunctions$executeOnce$1
            r0.<init>(r4, r8)
        L18:
            java.lang.Object r4 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r8 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L3d
            if (r1 != r2) goto L35
            java.lang.Object r5 = r0.L$2
            java.util.concurrent.Executor r5 = (java.util.concurrent.Executor) r5
            java.lang.Object r5 = r0.L$1
            androidx.appsearch.platformstorage.converter.a.v(r5)
            java.lang.Object r5 = r0.L$0
            androidx.appsearch.platformstorage.converter.a.B(r5)
            kotlin.b.b(r4)
            goto L6b
        L35:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3d:
            kotlin.b.b(r4)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.L$2 = r7
            r4 = 0
            r0.I$0 = r4
            r0.label = r2
            m9.k r4 = new m9.k
            H7.c r0 = U7.a.I(r0)
            r4.<init>(r2, r0)
            r4.y()
            android.os.CancellationSignal r0 = new android.os.CancellationSignal
            r0.<init>()
            com.stepos.ability.appfunctions.DirectAppFunctions$executeOnce$2$1 r1 = new com.stepos.ability.appfunctions.DirectAppFunctions$executeOnce$2$1
            r1.<init>()
            androidx.appsearch.platformstorage.converter.a.r(r5, r6, r7, r0, r1)
            java.lang.Object r4 = r4.x()
            if (r4 != r8) goto L6b
            return r8
        L6b:
            kotlin.Result r4 = (kotlin.Result) r4
            java.lang.Object r4 = r4.f4887a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.appfunctions.DirectAppFunctions.m7334executeOnceBWLJW6A(android.app.appfunctions.AppFunctionManager, android.app.appfunctions.ExecuteAppFunctionRequest, java.util.concurrent.Executor, H7.c):java.lang.Object");
    }

    private final String extractErrorMessage(JSONObject payload, ObjectSchema responseSchema) {
        Map<String, PropertySchema> properties;
        String strJsonFieldAsDisplayString;
        String strJsonFieldAsDisplayString2;
        for (String str : ERROR_MESSAGE_FIELD_NAMES) {
            if (payload.has(str) && (strJsonFieldAsDisplayString2 = jsonFieldAsDisplayString(payload, str)) != null) {
                return strJsonFieldAsDisplayString2;
            }
        }
        if (responseSchema == null || (properties = responseSchema.getProperties()) == null) {
            return null;
        }
        for (Map.Entry<String, PropertySchema> entry : properties.entrySet()) {
            String key = entry.getKey();
            PropertySchema value = entry.getValue();
            if (!SUCCESS_FIELD_NAMES.contains(key) && !STATUS_CODE_FIELD_NAMES.contains(key) && !ERROR_MESSAGE_FIELD_NAMES.contains(key) && value.getType() == 8 && (strJsonFieldAsDisplayString = INSTANCE.jsonFieldAsDisplayString(payload, key)) != null) {
                return strJsonFieldAsDisplayString;
            }
        }
        return null;
    }

    private final JSONArray floatArrayToJsonArray(float[] value) {
        JSONArray jSONArray = new JSONArray();
        for (float f : value) {
            jSONArray.put(Float.valueOf(f));
        }
        return jSONArray;
    }

    private final JSONObject genericDocumentToJson(GenericDocument doc) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (String str : doc.getPropertyNames()) {
            Object property = doc.getProperty(str);
            if (property != null) {
                DirectAppFunctions directAppFunctions = this;
                Object objPropertyValueToJson$default = propertyValueToJson$default(directAppFunctions, property, null, kotlin.collections.a.M(), null, 8, null);
                if (objPropertyValueToJson$default != null) {
                    jSONObject.put(str, objPropertyValueToJson$default);
                }
                this = directAppFunctions;
            }
        }
        return jSONObject;
    }

    private final String identifierCamelToSnake(String s5) {
        if (s5.length() == 0) {
            return s5;
        }
        String lowerCase = new Regex("([a-z0-9])([A-Z])").f(s5, "$1_$2").toLowerCase(Locale.ROOT);
        k.e(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    private final String inferArrayItemQualifiedName(ObjectSchema parentSchema, PropertySchema propertySchema, Map<String, ObjectSchema> components) {
        if (propertySchema.getType() != 10) {
            return null;
        }
        Map<String, PropertySchema> properties = parentSchema.getProperties();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, PropertySchema> entry : properties.entrySet()) {
            if (entry.getValue().getType() != 10) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Set setKeySet = linkedHashMap.keySet();
        Collection<ObjectSchema> collectionValues = components.values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            ObjectSchema objectSchema = (ObjectSchema) obj;
            if (!k.b(objectSchema.getQualifiedName(), parentSchema.getQualifiedName()) && !objectSchema.getProperties().isEmpty() && v.F0(objectSchema.getProperties().keySet(), setKeySet).isEmpty()) {
                arrayList.add(obj);
            }
        }
        if (arrayList.size() == 1) {
            return ((ObjectSchema) v.A0(arrayList)).getQualifiedName();
        }
        return null;
    }

    private final JSONObject inlineObjectSchema(ObjectSchema obj, Map<String, ObjectSchema> components, int depth) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, PropertySchema> entry : obj.getProperties().entrySet()) {
            String key = entry.getKey();
            ObjectSchema objectSchema = obj;
            jSONObject.put(key, INSTANCE.propertySchemaToJson(key, entry.getValue(), objectSchema, components, depth));
            obj = objectSchema;
        }
        ObjectSchema objectSchema2 = obj;
        JSONObject jSONObjectPut = new JSONObject().put("type", "object").put("properties", jSONObject);
        JSONArray jSONArray = new JSONArray();
        Iterator<T> it = objectSchema2.getRequired().iterator();
        while (it.hasNext()) {
            jSONArray.put((String) it.next());
        }
        JSONObject jSONObjectPut2 = jSONObjectPut.put("required", jSONArray).put("description", "object " + objectSchema2.getQualifiedName());
        k.e(jSONObjectPut2, "put(...)");
        return jSONObjectPut2;
    }

    private final JSONArray intArrayToJsonArray(int[] value) {
        JSONArray jSONArray = new JSONArray();
        for (int i : value) {
            jSONArray.put(i);
        }
        return jSONArray;
    }

    private final boolean isArrayLike(Object value) {
        return (value instanceof boolean[]) || (value instanceof long[]) || (value instanceof int[]) || (value instanceof double[]) || (value instanceof float[]) || (value instanceof byte[]) || (value instanceof Object[]);
    }

    private final boolean isColumnarArrayDocument(GenericDocument doc) {
        Set<String> propertyNames = doc.getPropertyNames();
        k.e(propertyNames, "getPropertyNames(...)");
        if (propertyNames.isEmpty()) {
            return false;
        }
        Set<String> set = propertyNames;
        if ((set instanceof Collection) && set.isEmpty()) {
            return true;
        }
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            if (!INSTANCE.isArrayLike(doc.getProperty((String) it.next()))) {
                return false;
            }
        }
        return true;
    }

    private final boolean isJvmArrayDump(String text) {
        return t.e0(text, "[", false) && m.i0(text, '@');
    }

    private final String jsonFieldAsDisplayString(JSONObject payload, String field) throws JSONException {
        Object obj = null;
        if (payload.has(field) && !payload.isNull(field)) {
            Object obj2 = payload.get(field);
            if (obj2 instanceof String) {
                String str = (String) obj2;
                if (!m.s0(str) && !k.b(str, "null") && !INSTANCE.isJvmArrayDump(str)) {
                    obj = obj2;
                }
                return (String) obj;
            }
            if (obj2 instanceof JSONArray) {
                String strOptString = ((JSONArray) obj2).optString(0);
                k.c(strOptString);
                if (!m.s0(strOptString) && !strOptString.equals("null")) {
                    return strOptString;
                }
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x015a A[Catch: all -> 0x0084, TryCatch #0 {all -> 0x0084, blocks: (B:30:0x006d, B:32:0x0073, B:48:0x00a4, B:84:0x0162, B:71:0x00f1, B:73:0x00f5, B:74:0x0108, B:76:0x010c, B:77:0x011e, B:79:0x0122, B:80:0x012e, B:68:0x00e8, B:81:0x0150, B:83:0x015a, B:64:0x00de, B:59:0x00c0, B:61:0x00ca, B:52:0x00ae, B:41:0x0094, B:85:0x0174, B:37:0x008a), top: B:90:0x006d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final android.app.appsearch.GenericDocument jsonLikeToGenericDocument(java.lang.Object r17, java.lang.String r18, java.util.Map<java.lang.String, com.stepos.ability.appfunctions.DirectAppFunctions.ObjectSchema> r19) {
        /*
            Method dump skipped, instructions count: 425
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.appfunctions.DirectAppFunctions.jsonLikeToGenericDocument(java.lang.Object, java.lang.String, java.util.Map):android.app.appsearch.GenericDocument");
    }

    private final JSONArray longArrayToJsonArray(long[] value) {
        JSONArray jSONArray = new JSONArray();
        for (long j5 : value) {
            jSONArray.put(j5);
        }
        return jSONArray;
    }

    private final ObjectSchema matchComponentByFieldNames(GenericDocument doc, Map<String, ObjectSchema> components) {
        Set<String> propertyNames = doc.getPropertyNames();
        k.e(propertyNames, "getPropertyNames(...)");
        Set setJ1 = v.j1(propertyNames);
        Object obj = null;
        if (setJ1.isEmpty()) {
            return null;
        }
        Iterator<T> it = components.values().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (k.b(v.j1(((ObjectSchema) next).getProperties().keySet()), setJ1)) {
                obj = next;
                break;
            }
        }
        return (ObjectSchema) obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object nextPage(SearchResults searchResults, Executor executor, H7.c<? super List<SearchResult>> cVar) {
        final C1718k c1718k = new C1718k(1, U7.a.I(cVar));
        c1718k.y();
        searchResults.getNextPage(executor, new Consumer() { // from class: com.stepos.ability.appfunctions.DirectAppFunctions$nextPage$2$1
            @Override // java.util.function.Consumer
            public final void accept(AppSearchResult<List<SearchResult>> appSearchResult) {
                if (!appSearchResult.isSuccess()) {
                    c1718k.resumeWith(EmptyList.f4893a);
                    return;
                }
                InterfaceC1717j interfaceC1717j = c1718k;
                List<SearchResult> resultValue = appSearchResult.getResultValue();
                if (resultValue == null) {
                    resultValue = EmptyList.f4893a;
                }
                interfaceC1717j.resumeWith(resultValue);
            }
        });
        Object objX = c1718k.x();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        return objX;
    }

    private final JSONObject normalizeResultPayload(JSONObject payload) {
        for (String str : RETURN_DOCUMENT_KEYS) {
            if (payload.has(str)) {
                Object objOpt = payload.opt(str);
                if (objOpt instanceof JSONObject) {
                    return normalizeResultPayload((JSONObject) objOpt);
                }
            }
        }
        return payload;
    }

    private final JSONObject objectDocumentToJson(GenericDocument doc, ObjectSchema schema, Map<String, ObjectSchema> components) throws JSONException {
        Object property;
        Object objA;
        Object objPropertyValueToJson;
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, PropertySchema> entry : schema.getProperties().entrySet()) {
            String key = entry.getKey();
            PropertySchema value = entry.getValue();
            try {
                objA = doc.getProperty(key);
            } catch (Throwable th) {
                objA = b.a(th);
            }
            if (objA instanceof Result.Failure) {
                objA = null;
            }
            if (objA != null && (objPropertyValueToJson = propertyValueToJson(objA, value, components, schema)) != null) {
                jSONObject.put(key, objPropertyValueToJson);
            }
        }
        for (String str : doc.getPropertyNames()) {
            if (!jSONObject.has(str) && (property = doc.getProperty(str)) != null) {
                DirectAppFunctions directAppFunctions = this;
                Map<String, ObjectSchema> map = components;
                Object objPropertyValueToJson$default = propertyValueToJson$default(directAppFunctions, property, null, map, null, 8, null);
                if (objPropertyValueToJson$default != null) {
                    jSONObject.put(str, objPropertyValueToJson$default);
                }
                this = directAppFunctions;
                components = map;
            }
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object openGlobalSession(AppSearchManager appSearchManager, Executor executor, H7.c<? super GlobalSearchSession> cVar) {
        final C1718k c1718k = new C1718k(1, U7.a.I(cVar));
        c1718k.y();
        appSearchManager.createGlobalSearchSession(executor, new Consumer() { // from class: com.stepos.ability.appfunctions.DirectAppFunctions$openGlobalSession$2$1
            @Override // java.util.function.Consumer
            public final void accept(AppSearchResult<GlobalSearchSession> appSearchResult) {
                GlobalSearchSession resultValue = appSearchResult.getResultValue();
                if (!appSearchResult.isSuccess() || resultValue == null) {
                    c1718k.resumeWith(b.a(new IllegalStateException(a.k("createGlobalSearchSession: ", appSearchResult.getErrorMessage()))));
                } else {
                    c1718k.resumeWith(resultValue);
                }
            }
        });
        Object objX = c1718k.x();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        return objX;
    }

    private final boolean[] optBooleanArray(GenericDocument genericDocument, String str) {
        Object objA;
        try {
            objA = genericDocument.getPropertyBooleanArray(str);
        } catch (Throwable th) {
            objA = b.a(th);
        }
        if (objA instanceof Result.Failure) {
            objA = null;
        }
        return (boolean[]) objA;
    }

    private final long[] optLongArray(GenericDocument genericDocument, String str) {
        Object objA;
        try {
            objA = genericDocument.getPropertyLongArray(str);
        } catch (Throwable th) {
            objA = b.a(th);
        }
        if (objA instanceof Result.Failure) {
            objA = null;
        }
        return (long[]) objA;
    }

    private final String optString(GenericDocument genericDocument, String str) {
        Object objA;
        Object objA2;
        try {
            objA = genericDocument.getPropertyString(str);
        } catch (Throwable th) {
            objA = b.a(th);
        }
        if (objA instanceof Result.Failure) {
            objA = null;
        }
        String str2 = (String) objA;
        if (str2 != null) {
            return str2;
        }
        try {
            String[] propertyStringArray = genericDocument.getPropertyStringArray(str);
            objA2 = propertyStringArray != null ? (String) q.n0(propertyStringArray) : null;
        } catch (Throwable th2) {
            objA2 = b.a(th2);
        }
        return (String) (objA2 instanceof Result.Failure ? null : objA2);
    }

    private final String[] optStringArray(GenericDocument genericDocument, String str) {
        Object objA;
        try {
            objA = genericDocument.getPropertyStringArray(str);
        } catch (Throwable th) {
            objA = b.a(th);
        }
        if (objA instanceof Result.Failure) {
            objA = null;
        }
        return (String[]) objA;
    }

    private final JSONObject paramJsonSchema(Param p, Map<String, ObjectSchema> components) throws JSONException {
        JSONObject jSONObjectTypeIdToJsonSchema$default = typeIdToJsonSchema$default(this, p.getType(), p.isNullable(), p.getRefQualifiedName(), components, 0, 16, null);
        String description = p.getDescription();
        if (description != null && !m.s0(description)) {
            jSONObjectTypeIdToJsonSchema$default.put("description", p.getDescription());
        }
        return jSONObjectTypeIdToJsonSchema$default;
    }

    private final Map<String, ObjectSchema> parseComponents(GenericDocument componentsDoc) {
        List<GenericDocument> arrayList;
        List<GenericDocument> arrayList2;
        Boolean boolL0;
        String str;
        Object property = componentsDoc.getProperty("dataTypes");
        Object[] objArr = property instanceof Object[] ? (Object[]) property : null;
        if (objArr != null) {
            arrayList = new ArrayList();
            for (Object obj : objArr) {
                if (obj instanceof GenericDocument) {
                    arrayList.add(obj);
                }
            }
        } else {
            arrayList = null;
        }
        if (arrayList == null) {
            arrayList = EmptyList.f4893a;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (GenericDocument genericDocument : arrayList) {
            String strOptString = optString(genericDocument, HintConstants.AUTOFILL_HINT_NAME);
            if (strOptString != null) {
                Object property2 = genericDocument.getProperty("dataTypeMetadata");
                Object[] objArr2 = property2 instanceof Object[] ? (Object[]) property2 : null;
                if (objArr2 != null) {
                    ArrayList arrayList3 = new ArrayList();
                    for (Object obj2 : objArr2) {
                        if (obj2 instanceof GenericDocument) {
                            arrayList3.add(obj2);
                        }
                    }
                    GenericDocument genericDocument2 = (GenericDocument) v.C0(arrayList3);
                    if (genericDocument2 != null) {
                        String[] strArrOptStringArray = optStringArray(genericDocument2, "objectQualifiedName");
                        if (strArrOptStringArray != null && (str = (String) q.n0(strArrOptStringArray)) != null) {
                            strOptString = str;
                        }
                        boolean[] zArrOptBooleanArray = optBooleanArray(genericDocument2, "isNullable");
                        boolean zBooleanValue = (zArrOptBooleanArray == null || (boolL0 = q.l0(zArrOptBooleanArray)) == null) ? true : boolL0.booleanValue();
                        String[] strArrOptStringArray2 = optStringArray(genericDocument2, "required");
                        List listI0 = strArrOptStringArray2 != null ? q.I0(strArrOptStringArray2) : null;
                        if (listI0 == null) {
                            listI0 = EmptyList.f4893a;
                        }
                        Object property3 = genericDocument2.getProperty("properties");
                        Object[] objArr3 = property3 instanceof Object[] ? (Object[]) property3 : null;
                        if (objArr3 != null) {
                            arrayList2 = new ArrayList();
                            for (Object obj3 : objArr3) {
                                if (obj3 instanceof GenericDocument) {
                                    arrayList2.add(obj3);
                                }
                            }
                        } else {
                            arrayList2 = null;
                        }
                        if (arrayList2 == null) {
                            arrayList2 = EmptyList.f4893a;
                        }
                        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                        for (GenericDocument genericDocument3 : arrayList2) {
                            String strOptString2 = optString(genericDocument3, HintConstants.AUTOFILL_HINT_NAME);
                            if (strOptString2 != null) {
                                Object property4 = genericDocument3.getProperty("dataTypeMetadata");
                                Object[] objArr4 = property4 instanceof Object[] ? (Object[]) property4 : null;
                                if (objArr4 != null) {
                                    ArrayList arrayList4 = new ArrayList();
                                    int length = objArr4.length;
                                    int i = 0;
                                    while (i < length) {
                                        int i6 = length;
                                        Object obj4 = objArr4[i];
                                        int i10 = i;
                                        if (obj4 instanceof GenericDocument) {
                                            arrayList4.add(obj4);
                                        }
                                        i = i10 + 1;
                                        length = i6;
                                    }
                                    GenericDocument genericDocument4 = (GenericDocument) v.C0(arrayList4);
                                    if (genericDocument4 != null) {
                                        String strOptString3 = optString(genericDocument3, "description");
                                        if (strOptString3 == null) {
                                            strOptString3 = optString(genericDocument4, "description");
                                        }
                                        PropertySchema dataTypeMetadata = parseDataTypeMetadata(genericDocument4, strOptString3);
                                        if (dataTypeMetadata != null) {
                                            linkedHashMap2.put(strOptString2, dataTypeMetadata);
                                        }
                                    }
                                }
                            }
                        }
                        linkedHashMap.put(strOptString, new ObjectSchema(strOptString, linkedHashMap2, listI0, zBooleanValue));
                    }
                }
            }
        }
        return linkedHashMap;
    }

    private final PropertySchema parseDataTypeMetadata(GenericDocument dataTypeMeta, String description) {
        Long lM0;
        Boolean boolL0;
        long[] jArrOptLongArray = optLongArray(dataTypeMeta, "type");
        if (jArrOptLongArray == null || (lM0 = q.m0(jArrOptLongArray)) == null) {
            return null;
        }
        int iLongValue = (int) lM0.longValue();
        boolean[] zArrOptBooleanArray = optBooleanArray(dataTypeMeta, "isNullable");
        boolean zBooleanValue = (zArrOptBooleanArray == null || (boolL0 = q.l0(zArrOptBooleanArray)) == null) ? false : boolL0.booleanValue();
        String strOptString = optString(dataTypeMeta, "dataTypeReference");
        return new PropertySchema(iLongValue, zBooleanValue, description, (strOptString == null || m.s0(strOptString)) ? null : strOptString, iLongValue == 10 ? resolveQualifiedNameFromTypeMetadata(dataTypeMeta, o.N("itemType", "elementType", "valueType")) : null);
    }

    public static /* synthetic */ PropertySchema parseDataTypeMetadata$default(DirectAppFunctions directAppFunctions, GenericDocument genericDocument, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        return directAppFunctions.parseDataTypeMetadata(genericDocument, str);
    }

    private final Param parseParam(GenericDocument doc) {
        long[] jArrOptLongArray;
        Long lM0;
        Boolean boolL0;
        Boolean boolL02;
        String strOptString = optString(doc, HintConstants.AUTOFILL_HINT_NAME);
        if (strOptString == null) {
            return null;
        }
        boolean[] zArrOptBooleanArray = optBooleanArray(doc, "isRequired");
        boolean zBooleanValue = false;
        boolean zBooleanValue2 = (zArrOptBooleanArray == null || (boolL02 = q.l0(zArrOptBooleanArray)) == null) ? false : boolL02.booleanValue();
        String strOptString2 = optString(doc, "description");
        Object property = doc.getProperty("dataTypeMetadata");
        Object[] objArr = property instanceof Object[] ? (Object[]) property : null;
        if (objArr != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : objArr) {
                if (obj instanceof GenericDocument) {
                    arrayList.add(obj);
                }
            }
            GenericDocument genericDocument = (GenericDocument) v.C0(arrayList);
            if (genericDocument != null && (jArrOptLongArray = optLongArray(genericDocument, "type")) != null && (lM0 = q.m0(jArrOptLongArray)) != null) {
                int iLongValue = (int) lM0.longValue();
                boolean[] zArrOptBooleanArray2 = optBooleanArray(genericDocument, "isNullable");
                if (zArrOptBooleanArray2 != null && (boolL0 = q.l0(zArrOptBooleanArray2)) != null) {
                    zBooleanValue = boolL0.booleanValue();
                }
                return new Param(strOptString, zBooleanValue2, iLongValue, zBooleanValue, strOptString2, optString(genericDocument, "dataTypeReference"));
            }
        }
        return null;
    }

    private final JSONObject propertySchemaToJson(String propName, PropertySchema prop, ObjectSchema parentSchema, Map<String, ObjectSchema> components, int depth) throws JSONException {
        if (prop.getType() != 10) {
            JSONObject jSONObjectTypeIdToJsonSchema = typeIdToJsonSchema(prop.getType(), prop.isNullable(), prop.getRefQualifiedName(), components, depth);
            String description = prop.getDescription();
            if (description != null && !m.s0(description)) {
                jSONObjectTypeIdToJsonSchema.put("description", prop.getDescription());
            }
            return jSONObjectTypeIdToJsonSchema;
        }
        ObjectSchema objectSchemaResolveArrayItemSchema$default = resolveArrayItemSchema$default(this, prop, components, null, parentSchema, 4, null);
        JSONObject jSONObjectO = androidx.constraintlayout.core.dsl.a.o("type", "array");
        jSONObjectO.put("items", objectSchemaResolveArrayItemSchema$default != null ? INSTANCE.inlineObjectSchema(objectSchemaResolveArrayItemSchema$default, components, depth + 1) : androidx.constraintlayout.core.dsl.a.o("type", "object"));
        String description2 = prop.getDescription();
        if (description2 != null && !m.s0(description2)) {
            jSONObjectO.put("description", prop.getDescription());
        }
        if (prop.isNullable()) {
            jSONObjectO.put("nullable", true);
        }
        return jSONObjectO;
    }

    private final Object propertyValueToJson(Object value, PropertySchema propSchema, Map<String, ObjectSchema> components, ObjectSchema parentSchema) {
        if (value == null) {
            return JSONObject.NULL;
        }
        GenericDocument documentValue = readDocumentValue(value);
        Object objConvertAppSearchValue = convertAppSearchValue(value, propSchema, components, documentValue, parentSchema);
        if (objConvertAppSearchValue != null) {
            return objConvertAppSearchValue;
        }
        Integer numValueOf = propSchema != null ? Integer.valueOf(propSchema.getType()) : null;
        if ((numValueOf != null && numValueOf.intValue() == 3) || (numValueOf != null && numValueOf.intValue() == 11)) {
            if (documentValue == null) {
                return null;
            }
            String refQualifiedName = propSchema.getRefQualifiedName();
            ObjectSchema objectSchema = refQualifiedName != null ? components.get(refQualifiedName) : null;
            return objectSchema != null ? objectDocumentToJson(documentValue, objectSchema, components) : documentToJsonObject$default(this, documentValue, propSchema, components, null, 8, null);
        }
        if (numValueOf == null || numValueOf.intValue() != 10 || documentValue == null) {
            return null;
        }
        return documentToJsonObject(documentValue, propSchema, components, propSchema != null ? INSTANCE.resolveArrayItemSchema(propSchema, components, documentValue, parentSchema) : null);
    }

    public static /* synthetic */ Object propertyValueToJson$default(DirectAppFunctions directAppFunctions, Object obj, PropertySchema propertySchema, Map map, ObjectSchema objectSchema, int i, Object obj2) {
        if ((i & 8) != 0) {
            objectSchema = null;
        }
        return directAppFunctions.propertyValueToJson(obj, propertySchema, map, objectSchema);
    }

    private final GenericDocument readDocumentValue(Object value) {
        if (value instanceof GenericDocument) {
            return (GenericDocument) value;
        }
        if (value instanceof Object[]) {
            GenericDocument[] genericDocumentArr = value instanceof GenericDocument[] ? (GenericDocument[]) value : null;
            if (genericDocumentArr != null) {
                return (GenericDocument) q.n0(genericDocumentArr);
            }
        }
        return null;
    }

    private final boolean readJsonBoolean(JSONObject payload, String field) throws JSONException {
        if (payload.has(field) && !payload.isNull(field)) {
            Object obj = payload.get(field);
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
            if (obj instanceof Number) {
                if (((Number) obj).intValue() != 0) {
                    return true;
                }
            } else if (obj instanceof JSONArray) {
                JSONArray jSONArray = (JSONArray) obj;
                if (jSONArray.length() > 0 && jSONArray.optBoolean(0)) {
                    return true;
                }
            } else if ((obj instanceof String) && (t.X((String) obj, "true") || k.b(obj, "1"))) {
                return true;
            }
        }
        return false;
    }

    private final long readJsonLong(JSONObject payload, String field) throws JSONException {
        Long lG0;
        if (payload.has(field) && !payload.isNull(field)) {
            Object obj = payload.get(field);
            if (obj instanceof Number) {
                return ((Number) obj).longValue();
            }
            if (obj instanceof JSONArray) {
                JSONArray jSONArray = (JSONArray) obj;
                if (jSONArray.length() > 0) {
                    return jSONArray.optLong(0);
                }
                return 0L;
            }
            if (obj instanceof String) {
                String str = (String) obj;
                if (!isJvmArrayDump(str) && (lG0 = t.g0(str)) != null) {
                    return lG0.longValue();
                }
            }
        }
        return 0L;
    }

    private final ObjectSchema resolveArrayItemSchema(PropertySchema propertySchema, Map<String, ObjectSchema> components, GenericDocument runtimeDoc, ObjectSchema parentSchema) {
        ObjectSchema objectSchema;
        String arrayItemQualifiedName = propertySchema.getArrayItemQualifiedName();
        if (arrayItemQualifiedName == null && (arrayItemQualifiedName = propertySchema.getRefQualifiedName()) == null) {
            arrayItemQualifiedName = parentSchema != null ? INSTANCE.inferArrayItemQualifiedName(parentSchema, propertySchema, components) : null;
        }
        if (arrayItemQualifiedName != null && (objectSchema = components.get(arrayItemQualifiedName)) != null) {
            return objectSchema;
        }
        if (runtimeDoc != null) {
            return INSTANCE.matchComponentByFieldNames(runtimeDoc, components);
        }
        return null;
    }

    public static /* synthetic */ ObjectSchema resolveArrayItemSchema$default(DirectAppFunctions directAppFunctions, PropertySchema propertySchema, Map map, GenericDocument genericDocument, ObjectSchema objectSchema, int i, Object obj) {
        if ((i & 4) != 0) {
            genericDocument = null;
        }
        if ((i & 8) != 0) {
            objectSchema = null;
        }
        return directAppFunctions.resolveArrayItemSchema(propertySchema, map, genericDocument, objectSchema);
    }

    private final String resolveQualifiedNameFromTypeMetadata(GenericDocument meta, List<String> nestedKeys) {
        String str;
        Iterator<String> it = nestedKeys.iterator();
        while (true) {
            if (!it.hasNext()) {
                return null;
            }
            Object property = meta.getProperty(it.next());
            Object[] objArr = property instanceof Object[] ? (Object[]) property : null;
            if (objArr != null) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : objArr) {
                    if (obj instanceof GenericDocument) {
                        arrayList.add(obj);
                    }
                }
                GenericDocument genericDocument = (GenericDocument) v.C0(arrayList);
                if (genericDocument == null) {
                    continue;
                } else {
                    String strOptString = optString(genericDocument, "dataTypeReference");
                    if (strOptString != null) {
                        if (m.s0(strOptString)) {
                            strOptString = null;
                        }
                        if (strOptString != null) {
                            return strOptString;
                        }
                    }
                    String[] strArrOptStringArray = optStringArray(genericDocument, "objectQualifiedName");
                    if (strArrOptStringArray != null && (str = (String) q.n0(strArrOptStringArray)) != null) {
                        String str2 = m.s0(str) ? null : str;
                        if (str2 != null) {
                            return str2;
                        }
                    }
                    String strResolveQualifiedNameFromTypeMetadata = resolveQualifiedNameFromTypeMetadata(genericDocument, nestedKeys);
                    if (strResolveQualifiedNameFromTypeMetadata != null) {
                        return strResolveQualifiedNameFromTypeMetadata;
                    }
                }
            }
        }
    }

    public static /* synthetic */ Object scan$default(DirectAppFunctions directAppFunctions, Context context, String str, H7.c cVar, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        return directAppFunctions.scan(context, str, cVar);
    }

    public static /* synthetic */ JSONObject toAnthropicTool$default(DirectAppFunctions directAppFunctions, Entry entry, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = directAppFunctions.encodeToolName(entry.getPkg(), entry.getFunctionId());
        }
        return directAppFunctions.toAnthropicTool(entry, str);
    }

    private final JSONObject typeIdToJsonSchema(int type, boolean isNullable, String refQualifiedName, Map<String, ObjectSchema> components, int depth) throws JSONException {
        JSONObject jSONObjectO;
        if (depth > 6) {
            JSONObject jSONObjectPut = new JSONObject().put("type", "object");
            k.e(jSONObjectPut, "put(...)");
            return jSONObjectPut;
        }
        switch (type) {
            case 0:
                jSONObjectO = androidx.constraintlayout.core.dsl.a.o("type", "null");
                break;
            case 1:
                jSONObjectO = androidx.constraintlayout.core.dsl.a.o("type", TypedValues.Custom.S_BOOLEAN);
                break;
            case 2:
                jSONObjectO = new JSONObject().put("type", TypedValues.Custom.S_STRING).put("format", "byte");
                break;
            case 3:
                jSONObjectO = androidx.constraintlayout.core.dsl.a.o("type", "object");
                break;
            case 4:
            case 5:
                jSONObjectO = androidx.constraintlayout.core.dsl.a.o("type", "number");
                break;
            case 6:
            case 7:
                jSONObjectO = androidx.constraintlayout.core.dsl.a.o("type", TypedValues.Custom.S_INT);
                break;
            case 8:
                jSONObjectO = androidx.constraintlayout.core.dsl.a.o("type", TypedValues.Custom.S_STRING);
                break;
            case 9:
            default:
                jSONObjectO = androidx.constraintlayout.core.dsl.a.o("type", "object").put("description", "appfunction-type-" + type);
                break;
            case 10:
                jSONObjectO = androidx.constraintlayout.core.dsl.a.o("type", "array").put("items", new JSONObject().put("type", "object"));
                break;
            case 11:
                ObjectSchema objectSchema = refQualifiedName != null ? components.get(refQualifiedName) : null;
                if (objectSchema == null) {
                    jSONObjectO = androidx.constraintlayout.core.dsl.a.o("type", "object").put("description", "ref=" + refQualifiedName + " (not resolved)");
                    break;
                } else {
                    jSONObjectO = inlineObjectSchema(objectSchema, components, depth + 1);
                    break;
                }
            case 12:
                jSONObjectO = new JSONObject().put("type", "object").put("description", "allOf (flattened object; see static components for branches)");
                break;
            case 13:
                jSONObjectO = new JSONObject().put("type", TypedValues.Custom.S_STRING).put("format", "pending-intent");
                break;
            case 14:
                jSONObjectO = androidx.constraintlayout.core.dsl.a.o("description", "oneOf / sealed variant (see static components for alternatives)");
                break;
        }
        if (isNullable) {
            jSONObjectO.put("nullable", true);
        }
        k.c(jSONObjectO);
        return jSONObjectO;
    }

    public static /* synthetic */ JSONObject typeIdToJsonSchema$default(DirectAppFunctions directAppFunctions, int i, boolean z10, String str, Map map, int i6, int i10, Object obj) {
        if ((i10 & 16) != 0) {
            i6 = 0;
        }
        return directAppFunctions.typeIdToJsonSchema(i, z10, str, map, i6);
    }

    private final GenericDocument unwrapReturnDocument(GenericDocument doc) {
        Object objA;
        if (doc == null) {
            return null;
        }
        Iterator<String> it = RETURN_DOCUMENT_KEYS.iterator();
        while (it.hasNext()) {
            try {
                objA = doc.getProperty(it.next());
            } catch (Throwable th) {
                objA = b.a(th);
            }
            if (objA instanceof Result.Failure) {
                objA = null;
            }
            if (objA != null) {
                if (objA instanceof GenericDocument) {
                    GenericDocument genericDocument = (GenericDocument) objA;
                    GenericDocument genericDocumentUnwrapReturnDocument = unwrapReturnDocument(genericDocument);
                    return genericDocumentUnwrapReturnDocument == null ? genericDocument : genericDocumentUnwrapReturnDocument;
                }
                if (objA instanceof Object[]) {
                    GenericDocument[] genericDocumentArr = objA instanceof GenericDocument[] ? (GenericDocument[]) objA : null;
                    GenericDocument genericDocument2 = genericDocumentArr != null ? (GenericDocument) q.n0(genericDocumentArr) : null;
                    if (genericDocument2 != null) {
                        GenericDocument genericDocumentUnwrapReturnDocument2 = unwrapReturnDocument(genericDocument2);
                        return genericDocumentUnwrapReturnDocument2 == null ? genericDocument2 : genericDocumentUnwrapReturnDocument2;
                    }
                } else {
                    continue;
                }
            }
        }
        return doc;
    }

    private final void wakeUp(Context context, String pkg) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(pkg);
        if (launchIntentForPackage == null) {
            return;
        }
        launchIntentForPackage.addFlags(268500992);
        try {
            context.startActivity(launchIntentForPackage);
        } catch (Throwable th) {
            b.a(th);
        }
    }

    private final Object wrapIndexValue(Object column, int index) {
        if (index < 0 || index >= arrayLikeSize(column)) {
            return null;
        }
        return column instanceof boolean[] ? new boolean[]{((boolean[]) column)[index]} : column instanceof long[] ? new long[]{((long[]) column)[index]} : column instanceof int[] ? new int[]{((int[]) column)[index]} : column instanceof double[] ? new double[]{((double[]) column)[index]} : column instanceof float[] ? new float[]{((float[]) column)[index]} : column instanceof Object[] ? new Object[]{((Object[]) column)[index]} : column;
    }

    public final Map<String, Entry> buildToolNameIndex(List<Entry> entries) {
        k.f(entries, "entries");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : entries) {
            Entry entry = (Entry) obj;
            String strEncodeToolName = INSTANCE.encodeToolName(entry.getPkg(), entry.getFunctionId());
            Object arrayList = linkedHashMap.get(strEncodeToolName);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(strEncodeToolName, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            String str = (String) entry2.getKey();
            List<Entry> list = (List) entry2.getValue();
            if (list.size() == 1) {
                linkedHashMap2.put(str, list.get(0));
            } else {
                for (Entry entry3 : list) {
                    String str2 = String.format("%08x", Arrays.copyOf(new Object[]{Integer.valueOf((entry3.getPkg() + "::" + entry3.getFunctionId()).hashCode())}, 1));
                    int length = 63 - str2.length();
                    if (length < 1) {
                        length = 1;
                    }
                    linkedHashMap2.put(m.N0(length, str) + "_" + str2, entry3);
                }
            }
        }
        return linkedHashMap2;
    }

    public final String encodeToolName(String pkg, String functionId) {
        String strI0;
        k.f(pkg, "pkg");
        k.f(functionId, "functionId");
        String string = m.R0(pkg).toString();
        String strI02 = m.I0('.', string, string);
        if (strI02.length() == 0) {
            strI02 = m.R0(pkg).toString();
        }
        String string2 = m.R0(functionId).toString();
        if (m.i0(string2, '#')) {
            strI0 = m.I0('#', string2, string2);
        } else {
            strI0 = m.I0('.', string2, string2);
            if (strI0.length() == 0) {
                strI0 = string2;
            }
        }
        if (strI0.length() != 0) {
            string2 = strI0;
        }
        String strS0 = m.S0(new Regex("_+").f(new Regex("[^a-zA-Z0-9_-]").f(a.B(identifierCamelToSnake(strI02), "_", identifierCamelToSnake(string2)), "_"), "_"), '_');
        if (strS0.length() == 0) {
            strS0 = String.format("%08x", Arrays.copyOf(new Object[]{Integer.valueOf((pkg + "::" + functionId).hashCode())}, 1));
        }
        if (strS0.length() <= 64) {
            return strS0;
        }
        String str = String.format("%08x", Arrays.copyOf(new Object[]{Integer.valueOf((pkg + "::" + functionId).hashCode())}, 1));
        int length = 63 - str.length();
        return a.B(m.N0(length >= 1 ? length : 1, strS0), "_", str);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /* renamed from: execute-hUnOzRk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m7335executehUnOzRk(android.content.Context r24, java.lang.String r25, java.lang.String r26, boolean r27, int r28, H7.c<? super kotlin.Result<? extends android.app.appsearch.GenericDocument>> r29) {
        /*
            r23 = this;
            r0 = r29
            boolean r1 = r0 instanceof com.stepos.ability.appfunctions.DirectAppFunctions$execute$4
            if (r1 == 0) goto L18
            r1 = r0
            com.stepos.ability.appfunctions.DirectAppFunctions$execute$4 r1 = (com.stepos.ability.appfunctions.DirectAppFunctions$execute$4) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L18
            int r2 = r2 - r3
            r1.label = r2
            r2 = r23
        L16:
            r7 = r1
            goto L20
        L18:
            com.stepos.ability.appfunctions.DirectAppFunctions$execute$4 r1 = new com.stepos.ability.appfunctions.DirectAppFunctions$execute$4
            r2 = r23
            r1.<init>(r2, r0)
            goto L16
        L20:
            java.lang.Object r0 = r7.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r3 = r7.label
            r4 = 1
            if (r3 == 0) goto L4b
            if (r3 != r4) goto L43
            java.lang.Object r1 = r7.L$3
            com.stepos.ability.appfunctions.DirectAppFunctions$Entry r1 = (com.stepos.ability.appfunctions.DirectAppFunctions.Entry) r1
            java.lang.Object r1 = r7.L$2
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r1 = r7.L$1
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r1 = r7.L$0
            android.content.Context r1 = (android.content.Context) r1
            kotlin.b.b(r0)
            kotlin.Result r0 = (kotlin.Result) r0
            java.lang.Object r0 = r0.f4887a
            return r0
        L43:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L4b:
            kotlin.b.b(r0)
            com.stepos.ability.appfunctions.DirectAppFunctions$Entry r8 = new com.stepos.ability.appfunctions.DirectAppFunctions$Entry
            com.stepos.ability.appfunctions.DirectAppFunctions$Param r9 = new com.stepos.ability.appfunctions.DirectAppFunctions$Param
            r16 = 48
            r17 = 0
            java.lang.String r10 = "enable"
            r11 = 1
            r12 = 1
            r13 = 0
            r14 = 0
            r15 = 0
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17)
            java.util.List r18 = H4.o.M(r9)
            r21 = 1784(0x6f8, float:2.5E-42)
            r22 = 0
            java.lang.String r11 = ""
            r12 = 0
            r13 = 0
            r14 = 0
            r16 = 0
            r17 = 0
            r19 = 0
            r20 = 0
            r9 = r25
            r10 = r26
            r8.<init>(r9, r10, r11, r12, r13, r14, r16, r17, r18, r19, r20, r21, r22)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r27)
            kotlin.Pair r3 = new kotlin.Pair
            java.lang.String r5 = "enable"
            r3.<init>(r5, r0)
            java.util.Map r5 = kotlin.collections.a.Q(r3)
            r0 = 0
            r7.L$0 = r0
            r7.L$1 = r0
            r7.L$2 = r0
            r7.L$3 = r0
            r0 = r27
            r7.Z$0 = r0
            r6 = r28
            r7.I$0 = r6
            r7.label = r4
            r3 = r24
            r4 = r8
            java.lang.Object r0 = r2.m7336executeyxL6bBk(r3, r4, r5, r6, r7)
            if (r0 != r1) goto La9
            return r1
        La9:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.appfunctions.DirectAppFunctions.m7335executehUnOzRk(android.content.Context, java.lang.String, java.lang.String, boolean, int, H7.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0152, code lost:
    
        if (r11 == r2) goto L42;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Type inference failed for: r10v0, types: [com.stepos.ability.appfunctions.DirectAppFunctions] */
    /* JADX WARN: Type inference failed for: r10v1, types: [java.util.concurrent.ExecutorService] */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* renamed from: execute-yxL6bBk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m7336executeyxL6bBk(android.content.Context r11, com.stepos.ability.appfunctions.DirectAppFunctions.Entry r12, java.util.Map<java.lang.String, ? extends java.lang.Object> r13, int r14, H7.c<? super kotlin.Result<? extends android.app.appsearch.GenericDocument>> r15) {
        /*
            Method dump skipped, instructions count: 358
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.appfunctions.DirectAppFunctions.m7336executeyxL6bBk(android.content.Context, com.stepos.ability.appfunctions.DirectAppFunctions$Entry, java.util.Map, int, H7.c):java.lang.Object");
    }

    public final AppFunctionBusinessResult interpretBusinessResult(GenericDocument gd, Entry entry) {
        k.f(entry, "entry");
        JSONObject jSONObjectNormalizeResultPayload = normalizeResultPayload(documentToJson(gd, entry));
        String responseTypeRef = entry.getResponseTypeRef();
        String strExtractErrorMessage = null;
        ObjectSchema objectSchema = responseTypeRef != null ? entry.getComponents().get(responseTypeRef) : null;
        boolean zEvaluateBusinessSuccess = evaluateBusinessSuccess(jSONObjectNormalizeResultPayload, objectSchema);
        if (!zEvaluateBusinessSuccess && (strExtractErrorMessage = extractErrorMessage(jSONObjectNormalizeResultPayload, objectSchema)) == null) {
            strExtractErrorMessage = "AppFunction returned business failure";
        }
        return new AppFunctionBusinessResult(zEvaluateBusinessSuccess, jSONObjectNormalizeResultPayload, strExtractErrorMessage);
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0120, code lost:
    
        if (r1 != r3) goto L39;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x0120 -> B:39:0x0123). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object scan(android.content.Context r24, java.lang.String r25, H7.c<? super java.util.List<com.stepos.ability.appfunctions.DirectAppFunctions.Entry>> r26) {
        /*
            Method dump skipped, instructions count: 702
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.appfunctions.DirectAppFunctions.scan(android.content.Context, java.lang.String, H7.c):java.lang.Object");
    }

    public final String summarize(GenericDocument gd, Entry entry) {
        k.f(entry, "entry");
        String string = normalizeResultPayload(documentToJson(gd, entry)).toString();
        k.e(string, "toString(...)");
        return string;
    }

    public final JSONObject toAnthropicTool(Entry entry, String name) throws JSONException {
        k.f(entry, "<this>");
        k.f(name, "name");
        JSONObject jSONObjectPut = new JSONObject().put("type", "object");
        JSONObject jSONObject = new JSONObject();
        for (Param param : entry.getParameters()) {
            jSONObject.put(param.getName(), INSTANCE.paramJsonSchema(param, entry.getComponents()));
        }
        JSONObject jSONObjectPut2 = jSONObjectPut.put("properties", jSONObject);
        JSONArray jSONArray = new JSONArray();
        List<Param> parameters = entry.getParameters();
        ArrayList arrayList = new ArrayList();
        for (Object obj : parameters) {
            if (((Param) obj).isRequired()) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            jSONArray.put(((Param) it.next()).getName());
        }
        JSONObject jSONObjectPut3 = androidx.constraintlayout.core.dsl.a.o(HintConstants.AUTOFILL_HINT_NAME, name).put("description", entry.getDescription()).put("input_schema", jSONObjectPut2.put("required", jSONArray));
        k.e(jSONObjectPut3, "put(...)");
        return jSONObjectPut3;
    }

    public final JSONArray toAnthropicTools(List<Entry> list) {
        k.f(list, "<this>");
        Set<Map.Entry<String, Entry>> setEntrySet = buildToolNameIndex(list).entrySet();
        int iP = kotlin.collections.a.P(w.c0(setEntrySet, 10));
        if (iP < 16) {
            iP = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iP);
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put((Entry) entry.getValue(), (String) entry.getKey());
        }
        JSONArray jSONArray = new JSONArray();
        for (Entry entry2 : list) {
            String strEncodeToolName = (String) linkedHashMap.get(entry2);
            if (strEncodeToolName == null) {
                strEncodeToolName = INSTANCE.encodeToolName(entry2.getPkg(), entry2.getFunctionId());
            }
            jSONArray.put(INSTANCE.toAnthropicTool(entry2, strEncodeToolName));
        }
        return jSONArray;
    }

    public final JSONObject toOutputSchemaJson(Entry entry) {
        String string;
        k.f(entry, "<this>");
        String responseTypeRef = entry.getResponseTypeRef();
        if (responseTypeRef != null && (string = m.R0(responseTypeRef).toString()) != null) {
            if (string.length() <= 0) {
                string = null;
            }
            if (string != null) {
                ObjectSchema objectSchema = entry.getComponents().get(string);
                return objectSchema != null ? inlineObjectSchema(objectSchema, entry.getComponents(), 0) : androidx.constraintlayout.core.dsl.a.o("type", "object").put("description", "unresolved response ref: ".concat(string));
            }
        }
        return null;
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010+\u001a\u00020\tHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010-\u001a\u00020\fHÆ\u0003J\u000f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eHÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00130\u0012HÆ\u0003J\u0091\u0001\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00130\u0012HÆ\u0001J\u0013\u00102\u001a\u00020\f2\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u000205HÖ\u0001J\t\u00106\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017R\u001d\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%¨\u00067"}, d2 = {"Lcom/stepos/ability/appfunctions/DirectAppFunctions$Entry;", "", "pkg", "", "functionId", "schemaType", "schemaCategory", "schemaName", "schemaVersion", "", "description", "enabledByDefault", "", "parameters", "", "Lcom/stepos/ability/appfunctions/DirectAppFunctions$Param;", ExecutionExtra.KEY_RESPONSE_TYPE_REF, "components", "", "Lcom/stepos/ability/appfunctions/DirectAppFunctions$ObjectSchema;", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;ZLjava/util/List;Ljava/lang/String;Ljava/util/Map;)V", "getPkg", "()Ljava/lang/String;", "getFunctionId", "getSchemaType", "getSchemaCategory", "getSchemaName", "getSchemaVersion", "()J", "getDescription", "getEnabledByDefault", "()Z", "getParameters", "()Ljava/util/List;", "getResponseTypeRef", "getComponents", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "other", "hashCode", "", "toString", "appfunctions_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Entry {
        private final Map<String, ObjectSchema> components;
        private final String description;
        private final boolean enabledByDefault;
        private final String functionId;
        private final List<Param> parameters;
        private final String pkg;
        private final String responseTypeRef;
        private final String schemaCategory;
        private final String schemaName;
        private final String schemaType;
        private final long schemaVersion;

        public Entry(String str, String str2, String str3, String str4, String str5, long j5, String str6, boolean z10, List list, String str7, Map map, int i, e eVar) {
            this(str, str2, str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? 0L : j5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? true : z10, (i & 256) != 0 ? EmptyList.f4893a : list, (i & 512) != 0 ? null : str7, (i & 1024) != 0 ? kotlin.collections.a.M() : map);
        }

        public static /* synthetic */ Entry copy$default(Entry entry, String str, String str2, String str3, String str4, String str5, long j5, String str6, boolean z10, List list, String str7, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                str = entry.pkg;
            }
            if ((i & 2) != 0) {
                str2 = entry.functionId;
            }
            if ((i & 4) != 0) {
                str3 = entry.schemaType;
            }
            if ((i & 8) != 0) {
                str4 = entry.schemaCategory;
            }
            if ((i & 16) != 0) {
                str5 = entry.schemaName;
            }
            if ((i & 32) != 0) {
                j5 = entry.schemaVersion;
            }
            if ((i & 64) != 0) {
                str6 = entry.description;
            }
            if ((i & 128) != 0) {
                z10 = entry.enabledByDefault;
            }
            if ((i & 256) != 0) {
                list = entry.parameters;
            }
            if ((i & 512) != 0) {
                str7 = entry.responseTypeRef;
            }
            if ((i & 1024) != 0) {
                map = entry.components;
            }
            Map map2 = map;
            List list2 = list;
            String str8 = str6;
            long j6 = j5;
            String str9 = str4;
            String str10 = str5;
            String str11 = str3;
            return entry.copy(str, str2, str11, str9, str10, j6, str8, z10, list2, str7, map2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getPkg() {
            return this.pkg;
        }

        /* renamed from: component10, reason: from getter */
        public final String getResponseTypeRef() {
            return this.responseTypeRef;
        }

        public final Map<String, ObjectSchema> component11() {
            return this.components;
        }

        /* renamed from: component2, reason: from getter */
        public final String getFunctionId() {
            return this.functionId;
        }

        /* renamed from: component3, reason: from getter */
        public final String getSchemaType() {
            return this.schemaType;
        }

        /* renamed from: component4, reason: from getter */
        public final String getSchemaCategory() {
            return this.schemaCategory;
        }

        /* renamed from: component5, reason: from getter */
        public final String getSchemaName() {
            return this.schemaName;
        }

        /* renamed from: component6, reason: from getter */
        public final long getSchemaVersion() {
            return this.schemaVersion;
        }

        /* renamed from: component7, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        /* renamed from: component8, reason: from getter */
        public final boolean getEnabledByDefault() {
            return this.enabledByDefault;
        }

        public final List<Param> component9() {
            return this.parameters;
        }

        public final Entry copy(String pkg, String functionId, String schemaType, String schemaCategory, String schemaName, long schemaVersion, String description, boolean enabledByDefault, List<Param> parameters, String responseTypeRef, Map<String, ObjectSchema> components) {
            k.f(pkg, "pkg");
            k.f(functionId, "functionId");
            k.f(schemaType, "schemaType");
            k.f(parameters, "parameters");
            k.f(components, "components");
            return new Entry(pkg, functionId, schemaType, schemaCategory, schemaName, schemaVersion, description, enabledByDefault, parameters, responseTypeRef, components);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) other;
            return k.b(this.pkg, entry.pkg) && k.b(this.functionId, entry.functionId) && k.b(this.schemaType, entry.schemaType) && k.b(this.schemaCategory, entry.schemaCategory) && k.b(this.schemaName, entry.schemaName) && this.schemaVersion == entry.schemaVersion && k.b(this.description, entry.description) && this.enabledByDefault == entry.enabledByDefault && k.b(this.parameters, entry.parameters) && k.b(this.responseTypeRef, entry.responseTypeRef) && k.b(this.components, entry.components);
        }

        public final Map<String, ObjectSchema> getComponents() {
            return this.components;
        }

        public final String getDescription() {
            return this.description;
        }

        public final boolean getEnabledByDefault() {
            return this.enabledByDefault;
        }

        public final String getFunctionId() {
            return this.functionId;
        }

        public final List<Param> getParameters() {
            return this.parameters;
        }

        public final String getPkg() {
            return this.pkg;
        }

        public final String getResponseTypeRef() {
            return this.responseTypeRef;
        }

        public final String getSchemaCategory() {
            return this.schemaCategory;
        }

        public final String getSchemaName() {
            return this.schemaName;
        }

        public final String getSchemaType() {
            return this.schemaType;
        }

        public final long getSchemaVersion() {
            return this.schemaVersion;
        }

        public int hashCode() {
            int iC = a.c(a.c(this.pkg.hashCode() * 31, 31, this.functionId), 31, this.schemaType);
            String str = this.schemaCategory;
            int iHashCode = (iC + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.schemaName;
            int iC2 = androidx.appfunctions.metadata.a.c((iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31, 31, this.schemaVersion);
            String str3 = this.description;
            int iE = androidx.appfunctions.metadata.a.e(this.parameters, androidx.appfunctions.metadata.a.d((iC2 + (str3 == null ? 0 : str3.hashCode())) * 31, 31, this.enabledByDefault), 31);
            String str4 = this.responseTypeRef;
            return this.components.hashCode() + ((iE + (str4 != null ? str4.hashCode() : 0)) * 31);
        }

        public String toString() {
            String str = this.pkg;
            String str2 = this.functionId;
            String str3 = this.schemaType;
            String str4 = this.schemaCategory;
            String str5 = this.schemaName;
            long j5 = this.schemaVersion;
            String str6 = this.description;
            boolean z10 = this.enabledByDefault;
            List<Param> list = this.parameters;
            String str7 = this.responseTypeRef;
            Map<String, ObjectSchema> map = this.components;
            StringBuilder sbW = a.w("Entry(pkg=", str, ", functionId=", str2, ", schemaType=");
            androidx.constraintlayout.core.dsl.a.A(sbW, str3, ", schemaCategory=", str4, ", schemaName=");
            a.y(j5, str5, ", schemaVersion=", sbW);
            sbW.append(", description=");
            sbW.append(str6);
            sbW.append(", enabledByDefault=");
            sbW.append(z10);
            sbW.append(", parameters=");
            sbW.append(list);
            sbW.append(", responseTypeRef=");
            sbW.append(str7);
            sbW.append(", components=");
            sbW.append(map);
            sbW.append(")");
            return sbW.toString();
        }

        public Entry(String pkg, String functionId, String schemaType, String str, String str2, long j5, String str3, boolean z10, List<Param> parameters, String str4, Map<String, ObjectSchema> components) {
            k.f(pkg, "pkg");
            k.f(functionId, "functionId");
            k.f(schemaType, "schemaType");
            k.f(parameters, "parameters");
            k.f(components, "components");
            this.pkg = pkg;
            this.functionId = functionId;
            this.schemaType = schemaType;
            this.schemaCategory = str;
            this.schemaName = str2;
            this.schemaVersion = j5;
            this.description = str3;
            this.enabledByDefault = z10;
            this.parameters = parameters;
            this.responseTypeRef = str4;
            this.components = components;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003JA\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/stepos/ability/appfunctions/DirectAppFunctions$PropertySchema;", "", "type", "", "isNullable", "", "description", "", "refQualifiedName", "arrayItemQualifiedName", AppAgent.CONSTRUCT, "(IZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getType", "()I", "()Z", "getDescription", "()Ljava/lang/String;", "getRefQualifiedName", "getArrayItemQualifiedName", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "appfunctions_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class PropertySchema {
        private final String arrayItemQualifiedName;
        private final String description;
        private final boolean isNullable;
        private final String refQualifiedName;
        private final int type;

        public PropertySchema(int i, boolean z10, String str, String str2, String str3) {
            this.type = i;
            this.isNullable = z10;
            this.description = str;
            this.refQualifiedName = str2;
            this.arrayItemQualifiedName = str3;
        }

        public static /* synthetic */ PropertySchema copy$default(PropertySchema propertySchema, int i, boolean z10, String str, String str2, String str3, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                i = propertySchema.type;
            }
            if ((i6 & 2) != 0) {
                z10 = propertySchema.isNullable;
            }
            if ((i6 & 4) != 0) {
                str = propertySchema.description;
            }
            if ((i6 & 8) != 0) {
                str2 = propertySchema.refQualifiedName;
            }
            if ((i6 & 16) != 0) {
                str3 = propertySchema.arrayItemQualifiedName;
            }
            String str4 = str3;
            String str5 = str;
            return propertySchema.copy(i, z10, str5, str2, str4);
        }

        /* renamed from: component1, reason: from getter */
        public final int getType() {
            return this.type;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsNullable() {
            return this.isNullable;
        }

        /* renamed from: component3, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        /* renamed from: component4, reason: from getter */
        public final String getRefQualifiedName() {
            return this.refQualifiedName;
        }

        /* renamed from: component5, reason: from getter */
        public final String getArrayItemQualifiedName() {
            return this.arrayItemQualifiedName;
        }

        public final PropertySchema copy(int type, boolean isNullable, String description, String refQualifiedName, String arrayItemQualifiedName) {
            return new PropertySchema(type, isNullable, description, refQualifiedName, arrayItemQualifiedName);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PropertySchema)) {
                return false;
            }
            PropertySchema propertySchema = (PropertySchema) other;
            return this.type == propertySchema.type && this.isNullable == propertySchema.isNullable && k.b(this.description, propertySchema.description) && k.b(this.refQualifiedName, propertySchema.refQualifiedName) && k.b(this.arrayItemQualifiedName, propertySchema.arrayItemQualifiedName);
        }

        public final String getArrayItemQualifiedName() {
            return this.arrayItemQualifiedName;
        }

        public final String getDescription() {
            return this.description;
        }

        public final String getRefQualifiedName() {
            return this.refQualifiedName;
        }

        public final int getType() {
            return this.type;
        }

        public int hashCode() {
            int iD = androidx.appfunctions.metadata.a.d(Integer.hashCode(this.type) * 31, 31, this.isNullable);
            String str = this.description;
            int iHashCode = (iD + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.refQualifiedName;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.arrayItemQualifiedName;
            return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
        }

        public final boolean isNullable() {
            return this.isNullable;
        }

        public String toString() {
            int i = this.type;
            boolean z10 = this.isNullable;
            String str = this.description;
            String str2 = this.refQualifiedName;
            String str3 = this.arrayItemQualifiedName;
            StringBuilder sb = new StringBuilder("PropertySchema(type=");
            sb.append(i);
            sb.append(", isNullable=");
            sb.append(z10);
            sb.append(", description=");
            androidx.constraintlayout.core.dsl.a.A(sb, str, ", refQualifiedName=", str2, ", arrayItemQualifiedName=");
            return a.q(sb, str3, ")");
        }

        public /* synthetic */ PropertySchema(int i, boolean z10, String str, String str2, String str3, int i6, e eVar) {
            this(i, z10, (i6 & 4) != 0 ? null : str, (i6 & 8) != 0 ? null : str2, (i6 & 16) != 0 ? null : str3);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003JI\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000e¨\u0006\u001f"}, d2 = {"Lcom/stepos/ability/appfunctions/DirectAppFunctions$Param;", "", HintConstants.AUTOFILL_HINT_NAME, "", "isRequired", "", "type", "", "isNullable", "description", "refQualifiedName", AppAgent.CONSTRUCT, "(Ljava/lang/String;ZIZLjava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "()Z", "getType", "()I", "getDescription", "getRefQualifiedName", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "appfunctions_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Param {
        private final String description;
        private final boolean isNullable;
        private final boolean isRequired;
        private final String name;
        private final String refQualifiedName;
        private final int type;

        public Param(String name, boolean z10, int i, boolean z11, String str, String str2) {
            k.f(name, "name");
            this.name = name;
            this.isRequired = z10;
            this.type = i;
            this.isNullable = z11;
            this.description = str;
            this.refQualifiedName = str2;
        }

        public static /* synthetic */ Param copy$default(Param param, String str, boolean z10, int i, boolean z11, String str2, String str3, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                str = param.name;
            }
            if ((i6 & 2) != 0) {
                z10 = param.isRequired;
            }
            if ((i6 & 4) != 0) {
                i = param.type;
            }
            if ((i6 & 8) != 0) {
                z11 = param.isNullable;
            }
            if ((i6 & 16) != 0) {
                str2 = param.description;
            }
            if ((i6 & 32) != 0) {
                str3 = param.refQualifiedName;
            }
            String str4 = str2;
            String str5 = str3;
            return param.copy(str, z10, i, z11, str4, str5);
        }

        /* renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsRequired() {
            return this.isRequired;
        }

        /* renamed from: component3, reason: from getter */
        public final int getType() {
            return this.type;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getIsNullable() {
            return this.isNullable;
        }

        /* renamed from: component5, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        /* renamed from: component6, reason: from getter */
        public final String getRefQualifiedName() {
            return this.refQualifiedName;
        }

        public final Param copy(String name, boolean isRequired, int type, boolean isNullable, String description, String refQualifiedName) {
            k.f(name, "name");
            return new Param(name, isRequired, type, isNullable, description, refQualifiedName);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Param)) {
                return false;
            }
            Param param = (Param) other;
            return k.b(this.name, param.name) && this.isRequired == param.isRequired && this.type == param.type && this.isNullable == param.isNullable && k.b(this.description, param.description) && k.b(this.refQualifiedName, param.refQualifiedName);
        }

        public final String getDescription() {
            return this.description;
        }

        public final String getName() {
            return this.name;
        }

        public final String getRefQualifiedName() {
            return this.refQualifiedName;
        }

        public final int getType() {
            return this.type;
        }

        public int hashCode() {
            int iD = androidx.appfunctions.metadata.a.d(androidx.constraintlayout.core.dsl.a.a(this.type, androidx.appfunctions.metadata.a.d(this.name.hashCode() * 31, 31, this.isRequired), 31), 31, this.isNullable);
            String str = this.description;
            int iHashCode = (iD + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.refQualifiedName;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public final boolean isNullable() {
            return this.isNullable;
        }

        public final boolean isRequired() {
            return this.isRequired;
        }

        public String toString() {
            String str = this.name;
            boolean z10 = this.isRequired;
            int i = this.type;
            boolean z11 = this.isNullable;
            String str2 = this.description;
            String str3 = this.refQualifiedName;
            StringBuilder sbL = androidx.constraintlayout.core.dsl.a.l("Param(name=", str, ", isRequired=", ", type=", z10);
            sbL.append(i);
            sbL.append(", isNullable=");
            sbL.append(z11);
            sbL.append(", description=");
            return androidx.appfunctions.metadata.a.p(sbL, str2, ", refQualifiedName=", str3, ")");
        }

        public /* synthetic */ Param(String str, boolean z10, int i, boolean z11, String str2, String str3, int i6, e eVar) {
            this(str, z10, i, z11, (i6 & 16) != 0 ? null : str2, (i6 & 32) != 0 ? null : str3);
        }
    }
}
