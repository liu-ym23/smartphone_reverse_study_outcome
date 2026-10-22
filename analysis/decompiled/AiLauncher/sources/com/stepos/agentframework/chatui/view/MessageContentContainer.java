package com.stepos.agentframework.chatui.view;

import Ua.C1060i;
import Z8.C1173v;
import Z8.C1174w;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.SystemClock;
import android.os.Trace;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.AMapLocationStaticsEntity;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.AgentUIConfig;
import com.stepos.agentframework.R$color;
import com.stepos.agentframework.R$id;
import com.stepos.agentframework.R$layout;
import com.stepos.agentframework.chatcore.intent.AgentTool;
import com.stepos.agentframework.chatcore.session.AgentMessageType;
import com.stepos.agentframework.chatcore.session.AgentRole;
import com.stepos.agentframework.chatcore.session.ChatCoreSdk;
import com.stepos.agentframework.chatcore.session.ChatHintType;
import com.stepos.agentframework.chatcore.session.EReplyStatus;
import com.stepos.agentframework.chatcore.session.bean.AppUIData;
import com.stepos.agentframework.chatui.AgentFileSyncBridge;
import com.stepos.agentframework.chatui.C2036o1;
import com.stepos.agentframework.chatui.CotTracker;
import com.stepos.agentframework.chatui.DisplayChatMessage;
import com.stepos.agentframework.chatui.DisplayMessage;
import com.stepos.agentframework.chatui.DisplayTool;
import com.stepos.agentframework.chatui.H1;
import com.stepos.agentframework.chatui.HeldCardFlushPolicy;
import com.stepos.agentframework.chatui.ToolNameMapping;
import com.stepos.agentframework.chatui.appui.AppUIGlobal;
import com.stepos.agentframework.chatui.appui.BaseAppUIHostView;
import com.stepos.agentframework.chatui.appui.LocalAppUIHostView;
import com.stepos.agentframework.chatui.appui.RemoteAppUIHostView;
import com.stepos.agentframework.chatui.appui.c;
import com.stepos.agentframework.chatui.appui.taskrobot.RobotAppUIHostView;
import com.stepos.agentframework.chatui.appui.web.WebAppUiView;
import com.stepos.agentframework.chatui.view.MessageContentContainer;
import com.stepos.agentframework.uikit.AIMDTextView;
import com.stepos.agentframework.uikit.MarkdownBlockSpacing;
import com.stepos.agentframework.uikit.MarkwonHelper;
import com.stepos.agentframework.util.AgentImagePreviewActivity;
import com.stepos.ailauncher.agent.receiver.SystemDeleteBroadcastReceiver;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h8.C4148a;
import io.ktor.http.LinkHeader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.C4848b;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ReferenceSource;
import kotlin.Result;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.sequences.SequencesKt___SequencesKt;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import u4.m;
import v9.C5685n;
import z4.C6360f;
import z4.LongTextShape;

@Metadata(d1 = {"\u0000Î\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\"\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u0094\u00022\u00020\u0001:\u0002\u0095\u0002B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J/\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b \u0010!J\u0015\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0002¢\u0006\u0004\b$\u0010%J\u0015\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\"H\u0002¢\u0006\u0004\b'\u0010%J\u000f\u0010(\u001a\u00020\u0010H\u0002¢\u0006\u0004\b(\u0010\u0018J\u000f\u0010)\u001a\u00020#H\u0002¢\u0006\u0004\b)\u0010*J)\u00100\u001a\u0004\u0018\u00010/2\u0006\u0010+\u001a\u00020\b2\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020\bH\u0002¢\u0006\u0004\b0\u00101J\u0017\u00104\u001a\u00020\u000e2\u0006\u00103\u001a\u000202H\u0002¢\u0006\u0004\b4\u00105J\u001f\u00107\u001a\u0002022\u0006\u00103\u001a\u0002022\u0006\u00106\u001a\u00020\nH\u0002¢\u0006\u0004\b7\u00108J\u0017\u0010:\u001a\u00020\b2\u0006\u00109\u001a\u00020\nH\u0002¢\u0006\u0004\b:\u0010;J\u0017\u0010>\u001a\u00020\u00102\u0006\u0010=\u001a\u00020<H\u0002¢\u0006\u0004\b>\u0010?J\u0015\u0010A\u001a\b\u0012\u0004\u0012\u00020@0\"H\u0002¢\u0006\u0004\bA\u0010%J\u0017\u0010B\u001a\u00020\u000e2\u0006\u00106\u001a\u00020\nH\u0002¢\u0006\u0004\bB\u0010CJ\u0017\u0010D\u001a\u00020\u00102\u0006\u00106\u001a\u00020\nH\u0002¢\u0006\u0004\bD\u0010EJA\u0010I\u001a\u00020\u00102\u0006\u00106\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u00103\u001a\u0002022\u0018\u0010H\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u0002020G0FH\u0002¢\u0006\u0004\bI\u0010JJ)\u0010K\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u0002020G0\"2\u0006\u00106\u001a\u00020\nH\u0002¢\u0006\u0004\bK\u0010LJ9\u0010N\u001a\u00020\u00102\u0018\u0010H\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u0002020G0\"2\u000e\b\u0002\u0010M\u001a\b\u0012\u0004\u0012\u00020/0\"H\u0002¢\u0006\u0004\bN\u0010OJ)\u0010P\u001a\u00020\u00102\u0018\u0010H\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u0002020G0\"H\u0002¢\u0006\u0004\bP\u0010QJ\u0017\u0010R\u001a\u00020\u00102\u0006\u00106\u001a\u00020\nH\u0002¢\u0006\u0004\bR\u0010EJ\u0017\u0010T\u001a\u00020\u000e2\u0006\u0010S\u001a\u00020\bH\u0002¢\u0006\u0004\bT\u0010UJ\u001d\u0010W\u001a\b\u0012\u0004\u0012\u00020\b0V2\u0006\u00106\u001a\u00020\nH\u0002¢\u0006\u0004\bW\u0010XJ#\u0010Z\u001a\b\u0012\u0004\u0012\u00020/0\"2\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020\b0VH\u0002¢\u0006\u0004\bZ\u0010[J\u0017\u0010]\u001a\u00020\u000e2\u0006\u0010\\\u001a\u00020/H\u0002¢\u0006\u0004\b]\u0010^J;\u0010`\u001a\u00020\u000e2\u0006\u0010S\u001a\u00020\b2\u0006\u00103\u001a\u0002022\u000e\b\u0002\u0010M\u001a\b\u0012\u0004\u0012\u00020/0\"2\n\b\u0002\u0010_\u001a\u0004\u0018\u00010,H\u0002¢\u0006\u0004\b`\u0010aJ\u001d\u0010c\u001a\u00020\u00102\f\u0010b\u001a\b\u0012\u0004\u0012\u00020/0\"H\u0002¢\u0006\u0004\bc\u0010QJ\u0015\u0010e\u001a\b\u0012\u0004\u0012\u00020d0\"H\u0002¢\u0006\u0004\be\u0010%J\u0011\u0010g\u001a\u0004\u0018\u00010fH\u0002¢\u0006\u0004\bg\u0010hJ\u0017\u0010i\u001a\u00020\u000e2\u0006\u00106\u001a\u00020\nH\u0002¢\u0006\u0004\bi\u0010CJ\u0017\u0010j\u001a\u00020,2\u0006\u00106\u001a\u00020\nH\u0002¢\u0006\u0004\bj\u0010kJ\u0017\u0010l\u001a\u00020,2\u0006\u00106\u001a\u00020\nH\u0002¢\u0006\u0004\bl\u0010kJ_\u0010r\u001a\u00020\u00102\u0006\u00106\u001a\u00020\n2\f\u0010m\u001a\b\u0012\u0004\u0012\u00020,0V2\f\u0010n\u001a\b\u0012\u0004\u0012\u00020d0\"2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020/0\"2\b\u0010o\u001a\u0004\u0018\u00010\u000e2\u0012\u0010q\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e0pH\u0002¢\u0006\u0004\br\u0010sJ\u0017\u0010v\u001a\u00020u2\u0006\u0010t\u001a\u00020\bH\u0002¢\u0006\u0004\bv\u0010wJ\u0017\u0010z\u001a\u00020\u00132\u0006\u0010y\u001a\u00020xH\u0002¢\u0006\u0004\bz\u0010{J\u0017\u0010~\u001a\u00020}2\u0006\u0010|\u001a\u00020\u0013H\u0002¢\u0006\u0004\b~\u0010\u007fJ\u0011\u0010\u0080\u0001\u001a\u00020\u0010H\u0002¢\u0006\u0005\b\u0080\u0001\u0010\u0018J&\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0082\u00012\u0006\u0010\u0014\u001a\u00020\u00132\u0007\u0010\u0081\u0001\u001a\u00020\u000eH\u0002¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001J\u001b\u0010\u0085\u0001\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0005\b\u0085\u0001\u0010\u0016J\u0019\u0010\u0086\u0001\u001a\u00020\u00102\u0006\u00106\u001a\u00020\nH\u0002¢\u0006\u0005\b\u0086\u0001\u0010EJ\u001c\u0010\u0089\u0001\u001a\u00020\u00102\b\u0010\u0088\u0001\u001a\u00030\u0087\u0001H\u0002¢\u0006\u0006\b\u0089\u0001\u0010\u008a\u0001J\u001f\u0010\u008b\u0001\u001a\b\u0012\u0004\u0012\u00020,0V2\u0006\u00106\u001a\u00020\nH\u0002¢\u0006\u0005\b\u008b\u0001\u0010XJ\u0019\u0010\u008c\u0001\u001a\u00020,2\u0006\u00106\u001a\u00020\nH\u0002¢\u0006\u0005\b\u008c\u0001\u0010kJ\u0019\u0010\u008d\u0001\u001a\u00020\u00102\u0006\u00106\u001a\u00020\nH\u0002¢\u0006\u0005\b\u008d\u0001\u0010EJ\u001c\u0010\u0090\u0001\u001a\u0002022\b\u0010\u008f\u0001\u001a\u00030\u008e\u0001H\u0002¢\u0006\u0006\b\u0090\u0001\u0010\u0091\u0001J$\u0010\u0094\u0001\u001a\u00020\b2\u0007\u0010\u0092\u0001\u001a\u00020\b2\u0007\u0010\u0093\u0001\u001a\u00020\bH\u0002¢\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001J\u0019\u0010\u0096\u0001\u001a\u00020\u00102\u0006\u00106\u001a\u00020\nH\u0002¢\u0006\u0005\b\u0096\u0001\u0010EJ\u001b\u0010\u0098\u0001\u001a\u00020\u00102\u0007\u0010\u0097\u0001\u001a\u00020\u0013H\u0002¢\u0006\u0006\b\u0098\u0001\u0010\u0099\u0001J,\u0010\u009e\u0001\u001a\u00020\u00102\b\u0010\u009b\u0001\u001a\u00030\u009a\u00012\u000e\u0010\u009d\u0001\u001a\t\u0012\u0005\u0012\u00030\u009c\u00010\"H\u0002¢\u0006\u0006\b\u009e\u0001\u0010\u009f\u0001J$\u0010¢\u0001\u001a\u00020\u00102\u0007\u0010 \u0001\u001a\u00020,2\u0007\u0010¡\u0001\u001a\u00020,H\u0014¢\u0006\u0006\b¢\u0001\u0010£\u0001J\u001c\u0010¦\u0001\u001a\u00020\u00102\b\u0010¥\u0001\u001a\u00030¤\u0001H\u0014¢\u0006\u0006\b¦\u0001\u0010§\u0001J\u0011\u0010¨\u0001\u001a\u00020\u0010H\u0014¢\u0006\u0005\b¨\u0001\u0010\u0018J\u0011\u0010©\u0001\u001a\u00020\u0010H\u0014¢\u0006\u0005\b©\u0001\u0010\u0018J\u001c\u0010¬\u0001\u001a\u00020\u000e2\b\u0010«\u0001\u001a\u00030ª\u0001H\u0016¢\u0006\u0006\b¬\u0001\u0010\u00ad\u0001J \u0010¯\u0001\u001a\u0010\u0012\u0005\u0012\u00030®\u0001\u0012\u0005\u0012\u00030®\u00010GH\u0000¢\u0006\u0006\b¯\u0001\u0010°\u0001J(\u0010±\u0001\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020\b2\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020\b¢\u0006\u0006\b±\u0001\u0010²\u0001J\u0017\u0010³\u0001\u001a\u00020\u00102\u0006\u00106\u001a\u00020\n¢\u0006\u0005\b³\u0001\u0010EJ\u0017\u0010´\u0001\u001a\u00020\u00102\u0006\u00106\u001a\u00020\n¢\u0006\u0005\b´\u0001\u0010EJ\u0010\u0010µ\u0001\u001a\u00020\u000e¢\u0006\u0006\bµ\u0001\u0010¶\u0001J%\u0010¸\u0001\u001a\u0004\u0018\u00010\u00132\u0006\u0010S\u001a\u00020\b2\u0007\u0010·\u0001\u001a\u000202H\u0007¢\u0006\u0006\b¸\u0001\u0010¹\u0001J,\u0010½\u0001\u001a\u00020@2\u0007\u00106\u001a\u00030º\u00012\b\u0010¼\u0001\u001a\u00030»\u00012\u0007\u0010\u0092\u0001\u001a\u00020\b¢\u0006\u0006\b½\u0001\u0010¾\u0001J\u0018\u0010¿\u0001\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0006\b¿\u0001\u0010\u0099\u0001J\u001b\u0010Á\u0001\u001a\u00020\u00102\b\u00106\u001a\u0004\u0018\u00010\nH\u0000¢\u0006\u0005\bÀ\u0001\u0010ER\u0018\u0010Ã\u0001\u001a\u00030Â\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÃ\u0001\u0010Ä\u0001R\u0019\u0010Å\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÅ\u0001\u0010Æ\u0001R\u0017\u0010Ç\u0001\u001a\u00020\b8\u0002X\u0082D¢\u0006\b\n\u0006\bÇ\u0001\u0010Æ\u0001R\u0019\u00106\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b6\u0010È\u0001R2\u0010Ê\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0010\u0018\u00010É\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÊ\u0001\u0010Ë\u0001\u001a\u0006\bÌ\u0001\u0010Í\u0001\"\u0006\bÎ\u0001\u0010Ï\u0001R\u0018\u0010Ð\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bÐ\u0001\u0010lR0\u0010Ñ\u0001\u001a\u001b\u0012\u0017\u0012\u0015\u0012\u0004\u0012\u00020\u0013\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\u00100É\u00010G0F8\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÑ\u0001\u0010Ò\u0001R\u0018\u0010Ô\u0001\u001a\u00030Ó\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÔ\u0001\u0010Õ\u0001R\u0018\u0010×\u0001\u001a\u00030Ö\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b×\u0001\u0010Ø\u0001R1\u0010Ú\u0001\u001a\u00020\u000e2\u0007\u0010Ù\u0001\u001a\u00020\u000e8\u0006@FX\u0086\u000e¢\u0006\u0017\n\u0005\bÚ\u0001\u0010l\u001a\u0006\bÛ\u0001\u0010¶\u0001\"\u0006\bÜ\u0001\u0010Ý\u0001R1\u0010Þ\u0001\u001a\u00020\u000e2\u0007\u0010Ù\u0001\u001a\u00020\u000e8\u0006@FX\u0086\u000e¢\u0006\u0017\n\u0005\bÞ\u0001\u0010l\u001a\u0006\bß\u0001\u0010¶\u0001\"\u0006\bà\u0001\u0010Ý\u0001Rh\u0010â\u0001\u001a\u001d\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u0010\u0018\u00010á\u00012\"\u0010Ù\u0001\u001a\u001d\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u0010\u0018\u00010á\u00018\u0006@FX\u0086\u000e¢\u0006\u0018\n\u0006\bâ\u0001\u0010ã\u0001\u001a\u0006\bä\u0001\u0010å\u0001\"\u0006\bæ\u0001\u0010ç\u0001R\u001b\u0010è\u0001\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bè\u0001\u0010Æ\u0001R(\u0010é\u0001\u001a\u00020,8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\bé\u0001\u0010$\u001a\u0006\bê\u0001\u0010ë\u0001\"\u0006\bì\u0001\u0010í\u0001R)\u0010î\u0001\u001a\u00030®\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\bî\u0001\u0010Z\u001a\u0006\bï\u0001\u0010ð\u0001\"\u0006\bñ\u0001\u0010ò\u0001R)\u0010ó\u0001\u001a\u00030®\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\bó\u0001\u0010Z\u001a\u0006\bô\u0001\u0010ð\u0001\"\u0006\bõ\u0001\u0010ò\u0001R(\u0010ö\u0001\u001a\u00020,8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\bö\u0001\u0010$\u001a\u0006\b÷\u0001\u0010ë\u0001\"\u0006\bø\u0001\u0010í\u0001R,\u0010ú\u0001\u001a\u0005\u0018\u00010ù\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bú\u0001\u0010û\u0001\u001a\u0006\bü\u0001\u0010ý\u0001\"\u0006\bþ\u0001\u0010ÿ\u0001R(\u0010\u0080\u0002\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b\u0080\u0002\u0010l\u001a\u0006\b\u0081\u0002\u0010¶\u0001\"\u0006\b\u0082\u0002\u0010Ý\u0001R1\u0010\u0083\u0002\u001a\u00020,2\u0007\u0010Ù\u0001\u001a\u00020,8\u0006@FX\u0086\u000e¢\u0006\u0017\n\u0005\b\u0083\u0002\u0010$\u001a\u0006\b\u0084\u0002\u0010ë\u0001\"\u0006\b\u0085\u0002\u0010í\u0001R\u0016\u0010\u0086\u0002\u001a\u00020\u000e8\u0002X\u0082D¢\u0006\u0007\n\u0005\b\u0086\u0002\u0010lR \u0010\u008a\u0002\u001a\u00020,8BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u0087\u0002\u0010\u0088\u0002\u001a\u0006\b\u0089\u0002\u0010ë\u0001R\u001b\u0010\u008b\u0002\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008b\u0002\u0010Æ\u0001R\u001e\u0010\u008c\u0002\u001a\t\u0012\u0004\u0012\u00020\u00100É\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008c\u0002\u0010Ë\u0001R\u0019\u0010\u008d\u0002\u001a\u00030®\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008d\u0002\u0010ZR\u0019\u0010\u008e\u0002\u001a\u00030®\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008e\u0002\u0010ZR\u001c\u0010\u008f\u0002\u001a\u0005\u0018\u00010\u009a\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008f\u0002\u0010\u0090\u0002R\u001c\u0010\u0092\u0002\u001a\u0005\u0018\u00010\u0091\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0092\u0002\u0010\u0093\u0002¨\u0006\u0096\u0002"}, d2 = {"Lcom/stepos/agentframework/chatui/view/MessageContentContainer;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "phase", "Lcom/stepos/agentframework/chatui/N1;", "current", "", "elapsedMs", "", "completed", "LY8/t;", "F0", "(Ljava/lang/String;Lcom/stepos/agentframework/chatui/N1;JZ)V", "Landroid/view/View;", "view", "f0", "(Landroid/view/View;)Z", "v0", "()V", "Lcom/stepos/agentframework/chatui/CotTracker$Section;", "section", "expanded", "G0", "(Lcom/stepos/agentframework/chatui/CotTracker$Section;Z)V", "Lcom/stepos/agentframework/chatui/P1;", "tool", "M0", "(Lcom/stepos/agentframework/chatui/P1;)Z", "", "Lcom/stepos/agentframework/chatui/view/ToolExecuteGroupView;", "I", "()Ljava/util/List;", "Lcom/stepos/agentframework/chatui/view/AssistantDocumentCardView;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "y0", "M", "()Lcom/stepos/agentframework/chatui/view/ToolExecuteGroupView;", "toolCallId", "", "uiType", "packageName", "Lcom/stepos/agentframework/chatui/appui/BaseAppUIHostView;", "U", "(Ljava/lang/String;ILjava/lang/String;)Lcom/stepos/agentframework/chatui/appui/BaseAppUIHostView;", "Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;", "data", "g0", "(Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;)Z", "message", ExifInterface.LATITUDE_SOUTH, "(Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;Lcom/stepos/agentframework/chatui/N1;)Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;", "m", "m0", "(Lcom/stepos/agentframework/chatui/N1;)Ljava/lang/String;", "Lu4/m$c;", "f", "t0", "(Lu4/m$c;)V", "Lcom/stepos/agentframework/uikit/AIMDTextView;", "H", "R0", "(Lcom/stepos/agentframework/chatui/N1;)Z", "T0", "(Lcom/stepos/agentframework/chatui/N1;)V", "", "Lkotlin/Pair;", "heldCards", "C", "(Lcom/stepos/agentframework/chatui/N1;Lcom/stepos/agentframework/chatui/P1;Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;Ljava/util/List;)V", "B", "(Lcom/stepos/agentframework/chatui/N1;)Ljava/util/List;", "preservedCardHosts", "X", "(Ljava/util/List;Ljava/util/List;)V", "R", "(Ljava/util/List;)V", "setMessageContent", "flag", "c0", "(Ljava/lang/String;)Z", "", "j0", "(Lcom/stepos/agentframework/chatui/N1;)Ljava/util/Set;", "liveFlags", "F", "(Ljava/util/Set;)Ljava/util/List;", "host", "z", "(Lcom/stepos/agentframework/chatui/appui/BaseAppUIHostView;)Z", "insertAt", "x", "(Ljava/lang/String;Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;Ljava/util/List;Ljava/lang/Integer;)Z", "preserved", "u0", "Lcom/stepos/agentframework/chatui/appui/taskrobot/RobotAppUIHostView;", "G", "Lcom/stepos/agentframework/chatui/view/q;", ExifInterface.LONGITUDE_WEST, "()Lcom/stepos/agentframework/chatui/view/q;", "K0", "i0", "(Lcom/stepos/agentframework/chatui/N1;)I", "Z", "suppressed", "preservedRobotHosts", "restoreExpanded", "", "savedToolExpandStates", "A0", "(Lcom/stepos/agentframework/chatui/N1;Ljava/util/Set;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Ljava/util/Map;)V", "text", "Landroid/widget/TextView;", "q0", "(Ljava/lang/String;)Landroid/widget/TextView;", "Lu4/m$f;", "echo", "o0", "(Lu4/m$f;)Landroid/view/View;", "hostView", "Landroid/widget/LinearLayout$LayoutParams;", "L", "(Landroid/view/View;)Landroid/widget/LinearLayout$LayoutParams;", "w", AMapLocationStaticsEntity.FIRST_LOCATE, "Lcom/stepos/agentframework/uikit/MarkdownBlockSpacing$Kind;", "J", "(Landroid/view/View;Z)Lcom/stepos/agentframework/uikit/MarkdownBlockSpacing$Kind;", "h0", "b0", "Lcom/stepos/agentframework/chatui/appui/BaseAppUIHostView$TerminateReason;", "reason", "r0", "(Lcom/stepos/agentframework/chatui/appui/BaseAppUIHostView$TerminateReason;)V", "N0", ExifInterface.GPS_DIRECTION_TRUE, "P0", "Lu4/m$g;", "taskMessage", "Q0", "(Lu4/m$g;)Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;", "agentId", "raw", "H0", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "k0", "capsule", "v", "(Landroid/view/View;)V", "Lcom/stepos/agentframework/chatui/view/S;", LinkHeader.Parameters.Anchor, "LK6/A;", SystemDeleteBroadcastReceiver.EXTRA_SOURCES, "L0", "(Lcom/stepos/agentframework/chatui/view/S;Ljava/util/List;)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "Landroid/graphics/Canvas;", "canvas", "dispatchDraw", "(Landroid/graphics/Canvas;)V", "onAttachedToWindow", "onDetachedFromWindow", "Landroid/view/MotionEvent;", "ev", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "", "Q", "()Lkotlin/Pair;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(Ljava/lang/String;ILjava/lang/String;)Z", "S0", "setMessage", "d0", "()Z", "appUIData", "a0", "(Ljava/lang/String;Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;)Landroid/view/View;", "Lcom/stepos/agentframework/chatui/J1;", "Lcom/stepos/agentframework/chatcore/session/EReplyStatus;", "status", "p0", "(Lcom/stepos/agentframework/chatui/J1;Lcom/stepos/agentframework/chatcore/session/EReplyStatus;Ljava/lang/String;)Lcom/stepos/agentframework/uikit/AIMDTextView;", "z0", "setSourcesOnly$agentcore_release", "setSourcesOnly", "Lz4/f;", "renderLogLimiter", "Lz4/f;", "TAG", "Ljava/lang/String;", "BIZ_CHANNEL_ICON_KEY", "Lcom/stepos/agentframework/chatui/N1;", "Lkotlin/Function0;", "onToolGroupHeaderClick", "Lp9/a;", "getOnToolGroupHeaderClick", "()Lp9/a;", "setOnToolGroupHeaderClick", "(Lp9/a;)V", "cotExposureDirty", "cotExposureTargets", "Ljava/util/List;", "Landroid/graphics/Rect;", "cotVisibleRect", "Landroid/graphics/Rect;", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "cotPreDrawListener", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", UxipConstants.f30680s, "showToolActionLayout", "getShowToolActionLayout", "setShowToolActionLayout", "(Z)V", "showToolExecuteView", "getShowToolExecuteView", "setShowToolExecuteView", "Lkotlin/Function3;", "onToolLikeStatusChangedListener", "Lp9/q;", "getOnToolLikeStatusChangedListener", "()Lp9/q;", "setOnToolLikeStatusChangedListener", "(Lp9/q;)V", "appUiTerminatedForMessageId", "receiveMessageTextColor", "getReceiveMessageTextColor", "()I", "setReceiveMessageTextColor", "(I)V", "receiveMessageTextSizeSp", "getReceiveMessageTextSizeSp", "()F", "setReceiveMessageTextSizeSp", "(F)V", "receiveMessageLineSpacingMultiplier", "getReceiveMessageLineSpacingMultiplier", "setReceiveMessageLineSpacingMultiplier", "sentItemBg", "getSentItemBg", "setSentItemBg", "Lcom/stepos/agentframework/AgentUIConfig$TextStyle;", "sentTextStyle", "Lcom/stepos/agentframework/AgentUIConfig$TextStyle;", "getSentTextStyle", "()Lcom/stepos/agentframework/AgentUIConfig$TextStyle;", "setSentTextStyle", "(Lcom/stepos/agentframework/AgentUIConfig$TextStyle;)V", "allowTextSelection", "getAllowTextSelection", "setAllowTextSelection", "horizontalContentInsetPx", "getHorizontalContentInsetPx", "setHorizontalContentInsetPx", "hideGuiAgentCard", "interMessageComponentSpacingPx$delegate", "LY8/h;", "getInterMessageComponentSpacingPx", "interMessageComponentSpacingPx", "lastRenderedStructureSignature", "onToolNameMapLoaded", "lastTouchOffsetX", "lastTouchOffsetY", "sourcesCapsule", "Lcom/stepos/agentframework/chatui/view/S;", "Lcom/stepos/agentframework/chatui/view/d0;", "sourcesPopup", "Lcom/stepos/agentframework/chatui/view/d0;", "Companion", Const.INTENT_KEY_APIKEY, "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@SuppressLint({"ViewConstructor"})
/* loaded from: classes2.dex */
public final class MessageContentContainer extends LinearLayout {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final CotHeaderDurationStore cotHeaderDurations = new CotHeaderDurationStore(0, 1, null);
    private static volatile boolean imagePreviewLauncherRegistered;
    private final String BIZ_CHANNEL_ICON_KEY;
    private String TAG;
    private boolean allowTextSelection;
    private String appUiTerminatedForMessageId;
    private boolean cotExposureDirty;
    private final List<Pair<View, InterfaceC5063a<Y8.t>>> cotExposureTargets;
    private final ViewTreeObserver.OnPreDrawListener cotPreDrawListener;
    private final Rect cotVisibleRect;
    private final boolean hideGuiAgentCard;
    private int horizontalContentInsetPx;

    /* renamed from: interMessageComponentSpacingPx$delegate, reason: from kotlin metadata */
    private final Y8.h interMessageComponentSpacingPx;
    private String lastRenderedStructureSignature;
    private float lastTouchOffsetX;
    private float lastTouchOffsetY;
    private DisplayMessage message;
    private InterfaceC5063a<Y8.t> onToolGroupHeaderClick;
    private p9.q<? super DisplayMessage, ? super String, ? super Integer, Y8.t> onToolLikeStatusChangedListener;
    private final InterfaceC5063a<Y8.t> onToolNameMapLoaded;
    private float receiveMessageLineSpacingMultiplier;
    private int receiveMessageTextColor;
    private float receiveMessageTextSizeSp;
    private final C6360f renderLogLimiter;
    private int sentItemBg;
    private AgentUIConfig.TextStyle sentTextStyle;
    private boolean showToolActionLayout;
    private boolean showToolExecuteView;
    private S sourcesCapsule;
    private C2069d0 sourcesPopup;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/stepos/agentframework/chatui/view/MessageContentContainer$a;", "", "<init>", "()V", "LY8/t;", Const.INTENT_KEY_UMID, "Lcom/stepos/agentframework/chatui/view/CotHeaderDurationStore;", "cotHeaderDurations", "Lcom/stepos/agentframework/chatui/view/CotHeaderDurationStore;", "", "imagePreviewLauncherRegistered", "Z", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatui.view.MessageContentContainer$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public static final Y8.t e(View view, List urls, int i10) {
            kotlin.jvm.internal.p.i(view, "view");
            kotlin.jvm.internal.p.i(urls, "urls");
            if (urls.isEmpty()) {
                return Y8.t.f7040a;
            }
            View rootView = view.getRootView();
            ViewGroup viewGroup = rootView instanceof ViewGroup ? (ViewGroup) rootView : null;
            if (viewGroup != null) {
                Context context = view.getContext();
                kotlin.jvm.internal.p.h(context, "getContext(...)");
                final com.stepos.agentframework.util.u uVar = new com.stepos.agentframework.util.u(context, urls, i10, viewGroup, true, false, 32, null);
                uVar.W(new InterfaceC5063a() { // from class: com.stepos.agentframework.chatui.view.K
                    @Override // p9.InterfaceC5063a
                    public final Object invoke() {
                        return MessageContentContainer.Companion.f(uVar);
                    }
                });
                uVar.X();
            } else {
                AgentImagePreviewActivity.Companion aVar = AgentImagePreviewActivity.INSTANCE;
                Context context2 = view.getContext();
                kotlin.jvm.internal.p.h(context2, "getContext(...)");
                aVar.a(context2, i10, urls, true);
            }
            return Y8.t.f7040a;
        }

        public static final Y8.t f(com.stepos.agentframework.util.u uVar) {
            uVar.D();
            return Y8.t.f7040a;
        }

        public final void d() {
            if (MessageContentContainer.imagePreviewLauncherRegistered) {
                return;
            }
            MessageContentContainer.imagePreviewLauncherRegistered = true;
            MarkwonHelper.s0(new p9.q() { // from class: com.stepos.agentframework.chatui.view.J
                @Override // p9.q
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return MessageContentContainer.Companion.e((View) obj, (List) obj2, ((Integer) obj3).intValue());
                }
            });
        }

        public Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[HeldCardFlushPolicy.Decision.values().length];
            try {
                iArr[HeldCardFlushPolicy.Decision.FLUSH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[HeldCardFlushPolicy.Decision.DROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[HeldCardFlushPolicy.Decision.HOLD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[AgentMessageType.values().length];
            try {
                iArr2[AgentMessageType.THINKING_TEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[AgentMessageType.TEXT.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[AgentMessageType.TOOL.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[AgentMessageType.TASK.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[AgentMessageType.FILE.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[AgentMessageType.FOLDER.ordinal()] = 6;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"com/stepos/agentframework/chatui/view/MessageContentContainer$c", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "", "onPreDraw", "()Z", "LY8/t;", Const.INTENT_KEY_APIKEY, "()V", "consumed", "Z", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c implements ViewTreeObserver.OnPreDrawListener {
        final /* synthetic */ View $capsule;
        final /* synthetic */ int $targetLeftPx;
        final /* synthetic */ ViewTreeObserver $vto;
        private boolean consumed;
        final /* synthetic */ MessageContentContainer this$0;

        public c(View view, int i10, MessageContentContainer messageContentContainer, ViewTreeObserver viewTreeObserver) {
            this.$capsule = view;
            this.$targetLeftPx = i10;
            this.this$0 = messageContentContainer;
            this.$vto = viewTreeObserver;
        }

        public final void a() {
            if (this.$vto.isAlive()) {
                this.$vto.removeOnPreDrawListener(this);
            }
            ViewTreeObserver viewTreeObserver = this.$capsule.getViewTreeObserver();
            if (viewTreeObserver == this.$vto || !viewTreeObserver.isAlive()) {
                return;
            }
            viewTreeObserver.removeOnPreDrawListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (this.consumed) {
                return true;
            }
            this.consumed = true;
            a();
            if (!this.$capsule.isAttachedToWindow()) {
                return true;
            }
            View view = this.$capsule;
            int left = 0;
            while (true) {
                if (view == null) {
                    break;
                }
                left += view.getLeft();
                Object parent = view.getParent();
                view = parent instanceof View ? (View) parent : null;
            }
            int i10 = this.$targetLeftPx - left;
            if (i10 == 0) {
                return true;
            }
            int iAbs = Math.abs(i10);
            O6.d dVar = O6.d.INSTANCE;
            Context context = this.this$0.getContext();
            kotlin.jvm.internal.p.h(context, "getContext(...)");
            if (iAbs > dVar.a(context, 60.0f)) {
                C4148a.u(this.this$0.TAG, "sources capsule align skipped, abnormal delta=" + i10, false, 4, null);
                return true;
            }
            ViewGroup.LayoutParams layoutParams = this.$capsule.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
            if (marginLayoutParams == null) {
                return true;
            }
            marginLayoutParams.leftMargin += i10;
            this.$capsule.setLayoutParams(marginLayoutParams);
            return false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageContentContainer(final Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.p.i(context, "context");
        this.renderLogLimiter = new C6360f(16, 0L, 2, null);
        INSTANCE.d();
        this.TAG = "MessageContentContainer";
        this.BIZ_CHANNEL_ICON_KEY = "bizChannelIcon";
        this.cotExposureDirty = true;
        this.cotExposureTargets = new ArrayList();
        this.cotVisibleRect = new Rect();
        this.cotPreDrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: com.stepos.agentframework.chatui.view.C
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                return MessageContentContainer.K(this.f23084a);
            }
        };
        this.showToolExecuteView = true;
        this.receiveMessageTextColor = -1;
        this.receiveMessageTextSizeSp = -1.0f;
        this.receiveMessageLineSpacingMultiplier = 1.6f;
        this.sentItemBg = -1;
        this.allowTextSelection = true;
        this.hideGuiAgentCard = true;
        this.interMessageComponentSpacingPx = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.agentframework.chatui.view.D
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Integer.valueOf(MessageContentContainer.e0(context));
            }
        });
        InterfaceC5063a<Y8.t> interfaceC5063a = new InterfaceC5063a() { // from class: com.stepos.agentframework.chatui.view.E
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return MessageContentContainer.s0(this.f23088a);
            }
        };
        this.onToolNameMapLoaded = interfaceC5063a;
        setOrientation(1);
        ToolNameMapping.INSTANCE.k(interfaceC5063a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [T, android.view.View, com.stepos.agentframework.chatui.view.q] */
    public static final C2087q B0(Ref$ObjectRef<C2087q> ref$ObjectRef, final MessageContentContainer messageContentContainer) {
        C2087q c2087q = ref$ObjectRef.f34820a;
        if (c2087q != null) {
            return c2087q;
        }
        Context context = messageContentContainer.getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        final ?? c2087q2 = new C2087q(context);
        c2087q2.setOnHeaderClick(new InterfaceC5063a() { // from class: com.stepos.agentframework.chatui.view.z
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return MessageContentContainer.C0(this.f23153a, c2087q2);
            }
        });
        c2087q2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        ref$ObjectRef.f34820a = c2087q2;
        messageContentContainer.addView((View) c2087q2, 0);
        return c2087q2;
    }

    public static final Y8.t C0(MessageContentContainer messageContentContainer, C2087q c2087q) {
        InterfaceC5063a<Y8.t> interfaceC5063a = messageContentContainer.onToolGroupHeaderClick;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
        messageContentContainer.G0(CotTracker.Section.RESULT, !c2087q.getIsExpand());
        return Y8.t.f7040a;
    }

    public static final boolean D(DisplayChatMessage it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.getType() == AgentMessageType.TOOL;
    }

    public static final Y8.t D0(MessageContentContainer messageContentContainer, m.FileMessage f10) {
        kotlin.jvm.internal.p.i(f10, "f");
        messageContentContainer.t0(f10);
        return Y8.t.f7040a;
    }

    public static final Ka.j E(DisplayChatMessage it) {
        kotlin.jvm.internal.p.i(it, "it");
        List<DisplayTool> listF = it.f();
        if (listF == null) {
            listF = C1173v.m();
        }
        return Z8.F.d0(listF);
    }

    public static final Y8.t E0(MessageContentContainer messageContentContainer, m.FileMessage f10) {
        kotlin.jvm.internal.p.i(f10, "f");
        messageContentContainer.t0(f10);
        return Y8.t.f7040a;
    }

    public static final Y8.t I0(MessageContentContainer messageContentContainer, m.FileMessage f10) {
        kotlin.jvm.internal.p.i(f10, "f");
        messageContentContainer.t0(f10);
        return Y8.t.f7040a;
    }

    public static final Y8.t J0(MessageContentContainer messageContentContainer, m.FileMessage f10) {
        kotlin.jvm.internal.p.i(f10, "f");
        messageContentContainer.t0(f10);
        return Y8.t.f7040a;
    }

    public static final boolean K(MessageContentContainer messageContentContainer) {
        if (messageContentContainer.cotExposureDirty) {
            messageContentContainer.v0();
            messageContentContainer.cotExposureDirty = false;
        }
        Iterator<Pair<View, InterfaceC5063a<Y8.t>>> it = messageContentContainer.cotExposureTargets.iterator();
        while (it.hasNext()) {
            Pair<View, InterfaceC5063a<Y8.t>> next = it.next();
            View viewA = next.a();
            InterfaceC5063a<Y8.t> interfaceC5063aB = next.b();
            if (messageContentContainer.f0(viewA)) {
                interfaceC5063aB.invoke();
                it.remove();
            }
        }
        return true;
    }

    public static final Y8.t N(MessageContentContainer messageContentContainer, ToolExecuteGroupView toolExecuteGroupView) {
        InterfaceC5063a<Y8.t> interfaceC5063a = messageContentContainer.onToolGroupHeaderClick;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
        messageContentContainer.G0(CotTracker.Section.TOOLCALL, !toolExecuteGroupView.getIsExpand());
        return Y8.t.f7040a;
    }

    public static final Y8.t O(MessageContentContainer messageContentContainer, boolean z10) {
        messageContentContainer.G0(CotTracker.Section.TOOLCALL, z10);
        return Y8.t.f7040a;
    }

    public static final void O0(Ref$IntRef ref$IntRef, Ref$BooleanRef ref$BooleanRef, Set<Integer> set, int i10) {
        int i11 = ref$IntRef.f34818a;
        if (i11 >= 0 && ref$BooleanRef.f34815a) {
            while (i11 < i10) {
                set.add(Integer.valueOf(i11));
                i11++;
            }
        }
        ref$IntRef.f34818a = -1;
        ref$BooleanRef.f34815a = false;
    }

    public static final Y8.t P(MessageContentContainer messageContentContainer, String toolCallId, int i10) {
        p9.q<? super DisplayMessage, ? super String, ? super Integer, Y8.t> qVar;
        kotlin.jvm.internal.p.i(toolCallId, "toolCallId");
        DisplayMessage displayMessage = messageContentContainer.message;
        if (displayMessage != null && (qVar = messageContentContainer.onToolLikeStatusChangedListener) != null) {
            qVar.invoke(displayMessage, toolCallId, Integer.valueOf(i10));
        }
        return Y8.t.f7040a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void Y(MessageContentContainer messageContentContainer, List list, List list2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            list2 = C1173v.m();
        }
        messageContentContainer.X(list, list2);
    }

    public static final int e0(Context context) {
        return O6.d.INSTANCE.a(context, 16.0f);
    }

    private final int getInterMessageComponentSpacingPx() {
        return ((Number) this.interMessageComponentSpacingPx.getValue()).intValue();
    }

    public static final Y8.t l0(MessageContentContainer messageContentContainer, S s10, List list) {
        messageContentContainer.L0(s10, list);
        return Y8.t.f7040a;
    }

    public static final CharSequence n0(DisplayChatMessage it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.getType().name();
    }

    public static final Y8.t s0(MessageContentContainer messageContentContainer) throws Exception {
        messageContentContainer.y0();
        return Y8.t.f7040a;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01c8 A[EDGE_INSN: B:279:0x01c8->B:71:0x01c8 BREAK  A[LOOP:10: B:63:0x01ab->B:280:?]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void setMessageContent(com.stepos.agentframework.chatui.DisplayMessage r28) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 1455
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatui.view.MessageContentContainer.setMessageContent(com.stepos.agentframework.chatui.N1):void");
    }

    public static final Y8.t w0(DisplayMessage displayMessage) {
        CotTracker.INSTANCE.a().h(displayMessage);
        return Y8.t.f7040a;
    }

    public static final Y8.t x0(DisplayMessage displayMessage, DisplayTool displayTool) {
        CotTracker.INSTANCE.a().k(displayMessage, displayTool);
        return Y8.t.f7040a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean y(MessageContentContainer messageContentContainer, String str, AppUIData appUIData, List list, Integer num, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            list = C1173v.m();
        }
        if ((i10 & 8) != 0) {
            num = null;
        }
        return messageContentContainer.x(str, appUIData, list, num);
    }

    public final List<AssistantDocumentCardView> A() {
        ArrayList arrayList = new ArrayList();
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            AssistantDocumentCardView assistantDocumentCardView = childAt instanceof AssistantDocumentCardView ? (AssistantDocumentCardView) childAt : null;
            if (assistantDocumentCardView != null) {
                arrayList.add(assistantDocumentCardView);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0099 A[EDGE_INSN: B:239:0x0099->B:30:0x0099 BREAK  A[LOOP:9: B:22:0x007b->B:240:?]] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0182  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A0(com.stepos.agentframework.chatui.DisplayMessage r28, java.util.Set<java.lang.Integer> r29, java.util.List<com.stepos.agentframework.chatui.appui.taskrobot.RobotAppUIHostView> r30, java.util.List<? extends com.stepos.agentframework.chatui.appui.BaseAppUIHostView> r31, java.lang.Boolean r32, java.util.Map<java.lang.String, java.lang.Boolean> r33) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 1020
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatui.view.MessageContentContainer.A0(com.stepos.agentframework.chatui.N1, java.util.Set, java.util.List, java.util.List, java.lang.Boolean, java.util.Map):void");
    }

    public final List<Pair<String, AppUIData>> B(DisplayMessage message) {
        List<DisplayTool> listF;
        ArrayList arrayList = new ArrayList();
        for (DisplayChatMessage displayChatMessage : message.m()) {
            if (displayChatMessage.getType() == AgentMessageType.TOOL && (listF = displayChatMessage.f()) != null) {
                for (DisplayTool displayTool : listF) {
                    AppUIData appUIData = displayTool.getAppUIData();
                    if (appUIData != null && !appUIData.isFixed() && appUIData.getHoldUntilComplete()) {
                        C(message, displayTool, appUIData, arrayList);
                    }
                }
            }
        }
        return arrayList;
    }

    public final void C(DisplayMessage message, DisplayTool tool, AppUIData data, List<Pair<String, AppUIData>> heldCards) {
        HeldCardFlushPolicy heldCardFlushPolicy = HeldCardFlushPolicy.INSTANCE;
        int i10 = b.$EnumSwitchMapping$0[heldCardFlushPolicy.b(message.getStatus(), data.getAppUIName(), tool.getIsFinished(), heldCardFlushPolicy.a(SequencesKt___SequencesKt.L(SequencesKt___SequencesKt.F(Z8.F.d0(message.m()), new InterfaceC5074l() { // from class: com.stepos.agentframework.chatui.view.F
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(MessageContentContainer.D((DisplayChatMessage) obj));
            }
        }), new InterfaceC5074l() { // from class: com.stepos.agentframework.chatui.view.G
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return MessageContentContainer.E((DisplayChatMessage) obj);
            }
        })), message.getReleaseHeldCards()).ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                return;
            }
            C4148a.u(this.TAG, "hold card dropped on terminal=" + message.getStatus() + " messageId=" + message.getMessageId() + " toolCallId=" + tool.getToolCallId() + " appUIName=" + data.getAppUIName(), false, 4, null);
            return;
        }
        if (message.getStatus() != EReplyStatus.COMPLETED) {
            C4148a.k(this.TAG, "hold card flush early status=" + message.getStatus() + " messageId=" + message.getMessageId() + " toolCallId=" + tool.getToolCallId() + " appUIName=" + data.getAppUIName() + " force=" + message.getReleaseHeldCards(), false, 4, null);
        }
        heldCards.add(Y8.j.a(tool.getToolCallId(), data));
    }

    public final List<BaseAppUIHostView> F(Set<String> liveFlags) {
        BaseAppUIHostView baseAppUIHostView;
        String flag;
        if (liveFlags.isEmpty() || getChildCount() == 0) {
            return C1173v.m();
        }
        ArrayList arrayList = new ArrayList();
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (((childAt instanceof LocalAppUIHostView) || (childAt instanceof RemoteAppUIHostView)) && (flag = (baseAppUIHostView = (BaseAppUIHostView) childAt).getFlag()) != null && liveFlags.contains(flag) && z(baseAppUIHostView)) {
                arrayList.add(baseAppUIHostView);
            }
        }
        return arrayList;
    }

    public final void F0(String phase, DisplayMessage current, long elapsedMs, boolean completed) {
        C6360f.Sample sampleA = this.renderLogLimiter.a(current.getSessionId() + "/" + current.getMessageId() + "/" + phase + "/slow=" + (elapsedMs >= 8), String.valueOf(completed), SystemClock.elapsedRealtime());
        if (sampleA == null) {
            return;
        }
        LongTextShape longTextShapeA = LongTextShape.INSTANCE.a(current);
        if (longTextShapeA.b() || elapsedMs >= 8 || !completed) {
            C4148a.d(this.TAG, "long text content sessionId=" + current.getSessionId() + " messageId=" + current.getMessageId() + " phase=" + phase + " elapsedMs=" + elapsedMs + " completed=" + completed + " children=" + getChildCount() + " width=" + getMeasuredWidth() + " height=" + getMeasuredHeight() + " count=" + sampleA.getCount() + " suppressed=" + sampleA.getSuppressed() + " " + longTextShapeA.a(), false, 4, null);
        }
    }

    public final List<RobotAppUIHostView> G() {
        if (getChildCount() == 0) {
            return C1173v.m();
        }
        ArrayList arrayList = new ArrayList();
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if ((childAt instanceof RobotAppUIHostView) && ((RobotAppUIHostView) childAt).W()) {
                arrayList.add(childAt);
            }
        }
        return arrayList;
    }

    public final void G0(CotTracker.Section section, boolean expanded) {
        this.cotExposureDirty = true;
        DisplayMessage displayMessage = this.message;
        if (displayMessage != null) {
            CotTracker.INSTANCE.a().d(displayMessage, section, expanded);
        }
    }

    public final List<AIMDTextView> H() {
        ArrayList arrayList = new ArrayList();
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt instanceof AIMDTextView) {
                arrayList.add(childAt);
            } else if (childAt instanceof C2087q) {
                arrayList.addAll(((C2087q) childAt).s());
            }
        }
        return arrayList;
    }

    public final String H0(String agentId, String raw) {
        return com.stepos.agentframework.chatui.util.a.INSTANCE.a(agentId, com.stepos.agentframework.chatui.util.r.INSTANCE.a(raw));
    }

    public final List<ToolExecuteGroupView> I() {
        ArrayList arrayList = new ArrayList();
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt instanceof ToolExecuteGroupView) {
                arrayList.add(childAt);
            } else if (childAt instanceof C2087q) {
                arrayList.addAll(((C2087q) childAt).t());
            }
        }
        return arrayList;
    }

    public final MarkdownBlockSpacing.Kind J(View view, boolean first) {
        if (view instanceof AIMDTextView) {
            return ((AIMDTextView) view).v0(first);
        }
        if (view instanceof AssistantImageCardView) {
            return MarkdownBlockSpacing.Kind.IMAGE;
        }
        if ((view instanceof BaseAppUIHostView) || (view instanceof WebAppUiView) || (view instanceof C2066c) || (view instanceof AssistantDocumentCardView) || (view instanceof C2070e) || (view instanceof M)) {
            return MarkdownBlockSpacing.Kind.ARTIFACT;
        }
        return null;
    }

    public final boolean K0(DisplayMessage message) {
        if (this.showToolExecuteView) {
            return (message.getStatus() == EReplyStatus.COMPLETED || message.getStatus() == EReplyStatus.CANCELED || message.getStatus() == EReplyStatus.ERROR) && i0(message) >= 0;
        }
        return false;
    }

    public final LinearLayout.LayoutParams L(View hostView) {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public final void L0(S anchor, List<ReferenceSource> sources) {
        C2069d0 c2069d0 = this.sourcesPopup;
        if (c2069d0 == null || !c2069d0.z()) {
            if (c2069d0 == null) {
                Context context = getContext();
                kotlin.jvm.internal.p.h(context, "getContext(...)");
                c2069d0 = new C2069d0(context);
                this.sourcesPopup = c2069d0;
            }
            c2069d0.G(anchor, sources);
        }
    }

    public final ToolExecuteGroupView M() {
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        final ToolExecuteGroupView toolExecuteGroupView = new ToolExecuteGroupView(context);
        toolExecuteGroupView.setOnHeaderClick(new InterfaceC5063a() { // from class: com.stepos.agentframework.chatui.view.t
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return MessageContentContainer.N(this.f23142a, toolExecuteGroupView);
            }
        });
        toolExecuteGroupView.setOnToolExpansionClick(new InterfaceC5074l() { // from class: com.stepos.agentframework.chatui.view.u
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return MessageContentContainer.O(this.f23145a, ((Boolean) obj).booleanValue());
            }
        });
        toolExecuteGroupView.setWithToolActionLayout(this.showToolActionLayout);
        toolExecuteGroupView.setReceiveTextColor(this.receiveMessageTextColor);
        toolExecuteGroupView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        toolExecuteGroupView.setOnLikeClickedListener(new p9.p() { // from class: com.stepos.agentframework.chatui.view.v
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return MessageContentContainer.P(this.f23146a, (String) obj, ((Integer) obj2).intValue());
            }
        });
        return toolExecuteGroupView;
    }

    public final boolean M0(DisplayTool tool) {
        return tool.D();
    }

    public final Set<Integer> N0(DisplayMessage message) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.f34818a = -1;
        Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        int i10 = 0;
        for (Object obj : message.m()) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            DisplayChatMessage displayChatMessage = (DisplayChatMessage) obj;
            if (displayChatMessage.getType() == AgentMessageType.TOOL) {
                if (ref$IntRef.f34818a < 0) {
                    ref$IntRef.f34818a = i10;
                }
                if (displayChatMessage.getHiddenToolExecuteView()) {
                    ref$BooleanRef.f34815a = true;
                }
            } else {
                O0(ref$IntRef, ref$BooleanRef, linkedHashSet, i10);
            }
            i10 = i11;
        }
        O0(ref$IntRef, ref$BooleanRef, linkedHashSet, message.m().size());
        return linkedHashSet;
    }

    public final void P0(DisplayMessage message) throws Exception {
        List<DisplayTool> listF;
        DisplayTool displayTool;
        DisplayTool displayToolPrevious;
        List<ToolExecuteGroupView> listI = I();
        if (listI.isEmpty()) {
            return;
        }
        Set<Integer> setN0 = N0(message);
        ArrayList arrayList = new ArrayList();
        AgentMessageType type = null;
        int i10 = 0;
        for (Object obj : message.m()) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            DisplayChatMessage displayChatMessage = (DisplayChatMessage) obj;
            if (displayChatMessage.getType() == AgentMessageType.TOOL && (listF = displayChatMessage.f()) != null && !listF.isEmpty() && !setN0.contains(Integer.valueOf(i10))) {
                List<DisplayTool> listF2 = displayChatMessage.f();
                if (listF2 != null) {
                    ListIterator<DisplayTool> listIterator = listF2.listIterator(listF2.size());
                    while (true) {
                        if (listIterator.hasPrevious()) {
                            displayToolPrevious = listIterator.previous();
                            if (M0(displayToolPrevious)) {
                                break;
                            }
                        } else {
                            displayToolPrevious = null;
                            break;
                        }
                    }
                    displayTool = displayToolPrevious;
                } else {
                    displayTool = null;
                }
                if (displayTool != null) {
                    if (type != AgentMessageType.TOOL) {
                        arrayList.add(displayTool);
                    } else if (!arrayList.isEmpty()) {
                        arrayList.set(C1173v.o(arrayList), displayTool);
                    }
                }
            }
            type = displayChatMessage.getType();
            i10 = i11;
        }
        if (message.getStatus() == EReplyStatus.COMPLETED || message.getStatus() == EReplyStatus.ERROR) {
            Iterator<T> it = listI.iterator();
            while (it.hasNext()) {
                ToolExecuteGroupView.D((ToolExecuteGroupView) it.next(), false, false, 2, null);
            }
            return;
        }
        DisplayChatMessage displayChatMessage2 = (DisplayChatMessage) Z8.F.E0(message.m());
        if (displayChatMessage2 == null) {
            Iterator<T> it2 = listI.iterator();
            while (it2.hasNext()) {
                ToolExecuteGroupView.D((ToolExecuteGroupView) it2.next(), false, false, 2, null);
            }
            return;
        }
        int iO = (displayChatMessage2.getType() != AgentMessageType.TOOL || setN0.contains(Integer.valueOf(C1173v.o(message.m())))) ? -1 : C1173v.o(arrayList);
        if (message.getStatus() == EReplyStatus.CANCELED) {
            int i12 = 0;
            for (Object obj2 : listI) {
                int i13 = i12 + 1;
                if (i12 < 0) {
                    C1173v.w();
                }
                ToolExecuteGroupView toolExecuteGroupView = (ToolExecuteGroupView) obj2;
                if (i12 == iO) {
                    toolExecuteGroupView.E(false);
                } else {
                    ToolExecuteGroupView.D(toolExecuteGroupView, false, false, 2, null);
                }
                i12 = i13;
            }
            return;
        }
        int i14 = 0;
        for (Object obj3 : listI) {
            int i15 = i14 + 1;
            if (i14 < 0) {
                C1173v.w();
            }
            ToolExecuteGroupView toolExecuteGroupView2 = (ToolExecuteGroupView) obj3;
            if (i14 == iO) {
                DisplayTool displayTool2 = (DisplayTool) Z8.F.t0(arrayList, i14);
                if (displayTool2 == null || displayTool2.getIsFinished()) {
                    toolExecuteGroupView2.C(false, false);
                } else {
                    toolExecuteGroupView2.B(displayTool2.getName(), displayTool2.getParameter(), displayTool2.getDisplayName(), message.F());
                }
            } else {
                ToolExecuteGroupView.D(toolExecuteGroupView2, false, false, 2, null);
            }
            i14 = i15;
        }
    }

    public final Pair<Float, Float> Q() {
        getLocationOnScreen(new int[2]);
        return Y8.j.a(Float.valueOf(r0[0] + this.lastTouchOffsetX), Float.valueOf(r0[1] + this.lastTouchOffsetY));
    }

    public final AppUIData Q0(m.TaskMessage taskMessage) {
        int iA = AppUIData.INSTANCE.a();
        String strK = taskMessage.k();
        String packageName = ChatCoreSdk.INSTANCE.c().getPackageName();
        kotlin.jvm.internal.p.h(packageName, "getPackageName(...)");
        String taskId = taskMessage.getTaskId();
        if (taskId == null) {
            taskId = "";
        }
        return new AppUIData(null, iA, null, false, strK, null, null, taskId, null, null, packageName, null, null, null, false, false, 64365, null);
    }

    public final void R(List<Pair<String, AppUIData>> heldCards) {
        int iNextIndex;
        Object objB;
        ListIterator<Pair<String, AppUIData>> listIterator = heldCards.listIterator(heldCards.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                iNextIndex = -1;
                break;
            }
            Object structuredContent = listIterator.previous().b().getStructuredContent();
            Map map = structuredContent instanceof Map ? (Map) structuredContent : null;
            if ((map != null ? map.get(this.BIZ_CHANNEL_ICON_KEY) : null) != null) {
                iNextIndex = listIterator.nextIndex();
                break;
            }
        }
        if (iNextIndex < 0) {
            return;
        }
        int i10 = 0;
        for (Object obj : heldCards) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            AppUIData appUIData = (AppUIData) ((Pair) obj).b();
            if (i10 != iNextIndex) {
                Object structuredContent2 = appUIData.getStructuredContent();
                Map map2 = structuredContent2 instanceof Map ? (Map) structuredContent2 : null;
                if (map2 != null && map2.containsKey(this.BIZ_CHANNEL_ICON_KEY)) {
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        kotlin.jvm.internal.p.g(map2, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.Any?>");
                        objB = Result.b(kotlin.jvm.internal.z.d(map2).remove(this.BIZ_CHANNEL_ICON_KEY));
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.INSTANCE;
                        objB = Result.b(C4849c.a(th));
                    }
                    if (!Result.h(objB)) {
                        LinkedHashMap linkedHashMap = new LinkedHashMap(map2);
                        linkedHashMap.remove(this.BIZ_CHANNEL_ICON_KEY);
                        appUIData.setStructuredContent(linkedHashMap);
                    }
                }
            }
            i10 = i11;
        }
    }

    public final boolean R0(DisplayMessage message) {
        int i10;
        List<AIMDTextView> listH = H();
        List<DisplayChatMessage> listM = message.m();
        if ((listM instanceof Collection) && listM.isEmpty()) {
            i10 = 0;
        } else {
            Iterator<T> it = listM.iterator();
            i10 = 0;
            while (it.hasNext()) {
                if (((DisplayChatMessage) it.next()).getType() == AgentMessageType.TEXT && (i10 = i10 + 1) < 0) {
                    C1173v.v();
                }
            }
        }
        if (listH.size() != i10) {
            setMessage(message);
            return true;
        }
        int i11 = 0;
        for (DisplayChatMessage displayChatMessage : message.m()) {
            if (displayChatMessage.getType() == AgentMessageType.TEXT) {
                boolean zIsTerminal = message.getStatus().isTerminal();
                if (!zIsTerminal) {
                    listH.get(i11).setStreaming(true);
                }
                listH.get(i11).setMarkdown(H0(message.getAgentId(), displayChatMessage.getContent().h()));
                listH.get(i11).setTableHorizontalScrollEnabled(true);
                if (zIsTerminal) {
                    listH.get(i11).setStreaming(false);
                    if (message.getStatus() == EReplyStatus.COMPLETED || message.getStatus() == EReplyStatus.CANCELED) {
                        listH.get(i11).X0();
                    }
                }
                i11++;
            }
        }
        return false;
    }

    public final AppUIData S(AppUIData data, DisplayMessage message) {
        List<String> listE;
        String strC = q4.j.INSTANCE.C(data);
        if (strC == null) {
            return data;
        }
        if (message.getStatus().isTerminal()) {
            listE = C1173v.m();
        } else {
            List<DisplayChatMessage> listM = message.m();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = listM.iterator();
            while (it.hasNext()) {
                List<DisplayTool> listF = ((DisplayChatMessage) it.next()).f();
                if (listF == null) {
                    listF = C1173v.m();
                }
                List<DisplayTool> list = listF;
                ArrayList arrayList2 = new ArrayList(C1174w.x(list, 10));
                for (DisplayTool displayTool : list) {
                    arrayList2.add(new AgentTool(displayTool.getToolCallId(), null, displayTool.getName(), null, null, displayTool.getParameter(), null, displayTool.getIsFinished(), null, displayTool.getResult(), displayTool.getAppUIData(), null, null, 0, false, null, 0, 0L, false, 522586, null));
                }
                Z8.A.E(arrayList, arrayList2);
            }
            listE = q4.j.INSTANCE.E(arrayList, strC);
        }
        q4.j.INSTANCE.u(data, listE);
        return data;
    }

    public final void S0(DisplayMessage message) {
        kotlin.jvm.internal.p.i(message, "message");
        long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        Trace.beginSection("Chat.messageContent." + com.stepos.ailauncher.chat.trace.a.BUTTON_UPDATE);
        try {
            T0(message);
            Trace.endSection();
            F0(com.stepos.ailauncher.chat.trace.a.BUTTON_UPDATE, message, (SystemClock.elapsedRealtimeNanos() - jElapsedRealtimeNanos) / 1000000, true);
        } catch (Throwable th) {
            Trace.endSection();
            F0(com.stepos.ailauncher.chat.trace.a.BUTTON_UPDATE, message, (SystemClock.elapsedRealtimeNanos() - jElapsedRealtimeNanos) / 1000000, false);
            throw th;
        }
    }

    public final int T(DisplayMessage message) {
        List<DisplayTool> listF;
        Set<Integer> setN0 = N0(message);
        int i10 = 0;
        AgentMessageType type = null;
        int i11 = 0;
        for (Object obj : message.m()) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                C1173v.w();
            }
            DisplayChatMessage displayChatMessage = (DisplayChatMessage) obj;
            if (displayChatMessage.getType() == AgentMessageType.TOOL && (listF = displayChatMessage.f()) != null && !listF.isEmpty() && !setN0.contains(Integer.valueOf(i11))) {
                List<DisplayTool> listF2 = displayChatMessage.f();
                kotlin.jvm.internal.p.f(listF2);
                List<DisplayTool> list = listF2;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    Iterator<T> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        if (M0((DisplayTool) it.next())) {
                            if (type != AgentMessageType.TOOL) {
                                i10++;
                            }
                        }
                    }
                }
            }
            type = displayChatMessage.getType();
            i11 = i12;
        }
        return i10;
    }

    public final void T0(DisplayMessage message) throws Exception {
        View viewA0;
        ArrayList arrayList;
        View viewA02;
        C2087q c2087qW;
        List list = null;
        CotTracker.j(CotTracker.INSTANCE.a(), message, null, 2, null);
        this.cotExposureDirty = true;
        int i10 = 0;
        if (message.getStatus() == EReplyStatus.COMPLETED || message.getStatus() == EReplyStatus.CANCELED || message.getStatus() == EReplyStatus.ERROR) {
            C4148a.d(this.TAG, "updateMessage id=" + message.getMessageId() + " status=" + message.getStatus() + " parts=" + message.m().size(), false, 4, null);
        }
        DisplayMessage displayMessage = this.message;
        if ((displayMessage != null ? displayMessage.getMessageId() : null) != null) {
            DisplayMessage displayMessage2 = this.message;
            if (!kotlin.jvm.internal.p.d(displayMessage2 != null ? displayMessage2.getMessageId() : null, message.getMessageId())) {
                setMessage(message);
                return;
            }
        }
        Long lC = CotHeaderDurationStore.c(cotHeaderDurations, message, 0L, 2, null);
        EReplyStatus status = message.getStatus();
        EReplyStatus eReplyStatus = EReplyStatus.CANCELED;
        if (status == eReplyStatus && message.getHint() == ChatHintType.STOPPED && (c2087qW = W()) != null) {
            c2087qW.r(lC, true);
        }
        this.message = message;
        if (message.getStatus() == eReplyStatus) {
            b0(message);
        } else {
            this.appUiTerminatedForMessageId = null;
        }
        if (K0(message) && W() == null) {
            setMessage(message);
            return;
        }
        if (!kotlin.jvm.internal.p.d(m0(message), this.lastRenderedStructureSignature)) {
            setMessage(message);
            return;
        }
        List<DisplayChatMessage> listM = message.m();
        if (!(listM instanceof Collection) || !listM.isEmpty()) {
            Iterator<T> it = listM.iterator();
            while (it.hasNext()) {
                if (((DisplayChatMessage) it.next()).getType() == AgentMessageType.TASK) {
                    setMessage(message);
                    return;
                }
            }
        }
        if (R0(message)) {
            Y(this, B(message), null, 2, null);
            return;
        }
        int iT = T(message);
        List<ToolExecuteGroupView> listI = I();
        if (this.showToolExecuteView && iT != listI.size()) {
            setMessage(message);
            return;
        }
        Set<Integer> setN0 = N0(message);
        ArrayList arrayList2 = new ArrayList();
        int i11 = -1;
        AgentMessageType type = null;
        for (Object obj : message.m()) {
            int i12 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            DisplayChatMessage displayChatMessage = (DisplayChatMessage) obj;
            if (displayChatMessage.getType() == AgentMessageType.TOOL) {
                List<DisplayTool> listF = displayChatMessage.f();
                if (listF != null) {
                    arrayList = new ArrayList();
                    for (Object obj2 : listF) {
                        if (M0((DisplayTool) obj2)) {
                            arrayList.add(obj2);
                        }
                    }
                } else {
                    arrayList = null;
                }
                if (this.showToolExecuteView && arrayList != null && !arrayList.isEmpty() && !setN0.contains(Integer.valueOf(i10))) {
                    if (type != AgentMessageType.TOOL) {
                        i11++;
                    }
                    ToolExecuteGroupView toolExecuteGroupView = (ToolExecuteGroupView) Z8.F.t0(listI, i11);
                    if (toolExecuteGroupView == null) {
                        setMessage(message);
                        return;
                    } else {
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            toolExecuteGroupView.L((DisplayTool) it2.next());
                        }
                    }
                }
                List<DisplayTool> listF2 = displayChatMessage.f();
                if (listF2 != null) {
                    for (DisplayTool displayTool : listF2) {
                        AppUIData appUIData = displayTool.getAppUIData();
                        if (appUIData != null && !appUIData.isFixed()) {
                            if (appUIData.getHoldUntilComplete()) {
                                C(message, displayTool, appUIData, arrayList2);
                            } else {
                                BaseAppUIHostView baseAppUIHostViewU = U(displayTool.getToolCallId(), appUIData.getUiType(), appUIData.getPackageName());
                                if (baseAppUIHostViewU != null) {
                                    baseAppUIHostViewU.e(displayTool.getToolCallId(), appUIData);
                                } else if (!g0(appUIData) && (viewA02 = a0(displayTool.getToolCallId(), appUIData)) != null) {
                                    addView(viewA02, L(viewA02));
                                }
                            }
                        }
                    }
                }
            } else {
                if (displayChatMessage.getType() == AgentMessageType.TASK) {
                    u4.m content = displayChatMessage.getContent();
                    m.TaskMessage taskMessage = content instanceof m.TaskMessage ? (m.TaskMessage) content : null;
                    if (taskMessage != null) {
                        if (kotlin.jvm.internal.p.d(taskMessage.k(), m.TaskMessage.defaultTaskCardAppUIName)) {
                            type = displayChatMessage.getType();
                        } else {
                            String taskId = taskMessage.getTaskId();
                            if (taskId == null) {
                                taskId = "";
                            }
                            if (La.H.x0(taskId)) {
                                taskId = message.getMessageId() + "_task_" + i10;
                            }
                            AppUIData appUIDataQ0 = Q0(taskMessage);
                            if (!V(taskId, appUIDataQ0.getUiType(), appUIDataQ0.getPackageName()) && !g0(appUIDataQ0) && (viewA0 = a0(taskId, appUIDataQ0)) != null) {
                                addView(viewA0, L(viewA0));
                            }
                        }
                    }
                }
                i10 = i12;
                list = null;
            }
            type = displayChatMessage.getType();
            i10 = i12;
            list = null;
        }
        List list2 = list;
        Y(this, arrayList2, list2, 2, list2);
        k0(message);
        w();
        P0(message);
    }

    public final BaseAppUIHostView U(String toolCallId, int uiType, String packageName) {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            AppUIData.Companion companion = AppUIData.INSTANCE;
            if (uiType == companion.c()) {
                if ((childAt instanceof RobotAppUIHostView) && kotlin.jvm.internal.p.d(((RobotAppUIHostView) childAt).getFlag(), toolCallId)) {
                    return (BaseAppUIHostView) childAt;
                }
            } else if (uiType == companion.e()) {
                if ((childAt instanceof com.stepos.agentframework.chatui.appui.l) && kotlin.jvm.internal.p.d(((com.stepos.agentframework.chatui.appui.l) childAt).getFlag(), toolCallId)) {
                    return (BaseAppUIHostView) childAt;
                }
            } else if (uiType != companion.a()) {
                continue;
            } else if (kotlin.jvm.internal.p.d(packageName, ChatCoreSdk.INSTANCE.c().getPackageName())) {
                if ((childAt instanceof LocalAppUIHostView) && kotlin.jvm.internal.p.d(((LocalAppUIHostView) childAt).getFlag(), toolCallId)) {
                    return (BaseAppUIHostView) childAt;
                }
            } else if ((childAt instanceof RemoteAppUIHostView) && kotlin.jvm.internal.p.d(((RemoteAppUIHostView) childAt).getFlag(), toolCallId)) {
                return (BaseAppUIHostView) childAt;
            }
        }
        return null;
    }

    public final boolean V(String toolCallId, int uiType, String packageName) {
        kotlin.jvm.internal.p.i(toolCallId, "toolCallId");
        kotlin.jvm.internal.p.i(packageName, "packageName");
        return U(toolCallId, uiType, packageName) != null;
    }

    public final C2087q W() {
        int childCount = getChildCount();
        int i10 = 0;
        while (true) {
            if (i10 >= childCount) {
                return null;
            }
            View childAt = getChildAt(i10);
            C2087q c2087q = childAt instanceof C2087q ? (C2087q) childAt : null;
            if (c2087q != null) {
                return c2087q;
            }
            i10++;
        }
    }

    public final void X(List<Pair<String, AppUIData>> heldCards, List<? extends BaseAppUIHostView> preservedCardHosts) {
        MessageContentContainer messageContentContainer;
        List<? extends BaseAppUIHostView> list;
        boolean zY;
        R(heldCards);
        Iterator<T> it = heldCards.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            String str = (String) pair.a();
            AppUIData appUIData = (AppUIData) pair.b();
            if (appUIData.getHoldAtTop()) {
                zY = this.x(str, appUIData, preservedCardHosts, Integer.valueOf(i10));
                messageContentContainer = this;
                list = preservedCardHosts;
            } else {
                messageContentContainer = this;
                list = preservedCardHosts;
                zY = y(messageContentContainer, str, appUIData, list, null, 8, null);
            }
            if (zY && appUIData.getHoldAtTop()) {
                i10++;
            }
            this = messageContentContainer;
            preservedCardHosts = list;
        }
    }

    public final int Z(DisplayMessage message) {
        List<DisplayChatMessage> listM = message.m();
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        for (Object obj : listM) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            Integer numValueOf = Integer.valueOf(i10);
            if (((DisplayChatMessage) obj).getType() != AgentMessageType.TEXT) {
                numValueOf = null;
            }
            if (numValueOf != null) {
                arrayList.add(numValueOf);
            }
            i10 = i11;
        }
        return H1.INSTANCE.a(arrayList, i0(message));
    }

    @SuppressLint({"SetTextI18n"})
    public final View a0(String flag, AppUIData appUIData) {
        AppUIData appUIDataS;
        String str;
        String requestSessionId;
        com.stepos.agentframework.chatui.appui.l lVar;
        String traceId;
        String sessionId;
        String requestSessionId2;
        DisplayMessage displayMessage;
        kotlin.jvm.internal.p.i(flag, "flag");
        kotlin.jvm.internal.p.i(appUIData, "appUIData");
        q4.j jVar = q4.j.INSTANCE;
        jVar.C(appUIData);
        if (jVar.C(appUIData) == null || (displayMessage = this.message) == null || (appUIDataS = S(appUIData, displayMessage)) == null) {
            appUIDataS = appUIData;
        }
        int uiType = appUIDataS.getUiType();
        AppUIData.Companion companion = AppUIData.INSTANCE;
        str = "";
        if (uiType == companion.c()) {
            if (this.hideGuiAgentCard) {
                return null;
            }
            Context context = getContext();
            kotlin.jvm.internal.p.h(context, "getContext(...)");
            RobotAppUIHostView robotAppUIHostView = new RobotAppUIHostView(context, null);
            robotAppUIHostView.e(flag, appUIDataS);
            DisplayMessage displayMessage2 = this.message;
            if (displayMessage2 == null || (traceId = displayMessage2.getTraceId()) == null) {
                traceId = "";
            }
            robotAppUIHostView.setTraceId(traceId);
            robotAppUIHostView.setToolCallId(flag);
            DisplayMessage displayMessage3 = this.message;
            if (displayMessage3 == null || (sessionId = displayMessage3.getSessionId()) == null) {
                sessionId = "";
            }
            robotAppUIHostView.setChatSessionId(sessionId);
            DisplayMessage displayMessage4 = this.message;
            if (displayMessage4 != null && (requestSessionId2 = displayMessage4.getRequestSessionId()) != null) {
                str = requestSessionId2;
            }
            robotAppUIHostView.setRequestSessionId(str);
            O6.d dVar = O6.d.INSTANCE;
            Context context2 = robotAppUIHostView.getContext();
            kotlin.jvm.internal.p.h(context2, "getContext(...)");
            robotAppUIHostView.X(dVar.a(context2, 130.0f));
            com.stepos.agentframework.chatui.appui.c.INSTANCE.a().c(flag, robotAppUIHostView);
            return robotAppUIHostView;
        }
        if (uiType == companion.e()) {
            c.Companion companion2 = com.stepos.agentframework.chatui.appui.c.INSTANCE;
            com.stepos.agentframework.chatui.appui.c cVarA = companion2.a();
            Context context3 = getContext();
            kotlin.jvm.internal.p.h(context3, "getContext(...)");
            View viewG = cVarA.g(context3, flag);
            if (viewG == null || !(viewG instanceof com.stepos.agentframework.chatui.appui.l)) {
                Context context4 = getContext();
                kotlin.jvm.internal.p.h(context4, "getContext(...)");
                lVar = new com.stepos.agentframework.chatui.appui.l(context4);
                lVar.e(flag, appUIDataS);
                companion2.a().c(flag, lVar);
            } else {
                z0(viewG);
                lVar = (com.stepos.agentframework.chatui.appui.l) viewG;
            }
            DisplayMessage displayMessage5 = this.message;
            String sessionId2 = displayMessage5 != null ? displayMessage5.getSessionId() : null;
            if (sessionId2 == null) {
                sessionId2 = "";
            }
            lVar.setChatSessionId(sessionId2);
            DisplayMessage displayMessage6 = this.message;
            requestSessionId = displayMessage6 != null ? displayMessage6.getRequestSessionId() : null;
            lVar.setRequestSessionId(requestSessionId != null ? requestSessionId : "");
            return lVar;
        }
        if (uiType != companion.a()) {
            if (uiType == companion.d()) {
                Context context5 = getContext();
                kotlin.jvm.internal.p.h(context5, "getContext(...)");
                WebAppUiView webAppUiView = new WebAppUiView(context5, null);
                webAppUiView.setGlobal(new AppUIGlobal(null, null, null, null, 15, null));
                webAppUiView.d(appUIDataS);
                return webAppUiView;
            }
            Context context6 = getContext();
            kotlin.jvm.internal.p.h(context6, "getContext(...)");
            com.stepos.agentframework.chatui.appui.h hVar = new com.stepos.agentframework.chatui.appui.h(context6);
            hVar.setText(appUIData.getUiType() + " 类型，待实现");
            return hVar;
        }
        c.Companion companion3 = com.stepos.agentframework.chatui.appui.c.INSTANCE;
        com.stepos.agentframework.chatui.appui.c cVarA2 = companion3.a();
        Context context7 = getContext();
        kotlin.jvm.internal.p.h(context7, "getContext(...)");
        BaseAppUIHostView baseAppUIHostViewG = cVarA2.g(context7, flag);
        boolean z10 = baseAppUIHostViewG instanceof LocalAppUIHostView;
        if (z10 || (baseAppUIHostViewG instanceof RemoteAppUIHostView)) {
            z0(baseAppUIHostViewG);
            if (z10) {
                LocalAppUIHostView localAppUIHostView = (LocalAppUIHostView) baseAppUIHostViewG;
                if (localAppUIHostView.getBridge() == null) {
                    localAppUIHostView.e(flag, appUIDataS);
                }
            }
        } else if (kotlin.jvm.internal.p.d(appUIDataS.getPackageName(), ChatCoreSdk.INSTANCE.c().getPackageName())) {
            Context context8 = getContext();
            kotlin.jvm.internal.p.h(context8, "getContext(...)");
            baseAppUIHostViewG = new LocalAppUIHostView(context8, null);
            companion3.a().c(flag, baseAppUIHostViewG);
            baseAppUIHostViewG.e(flag, appUIDataS);
        } else {
            Context context9 = getContext();
            kotlin.jvm.internal.p.h(context9, "getContext(...)");
            baseAppUIHostViewG = new RemoteAppUIHostView(context9, null);
            baseAppUIHostViewG.e(flag, appUIDataS);
            companion3.a().c(flag, baseAppUIHostViewG);
        }
        DisplayMessage displayMessage7 = this.message;
        String sessionId3 = displayMessage7 != null ? displayMessage7.getSessionId() : null;
        if (sessionId3 == null) {
            sessionId3 = "";
        }
        baseAppUIHostViewG.setChatSessionId(sessionId3);
        DisplayMessage displayMessage8 = this.message;
        requestSessionId = displayMessage8 != null ? displayMessage8.getRequestSessionId() : null;
        baseAppUIHostViewG.setRequestSessionId(requestSessionId != null ? requestSessionId : "");
        return baseAppUIHostViewG;
    }

    public final void b0(DisplayMessage message) {
        C4148a.k(this.TAG, "handleCanceledConversationAppUi messageId:" + message.getMessageId() + " appUiTerminatedForMessageId:" + this.appUiTerminatedForMessageId, false, 4, null);
        if (kotlin.jvm.internal.p.d(this.appUiTerminatedForMessageId, message.getMessageId())) {
            return;
        }
        r0(BaseAppUIHostView.TerminateReason.USER_CANCELED);
        this.appUiTerminatedForMessageId = message.getMessageId();
    }

    public final boolean c0(String flag) {
        if (flag.length() == 0) {
            return false;
        }
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (((childAt instanceof LocalAppUIHostView) || (childAt instanceof RemoteAppUIHostView)) && kotlin.jvm.internal.p.d(((BaseAppUIHostView) childAt).getFlag(), flag)) {
                return true;
            }
        }
        return false;
    }

    public final boolean d0() {
        return W() != null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        kotlin.jvm.internal.p.i(canvas, "canvas");
        DisplayMessage displayMessage = this.message;
        long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Chat.messageContent.");
        sb2.append("draw");
        Trace.beginSection(sb2.toString());
        try {
            super.dispatchDraw(canvas);
            Trace.endSection();
            long jElapsedRealtimeNanos2 = (SystemClock.elapsedRealtimeNanos() - jElapsedRealtimeNanos) / 1000000;
            if (displayMessage == null || jElapsedRealtimeNanos2 < 8) {
                return;
            }
            F0("draw", displayMessage, jElapsedRealtimeNanos2, true);
        } finally {
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent ev) {
        kotlin.jvm.internal.p.i(ev, "ev");
        if (ev.getActionMasked() == 0) {
            getLocationOnScreen(new int[2]);
            this.lastTouchOffsetX = ev.getRawX() - r0[0];
            this.lastTouchOffsetY = ev.getRawY() - r0[1];
        }
        return super.dispatchTouchEvent(ev);
    }

    public final boolean f0(View view) {
        if (view.isAttachedToWindow() && view.isShown() && view.getWindowVisibility() == 0) {
            View view2 = view;
            while (view2 != null) {
                if (view2.getAlpha() <= 0.0f) {
                    return false;
                }
                Object parent = view2.getParent();
                view2 = parent instanceof View ? (View) parent : null;
            }
            if (view.getGlobalVisibleRect(this.cotVisibleRect) && !this.cotVisibleRect.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public final boolean g0(AppUIData data) {
        String strC = q4.j.INSTANCE.C(data);
        if (strC == null) {
            return false;
        }
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            LocalAppUIHostView localAppUIHostView = childAt instanceof LocalAppUIHostView ? (LocalAppUIHostView) childAt : null;
            if (localAppUIHostView != null && kotlin.jvm.internal.p.d(q4.j.INSTANCE.C(localAppUIHostView.getAppUIData()), strC)) {
                return true;
            }
        }
        return false;
    }

    public final boolean getAllowTextSelection() {
        return this.allowTextSelection;
    }

    public final int getHorizontalContentInsetPx() {
        return this.horizontalContentInsetPx;
    }

    public final InterfaceC5063a<Y8.t> getOnToolGroupHeaderClick() {
        return this.onToolGroupHeaderClick;
    }

    public final p9.q<DisplayMessage, String, Integer, Y8.t> getOnToolLikeStatusChangedListener() {
        return this.onToolLikeStatusChangedListener;
    }

    public final float getReceiveMessageLineSpacingMultiplier() {
        return this.receiveMessageLineSpacingMultiplier;
    }

    public final int getReceiveMessageTextColor() {
        return this.receiveMessageTextColor;
    }

    public final float getReceiveMessageTextSizeSp() {
        return this.receiveMessageTextSizeSp;
    }

    public final int getSentItemBg() {
        return this.sentItemBg;
    }

    public final AgentUIConfig.TextStyle getSentTextStyle() {
        return this.sentTextStyle;
    }

    public final boolean getShowToolActionLayout() {
        return this.showToolActionLayout;
    }

    public final boolean getShowToolExecuteView() {
        return this.showToolExecuteView;
    }

    public final boolean h0(View view) {
        LocalAppUIHostView localAppUIHostView = view instanceof LocalAppUIHostView ? (LocalAppUIHostView) view : null;
        if (localAppUIHostView == null) {
            return false;
        }
        AppUIData appUIData = localAppUIHostView.getAppUIData();
        return kotlin.jvm.internal.p.d(appUIData != null ? appUIData.getAppUIName() : null, m.TaskMessage.APP_UI_NAME_TEXT_TO_IMAGE);
    }

    public final int i0(DisplayMessage message) {
        List<DisplayTool> listF;
        Set<Integer> setN0 = N0(message);
        int i10 = -1;
        int i11 = 0;
        for (Object obj : message.m()) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                C1173v.w();
            }
            DisplayChatMessage displayChatMessage = (DisplayChatMessage) obj;
            if (displayChatMessage.getType() == AgentMessageType.TOOL && !setN0.contains(Integer.valueOf(i11)) && (listF = displayChatMessage.f()) != null) {
                List<DisplayTool> list = listF;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    Iterator<T> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        if (M0((DisplayTool) it.next())) {
                            i10 = i11;
                            break;
                        }
                    }
                }
            }
            i11 = i12;
        }
        return i10;
    }

    public final Set<String> j0(DisplayMessage message) {
        List<DisplayChatMessage> listM = message.m();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = listM.iterator();
        while (it.hasNext()) {
            List<DisplayTool> listF = ((DisplayChatMessage) it.next()).f();
            if (listF == null) {
                listF = C1173v.m();
            }
            Z8.A.E(arrayList, listF);
        }
        ArrayList arrayList2 = new ArrayList(C1174w.x(arrayList, 10));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add(((DisplayTool) it2.next()).getToolCallId());
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : arrayList2) {
            if (((String) obj).length() > 0) {
                arrayList3.add(obj);
            }
        }
        return Z8.F.r1(arrayList3);
    }

    public final void k0(DisplayMessage message) {
        final List<ReferenceSource> listX;
        S s10 = this.sourcesCapsule;
        if (s10 != null) {
            ViewParent parent = s10.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(s10);
            }
            this.sourcesCapsule = null;
        }
        if (message.getRole() == AgentRole.ASSISTANT && message.getStatus() == EReplyStatus.COMPLETED && (listX = message.x()) != null && !listX.isEmpty()) {
            Context context = getContext();
            kotlin.jvm.internal.p.h(context, "getContext(...)");
            final S s11 = new S(context);
            s11.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            s11.b(listX, new InterfaceC5063a() { // from class: com.stepos.agentframework.chatui.view.s
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return MessageContentContainer.l0(this.f23138a, s11, listX);
                }
            });
            addView(s11);
            this.sourcesCapsule = s11;
            v(s11);
        }
    }

    public final String m0(DisplayMessage m10) {
        return Z8.F.A0(m10.m(), "|", null, null, 0, null, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatui.view.w
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return MessageContentContainer.n0((DisplayChatMessage) obj);
            }
        }, 30, null);
    }

    public final View o0(m.InquiryMessage echo) {
        View viewInflate = LayoutInflater.from(getContext()).inflate(R$layout.view_inquiry_echo, (ViewGroup) this, false);
        if (this.sentItemBg != -1) {
            viewInflate.findViewById(R$id.ll_inquiry_echo_content).setBackgroundResource(this.sentItemBg);
        }
        TextView textView = (TextView) viewInflate.findViewById(R$id.tv_inquiry_echo);
        textView.setText(echo.getSummary());
        kotlin.jvm.internal.p.f(textView);
        com.stepos.agentframework.a.a(textView, this.sentTextStyle);
        kotlin.jvm.internal.p.f(viewInflate);
        return viewInflate;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.cotExposureDirty = true;
        getViewTreeObserver().addOnPreDrawListener(this.cotPreDrawListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        getViewTreeObserver().removeOnPreDrawListener(this.cotPreDrawListener);
        this.cotExposureTargets.clear();
        super.onDetachedFromWindow();
        C2069d0 c2069d0 = this.sourcesPopup;
        if (c2069d0 != null) {
            c2069d0.v();
        }
        this.sourcesPopup = null;
        ToolNameMapping toolNameMapping = ToolNameMapping.INSTANCE;
        if (toolNameMapping.d() == this.onToolNameMapLoaded) {
            toolNameMapping.k(null);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        DisplayMessage displayMessage = this.message;
        long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Chat.messageContent.");
        sb2.append("measure");
        Trace.beginSection(sb2.toString());
        try {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            Trace.endSection();
            long jElapsedRealtimeNanos2 = (SystemClock.elapsedRealtimeNanos() - jElapsedRealtimeNanos) / 1000000;
            if (displayMessage == null || jElapsedRealtimeNanos2 < 8) {
                return;
            }
            F0("measure", displayMessage, jElapsedRealtimeNanos2, true);
        } finally {
        }
    }

    public final AIMDTextView p0(DisplayChatMessage message, EReplyStatus status, String agentId) {
        kotlin.jvm.internal.p.i(message, "message");
        kotlin.jvm.internal.p.i(status, "status");
        kotlin.jvm.internal.p.i(agentId, "agentId");
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        AIMDTextView aIMDTextView = new AIMDTextView(context, null, 0, 6, null);
        aIMDTextView.setHasPrecedingContent(getChildCount() > 0);
        aIMDTextView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        aIMDTextView.setTextColor(androidx.core.content.a.c(aIMDTextView.getContext(), R$color.agent_text_primary));
        int i10 = this.receiveMessageTextColor;
        if (i10 != -1) {
            aIMDTextView.setTextColor(i10);
        }
        float f10 = this.receiveMessageTextSizeSp;
        if (f10 <= 0.0f) {
            f10 = 16.0f;
        }
        aIMDTextView.S0(2, f10);
        float f11 = this.receiveMessageLineSpacingMultiplier;
        if (f11 <= 0.0f) {
            f11 = 1.6f;
        }
        aIMDTextView.Q0(0.0f, f11);
        aIMDTextView.setSelectionEnabled(this.allowTextSelection);
        aIMDTextView.setTableHorizontalScrollEnabled(true);
        aIMDTextView.setStreaming(!status.isTerminal());
        aIMDTextView.setMarkdown(H0(agentId, message.getContent().h()));
        if (status != EReplyStatus.COMPLETED && status != EReplyStatus.CANCELED) {
            return aIMDTextView;
        }
        aIMDTextView.X0();
        return aIMDTextView;
    }

    public final TextView q0(String text) {
        float f10 = getResources().getDisplayMetrics().density;
        TextView textView = new TextView(getContext());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        textView.setText(text);
        textView.setTextColor(androidx.core.content.a.c(textView.getContext(), R$color.agent_text_primary));
        textView.setTextSize(2, 15.0f);
        textView.setLetterSpacing(0.06f);
        textView.setLineSpacing(f10 * 4.0f, 1.0f);
        return textView;
    }

    public final void r0(BaseAppUIHostView.TerminateReason reason) {
        int childCount = getChildCount();
        while (true) {
            childCount--;
            if (-1 >= childCount) {
                return;
            }
            View childAt = getChildAt(childCount);
            if (childAt instanceof com.stepos.agentframework.chatui.appui.l) {
                C4148a.k(this.TAG, "notifyWidgetAppUiHostsCanceled notify widget canceled", false, 4, null);
                ((com.stepos.agentframework.chatui.appui.l) childAt).i(reason);
            } else if (childAt instanceof RobotAppUIHostView) {
                C4148a.k(this.TAG, "notifyRobotAppUIHostsCanceled notify task robot canceled", false, 4, null);
                ((RobotAppUIHostView) childAt).L(reason);
            }
        }
    }

    public final void setAllowTextSelection(boolean z10) {
        this.allowTextSelection = z10;
    }

    public final void setHorizontalContentInsetPx(int i10) {
        int iF = C5685n.f(i10, 0);
        if (this.horizontalContentInsetPx == iF) {
            return;
        }
        this.horizontalContentInsetPx = iF;
        w();
    }

    public final void setMessage(DisplayMessage message) {
        kotlin.jvm.internal.p.i(message, "message");
        long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        Trace.beginSection("Chat.messageContent.set");
        try {
            setMessageContent(message);
            Trace.endSection();
            F0("set", message, (SystemClock.elapsedRealtimeNanos() - jElapsedRealtimeNanos) / 1000000, true);
        } catch (Throwable th) {
            Trace.endSection();
            F0("set", message, (SystemClock.elapsedRealtimeNanos() - jElapsedRealtimeNanos) / 1000000, false);
            throw th;
        }
    }

    public final void setOnToolGroupHeaderClick(InterfaceC5063a<Y8.t> interfaceC5063a) {
        this.onToolGroupHeaderClick = interfaceC5063a;
    }

    public final void setOnToolLikeStatusChangedListener(p9.q<? super DisplayMessage, ? super String, ? super Integer, Y8.t> qVar) {
        this.onToolLikeStatusChangedListener = qVar;
    }

    public final void setReceiveMessageLineSpacingMultiplier(float f10) {
        this.receiveMessageLineSpacingMultiplier = f10;
    }

    public final void setReceiveMessageTextColor(int i10) {
        this.receiveMessageTextColor = i10;
    }

    public final void setReceiveMessageTextSizeSp(float f10) {
        this.receiveMessageTextSizeSp = f10;
    }

    public final void setSentItemBg(int i10) {
        this.sentItemBg = i10;
    }

    public final void setSentTextStyle(AgentUIConfig.TextStyle textStyle) {
        this.sentTextStyle = textStyle;
    }

    public final void setShowToolActionLayout(boolean z10) {
        this.showToolActionLayout = z10;
    }

    public final void setShowToolExecuteView(boolean z10) {
        this.showToolExecuteView = z10;
    }

    public final void setSourcesOnly$agentcore_release(DisplayMessage message) {
        removeAllViews();
        this.sourcesCapsule = null;
        this.message = message;
        if (message != null) {
            k0(message);
        }
    }

    public final void t0(m.FileMessage f10) {
        String fileId = f10.getFileId();
        if (fileId == null || La.H.x0(fileId)) {
            Toast.makeText(getContext(), "无 fileId，无法预览", 0).show();
            return;
        }
        p9.r<Context, AgentFileSyncBridge.Result, String, String, Y8.t> rVarC = AgentFileSyncBridge.c();
        if (rVarC == null) {
            return;
        }
        DisplayMessage displayMessage = this.message;
        C1060i.d(kotlinx.coroutines.d.b(), null, null, new MessageContentContainer$openFilePreview$1(fileId, rVarC, this, displayMessage != null ? displayMessage.getSessionId() : null, null), 3, null);
    }

    public final void u0(List<? extends BaseAppUIHostView> preserved) {
        for (BaseAppUIHostView baseAppUIHostView : preserved) {
            String flag = baseAppUIHostView.getFlag();
            if (flag != null && flag.length() != 0 && !c0(flag)) {
                if (z(baseAppUIHostView)) {
                    z0(baseAppUIHostView);
                    addView(baseAppUIHostView, L(baseAppUIHostView));
                } else {
                    baseAppUIHostView.b();
                    com.stepos.agentframework.chatui.appui.c cVarA = com.stepos.agentframework.chatui.appui.c.INSTANCE.a();
                    Context context = getContext();
                    kotlin.jvm.internal.p.h(context, "getContext(...)");
                    cVarA.k(context, flag);
                }
            }
        }
    }

    public final void v(View capsule) {
        O6.d dVar = O6.d.INSTANCE;
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        int iA = dVar.a(context, 20.0f);
        ViewTreeObserver viewTreeObserver = capsule.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.addOnPreDrawListener(new c(capsule, iA, this, viewTreeObserver));
        }
    }

    public final void v0() {
        this.cotExposureTargets.clear();
        final DisplayMessage displayMessage = this.message;
        if (displayMessage != null && displayMessage.getRole() == AgentRole.ASSISTANT) {
            Iterator<DisplayChatMessage> it = displayMessage.m().iterator();
            int i10 = 0;
            int i11 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i11 = -1;
                    break;
                } else if (it.next().getType() == AgentMessageType.TOOL) {
                    break;
                } else {
                    i11++;
                }
            }
            if (i11 < 0) {
                return;
            }
            List<DisplayChatMessage> listM = displayMessage.m();
            ArrayList arrayList = new ArrayList();
            for (Object obj : listM) {
                int i12 = i10 + 1;
                if (i10 < 0) {
                    C1173v.w();
                }
                DisplayChatMessage displayChatMessage = (DisplayChatMessage) obj;
                Pair pairA = displayChatMessage.getType() == AgentMessageType.TEXT ? Y8.j.a(Integer.valueOf(i10), displayChatMessage) : null;
                if (pairA != null) {
                    arrayList.add(pairA);
                }
                i10 = i12;
            }
            for (Pair pair : Z8.F.w1(H(), arrayList)) {
                AIMDTextView aIMDTextView = (AIMDTextView) pair.a();
                Pair pair2 = (Pair) pair.b();
                int iIntValue = ((Number) pair2.a()).intValue();
                DisplayChatMessage displayChatMessage2 = (DisplayChatMessage) pair2.b();
                if (iIntValue < i11 && !La.H.x0(displayChatMessage2.getContent().h())) {
                    this.cotExposureTargets.add(Y8.j.a(aIMDTextView, new InterfaceC5063a() { // from class: com.stepos.agentframework.chatui.view.H
                        @Override // p9.InterfaceC5063a
                        public final Object invoke() {
                            return MessageContentContainer.w0(displayMessage);
                        }
                    }));
                }
            }
            Iterator<T> it2 = I().iterator();
            while (it2.hasNext()) {
                Iterator<T> it3 = ((ToolExecuteGroupView) it2.next()).J().iterator();
                while (it3.hasNext()) {
                    Pair pair3 = (Pair) it3.next();
                    View view = (View) pair3.a();
                    final DisplayTool displayTool = (DisplayTool) pair3.b();
                    this.cotExposureTargets.add(Y8.j.a(view, new InterfaceC5063a() { // from class: com.stepos.agentframework.chatui.view.I
                        @Override // p9.InterfaceC5063a
                        public final Object invoke() {
                            return MessageContentContainer.x0(displayMessage, displayTool);
                        }
                    }));
                }
            }
        }
    }

    public final void w() {
        MarkdownBlockSpacing.Kind kindJ;
        int interMessageComponentSpacingPx;
        int childCount = getChildCount();
        View view = null;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                boolean z10 = childAt instanceof AIMDTextView;
                AIMDTextView aIMDTextView = z10 ? (AIMDTextView) childAt : null;
                if (aIMDTextView != null) {
                    aIMDTextView.setHasPrecedingContent(view != null);
                }
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : layoutParams instanceof ViewGroup.MarginLayoutParams ? new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LinearLayout.LayoutParams(-1, -2);
                MarkdownBlockSpacing.Kind kindJ2 = view != null ? J(view, false) : null;
                if (kindJ2 != null) {
                    kotlin.jvm.internal.p.f(childAt);
                    kindJ = J(childAt, true);
                } else {
                    kindJ = null;
                }
                Integer numValueOf = (kindJ2 == null || kindJ == null) ? null : Integer.valueOf(MarkdownBlockSpacing.INSTANCE.c(kindJ2, kindJ, z10 && ((AIMDTextView) childAt).getSupplementaryParagraphIndices().contains(0)));
                if (view == null) {
                    interMessageComponentSpacingPx = 0;
                } else if (numValueOf != null) {
                    O6.d dVar = O6.d.INSTANCE;
                    Context context = getContext();
                    kotlin.jvm.internal.p.h(context, "getContext(...)");
                    interMessageComponentSpacingPx = dVar.a(context, numValueOf.intValue());
                } else {
                    interMessageComponentSpacingPx = getInterMessageComponentSpacingPx();
                }
                boolean zH0 = h0(childAt);
                int i11 = zH0 ? 0 : this.horizontalContentInsetPx;
                layoutParams2.setMarginStart(i11);
                layoutParams2.topMargin = interMessageComponentSpacingPx;
                layoutParams2.setMarginEnd(i11);
                layoutParams2.bottomMargin = 0;
                childAt.setLayoutParams(layoutParams2);
                LocalAppUIHostView localAppUIHostView = childAt instanceof LocalAppUIHostView ? (LocalAppUIHostView) childAt : null;
                if (localAppUIHostView != null) {
                    localAppUIHostView.setContentStartInset(zH0 ? this.horizontalContentInsetPx : 0);
                }
                view = childAt;
            }
        }
    }

    public final boolean x(String flag, AppUIData data, List<? extends BaseAppUIHostView> preservedCardHosts, Integer insertAt) {
        Object next;
        String strC = q4.j.INSTANCE.C(data);
        boolean zC0 = c0(flag);
        boolean z10 = strC != null && g0(data);
        if (zC0 || z10) {
            return false;
        }
        Iterator<T> it = preservedCardHosts.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (kotlin.jvm.internal.p.d(((BaseAppUIHostView) next).getFlag(), flag)) {
                break;
            }
        }
        BaseAppUIHostView baseAppUIHostView = (BaseAppUIHostView) next;
        View viewA0 = (baseAppUIHostView == null || !z(baseAppUIHostView)) ? null : baseAppUIHostView;
        if (baseAppUIHostView != null && viewA0 == null) {
            C4148a.k(this.TAG, "attachAppUiHost drop destroyed host flag=" + flag, false, 4, null);
            z0(baseAppUIHostView);
            baseAppUIHostView.b();
            com.stepos.agentframework.chatui.appui.c cVarA = com.stepos.agentframework.chatui.appui.c.INSTANCE.a();
            Context context = getContext();
            kotlin.jvm.internal.p.h(context, "getContext(...)");
            cVarA.k(context, flag);
        }
        if (viewA0 != null) {
            z0(viewA0);
        } else {
            viewA0 = a0(flag, data);
        }
        if (viewA0 == null) {
            return false;
        }
        if (insertAt != null) {
            addView(viewA0, insertAt.intValue(), L(viewA0));
        } else {
            addView(viewA0, L(viewA0));
        }
        return true;
    }

    public final void y0() throws Exception {
        Iterator<T> it = I().iterator();
        while (it.hasNext()) {
            ((ToolExecuteGroupView) it.next()).w();
        }
    }

    public final boolean z(BaseAppUIHostView host) {
        LocalAppUIHostView localAppUIHostView = host instanceof LocalAppUIHostView ? (LocalAppUIHostView) host : null;
        C2036o1 c2036o1 = C2036o1.INSTANCE;
        boolean isHostDestroyed = host.getIsHostDestroyed();
        boolean z10 = false;
        boolean z11 = localAppUIHostView != null && localAppUIHostView.getBridge() == null;
        if (localAppUIHostView != null && h0(localAppUIHostView)) {
            com.stepos.agentframework.chatui.appui.a<?, ?> bridge = localAppUIHostView.getBridge();
            if ((bridge != null ? bridge.c() : null) == null || localAppUIHostView.getAppUIContainer().getChildCount() == 0) {
                z10 = true;
            }
        }
        return c2036o1.a(isHostDestroyed, z11, z10);
    }

    public final void z0(View view) {
        kotlin.jvm.internal.p.i(view, "view");
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(view);
        }
    }
}
