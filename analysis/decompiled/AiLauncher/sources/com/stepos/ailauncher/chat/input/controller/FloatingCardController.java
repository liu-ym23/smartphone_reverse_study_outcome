package com.stepos.ailauncher.chat.input.controller;

import E4.FloatCardContent;
import E4.FloatCardOption;
import E4.FloatCardOptions;
import E4.FloatCardPage;
import E4.FloatCardRequest;
import E4.FloatCardRiskBadge;
import E4.d;
import E4.e;
import E4.g;
import E4.n;
import Ua.C1060i;
import Ua.L0;
import Ua.M;
import Ua.Y;
import Z8.C1172u;
import Z8.C1173v;
import Z8.C1174w;
import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.ViewStub;
import androidx.dynamicanimation.animation.e;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.R$id;
import com.stepos.agentframework.chatcore.SessionHandler;
import com.stepos.agentframework.floatcard.api.FloatCardOptionStyle;
import com.stepos.agentframework.floatcard.api.FloatCardRiskLevel;
import com.stepos.agentframework.floatcard.api.FloatCardScene;
import com.stepos.agentframework.floatcard.api.FloatCardSkipMode;
import com.stepos.agentframework.floatcard.api.SelectionMode;
import com.stepos.agentframework.floatcard.view.FloatCardContainerView;
import com.stepos.aiengine.args.MultiFilesBundle;
import com.stepos.ailauncher.chat.view.AskUserInquiry;
import com.stepos.ailauncher.chat.view.BaseInputView;
import com.stepos.ailauncher.chat.view.C2851i7;
import com.stepos.ailauncher.chat.view.RiskCardButton;
import com.stepos.ailauncher.contract.api.taskstore.ILiveNotificationService;
import com.stepos.ailauncher.floatcard.api.IFloatCardEventHandler;
import com.stepos.ailauncher.floatcard.api.IFloatCardService;
import com.stepos.ailauncher.sheet.SheetSpring;
import com.stepos.ailauncher.sheet.h0;
import com.stepos.ailauncher.sheet.i0;
import com.stepos.ame.sdk.SkillStoreKt;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.jvm.internal.Ref$BooleanRef;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000¢\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0002å\u0001\u0018\u0000 ì\u00012\u00020\u0001:\u0004í\u0001î\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0011\u0010\u000fJ\u0017\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\n2\b\b\u0002\u0010\u001b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001e\u0010\u000fJ\u000f\u0010\u001f\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001f\u0010\u000fJ\u000f\u0010 \u001a\u00020\rH\u0002¢\u0006\u0004\b \u0010\u000fJ\u0011\u0010!\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b!\u0010\"J\u0017\u0010%\u001a\u00020\r2\u0006\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\b%\u0010&J\u0017\u0010(\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u0006H\u0002¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\rH\u0002¢\u0006\u0004\b*\u0010\u000fJ\u001f\u0010-\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u00062\u0006\u0010,\u001a\u00020+H\u0002¢\u0006\u0004\b-\u0010.J\u001b\u0010/\u001a\u00020\r2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b/\u0010)J\u001f\u00100\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u00062\u0006\u0010,\u001a\u00020+H\u0002¢\u0006\u0004\b0\u0010.J'\u00103\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u00062\u0006\u0010,\u001a\u00020+2\u0006\u00102\u001a\u000201H\u0002¢\u0006\u0004\b3\u00104J\u0017\u00105\u001a\u00020\n2\u0006\u0010,\u001a\u00020+H\u0002¢\u0006\u0004\b5\u00106J/\u00108\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u00062\u0006\u0010,\u001a\u00020+2\u0006\u00107\u001a\u0002012\u0006\u00102\u001a\u000201H\u0002¢\u0006\u0004\b8\u00109J;\u0010=\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u00062\u0006\u0010,\u001a\u00020+2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\r0:2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\r0:H\u0002¢\u0006\u0004\b=\u0010>J-\u0010B\u001a\u00020\r2\u0006\u0010@\u001a\u00020?2\u0006\u0010A\u001a\u0002012\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\r0:H\u0002¢\u0006\u0004\bB\u0010CJ\u000f\u0010D\u001a\u00020?H\u0002¢\u0006\u0004\bD\u0010EJ\u0017\u0010F\u001a\u00020\r2\u0006\u0010@\u001a\u00020?H\u0002¢\u0006\u0004\bF\u0010GJ\u000f\u0010H\u001a\u00020\rH\u0002¢\u0006\u0004\bH\u0010\u000fJ\u0017\u0010I\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u0006H\u0002¢\u0006\u0004\bI\u0010)J-\u0010K\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u00062\u0006\u0010,\u001a\u00020+2\f\u0010J\u001a\b\u0012\u0004\u0012\u00020\r0:H\u0002¢\u0006\u0004\bK\u0010LJ\u001f\u0010O\u001a\u00020\r2\u0006\u0010M\u001a\u00020?2\u0006\u0010N\u001a\u00020\nH\u0002¢\u0006\u0004\bO\u0010PJ\u000f\u0010Q\u001a\u00020\rH\u0002¢\u0006\u0004\bQ\u0010\u000fJI\u0010Y\u001a\u00020\r2\u0006\u0010R\u001a\u00020?2\u0006\u0010T\u001a\u00020S2\u0006\u0010U\u001a\u00020#2\u0006\u0010V\u001a\u00020#2\u0006\u0010X\u001a\u00020W2\u0010\b\u0002\u0010J\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010:H\u0002¢\u0006\u0004\bY\u0010ZJQ\u0010\\\u001a\u00020\r2\u0006\u0010R\u001a\u00020?2\f\u0010T\u001a\b\u0012\u0004\u0012\u00020?0[2\u0006\u0010U\u001a\u00020#2\b\b\u0002\u0010V\u001a\u00020#2\u0006\u0010X\u001a\u00020W2\u0010\b\u0002\u0010J\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010:H\u0002¢\u0006\u0004\b\\\u0010]J\u000f\u0010^\u001a\u00020\rH\u0002¢\u0006\u0004\b^\u0010\u000fJ\u0019\u0010_\u001a\u00020\r2\b\u0010'\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b_\u0010)J\u0017\u0010`\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u0006H\u0002¢\u0006\u0004\b`\u0010)J\u0017\u0010a\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u0006H\u0002¢\u0006\u0004\ba\u0010)J\u001f\u0010c\u001a\u00020\r2\u0006\u0010R\u001a\u00020?2\u0006\u0010b\u001a\u000201H\u0002¢\u0006\u0004\bc\u0010dJ\u001f\u0010e\u001a\u0002012\u0006\u0010'\u001a\u00020?2\u0006\u0010M\u001a\u00020?H\u0002¢\u0006\u0004\be\u0010fJ\u0019\u0010h\u001a\u00020\r2\b\b\u0002\u0010g\u001a\u00020\nH\u0002¢\u0006\u0004\bh\u0010iJ\u000f\u0010j\u001a\u00020\rH\u0002¢\u0006\u0004\bj\u0010\u000fJ\u0017\u0010l\u001a\u00020\u00122\u0006\u0010k\u001a\u00020\u0012H\u0002¢\u0006\u0004\bl\u0010mJ%\u0010s\u001a\u00020r2\u0006\u0010n\u001a\u00020\u00122\f\u0010q\u001a\b\u0012\u0004\u0012\u00020p0oH\u0002¢\u0006\u0004\bs\u0010tJ]\u0010~\u001a\u00020r2\u0006\u0010u\u001a\u00020\u00122\u0006\u0010v\u001a\u00020\u00122\b\u0010w\u001a\u0004\u0018\u00010\u00122\u0006\u0010x\u001a\u00020\u00122\b\u0010y\u001a\u0004\u0018\u00010\u00122\f\u0010{\u001a\b\u0012\u0004\u0012\u00020z0o2\b\b\u0002\u0010|\u001a\u00020\u00122\b\b\u0002\u0010}\u001a\u00020\nH\u0002¢\u0006\u0004\b~\u0010\u007fJ(\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0081\u00012\u0006\u0010x\u001a\u00020\u00122\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001J\u001a\u0010\u0085\u0001\u001a\u00020\r2\u0007\u0010\u0084\u0001\u001a\u00020\u0012H\u0002¢\u0006\u0005\b\u0085\u0001\u0010\u0015J\u000f\u0010\u0086\u0001\u001a\u00020\n¢\u0006\u0005\b\u0086\u0001\u0010\fJ\u0012\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u0012¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J\u000f\u0010\u0089\u0001\u001a\u00020\n¢\u0006\u0005\b\u0089\u0001\u0010\fJi\u0010\u008e\u0001\u001a\u00020\n2\u0007\u0010\u0084\u0001\u001a\u00020\u00122\u0006\u0010n\u001a\u00020\u00122\f\u0010q\u001a\b\u0012\u0004\u0012\u00020p0o2\u000b\b\u0002\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u00122+\u0010\u008d\u0001\u001a&\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120o\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\n0\u008c\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u008b\u0001¢\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001Jo\u0010\u0093\u0001\u001a\u00020\n2\u0006\u0010u\u001a\u00020\u00122\u0006\u0010v\u001a\u00020\u00122\b\u0010w\u001a\u0004\u0018\u00010\u00122\u0006\u0010x\u001a\u00020\u00122\b\u0010y\u001a\u0004\u0018\u00010\u00122\f\u0010{\u001a\b\u0012\u0004\u0012\u00020z0o2\u0014\u0010\u0091\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\r0\u0090\u00012\r\u0010\u0092\u0001\u001a\b\u0012\u0004\u0012\u00020\r0:¢\u0006\u0006\b\u0093\u0001\u0010\u0094\u0001JW\u0010\u0095\u0001\u001a\u00020\n2\u0007\u0010\u0084\u0001\u001a\u00020\u00122\u0006\u0010u\u001a\u00020\u00122\u0006\u0010v\u001a\u00020\u00122\b\u0010w\u001a\u0004\u0018\u00010\u00122\f\u0010{\u001a\b\u0012\u0004\u0012\u00020z0o2\u0014\u0010\u0091\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\r0\u0090\u0001¢\u0006\u0006\b\u0095\u0001\u0010\u0096\u0001J1\u0010\u0098\u0001\u001a\u00020\r2\n\b\u0002\u0010k\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010g\u001a\u00020\n2\t\b\u0002\u0010\u0097\u0001\u001a\u00020\n¢\u0006\u0006\b\u0098\u0001\u0010\u0099\u0001J\u001b\u0010\u009b\u0001\u001a\u00020\n2\t\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u0012¢\u0006\u0006\b\u009b\u0001\u0010\u009c\u0001J\u001b\u0010\u009e\u0001\u001a\u00020\n2\t\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u0012¢\u0006\u0006\b\u009e\u0001\u0010\u009c\u0001J\u000f\u0010\u009f\u0001\u001a\u00020\r¢\u0006\u0005\b\u009f\u0001\u0010\u000fR\u0015\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0003\u0010 \u0001R\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0005\u0010¡\u0001R\u001b\u0010¢\u0001\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¢\u0001\u0010£\u0001R\u001c\u0010¥\u0001\u001a\u0005\u0018\u00010¤\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¥\u0001\u0010¦\u0001R\u001b\u0010§\u0001\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b§\u0001\u0010¨\u0001R \u0010ª\u0001\u001a\t\u0018\u00010©\u0001R\u00020\u00008\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bª\u0001\u0010«\u0001R\u0019\u0010¬\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¬\u0001\u0010\u00ad\u0001R\u0019\u0010®\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b®\u0001\u0010\u00ad\u0001R\u0019\u0010¯\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¯\u0001\u0010\u00ad\u0001R\u0018\u0010±\u0001\u001a\u00030°\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b±\u0001\u0010²\u0001R\u001c\u0010´\u0001\u001a\u0005\u0018\u00010³\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b´\u0001\u0010µ\u0001R\u001b\u0010¶\u0001\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¶\u0001\u0010·\u0001R\u001b\u0010¸\u0001\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¸\u0001\u0010·\u0001R(\u0010¹\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\r\u0018\u00010\u0090\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¹\u0001\u0010º\u0001R!\u0010»\u0001\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010:8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b»\u0001\u0010¼\u0001R?\u0010½\u0001\u001a(\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120o\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\n0\u008c\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u008b\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b½\u0001\u0010¾\u0001R\u001b\u0010¿\u0001\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¿\u0001\u0010·\u0001R\u001c\u0010Á\u0001\u001a\u0005\u0018\u00010À\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÁ\u0001\u0010Â\u0001R\u001b\u0010Ã\u0001\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÃ\u0001\u0010·\u0001R\u001a\u0010Å\u0001\u001a\u00030Ä\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÅ\u0001\u0010Æ\u0001R(\u0010Ç\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\r\u0018\u00010\u0090\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÇ\u0001\u0010º\u0001R!\u0010È\u0001\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010:8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÈ\u0001\u0010¼\u0001R\u001c\u0010É\u0001\u001a\u0005\u0018\u00010À\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÉ\u0001\u0010Â\u0001R\u0019\u0010Ê\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÊ\u0001\u0010\u00ad\u0001R\u0019\u0010Ë\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bË\u0001\u0010\u00ad\u0001R\u001b\u0010Ì\u0001\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÌ\u0001\u0010·\u0001R\u001c\u0010Î\u0001\u001a\u0005\u0018\u00010Í\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÎ\u0001\u0010Ï\u0001R\u001f\u0010Ò\u0001\u001a\n\u0012\u0005\u0012\u00030Ñ\u00010Ð\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÒ\u0001\u0010Ó\u0001R\u001c\u0010Õ\u0001\u001a\u0005\u0018\u00010Ô\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÕ\u0001\u0010Ö\u0001R\u001c\u0010Ø\u0001\u001a\u0005\u0018\u00010×\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bØ\u0001\u0010Ù\u0001R\u001c\u0010Ú\u0001\u001a\u0005\u0018\u00010×\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÚ\u0001\u0010Ù\u0001R\u0019\u0010Û\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÛ\u0001\u0010\u00ad\u0001R\u0019\u0010Ü\u0001\u001a\u0002018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÜ\u0001\u0010Ý\u0001R\u0019\u0010Þ\u0001\u001a\u0002018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÞ\u0001\u0010Ý\u0001R\u001b\u0010ß\u0001\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bß\u0001\u0010à\u0001R/\u0010ã\u0001\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0005\u0012\u00030â\u0001\u0012\u0004\u0012\u00020\n0á\u0001\u0018\u00010o8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bã\u0001\u0010Ó\u0001R\u0019\u0010ä\u0001\u001a\u0002018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bä\u0001\u0010Ý\u0001R\u0018\u0010æ\u0001\u001a\u00030å\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bæ\u0001\u0010ç\u0001R\u001a\u0010ë\u0001\u001a\u0005\u0018\u00010è\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\bé\u0001\u0010ê\u0001¨\u0006ï\u0001"}, d2 = {"Lcom/stepos/ailauncher/chat/input/controller/FloatingCardController;", "", "Lcom/stepos/ailauncher/chat/view/BaseInputView;", "inputView", "Landroid/view/ViewStub;", "infoCardStub", "Lcom/stepos/agentframework/floatcard/view/FloatCardContainerView;", "preInflatedContainer", "<init>", "(Lcom/stepos/ailauncher/chat/view/BaseInputView;Landroid/view/ViewStub;Lcom/stepos/agentframework/floatcard/view/FloatCardContainerView;)V", "", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "()Z", "LY8/t;", "L", "()V", "h1", "d1", "", "action", "e1", "(Ljava/lang/String;)V", "chosen", "LE4/e;", "e0", "(Ljava/lang/String;)LE4/e;", x5.d.EXTRA_ENABLED, "allowChatScroll", "j1", "(ZZ)V", "j0", "w1", "N", "i0", "()Lcom/stepos/agentframework/floatcard/view/FloatCardContainerView;", "", "dp", "M", "(F)V", "container", "l0", "(Lcom/stepos/agentframework/floatcard/view/FloatCardContainerView;)V", "x1", "LE4/p;", "card", "M0", "(Lcom/stepos/agentframework/floatcard/view/FloatCardContainerView;LE4/p;)V", "Y", "O", "", "enterGeneration", "x0", "(Lcom/stepos/agentframework/floatcard/view/FloatCardContainerView;LE4/p;I)V", "y1", "(LE4/p;)Z", "heightPx", "B0", "(Lcom/stepos/agentframework/floatcard/view/FloatCardContainerView;LE4/p;II)V", "Lkotlin/Function0;", "onCardGone", "onSettled", "D0", "(Lcom/stepos/agentframework/floatcard/view/FloatCardContainerView;LE4/p;Lp9/a;Lp9/a;)V", "Landroid/view/View;", "layer", "reveal", "I0", "(Landroid/view/View;ILp9/a;)V", "R", "()Landroid/view/View;", "Q", "(Landroid/view/View;)V", "f1", "g1", "onEnd", "V0", "(Lcom/stepos/agentframework/floatcard/view/FloatCardContainerView;LE4/p;Lp9/a;)V", "shell", "revealInput", "u0", "(Landroid/view/View;Z)V", "r0", "view", "Landroidx/dynamicanimation/animation/e$s;", "prop", MultiFilesBundle.EVENT_FINAL, "minVisible", "Lcom/stepos/ailauncher/sheet/g0;", "spec", "q1", "(Landroid/view/View;Landroidx/dynamicanimation/animation/e$s;FFLcom/stepos/ailauncher/sheet/g0;Lp9/a;)V", "Landroidx/dynamicanimation/animation/f;", "r1", "(Landroid/view/View;Landroidx/dynamicanimation/animation/f;FFLcom/stepos/ailauncher/sheet/g0;Lp9/a;)V", "p1", "v1", ExifInterface.LONGITUDE_WEST, "k0", "height", "l1", "(Landroid/view/View;I)V", "A0", "(Landroid/view/View;Landroid/view/View;)I", "cancelRisk", "b0", "(Z)V", "a0", "taskId", "X", "(Ljava/lang/String;)Ljava/lang/String;", "inquiryId", "", "Lcom/stepos/ailauncher/chat/view/S;", "inquiries", "LE4/k;", ExifInterface.LATITUDE_SOUTH, "(Ljava/lang/String;Ljava/util/List;)LE4/k;", "requestId", "title", "body", "riskLevel", "riskBadgeLabel", "Lcom/stepos/ailauncher/chat/view/A7;", "buttons", "businessType", "hostDrivenEnterAnim", ExifInterface.GPS_DIRECTION_TRUE, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Z)LE4/k;", "label", "LE4/l;", "i1", "(Ljava/lang/String;Ljava/lang/String;)LE4/l;", "sessionId", "z0", "w0", "d0", "()Ljava/lang/String;", "t0", "page", "Lkotlin/Function2;", "Le9/c;", "onSubmit", "n1", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lp9/p;)Z", "Lkotlin/Function1;", "onChoice", "onCancel", "o1", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lp9/l;Lp9/a;)Z", "m1", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lp9/l;)Z", "animate", "f0", "(Ljava/lang/String;ZZ)V", "currentSessionId", "h0", "(Ljava/lang/String;)Z", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "v0", "c1", "Lcom/stepos/ailauncher/chat/view/BaseInputView;", "Landroid/view/ViewStub;", "floatCardContainer", "Lcom/stepos/agentframework/floatcard/view/FloatCardContainerView;", "LG4/h;", "floatCardHost", "LG4/h;", "floatCardSlot", "Landroid/view/View;", "Lcom/stepos/ailauncher/chat/input/controller/FloatingCardController$b;", "fullscreenTouchIntercept", "Lcom/stepos/ailauncher/chat/input/controller/FloatingCardController$b;", "cardWantsFullscreenIntercept", "Z", "interceptAllowChatScroll", "passthroughChatList", "LUa/M;", "interceptScope", "LUa/M;", "Lkotlinx/coroutines/g;", "conversationBodyJob", "Lkotlinx/coroutines/g;", "currentTaskId", "Ljava/lang/String;", "currentCardId", "pendingOnSubmit", "Lp9/l;", "pendingOnCancel", "Lp9/a;", "pendingInquirySubmit", "Lp9/p;", "currentInquirySessionId", "Lcom/stepos/ailauncher/floatcard/api/IFloatCardEventHandler;", "inquiryEventHandler", "Lcom/stepos/ailauncher/floatcard/api/IFloatCardEventHandler;", "inquiryPage", "", "inquiryShownAt", "J", "pendingRiskChoice", "pendingRiskCancel", "riskEventHandler", "riskChoiceDelivered", "pendingUnregisterAfterExit", "currentApprovalSessionId", "Ly7/E;", "riskCardGlassHandle", "Ly7/E;", "", "Landroidx/dynamicanimation/animation/i;", "cardAnims", "Ljava/util/List;", "Landroid/view/ViewPropertyAnimator;", "cardTween", "Landroid/view/ViewPropertyAnimator;", "Ljava/lang/Runnable;", "cardAnimFallback", "Ljava/lang/Runnable;", "cardEnterSafety", "cardExitRunning", "inputRevealGeneration", "I", "cardAnimGeneration", "containerClipSaved", "Ljava/lang/Boolean;", "Lkotlin/Pair;", "Landroid/view/ViewGroup;", "ancestorClipSaved", "floatingCardDefaultTopMarginPx", "com/stepos/ailauncher/chat/input/controller/FloatingCardController$c", "containerHeightProperty", "Lcom/stepos/ailauncher/chat/input/controller/FloatingCardController$c;", "Lcom/stepos/ailauncher/floatcard/api/IFloatCardService;", "s0", "()Lcom/stepos/ailauncher/floatcard/api/IFloatCardService;", "service", "Companion", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FloatingCardController {
    private static final String ASK_USER_BUSINESS_TYPE = "ask_user";
    private static final String BUSINESS_TYPE = "info_request";
    private static final long CARD_ANIM_FALLBACK_MS = 150;
    private static final float CARD_BOTTOM_INSET_WHEN_INPUTBAR_HIDDEN_DP = 16.0f;
    private static final float ENTER_DAMPING_RATIO = 1.2f;
    private static final long ENTER_SAFETY_MS = 480;
    private static final float ENTER_TEMPO = 1.2f;
    private static final float EXIT_DAMPING_RATIO = 1.2f;
    private static final long EXIT_FALLBACK_MS = 540;
    private static final float EXIT_TEMPO = 1.705f;
    private static final float FLOAT_CARD_TOP_MARGIN_DP = 16.0f;
    private static final String RISK_BUSINESS_TYPE = "risk_statement";
    private static final String RISK_SELECTION_ID = "risk";
    private static final float SHELL_ENTER_DY_DP = 32.0f;
    private static final String TAG = "FloatingCardController";
    private static final String TOOL_APPROVAL_BUSINESS_TYPE = "tool_approval";
    private List<? extends Pair<? extends ViewGroup, Boolean>> ancestorClipSaved;
    private Runnable cardAnimFallback;
    private int cardAnimGeneration;
    private final List<androidx.dynamicanimation.animation.i> cardAnims;
    private Runnable cardEnterSafety;
    private boolean cardExitRunning;
    private ViewPropertyAnimator cardTween;
    private boolean cardWantsFullscreenIntercept;
    private Boolean containerClipSaved;
    private final c containerHeightProperty;
    private kotlinx.coroutines.g conversationBodyJob;
    private String currentApprovalSessionId;
    private String currentCardId;
    private String currentInquirySessionId;
    private String currentTaskId;
    private FloatCardContainerView floatCardContainer;
    private G4.h floatCardHost;
    private View floatCardSlot;
    private int floatingCardDefaultTopMarginPx;
    private b fullscreenTouchIntercept;
    private final ViewStub infoCardStub;
    private int inputRevealGeneration;
    private final BaseInputView inputView;
    private IFloatCardEventHandler inquiryEventHandler;
    private String inquiryPage;
    private long inquiryShownAt;
    private boolean interceptAllowChatScroll;
    private final M interceptScope;
    private boolean passthroughChatList;
    private p9.p<? super List<String>, ? super InterfaceC4014c<? super Boolean>, ? extends Object> pendingInquirySubmit;
    private InterfaceC5063a<Y8.t> pendingOnCancel;
    private InterfaceC5074l<? super String, Y8.t> pendingOnSubmit;
    private InterfaceC5063a<Y8.t> pendingRiskCancel;
    private InterfaceC5074l<? super String, Y8.t> pendingRiskChoice;
    private boolean pendingUnregisterAfterExit;
    private y7.E riskCardGlassHandle;
    private boolean riskChoiceDelivered;
    private IFloatCardEventHandler riskEventHandler;
    private static final a Companion = new a(null);
    private static final SheetSpring RISK_CARD_POSITION_SPRING = new SheetSpring(800.0f, 0.8f);
    private static final SheetSpring RISK_CARD_ENTER_FADE_SPRING = SheetSpring.Companion.b(SheetSpring.INSTANCE, 800.0f, 40.0f, 0.0f, 4, null);
    private static final SheetSpring RISK_CARD_EXIT_FADE_SPRING = new SheetSpring(439.0f, 0.9f);

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0006R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u000eR\u0014\u0010\u0015\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u000eR\u0014\u0010\u0016\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u000eR\u0014\u0010\u0017\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u000eR\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u000eR\u0014\u0010\u001e\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001e\u0010\u000e¨\u0006\u001f"}, d2 = {"Lcom/stepos/ailauncher/chat/input/controller/FloatingCardController$a;", "", "<init>", "()V", "", "TAG", "Ljava/lang/String;", "BUSINESS_TYPE", "ASK_USER_BUSINESS_TYPE", "RISK_BUSINESS_TYPE", "TOOL_APPROVAL_BUSINESS_TYPE", "RISK_SELECTION_ID", "", "SHELL_ENTER_DY_DP", "F", "", "CARD_ANIM_FALLBACK_MS", "J", "ENTER_SAFETY_MS", "EXIT_FALLBACK_MS", "EXIT_TEMPO", "EXIT_DAMPING_RATIO", "ENTER_TEMPO", "ENTER_DAMPING_RATIO", "Lcom/stepos/ailauncher/sheet/g0;", "RISK_CARD_POSITION_SPRING", "Lcom/stepos/ailauncher/sheet/g0;", "RISK_CARD_ENTER_FADE_SPRING", "RISK_CARD_EXIT_FADE_SPRING", "CARD_BOTTOM_INSET_WHEN_INPUTBAR_HIDDEN_DP", "FLOAT_CARD_TOP_MARGIN_DP", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u001f\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/stepos/ailauncher/chat/input/controller/FloatingCardController$b;", "Landroid/view/View;", "Landroid/content/Context;", "context", "<init>", "(Lcom/stepos/ailauncher/chat/input/controller/FloatingCardController;Landroid/content/Context;)V", "Landroid/view/MotionEvent;", "event", "", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", Const.INTENT_KEY_PKGNAME, "target", Const.INTENT_KEY_APIKEY, "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "", "passthroughLoc", "[I", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class b extends View {
        private final int[] passthroughLoc;
        final /* synthetic */ FloatingCardController this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(FloatingCardController floatingCardController, Context context) {
            super(context);
            kotlin.jvm.internal.p.i(context, "context");
            this.this$0 = floatingCardController;
            this.passthroughLoc = new int[2];
            setImportantForAccessibility(2);
        }

        public final boolean a(View target, MotionEvent event) {
            target.getLocationOnScreen(this.passthroughLoc);
            float rawX = event.getRawX();
            float rawY = event.getRawY();
            if (rawX >= this.passthroughLoc[0] && rawX < r1 + target.getWidth()) {
                if (rawY >= this.passthroughLoc[1] && rawY < r4 + target.getHeight()) {
                    return true;
                }
            }
            return false;
        }

        public final boolean b(MotionEvent event) {
            BaseInputView baseInputView = this.this$0.inputView;
            if (baseInputView.isShown() && baseInputView.getWidth() > 0 && baseInputView.getHeight() > 0 && a(baseInputView, event)) {
                return true;
            }
            View view = this.this$0.floatCardSlot;
            if (view != null && view.isShown() && view.getWidth() > 0 && view.getHeight() > 0 && a(view, event)) {
                return true;
            }
            if (!this.this$0.passthroughChatList) {
                return false;
            }
            View rootView = this.this$0.inputView.getRootView();
            View viewFindViewById = rootView.findViewById(R$id.chat_list);
            if (viewFindViewById != null && viewFindViewById.isShown() && viewFindViewById.getWidth() > 0 && viewFindViewById.getHeight() > 0 && a(viewFindViewById, event)) {
                return true;
            }
            View viewFindViewById2 = rootView.findViewById(com.stepos.ailauncher.chat.R$id.top_bar);
            return viewFindViewById2 != null && viewFindViewById2.isShown() && viewFindViewById2.getWidth() > 0 && viewFindViewById2.getHeight() > 0 && a(viewFindViewById2, event);
        }

        @Override // android.view.View
        public boolean dispatchTouchEvent(MotionEvent event) {
            kotlin.jvm.internal.p.i(event, "event");
            return com.stepos.ailauncher.common.utils.v.INSTANCE.j() && !b(event);
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/stepos/ailauncher/chat/input/controller/FloatingCardController$c", "Landroidx/dynamicanimation/animation/f;", "Landroid/view/View;", "view", "", Const.INTENT_KEY_APIKEY, "(Landroid/view/View;)F", UxipConstants.f30680s, "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Landroid/view/View;F)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c extends androidx.dynamicanimation.animation.f<View> {
        public c() {
            super("cardContainerHeight");
        }

        @Override // androidx.dynamicanimation.animation.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public float getValue(View view) {
            kotlin.jvm.internal.p.i(view, "view");
            if (view.getLayoutParams() != null) {
                return r0.height;
            }
            return 0.0f;
        }

        @Override // androidx.dynamicanimation.animation.f
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void setValue(View view, float value) {
            int iF;
            kotlin.jvm.internal.p.i(view, "view");
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null || layoutParams.height == (iF = C5685n.f((int) value, 0))) {
                return;
            }
            layoutParams.height = iF;
            view.setLayoutParams(layoutParams);
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096@¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"com/stepos/ailauncher/chat/input/controller/FloatingCardController$d", "Lcom/stepos/ailauncher/floatcard/api/IFloatCardEventHandler;", "LE4/d;", "event", "LE4/e;", "handle", "(LE4/d;Le9/c;)Ljava/lang/Object;", "", "businessType", "Ljava/lang/String;", "getBusinessType", "()Ljava/lang/String;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d implements IFloatCardEventHandler {
        final /* synthetic */ String $requestId;
        private final String businessType = FloatingCardController.TOOL_APPROVAL_BUSINESS_TYPE;
        final /* synthetic */ FloatingCardController this$0;

        public d(String str, FloatingCardController floatingCardController) {
            this.$requestId = str;
            this.this$0 = floatingCardController;
        }

        @Override // com.stepos.ailauncher.floatcard.api.IFloatCardEventHandler
        public String getBusinessType() {
            return this.businessType;
        }

        @Override // com.stepos.ailauncher.floatcard.api.IFloatCardEventHandler
        public Object handle(E4.d dVar, InterfaceC4014c<? super E4.e> interfaceC4014c) {
            List<String> listA;
            if (!(dVar instanceof d.Submit)) {
                return e.C0026e.INSTANCE;
            }
            E4.n nVar = ((d.Submit) dVar).a().get("risk");
            n.Selected selected = nVar instanceof n.Selected ? (n.Selected) nVar : null;
            String str = (selected == null || (listA = selected.a()) == null) ? null : (String) Z8.F.s0(listA);
            if (str == null || str.length() == 0) {
                Log.w(FloatingCardController.TAG, "showApproval Submit without choice, requestId=" + this.$requestId);
                return e.C0026e.INSTANCE;
            }
            Log.i(FloatingCardController.TAG, "showApproval Submit requestId=" + this.$requestId + " choice=" + str);
            this.this$0.riskChoiceDelivered = true;
            InterfaceC5074l interfaceC5074l = this.this$0.pendingRiskChoice;
            this.this$0.pendingRiskChoice = null;
            this.this$0.pendingRiskCancel = null;
            if (interfaceC5074l != null) {
                interfaceC5074l.invoke(str);
            }
            FloatingCardController.c0(this.this$0, false, 1, null);
            return e.a.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096@¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"com/stepos/ailauncher/chat/input/controller/FloatingCardController$e", "Lcom/stepos/ailauncher/floatcard/api/IFloatCardEventHandler;", "LE4/d;", "event", "LE4/e;", "handle", "(LE4/d;Le9/c;)Ljava/lang/Object;", "", "businessType", "Ljava/lang/String;", "getBusinessType", "()Ljava/lang/String;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class e implements IFloatCardEventHandler {
        final /* synthetic */ String $requestId;
        private final String businessType = FloatingCardController.RISK_BUSINESS_TYPE;
        final /* synthetic */ FloatingCardController this$0;

        public e(String str, FloatingCardController floatingCardController) {
            this.$requestId = str;
            this.this$0 = floatingCardController;
        }

        @Override // com.stepos.ailauncher.floatcard.api.IFloatCardEventHandler
        public String getBusinessType() {
            return this.businessType;
        }

        @Override // com.stepos.ailauncher.floatcard.api.IFloatCardEventHandler
        public Object handle(E4.d dVar, InterfaceC4014c<? super E4.e> interfaceC4014c) {
            List<String> listA;
            if (!(dVar instanceof d.Submit)) {
                return e.C0026e.INSTANCE;
            }
            E4.n nVar = ((d.Submit) dVar).a().get("risk");
            String str = null;
            n.Selected selected = nVar instanceof n.Selected ? (n.Selected) nVar : null;
            if (selected != null && (listA = selected.a()) != null) {
                str = (String) Z8.F.s0(listA);
            }
            if (str == null || str.length() == 0) {
                Log.w(FloatingCardController.TAG, "showRisk Submit without choice, requestId=" + this.$requestId);
                return e.C0026e.INSTANCE;
            }
            Log.i(FloatingCardController.TAG, "showRisk Submit requestId=" + this.$requestId + " choice=" + str);
            return this.this$0.e0(str);
        }
    }

    public FloatingCardController(BaseInputView inputView, ViewStub viewStub, FloatCardContainerView floatCardContainerView) {
        kotlin.jvm.internal.p.i(inputView, "inputView");
        this.inputView = inputView;
        this.infoCardStub = viewStub;
        this.floatCardContainer = floatCardContainerView;
        this.interceptScope = kotlinx.coroutines.d.a(L0.b(null, 1, null).plus(Y.c().getImmediate()));
        this.cardAnims = new ArrayList();
        this.containerHeightProperty = new c();
    }

    public static final Y8.t C0(int i10, FloatingCardController floatingCardController, FloatCardContainerView floatCardContainerView, E4.p pVar, View view) {
        if (i10 == floatingCardController.cardAnimGeneration && kotlin.jvm.internal.p.d(floatCardContainerView.e(), pVar.getCardId())) {
            view.setTranslationY(0.0f);
            view.setAlpha(1.0f);
            floatingCardController.inputView.F9();
            floatingCardController.x0(floatCardContainerView, pVar, i10);
            return Y8.t.f7040a;
        }
        return Y8.t.f7040a;
    }

    public static final void E0(Ref$BooleanRef ref$BooleanRef, final FloatingCardController floatingCardController, FloatCardContainerView floatCardContainerView, final View view, InterfaceC5063a<Y8.t> interfaceC5063a, final InterfaceC5063a<Y8.t> interfaceC5063a2) {
        if (ref$BooleanRef.f34815a) {
            return;
        }
        ref$BooleanRef.f34815a = true;
        floatingCardController.v1(floatCardContainerView);
        view.setTranslationY(0.0f);
        view.setAlpha(0.0f);
        final int i10 = floatingCardController.inputRevealGeneration + 1;
        floatingCardController.inputRevealGeneration = i10;
        interfaceC5063a.invoke();
        view.post(new Runnable() { // from class: com.stepos.ailauncher.chat.input.controller.q
            @Override // java.lang.Runnable
            public final void run() {
                FloatingCardController.F0(i10, floatingCardController, view, interfaceC5063a2);
            }
        });
    }

    public static final void F0(int i10, FloatingCardController floatingCardController, View view, InterfaceC5063a interfaceC5063a) {
        if (i10 == floatingCardController.inputRevealGeneration) {
            floatingCardController.I0(view, i10, interfaceC5063a);
        } else {
            if (floatingCardController.inputView.getInputContainerHiddenByFloatingCard()) {
                return;
            }
            floatingCardController.f1();
        }
    }

    public static final Y8.t G0(Ref$BooleanRef ref$BooleanRef, FloatingCardController floatingCardController, FloatCardContainerView floatCardContainerView, View view, InterfaceC5063a interfaceC5063a, InterfaceC5063a interfaceC5063a2) {
        E0(ref$BooleanRef, floatingCardController, floatCardContainerView, view, interfaceC5063a, interfaceC5063a2);
        return Y8.t.f7040a;
    }

    public static final void H0(Ref$BooleanRef ref$BooleanRef, FloatingCardController floatingCardController, FloatCardContainerView floatCardContainerView, View view, InterfaceC5063a interfaceC5063a, InterfaceC5063a interfaceC5063a2) {
        E0(ref$BooleanRef, floatingCardController, floatCardContainerView, view, interfaceC5063a, interfaceC5063a2);
    }

    public static final void J0(Ref$BooleanRef ref$BooleanRef, int i10, FloatingCardController floatingCardController, View view, InterfaceC5063a<Y8.t> interfaceC5063a) {
        if (ref$BooleanRef.f34815a) {
            return;
        }
        ref$BooleanRef.f34815a = true;
        if (i10 != floatingCardController.inputRevealGeneration) {
            return;
        }
        floatingCardController.v1(floatingCardController.floatCardContainer);
        view.setTranslationY(0.0f);
        view.setAlpha(1.0f);
        floatingCardController.f1();
        interfaceC5063a.invoke();
    }

    public static final Y8.t K0(Ref$BooleanRef ref$BooleanRef, int i10, FloatingCardController floatingCardController, View view, InterfaceC5063a interfaceC5063a) {
        J0(ref$BooleanRef, i10, floatingCardController, view, interfaceC5063a);
        return Y8.t.f7040a;
    }

    public static final void L0(Ref$BooleanRef ref$BooleanRef, int i10, FloatingCardController floatingCardController, View view, InterfaceC5063a interfaceC5063a) {
        J0(ref$BooleanRef, i10, floatingCardController, view, interfaceC5063a);
    }

    public static final Y8.t N0(FloatingCardController floatingCardController, FloatCardContainerView floatCardContainerView, View view, int i10, Ref$BooleanRef ref$BooleanRef, E4.p pVar) {
        S0(i10, floatingCardController, ref$BooleanRef, floatCardContainerView, pVar, view, floatingCardController.A0(floatCardContainerView, view), false, 128, null);
        return Y8.t.f7040a;
    }

    public static final void O0(Ref$BooleanRef ref$BooleanRef, FloatingCardController floatingCardController, FloatCardContainerView floatCardContainerView, View view, int i10, E4.p pVar) {
        if (ref$BooleanRef.f34815a) {
            return;
        }
        S0(i10, floatingCardController, ref$BooleanRef, floatCardContainerView, pVar, view, floatingCardController.A0(floatCardContainerView, view), false, 128, null);
    }

    public static final void P(FloatingCardController floatingCardController, int i10, FloatCardContainerView floatCardContainerView, E4.p pVar) {
        floatingCardController.cardEnterSafety = null;
        if (i10 == floatingCardController.cardAnimGeneration && kotlin.jvm.internal.p.d(floatCardContainerView.e(), pVar.getCardId())) {
            View view = pVar.getView();
            if (floatCardContainerView.getHeight() > 1 && view.getAlpha() >= 0.99f && floatingCardController.R().getTranslationY() == 0.0f && floatingCardController.R().getAlpha() >= 0.99f) {
                if (floatingCardController.y1(pVar)) {
                    floatingCardController.x0(floatCardContainerView, pVar, i10);
                    return;
                }
                return;
            }
            view.setAlpha(1.0f);
            view.setTranslationY(0.0f);
            if (floatingCardController.y1(pVar)) {
                floatingCardController.inputView.setInputBarHiddenForFloatingCard(true);
            }
            floatingCardController.f1();
            floatingCardController.l1(floatCardContainerView, -2);
            floatingCardController.l1(view, -2);
            floatingCardController.g1(floatCardContainerView);
            if (floatingCardController.y1(pVar)) {
                floatingCardController.x0(floatCardContainerView, pVar, i10);
            }
        }
    }

    public static final void P0(final FloatingCardController floatingCardController, final FloatCardContainerView floatCardContainerView, final View view, final int i10, final Ref$BooleanRef ref$BooleanRef, final E4.p pVar) {
        int iA0 = floatingCardController.A0(floatCardContainerView, view);
        if (iA0 > 0) {
            S0(i10, floatingCardController, ref$BooleanRef, floatCardContainerView, pVar, view, iA0, false, 128, null);
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.stepos.ailauncher.chat.input.controller.c
            @Override // java.lang.Runnable
            public final void run() {
                FloatingCardController.Q0(this.f25387a, floatCardContainerView, view, i10, ref$BooleanRef, pVar);
            }
        };
        floatCardContainerView.postDelayed(runnable, 150L);
        floatingCardController.cardAnimFallback = runnable;
    }

    public static final void Q0(FloatingCardController floatingCardController, FloatCardContainerView floatCardContainerView, View view, int i10, Ref$BooleanRef ref$BooleanRef, E4.p pVar) {
        R0(i10, floatingCardController, ref$BooleanRef, floatCardContainerView, pVar, view, floatingCardController.A0(floatCardContainerView, view), true);
    }

    public static final void R0(int i10, final FloatingCardController floatingCardController, Ref$BooleanRef ref$BooleanRef, final FloatCardContainerView floatCardContainerView, E4.p pVar, final View view, int i11, boolean z10) {
        if (i10 == floatingCardController.cardAnimGeneration && !ref$BooleanRef.f34815a && kotlin.jvm.internal.p.d(floatCardContainerView.e(), pVar.getCardId())) {
            floatingCardController.cardExitRunning = false;
            floatCardContainerView.setTranslationY(0.0f);
            if (i11 > 0 || z10) {
                if (i11 <= 0 && z10) {
                    ref$BooleanRef.f34815a = true;
                    Runnable runnable = floatingCardController.cardAnimFallback;
                    if (runnable != null) {
                        floatCardContainerView.removeCallbacks(runnable);
                    }
                    floatingCardController.cardAnimFallback = null;
                    view.setAlpha(1.0f);
                    view.setTranslationY(0.0f);
                    if (floatingCardController.y1(pVar)) {
                        floatingCardController.inputView.setInputBarHiddenForFloatingCard(true);
                        floatingCardController.f1();
                    }
                    floatingCardController.l1(floatCardContainerView, -2);
                    if (floatingCardController.y1(pVar)) {
                        floatingCardController.x0(floatCardContainerView, pVar, i10);
                        return;
                    }
                    return;
                }
                ref$BooleanRef.f34815a = true;
                Runnable runnable2 = floatingCardController.cardAnimFallback;
                if (runnable2 != null) {
                    floatCardContainerView.removeCallbacks(runnable2);
                }
                floatingCardController.cardAnimFallback = null;
                if (floatingCardController.y1(pVar)) {
                    floatingCardController.B0(floatCardContainerView, pVar, i11, i10);
                    return;
                }
                float f10 = floatCardContainerView.getResources().getDisplayMetrics().density;
                i0 i0Var = i0.INSTANCE;
                SheetSpring sheetSpringE = i0Var.c().e(1.2f, 1.2f);
                view.setTranslationY(f10 * SHELL_ENTER_DY_DP);
                e.s TRANSLATION_Y = androidx.dynamicanimation.animation.e.f13691o;
                kotlin.jvm.internal.p.h(TRANSLATION_Y, "TRANSLATION_Y");
                floatingCardController.q1(view, TRANSLATION_Y, 0.0f, 1.0f, sheetSpringE, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.input.controller.z
                    @Override // p9.InterfaceC5063a
                    public final Object invoke() {
                        return FloatingCardController.T0(view);
                    }
                });
                e.s ALPHA = androidx.dynamicanimation.animation.e.f13701y;
                kotlin.jvm.internal.p.h(ALPHA, "ALPHA");
                s1(floatingCardController, view, ALPHA, 1.0f, 0.00390625f, i0Var.b(), null, 32, null);
                floatingCardController.l1(view, i11);
                floatingCardController.r1(floatCardContainerView, floatingCardController.containerHeightProperty, i11, 1.0f, sheetSpringE, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.input.controller.A
                    @Override // p9.InterfaceC5063a
                    public final Object invoke() {
                        return FloatingCardController.U0(view, floatingCardController, floatCardContainerView);
                    }
                });
            }
        }
    }

    public static /* synthetic */ void S0(int i10, FloatingCardController floatingCardController, Ref$BooleanRef ref$BooleanRef, FloatCardContainerView floatCardContainerView, E4.p pVar, View view, int i11, boolean z10, int i12, Object obj) {
        R0(i10, floatingCardController, ref$BooleanRef, floatCardContainerView, pVar, view, i11, (i12 & 128) != 0 ? false : z10);
    }

    public static final Y8.t T0(View view) {
        view.setTranslationY(0.0f);
        return Y8.t.f7040a;
    }

    public static /* synthetic */ FloatCardRequest U(FloatingCardController floatingCardController, String str, String str2, String str3, String str4, String str5, List list, String str6, boolean z10, int i10, Object obj) {
        return floatingCardController.T(str, str2, str3, str4, str5, list, (i10 & 64) != 0 ? RISK_BUSINESS_TYPE : str6, (i10 & 128) != 0 ? true : z10);
    }

    public static final Y8.t U0(View view, FloatingCardController floatingCardController, FloatCardContainerView floatCardContainerView) {
        view.setTranslationY(0.0f);
        floatingCardController.l1(floatCardContainerView, -2);
        floatingCardController.l1(view, -2);
        floatingCardController.inputView.F9();
        return Y8.t.f7040a;
    }

    public static final void W0(Ref$BooleanRef ref$BooleanRef, FloatingCardController floatingCardController, View view, boolean z10, FloatCardContainerView floatCardContainerView, boolean z11, InterfaceC5063a<Y8.t> interfaceC5063a) {
        if (ref$BooleanRef.f34815a) {
            return;
        }
        ref$BooleanRef.f34815a = true;
        floatingCardController.u0(view, z10);
        floatingCardController.l1(floatCardContainerView, 0);
        floatCardContainerView.setClipChildren(z11);
        floatCardContainerView.setTranslationY(0.0f);
        floatingCardController.W(floatCardContainerView);
        floatingCardController.cardExitRunning = false;
        interfaceC5063a.invoke();
        floatingCardController.r0();
    }

    public static final Y8.t X0(InterfaceC5063a interfaceC5063a) {
        interfaceC5063a.invoke();
        return Y8.t.f7040a;
    }

    public static final Y8.t Y0(FloatingCardController floatingCardController) {
        floatingCardController.cardExitRunning = false;
        floatingCardController.r0();
        return Y8.t.f7040a;
    }

    public static /* synthetic */ void Z(FloatingCardController floatingCardController, FloatCardContainerView floatCardContainerView, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            floatCardContainerView = floatingCardController.floatCardContainer;
        }
        floatingCardController.Y(floatCardContainerView);
    }

    public static final void Z0(int i10, Ref$BooleanRef ref$BooleanRef, FloatingCardController floatingCardController, View view, boolean z10, FloatCardContainerView floatCardContainerView, boolean z11, InterfaceC5063a interfaceC5063a, androidx.dynamicanimation.animation.e eVar, float f10, float f11) {
        if (f10 <= i10 + 1.0f) {
            W0(ref$BooleanRef, floatingCardController, view, z10, floatCardContainerView, z11, interfaceC5063a);
        }
    }

    public static final void a1(Ref$BooleanRef ref$BooleanRef, FloatingCardController floatingCardController, View view, boolean z10, FloatCardContainerView floatCardContainerView, boolean z11, InterfaceC5063a interfaceC5063a, androidx.dynamicanimation.animation.e eVar, boolean z12, float f10, float f11) {
        if (z12) {
            return;
        }
        W0(ref$BooleanRef, floatingCardController, view, z10, floatCardContainerView, z11, interfaceC5063a);
    }

    public static final void b1(Ref$BooleanRef ref$BooleanRef, FloatingCardController floatingCardController, View view, boolean z10, FloatCardContainerView floatCardContainerView, boolean z11, InterfaceC5063a interfaceC5063a) {
        W0(ref$BooleanRef, floatingCardController, view, z10, floatCardContainerView, z11, interfaceC5063a);
    }

    public static /* synthetic */ void c0(FloatingCardController floatingCardController, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        floatingCardController.b0(z10);
    }

    public static /* synthetic */ void g0(FloatingCardController floatingCardController, String str, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        if ((i10 & 4) != 0) {
            z11 = z10;
        }
        floatingCardController.f0(str, z10, z11);
    }

    public static /* synthetic */ void k1(FloatingCardController floatingCardController, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z11 = false;
        }
        floatingCardController.j1(z10, z11);
    }

    public static final Y8.t m0(final FloatingCardController floatingCardController, boolean z10, FloatCardOptions options) {
        kotlin.jvm.internal.p.i(options, "options");
        if (options.getHideChatViewOnShow()) {
            if (!z10) {
                floatingCardController.inputView.setInputBarHiddenForFloatingCard(false);
                floatingCardController.M(0.0f);
                floatingCardController.inputView.post(new Runnable() { // from class: com.stepos.ailauncher.chat.input.controller.u
                    @Override // java.lang.Runnable
                    public final void run() {
                        FloatingCardController.n0(this.f25462a);
                    }
                });
            }
            floatingCardController.d1();
        } else {
            floatingCardController.inputView.setInputBarSingleLineForFloatingCard(z10);
            floatingCardController.M(0.0f);
            floatingCardController.d1();
        }
        floatingCardController.j1(z10, z10);
        return Y8.t.f7040a;
    }

    public static final void n0(FloatingCardController floatingCardController) {
        BaseInputView.N6(floatingCardController.inputView, false, false, 2, null);
    }

    public static final Y8.t o0(FloatingCardController floatingCardController, FloatCardContainerView floatCardContainerView, E4.p card) {
        kotlin.jvm.internal.p.i(card, "card");
        floatingCardController.M0(floatCardContainerView, card);
        return Y8.t.f7040a;
    }

    public static final Y8.t p0(FloatingCardController floatingCardController, final FloatCardContainerView floatCardContainerView, final E4.p card, final InterfaceC5063a onEnd) {
        kotlin.jvm.internal.p.i(card, "card");
        kotlin.jvm.internal.p.i(onEnd, "onEnd");
        floatingCardController.V0(floatCardContainerView, card, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.input.controller.y
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return FloatingCardController.q0(floatCardContainerView, card, onEnd);
            }
        });
        return Y8.t.f7040a;
    }

    public static final Y8.t q0(FloatCardContainerView floatCardContainerView, E4.p pVar, InterfaceC5063a interfaceC5063a) {
        if (kotlin.jvm.internal.p.d(floatCardContainerView.e(), pVar.getCardId())) {
            interfaceC5063a.invoke();
        }
        return Y8.t.f7040a;
    }

    public static /* synthetic */ void s1(FloatingCardController floatingCardController, View view, e.s sVar, float f10, float f11, SheetSpring sheetSpring, InterfaceC5063a interfaceC5063a, int i10, Object obj) {
        if ((i10 & 32) != 0) {
            interfaceC5063a = null;
        }
        floatingCardController.q1(view, sVar, f10, f11, sheetSpring, interfaceC5063a);
    }

    public static final void t1(InterfaceC5063a interfaceC5063a, androidx.dynamicanimation.animation.e eVar, boolean z10, float f10, float f11) {
        if (z10) {
            return;
        }
        interfaceC5063a.invoke();
    }

    public static final void u1(InterfaceC5063a interfaceC5063a, androidx.dynamicanimation.animation.e eVar, boolean z10, float f10, float f11) {
        if (z10) {
            return;
        }
        interfaceC5063a.invoke();
    }

    public static final void y0(int i10, FloatingCardController floatingCardController, FloatCardContainerView floatCardContainerView, E4.p pVar) {
        if (i10 == floatingCardController.cardAnimGeneration && kotlin.jvm.internal.p.d(floatCardContainerView.e(), pVar.getCardId())) {
            floatingCardController.inputView.M6(false, true);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int A0(View container, View shell) {
        int width = container.getWidth();
        if (width <= 0) {
            return 0;
        }
        E4.o oVar = shell instanceof E4.o ? (E4.o) shell : null;
        View contentView = oVar != null ? oVar.getContentView() : null;
        if (contentView != null) {
            contentView.measure(View.MeasureSpec.makeMeasureSpec(width, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
            if (contentView.getMeasuredHeight() > 0) {
                return contentView.getMeasuredHeight();
            }
        }
        shell.measure(View.MeasureSpec.makeMeasureSpec(width, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        return shell.getMeasuredHeight();
    }

    public final void B0(final FloatCardContainerView container, final E4.p card, int heightPx, final int enterGeneration) {
        View view = card.getView();
        final View viewR = R();
        float fB = C2656a.INSTANCE.b(viewR);
        view.setAlpha(1.0f);
        view.setTranslationY(0.0f);
        BaseInputView.N6(this.inputView, true, false, 2, null);
        this.inputView.setInputBarHiddenForFloatingCard(true);
        M(16.0f);
        l1(view, heightPx);
        l1(container, heightPx);
        L();
        this.inputView.H9();
        viewR.animate().cancel();
        viewR.setAlpha(0.0f);
        viewR.setTranslationY(fB);
        Q(viewR);
        e.s TRANSLATION_Y = androidx.dynamicanimation.animation.e.f13691o;
        kotlin.jvm.internal.p.h(TRANSLATION_Y, "TRANSLATION_Y");
        q1(viewR, TRANSLATION_Y, 0.0f, 1.0f, RISK_CARD_POSITION_SPRING, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.input.controller.p
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return FloatingCardController.C0(enterGeneration, this, container, card, viewR);
            }
        });
        e.s ALPHA = androidx.dynamicanimation.animation.e.f13701y;
        kotlin.jvm.internal.p.h(ALPHA, "ALPHA");
        s1(this, viewR, ALPHA, 1.0f, 0.00390625f, RISK_CARD_ENTER_FADE_SPRING, null, 32, null);
    }

    public final void D0(final FloatCardContainerView container, E4.p card, final InterfaceC5063a<Y8.t> onCardGone, final InterfaceC5063a<Y8.t> onSettled) {
        int iIntValue;
        Y(container);
        W(container);
        View view = card.getView();
        final View viewR = R();
        Integer numValueOf = Integer.valueOf(container.getHeight());
        if (numValueOf.intValue() <= 0) {
            numValueOf = null;
        }
        if (numValueOf != null) {
            iIntValue = numValueOf.intValue();
        } else {
            Integer numValueOf2 = Integer.valueOf(view.getHeight());
            Integer num = numValueOf2.intValue() > 0 ? numValueOf2 : null;
            iIntValue = num != null ? num.intValue() : A0(container, view);
        }
        if (iIntValue <= 0) {
            f1();
            onCardGone.invoke();
            onSettled.invoke();
            return;
        }
        view.setAlpha(1.0f);
        view.setTranslationY(0.0f);
        viewR.setAlpha(1.0f);
        viewR.setTranslationY(0.0f);
        Q(viewR);
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        e.s TRANSLATION_Y = androidx.dynamicanimation.animation.e.f13691o;
        kotlin.jvm.internal.p.h(TRANSLATION_Y, "TRANSLATION_Y");
        s1(this, viewR, TRANSLATION_Y, C2656a.INSTANCE.b(viewR), 1.0f, RISK_CARD_POSITION_SPRING, null, 32, null);
        e.s ALPHA = androidx.dynamicanimation.animation.e.f13701y;
        kotlin.jvm.internal.p.h(ALPHA, "ALPHA");
        q1(viewR, ALPHA, 0.0f, 0.00390625f, RISK_CARD_EXIT_FADE_SPRING, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.input.controller.k
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return FloatingCardController.G0(ref$BooleanRef, this, container, viewR, onCardGone, onSettled);
            }
        });
        Runnable runnable = new Runnable() { // from class: com.stepos.ailauncher.chat.input.controller.l
            @Override // java.lang.Runnable
            public final void run() {
                FloatingCardController.H0(ref$BooleanRef, this, container, viewR, onCardGone, onSettled);
            }
        };
        container.postDelayed(runnable, EXIT_FALLBACK_MS);
        this.cardAnimFallback = runnable;
    }

    public final void I0(final View layer, final int reveal, final InterfaceC5063a<Y8.t> onSettled) {
        if (reveal != this.inputRevealGeneration) {
            return;
        }
        if (this.inputView.getInputContainerHiddenByFloatingCard()) {
            this.inputView.setInputBarHiddenForFloatingCard(false);
        }
        layer.animate().cancel();
        layer.setTranslationY(0.0f);
        layer.setAlpha(0.0f);
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        Log.i(TAG, "playBottomSlideInputReveal fade-only");
        e.s ALPHA = androidx.dynamicanimation.animation.e.f13701y;
        kotlin.jvm.internal.p.h(ALPHA, "ALPHA");
        q1(layer, ALPHA, 1.0f, 0.00390625f, RISK_CARD_ENTER_FADE_SPRING, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.input.controller.r
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return FloatingCardController.K0(ref$BooleanRef, reveal, this, layer, onSettled);
            }
        });
        Runnable runnable = new Runnable() { // from class: com.stepos.ailauncher.chat.input.controller.s
            @Override // java.lang.Runnable
            public final void run() {
                FloatingCardController.L0(ref$BooleanRef, reveal, this, layer, onSettled);
            }
        };
        this.inputView.postDelayed(runnable, EXIT_FALLBACK_MS);
        this.cardAnimFallback = runnable;
    }

    public final void L() {
        this.inputView.setFloatingCardInputBarGlass(true);
    }

    public final void M(float dp) {
        int i10;
        View view = this.floatCardSlot;
        if (view == null || view.getPaddingBottom() == (i10 = (int) ((dp * this.inputView.getResources().getDisplayMetrics().density) + 0.5f))) {
            return;
        }
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), i10);
    }

    public final void M0(final FloatCardContainerView container, final E4.p card) {
        E4.o oVar = card instanceof E4.o ? (E4.o) card : null;
        if (oVar == null) {
            return;
        }
        W(container);
        this.pendingUnregisterAfterExit = false;
        k0(container);
        final int i10 = this.cardAnimGeneration;
        final View view = card.getView();
        view.setVisibility(0);
        if (y1(card)) {
            view.setAlpha(1.0f);
            view.setTranslationY(0.0f);
        } else {
            view.setAlpha(0.0f);
            view.setTranslationY(0.0f);
        }
        l1(container, 0);
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        oVar.setOnContentHeightSettled(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.input.controller.v
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return FloatingCardController.N0(this.f25463a, container, view, i10, ref$BooleanRef, card);
            }
        });
        container.post(new Runnable() { // from class: com.stepos.ailauncher.chat.input.controller.w
            @Override // java.lang.Runnable
            public final void run() {
                FloatingCardController.O0(ref$BooleanRef, this, container, view, i10, card);
            }
        });
        Runnable runnable = new Runnable() { // from class: com.stepos.ailauncher.chat.input.controller.x
            @Override // java.lang.Runnable
            public final void run() {
                FloatingCardController.P0(this.f25475a, container, view, i10, ref$BooleanRef, card);
            }
        };
        container.postDelayed(runnable, 150L);
        this.cardAnimFallback = runnable;
        O(container, card);
    }

    public final void N() {
        boolean z10 = this.cardWantsFullscreenIntercept;
        com.stepos.ailauncher.common.utils.v vVar = com.stepos.ailauncher.common.utils.v.INSTANCE;
        boolean zB = B.b(z10, vVar.j());
        this.passthroughChatList = zB && this.interceptAllowChatScroll;
        if (zB) {
            b bVar = this.fullscreenTouchIntercept;
            if ((bVar != null ? bVar.getParent() : null) != null) {
                bVar.bringToFront();
                return;
            }
            View rootView = this.inputView.getRootView();
            ViewGroup viewGroup = rootView instanceof ViewGroup ? (ViewGroup) rootView : null;
            if (viewGroup == null) {
                Log.w(TAG, "setFullscreenTouchIntercept: rootView not ViewGroup");
                return;
            }
            if (bVar == null) {
                Context context = this.inputView.getContext();
                kotlin.jvm.internal.p.h(context, "getContext(...)");
                bVar = new b(this, context);
                this.fullscreenTouchIntercept = bVar;
            }
            if (bVar.getParent() != viewGroup) {
                ViewParent parent = bVar.getParent();
                ViewGroup viewGroup2 = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                if (viewGroup2 != null) {
                    viewGroup2.removeView(bVar);
                }
                viewGroup.addView(bVar, new ViewGroup.LayoutParams(-1, -1));
            }
            bVar.bringToFront();
            Log.i(TAG, "fullscreen touch intercept attached");
            return;
        }
        this.passthroughChatList = false;
        b bVar2 = this.fullscreenTouchIntercept;
        if (bVar2 == null) {
            return;
        }
        if (bVar2.getParent() == null && !this.cardWantsFullscreenIntercept) {
            this.fullscreenTouchIntercept = null;
            return;
        }
        ViewParent parent2 = bVar2.getParent();
        ViewGroup viewGroup3 = parent2 instanceof ViewGroup ? (ViewGroup) parent2 : null;
        if (viewGroup3 != null) {
            viewGroup3.removeView(bVar2);
        }
        if (!this.cardWantsFullscreenIntercept) {
            this.fullscreenTouchIntercept = null;
        }
        Log.i(TAG, "fullscreen touch intercept removed body=" + vVar.j() + " card=" + this.cardWantsFullscreenIntercept);
    }

    public final void O(final FloatCardContainerView container, final E4.p card) {
        Y(container);
        final int i10 = this.cardAnimGeneration;
        Runnable runnable = new Runnable() { // from class: com.stepos.ailauncher.chat.input.controller.d
            @Override // java.lang.Runnable
            public final void run() {
                FloatingCardController.P(this.f25393a, i10, container, card);
            }
        };
        container.postDelayed(runnable, ENTER_SAFETY_MS);
        this.cardEnterSafety = runnable;
    }

    public final void Q(View layer) {
        if (this.ancestorClipSaved != null) {
            return;
        }
        this.ancestorClipSaved = C2656a.INSTANCE.c(layer);
    }

    public final View R() {
        ViewGroup mainInput = this.inputView.getMainInput();
        if (mainInput != null) {
            return mainInput;
        }
        View view = this.floatCardSlot;
        if (view != null) {
            return view;
        }
        FloatCardContainerView floatCardContainerView = this.floatCardContainer;
        return floatCardContainerView != null ? floatCardContainerView : this.inputView;
    }

    public final FloatCardRequest S(String inquiryId, List<AskUserInquiry> inquiries) {
        List<AskUserInquiry> list = inquiries;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        int i10 = 0;
        for (Object obj : list) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            AskUserInquiry askUserInquiry = (AskUserInquiry) obj;
            String question = askUserInquiry.getQuestion();
            String str = "q" + i10;
            List<String> listA = askUserInquiry.a();
            ArrayList arrayList2 = new ArrayList(C1174w.x(listA, 10));
            for (String str2 : listA) {
                arrayList2.add(new FloatCardOption(str2, str2, false, false, false, 28, null));
            }
            arrayList.add(new FloatCardPage(question, null, null, null, C1172u.e(new g.Selection(str, null, arrayList2, SelectionMode.Single, FloatCardOptionStyle.Plain, true, 2, null)), FloatCardSkipMode.Enabled, null, null, null, null, 974, null));
            i10 = i11;
        }
        return new FloatCardRequest(X(inquiryId), "common_form", "ask_user", FloatCardScene.Chat, new FloatCardContent(arrayList, null, null, null, null, 30, null), new FloatCardOptions(false, true, true, true, true), null, 64, null);
    }

    public final FloatCardRequest T(String requestId, String title, String body, String riskLevel, String riskBadgeLabel, List<RiskCardButton> buttons, String businessType, boolean hostDrivenEnterAnim) {
        String str;
        String str2;
        String str3;
        FloatingCardController floatingCardController;
        String strX = X(requestId);
        FloatCardScene floatCardScene = FloatCardScene.Chat;
        if (body == null || La.H.x0(body)) {
            str = riskLevel;
            str2 = riskBadgeLabel;
            str3 = null;
            floatingCardController = this;
        } else {
            floatingCardController = this;
            str3 = body;
            str = riskLevel;
            str2 = riskBadgeLabel;
        }
        FloatCardRiskBadge floatCardRiskBadgeI1 = floatingCardController.i1(str, str2);
        List<RiskCardButton> list = buttons;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        for (RiskCardButton riskCardButton : list) {
            arrayList.add(new FloatCardOption(riskCardButton.getId(), riskCardButton.getText(), false, false, false, 28, null));
        }
        return new FloatCardRequest(strX, "common_form", businessType, floatCardScene, new FloatCardContent(C1172u.e(new FloatCardPage(title, str3, null, null, C1172u.e(new g.Selection("risk", null, arrayList, SelectionMode.Single, FloatCardOptionStyle.Plain, true, 2, null)), FloatCardSkipMode.Hidden, null, null, null, floatCardRiskBadgeI1, 460, null)), null, null, null, null, 30, null), new FloatCardOptions(true, true, true, hostDrivenEnterAnim, true), null, 64, null);
    }

    public final boolean V() {
        if (this.inputView.isShown() || this.inputView.hasWindowFocus()) {
            return true;
        }
        Context context = this.inputView.getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        return com.stepos.ailauncher.floatcard.c.a(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0061 A[PHI: r0
      0x0061: PHI (r0v15 java.lang.Integer) = (r0v4 java.lang.Integer), (r0v7 java.lang.Integer) binds: [B:16:0x005f, B:22:0x0076] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void V0(final com.stepos.agentframework.floatcard.view.FloatCardContainerView r13, E4.p r14, final p9.InterfaceC5063a<Y8.t> r15) {
        /*
            Method dump skipped, instructions count: 318
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.input.controller.FloatingCardController.V0(com.stepos.agentframework.floatcard.view.FloatCardContainerView, E4.p, p9.a):void");
    }

    public final void W(FloatCardContainerView container) {
        this.inputRevealGeneration++;
        v1(container);
        C2656a.INSTANCE.a(this.ancestorClipSaved);
        this.ancestorClipSaved = null;
        g1(container);
        k0(container);
    }

    public final String X(String taskId) {
        return "input_card_" + taskId;
    }

    public final void Y(FloatCardContainerView container) {
        if (container == null) {
            return;
        }
        Runnable runnable = this.cardEnterSafety;
        if (runnable != null) {
            container.removeCallbacks(runnable);
        }
        this.cardEnterSafety = null;
    }

    public final void a0() {
        this.currentTaskId = null;
        this.currentCardId = null;
        this.pendingOnSubmit = null;
        this.pendingOnCancel = null;
        this.pendingInquirySubmit = null;
        this.currentInquirySessionId = null;
        this.inquiryPage = null;
        this.inquiryShownAt = 0L;
        this.inquiryEventHandler = null;
        this.pendingRiskChoice = null;
        this.pendingRiskCancel = null;
        this.riskChoiceDelivered = false;
        this.riskEventHandler = null;
        this.currentApprovalSessionId = null;
    }

    public final void b0(boolean cancelRisk) {
        IFloatCardService iFloatCardServiceS0;
        IFloatCardService iFloatCardServiceS02;
        this.cardAnimGeneration++;
        FloatCardContainerView floatCardContainerView = this.floatCardContainer;
        E4.p currentCard = floatCardContainerView != null ? floatCardContainerView.getCurrentCard() : null;
        E4.o oVar = currentCard instanceof E4.o ? (E4.o) currentCard : null;
        if (oVar != null) {
            oVar.setOnContentHeightSettled(null);
        }
        Z(this, null, 1, null);
        FloatCardContainerView floatCardContainerView2 = this.floatCardContainer;
        if (floatCardContainerView2 != null) {
            W(floatCardContainerView2);
        } else {
            this.inputRevealGeneration++;
            Iterator<T> it = this.cardAnims.iterator();
            while (it.hasNext()) {
                ((androidx.dynamicanimation.animation.i) it.next()).d();
            }
            this.cardAnims.clear();
            this.cardAnimFallback = null;
        }
        h1();
        d1();
        this.cardExitRunning = false;
        this.inputView.setInputBarSingleLineForFloatingCard(false);
        IFloatCardEventHandler iFloatCardEventHandler = this.inquiryEventHandler;
        if (iFloatCardEventHandler != null && (iFloatCardServiceS02 = s0()) != null) {
            iFloatCardServiceS02.unregisterEventHandler(iFloatCardEventHandler.getBusinessType());
        }
        String str = this.currentTaskId;
        InterfaceC5063a<Y8.t> interfaceC5063a = this.pendingRiskCancel;
        boolean z10 = this.riskChoiceDelivered;
        IFloatCardEventHandler iFloatCardEventHandler2 = this.riskEventHandler;
        if (iFloatCardEventHandler2 != null && (iFloatCardServiceS0 = s0()) != null) {
            iFloatCardServiceS0.unregisterEventHandler(iFloatCardEventHandler2.getBusinessType());
        }
        a0();
        if (cancelRisk && interfaceC5063a != null && !z10) {
            interfaceC5063a.invoke();
            return;
        }
        if (interfaceC5063a == null || z10) {
            return;
        }
        Log.i(TAG, "clearState: keep risk request alive taskId=" + str);
    }

    public final void c1() {
        FloatingCardController floatingCardController;
        if (this.currentTaskId != null) {
            floatingCardController = this;
            g0(floatingCardController, null, false, false, 5, null);
        } else {
            floatingCardController = this;
        }
        k1(floatingCardController, false, false, 2, null);
        floatingCardController.x1();
    }

    /* renamed from: d0, reason: from getter */
    public final String getCurrentTaskId() {
        return this.currentTaskId;
    }

    public final void d1() {
        C2851i7.INSTANCE.h(this.riskCardGlassHandle);
        this.riskCardGlassHandle = null;
    }

    public final E4.e e0(String chosen) {
        this.riskChoiceDelivered = true;
        InterfaceC5074l<? super String, Y8.t> interfaceC5074l = this.pendingRiskChoice;
        this.pendingRiskChoice = null;
        this.pendingRiskCancel = null;
        c0(this, false, 1, null);
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(chosen);
        }
        return e.a.INSTANCE;
    }

    public final void e1(String action) {
        M5.c cVar = M5.c.INSTANCE;
        String str = this.currentInquirySessionId;
        Long lValueOf = Long.valueOf(this.inquiryShownAt);
        if (!(lValueOf.longValue() > 0)) {
            lValueOf = null;
        }
        cVar.g(str, M5.c.CONFIRM_CARD, action, lValueOf != null ? Long.valueOf(System.currentTimeMillis() - lValueOf.longValue()) : null, this.inquiryPage);
    }

    public final void f0(String taskId, boolean cancelRisk, boolean animate) {
        String str = this.currentTaskId;
        if (str == null) {
            return;
        }
        if (taskId != null && !kotlin.jvm.internal.p.d(taskId, str)) {
            Log.d(TAG, "dismiss: taskId mismatch active=" + str + " requested=" + taskId + ", skip");
            return;
        }
        String str2 = this.currentCardId;
        if (str2 != null) {
            IFloatCardService iFloatCardServiceS0 = s0();
            String strHostIdOf = iFloatCardServiceS0 != null ? iFloatCardServiceS0.hostIdOf(str2) : null;
            G4.h hVar = this.floatCardHost;
            if (!kotlin.jvm.internal.p.d(strHostIdOf, hVar != null ? hVar.getHostId() : null)) {
                Log.i(TAG, "dismiss: taskId=" + str + " cardId=" + str2 + " owned by another host, keep card+handler");
                a0();
                x1();
                return;
            }
        }
        b0(cancelRisk);
        if (str2 != null) {
            this.pendingUnregisterAfterExit = animate;
            IFloatCardService iFloatCardServiceS02 = s0();
            if (iFloatCardServiceS02 != null) {
                iFloatCardServiceS02.dismiss(str2, animate);
            }
            if (!animate) {
                p1();
                x1();
            }
        } else {
            x1();
        }
        Log.i(TAG, "dismiss: taskId=" + str + " cardId=" + str2 + " cancelRisk=" + cancelRisk + " animate=" + animate);
    }

    public final void f1() {
        ViewPropertyAnimator viewPropertyAnimatorAnimate;
        ViewPropertyAnimator viewPropertyAnimatorAnimate2;
        View view = this.floatCardSlot;
        if (view == null) {
            view = this.floatCardContainer;
        }
        if (view != null && (viewPropertyAnimatorAnimate2 = view.animate()) != null) {
            viewPropertyAnimatorAnimate2.cancel();
        }
        if (view != null) {
            view.setAlpha(1.0f);
        }
        if (view != null) {
            view.setTranslationY(0.0f);
        }
        ViewGroup mainInput = this.inputView.getMainInput();
        if (mainInput != null && (viewPropertyAnimatorAnimate = mainInput.animate()) != null) {
            viewPropertyAnimatorAnimate.cancel();
        }
        ViewGroup mainInput2 = this.inputView.getMainInput();
        if (mainInput2 != null) {
            mainInput2.setAlpha(1.0f);
        }
        ViewGroup mainInput3 = this.inputView.getMainInput();
        if (mainInput3 != null) {
            mainInput3.setTranslationY(0.0f);
        }
        C2656a.INSTANCE.a(this.ancestorClipSaved);
        this.ancestorClipSaved = null;
        d1();
    }

    public final void g1(FloatCardContainerView container) {
        Boolean bool = this.containerClipSaved;
        if (bool != null) {
            container.setClipChildren(bool.booleanValue());
            this.containerClipSaved = null;
        }
    }

    public final boolean h0(String currentSessionId) {
        if (this.pendingInquirySubmit == null && this.currentInquirySessionId == null && this.currentApprovalSessionId == null) {
            return false;
        }
        String str = this.currentInquirySessionId;
        if (str == null) {
            str = this.currentApprovalSessionId;
        }
        SessionHandler sessionHandler = this.inputView.getSessionHandler();
        if (sessionHandler != null ? sessionHandler.z3(str, currentSessionId) : (str == null || str.length() == 0 || !kotlin.jvm.internal.p.d(str, currentSessionId)) ? false : true) {
            return false;
        }
        Log.i(TAG, "dismissInquiryIfNotSession: card session=" + str + " != cur=" + currentSessionId + ", dismiss");
        g0(this, null, false, false, 5, null);
        return true;
    }

    public final void h1() {
        this.inputView.setFloatingCardInputBarGlass(false);
    }

    public final FloatCardContainerView i0() {
        Object objB;
        FloatCardContainerView floatCardContainerView;
        View view;
        FloatCardContainerView floatCardContainerView2 = this.floatCardContainer;
        if (floatCardContainerView2 != null) {
            if (this.floatCardSlot == null) {
                Object parent = floatCardContainerView2.getParent();
                view = parent instanceof View ? (View) parent : null;
                if (view == null) {
                    view = floatCardContainerView2;
                }
                this.floatCardSlot = view;
            }
            return floatCardContainerView2;
        }
        FloatCardContainerView floatCardContainerView3 = (FloatCardContainerView) this.inputView.findViewById(com.stepos.ailauncher.chat.R$id.float_card_container);
        if (floatCardContainerView3 != null) {
            this.floatCardContainer = floatCardContainerView3;
            Object parent2 = floatCardContainerView3.getParent();
            view = parent2 instanceof View ? (View) parent2 : null;
            if (view == null) {
                view = floatCardContainerView3;
            }
            this.floatCardSlot = view;
            return floatCardContainerView3;
        }
        ViewStub viewStub = this.infoCardStub;
        if (viewStub == null) {
            View viewFindViewById = this.inputView.findViewById(com.stepos.ailauncher.chat.R$id.vsInfoCard);
            kotlin.jvm.internal.p.h(viewFindViewById, "findViewById(...)");
            viewStub = (ViewStub) viewFindViewById;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(viewStub.inflate());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.w(TAG, "ensureContainer: inflate failed", thE);
        }
        if (Result.g(objB)) {
            objB = null;
        }
        View view2 = (View) objB;
        if (view2 == null) {
            return null;
        }
        ViewGroup viewGroup = view2 instanceof ViewGroup ? (ViewGroup) view2 : null;
        if (viewGroup != null && (floatCardContainerView = (FloatCardContainerView) viewGroup.findViewById(com.stepos.ailauncher.chat.R$id.float_card_container)) != null) {
            this.floatCardContainer = floatCardContainerView;
            this.floatCardSlot = view2;
            return floatCardContainerView;
        }
        Log.w(TAG, "ensureContainer: float_card_container not found in inflated root " + view2.getClass().getName());
        return null;
    }

    public final FloatCardRiskBadge i1(String riskLevel, String label) {
        if (label != null && !La.H.x0(label)) {
            String lowerCase = riskLevel.toLowerCase(Locale.ROOT);
            kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
            if (kotlin.jvm.internal.p.d(lowerCase, "high")) {
                return new FloatCardRiskBadge(FloatCardRiskLevel.High, label, null, null, 12, null);
            }
        }
        return null;
    }

    public final void j0() {
        kotlinx.coroutines.g gVar = this.conversationBodyJob;
        if (gVar == null || !gVar.b()) {
            this.conversationBodyJob = C1060i.d(this.interceptScope, null, null, new FloatingCardController$ensureConversationBodyObserver$1(this, null), 3, null);
        }
    }

    public final void j1(boolean enabled, boolean allowChatScroll) {
        this.cardWantsFullscreenIntercept = enabled;
        this.interceptAllowChatScroll = allowChatScroll;
        if (enabled) {
            j0();
        } else {
            w1();
        }
        N();
    }

    public final void k0(FloatCardContainerView container) {
        ViewGroup.LayoutParams layoutParams = container.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams == null) {
            return;
        }
        int i10 = this.floatingCardDefaultTopMarginPx;
        if (i10 <= 0) {
            i10 = marginLayoutParams.topMargin;
            if (i10 > 0) {
                this.floatingCardDefaultTopMarginPx = i10;
            } else {
                i10 = (int) ((container.getResources().getDisplayMetrics().density * 16.0f) + 0.5f);
                this.floatingCardDefaultTopMarginPx = i10;
            }
        }
        if (marginLayoutParams.topMargin == i10) {
            return;
        }
        marginLayoutParams.topMargin = i10;
        container.setLayoutParams(marginLayoutParams);
    }

    public final void l0(final FloatCardContainerView container) {
        if (this.floatCardHost != null) {
            return;
        }
        String str = "input_view_info_card_" + System.identityHashCode(this.inputView);
        Context context = this.inputView.getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        G4.h hVar = new G4.h(str, 90, context, container, Z8.Y.j(FloatCardScene.Any, FloatCardScene.Chat), new p9.p() { // from class: com.stepos.ailauncher.chat.input.controller.b
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return FloatingCardController.m0(this.f25386a, ((Boolean) obj).booleanValue(), (FloatCardOptions) obj2);
            }
        }, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.input.controller.m
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return FloatingCardController.o0(this.f25437a, container, (E4.p) obj);
            }
        }, new p9.p() { // from class: com.stepos.ailauncher.chat.input.controller.t
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return FloatingCardController.p0(this.f25460a, container, (E4.p) obj, (InterfaceC5063a) obj2);
            }
        });
        this.floatCardHost = hVar;
        IFloatCardService iFloatCardServiceS0 = s0();
        if (iFloatCardServiceS0 != null) {
            iFloatCardServiceS0.registerHost(hVar);
        }
    }

    public final void l1(View view, int height) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null || layoutParams.height == height) {
            return;
        }
        layoutParams.height = height;
        view.setLayoutParams(layoutParams);
    }

    public final boolean m1(String sessionId, String requestId, String title, String body, List<RiskCardButton> buttons, InterfaceC5074l<? super String, Y8.t> onChoice) {
        String str;
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(requestId, "requestId");
        kotlin.jvm.internal.p.i(title, "title");
        kotlin.jvm.internal.p.i(buttons, "buttons");
        kotlin.jvm.internal.p.i(onChoice, "onChoice");
        if (buttons.isEmpty()) {
            Log.w(TAG, "showApproval: empty buttons, drop requestId=" + requestId);
            return false;
        }
        if (!V()) {
            Log.i(TAG, "showApproval: requestId=" + requestId + " skip, host not in foreground");
            return false;
        }
        if (kotlin.jvm.internal.p.d(this.currentTaskId, requestId) && this.currentCardId != null) {
            Log.i(TAG, "showApproval: requestId=" + requestId + " already showing, skip");
            return true;
        }
        FloatCardContainerView floatCardContainerViewI0 = i0();
        if (floatCardContainerViewI0 == null) {
            Log.w(TAG, "showApproval: failed to inflate vsInfoCard, drop requestId=" + requestId);
            return false;
        }
        l0(floatCardContainerViewI0);
        IFloatCardService iFloatCardServiceS0 = s0();
        if (iFloatCardServiceS0 == null) {
            Log.w(TAG, "showApproval: IFloatCardService not registered, drop requestId=" + requestId);
            return false;
        }
        this.pendingOnSubmit = null;
        this.pendingOnCancel = null;
        this.pendingInquirySubmit = null;
        this.currentInquirySessionId = null;
        IFloatCardEventHandler iFloatCardEventHandler = this.inquiryEventHandler;
        if (iFloatCardEventHandler != null) {
            iFloatCardServiceS0.unregisterEventHandler(iFloatCardEventHandler.getBusinessType());
        }
        this.inquiryEventHandler = null;
        IFloatCardEventHandler iFloatCardEventHandler2 = this.riskEventHandler;
        if (iFloatCardEventHandler2 != null) {
            iFloatCardServiceS0.unregisterEventHandler(iFloatCardEventHandler2.getBusinessType());
        }
        InterfaceC5063a<Y8.t> interfaceC5063a = this.pendingRiskCancel;
        InterfaceC5063a<Y8.t> interfaceC5063a2 = (interfaceC5063a == null || (str = this.currentTaskId) == null || kotlin.jvm.internal.p.d(str, requestId) || this.riskChoiceDelivered) ? null : interfaceC5063a;
        this.currentTaskId = requestId;
        this.currentCardId = X(requestId);
        this.currentApprovalSessionId = sessionId;
        this.pendingRiskChoice = onChoice;
        this.pendingRiskCancel = null;
        this.riskChoiceDelivered = false;
        d dVar = new d(requestId, this);
        this.riskEventHandler = dVar;
        iFloatCardServiceS0.registerEventHandler(dVar);
        iFloatCardServiceS0.show(T(requestId, title, body, "", null, buttons, TOOL_APPROVAL_BUSINESS_TYPE, true));
        L();
        Log.i(TAG, "showApproval: requestId=" + requestId + " cardId=" + this.currentCardId + " buttons=" + buttons.size());
        if (interfaceC5063a2 != null) {
            Log.w(TAG, "showApproval: superseded previous choice card by requestId=" + requestId + ", cancel it");
            interfaceC5063a2.invoke();
        }
        return true;
    }

    public final boolean n1(String sessionId, String inquiryId, List<AskUserInquiry> inquiries, String page, p9.p<? super List<String>, ? super InterfaceC4014c<? super Boolean>, ? extends Object> onSubmit) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(inquiryId, "inquiryId");
        kotlin.jvm.internal.p.i(inquiries, "inquiries");
        kotlin.jvm.internal.p.i(onSubmit, "onSubmit");
        if (inquiries.isEmpty()) {
            Log.w(TAG, "showInquiry: empty inquiries, drop inquiryId=" + inquiryId);
            return false;
        }
        if (!V()) {
            Log.i(TAG, "showInquiry: inquiryId=" + inquiryId + " skip, host not in foreground");
            return false;
        }
        if (kotlin.jvm.internal.p.d(this.currentTaskId, inquiryId) && this.currentCardId != null) {
            Log.i(TAG, "showInquiry: inquiryId=" + inquiryId + " already showing, skip");
            z0(sessionId);
            return true;
        }
        if (this.currentCardId != null) {
            g0(this, null, false, false, 7, null);
        }
        String strX = X(inquiryId);
        this.currentTaskId = inquiryId;
        this.currentCardId = strX;
        this.currentInquirySessionId = sessionId;
        this.pendingInquirySubmit = onSubmit;
        this.inquiryPage = page;
        FloatCardContainerView floatCardContainerViewI0 = i0();
        if (floatCardContainerViewI0 == null) {
            Log.w(TAG, "showInquiry: failed to inflate vsInfoCard, drop inquiryId=" + inquiryId);
            c0(this, false, 1, null);
            return false;
        }
        l0(floatCardContainerViewI0);
        IFloatCardService iFloatCardServiceS0 = s0();
        if (iFloatCardServiceS0 == null) {
            Log.w(TAG, "showInquiry: IFloatCardService not registered, drop inquiryId=" + inquiryId);
            c0(this, false, 1, null);
            return false;
        }
        this.pendingOnSubmit = null;
        this.pendingOnCancel = null;
        IFloatCardEventHandler iFloatCardEventHandler = this.inquiryEventHandler;
        if (iFloatCardEventHandler != null) {
            iFloatCardServiceS0.unregisterEventHandler(iFloatCardEventHandler.getBusinessType());
        }
        FloatingCardController$showInquiry$handler$1 floatingCardController$showInquiry$handler$1 = new FloatingCardController$showInquiry$handler$1(inquiries, inquiryId, this);
        this.inquiryEventHandler = floatingCardController$showInquiry$handler$1;
        iFloatCardServiceS0.registerEventHandler(floatingCardController$showInquiry$handler$1);
        iFloatCardServiceS0.show(S(inquiryId, inquiries));
        L();
        this.inquiryShownAt = System.currentTimeMillis();
        M5.c.INSTANCE.h(sessionId, M5.c.CONFIRM_CARD, page);
        z0(sessionId);
        Log.i(TAG, "showInquiry: inquiryId=" + inquiryId + " cardId=" + strX + " questions=" + inquiries.size());
        return true;
    }

    public final boolean o1(String requestId, String title, String body, String riskLevel, String riskBadgeLabel, List<RiskCardButton> buttons, InterfaceC5074l<? super String, Y8.t> onChoice, InterfaceC5063a<Y8.t> onCancel) {
        String str;
        kotlin.jvm.internal.p.i(requestId, "requestId");
        kotlin.jvm.internal.p.i(title, "title");
        kotlin.jvm.internal.p.i(riskLevel, "riskLevel");
        kotlin.jvm.internal.p.i(buttons, "buttons");
        kotlin.jvm.internal.p.i(onChoice, "onChoice");
        kotlin.jvm.internal.p.i(onCancel, "onCancel");
        if (buttons.isEmpty()) {
            Log.w(TAG, "showRisk: empty buttons, drop requestId=" + requestId);
            return false;
        }
        if (!V()) {
            Log.i(TAG, "showRisk: requestId=" + requestId + " skip, host not in foreground");
            return false;
        }
        FloatCardContainerView floatCardContainerViewI0 = i0();
        if (floatCardContainerViewI0 == null) {
            Log.w(TAG, "showRisk: failed to inflate vsInfoCard, drop requestId=" + requestId);
            return false;
        }
        l0(floatCardContainerViewI0);
        IFloatCardService iFloatCardServiceS0 = s0();
        if (iFloatCardServiceS0 == null) {
            Log.w(TAG, "showRisk: IFloatCardService not registered, drop requestId=" + requestId);
            return false;
        }
        this.pendingOnSubmit = null;
        this.pendingOnCancel = null;
        this.pendingInquirySubmit = null;
        this.currentInquirySessionId = null;
        this.currentApprovalSessionId = null;
        IFloatCardEventHandler iFloatCardEventHandler = this.inquiryEventHandler;
        if (iFloatCardEventHandler != null) {
            iFloatCardServiceS0.unregisterEventHandler(iFloatCardEventHandler.getBusinessType());
        }
        this.inquiryEventHandler = null;
        IFloatCardEventHandler iFloatCardEventHandler2 = this.riskEventHandler;
        if (iFloatCardEventHandler2 != null) {
            iFloatCardServiceS0.unregisterEventHandler(iFloatCardEventHandler2.getBusinessType());
        }
        InterfaceC5063a<Y8.t> interfaceC5063a = this.pendingRiskCancel;
        InterfaceC5063a<Y8.t> interfaceC5063a2 = (interfaceC5063a == null || (str = this.currentTaskId) == null || kotlin.jvm.internal.p.d(str, requestId) || this.riskChoiceDelivered) ? null : interfaceC5063a;
        this.currentTaskId = requestId;
        this.currentCardId = X(requestId);
        this.pendingRiskChoice = onChoice;
        this.pendingRiskCancel = onCancel;
        this.riskChoiceDelivered = false;
        e eVar = new e(requestId, this);
        this.riskEventHandler = eVar;
        iFloatCardServiceS0.registerEventHandler(eVar);
        iFloatCardServiceS0.show(U(this, requestId, title, body, riskLevel, riskBadgeLabel, buttons, null, true, 64, null));
        L();
        Log.i(TAG, "showRisk: requestId=" + requestId + " cardId=" + this.currentCardId + " buttons=" + buttons.size());
        if (interfaceC5063a2 == null) {
            return true;
        }
        Log.w(TAG, "showRisk: superseded previous risk card by requestId=" + requestId + ", cancel it");
        interfaceC5063a2.invoke();
        return true;
    }

    public final void p1() {
        ViewPropertyAnimator viewPropertyAnimatorAnimate;
        FloatCardContainerView floatCardContainerView = this.floatCardContainer;
        if (floatCardContainerView == null) {
            return;
        }
        E4.p currentCard = floatCardContainerView.getCurrentCard();
        E4.o oVar = currentCard instanceof E4.o ? (E4.o) currentCard : null;
        if (oVar != null) {
            oVar.setOnContentHeightSettled(null);
        }
        W(floatCardContainerView);
        E4.p currentCard2 = floatCardContainerView.getCurrentCard();
        View view = currentCard2 != null ? currentCard2.getView() : null;
        if (view != null && (viewPropertyAnimatorAnimate = view.animate()) != null) {
            viewPropertyAnimatorAnimate.cancel();
        }
        if (view != null) {
            view.setAlpha(1.0f);
        }
        if (view != null) {
            view.setTranslationY(0.0f);
        }
        f1();
        l1(floatCardContainerView, -2);
        if (view != null) {
            l1(view, -2);
        }
        g1(floatCardContainerView);
        FloatCardContainerView.j(floatCardContainerView, null, null, 3, null);
    }

    public final void q1(View view, e.s prop, float f10, float minVisible, SheetSpring spec, final InterfaceC5063a<Y8.t> onEnd) {
        List<androidx.dynamicanimation.animation.i> list = this.cardAnims;
        androidx.dynamicanimation.animation.i iVar = new androidx.dynamicanimation.animation.i(view, prop);
        iVar.o(minVisible);
        iVar.B(h0.d(spec, f10));
        if (onEnd != null) {
            iVar.b(new e.q() { // from class: com.stepos.ailauncher.chat.input.controller.o
                @Override // androidx.dynamicanimation.animation.e.q
                public final void a(androidx.dynamicanimation.animation.e eVar, boolean z10, float f11, float f12) {
                    FloatingCardController.t1(onEnd, eVar, z10, f11, f12);
                }
            });
        }
        iVar.t();
        list.add(iVar);
    }

    public final void r0() {
        if (this.pendingUnregisterAfterExit) {
            this.pendingUnregisterAfterExit = false;
            x1();
        }
    }

    public final void r1(View view, androidx.dynamicanimation.animation.f<View> prop, float f10, float minVisible, SheetSpring spec, final InterfaceC5063a<Y8.t> onEnd) {
        List<androidx.dynamicanimation.animation.i> list = this.cardAnims;
        androidx.dynamicanimation.animation.i iVar = new androidx.dynamicanimation.animation.i(view, prop);
        iVar.o(minVisible);
        iVar.B(h0.d(spec, f10));
        if (onEnd != null) {
            iVar.b(new e.q() { // from class: com.stepos.ailauncher.chat.input.controller.n
                @Override // androidx.dynamicanimation.animation.e.q
                public final void a(androidx.dynamicanimation.animation.e eVar, boolean z10, float f11, float f12) {
                    FloatingCardController.u1(onEnd, eVar, z10, f11, f12);
                }
            });
        }
        iVar.t();
        list.add(iVar);
    }

    public final IFloatCardService s0() {
        return (IFloatCardService) D5.a.INSTANCE.a(IFloatCardService.class);
    }

    public final boolean t0() {
        FloatCardContainerView floatCardContainerView;
        String str = this.currentCardId;
        return str != null && (floatCardContainerView = this.floatCardContainer) != null && floatCardContainerView.getVisibility() == 0 && kotlin.jvm.internal.p.d(floatCardContainerView.e(), str);
    }

    public final void u0(View shell, boolean revealInput) {
        shell.setAlpha(0.0f);
        shell.setVisibility(4);
        if (revealInput) {
            this.inputView.setInputBarHiddenForFloatingCard(false);
        }
    }

    public final boolean v0(String content) {
        if (this.currentTaskId == null) {
            return false;
        }
        if (this.pendingInquirySubmit != null) {
            if (content != null) {
                String str = content.length() > 0 ? content : null;
                if (str != null) {
                    String str2 = this.currentCardId;
                    if (str2 == null) {
                        c0(this, false, 1, null);
                        return false;
                    }
                    e1("input");
                    IFloatCardService iFloatCardServiceS0 = s0();
                    if (iFloatCardServiceS0 != null) {
                        iFloatCardServiceS0.pushVoiceText(str2, str, true);
                    }
                    return true;
                }
            }
            return false;
        }
        if (this.pendingRiskChoice != null) {
            Log.i(TAG, "interceptSend: risk card present, dismiss & fall through to normal send");
            g0(this, null, false, false, 7, null);
            return false;
        }
        InterfaceC5074l<? super String, Y8.t> interfaceC5074l = this.pendingOnSubmit;
        if (interfaceC5074l != null && content != null) {
            String str3 = content.length() > 0 ? content : null;
            if (str3 != null) {
                Log.i(TAG, "interceptSend: forwarding to onSubmit, len=" + str3.length());
                g0(this, null, false, false, 7, null);
                interfaceC5074l.invoke(str3);
                return true;
            }
        }
        return false;
    }

    public final void v1(FloatCardContainerView container) {
        ViewPropertyAnimator viewPropertyAnimatorAnimate;
        ViewPropertyAnimator viewPropertyAnimatorAnimate2;
        E4.p currentCard;
        View view;
        ViewPropertyAnimator viewPropertyAnimatorAnimate3;
        Iterator<T> it = this.cardAnims.iterator();
        while (it.hasNext()) {
            ((androidx.dynamicanimation.animation.i) it.next()).d();
        }
        this.cardAnims.clear();
        ViewPropertyAnimator viewPropertyAnimator = this.cardTween;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
        this.cardTween = null;
        if (container != null && (currentCard = container.getCurrentCard()) != null && (view = currentCard.getView()) != null && (viewPropertyAnimatorAnimate3 = view.animate()) != null) {
            viewPropertyAnimatorAnimate3.cancel();
        }
        ViewGroup mainInput = this.inputView.getMainInput();
        if (mainInput != null && (viewPropertyAnimatorAnimate2 = mainInput.animate()) != null) {
            viewPropertyAnimatorAnimate2.cancel();
        }
        View view2 = this.floatCardSlot;
        if (view2 != null && (viewPropertyAnimatorAnimate = view2.animate()) != null) {
            viewPropertyAnimatorAnimate.cancel();
        }
        Runnable runnable = this.cardAnimFallback;
        if (runnable != null) {
            if (container != null) {
                container.removeCallbacks(runnable);
            }
            ViewGroup mainInput2 = this.inputView.getMainInput();
            if (mainInput2 != null) {
                mainInput2.removeCallbacks(runnable);
            }
            View view3 = this.floatCardSlot;
            if (view3 != null) {
                view3.removeCallbacks(runnable);
            }
            this.inputView.removeCallbacks(runnable);
        }
        this.cardAnimFallback = null;
    }

    public final boolean w0() {
        return this.currentTaskId != null;
    }

    public final void w1() {
        kotlinx.coroutines.g gVar = this.conversationBodyJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        this.conversationBodyJob = null;
    }

    public final void x0(final FloatCardContainerView container, final E4.p card, final int enterGeneration) {
        container.post(new Runnable() { // from class: com.stepos.ailauncher.chat.input.controller.j
            @Override // java.lang.Runnable
            public final void run() {
                FloatingCardController.y0(enterGeneration, this, container, card);
            }
        });
    }

    public final void x1() {
        G4.h hVar = this.floatCardHost;
        if (hVar == null) {
            return;
        }
        this.floatCardHost = null;
        IFloatCardService iFloatCardServiceS0 = s0();
        if (iFloatCardServiceS0 != null) {
            iFloatCardServiceS0.unregisterHost(hVar);
        }
    }

    public final boolean y1(E4.p card) {
        String businessType;
        com.stepos.agentframework.floatcard.view.p pVar = card instanceof com.stepos.agentframework.floatcard.view.p ? (com.stepos.agentframework.floatcard.view.p) card : null;
        if (pVar == null || (businessType = pVar.getBusinessType()) == null) {
            return false;
        }
        return kotlin.jvm.internal.p.d(businessType, RISK_BUSINESS_TYPE) || kotlin.jvm.internal.p.d(businessType, TOOL_APPROVAL_BUSINESS_TYPE);
    }

    public final void z0(String sessionId) {
        ILiveNotificationService iLiveNotificationService;
        if (La.H.x0(sessionId) || !com.stepos.ailauncher.common.utils.v.INSTANCE.j() || (iLiveNotificationService = (ILiveNotificationService) D5.a.INSTANCE.a(ILiveNotificationService.class)) == null) {
            return;
        }
        iLiveNotificationService.markTakeoverAlreadySeen(sessionId);
    }
}
