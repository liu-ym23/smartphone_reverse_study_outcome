package com.stepos.agentframework.chatui;

import Ua.C1060i;
import Ua.InterfaceC1066l;
import Z8.C1173v;
import Z8.C1174w;
import android.annotation.SuppressLint;
import android.os.SystemClock;
import android.os.Trace;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.AgentUIConfig;
import com.stepos.agentframework.R$layout;
import com.stepos.agentframework.chatcore.session.AgentRole;
import com.stepos.agentframework.chatcore.session.EReplyStatus;
import com.stepos.agentframework.chatcore.session.ReconnectReason;
import com.stepos.agentframework.chatcore.session.bean.AppUIData;
import com.stepos.agentframework.chatui.longtext.ChatRenderRow;
import com.stepos.agentframework.chatui.longtext.LongTextDocument;
import com.stepos.agentframework.chatui.viewholder.AbstractC2106k;
import com.stepos.agentframework.chatui.viewholder.C2104i;
import com.stepos.agentframework.chatui.viewholder.C2107l;
import com.stepos.agentframework.chatui.viewholder.C2108m;
import com.stepos.agentframework.chatui.viewholder.C2109n;
import com.stepos.agentframework.chatui.viewholder.C2113s;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.core.download.ModelFlowMeta;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h8.C4148a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.jvm.internal.FunctionReferenceImpl;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import v9.C5685n;
import z4.C6360f;
import z4.LongTextCandidate;
import z4.LongTextKey;

@Metadata(d1 = {"\u0000Ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e*\u0004Ë\u0001Î\u0001\u0018\u0000 ò\u00012\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0006ó\u0001ô\u0001õ\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0010\u0010\u000fJ\u001f\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0017\u0010\u0014J\u000f\u0010\u0018\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J%\u0010\u001d\u001a\u00020\r2\b\b\u0002\u0010\u001a\u001a\u00020\u000b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\bH\u0002¢\u0006\u0004\b \u0010!J\u0018\u0010$\u001a\u00020\r2\u0006\u0010#\u001a\u00020\"H\u0082@¢\u0006\u0004\b$\u0010%J\u0017\u0010'\u001a\u00020\r2\u0006\u0010&\u001a\u00020\"H\u0002¢\u0006\u0004\b'\u0010(J9\u0010.\u001a\u00020\r2\u0006\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u000b2\u0018\u0010-\u001a\u0014\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00020+H\u0002¢\u0006\u0004\b.\u0010/J?\u00108\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\b2\u0006\u00100\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u00022\u0006\u00103\u001a\u0002022\u0006\u00105\u001a\u0002042\u0006\u00107\u001a\u000206H\u0002¢\u0006\u0004\b8\u00109J\u001f\u0010:\u001a\u00020\r2\u0006\u00101\u001a\u00020\u00022\u0006\u00100\u001a\u00020\u000bH\u0002¢\u0006\u0004\b:\u0010;J-\u0010>\u001a\u00020\r2\u0006\u00101\u001a\u00020\u00022\u0006\u00100\u001a\u00020\u000b2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u001b0<H\u0002¢\u0006\u0004\b>\u0010?J\u000f\u0010@\u001a\u00020\rH\u0002¢\u0006\u0004\b@\u0010\u0019J\u0017\u0010C\u001a\u00020\u000b2\u0006\u0010B\u001a\u00020AH\u0002¢\u0006\u0004\bC\u0010DJ\u001f\u0010G\u001a\u00020\u000b2\u0006\u0010E\u001a\u0002022\u0006\u0010F\u001a\u00020\u000bH\u0002¢\u0006\u0004\bG\u0010HJ!\u0010K\u001a\u00020\r2\u0006\u0010I\u001a\u00020A2\b\u0010J\u001a\u0004\u0018\u00010AH\u0002¢\u0006\u0004\bK\u0010LJ\u000f\u0010M\u001a\u000206H\u0002¢\u0006\u0004\bM\u0010NJ\u0017\u0010P\u001a\u00020\r2\u0006\u0010O\u001a\u000206H\u0002¢\u0006\u0004\bP\u0010QJ\u000f\u0010R\u001a\u00020\rH\u0002¢\u0006\u0004\bR\u0010\u0019J\u000f\u0010S\u001a\u00020\u000bH\u0002¢\u0006\u0004\bS\u0010TJ\u000f\u0010U\u001a\u00020\u000bH\u0002¢\u0006\u0004\bU\u0010TJ\u000f\u0010V\u001a\u00020\u000bH\u0002¢\u0006\u0004\bV\u0010TJ\u000f\u0010W\u001a\u00020\rH\u0002¢\u0006\u0004\bW\u0010\u0019J\u000f\u0010X\u001a\u00020\u000bH\u0002¢\u0006\u0004\bX\u0010TJ\u0017\u0010Y\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\bY\u0010\u000fJ\u000f\u0010Z\u001a\u00020\u000bH\u0002¢\u0006\u0004\bZ\u0010TJ\u000f\u0010[\u001a\u00020\rH\u0002¢\u0006\u0004\b[\u0010\u0019J\u001f\u0010^\u001a\u00020\r2\u0006\u0010E\u001a\u0002022\u0006\u0010]\u001a\u00020\\H\u0002¢\u0006\u0004\b^\u0010_J'\u0010`\u001a\u00020\r2\u0006\u0010&\u001a\u00020\"2\u0006\u0010E\u001a\u0002022\u0006\u0010]\u001a\u00020\\H\u0002¢\u0006\u0004\b`\u0010aJ\u000f\u0010b\u001a\u00020\rH\u0002¢\u0006\u0004\bb\u0010\u0019J\u0019\u0010c\u001a\u0004\u0018\u00010\b2\u0006\u00100\u001a\u00020\u000bH\u0000¢\u0006\u0004\bc\u0010dJ\u0017\u0010f\u001a\u0004\u0018\u00010e2\u0006\u00100\u001a\u00020\u000b¢\u0006\u0004\bf\u0010gJ\u0015\u0010h\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u000b¢\u0006\u0004\bh\u0010iJ\u0015\u0010j\u001a\u0002062\u0006\u00100\u001a\u00020\u000b¢\u0006\u0004\bj\u0010kJ\r\u0010l\u001a\u00020\r¢\u0006\u0004\bl\u0010\u0019J\u0015\u0010m\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u000b¢\u0006\u0004\bm\u0010iJ\u001f\u0010p\u001a\u00020\u000b2\u0006\u0010n\u001a\u00020\u000b2\b\b\u0002\u0010o\u001a\u000206¢\u0006\u0004\bp\u0010qJ)\u0010s\u001a\u00020\u000b2\u0006\u0010E\u001a\u0002022\b\b\u0002\u0010r\u001a\u00020\u000b2\b\b\u0002\u0010o\u001a\u000206¢\u0006\u0004\bs\u0010tJ%\u0010v\u001a\u0002062\u0006\u0010E\u001a\u0002022\u0006\u0010r\u001a\u00020\u000b2\u0006\u0010u\u001a\u00020\u000b¢\u0006\u0004\bv\u0010wJ!\u0010x\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\bx\u0010\u001eJ\u0017\u0010y\u001a\u00020\r2\u0006\u0010&\u001a\u00020\"H\u0016¢\u0006\u0004\by\u0010(J\u0017\u0010z\u001a\u00020\r2\u0006\u0010&\u001a\u00020\"H\u0016¢\u0006\u0004\bz\u0010(J\u001f\u0010}\u001a\u00020\u00022\u0006\u0010|\u001a\u00020{2\u0006\u0010)\u001a\u00020\u000bH\u0016¢\u0006\u0004\b}\u0010~J\u001f\u0010\u007f\u001a\u00020\r2\u0006\u00101\u001a\u00020\u00022\u0006\u00100\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u007f\u0010;J/\u0010\u0080\u0001\u001a\u00020\r2\u0006\u00101\u001a\u00020\u00022\u0006\u00100\u001a\u00020\u000b2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u001b0<H\u0016¢\u0006\u0005\b\u0080\u0001\u0010?J\u0011\u0010\u0081\u0001\u001a\u00020\u000bH\u0016¢\u0006\u0005\b\u0081\u0001\u0010TJ\u0019\u0010\u0082\u0001\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u000bH\u0016¢\u0006\u0005\b\u0082\u0001\u0010iJ!\u0010\u0084\u0001\u001a\u00020\r2\r\u0010\u0083\u0001\u001a\b\u0012\u0004\u0012\u00020A0<H\u0007¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J\u001f\u0010\u0086\u0001\u001a\u0002062\r\u0010\u0083\u0001\u001a\b\u0012\u0004\u0012\u00020A0\u0007¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J!\u0010\u0088\u0001\u001a\u00020\r2\r\u0010\u0083\u0001\u001a\b\u0012\u0004\u0012\u00020A0<H\u0007¢\u0006\u0006\b\u0088\u0001\u0010\u0085\u0001J\u0011\u0010\u0089\u0001\u001a\u00020\rH\u0007¢\u0006\u0005\b\u0089\u0001\u0010\u0019J!\u0010\u008b\u0001\u001a\u00020\r2\u0006\u0010B\u001a\u00020A2\u0007\u0010\u008a\u0001\u001a\u000202¢\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001J\u0018\u0010\u008d\u0001\u001a\u00020\r2\u0006\u0010B\u001a\u00020A¢\u0006\u0006\b\u008d\u0001\u0010\u008e\u0001J\u0018\u0010\u008f\u0001\u001a\u00020\r2\u0006\u0010B\u001a\u00020A¢\u0006\u0006\b\u008f\u0001\u0010\u008e\u0001J\u0018\u0010\u0090\u0001\u001a\u00020\r2\u0006\u0010E\u001a\u000202¢\u0006\u0006\b\u0090\u0001\u0010\u0091\u0001J\u0018\u0010\u0092\u0001\u001a\u00020\r2\u0006\u0010E\u001a\u000202¢\u0006\u0006\b\u0092\u0001\u0010\u0091\u0001J!\u0010\u0094\u0001\u001a\u00020\r2\u0006\u0010E\u001a\u0002022\u0007\u0010\u0093\u0001\u001a\u00020\u000b¢\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001J\u000f\u0010\u0096\u0001\u001a\u00020\u000b¢\u0006\u0005\b\u0096\u0001\u0010TJ\u000f\u0010\u0097\u0001\u001a\u00020\r¢\u0006\u0005\b\u0097\u0001\u0010\u0019J\u000f\u0010\u0098\u0001\u001a\u000206¢\u0006\u0005\b\u0098\u0001\u0010NJ\u000f\u0010\u0099\u0001\u001a\u00020\r¢\u0006\u0005\b\u0099\u0001\u0010\u0019J\u000f\u0010\u009a\u0001\u001a\u00020\r¢\u0006\u0005\b\u009a\u0001\u0010\u0019J\u000f\u0010\u009b\u0001\u001a\u00020\r¢\u0006\u0005\b\u009b\u0001\u0010\u0019J\u001c\u0010\u009e\u0001\u001a\u00020\r2\n\b\u0002\u0010\u009d\u0001\u001a\u00030\u009c\u0001¢\u0006\u0006\b\u009e\u0001\u0010\u009f\u0001J\u001e\u0010 \u0001\u001a\u00020\r2\f\b\u0002\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009c\u0001¢\u0006\u0006\b \u0001\u0010\u009f\u0001J\u0018\u0010¡\u0001\u001a\u00020\r2\u0006\u0010E\u001a\u000202¢\u0006\u0006\b¡\u0001\u0010\u0091\u0001J\u000f\u0010¢\u0001\u001a\u00020\r¢\u0006\u0005\b¢\u0001\u0010\u0019J\"\u0010¥\u0001\u001a\u00020\r2\u0007\u0010£\u0001\u001a\u0002022\u0007\u0010¤\u0001\u001a\u000202¢\u0006\u0006\b¥\u0001\u0010¦\u0001J\u000f\u0010§\u0001\u001a\u00020\r¢\u0006\u0005\b§\u0001\u0010\u0019J\u000f\u0010¨\u0001\u001a\u00020\r¢\u0006\u0005\b¨\u0001\u0010\u0019J\u001f\u0010©\u0001\u001a\u00020\r2\u0006\u0010E\u001a\u0002022\u0006\u0010]\u001a\u00020\\¢\u0006\u0005\b©\u0001\u0010_R&\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b\u0004\u0010ª\u0001\u001a\u0006\b«\u0001\u0010¬\u0001\"\u0005\b\u00ad\u0001\u0010\u0006R\u0017\u0010°\u0001\u001a\u0002028\u0002X\u0082D¢\u0006\b\n\u0006\b®\u0001\u0010¯\u0001R!\u0010±\u0001\u001a\b\u0012\u0004\u0012\u00020e0<8\u0006¢\u0006\u000f\n\u0006\b±\u0001\u0010²\u0001\u001a\u0005\b³\u0001\u0010\nR\u001f\u0010´\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b´\u0001\u0010²\u0001R\u0019\u0010µ\u0001\u001a\u0002048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bµ\u0001\u0010\u009a\u0001R \u0010·\u0001\u001a\u000b ¶\u0001*\u0004\u0018\u000102028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b·\u0001\u0010¯\u0001R\u0018\u0010¹\u0001\u001a\u00030¸\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¹\u0001\u0010º\u0001R&\u0010¾\u0001\u001a\u0011\u0012\u0005\u0012\u00030¼\u0001\u0012\u0005\u0012\u00030½\u00010»\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¾\u0001\u0010¿\u0001R\u0019\u0010À\u0001\u001a\u0002028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÀ\u0001\u0010¯\u0001R/\u0010Â\u0001\u001a\u0002062\u0007\u0010Á\u0001\u001a\u0002068\u0006@FX\u0086\u000e¢\u0006\u0015\n\u0005\bÂ\u0001\u0010x\u001a\u0005\bÃ\u0001\u0010N\"\u0005\bÄ\u0001\u0010QR\u001a\u0010Æ\u0001\u001a\u00030Å\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÆ\u0001\u0010Ç\u0001R\u001c\u0010É\u0001\u001a\u0005\u0018\u00010È\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÉ\u0001\u0010Ê\u0001R\u0018\u0010Ì\u0001\u001a\u00030Ë\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÌ\u0001\u0010Í\u0001R\u0018\u0010Ï\u0001\u001a\u00030Î\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÏ\u0001\u0010Ð\u0001R\u001b\u0010Ñ\u0001\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÑ\u0001\u0010Ò\u0001R\u0018\u0010Ó\u0001\u001a\u0002068\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bÓ\u0001\u0010xR$\u0010Ô\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0»\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÔ\u0001\u0010¿\u0001R6\u0010Õ\u0001\u001a!\u0012\u0004\u0012\u00020\u000b\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00020+0»\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÕ\u0001\u0010¿\u0001R2\u0010×\u0001\u001a\u000b\u0012\u0004\u0012\u00020\r\u0018\u00010Ö\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b×\u0001\u0010Ø\u0001\u001a\u0006\bÙ\u0001\u0010Ú\u0001\"\u0006\bÛ\u0001\u0010Ü\u0001R2\u0010Ý\u0001\u001a\u000b\u0012\u0004\u0012\u00020\r\u0018\u00010Ö\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bÝ\u0001\u0010Ø\u0001\u001a\u0006\bÞ\u0001\u0010Ú\u0001\"\u0006\bß\u0001\u0010Ü\u0001R6\u0010á\u0001\u001a\u000f\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\r0à\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bá\u0001\u0010â\u0001\u001a\u0006\bã\u0001\u0010ä\u0001\"\u0006\bå\u0001\u0010æ\u0001R\u0018\u0010ç\u0001\u001a\u0002068\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bç\u0001\u0010xR,\u0010é\u0001\u001a\u0005\u0018\u00010è\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bé\u0001\u0010ê\u0001\u001a\u0006\bë\u0001\u0010ì\u0001\"\u0006\bí\u0001\u0010î\u0001R&\u0010ï\u0001\u001a\u0002068\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bï\u0001\u0010x\u001a\u0005\bð\u0001\u0010N\"\u0005\bñ\u0001\u0010Q¨\u0006ö\u0001"}, d2 = {"Lcom/stepos/agentframework/chatui/ChatMessageAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/stepos/agentframework/chatui/viewholder/k;", "Lcom/stepos/agentframework/chatui/U1;", "chatView", "<init>", "(Lcom/stepos/agentframework/chatui/U1;)V", "", "Lcom/stepos/agentframework/chatui/longtext/ChatRenderRow;", "z", "()Ljava/util/List;", "", "index", "LY8/t;", "b0", "(I)V", "e0", "from", "to", "c0", "(II)V", "start", "count", "d0", "E0", "()V", "changedIndex", "", "payload", "n0", "(ILjava/lang/Object;)V", "row", "l0", "(Lcom/stepos/agentframework/chatui/longtext/ChatRenderRow;)V", "Landroidx/recyclerview/widget/RecyclerView;", "rv", "v", "(Landroidx/recyclerview/widget/RecyclerView;Le9/c;)Ljava/lang/Object;", "recyclerView", "k0", "(Landroidx/recyclerview/widget/RecyclerView;)V", "viewType", "layoutId", "Lkotlin/Function2;", "Landroid/view/View;", "creator", "s0", "(IILp9/p;)V", "position", "holder", "", "mode", "", "bindMs", "", "completed", "D0", "(Lcom/stepos/agentframework/chatui/longtext/ChatRenderRow;ILcom/stepos/agentframework/chatui/viewholder/k;Ljava/lang/String;JZ)V", "x", "(Lcom/stepos/agentframework/chatui/viewholder/k;I)V", "", "payloads", "w", "(Lcom/stepos/agentframework/chatui/viewholder/k;ILjava/util/List;)V", "D", "Lcom/stepos/agentframework/chatui/N1;", "message", "P", "(Lcom/stepos/agentframework/chatui/N1;)I", "messageId", "keepIndex", "v0", "(Ljava/lang/String;I)I", "incoming", "existing", "O", "(Lcom/stepos/agentframework/chatui/N1;Lcom/stepos/agentframework/chatui/N1;)V", "H", "()Z", "notify", "P0", "(Z)V", "u0", "U", "()I", "S0", "p0", "r0", "y", "z0", "T0", "t0", "Lcom/stepos/agentframework/chatui/SendState;", VoiceWakeupReceiver.EXTRA_STATE, "Q0", "(Ljava/lang/String;Lcom/stepos/agentframework/chatui/SendState;)V", "u", "(Landroidx/recyclerview/widget/RecyclerView;Ljava/lang/String;Lcom/stepos/agentframework/chatui/SendState;)V", "C", "G0", "(I)Lcom/stepos/agentframework/chatui/longtext/ChatRenderRow;", "Lcom/stepos/agentframework/chatui/S1;", ExifInterface.LATITUDE_SOUTH, "(I)Lcom/stepos/agentframework/chatui/S1;", ExifInterface.LONGITUDE_EAST, "(I)I", "Q", "(I)Z", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "logicalIndex", "atTop", "x0", "(IZ)I", "displayOffset", ExifInterface.LONGITUDE_WEST, "(Ljava/lang/String;IZ)I", "pixelOffset", "F0", "(Ljava/lang/String;II)Z", "Z", "onAttachedToRecyclerView", "onDetachedFromRecyclerView", "Landroid/view/ViewGroup;", "parent", "i0", "(Landroid/view/ViewGroup;I)Lcom/stepos/agentframework/chatui/viewholder/k;", "g0", "h0", "getItemCount", "getItemViewType", "messages", "H0", "(Ljava/util/List;)V", "I", "(Ljava/util/List;)Z", "r", "clear", "oldMessageId", "C0", "(Lcom/stepos/agentframework/chatui/N1;Ljava/lang/String;)V", "s", "(Lcom/stepos/agentframework/chatui/N1;)V", "t", "w0", "(Ljava/lang/String;)V", "Y", "likeStatus", "U0", "(Ljava/lang/String;I)V", ExifInterface.GPS_DIRECTION_TRUE, "q0", "R", "M0", "J", "M", "Lcom/stepos/agentframework/chatcore/session/ReconnectReason;", "reason", "N0", "(Lcom/stepos/agentframework/chatcore/session/ReconnectReason;)V", "K", "A0", "B0", "hint", "action", "O0", "(Ljava/lang/String;Ljava/lang/String;)V", "N", "B", "V0", "Lcom/stepos/agentframework/chatui/U1;", "F", "()Lcom/stepos/agentframework/chatui/U1;", "setChatView", "TAG$1", "Ljava/lang/String;", "TAG", "itemList", "Ljava/util/List;", "G", "renderRows", "nextPreparationId", "kotlin.jvm.PlatformType", "diagnosticAdapterId", "Lz4/f;", "bindLogLimiter", "Lz4/f;", "", "Lz4/e;", "Lcom/stepos/agentframework/chatui/ChatMessageAdapter$c;", "preparations", "Ljava/util/Map;", "projectionDisabledReason", UxipConstants.f30680s, "longTextProjectionEnabled", "getLongTextProjectionEnabled", "setLongTextProjectionEnabled", "LUa/M;", "preparationScope", "LUa/M;", "Lcom/stepos/agentframework/chatui/ChatMessageAdapter$b;", "pendingTextViewport", "Lcom/stepos/agentframework/chatui/ChatMessageAdapter$b;", "com/stepos/agentframework/chatui/ChatMessageAdapter$i", "viewportScrollListener", "Lcom/stepos/agentframework/chatui/ChatMessageAdapter$i;", "com/stepos/agentframework/chatui/ChatMessageAdapter$h", "viewportAttachListener", "Lcom/stepos/agentframework/chatui/ChatMessageAdapter$h;", "attachedRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "actionFooterWarmed", "viewTypeLayoutMap", "viewHolderCreatorMap", "Lkotlin/Function0;", "onViewBound", "Lp9/a;", "getOnViewBound", "()Lp9/a;", "J0", "(Lp9/a;)V", "onViewBoundForScroll", "getOnViewBoundForScroll$agentcore_release", "K0", "Lkotlin/Function1;", "onDataEmptyStateChanged", "Lp9/l;", "getOnDataEmptyStateChanged", "()Lp9/l;", "I0", "(Lp9/l;)V", "isEmptyState", "Lcom/stepos/agentframework/AgentUIConfig;", "agentUiConfig", "Lcom/stepos/agentframework/AgentUIConfig;", "getAgentUiConfig", "()Lcom/stepos/agentframework/AgentUIConfig;", "setAgentUiConfig", "(Lcom/stepos/agentframework/AgentUIConfig;)V", "suppressActionBarForTask", "getSuppressActionBarForTask", "L0", "Companion", "c", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ChatMessageAdapter extends RecyclerView.Adapter<AbstractC2106k> {
    private static final Ua.I LONG_TEXT_WORKER = Ua.I.t1(Ua.Y.a(), 1, null, 2, null);
    public static final String PAYLOAD_COLLAPSE_COT = "collapse_cot";
    public static final String PAYLOAD_REPLACE_MESSAGE = "replace_message";
    public static final String PAYLOAD_SENT_MESSAGE_DISMISS_ERROR = "sent_msg_dismiss_error";
    public static final String PAYLOAD_SENT_MESSAGE_SHOW_ERROR = "sent_msg_show_error";
    public static final String PAYLOAD_UPDATE_CONTENT = "update_content";
    public static final String PAYLOAD_UPDATE_LIKE = "update_like";
    public static final String PAYLOAD_UPDATE_LOADING = "update_loading";
    public static final String PAYLOAD_UPDATE_SEND_STATE = "update_send_state";
    public static final String PAYLOAD_UPDATE_SUGGESTIONS = "update_suggestions";
    private static final String TAG = "ChatMessageAdapter";
    private static final int TYPE_LONG_TEXT = 9;
    private static final int TYPE_LONG_TEXT_ATTACHMENTS = 12;
    private static final int TYPE_LONG_TEXT_CODE = 14;
    private static final int TYPE_LONG_TEXT_HEADER = 10;
    private static final int TYPE_LONG_TEXT_TABLE_ROW = 13;
    private static final int TYPE_MARKDOWN_SLICE = 11;

    /* renamed from: TAG$1, reason: from kotlin metadata */
    private final String TAG;
    private boolean actionFooterWarmed;
    private AgentUIConfig agentUiConfig;
    private RecyclerView attachedRecyclerView;
    private final C6360f bindLogLimiter;
    private U1 chatView;
    private final String diagnosticAdapterId;
    private boolean isEmptyState;
    private final List<S1> itemList;
    private boolean longTextProjectionEnabled;
    private long nextPreparationId;
    private InterfaceC5074l<? super Boolean, Y8.t> onDataEmptyStateChanged;
    private InterfaceC5063a<Y8.t> onViewBound;
    private InterfaceC5063a<Y8.t> onViewBoundForScroll;
    private PendingTextViewport pendingTextViewport;
    private Ua.M preparationScope;
    private final Map<LongTextKey, c> preparations;
    private String projectionDisabledReason;
    private List<ChatRenderRow> renderRows;
    private boolean suppressActionBarForTask;
    private final Map<Integer, p9.p<View, U1, AbstractC2106k>> viewHolderCreatorMap;
    private final Map<Integer, Integer> viewTypeLayoutMap;
    private final h viewportAttachListener;
    private final i viewportScrollListener;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatui.ChatMessageAdapter$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements p9.p<View, U1, com.stepos.agentframework.chatui.viewholder.F> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(2, com.stepos.agentframework.chatui.viewholder.F.class, "<init>", "<init>(Landroid/view/View;Lcom/stepos/agentframework/chatui/IChatView;)V", 0);
        }

        @Override // p9.p
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public final com.stepos.agentframework.chatui.viewholder.F invoke(View p02, U1 p12) {
            kotlin.jvm.internal.p.i(p02, "p0");
            kotlin.jvm.internal.p.i(p12, "p1");
            return new com.stepos.agentframework.chatui.viewholder.F(p02, p12);
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatui.ChatMessageAdapter$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements p9.p<View, U1, com.stepos.agentframework.chatui.viewholder.O> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(2, com.stepos.agentframework.chatui.viewholder.O.class, "<init>", "<init>(Landroid/view/View;Lcom/stepos/agentframework/chatui/IChatView;)V", 0);
        }

        @Override // p9.p
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public final com.stepos.agentframework.chatui.viewholder.O invoke(View p02, U1 p12) {
            kotlin.jvm.internal.p.i(p02, "p0");
            kotlin.jvm.internal.p.i(p12, "p1");
            return new com.stepos.agentframework.chatui.viewholder.O(p02, p12);
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatui.ChatMessageAdapter$3, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements p9.p<View, U1, com.stepos.agentframework.chatui.viewholder.M> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(2, com.stepos.agentframework.chatui.viewholder.M.class, "<init>", "<init>(Landroid/view/View;Lcom/stepos/agentframework/chatui/IChatView;)V", 0);
        }

        @Override // p9.p
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public final com.stepos.agentframework.chatui.viewholder.M invoke(View p02, U1 p12) {
            kotlin.jvm.internal.p.i(p02, "p0");
            kotlin.jvm.internal.p.i(p12, "p1");
            return new com.stepos.agentframework.chatui.viewholder.M(p02, p12);
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatui.ChatMessageAdapter$4, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements p9.p<View, U1, com.stepos.agentframework.chatui.viewholder.J> {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        public AnonymousClass4() {
            super(2, com.stepos.agentframework.chatui.viewholder.J.class, "<init>", "<init>(Landroid/view/View;Lcom/stepos/agentframework/chatui/IChatView;)V", 0);
        }

        @Override // p9.p
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public final com.stepos.agentframework.chatui.viewholder.J invoke(View p02, U1 p12) {
            kotlin.jvm.internal.p.i(p02, "p0");
            kotlin.jvm.internal.p.i(p12, "p1");
            return new com.stepos.agentframework.chatui.viewholder.J(p02, p12);
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatui.ChatMessageAdapter$5, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass5 extends FunctionReferenceImpl implements p9.p<View, U1, C2104i> {
        public static final AnonymousClass5 INSTANCE = new AnonymousClass5();

        public AnonymousClass5() {
            super(2, C2104i.class, "<init>", "<init>(Landroid/view/View;Lcom/stepos/agentframework/chatui/IChatView;)V", 0);
        }

        @Override // p9.p
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public final C2104i invoke(View p02, U1 p12) {
            kotlin.jvm.internal.p.i(p02, "p0");
            kotlin.jvm.internal.p.i(p12, "p1");
            return new C2104i(p02, p12);
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatui.ChatMessageAdapter$6, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass6 extends FunctionReferenceImpl implements p9.p<View, U1, C2107l> {
        public static final AnonymousClass6 INSTANCE = new AnonymousClass6();

        public AnonymousClass6() {
            super(2, C2107l.class, "<init>", "<init>(Landroid/view/View;Lcom/stepos/agentframework/chatui/IChatView;)V", 0);
        }

        @Override // p9.p
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public final C2107l invoke(View p02, U1 p12) {
            kotlin.jvm.internal.p.i(p02, "p0");
            kotlin.jvm.internal.p.i(p12, "p1");
            return new C2107l(p02, p12);
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatui.ChatMessageAdapter$7, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass7 extends FunctionReferenceImpl implements p9.p<View, U1, com.stepos.agentframework.chatui.viewholder.P> {
        public static final AnonymousClass7 INSTANCE = new AnonymousClass7();

        public AnonymousClass7() {
            super(2, com.stepos.agentframework.chatui.viewholder.P.class, "<init>", "<init>(Landroid/view/View;Lcom/stepos/agentframework/chatui/IChatView;)V", 0);
        }

        @Override // p9.p
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public final com.stepos.agentframework.chatui.viewholder.P invoke(View p02, U1 p12) {
            kotlin.jvm.internal.p.i(p02, "p0");
            kotlin.jvm.internal.p.i(p12, "p1");
            return new com.stepos.agentframework.chatui.viewholder.P(p02, p12);
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatui.ChatMessageAdapter$8, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass8 extends FunctionReferenceImpl implements p9.p<View, U1, com.stepos.agentframework.chatui.viewholder.I> {
        public static final AnonymousClass8 INSTANCE = new AnonymousClass8();

        public AnonymousClass8() {
            super(2, com.stepos.agentframework.chatui.viewholder.I.class, "<init>", "<init>(Landroid/view/View;Lcom/stepos/agentframework/chatui/IChatView;)V", 0);
        }

        @Override // p9.p
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public final com.stepos.agentframework.chatui.viewholder.I invoke(View p02, U1 p12) {
            kotlin.jvm.internal.p.i(p02, "p0");
            kotlin.jvm.internal.p.i(p12, "p1");
            return new com.stepos.agentframework.chatui.viewholder.I(p02, p12);
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatui.ChatMessageAdapter$9, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass9 extends FunctionReferenceImpl implements p9.p<View, U1, com.stepos.agentframework.chatui.viewholder.S> {
        public static final AnonymousClass9 INSTANCE = new AnonymousClass9();

        public AnonymousClass9() {
            super(2, com.stepos.agentframework.chatui.viewholder.S.class, "<init>", "<init>(Landroid/view/View;Lcom/stepos/agentframework/chatui/IChatView;)V", 0);
        }

        @Override // p9.p
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public final com.stepos.agentframework.chatui.viewholder.S invoke(View p02, U1 p12) {
            kotlin.jvm.internal.p.i(p02, "p0");
            kotlin.jvm.internal.p.i(p12, "p1");
            return new com.stepos.agentframework.chatui.viewholder.S(p02, p12);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\rR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0017\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/stepos/agentframework/chatui/ChatMessageAdapter$b;", "", "Lz4/e;", "key", "", "displayOffset", "pixelOffset", "<init>", "(Lz4/e;II)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lz4/e;", Const.INTENT_KEY_PKGNAME, "()Lz4/e;", "I", Const.INTENT_KEY_APIKEY, "c", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatui.ChatMessageAdapter$b, reason: from toString */
    public static final /* data */ class PendingTextViewport {
        private final int displayOffset;
        private final LongTextKey key;
        private final int pixelOffset;

        public PendingTextViewport(LongTextKey key, int i10, int i11) {
            kotlin.jvm.internal.p.i(key, "key");
            this.key = key;
            this.displayOffset = i10;
            this.pixelOffset = i11;
        }

        /* renamed from: a, reason: from getter */
        public final int getDisplayOffset() {
            return this.displayOffset;
        }

        /* renamed from: b, reason: from getter */
        public final LongTextKey getKey() {
            return this.key;
        }

        /* renamed from: c, reason: from getter */
        public final int getPixelOffset() {
            return this.pixelOffset;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PendingTextViewport)) {
                return false;
            }
            PendingTextViewport pendingTextViewport = (PendingTextViewport) other;
            return kotlin.jvm.internal.p.d(this.key, pendingTextViewport.key) && this.displayOffset == pendingTextViewport.displayOffset && this.pixelOffset == pendingTextViewport.pixelOffset;
        }

        public int hashCode() {
            return (((this.key.hashCode() * 31) + Integer.hashCode(this.displayOffset)) * 31) + Integer.hashCode(this.pixelOffset);
        }

        public String toString() {
            return "PendingTextViewport(key=" + this.key + ", displayOffset=" + this.displayOffset + ", pixelOffset=" + this.pixelOffset + ")";
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010$\u001a\u00020#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R#\u0010-\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020,0*8\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100¨\u00061"}, d2 = {"Lcom/stepos/agentframework/chatui/ChatMessageAdapter$c;", "", "Lz4/c;", "candidate", "", "id", "<init>", "(Lz4/c;J)V", "Lz4/c;", Const.INTENT_KEY_APIKEY, "()Lz4/c;", "J", "e", "()J", "", "finished", "Z", Const.INTENT_KEY_UMID, "()Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Z)V", "Lcom/stepos/agentframework/chatui/longtext/LongTextDocument;", "document", "Lcom/stepos/agentframework/chatui/longtext/LongTextDocument;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/agentframework/chatui/longtext/LongTextDocument;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lcom/stepos/agentframework/chatui/longtext/LongTextDocument;)V", "Lkotlinx/coroutines/g;", "job", "Lkotlinx/coroutines/g;", "f", "()Lkotlinx/coroutines/g;", "k", "(Lkotlinx/coroutines/g;)V", "", "fallbackReason", "Ljava/lang/String;", "c", "()Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/String;)V", "", "", "Lz4/h;", "tableScrollStates", "Ljava/util/Map;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Ljava/util/Map;", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c {
        private final LongTextCandidate candidate;
        private LongTextDocument document;
        private String fallbackReason;
        private boolean finished;
        private final long id;
        private kotlinx.coroutines.g job;
        private final Map<Integer, z4.h> tableScrollStates;

        public c(LongTextCandidate candidate, long j10) {
            kotlin.jvm.internal.p.i(candidate, "candidate");
            this.candidate = candidate;
            this.id = j10;
            this.fallbackReason = ModelFlowMeta.PLAN_NONE;
            this.tableScrollStates = new LinkedHashMap();
        }

        /* renamed from: a, reason: from getter */
        public final LongTextCandidate getCandidate() {
            return this.candidate;
        }

        /* renamed from: b, reason: from getter */
        public final LongTextDocument getDocument() {
            return this.document;
        }

        /* renamed from: c, reason: from getter */
        public final String getFallbackReason() {
            return this.fallbackReason;
        }

        /* renamed from: d, reason: from getter */
        public final boolean getFinished() {
            return this.finished;
        }

        /* renamed from: e, reason: from getter */
        public final long getId() {
            return this.id;
        }

        /* renamed from: f, reason: from getter */
        public final kotlinx.coroutines.g getJob() {
            return this.job;
        }

        public final Map<Integer, z4.h> g() {
            return this.tableScrollStates;
        }

        public final void h(LongTextDocument longTextDocument) {
            this.document = longTextDocument;
        }

        public final void i(String str) {
            kotlin.jvm.internal.p.i(str, "<set-?>");
            this.fallbackReason = str;
        }

        public final void j(boolean z10) {
            this.finished = z10;
        }

        public final void k(kotlinx.coroutines.g gVar) {
            this.job = gVar;
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class d {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ChatRenderRow.Kind.values().length];
            try {
                iArr[ChatRenderRow.Kind.MESSAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ChatRenderRow.Kind.HEADER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ChatRenderRow.Kind.ATTACHMENTS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ChatRenderRow.Kind.BLOCK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ChatRenderRow.Kind.PREPARING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ChatRenderRow.Kind.SLICE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class e implements InterfaceC5074l<Throwable, Y8.t> {
        final /* synthetic */ f $listener;
        final /* synthetic */ RecyclerView $rv;

        public e(RecyclerView recyclerView, f fVar) {
            this.$rv = recyclerView;
            this.$listener = fVar;
        }

        public final void a(Throwable th) {
            this.$rv.removeOnScrollListener(this.$listener);
        }

        @Override // p9.InterfaceC5074l
        public /* bridge */ /* synthetic */ Y8.t invoke(Throwable th) {
            a(th);
            return Y8.t.f7040a;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/agentframework/chatui/ChatMessageAdapter$f", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "LY8/t;", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class f extends RecyclerView.OnScrollListener {
        final /* synthetic */ InterfaceC1066l<Y8.t> $continuation;
        final /* synthetic */ RecyclerView $rv;

        /* JADX WARN: Multi-variable type inference failed */
        public f(RecyclerView recyclerView, InterfaceC1066l<? super Y8.t> interfaceC1066l) {
            this.$rv = recyclerView;
            this.$continuation = interfaceC1066l;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            kotlin.jvm.internal.p.i(recyclerView, "recyclerView");
            if (newState == 0) {
                this.$rv.removeOnScrollListener(this);
                if (this.$continuation.b()) {
                    InterfaceC1066l<Y8.t> interfaceC1066l = this.$continuation;
                    Result.Companion companion = Result.INSTANCE;
                    interfaceC1066l.resumeWith(Result.b(Y8.t.f7040a));
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\nJ!\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"com/stepos/agentframework/chatui/ChatMessageAdapter$g", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "", "getOldListSize", "()I", "getNewListSize", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "", "areItemsTheSame", "(II)Z", "areContentsTheSame", "", "getChangePayload", "(II)Ljava/lang/Object;", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class g extends DiffUtil.Callback {
        final /* synthetic */ int $changedIndex;
        final /* synthetic */ List<ChatRenderRow> $next;
        final /* synthetic */ List<ChatRenderRow> $old;
        final /* synthetic */ Object $payload;

        public g(List<ChatRenderRow> list, List<ChatRenderRow> list2, int i10, Object obj) {
            this.$old = list;
            this.$next = list2;
            this.$changedIndex = i10;
            this.$payload = obj;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areContentsTheSame(int a10, int b10) {
            return this.$next.get(b10).getLogicalIndex() != this.$changedIndex && this.$old.get(a10).getItem() == this.$next.get(b10).getItem() && this.$old.get(a10).getDocument() == this.$next.get(b10).getDocument() && kotlin.jvm.internal.p.d(this.$old.get(a10).getSliceMarkdown(), this.$next.get(b10).getSliceMarkdown());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areItemsTheSame(int a10, int b10) {
            return this.$old.get(a10).l(this.$next.get(b10));
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public Object getChangePayload(int a10, int b10) {
            return this.$payload;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getNewListSize() {
            return this.$next.size();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getOldListSize() {
            return this.$old.size();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"com/stepos/agentframework/chatui/ChatMessageAdapter$h", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "view", "LY8/t;", "onViewDetachedFromWindow", "(Landroid/view/View;)V", "onViewAttachedToWindow", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class h implements View.OnAttachStateChangeListener {
        public h() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            kotlin.jvm.internal.p.i(view, "view");
            if (!kotlinx.coroutines.d.h(ChatMessageAdapter.this.preparationScope)) {
                ChatMessageAdapter.this.preparationScope = kotlinx.coroutines.d.a(Ua.L0.b(null, 1, null).plus(Ua.Y.c().getImmediate()));
            }
            RecyclerView recyclerView = (RecyclerView) view;
            int childCount = recyclerView.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                ChatRenderRow chatRenderRowG0 = ChatMessageAdapter.this.G0(recyclerView.getChildAdapterPosition(recyclerView.getChildAt(i10)));
                if (chatRenderRowG0 != null) {
                    if (chatRenderRowG0.getKind() != ChatRenderRow.Kind.PREPARING) {
                        chatRenderRowG0 = null;
                    }
                    if (chatRenderRowG0 != null) {
                        ChatMessageAdapter.this.l0(chatRenderRowG0);
                    }
                }
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            kotlin.jvm.internal.p.i(view, "view");
            kotlinx.coroutines.d.e(ChatMessageAdapter.this.preparationScope, null, 1, null);
            Iterator it = ChatMessageAdapter.this.preparations.values().iterator();
            while (it.hasNext()) {
                ((c) it.next()).k(null);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/agentframework/chatui/ChatMessageAdapter$i", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "LY8/t;", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class i extends RecyclerView.OnScrollListener {
        public i() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            kotlin.jvm.internal.p.i(recyclerView, "recyclerView");
            if (newState == 1) {
                ChatMessageAdapter.this.A();
            }
        }
    }

    public ChatMessageAdapter(U1 chatView) {
        kotlin.jvm.internal.p.i(chatView, "chatView");
        this.chatView = chatView;
        this.TAG = TAG;
        this.itemList = new ArrayList();
        this.renderRows = C1173v.m();
        this.diagnosticAdapterId = Integer.toHexString(System.identityHashCode(this));
        this.bindLogLimiter = new C6360f(0, 0L, 3, null);
        this.preparations = new LinkedHashMap();
        this.projectionDisabledReason = ModelFlowMeta.PLAN_NONE;
        this.longTextProjectionEnabled = true;
        this.preparationScope = kotlinx.coroutines.d.a(Ua.L0.b(null, 1, null).plus(Ua.Y.c().getImmediate()));
        this.viewportScrollListener = new i();
        this.viewportAttachListener = new h();
        this.viewTypeLayoutMap = new LinkedHashMap();
        this.viewHolderCreatorMap = new LinkedHashMap();
        this.onDataEmptyStateChanged = new InterfaceC5074l() { // from class: com.stepos.agentframework.chatui.C1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ChatMessageAdapter.j0(((Boolean) obj).booleanValue());
            }
        };
        s0(0, R$layout.item_message_receive, AnonymousClass1.INSTANCE);
        s0(1, R$layout.item_message_sent, AnonymousClass2.INSTANCE);
        s0(2, R$layout.item_sent_image, AnonymousClass3.INSTANCE);
        s0(3, R$layout.item_sent_file, AnonymousClass4.INSTANCE);
        s0(4, R$layout.item_action_footer, AnonymousClass5.INSTANCE);
        s0(5, R$layout.item_message_loading_bubble, AnonymousClass6.INSTANCE);
        s0(6, R$layout.item_message_thinking_bubble, AnonymousClass7.INSTANCE);
        s0(7, R$layout.item_message_reconnect_prompt, AnonymousClass8.INSTANCE);
        s0(8, R$layout.item_message_top_notice, AnonymousClass9.INSTANCE);
    }

    public static /* synthetic */ void L(ChatMessageAdapter chatMessageAdapter, ReconnectReason reconnectReason, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            reconnectReason = null;
        }
        chatMessageAdapter.K(reconnectReason);
    }

    public static final void R0(ChatMessageAdapter chatMessageAdapter, RecyclerView recyclerView, String str, SendState sendState) {
        if (chatMessageAdapter.attachedRecyclerView == recyclerView) {
            chatMessageAdapter.u(recyclerView, str, sendState);
        }
    }

    public static /* synthetic */ int X(ChatMessageAdapter chatMessageAdapter, String str, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = -1;
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return chatMessageAdapter.W(str, i10, z10);
    }

    public static /* synthetic */ void a0(ChatMessageAdapter chatMessageAdapter, int i10, Object obj, int i11, Object obj2) {
        if ((i11 & 2) != 0) {
            obj = null;
        }
        chatMessageAdapter.Z(i10, obj);
    }

    public static final void f0(ChatMessageAdapter chatMessageAdapter, RecyclerView recyclerView) {
        chatMessageAdapter.k0(recyclerView);
    }

    public static final Y8.t j0(boolean z10) {
        return Y8.t.f7040a;
    }

    public static final Y8.t m0(ChatMessageAdapter chatMessageAdapter, LongTextKey longTextKey, c cVar, Throwable th) {
        if (th instanceof CancellationException) {
            C4148a.d(chatMessageAdapter.TAG, "long text prepare cancelled adapter=" + chatMessageAdapter.diagnosticAdapterId + " sessionId=" + longTextKey.getSessionId() + " messageId=" + longTextKey.getMessageId() + " preparationId=" + cVar.getId(), false, 4, null);
        }
        return Y8.t.f7040a;
    }

    public static /* synthetic */ void o0(ChatMessageAdapter chatMessageAdapter, int i10, Object obj, int i11, Object obj2) {
        if ((i11 & 1) != 0) {
            i10 = -1;
        }
        if ((i11 & 2) != 0) {
            obj = null;
        }
        chatMessageAdapter.n0(i10, obj);
    }

    public static /* synthetic */ int y0(ChatMessageAdapter chatMessageAdapter, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        return chatMessageAdapter.x0(i10, z10);
    }

    public final void A() {
        this.pendingTextViewport = null;
    }

    public final void A0(String messageId) {
        kotlin.jvm.internal.p.i(messageId, "messageId");
        if (messageId.length() == 0) {
            B0();
            return;
        }
        Iterator<S1> it = this.itemList.iterator();
        int i10 = 0;
        while (true) {
            if (!it.hasNext()) {
                i10 = -1;
                break;
            }
            S1 next = it.next();
            if ((next instanceof DisplayMessage) && kotlin.jvm.internal.p.d(((DisplayMessage) next).getMessageId(), messageId)) {
                break;
            } else {
                i10++;
            }
        }
        if (i10 == -1) {
            B0();
        } else {
            z0(i10);
        }
    }

    public final void B() {
        Iterator<S1> it = this.itemList.iterator();
        int i10 = 0;
        while (true) {
            if (!it.hasNext()) {
                i10 = -1;
                break;
            }
            S1 next = it.next();
            if (next instanceof DisplayMessage) {
                DisplayMessage displayMessage = (DisplayMessage) next;
                if (displayMessage.getRole() == AgentRole.ASSISTANT && displayMessage.getStatus() != EReplyStatus.COMPLETED && displayMessage.getStatus() != EReplyStatus.ERROR) {
                    break;
                }
            }
            i10++;
        }
        if (i10 == -1) {
            Iterator<S1> it2 = this.itemList.iterator();
            i10 = 0;
            while (true) {
                if (!it2.hasNext()) {
                    i10 = -1;
                    break;
                }
                S1 next2 = it2.next();
                if ((next2 instanceof DisplayMessage) && ((DisplayMessage) next2).getRole() == AgentRole.ASSISTANT) {
                    break;
                } else {
                    i10++;
                }
            }
        }
        C4148a.k(this.TAG, "collapseDeepThinkingOfStreamingMessage: index=" + i10 + ", itemCount=" + this.itemList.size(), false, 4, null);
        if (i10 != -1) {
            Z(i10, PAYLOAD_COLLAPSE_COT);
        }
    }

    public final void B0() {
        int iNextIndex;
        List<S1> list = this.itemList;
        ListIterator<S1> listIterator = list.listIterator(list.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                iNextIndex = -1;
                break;
            }
            S1 s1Previous = listIterator.previous();
            if ((s1Previous instanceof DisplayMessage) && ((DisplayMessage) s1Previous).getRole() == AgentRole.ASSISTANT) {
                iNextIndex = listIterator.nextIndex();
                break;
            }
        }
        if (iNextIndex == -1) {
            return;
        }
        z0(iNextIndex);
    }

    public final void C() {
        boolean zIsEmpty = this.itemList.isEmpty();
        if (this.isEmptyState != zIsEmpty) {
            this.isEmptyState = zIsEmpty;
            this.onDataEmptyStateChanged.invoke(Boolean.valueOf(zIsEmpty));
        }
    }

    public final void C0(DisplayMessage message, String oldMessageId) {
        kotlin.jvm.internal.p.i(message, "message");
        kotlin.jvm.internal.p.i(oldMessageId, "oldMessageId");
        Iterator<S1> it = this.itemList.iterator();
        int i10 = 0;
        while (true) {
            if (!it.hasNext()) {
                i10 = -1;
                break;
            }
            S1 next = it.next();
            if (next.b()) {
                kotlin.jvm.internal.p.g(next, "null cannot be cast to non-null type com.stepos.agentframework.chatui.DisplayMessage");
                if (kotlin.jvm.internal.p.d(((DisplayMessage) next).getMessageId(), oldMessageId)) {
                    break;
                }
            }
            i10++;
        }
        if (i10 == -1) {
            s(message);
            return;
        }
        if (!kotlin.jvm.internal.p.d(message.getMessageId(), oldMessageId)) {
            List<S1> list = this.itemList;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                for (S1 s12 : list) {
                    if (s12.b()) {
                        kotlin.jvm.internal.p.g(s12, "null cannot be cast to non-null type com.stepos.agentframework.chatui.DisplayMessage");
                        if (kotlin.jvm.internal.p.d(((DisplayMessage) s12).getMessageId(), message.getMessageId())) {
                            C4148a.k(this.TAG, "replaceMessage skip: newId=" + message.getMessageId() + " already in list, remove placeholder=" + oldMessageId, false, 4, null);
                            this.itemList.remove(i10);
                            e0(i10);
                            q0();
                            return;
                        }
                    }
                }
            }
        }
        S1 s13 = this.itemList.get(i10);
        DisplayMessage displayMessage = s13 instanceof DisplayMessage ? (DisplayMessage) s13 : null;
        O(message, displayMessage);
        if (displayMessage != null && kotlin.jvm.internal.p.d(oldMessageId, message.getMessageId()) && kotlin.jvm.internal.p.d(message, displayMessage)) {
            return;
        }
        this.itemList.set(i10, message);
        Z(i10, PAYLOAD_REPLACE_MESSAGE);
        q0();
        v0(message.getMessageId(), i10);
    }

    public final void D() {
        try {
            InterfaceC5063a<Y8.t> interfaceC5063a = this.onViewBound;
            if (interfaceC5063a != null) {
                interfaceC5063a.invoke();
            }
        } finally {
            InterfaceC5063a<Y8.t> interfaceC5063a2 = this.onViewBoundForScroll;
            if (interfaceC5063a2 != null) {
                interfaceC5063a2.invoke();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void D0(com.stepos.agentframework.chatui.longtext.ChatRenderRow r30, int r31, com.stepos.agentframework.chatui.viewholder.AbstractC2106k r32, java.lang.String r33, long r34, boolean r36) {
        /*
            Method dump skipped, instructions count: 811
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatui.ChatMessageAdapter.D0(com.stepos.agentframework.chatui.longtext.ChatRenderRow, int, com.stepos.agentframework.chatui.viewholder.k, java.lang.String, long, boolean):void");
    }

    public final int E(int position) {
        ChatRenderRow chatRenderRowG0 = G0(position);
        if (chatRenderRowG0 != null) {
            return chatRenderRowG0.d();
        }
        return -1;
    }

    public final void E0() {
        this.renderRows = z();
        notifyDataSetChanged();
    }

    /* renamed from: F, reason: from getter */
    public final U1 getChatView() {
        return this.chatView;
    }

    public final boolean F0(String messageId, int displayOffset, int pixelOffset) {
        RecyclerView recyclerView;
        kotlin.jvm.internal.p.i(messageId, "messageId");
        int iX = X(this, messageId, displayOffset, false, 4, null);
        ChatRenderRow chatRenderRowG0 = G0(iX);
        if (chatRenderRowG0 == null || (recyclerView = this.attachedRecyclerView) == null) {
            return false;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (linearLayoutManager == null) {
            return false;
        }
        if (chatRenderRowG0.getKind() == ChatRenderRow.Kind.PREPARING) {
            S1 s1F = chatRenderRowG0.getItem();
            kotlin.jvm.internal.p.g(s1F, "null cannot be cast to non-null type com.stepos.agentframework.chatui.DisplayMessage");
            DisplayMessage displayMessage = (DisplayMessage) s1F;
            this.pendingTextViewport = new PendingTextViewport(new LongTextKey(displayMessage.getSessionId(), displayMessage.getMessageId()), displayOffset, pixelOffset);
            l0(chatRenderRowG0);
        }
        linearLayoutManager.scrollToPositionWithOffset(iX, pixelOffset);
        return true;
    }

    public final List<S1> G() {
        return this.itemList;
    }

    public final ChatRenderRow G0(int position) {
        return (ChatRenderRow) Z8.F.t0(this.renderRows, position);
    }

    public final boolean H() {
        return Z8.F.s0(this.itemList) instanceof C1978a;
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void H0(List<DisplayMessage> messages) {
        kotlin.jvm.internal.p.i(messages, "messages");
        this.itemList.clear();
        List<S1> list = this.itemList;
        List<DisplayMessage> list2 = messages;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list2) {
            DisplayMessage displayMessage = (DisplayMessage) obj;
            if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    if (displayMessage.I((DisplayMessage) it.next())) {
                        break;
                    }
                }
            }
            arrayList.add(obj);
        }
        list.addAll(arrayList);
        P0(false);
        E0();
        C();
    }

    public final boolean I(List<DisplayMessage> messages) {
        kotlin.jvm.internal.p.i(messages, "messages");
        return j2.INSTANCE.b(this.itemList, messages);
    }

    public final void I0(InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l) {
        kotlin.jvm.internal.p.i(interfaceC5074l, "<set-?>");
        this.onDataEmptyStateChanged = interfaceC5074l;
    }

    public final void J() {
        int iU = U();
        C4148a.k(this.TAG, "hideLoadingBubble: index=" + iU + ", itemCount=" + this.itemList.size(), false, 4, null);
        if (iU != -1) {
            this.itemList.remove(iU);
            e0(iU);
            q0();
            C();
        }
    }

    public final void J0(InterfaceC5063a<Y8.t> interfaceC5063a) {
        this.onViewBound = interfaceC5063a;
    }

    public final void K(ReconnectReason reason) {
        int iP0;
        if (reason != null) {
            Iterator<S1> it = this.itemList.iterator();
            int i10 = 0;
            while (true) {
                if (!it.hasNext()) {
                    iP0 = -1;
                    break;
                }
                S1 next = it.next();
                if ((next instanceof k2) && ((k2) next).getReason() == reason) {
                    iP0 = i10;
                    break;
                }
                i10++;
            }
        } else {
            iP0 = p0();
        }
        if (iP0 == -1) {
            return;
        }
        C4148a.k(this.TAG, "hideReconnectPrompt: index=" + iP0 + " reason=" + reason + " itemCount=" + this.itemList.size(), false, 4, null);
        this.itemList.remove(iP0);
        e0(iP0);
        r0();
        q0();
        C();
    }

    public final void K0(InterfaceC5063a<Y8.t> interfaceC5063a) {
        this.onViewBoundForScroll = interfaceC5063a;
    }

    public final void L0(boolean z10) {
        this.suppressActionBarForTask = z10;
    }

    public final void M() {
        int iS0 = S0();
        C4148a.k(this.TAG, "hideThinkingBubble: index=" + iS0 + ", itemCount=" + this.itemList.size(), false, 4, null);
        if (iS0 != -1) {
            this.itemList.remove(iS0);
            e0(iS0);
            q0();
            C();
        }
    }

    public final void M0() {
        if (U() != -1) {
            C4148a.k(this.TAG, "showLoadingBubble skip: already showing, itemCount=" + this.itemList.size(), false, 4, null);
            return;
        }
        C4148a.k(this.TAG, "showLoadingBubble: insert at 0, itemCount=" + this.itemList.size(), false, 4, null);
        u0();
        this.itemList.add(0, new h2());
        b0(0);
        C();
    }

    public final void N() {
        int iT0 = T0();
        if (iT0 == -1) {
            return;
        }
        this.itemList.remove(iT0);
        e0(iT0);
        C();
    }

    public final void N0(ReconnectReason reason) {
        kotlin.jvm.internal.p.i(reason, "reason");
        int iP0 = p0();
        if (iP0 != -1) {
            S1 s12 = this.itemList.get(iP0);
            k2 k2Var = s12 instanceof k2 ? (k2) s12 : null;
            if ((k2Var != null ? k2Var.getReason() : null) == reason) {
                C4148a.k(this.TAG, "showReconnectPrompt skip: already showing, itemCount=" + this.itemList.size(), false, 4, null);
                t0();
                return;
            }
            C4148a.k(this.TAG, "showReconnectPrompt: retext reason=" + reason + " at index=" + iP0, false, 4, null);
            this.itemList.set(iP0, new k2(reason));
            a0(this, iP0, null, 2, null);
            t0();
            return;
        }
        C4148a.k(this.TAG, "showReconnectPrompt: insert at 0, reason=" + reason + " itemCount=" + this.itemList.size(), false, 4, null);
        u0();
        int iS0 = S0();
        if (iS0 != -1) {
            this.itemList.remove(iS0);
            e0(iS0);
        }
        int iU = U();
        if (iU != -1) {
            this.itemList.remove(iU);
            e0(iU);
        }
        this.itemList.add(0, new k2(reason));
        b0(0);
        r0();
        t0();
        C();
    }

    public final void O(DisplayMessage incoming, DisplayMessage existing) {
        DisplayTool p12;
        AppUIData appUIDataC;
        if (existing == null) {
            return;
        }
        List<DisplayChatMessage> listM = existing.m();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = listM.iterator();
        while (it.hasNext()) {
            List<DisplayTool> listF = ((DisplayChatMessage) it.next()).f();
            if (listF == null) {
                listF = C1173v.m();
            }
            Z8.A.E(arrayList, listF);
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            DisplayTool p13 = (DisplayTool) obj;
            if (p13.getAppUIData() != null && p13.getToolCallId().length() > 0) {
                arrayList2.add(obj);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(C5685n.f(Z8.Q.e(C1174w.x(arrayList2, 10)), 16));
        for (Object obj2 : arrayList2) {
            linkedHashMap.put(((DisplayTool) obj2).getToolCallId(), obj2);
        }
        if (linkedHashMap.isEmpty()) {
            return;
        }
        Iterator<T> it2 = incoming.m().iterator();
        while (it2.hasNext()) {
            List<DisplayTool> listF2 = ((DisplayChatMessage) it2.next()).f();
            if (listF2 != null) {
                for (DisplayTool p14 : listF2) {
                    if (p14.getAppUIData() == null && (p12 = (DisplayTool) linkedHashMap.get(p14.getToolCallId())) != null && (appUIDataC = p12.getAppUIData()) != null) {
                        p14.n(appUIDataC);
                    }
                }
            }
        }
    }

    public final void O0(String hint, String action) {
        kotlin.jvm.internal.p.i(hint, "hint");
        kotlin.jvm.internal.p.i(action, "action");
        int iT0 = T0();
        if (iT0 == -1) {
            int size = this.itemList.size();
            this.itemList.add(size, new t2(hint, action));
            b0(size);
            C();
            return;
        }
        S1 s12 = this.itemList.get(iT0);
        kotlin.jvm.internal.p.g(s12, "null cannot be cast to non-null type com.stepos.agentframework.chatui.TopNoticeItem");
        t2 t2Var = (t2) s12;
        if (kotlin.jvm.internal.p.d(t2Var.getHint(), hint) && kotlin.jvm.internal.p.d(t2Var.getAction(), action)) {
            return;
        }
        t2Var.f(hint);
        t2Var.e(action);
        a0(this, iT0, null, 2, null);
    }

    public final int P(DisplayMessage message) {
        int iY = y();
        if (message.getRole() != AgentRole.ASSISTANT || message.getPairId().length() == 0) {
            return iY;
        }
        Iterator<S1> it = this.itemList.iterator();
        int i10 = 0;
        while (true) {
            if (!it.hasNext()) {
                i10 = -1;
                break;
            }
            S1 next = it.next();
            if (next.b()) {
                kotlin.jvm.internal.p.g(next, "null cannot be cast to non-null type com.stepos.agentframework.chatui.DisplayMessage");
                if (kotlin.jvm.internal.p.d(((DisplayMessage) next).getPairId(), message.getPairId())) {
                    break;
                }
            }
            i10++;
        }
        if (i10 != -1) {
            return Math.max(iY, i10);
        }
        return iY;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void P0(boolean r6) {
        /*
            r5 = this;
            java.util.List<com.stepos.agentframework.chatui.S1> r0 = r5.itemList
            int r1 = r5.T()
            java.lang.Object r0 = Z8.F.t0(r0, r1)
            boolean r1 = r0 instanceof com.stepos.agentframework.chatui.DisplayMessage
            r2 = 0
            if (r1 == 0) goto L12
            com.stepos.agentframework.chatui.N1 r0 = (com.stepos.agentframework.chatui.DisplayMessage) r0
            goto L13
        L12:
            r0 = r2
        L13:
            r1 = 0
            if (r0 == 0) goto L4a
            com.stepos.agentframework.chatcore.session.AgentRole r3 = r0.getRole()
            com.stepos.agentframework.chatcore.session.AgentRole r4 = com.stepos.agentframework.chatcore.session.AgentRole.ASSISTANT
            if (r3 != r4) goto L4a
            com.stepos.agentframework.chatcore.session.EReplyStatus r3 = r0.getStatus()
            com.stepos.agentframework.chatcore.session.EReplyStatus r4 = com.stepos.agentframework.chatcore.session.EReplyStatus.COMPLETED
            if (r3 != r4) goto L4a
            boolean r3 = r0.getNeedActionBarShow()
            if (r3 == 0) goto L4a
            boolean r3 = r5.suppressActionBarForTask
            if (r3 != 0) goto L4a
            boolean r3 = r0.H()
            if (r3 != 0) goto L4a
            boolean r3 = r0.O()
            if (r3 != 0) goto L4a
            com.stepos.agentframework.AgentUIConfig r3 = r5.agentUiConfig
            r4 = 1
            if (r3 == 0) goto L46
            boolean r3 = r3.getWithActionLayout()
            goto L47
        L46:
            r3 = r4
        L47:
            if (r3 == 0) goto L4a
            goto L4b
        L4a:
            r4 = r1
        L4b:
            if (r4 == 0) goto La5
            java.util.List<com.stepos.agentframework.chatui.S1> r3 = r5.itemList
            java.lang.Object r3 = Z8.F.s0(r3)
            boolean r4 = r3 instanceof com.stepos.agentframework.chatui.C1978a
            if (r4 == 0) goto L5a
            com.stepos.agentframework.chatui.a r3 = (com.stepos.agentframework.chatui.C1978a) r3
            goto L5b
        L5a:
            r3 = r2
        L5b:
            if (r3 == 0) goto L7e
            kotlin.jvm.internal.p.f(r0)
            r3.d(r0)
            if (r6 == 0) goto Lc9
            androidx.recyclerview.widget.RecyclerView r6 = r5.attachedRecyclerView
            if (r6 == 0) goto L6e
            androidx.recyclerview.widget.RecyclerView$ItemAnimator r0 = r6.getItemAnimator()
            goto L6f
        L6e:
            r0 = r2
        L6f:
            if (r6 == 0) goto L74
            r6.setItemAnimator(r2)
        L74:
            r3 = 2
            a0(r5, r1, r2, r3, r2)
            if (r6 == 0) goto Lc9
            r6.setItemAnimator(r0)
            return
        L7e:
            java.util.List<com.stepos.agentframework.chatui.S1> r3 = r5.itemList
            com.stepos.agentframework.chatui.a r4 = new com.stepos.agentframework.chatui.a
            kotlin.jvm.internal.p.f(r0)
            r4.<init>(r0)
            r3.add(r1, r4)
            if (r6 == 0) goto Lc9
            androidx.recyclerview.widget.RecyclerView r6 = r5.attachedRecyclerView
            if (r6 == 0) goto L96
            androidx.recyclerview.widget.RecyclerView$ItemAnimator r0 = r6.getItemAnimator()
            goto L97
        L96:
            r0 = r2
        L97:
            if (r6 == 0) goto L9c
            r6.setItemAnimator(r2)
        L9c:
            r5.b0(r1)
            if (r6 == 0) goto Lc9
            r6.setItemAnimator(r0)
            return
        La5:
            boolean r0 = r5.H()
            if (r0 == 0) goto Lc9
            java.util.List<com.stepos.agentframework.chatui.S1> r0 = r5.itemList
            r0.remove(r1)
            if (r6 == 0) goto Lc9
            androidx.recyclerview.widget.RecyclerView r6 = r5.attachedRecyclerView
            if (r6 == 0) goto Lbb
            androidx.recyclerview.widget.RecyclerView$ItemAnimator r0 = r6.getItemAnimator()
            goto Lbc
        Lbb:
            r0 = r2
        Lbc:
            if (r6 == 0) goto Lc1
            r6.setItemAnimator(r2)
        Lc1:
            r5.e0(r1)
            if (r6 == 0) goto Lc9
            r6.setItemAnimator(r0)
        Lc9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatui.ChatMessageAdapter.P0(boolean):void");
    }

    public final boolean Q(int position) {
        ChatRenderRow chatRenderRowG0 = G0(position);
        return (chatRenderRowG0 != null ? chatRenderRowG0.getKind() : null) == ChatRenderRow.Kind.PREPARING;
    }

    public final void Q0(final String messageId, final SendState state) {
        final RecyclerView recyclerView = this.attachedRecyclerView;
        if (recyclerView == null) {
            return;
        }
        u(recyclerView, messageId, state);
        recyclerView.post(new Runnable() { // from class: com.stepos.agentframework.chatui.D1
            @Override // java.lang.Runnable
            public final void run() {
                ChatMessageAdapter.R0(this.f22777a, recyclerView, messageId, state);
            }
        });
    }

    public final boolean R() {
        return p0() != -1;
    }

    public final S1 S(int position) {
        ChatRenderRow chatRenderRowG0 = G0(position);
        if (chatRenderRowG0 != null) {
            return chatRenderRowG0.getItem();
        }
        return null;
    }

    public final int S0() {
        Iterator<S1> it = this.itemList.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            if (it.next() instanceof q2) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public final int T() {
        return H() ? 1 : 0;
    }

    public final int T0() {
        Iterator<S1> it = this.itemList.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            if (it.next() instanceof t2) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public final int U() {
        Iterator<S1> it = this.itemList.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            if (it.next() instanceof h2) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public final void U0(String messageId, int likeStatus) {
        kotlin.jvm.internal.p.i(messageId, "messageId");
        Iterator<S1> it = this.itemList.iterator();
        int i10 = 0;
        while (true) {
            if (!it.hasNext()) {
                i10 = -1;
                break;
            }
            S1 next = it.next();
            if (next.b()) {
                kotlin.jvm.internal.p.g(next, "null cannot be cast to non-null type com.stepos.agentframework.chatui.DisplayMessage");
                if (kotlin.jvm.internal.p.d(((DisplayMessage) next).getMessageId(), messageId)) {
                    break;
                }
            }
            i10++;
        }
        if (i10 != -1) {
            S1 s12 = this.itemList.get(i10);
            kotlin.jvm.internal.p.g(s12, "null cannot be cast to non-null type com.stepos.agentframework.chatui.DisplayMessage");
            ((DisplayMessage) s12).W(likeStatus);
            Z(i10, PAYLOAD_UPDATE_LIKE);
        }
        Object objS0 = Z8.F.s0(this.itemList);
        C1978a c1978a = objS0 instanceof C1978a ? (C1978a) objS0 : null;
        if (c1978a == null || !kotlin.jvm.internal.p.d(c1978a.getTarget().getMessageId(), messageId)) {
            return;
        }
        c1978a.getTarget().W(likeStatus);
        Z(0, PAYLOAD_UPDATE_LIKE);
    }

    public final int V(int position) {
        ChatRenderRow chatRenderRowG0 = G0(position);
        if (chatRenderRowG0 != null) {
            return chatRenderRowG0.getLogicalIndex();
        }
        return -1;
    }

    public final void V0(String messageId, SendState state) {
        kotlin.jvm.internal.p.i(messageId, "messageId");
        kotlin.jvm.internal.p.i(state, "state");
        if (messageId.length() == 0) {
            return;
        }
        Iterator<S1> it = this.itemList.iterator();
        int i10 = 0;
        while (true) {
            if (!it.hasNext()) {
                i10 = -1;
                break;
            }
            S1 next = it.next();
            if (next.b()) {
                kotlin.jvm.internal.p.g(next, "null cannot be cast to non-null type com.stepos.agentframework.chatui.DisplayMessage");
                if (kotlin.jvm.internal.p.d(((DisplayMessage) next).getMessageId(), messageId)) {
                    break;
                }
            }
            i10++;
        }
        if (i10 == -1) {
            C4148a.u(this.TAG, "updateSendState miss messageId=" + messageId + " target=" + state + " itemCount=" + this.itemList.size(), false, 4, null);
            return;
        }
        S1 s12 = this.itemList.get(i10);
        kotlin.jvm.internal.p.g(s12, "null cannot be cast to non-null type com.stepos.agentframework.chatui.DisplayMessage");
        DisplayMessage displayMessage = (DisplayMessage) s12;
        if (displayMessage.getSendState() == state) {
            C4148a.d(this.TAG, "updateSendState unchanged messageId=" + messageId + " state=" + state + " index=" + i10, false, 4, null);
            Q0(messageId, state);
            return;
        }
        SendState sendState = displayMessage.getSendState();
        displayMessage.g0(state);
        C4148a.k(this.TAG, "updateSendState messageId=" + messageId + " " + sendState + "->" + state + " index=" + i10, false, 4, null);
        Q0(messageId, state);
        Z(i10, PAYLOAD_UPDATE_SEND_STATE);
    }

    public final int W(String messageId, int displayOffset, boolean atTop) {
        int i10;
        kotlin.jvm.internal.p.i(messageId, "messageId");
        Iterator<S1> it = this.itemList.iterator();
        int i11 = 0;
        while (true) {
            i10 = -1;
            if (!it.hasNext()) {
                i11 = -1;
                break;
            }
            S1 next = it.next();
            if ((next instanceof DisplayMessage) && kotlin.jvm.internal.p.d(((DisplayMessage) next).getMessageId(), messageId)) {
                break;
            }
            i11++;
        }
        if (i11 < 0) {
            return -1;
        }
        if (displayOffset >= 0) {
            Iterator<ChatRenderRow> it2 = this.renderRows.iterator();
            int i12 = 0;
            while (true) {
                if (!it2.hasNext()) {
                    i12 = -1;
                    break;
                }
                ChatRenderRow next2 = it2.next();
                if (next2.getLogicalIndex() == i11 && next2.getKind() == ChatRenderRow.Kind.BLOCK) {
                    LongTextDocument longTextDocumentE = next2.getDocument();
                    kotlin.jvm.internal.p.f(longTextDocumentE);
                    LongTextDocument.Block block = longTextDocumentE.a().get(next2.getBlockIndex());
                    int start = block.getStart();
                    if (displayOffset < block.getEnd() && start <= displayOffset) {
                        break;
                    }
                }
                i12++;
            }
            if (i12 >= 0) {
                return i12;
            }
            Iterator<ChatRenderRow> it3 = this.renderRows.iterator();
            int i13 = 0;
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                ChatRenderRow next3 = it3.next();
                if (next3.getLogicalIndex() == i11 && next3.getKind() == ChatRenderRow.Kind.SLICE && next3.getSliceIndex() == displayOffset) {
                    i10 = i13;
                    break;
                }
                i13++;
            }
            if (i10 >= 0) {
                return i10;
            }
        }
        return x0(i11, atTop || displayOffset == -2);
    }

    public final void Y(String messageId) {
        kotlin.jvm.internal.p.i(messageId, "messageId");
        u0();
        Iterator<S1> it = this.itemList.iterator();
        int i10 = 0;
        while (true) {
            if (!it.hasNext()) {
                i10 = -1;
                break;
            }
            S1 next = it.next();
            if (next.b()) {
                kotlin.jvm.internal.p.g(next, "null cannot be cast to non-null type com.stepos.agentframework.chatui.DisplayMessage");
                if (kotlin.jvm.internal.p.d(((DisplayMessage) next).getMessageId(), messageId)) {
                    break;
                }
            }
            i10++;
        }
        if (i10 == -1) {
            q0();
            return;
        }
        int iY = y();
        if (i10 != iY) {
            this.itemList.add(iY, this.itemList.remove(i10));
            c0(i10, iY);
        }
        q0();
    }

    public final void Z(int index, Object payload) {
        n0(index, payload);
    }

    public final void b0(int index) {
        o0(this, 0, null, 3, null);
    }

    public final void c0(int from, int to) {
        o0(this, 0, null, 3, null);
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void clear() {
        this.itemList.clear();
        E0();
        C();
    }

    public final void d0(int start, int count) {
        o0(this, 0, null, 3, null);
    }

    public final void e0(int index) {
        o0(this, 0, null, 3, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: g0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(AbstractC2106k holder, int position) {
        kotlin.jvm.internal.p.i(holder, "holder");
        ChatRenderRow chatRenderRow = this.renderRows.get(position);
        long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        Trace.beginSection("Chat.bindRow." + chatRenderRow.getKind());
        try {
            x(holder, position);
            D();
            Trace.endSection();
            D0(chatRenderRow, position, holder, ChatTracker.STAGE_FULL, (SystemClock.elapsedRealtimeNanos() - jElapsedRealtimeNanos) / 1000000, true);
        } catch (Throwable th) {
            Trace.endSection();
            D0(chatRenderRow, position, holder, ChatTracker.STAGE_FULL, (SystemClock.elapsedRealtimeNanos() - jElapsedRealtimeNanos) / 1000000, false);
            throw th;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.renderRows.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        List<LongTextDocument.Block> listA;
        ChatRenderRow chatRenderRow = this.renderRows.get(position);
        switch (d.$EnumSwitchMapping$0[chatRenderRow.getKind().ordinal()]) {
            case 1:
                return chatRenderRow.getItem().a();
            case 2:
                return 10;
            case 3:
                return 12;
            case 4:
            case 5:
                LongTextDocument longTextDocumentE = chatRenderRow.getDocument();
                LongTextDocument.Block block = (longTextDocumentE == null || (listA = longTextDocumentE.a()) == null) ? null : (LongTextDocument.Block) Z8.F.t0(listA, chatRenderRow.getBlockIndex());
                if ((block != null ? block.getTableRow() : null) != null) {
                    return 13;
                }
                return (block != null ? block.getCodeBlock() : null) != null ? 14 : 9;
            case 6:
                return 11;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: h0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(AbstractC2106k holder, int position, List<Object> payloads) {
        kotlin.jvm.internal.p.i(holder, "holder");
        kotlin.jvm.internal.p.i(payloads, "payloads");
        String str = payloads.isEmpty() ? ChatTracker.STAGE_FULL : "payload";
        ChatRenderRow chatRenderRow = this.renderRows.get(position);
        long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        Trace.beginSection("Chat.bindRow." + chatRenderRow.getKind());
        try {
            w(holder, position, payloads);
            Trace.endSection();
            D0(chatRenderRow, position, holder, str, (SystemClock.elapsedRealtimeNanos() - jElapsedRealtimeNanos) / 1000000, true);
        } catch (Throwable th) {
            Trace.endSection();
            D0(chatRenderRow, position, holder, str, (SystemClock.elapsedRealtimeNanos() - jElapsedRealtimeNanos) / 1000000, false);
            throw th;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public AbstractC2106k onCreateViewHolder(ViewGroup parent, int viewType) {
        kotlin.jvm.internal.p.i(parent, "parent");
        if (viewType == 9) {
            return new C2109n(parent, this.chatView);
        }
        if (viewType == 13) {
            return new com.stepos.agentframework.chatui.viewholder.r(parent, this.chatView);
        }
        if (viewType == 12) {
            return new C2108m(parent, this.chatView);
        }
        if (viewType == 10) {
            return com.stepos.agentframework.chatui.viewholder.F.INSTANCE.a(parent, this.chatView);
        }
        if (viewType == 11 || viewType == 14) {
            return new C2113s(parent, this.chatView);
        }
        Integer num = this.viewTypeLayoutMap.get(Integer.valueOf(viewType));
        if (num == null) {
            throw new IllegalArgumentException("未注册 ViewType: " + viewType);
        }
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(num.intValue(), parent, false);
        p9.p<View, U1, AbstractC2106k> pVar = this.viewHolderCreatorMap.get(Integer.valueOf(viewType));
        if (pVar != null) {
            kotlin.jvm.internal.p.f(viewInflate);
            AbstractC2106k abstractC2106kInvoke = pVar.invoke(viewInflate, this.chatView);
            if (abstractC2106kInvoke != null) {
                return abstractC2106kInvoke;
            }
        }
        throw new IllegalArgumentException("未注册 ViewHolder for ViewType: " + viewType);
    }

    public final void k0(RecyclerView recyclerView) {
        if (!this.actionFooterWarmed && recyclerView.getAdapter() == this && this.viewTypeLayoutMap.containsKey(4)) {
            this.actionFooterWarmed = true;
            recyclerView.getRecycledViewPool().putRecycledView(createViewHolder(recyclerView, 4));
        }
    }

    public final void l0(ChatRenderRow row) {
        S1 s1F = row.getItem();
        kotlin.jvm.internal.p.g(s1F, "null cannot be cast to non-null type com.stepos.agentframework.chatui.DisplayMessage");
        DisplayMessage displayMessage = (DisplayMessage) s1F;
        final LongTextKey longTextKey = new LongTextKey(displayMessage.getSessionId(), displayMessage.getMessageId());
        final c cVar = this.preparations.get(longTextKey);
        if (cVar == null || cVar.getFinished() || cVar.getJob() != null) {
            return;
        }
        kotlinx.coroutines.g gVarD = C1060i.d(this.preparationScope, null, null, new ChatMessageAdapter$prepareLongText$1(this, longTextKey, cVar, cVar.getCandidate(), null), 3, null);
        gVarD.J(new InterfaceC5074l() { // from class: com.stepos.agentframework.chatui.B1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ChatMessageAdapter.m0(this.f22764a, longTextKey, cVar, (Throwable) obj);
            }
        });
        cVar.k(gVarD);
    }

    public final void n0(int changedIndex, Object payload) {
        List<ChatRenderRow> list = this.renderRows;
        List<ChatRenderRow> listZ = z();
        DiffUtil.DiffResult diffResultCalculateDiff = DiffUtil.calculateDiff(new g(list, listZ, changedIndex, payload));
        kotlin.jvm.internal.p.h(diffResultCalculateDiff, "calculateDiff(...)");
        this.renderRows = listZ;
        diffResultCalculateDiff.dispatchUpdatesTo(this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(final RecyclerView recyclerView) {
        kotlin.jvm.internal.p.i(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        this.attachedRecyclerView = recyclerView;
        recyclerView.addOnAttachStateChangeListener(this.viewportAttachListener);
        recyclerView.addOnScrollListener(this.viewportScrollListener);
        if (!kotlinx.coroutines.d.h(this.preparationScope)) {
            this.preparationScope = kotlinx.coroutines.d.a(Ua.L0.b(null, 1, null).plus(Ua.Y.c().getImmediate()));
        }
        this.actionFooterWarmed = false;
        recyclerView.post(new Runnable() { // from class: com.stepos.agentframework.chatui.A1
            @Override // java.lang.Runnable
            public final void run() {
                ChatMessageAdapter.f0(this.f22753a, recyclerView);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        kotlin.jvm.internal.p.i(recyclerView, "recyclerView");
        recyclerView.removeOnAttachStateChangeListener(this.viewportAttachListener);
        recyclerView.removeOnScrollListener(this.viewportScrollListener);
        if (this.attachedRecyclerView == recyclerView) {
            this.attachedRecyclerView = null;
            this.actionFooterWarmed = false;
            kotlinx.coroutines.d.e(this.preparationScope, null, 1, null);
            Iterator<T> it = this.preparations.values().iterator();
            while (it.hasNext()) {
                ((c) it.next()).k(null);
            }
            this.pendingTextViewport = null;
        }
        super.onDetachedFromRecyclerView(recyclerView);
    }

    public final int p0() {
        Iterator<S1> it = this.itemList.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            if (it.next() instanceof k2) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public final void q0() {
        P0(true);
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void r(List<DisplayMessage> messages) {
        kotlin.jvm.internal.p.i(messages, "messages");
        int size = this.itemList.size();
        this.itemList.addAll(messages);
        d0(size, messages.size());
        C();
    }

    public final void r0() {
        Iterator<S1> it = this.itemList.iterator();
        int i10 = 0;
        while (true) {
            if (!it.hasNext()) {
                i10 = -1;
                break;
            }
            S1 next = it.next();
            if (next instanceof DisplayMessage) {
                DisplayMessage displayMessage = (DisplayMessage) next;
                if (displayMessage.getRole() == AgentRole.ASSISTANT && (displayMessage.getStatus() == EReplyStatus.START || displayMessage.getStatus() == EReplyStatus.REPLYING || displayMessage.getStatus() == EReplyStatus.TOOL_EXECUTING)) {
                    break;
                }
            }
            i10++;
        }
        if (i10 != -1) {
            a0(this, i10, null, 2, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x016c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void s(com.stepos.agentframework.chatui.DisplayMessage r13) {
        /*
            Method dump skipped, instructions count: 563
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatui.ChatMessageAdapter.s(com.stepos.agentframework.chatui.N1):void");
    }

    public final void s0(int viewType, int layoutId, p9.p<? super View, ? super U1, ? extends AbstractC2106k> creator) {
        this.viewTypeLayoutMap.put(Integer.valueOf(viewType), Integer.valueOf(layoutId));
        this.viewHolderCreatorMap.put(Integer.valueOf(viewType), creator);
    }

    public final void t(DisplayMessage message) {
        kotlin.jvm.internal.p.i(message, "message");
        Object objT0 = Z8.F.t0(this.itemList, T());
        DisplayMessage displayMessage = objT0 instanceof DisplayMessage ? (DisplayMessage) objT0 : null;
        u0();
        int iP = P(message);
        this.itemList.add(iP, message);
        b0(iP);
        q0();
        if ((displayMessage != null ? displayMessage.getRole() : null) == AgentRole.ASSISTANT && !displayMessage.getStatus().isTerminal()) {
            Iterator<S1> it = this.itemList.iterator();
            int i10 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i10 = -1;
                    break;
                } else if (it.next() == displayMessage) {
                    break;
                } else {
                    i10++;
                }
            }
            if (i10 >= 0 && i10 != T()) {
                Z(i10, PAYLOAD_UPDATE_LOADING);
            }
        }
        C();
    }

    public final void t0() {
        Iterator<S1> it = this.itemList.iterator();
        int i10 = 0;
        while (true) {
            if (!it.hasNext()) {
                i10 = -1;
                break;
            }
            S1 next = it.next();
            if (next instanceof DisplayMessage) {
                DisplayMessage displayMessage = (DisplayMessage) next;
                if (displayMessage.getRole() == AgentRole.ASSISTANT && !displayMessage.getStatus().isTerminal()) {
                    break;
                }
            }
            i10++;
        }
        if (i10 == -1) {
            return;
        }
        S1 s12 = this.itemList.get(i10);
        kotlin.jvm.internal.p.g(s12, "null cannot be cast to non-null type com.stepos.agentframework.chatui.DisplayMessage");
        DisplayMessage displayMessage2 = (DisplayMessage) s12;
        if (displayMessage2.getReleaseHeldCards()) {
            Z(i10, PAYLOAD_UPDATE_CONTENT);
            return;
        }
        displayMessage2.d0(true);
        C4148a.k(this.TAG, "releaseHeldCardsOnStreamingAssistant messageId=" + displayMessage2.getMessageId() + " status=" + displayMessage2.getStatus(), false, 4, null);
        Z(i10, PAYLOAD_UPDATE_CONTENT);
    }

    public final void u(RecyclerView recyclerView, String messageId, SendState state) {
        Iterator<S1> it = this.itemList.iterator();
        int i10 = 0;
        while (true) {
            if (!it.hasNext()) {
                i10 = -1;
                break;
            }
            S1 next = it.next();
            if ((next instanceof DisplayMessage) && kotlin.jvm.internal.p.d(((DisplayMessage) next).getMessageId(), messageId)) {
                break;
            } else {
                i10++;
            }
        }
        if (i10 == -1) {
            return;
        }
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(y0(this, i10, false, 2, null));
        AbstractC2106k abstractC2106k = viewHolderFindViewHolderForAdapterPosition instanceof AbstractC2106k ? (AbstractC2106k) viewHolderFindViewHolderForAdapterPosition : null;
        if (abstractC2106k == null) {
            return;
        }
        abstractC2106k.j(state);
        C4148a.d(this.TAG, "syncVisibleSendState messageId=" + messageId + " state=" + state + " index=" + i10 + " holder=" + abstractC2106k.getClass().getSimpleName(), false, 4, null);
    }

    public final void u0() {
        if (H()) {
            this.itemList.remove(0);
            e0(0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0040 A[PHI: r6
      0x0040: PHI (r6v2 androidx.recyclerview.widget.RecyclerView) = (r6v1 androidx.recyclerview.widget.RecyclerView), (r6v3 androidx.recyclerview.widget.RecyclerView) binds: [B:16:0x003d, B:25:0x0081] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0081 -> B:17:0x0040). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object v(androidx.recyclerview.widget.RecyclerView r6, e9.InterfaceC4014c<? super Y8.t> r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.stepos.agentframework.chatui.ChatMessageAdapter$awaitProjectionIdle$1
            if (r0 == 0) goto L13
            r0 = r7
            com.stepos.agentframework.chatui.ChatMessageAdapter$awaitProjectionIdle$1 r0 = (com.stepos.agentframework.chatui.ChatMessageAdapter$awaitProjectionIdle$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.chatui.ChatMessageAdapter$awaitProjectionIdle$1 r0 = new com.stepos.agentframework.chatui.ChatMessageAdapter$awaitProjectionIdle$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r7 = f9.C4063a.g()
            int r1 = r0.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L3d
            if (r1 == r3) goto L35
            if (r1 != r2) goto L2d
            java.lang.Object r6 = r0.L$0
            androidx.recyclerview.widget.RecyclerView r6 = (androidx.recyclerview.widget.RecyclerView) r6
            goto L3d
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            java.lang.Object r6 = r0.L$0
            androidx.recyclerview.widget.RecyclerView r6 = (androidx.recyclerview.widget.RecyclerView) r6
            kotlin.C4849c.b(r5)
            goto L79
        L3d:
            kotlin.C4849c.b(r5)
        L40:
            int r5 = r6.getScrollState()
            if (r5 == 0) goto L84
            r0.L$0 = r6
            r5 = 0
            r0.I$0 = r5
            r0.label = r3
            kotlinx.coroutines.c r5 = new kotlinx.coroutines.c
            e9.c r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.d(r0)
            r5.<init>(r1, r3)
            r5.I()
            com.stepos.agentframework.chatui.ChatMessageAdapter$f r1 = new com.stepos.agentframework.chatui.ChatMessageAdapter$f
            r1.<init>(r6, r5)
            r6.addOnScrollListener(r1)
            com.stepos.agentframework.chatui.ChatMessageAdapter$e r4 = new com.stepos.agentframework.chatui.ChatMessageAdapter$e
            r4.<init>(r6, r1)
            r5.q(r4)
            java.lang.Object r5 = r5.C()
            java.lang.Object r1 = f9.C4063a.g()
            if (r5 != r1) goto L76
            g9.f.c(r0)
        L76:
            if (r5 != r7) goto L79
            goto L83
        L79:
            r0.L$0 = r6
            r0.label = r2
            java.lang.Object r5 = Ua.W0.a(r0)
            if (r5 != r7) goto L40
        L83:
            return r7
        L84:
            Y8.t r5 = Y8.t.f7040a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatui.ChatMessageAdapter.v(androidx.recyclerview.widget.RecyclerView, e9.c):java.lang.Object");
    }

    public final int v0(String messageId, int keepIndex) {
        int size = this.itemList.size() - 1;
        if (size < 0) {
            return keepIndex;
        }
        while (true) {
            int i10 = size - 1;
            if (size != keepIndex) {
                S1 s12 = this.itemList.get(size);
                DisplayMessage displayMessage = s12 instanceof DisplayMessage ? (DisplayMessage) s12 : null;
                if (displayMessage != null && kotlin.jvm.internal.p.d(displayMessage.getMessageId(), messageId)) {
                    C4148a.k(this.TAG, "remove duplicate messageId=" + messageId + " at=" + size + " keep=" + keepIndex, false, 4, null);
                    this.itemList.remove(size);
                    e0(size);
                    if (size < keepIndex) {
                        keepIndex--;
                    }
                }
            }
            if (i10 < 0) {
                return keepIndex;
            }
            size = i10;
        }
    }

    public final void w(AbstractC2106k holder, int position, List<Object> payloads) {
        if (this.renderRows.get(position).getKind() != ChatRenderRow.Kind.MESSAGE) {
            x(holder, position);
            D();
            return;
        }
        int iH = this.renderRows.get(position).getLogicalIndex();
        if (payloads.isEmpty()) {
            holder.e(this.itemList.get(iH), iH);
            D();
            return;
        }
        for (Object obj : payloads) {
            if (kotlin.jvm.internal.p.d(obj, PAYLOAD_UPDATE_CONTENT)) {
                S1 s12 = this.itemList.get(iH);
                if (s12 instanceof DisplayMessage) {
                    DisplayMessage displayMessage = (DisplayMessage) s12;
                    holder.h(displayMessage, iH);
                    if (displayMessage.getRole() == AgentRole.USER) {
                        holder.j(displayMessage.getSendState());
                    }
                }
            } else if (kotlin.jvm.internal.p.d(obj, PAYLOAD_REPLACE_MESSAGE)) {
                holder.e(this.itemList.get(iH), iH);
            } else if (kotlin.jvm.internal.p.d(obj, PAYLOAD_UPDATE_LIKE)) {
                S1 s13 = this.itemList.get(iH);
                if (s13 instanceof DisplayMessage) {
                    holder.i(((DisplayMessage) s13).getLikeStatus());
                } else if (s13 instanceof C1978a) {
                    holder.i(((C1978a) s13).getTarget().getLikeStatus());
                }
            } else if (kotlin.jvm.internal.p.d(obj, PAYLOAD_UPDATE_SUGGESTIONS)) {
                if (this.itemList.get(iH) instanceof DisplayMessage) {
                    S1 s14 = this.itemList.get(iH);
                    kotlin.jvm.internal.p.g(s14, "null cannot be cast to non-null type com.stepos.agentframework.chatui.DisplayMessage");
                    holder.f((DisplayMessage) s14);
                }
            } else if (kotlin.jvm.internal.p.d(obj, PAYLOAD_SENT_MESSAGE_SHOW_ERROR)) {
                holder.g("网络错误，请稍后重试");
            } else if (kotlin.jvm.internal.p.d(obj, PAYLOAD_SENT_MESSAGE_DISMISS_ERROR)) {
                holder.b();
            } else if (kotlin.jvm.internal.p.d(obj, PAYLOAD_UPDATE_SEND_STATE)) {
                S1 s15 = this.itemList.get(iH);
                if (s15 instanceof DisplayMessage) {
                    holder.j(((DisplayMessage) s15).getSendState());
                }
            } else if (kotlin.jvm.internal.p.d(obj, PAYLOAD_COLLAPSE_COT)) {
                holder.a();
            } else if (kotlin.jvm.internal.p.d(obj, PAYLOAD_UPDATE_LOADING)) {
                S1 s16 = this.itemList.get(iH);
                DisplayMessage displayMessage2 = s16 instanceof DisplayMessage ? (DisplayMessage) s16 : null;
                if (displayMessage2 != null) {
                    com.stepos.agentframework.chatui.viewholder.F f10 = holder instanceof com.stepos.agentframework.chatui.viewholder.F ? (com.stepos.agentframework.chatui.viewholder.F) holder : null;
                    if (f10 != null) {
                        f10.e0(displayMessage2, iH);
                    }
                }
            }
        }
        D();
    }

    public final void w0(String messageId) {
        kotlin.jvm.internal.p.i(messageId, "messageId");
        Iterator<S1> it = this.itemList.iterator();
        int i10 = 0;
        while (true) {
            if (!it.hasNext()) {
                i10 = -1;
                break;
            }
            S1 next = it.next();
            if (next.b()) {
                kotlin.jvm.internal.p.g(next, "null cannot be cast to non-null type com.stepos.agentframework.chatui.DisplayMessage");
                if (kotlin.jvm.internal.p.d(((DisplayMessage) next).getMessageId(), messageId)) {
                    break;
                }
            }
            i10++;
        }
        if (i10 != -1) {
            this.itemList.remove(i10);
            e0(i10);
            q0();
            C();
        }
    }

    public final void x(AbstractC2106k holder, int position) {
        int iO;
        List<LongTextDocument.Block> listA;
        LongTextDocument.Block block;
        ChatRenderRow chatRenderRow = this.renderRows.get(position);
        tableRow = null;
        tableRow = null;
        LongTextDocument.TableRow tableRow = null;
        switch (d.$EnumSwitchMapping$0[chatRenderRow.getKind().ordinal()]) {
            case 1:
                holder.e(chatRenderRow.getItem(), chatRenderRow.getLogicalIndex());
                return;
            case 2:
                kotlin.jvm.internal.p.g(holder, "null cannot be cast to non-null type com.stepos.agentframework.chatui.viewholder.ReceiveTextViewHolder");
                com.stepos.agentframework.chatui.viewholder.F f10 = (com.stepos.agentframework.chatui.viewholder.F) holder;
                S1 s1F = chatRenderRow.getItem();
                kotlin.jvm.internal.p.g(s1F, "null cannot be cast to non-null type com.stepos.agentframework.chatui.DisplayMessage");
                DisplayMessage displayMessage = (DisplayMessage) s1F;
                int iH = chatRenderRow.getLogicalIndex();
                Integer numValueOf = Integer.valueOf(chatRenderRow.getBodyPartIndex());
                Integer num = numValueOf.intValue() >= 0 ? numValueOf : null;
                if (num != null) {
                    iO = num.intValue();
                } else {
                    S1 s1F2 = chatRenderRow.getItem();
                    kotlin.jvm.internal.p.g(s1F2, "null cannot be cast to non-null type com.stepos.agentframework.chatui.DisplayMessage");
                    iO = C1173v.o(((DisplayMessage) s1F2).m());
                }
                f10.y(displayMessage, iH, iO);
                return;
            case 3:
                kotlin.jvm.internal.p.g(holder, "null cannot be cast to non-null type com.stepos.agentframework.chatui.viewholder.LongTextAttachmentsViewHolder");
                ((C2108m) holder).k(chatRenderRow);
                return;
            case 4:
            case 5:
                if (holder instanceof com.stepos.agentframework.chatui.viewholder.r) {
                    S1 s1F3 = chatRenderRow.getItem();
                    kotlin.jvm.internal.p.g(s1F3, "null cannot be cast to non-null type com.stepos.agentframework.chatui.DisplayMessage");
                    DisplayMessage displayMessage2 = (DisplayMessage) s1F3;
                    c cVar = this.preparations.get(new LongTextKey(displayMessage2.getSessionId(), displayMessage2.getMessageId()));
                    if (cVar == null) {
                        throw new IllegalArgumentException("Required value was null.");
                    }
                    c cVar2 = cVar;
                    LongTextDocument longTextDocumentE = chatRenderRow.getDocument();
                    if (longTextDocumentE != null && (listA = longTextDocumentE.a()) != null && (block = listA.get(chatRenderRow.getBlockIndex())) != null) {
                        tableRow = block.getTableRow();
                    }
                    if (tableRow == null) {
                        throw new IllegalArgumentException("Required value was null.");
                    }
                    com.stepos.agentframework.chatui.viewholder.r rVar = (com.stepos.agentframework.chatui.viewholder.r) holder;
                    Map<Integer, z4.h> mapG = cVar2.g();
                    Integer numValueOf2 = Integer.valueOf(tableRow.getTableId());
                    z4.h hVar = mapG.get(numValueOf2);
                    if (hVar == null) {
                        hVar = new z4.h();
                        mapG.put(numValueOf2, hVar);
                    }
                    rVar.r(chatRenderRow, hVar);
                } else if (holder instanceof C2113s) {
                    ((C2113s) holder).k(chatRenderRow);
                } else {
                    kotlin.jvm.internal.p.g(holder, "null cannot be cast to non-null type com.stepos.agentframework.chatui.viewholder.LongTextBlockViewHolder");
                    ((C2109n) holder).k(chatRenderRow);
                }
                if (chatRenderRow.getKind() == ChatRenderRow.Kind.PREPARING) {
                    l0(chatRenderRow);
                    return;
                }
                return;
            case 6:
                kotlin.jvm.internal.p.g(holder, "null cannot be cast to non-null type com.stepos.agentframework.chatui.viewholder.MarkdownBlockViewHolder");
                ((C2113s) holder).k(chatRenderRow);
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final int x0(int logicalIndex, boolean atTop) {
        if (atTop) {
            List<ChatRenderRow> list = this.renderRows;
            ListIterator<ChatRenderRow> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                if (listIterator.previous().getLogicalIndex() == logicalIndex) {
                    return listIterator.nextIndex();
                }
            }
            return -1;
        }
        Iterator<ChatRenderRow> it = this.renderRows.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            if (it.next().getLogicalIndex() == logicalIndex) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public final int y() {
        return Math.max(U(), Math.max(S0(), p0())) + 1;
    }

    public final List<ChatRenderRow> z() {
        c cVar;
        int iO;
        List<DisplayChatMessage> listM;
        kotlinx.coroutines.g job;
        HashSet hashSet = new HashSet();
        List<S1> list = this.itemList;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        int i10 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            S1 s12 = (S1) next;
            LongTextCandidate c6357cF = this.longTextProjectionEnabled ? LongTextCandidate.INSTANCE.f(s12) : null;
            if (c6357cF != null) {
                hashSet.add(c6357cF.getKey());
                cVar = this.preparations.get(c6357cF.getKey());
                if (cVar == null || !kotlin.jvm.internal.p.d(cVar.getCandidate().getSource(), c6357cF.getSource()) || !kotlin.jvm.internal.p.d(cVar.getCandidate().getAgentId(), c6357cF.getAgentId()) || cVar.getCandidate().getPartIndex() != c6357cF.getPartIndex()) {
                    if (cVar != null && (job = cVar.getJob()) != null) {
                        kotlinx.coroutines.g.Y0(job, null, 1, null);
                    }
                    long j10 = this.nextPreparationId + 1;
                    this.nextPreparationId = j10;
                    cVar = new c(c6357cF, j10);
                    this.preparations.put(c6357cF.getKey(), cVar);
                }
            } else {
                cVar = null;
            }
            com.stepos.agentframework.chatui.longtext.a aVar = com.stepos.agentframework.chatui.longtext.a.INSTANCE;
            LongTextDocument document = cVar != null ? cVar.getDocument() : null;
            boolean z10 = (cVar == null || cVar.getFinished()) ? false : true;
            boolean z11 = this.longTextProjectionEnabled;
            if (c6357cF != null) {
                iO = c6357cF.getPartIndex();
            } else {
                DisplayMessage displayMessage = s12 instanceof DisplayMessage ? (DisplayMessage) s12 : null;
                iO = (displayMessage == null || (listM = displayMessage.m()) == null) ? -1 : C1173v.o(listM);
            }
            Z8.A.E(arrayList, aVar.b(s12, i10, document, z10, z11, iO));
            i10 = i11;
        }
        Iterator<Map.Entry<LongTextKey, c>> it2 = this.preparations.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry<LongTextKey, c> next2 = it2.next();
            if (!hashSet.contains(next2.getKey())) {
                PendingTextViewport pendingTextViewport = this.pendingTextViewport;
                if (kotlin.jvm.internal.p.d(pendingTextViewport != null ? pendingTextViewport.getKey() : null, next2.getKey())) {
                    this.pendingTextViewport = null;
                }
                kotlinx.coroutines.g job2 = next2.getValue().getJob();
                if (job2 != null) {
                    kotlinx.coroutines.g.Y0(job2, null, 1, null);
                }
                it2.remove();
            }
        }
        return arrayList;
    }

    public final void z0(int index) {
        S1 s12 = this.itemList.get(index);
        DisplayMessage displayMessage = s12 instanceof DisplayMessage ? (DisplayMessage) s12 : null;
        if (displayMessage == null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        displayMessage.k0(EReplyStatus.REPLYING);
        displayMessage.c0(jCurrentTimeMillis);
        displayMessage.b0(null);
        this.itemList.set(index, displayMessage);
        Z(index, PAYLOAD_UPDATE_LOADING);
        C4148a.k(this.TAG, "reopenForReplay messageId=" + displayMessage.getMessageId(), false, 4, null);
    }
}
