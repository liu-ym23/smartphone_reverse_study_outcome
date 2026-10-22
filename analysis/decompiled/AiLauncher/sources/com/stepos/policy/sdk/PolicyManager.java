package com.stepos.policy.sdk;

import La.D;
import La.H;
import M0.a;
import Ua.C1056g;
import Ua.C1058h;
import Ua.C1060i;
import Ua.C1073o0;
import Ua.CoroutineName;
import Ua.I;
import Ua.J;
import Ua.L0;
import Ua.M;
import Ua.Y;
import Y8.t;
import Z8.F;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.net.Uri;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.PreferencesKt;
import androidx.exifinterface.media.ExifInterface;
import com.amap.api.services.core.AMapException;
import com.google.gson.Gson;
import com.stepos.aiengine.args.QueryAlgorithmBundle;
import com.stepos.aiengine.update.AlgorithmUpdateBundle;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity;
import com.stepos.policy.sdk.bean.CustomDeleteInfoBean;
import com.stepos.policy.sdk.bean.DeleteInfoBean;
import com.stepos.policy.sdk.bean.DeleteInfoEncryptMultiBean;
import com.stepos.policy.sdk.bean.PolicyFileDataResultBean;
import com.stepos.policy.sdk.bean.PolicyNewestPathResultBean;
import com.stepos.policy.sdk.bean.PolicyRecordBaseInfo;
import com.stepos.policy.sdk.bean.PolicyRecordRequest;
import com.stepos.policy.sdk.bean.PolicySdkResultBean;
import com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder;
import com.stepos.policy.sdk.manager.WithdrawalManager;
import com.stepos.policy.sdk.manager.WithdrawalManagerWithoutSecureService;
import com.stepos.policy.sdk.net.PolicySdkRetrofitCreator;
import com.stepos.policy.sdk.util.PolicyAppSecretResolver;
import com.stepos.policy.sdk.util.PolicyCheckLogUtils;
import com.stepos.policy.sdk.util.PolicyCloudPolicyIndex;
import com.stepos.policy.sdk.util.PolicyHtmlDisplayAdapter;
import com.stepos.policy.sdk.util.PolicySdkFileUtils;
import com.stepos.policy.sdk.util.PolicySdkLogUtils;
import com.stepos.policy.sdk.util.PolicySdkNetworkGate;
import com.stepos.policy.sdk.util.PolicySdkNetworkUtil;
import com.stepos.policy.sdk.util.PolicySdkToolsUtils;
import com.stepos.policy.sdk.util.SocketHookUtil;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import p9.InterfaceC5074l;
import p9.p;
import stepos.support.v7.app.q;

@Metadata(d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b7\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\bH\u0082@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0013\u001a\u00020\u0012H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0017\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J;\u0010\u001c\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\"\u0010\u001b\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0019j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u001f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001f\u0010 JS\u0010\"\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\"\u0010\u001b\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0019j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u001aH\u0007¢\u0006\u0004\b\"\u0010#J-\u0010&\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\u0006\u0010$\u001a\u00020\b2\b\u0010%\u001a\u0004\u0018\u00010\u0004H\u0082@ø\u0001\u0000¢\u0006\u0004\b&\u0010'J\u001b\u0010(\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\fH\u0082@ø\u0001\u0000¢\u0006\u0004\b(\u0010)J\u0017\u0010*\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b*\u0010+J5\u0010.\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\b\u0010,\u001a\u0004\u0018\u00010\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00042\b\u0010-\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b.\u0010/J'\u00101\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u0004H\u0007¢\u0006\u0004\b1\u00102JC\u00108\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u00104\u001a\u0002032\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\u001205H\u0007¢\u0006\u0004\b8\u00109J\u0089\u0001\u0010F\u001a\u0004\u0018\u00010E2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010:\u001a\u00020\b2\u0006\u0010;\u001a\u00020\b2\u0006\u0010<\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u00042\u0006\u0010>\u001a\u00020\u00042\u0006\u0010?\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00040@2\b\u0010B\u001a\u0004\u0018\u00010\u00042\u0006\u0010D\u001a\u00020CH\u0007¢\u0006\u0004\bF\u0010GJY\u0010H\u001a\u0004\u0018\u00010E2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010:\u001a\u00020\b2\u0006\u0010;\u001a\u00020\b2\u0006\u0010<\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u00042\u0006\u0010>\u001a\u00020\u00042\u0006\u0010?\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010D\u001a\u00020CH\u0007¢\u0006\u0004\bH\u0010IJG\u0010K\u001a\u00020J2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010:\u001a\u00020\b2\u0006\u0010;\u001a\u00020\b2\u0006\u0010<\u001a\u00020\u00042\u0006\u0010?\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010D\u001a\u00020CH\u0002¢\u0006\u0004\bK\u0010LJy\u0010M\u001a\u0004\u0018\u00010E2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010:\u001a\u00020\b2\u0006\u0010;\u001a\u00020\b2\u0006\u0010<\u001a\u00020\u00042\u0006\u0010?\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00040@2\b\u0010B\u001a\u0004\u0018\u00010\u00042\u0006\u0010D\u001a\u00020CH\u0007¢\u0006\u0004\bM\u0010NJI\u0010O\u001a\u0004\u0018\u00010E2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010:\u001a\u00020\b2\u0006\u0010;\u001a\u00020\b2\u0006\u0010<\u001a\u00020\u00042\u0006\u0010?\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010D\u001a\u00020CH\u0007¢\u0006\u0004\bO\u0010PJy\u0010W\u001a\u0004\u0018\u00010E2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010Q\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00040@2\b\u0010B\u001a\u0004\u0018\u00010\u00042\u0006\u0010R\u001a\u00020\b2\u0006\u0010T\u001a\u00020S2\u0006\u0010U\u001a\u00020\u00042\u0006\u0010V\u001a\u00020\u00042\u0006\u0010D\u001a\u00020CH\u0007¢\u0006\u0004\bW\u0010XJy\u0010\\\u001a\u0004\u0018\u00010J2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010<\u001a\u00020\u00042\u0006\u0010T\u001a\u00020S2\u0006\u0010Y\u001a\u00020\u00042\u0006\u0010Z\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00040@2\b\u0010B\u001a\u0004\u0018\u00010\u00042\u0006\u0010[\u001a\u00020\u00042\u0006\u0010D\u001a\u00020CH\u0007¢\u0006\u0004\b\\\u0010]JI\u0010`\u001a\u0004\u0018\u00010E2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010<\u001a\u00020\u00042\u0006\u0010T\u001a\u00020S2\u0006\u0010Y\u001a\u00020\u00042\u0006\u0010Z\u001a\u00020\u00042\u0006\u0010^\u001a\u00020\u00042\u0006\u0010D\u001a\u00020_H\u0007¢\u0006\u0004\b`\u0010aJY\u0010d\u001a\u0004\u0018\u00010E2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010b\u001a\u00020\b2\u0006\u0010<\u001a\u00020\u00042\u0006\u0010T\u001a\u00020S2\u0006\u0010Y\u001a\u00020\u00042\u0006\u0010Z\u001a\u00020\u00042\u0006\u0010^\u001a\u00020\u00042\u0006\u0010c\u001a\u00020\u00042\u0006\u0010D\u001a\u00020_H\u0007¢\u0006\u0004\bd\u0010eJy\u0010f\u001a\u0004\u0018\u00010E2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010<\u001a\u00020\u00042\u0006\u0010T\u001a\u00020S2\u0006\u0010Y\u001a\u00020\u00042\u0006\u0010Z\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00040@2\b\u0010B\u001a\u0004\u0018\u00010\u00042\u0006\u0010[\u001a\u00020\u00042\u0006\u0010D\u001a\u00020CH\u0007¢\u0006\u0004\bf\u0010gJA\u0010h\u001a\u0004\u0018\u00010E2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010<\u001a\u00020\u00042\u0006\u0010T\u001a\u00020S2\u0006\u0010Y\u001a\u00020\u00042\u0006\u0010Z\u001a\u00020\u00042\u0006\u0010D\u001a\u00020CH\u0007¢\u0006\u0004\bh\u0010iJI\u0010j\u001a\u0004\u0018\u00010J2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010<\u001a\u00020\u00042\u0006\u0010T\u001a\u00020S2\u0006\u0010Y\u001a\u00020\u00042\u0006\u0010Z\u001a\u00020\u00042\u0006\u0010[\u001a\u00020\u00042\u0006\u0010D\u001a\u00020CH\u0007¢\u0006\u0004\bj\u0010kJI\u0010n\u001a\u0004\u0018\u00010J2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010m\u001a\u00020l2\u0006\u0010<\u001a\u00020\u00042\u0006\u0010T\u001a\u00020S2\u0006\u0010Y\u001a\u00020\u00042\u0006\u0010Z\u001a\u00020\u00042\u0006\u0010D\u001a\u00020CH\u0007¢\u0006\u0004\bn\u0010oJq\u0010p\u001a\u0004\u0018\u00010J2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010<\u001a\u00020\u00042\u0006\u0010T\u001a\u00020S2\u0006\u0010Y\u001a\u00020\u00042\u0006\u0010Z\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00040@2\b\u0010B\u001a\u0004\u0018\u00010\u00042\u0006\u0010D\u001a\u00020CH\u0007¢\u0006\u0004\bp\u0010qJ7\u0010r\u001a\u0002032\u0006\u0010\r\u001a\u00020\f2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00040@2\b\u0010B\u001a\u0004\u0018\u00010\u00042\u0006\u0010[\u001a\u00020\u0004H\u0007¢\u0006\u0004\br\u0010sJ\u0017\u0010t\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\bt\u0010+J\u0097\u0001\u0010|\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\u0006\u0010u\u001a\u00020\u00042\u0006\u0010v\u001a\u00020\u00042\u0006\u0010w\u001a\u00020\u00042\u001a\u0010{\u001a\u0016\u0012\u0004\u0012\u00020y\u0018\u00010xj\n\u0012\u0004\u0012\u00020y\u0018\u0001`z2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00040@2\b\u0010B\u001a\u0004\u0018\u00010\u00042\u0006\u0010[\u001a\u00020\u00042\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\u001205H\u0007¢\u0006\u0004\b|\u0010}JK\u0010~\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u00104\u001a\u0002032\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\u001205H\u0007¢\u0006\u0004\b~\u0010\u007fJ\u0099\u0001\u0010\u0080\u0001\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\u0006\u0010u\u001a\u00020\u00042\u0006\u0010v\u001a\u00020\u00042\u0006\u0010w\u001a\u00020\u00042\u001a\u0010{\u001a\u0016\u0012\u0004\u0012\u00020y\u0018\u00010xj\n\u0012\u0004\u0012\u00020y\u0018\u0001`z2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00040@2\b\u0010B\u001a\u0004\u0018\u00010\u00042\u0006\u0010[\u001a\u00020\u00042\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\u001205H\u0007¢\u0006\u0005\b\u0080\u0001\u0010}JR\u0010\u0081\u0001\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00040@2\b\u0010B\u001a\u0004\u0018\u00010\u00042\u0006\u0010[\u001a\u00020\u0004H\u0007¢\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J\u0099\u0001\u0010\u0086\u0001\u001a\u0004\u0018\u00010E2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010;\u001a\u00020\b2\u000f\u0010\u0083\u0001\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010@2\u000f\u0010\u0084\u0001\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010@2\u0006\u0010<\u001a\u00020\u00042\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010S2\u0006\u0010T\u001a\u00020S2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00040@2\b\u0010B\u001a\u0004\u0018\u00010\u00042\u0006\u0010D\u001a\u00020_H\u0007¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J£\u0001\u0010\u008a\u0001\u001a\u0004\u0018\u00010E2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010;\u001a\u00020\b2\u000f\u0010\u0083\u0001\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010@2\u000f\u0010\u0084\u0001\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010@2\u0006\u0010<\u001a\u00020\u00042\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010S2\u0006\u0010T\u001a\u00020S2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00040@2\b\u0010B\u001a\u0004\u0018\u00010\u00042\u0007\u0010\u0088\u0001\u001a\u00020_2\u0007\u0010\u0089\u0001\u001a\u00020CH\u0007¢\u0006\u0006\b\u008a\u0001\u0010\u008b\u0001Ji\u0010\u008c\u0001\u001a\u0004\u0018\u00010E2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010;\u001a\u00020\b2\u000f\u0010\u0083\u0001\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010@2\u000f\u0010\u0084\u0001\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010@2\u0006\u0010<\u001a\u00020\u00042\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010S2\u0006\u0010T\u001a\u00020S2\u0006\u0010D\u001a\u00020_H\u0007¢\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001J`\u0010\u0090\u0001\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\u0007\u0010\u008e\u0001\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0007\u0010\u008f\u0001\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\u001205H\u0007¢\u0006\u0006\b\u0090\u0001\u0010\u0091\u0001J\"\u0010\u0092\u0001\u001a\u0002062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0004H\u0007¢\u0006\u0006\b\u0092\u0001\u0010\u0093\u0001J\"\u0010\u0094\u0001\u001a\u0002062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0004H\u0007¢\u0006\u0006\b\u0094\u0001\u0010\u0093\u0001J1\u0010\u0096\u0001\u001a\u0002062\u0006\u0010\r\u001a\u00020\f2\t\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0015\u001a\u00020\u0004H\u0087@ø\u0001\u0000¢\u0006\u0006\b\u0096\u0001\u0010\u0097\u0001J*\u0010\u0098\u0001\u001a\u0002062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010<\u001a\u00020\u0004H\u0007¢\u0006\u0006\b\u0098\u0001\u0010\u0099\u0001J2\u0010\u009a\u0001\u001a\u0002062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010:\u001a\u00020\b2\u0006\u0010<\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004H\u0007¢\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001J*\u0010\u009c\u0001\u001a\u0002062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010<\u001a\u00020\u0004H\u0007¢\u0006\u0006\b\u009c\u0001\u0010\u0099\u0001J_\u0010\u009f\u0001\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0007\u0010\u008f\u0001\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00042\n\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u009d\u00012\b\u0010!\u001a\u0004\u0018\u00010\u00042\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\u001205H\u0007¢\u0006\u0006\b\u009f\u0001\u0010 \u0001J]\u0010¡\u0001\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0007\u0010\u008f\u0001\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00042\b\u0010\u009e\u0001\u001a\u00030\u009d\u00012\b\u0010!\u001a\u0004\u0018\u00010\u00042\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020605H\u0007¢\u0006\u0006\b¡\u0001\u0010¢\u0001JU\u0010¤\u0001\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0007\u0010\u008f\u0001\u001a\u00020\u00042\n\u0010£\u0001\u001a\u0005\u0018\u00010\u009d\u00012\b\u0010!\u001a\u0004\u0018\u00010\u00042\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020605H\u0007¢\u0006\u0006\b¤\u0001\u0010¥\u0001J5\u0010¦\u0001\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\b\u0010\u009e\u0001\u001a\u00030\u009d\u00012\u0007\u0010\u008f\u0001\u001a\u00020\u0004H\u0007¢\u0006\u0006\b¦\u0001\u0010§\u0001J9\u0010«\u0001\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\u000e\u0010©\u0001\u001a\t\u0012\u0004\u0012\u00020\u00040¨\u00012\t\u0010ª\u0001\u001a\u0004\u0018\u00010\u0004H\u0082@ø\u0001\u0000¢\u0006\u0006\b«\u0001\u0010¬\u0001J-\u0010°\u0001\u001a\u00020\u00122\u0007\u0010\u00ad\u0001\u001a\u00020\f2\u0007\u0010®\u0001\u001a\u00020\u00042\u0007\u0010¯\u0001\u001a\u00020lH\u0007¢\u0006\u0006\b°\u0001\u0010±\u0001J\\\u0010²\u0001\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0007\u0010®\u0001\u001a\u00020\u00042\u0007\u0010¯\u0001\u001a\u00020l2&\u00107\u001a\"\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020y\u0018\u00010xj\n\u0012\u0004\u0012\u00020y\u0018\u0001`z\u0012\u0004\u0012\u00020\u001205H\u0007¢\u0006\u0006\b²\u0001\u0010³\u0001JY\u0010¶\u0001\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\u0019\u0010µ\u0001\u001a\u0014\u0012\u0005\u0012\u00030´\u00010xj\t\u0012\u0005\u0012\u00030´\u0001`z2\"\u00107\u001a\u001e\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020y0xj\b\u0012\u0004\u0012\u00020y`z\u0012\u0004\u0012\u00020\u001205H\u0007¢\u0006\u0006\b¶\u0001\u0010·\u0001JY\u0010¹\u0001\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\u0019\u0010µ\u0001\u001a\u0014\u0012\u0005\u0012\u00030¸\u00010xj\t\u0012\u0005\u0012\u00030¸\u0001`z2\"\u00107\u001a\u001e\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020y0xj\b\u0012\u0004\u0012\u00020y`z\u0012\u0004\u0012\u00020\u001205H\u0007¢\u0006\u0006\b¹\u0001\u0010·\u0001J\u0019\u0010º\u0001\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0005\bº\u0001\u0010\u0011J#\u0010¼\u0001\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0007\u0010»\u0001\u001a\u00020lH\u0007¢\u0006\u0006\b¼\u0001\u0010½\u0001J-\u0010¿\u0001\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00042\t\u0010¾\u0001\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0006\b¿\u0001\u0010À\u0001J\"\u0010Á\u0001\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0004H\u0002¢\u0006\u0006\bÁ\u0001\u0010Â\u0001JQ\u0010Ã\u0001\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0007\u0010\u008f\u0001\u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010\u00042\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020605H\u0007¢\u0006\u0006\bÃ\u0001\u0010Ä\u0001JE\u0010Å\u0001\u001a\u0012\u0012\u0004\u0012\u00020y0xj\b\u0012\u0004\u0012\u00020y`z2\u0006\u0010\r\u001a\u00020\f2\u0019\u0010µ\u0001\u001a\u0014\u0012\u0005\u0012\u00030¸\u00010xj\t\u0012\u0005\u0012\u00030¸\u0001`zH\u0007¢\u0006\u0006\bÅ\u0001\u0010Æ\u0001J\u001f\u0010Ç\u0001\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\fH\u0086@ø\u0001\u0000¢\u0006\u0005\bÇ\u0001\u0010)J\u001d\u0010È\u0001\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0086@ø\u0001\u0000¢\u0006\u0005\bÈ\u0001\u0010)J!\u0010Ê\u0001\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\u0007\u0010É\u0001\u001a\u00020l¢\u0006\u0006\bÊ\u0001\u0010Ë\u0001J\u001d\u0010Ì\u0001\u001a\u00020l2\u0006\u0010\r\u001a\u00020\fH\u0086@ø\u0001\u0000¢\u0006\u0005\bÌ\u0001\u0010)J0\u0010Í\u0001\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\f2\u000e\u0010©\u0001\u001a\t\u0012\u0004\u0012\u00020\u00040¨\u0001H\u0086@ø\u0001\u0000¢\u0006\u0006\bÍ\u0001\u0010Î\u0001J\u0018\u0010Ï\u0001\u001a\u00020l2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0006\bÏ\u0001\u0010Ð\u0001R\u001d\u0010Ò\u0001\u001a\u00030Ñ\u00018\u0006¢\u0006\u0010\n\u0006\bÒ\u0001\u0010Ó\u0001\u001a\u0006\bÔ\u0001\u0010Õ\u0001R)\u0010Ö\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÖ\u0001\u0010×\u0001\u001a\u0006\bØ\u0001\u0010Ù\u0001\"\u0006\bÚ\u0001\u0010Û\u0001R)\u0010Ü\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÜ\u0001\u0010×\u0001\u001a\u0006\bÝ\u0001\u0010Ù\u0001\"\u0006\bÞ\u0001\u0010Û\u0001R)\u0010ß\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bß\u0001\u0010×\u0001\u001a\u0006\bà\u0001\u0010Ù\u0001\"\u0006\bá\u0001\u0010Û\u0001R)\u0010â\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bâ\u0001\u0010×\u0001\u001a\u0006\bã\u0001\u0010Ù\u0001\"\u0006\bä\u0001\u0010Û\u0001R)\u0010å\u0001\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bå\u0001\u0010æ\u0001\u001a\u0006\bç\u0001\u0010è\u0001\"\u0006\bé\u0001\u0010ê\u0001R5\u0010ë\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bë\u0001\u0010ì\u0001\u001a\u0006\bí\u0001\u0010î\u0001\"\u0006\bï\u0001\u0010ð\u0001R\u001d\u0010ñ\u0001\u001a\u00030Ñ\u00018\u0006¢\u0006\u0010\n\u0006\bñ\u0001\u0010Ó\u0001\u001a\u0006\bò\u0001\u0010Õ\u0001R)\u0010ó\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bó\u0001\u0010×\u0001\u001a\u0006\bô\u0001\u0010Ù\u0001\"\u0006\bõ\u0001\u0010Û\u0001R)\u0010ö\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bö\u0001\u0010×\u0001\u001a\u0006\b÷\u0001\u0010Ù\u0001\"\u0006\bø\u0001\u0010Û\u0001R)\u0010ù\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bù\u0001\u0010×\u0001\u001a\u0006\bú\u0001\u0010Ù\u0001\"\u0006\bû\u0001\u0010Û\u0001R)\u0010ü\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bü\u0001\u0010×\u0001\u001a\u0006\bý\u0001\u0010Ù\u0001\"\u0006\bþ\u0001\u0010Û\u0001R)\u0010ÿ\u0001\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÿ\u0001\u0010æ\u0001\u001a\u0006\b\u0080\u0002\u0010è\u0001\"\u0006\b\u0081\u0002\u0010ê\u0001R0\u0010\u0082\u0002\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u001f\n\u0006\b\u0082\u0002\u0010æ\u0001\u0012\u0005\b\u0085\u0002\u0010\u0003\u001a\u0006\b\u0083\u0002\u0010è\u0001\"\u0006\b\u0084\u0002\u0010ê\u0001R\u0018\u0010\u0086\u0002\u001a\u00030\u009d\u00018\u0002X\u0082T¢\u0006\b\n\u0006\b\u0086\u0002\u0010\u0087\u0002R\u0018\u0010\u0088\u0002\u001a\u00030\u009d\u00018\u0002X\u0082T¢\u0006\b\n\u0006\b\u0088\u0002\u0010\u0087\u0002R\u001d\u0010\u008a\u0002\u001a\u00030\u0089\u00028\u0006¢\u0006\u0010\n\u0006\b\u008a\u0002\u0010\u008b\u0002\u001a\u0006\b\u008c\u0002\u0010\u008d\u0002\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u008e\u0002"}, d2 = {"Lcom/stepos/policy/sdk/PolicyManager;", "", "<init>", "()V", "", "appId", "appSecret", "api", "", "localReturned", "resolveSignSecret", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLe9/c;)Ljava/lang/Object;", "Landroid/content/Context;", "context", "resolvePolicyContext", "(Landroid/content/Context;)Landroid/content/Context;", "isDeviceProtectedStorageContext", "(Landroid/content/Context;)Z", "LY8/t;", "awaitSyncLocalFileFinished", "(Le9/c;)Ljava/lang/Object;", QueryAlgorithmBundle.KEY_CATEGORY, "Lcom/stepos/policy/sdk/bean/PolicyNewestPathResultBean;", "findNewestPolicyFile", "(Landroid/content/Context;Ljava/lang/String;)Lcom/stepos/policy/sdk/bean/PolicyNewestPathResultBean;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "policyCategoryMap", "selfCheckLocalAssets", "(Landroid/content/Context;Ljava/util/HashMap;)V", "assetName", "assetExists", "(Landroid/content/Context;Ljava/lang/String;)Z", "versionName", "initSDK", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;)V", "isOperateSuccess", "operateJson", "savePolicyOperate", "(Landroid/content/Context;ZLjava/lang/String;Le9/c;)Ljava/lang/Object;", "loadCloudPolicyUidCategoryMap", "(Landroid/content/Context;Le9/c;)Ljava/lang/Object;", "persistCloudPolicyUidCategoryMap", "(Landroid/content/Context;)V", "policyUrl", "policyUid", "rememberCloudPolicyUidCategory", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toPath", "copyPolicyFile", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "Lcom/stepos/policy/sdk/bean/PolicyRecordRequest;", "policyRecordRequest", "Lkotlin/Function1;", "Lcom/stepos/policy/sdk/bean/PolicySdkResultBean;", "callBackPolicyResult", "uploadPolicyOperateRecord", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/policy/sdk/bean/PolicyRecordRequest;Lp9/l;)V", "methodType", "secondaryConfirmation", "title", "userPrivacyPolicyName", "userCategory", "privacyPolicyName", "", "categoryList", "userId", "Lstepos/support/v7/app/q$h;", "permissionDialogClickListener", "Lstepos/support/v7/app/c;", "showReGrantTwoPolicyDialogAndUploadRecord", "(Landroid/content/Context;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Lstepos/support/v7/app/q$h;)Lstepos/support/v7/app/c;", "showReGrantTwoPolicyDialog", "(Landroid/content/Context;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lstepos/support/v7/app/q$h;)Lstepos/support/v7/app/c;", "Lstepos/support/v7/app/q;", "createReGrantDialogBuilder", "(Landroid/content/Context;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lstepos/support/v7/app/q$h;)Lstepos/support/v7/app/q;", "showReGrantDialogAndUploadRecord", "(Landroid/content/Context;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Lstepos/support/v7/app/q$h;)Lstepos/support/v7/app/c;", "showReGrantDialog", "(Landroid/content/Context;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lstepos/support/v7/app/q$h;)Lstepos/support/v7/app/c;", "dialogTitle", "isRecord", "", "customTerms", "btnNegative", "btnPositive", "showNewestDialogAndUploadRecord", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;ZLjava/lang/CharSequence;Ljava/lang/String;Ljava/lang/String;Lstepos/support/v7/app/q$h;)Lstepos/support/v7/app/c;", "customNegativeButtonText", "customPositiveButtonText", "operationType", "showDialogUploadRecordBuilder", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/CharSequence;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lstepos/support/v7/app/q$h;)Lstepos/support/v7/app/q;", "checkButtonMessage", "Lcom/stepos/policy/sdk/dialog/PolicyPermissionDialogBuilder$OnPermissionClickListener;", "showWithdrawalAndCleanServiceDataDialog", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/CharSequence;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/policy/sdk/dialog/PolicyPermissionDialogBuilder$OnPermissionClickListener;)Lstepos/support/v7/app/c;", "hasLogin", "secondCheckButtonMessage", "showWithdrawalAndCleanServiceDataDialogByAccount", "(Landroid/content/Context;ZLjava/lang/String;Ljava/lang/CharSequence;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/policy/sdk/dialog/PolicyPermissionDialogBuilder$OnPermissionClickListener;)Lstepos/support/v7/app/c;", "showDialogByCustomViewAndUploadRecord", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/CharSequence;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lstepos/support/v7/app/q$h;)Lstepos/support/v7/app/c;", "showDialogByCustomView", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/CharSequence;Ljava/lang/String;Ljava/lang/String;Lstepos/support/v7/app/q$h;)Lstepos/support/v7/app/c;", "showDialogByCustomViewBuilder", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/CharSequence;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lstepos/support/v7/app/q$h;)Lstepos/support/v7/app/q;", "", "theme", "showDialogByCustomThemeViewBuilder", "(Landroid/content/Context;ILjava/lang/String;Ljava/lang/CharSequence;Ljava/lang/String;Ljava/lang/String;Lstepos/support/v7/app/q$h;)Lstepos/support/v7/app/q;", "showDialogByCustomViewBuilderRecord", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/CharSequence;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Lstepos/support/v7/app/q$h;)Lstepos/support/v7/app/q;", "createRecordRequest", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/policy/sdk/bean/PolicyRecordRequest;", "reTryUploadRecord", "serviceName", "validateCode", "verifyType", "Ljava/util/ArrayList;", "Lcom/stepos/policy/sdk/bean/DeleteInfoBean;", "Lkotlin/collections/ArrayList;", "deleteInfoBeanList", "uploadRecordWithoutSecureService", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lp9/l;)V", "uploadRecordByCustomRecordRequest", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/policy/sdk/bean/PolicyRecordRequest;Lp9/l;)V", "uploadRecordToCleanServiceData", "autoUploadRecord", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "permissionKey", "permissionSummary", "reminder", "showCustomPolicyDialogAndUploadRecord", "(Landroid/content/Context;Z[Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Lcom/stepos/policy/sdk/dialog/PolicyPermissionDialogBuilder$OnPermissionClickListener;)Lstepos/support/v7/app/c;", "fullAgreeListener", "basicListener", "showCustomPolicyThreeButtonDialogAndUploadRecord", "(Landroid/content/Context;Z[Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Lcom/stepos/policy/sdk/dialog/PolicyPermissionDialogBuilder$OnPermissionClickListener;Lstepos/support/v7/app/q$h;)Lstepos/support/v7/app/c;", "showCustomPolicyDialog", "(Landroid/content/Context;Z[Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Lcom/stepos/policy/sdk/dialog/PolicyPermissionDialogBuilder$OnPermissionClickListener;)Lstepos/support/v7/app/c;", "isAutoRecord", "language", "checkNewestPolicy", "(Landroid/content/Context;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lp9/l;)V", "getPolicyNewestPathByCustom", "(Landroid/content/Context;Ljava/lang/String;)Lcom/stepos/policy/sdk/bean/PolicySdkResultBean;", "getPolicyNewestPath", "localPath", "initPolicyNewestPath", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "openPolicyDataByWebView", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/policy/sdk/bean/PolicySdkResultBean;", "openPolicyMethod", "(Landroid/content/Context;ZLjava/lang/String;Ljava/lang/String;)Lcom/stepos/policy/sdk/bean/PolicySdkResultBean;", "openPolicyDataByBrowser", "", "version", "getPolicyData", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Lp9/l;)V", "getPolicyHistoryList", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Lp9/l;)V", "versionId", "getPolicyByVersion", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Lp9/l;)V", "getPolicyHistoryUrl", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)Ljava/lang/String;", "LM0/a$a;", "dataStoreKey", "dataStoreValue", "saveDataStoreString", "(Landroid/content/Context;LM0/a$a;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "mContext", "businessType", "deleteType", "getCommonDeleteInfoList", "(Landroid/content/Context;Ljava/lang/String;I)V", "getPrivateDeleteInfoList", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILp9/l;)V", "Lcom/stepos/policy/sdk/bean/CustomDeleteInfoBean;", "customDeleteInfoList", "encryptCustomDeleteInfoListBySecure", "(Landroid/content/Context;Ljava/util/ArrayList;Lp9/l;)V", "Lcom/stepos/policy/sdk/bean/DeleteInfoEncryptMultiBean;", "encryptMultiDeleteListBySecure", "isSupportSecureService31", "versionCode", "isSupportSecureService", "(Landroid/content/Context;I)Z", Parameters.UPLOAD_REQUEST_PARAM_MD5, "saveLocalCategoryMd5", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "getLocalCategoryMd5", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;", "getPolicyServiceConfig", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lp9/l;)V", "encryptDeleteInfoWithoutSecureService", "(Landroid/content/Context;Ljava/util/ArrayList;)Ljava/util/ArrayList;", "getPolicyOperateJson", "getPolicyOperate", "status", "saveAgreeStatus", "(Landroid/content/Context;I)V", "getAgreeStatus", "getDataStoreString", "(Landroid/content/Context;LM0/a$a;Le9/c;)Ljava/lang/Object;", "getSecureServiceVersionCode", "(Landroid/content/Context;)I", "LUa/M;", "lifecycleScope", "LUa/M;", "getLifecycleScope", "()LUa/M;", "mAppId", "Ljava/lang/String;", "getMAppId", "()Ljava/lang/String;", "setMAppId", "(Ljava/lang/String;)V", "mAppSecret", "getMAppSecret", "setMAppSecret", "mAppVersionName", "getMAppVersionName", "setMAppVersionName", "customPolicyCSSFileName", "getCustomPolicyCSSFileName", "setCustomPolicyCSSFileName", "syncLocalFileFinished", "Z", "getSyncLocalFileFinished", "()Z", "setSyncLocalFileFinished", "(Z)V", "localAssetsCategoryPathMap", "Ljava/util/HashMap;", "getLocalAssetsCategoryPathMap", "()Ljava/util/HashMap;", "setLocalAssetsCategoryPathMap", "(Ljava/util/HashMap;)V", "scope", "getScope", "companyCode", "getCompanyCode", "setCompanyCode", Parameters.BRAND, "getBrand", "setBrand", AlgorithmUpdateBundle.KEY_SUFFIX_MODEL, "getModel", "setModel", "osVersion", "getOsVersion", "setOsVersion", "initSDKByDeviceProtectedStorageContext", "getInitSDKByDeviceProtectedStorageContext", "setInitSDKByDeviceProtectedStorageContext", "readAndroidIdEnabled", "getReadAndroidIdEnabled", "setReadAndroidIdEnabled", "getReadAndroidIdEnabled$annotations", "SYNC_LOCAL_FILE_MAX_WAIT_MS", "J", "SYNC_LOCAL_FILE_POLL_MS", "LUa/J;", "exceptionHandler", "LUa/J;", "getExceptionHandler", "()LUa/J;", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PolicyManager {
    private static final long SYNC_LOCAL_FILE_MAX_WAIT_MS = 10000;
    private static final long SYNC_LOCAL_FILE_POLL_MS = 200;
    private static String brand;
    private static String companyCode;
    private static final J exceptionHandler;
    private static boolean initSDKByDeviceProtectedStorageContext;
    private static String model;
    private static String osVersion;
    private static boolean readAndroidIdEnabled;
    private static boolean syncLocalFileFinished;
    public static final PolicyManager INSTANCE = new PolicyManager();
    private static final M lifecycleScope = kotlinx.coroutines.d.b();
    private static String mAppId = "";
    private static String mAppSecret = "";
    private static String mAppVersionName = "";
    private static String customPolicyCSSFileName = "";
    private static HashMap<String, String> localAssetsCategoryPathMap = new HashMap<>();
    private static final M scope = kotlinx.coroutines.d.a(L0.b(null, 1, null).plus(Y.b()));

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"com/stepos/policy/sdk/PolicyManager$a", "Lcom/stepos/policy/sdk/dialog/PolicyPermissionDialogBuilder$OnPermissionClickListener;", "Landroid/content/DialogInterface;", C3081a.FOCUS_DIALOG_NAME, "", "alwaysDeny", "allow", "LY8/t;", "onPermissionClick", "(Landroid/content/DialogInterface;ZZ)V", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class a implements PolicyPermissionDialogBuilder.OnPermissionClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f30281a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PolicyPermissionDialogBuilder.OnPermissionClickListener f30282b;

        public a(Context context, PolicyPermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
            this.f30281a = context;
            this.f30282b = onPermissionClickListener;
        }

        @Override // com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.OnPermissionClickListener
        public void onPermissionClick(DialogInterface dialog, boolean alwaysDeny, boolean allow) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
            if (allow) {
                SocketHookUtil.recoveryPlatform();
                PolicyManager.INSTANCE.saveAgreeStatus(this.f30281a, 1);
            }
            this.f30282b.onPermissionClick(dialog, alwaysDeny, allow);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {1, 8, 0})
    @InterfaceC4112d(c = "com.stepos.policy.sdk.PolicyManager$autoUploadRecord$2", f = "PolicyManager.kt", l = {1351}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$autoUploadRecord$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f30289a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef<PolicyRecordRequest> f30290b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f30291c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Ref$ObjectRef<PolicyRecordRequest> ref$ObjectRef, Context context, InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.f30290b = ref$ObjectRef;
            this.f30291c = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass2(this.f30290b, this.f30291c, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.f30289a;
            if (i10 == 0) {
                C4849c.b(obj);
                String json = new Gson().toJson(this.f30290b.f34820a);
                PolicyManager policyManager = PolicyManager.INSTANCE;
                Context context = this.f30291c;
                this.f30289a = 1;
                if (policyManager.savePolicyOperate(context, false, json, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            return t.f7040a;
        }
    }

    @InterfaceC4112d(c = "com.stepos.policy.sdk.PolicyManager", f = "PolicyManager.kt", l = {181}, m = "awaitSyncLocalFileFinished")
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: com.stepos.policy.sdk.PolicyManager$awaitSyncLocalFileFinished$1, reason: invalid class name and case insensitive filesystem */
    public static final class C38371 extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public long f30292a;

        /* renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f30293b;

        /* renamed from: d, reason: collision with root package name */
        public int f30295d;

        public C38371(InterfaceC4014c<? super C38371> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f30293b = obj;
            this.f30295d |= Integer.MIN_VALUE;
            return PolicyManager.this.awaitSyncLocalFileFinished(this);
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"com/stepos/policy/sdk/PolicyManager$b", "Lcom/stepos/policy/sdk/dialog/PolicyPermissionDialogBuilder$OnPermissionClickListener;", "Landroid/content/DialogInterface;", C3081a.FOCUS_DIALOG_NAME, "", "alwaysDeny", "allow", "LY8/t;", "onPermissionClick", "(Landroid/content/DialogInterface;ZZ)V", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class b implements PolicyPermissionDialogBuilder.OnPermissionClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f30296a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f30297b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f30298c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f30299d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String[] f30300e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f30301f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ PolicyPermissionDialogBuilder.OnPermissionClickListener f30302g;

        public b(Context context, String str, String str2, String str3, String[] strArr, String str4, PolicyPermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
            this.f30296a = context;
            this.f30297b = str;
            this.f30298c = str2;
            this.f30299d = str3;
            this.f30300e = strArr;
            this.f30301f = str4;
            this.f30302g = onPermissionClickListener;
        }

        @Override // com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.OnPermissionClickListener
        public void onPermissionClick(DialogInterface dialog, boolean alwaysDeny, boolean allow) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
            String str = allow ? "2" : "0";
            if (allow) {
                SocketHookUtil.recoveryPlatform();
                PolicyManager.INSTANCE.saveAgreeStatus(this.f30296a, 1);
                PolicyManager.autoUploadRecord(this.f30296a, this.f30297b, this.f30298c, this.f30299d, this.f30300e, this.f30301f, str);
            }
            this.f30302g.onPermissionClick(dialog, alwaysDeny, allow);
        }
    }

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/stepos/policy/sdk/PolicyManager$c", "Lcom/stepos/policy/sdk/dialog/PolicyPermissionDialogBuilder$OnPermissionClickListener;", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class c implements PolicyPermissionDialogBuilder.OnPermissionClickListener {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {1, 8, 0})
    @InterfaceC4112d(c = "com.stepos.policy.sdk.PolicyManager$checkNewestPolicy$1", f = "PolicyManager.kt", l = {1547, 1597, 1610}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$checkNewestPolicy$1, reason: invalid class name and case insensitive filesystem */
    public static final class C38381 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public Object f30303a;

        /* renamed from: b, reason: collision with root package name */
        public Object f30304b;

        /* renamed from: c, reason: collision with root package name */
        public Object f30305c;

        /* renamed from: d, reason: collision with root package name */
        public Object f30306d;

        /* renamed from: e, reason: collision with root package name */
        public int f30307e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Context f30308f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f30309g;

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ String f30310h;

        /* renamed from: i, reason: collision with root package name */
        public final /* synthetic */ boolean f30311i;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ String f30312j;

        /* renamed from: k, reason: collision with root package name */
        public final /* synthetic */ String f30313k;

        /* renamed from: l, reason: collision with root package name */
        public final /* synthetic */ String f30314l;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ InterfaceC5074l<PolicySdkResultBean, t> f30315m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C38381(Context context, String str, String str2, boolean z10, String str3, String str4, String str5, InterfaceC5074l<? super PolicySdkResultBean, t> interfaceC5074l, InterfaceC4014c<? super C38381> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.f30308f = context;
            this.f30309g = str;
            this.f30310h = str2;
            this.f30311i = z10;
            this.f30312j = str3;
            this.f30313k = str4;
            this.f30314l = str5;
            this.f30315m = interfaceC5074l;
        }

        public static final void f(Ref$ObjectRef<PolicySdkResultBean> ref$ObjectRef, InterfaceC5074l<? super PolicySdkResultBean, t> interfaceC5074l, String str, String str2) {
            PolicySdkLogUtils.INSTANCE.logCheckNewestResult(ref$ObjectRef.f34820a, str, str2);
            interfaceC5074l.invoke(ref$ObjectRef.f34820a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new C38381(this.f30308f, this.f30309g, this.f30310h, this.f30311i, this.f30312j, this.f30313k, this.f30314l, this.f30315m, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((C38381) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:52:0x01a3, code lost:
        
            if (r0 == r6) goto L53;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0103  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x0134  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x0147  */
        /* JADX WARN: Type inference failed for: r0v19, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v3, types: [T, com.stepos.policy.sdk.bean.PolicySdkResultBean] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r36) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 1229
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.C38381.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J7\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\f\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u000e\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\r¨\u0006\u000f"}, d2 = {"com/stepos/policy/sdk/PolicyManager$d", "Lcom/stepos/policy/sdk/dialog/PolicyPermissionDialogBuilder$OnThreeButtonClickListener;", "Landroid/content/DialogInterface;", C3081a.FOCUS_DIALOG_NAME, "", "alwaysDeny", "", "", C3081a.FOCUS_MAP_NAME, "LY8/t;", "onFullAgreeClick", "(Landroid/content/DialogInterface;ZLjava/util/Map;)V", "onBasicOnlyClick", "(Landroid/content/DialogInterface;Z)V", "onRejectClick", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class d implements PolicyPermissionDialogBuilder.OnThreeButtonClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f30325a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f30326b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f30327c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f30328d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String[] f30329e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f30330f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ PolicyPermissionDialogBuilder.OnPermissionClickListener f30331g;

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ q.h f30332h;

        public d(Context context, String str, String str2, String str3, String[] strArr, String str4, PolicyPermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener, q.h hVar) {
            this.f30325a = context;
            this.f30326b = str;
            this.f30327c = str2;
            this.f30328d = str3;
            this.f30329e = strArr;
            this.f30330f = str4;
            this.f30331g = onPermissionClickListener;
            this.f30332h = hVar;
        }

        @Override // com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.OnThreeButtonClickListener
        public void onBasicOnlyClick(DialogInterface dialog, boolean alwaysDeny) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
            SocketHookUtil.recoveryPlatform();
            PolicyManager.INSTANCE.saveAgreeStatus(this.f30325a, 1);
            PolicyManager.autoUploadRecord(this.f30325a, this.f30326b, this.f30327c, this.f30328d, this.f30329e, this.f30330f, "1");
            this.f30332h.onPermissionClick(dialog, alwaysDeny, true);
        }

        @Override // com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.OnThreeButtonClickListener
        public void onFullAgreeClick(DialogInterface dialog, boolean alwaysDeny, Map<String, Boolean> map) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
            SocketHookUtil.recoveryPlatform();
            PolicyManager.INSTANCE.saveAgreeStatus(this.f30325a, 1);
            PolicyManager.autoUploadRecord(this.f30325a, this.f30326b, this.f30327c, this.f30328d, this.f30329e, this.f30330f, "2");
            this.f30331g.onPermissionClick(dialog, alwaysDeny, true);
        }

        @Override // com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.OnThreeButtonClickListener
        public void onRejectClick(DialogInterface dialog, boolean alwaysDeny) {
            this.f30332h.onPermissionClick(dialog, alwaysDeny, false);
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"com/stepos/policy/sdk/PolicyManager$e", "Lstepos/support/v7/app/q$h;", "Landroid/content/DialogInterface;", C3081a.FOCUS_DIALOG_NAME, "", "alwaysDeny", "allow", "LY8/t;", "onPermissionClick", "(Landroid/content/DialogInterface;ZZ)V", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class e implements q.h {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f30333a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f30334b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ q.h f30335c;

        public e(String str, Context context, q.h hVar) {
            this.f30333a = str;
            this.f30334b = context;
            this.f30335c = hVar;
        }

        @Override // stepos.support.v7.app.q.h
        public void onPermissionClick(DialogInterface dialog, boolean alwaysDeny, boolean allow) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
            if (allow && kotlin.jvm.internal.p.d(this.f30333a, "2")) {
                SocketHookUtil.recoveryPlatform();
                PolicyManager.INSTANCE.saveAgreeStatus(this.f30334b, 1);
            }
            this.f30335c.onPermissionClick(dialog, alwaysDeny, allow);
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"com/stepos/policy/sdk/PolicyManager$f", "Lstepos/support/v7/app/q$h;", "Landroid/content/DialogInterface;", C3081a.FOCUS_DIALOG_NAME, "", "alwaysDeny", "allow", "LY8/t;", "onPermissionClick", "(Landroid/content/DialogInterface;ZZ)V", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class f implements q.h {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f30342a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f30343b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f30344c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f30345d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String[] f30346e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f30347f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ q.h f30348g;

        public f(Context context, String str, String str2, String str3, String[] strArr, String str4, q.h hVar) {
            this.f30342a = context;
            this.f30343b = str;
            this.f30344c = str2;
            this.f30345d = str3;
            this.f30346e = strArr;
            this.f30347f = str4;
            this.f30348g = hVar;
        }

        @Override // stepos.support.v7.app.q.h
        public void onPermissionClick(DialogInterface dialog, boolean alwaysDeny, boolean allow) {
            String str = allow ? "2" : "0";
            if (allow) {
                PolicyManager.autoUploadRecord(this.f30342a, this.f30343b, this.f30344c, this.f30345d, this.f30346e, this.f30347f, str);
            }
            this.f30348g.onPermissionClick(dialog, alwaysDeny, allow);
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"com/stepos/policy/sdk/PolicyManager$g", "Lstepos/support/v7/app/q$h;", "Landroid/content/DialogInterface;", C3081a.FOCUS_DIALOG_NAME, "", "alwaysDeny", "allow", "LY8/t;", "onPermissionClick", "(Landroid/content/DialogInterface;ZZ)V", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class g implements q.h {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f30349a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f30350b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f30351c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f30352d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f30353e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String[] f30354f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f30355g;

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ q.h f30356h;

        public g(String str, Context context, String str2, String str3, String str4, String[] strArr, String str5, q.h hVar) {
            this.f30349a = str;
            this.f30350b = context;
            this.f30351c = str2;
            this.f30352d = str3;
            this.f30353e = str4;
            this.f30354f = strArr;
            this.f30355g = str5;
            this.f30356h = hVar;
        }

        @Override // stepos.support.v7.app.q.h
        public void onPermissionClick(DialogInterface dialog, boolean alwaysDeny, boolean allow) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
            if (allow) {
                if (kotlin.jvm.internal.p.d(this.f30349a, "1")) {
                    SocketHookUtil.recoveryPlatform();
                    PolicyManager.INSTANCE.saveAgreeStatus(this.f30350b, 1);
                }
                PolicyManager.autoUploadRecord(this.f30350b, this.f30351c, this.f30352d, this.f30353e, this.f30354f, this.f30355g, this.f30349a);
            }
            this.f30356h.onPermissionClick(dialog, alwaysDeny, allow);
        }
    }

    @InterfaceC4112d(c = "com.stepos.policy.sdk.PolicyManager", f = "PolicyManager.kt", l = {398}, m = "getAgreeStatus")
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: com.stepos.policy.sdk.PolicyManager$getAgreeStatus$1, reason: invalid class name and case insensitive filesystem */
    public static final class C38411 extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f30357a;

        /* renamed from: c, reason: collision with root package name */
        public int f30359c;

        public C38411(InterfaceC4014c<? super C38411> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f30357a = obj;
            this.f30359c |= Integer.MIN_VALUE;
            return PolicyManager.this.getAgreeStatus(null, this);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "", "<anonymous>", "(LUa/M;)Ljava/lang/String;"}, k = 3, mv = {1, 8, 0})
    @InterfaceC4112d(c = "com.stepos.policy.sdk.PolicyManager$getLocalCategoryMd5$1", f = "PolicyManager.kt", l = {2602}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$getLocalCategoryMd5$1, reason: invalid class name and case insensitive filesystem */
    public static final class C38431 extends SuspendLambda implements p<M, InterfaceC4014c<? super String>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f30364a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f30365b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f30366c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C38431(Context context, String str, InterfaceC4014c<? super C38431> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.f30365b = context;
            this.f30366c = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new C38431(this.f30365b, this.f30366c, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super String> interfaceC4014c) {
            return ((C38431) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.f30364a;
            if (i10 == 0) {
                C4849c.b(obj);
                final Xa.b data = com.stepos.policy.sdk.d.g(this.f30365b).getData();
                final String str = this.f30366c;
                Xa.b<String> bVar = new Xa.b<String>() { // from class: com.stepos.policy.sdk.PolicyManager$getLocalCategoryMd5$1$invokeSuspend$$inlined$map$1

                    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", UxipConstants.f30680s, "LY8/t;", "emit", "(Ljava/lang/Object;Le9/c;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
                    /* renamed from: com.stepos.policy.sdk.PolicyManager$getLocalCategoryMd5$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                    public static final class AnonymousClass2<T> implements Xa.c {

                        /* renamed from: a, reason: collision with root package name */
                        public final /* synthetic */ Xa.c f30261a;

                        /* renamed from: b, reason: collision with root package name */
                        public final /* synthetic */ String f30262b;

                        @InterfaceC4112d(c = "com.stepos.policy.sdk.PolicyManager$getLocalCategoryMd5$1$invokeSuspend$$inlined$map$1$2", f = "PolicyManager.kt", l = {223}, m = "emit")
                        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                        /* renamed from: com.stepos.policy.sdk.PolicyManager$getLocalCategoryMd5$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                        public static final class AnonymousClass1 extends ContinuationImpl {

                            /* renamed from: a, reason: collision with root package name */
                            public /* synthetic */ Object f30263a;

                            /* renamed from: b, reason: collision with root package name */
                            public int f30264b;

                            public AnonymousClass1(InterfaceC4014c interfaceC4014c) {
                                super(interfaceC4014c);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                this.f30263a = obj;
                                this.f30264b |= Integer.MIN_VALUE;
                                return AnonymousClass2.this.emit(null, this);
                            }
                        }

                        public AnonymousClass2(Xa.c cVar, String str) {
                            this.f30261a = cVar;
                            this.f30262b = str;
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                        @Override // Xa.c
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct add '--show-bad-code' argument
                        */
                        public final java.lang.Object emit(java.lang.Object r6, e9.InterfaceC4014c r7) throws java.lang.Throwable {
                            /*
                                r5 = this;
                                boolean r0 = r7 instanceof com.stepos.policy.sdk.PolicyManager$getLocalCategoryMd5$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1
                                if (r0 == 0) goto L13
                                r0 = r7
                                com.stepos.policy.sdk.PolicyManager$getLocalCategoryMd5$1$invokeSuspend$$inlined$map$1$2$1 r0 = (com.stepos.policy.sdk.PolicyManager$getLocalCategoryMd5$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                                int r1 = r0.f30264b
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.f30264b = r1
                                goto L18
                            L13:
                                com.stepos.policy.sdk.PolicyManager$getLocalCategoryMd5$1$invokeSuspend$$inlined$map$1$2$1 r0 = new com.stepos.policy.sdk.PolicyManager$getLocalCategoryMd5$1$invokeSuspend$$inlined$map$1$2$1
                                r0.<init>(r7)
                            L18:
                                java.lang.Object r7 = r0.f30263a
                                java.lang.Object r1 = f9.C4063a.g()
                                int r2 = r0.f30264b
                                r3 = 1
                                if (r2 == 0) goto L31
                                if (r2 != r3) goto L29
                                kotlin.C4849c.b(r7)
                                goto L5c
                            L29:
                                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                                r5.<init>(r6)
                                throw r5
                            L31:
                                kotlin.C4849c.b(r7)
                                Xa.c r7 = r5.f30261a
                                M0.a r6 = (M0.a) r6
                                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                                r2.<init>()
                                java.lang.String r4 = "local_"
                                r2.append(r4)
                                java.lang.String r5 = r5.f30262b
                                r2.append(r5)
                                java.lang.String r5 = r2.toString()
                                M0.a$a r5 = M0.c.f(r5)
                                java.lang.Object r5 = r6.b(r5)
                                r0.f30264b = r3
                                java.lang.Object r5 = r7.emit(r5, r0)
                                if (r5 != r1) goto L5c
                                return r1
                            L5c:
                                Y8.t r5 = Y8.t.f7040a
                                return r5
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager$getLocalCategoryMd5$1$invokeSuspend$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, e9.c):java.lang.Object");
                        }
                    }

                    @Override // Xa.b
                    public Object collect(Xa.c<? super String> cVar, InterfaceC4014c interfaceC4014c) {
                        Object objCollect = data.collect(new AnonymousClass2(cVar, str), interfaceC4014c);
                        return objCollect == C4063a.g() ? objCollect : t.f7040a;
                    }
                };
                this.f30364a = 1;
                obj = Xa.d.y(bVar, this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            String strValueOf = String.valueOf(obj);
            return kotlin.jvm.internal.p.d(strValueOf, "null") ? "" : strValueOf;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {1, 8, 0})
    @InterfaceC4112d(c = "com.stepos.policy.sdk.PolicyManager$getPolicyByVersion$1", f = "PolicyManager.kt", l = {2325, 2335}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$getPolicyByVersion$1, reason: invalid class name and case insensitive filesystem */
    public static final class C38441 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public Object f30367a;

        /* renamed from: b, reason: collision with root package name */
        public int f30368b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Long f30369c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f30370d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f30371e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f30372f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ InterfaceC5074l<PolicySdkResultBean, PolicySdkResultBean> f30373g;

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ String f30374h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C38441(Long l10, String str, String str2, String str3, InterfaceC5074l<? super PolicySdkResultBean, PolicySdkResultBean> interfaceC5074l, String str4, InterfaceC4014c<? super C38441> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.f30369c = l10;
            this.f30370d = str;
            this.f30371e = str2;
            this.f30372f = str3;
            this.f30373g = interfaceC5074l;
            this.f30374h = str4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new C38441(this.f30369c, this.f30370d, this.f30371e, this.f30372f, this.f30373g, this.f30374h, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((C38441) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:29:0x00b6, code lost:
        
            if (r0 == r8) goto L30;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v12, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v28, types: [T, com.stepos.policy.sdk.bean.PolicyVersionResponse] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r23) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 399
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.C38441.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {1, 8, 0})
    @InterfaceC4112d(c = "com.stepos.policy.sdk.PolicyManager$getPolicyData$1", f = "PolicyManager.kt", l = {2139, 2148}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$getPolicyData$1, reason: invalid class name and case insensitive filesystem */
    public static final class C38451 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public Object f30382a;

        /* renamed from: b, reason: collision with root package name */
        public int f30383b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f30384c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Long f30385d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f30386e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f30387f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f30388g;

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ InterfaceC5074l<PolicySdkResultBean, t> f30389h;

        /* renamed from: i, reason: collision with root package name */
        public final /* synthetic */ String f30390i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C38451(String str, Long l10, String str2, String str3, String str4, InterfaceC5074l<? super PolicySdkResultBean, t> interfaceC5074l, String str5, InterfaceC4014c<? super C38451> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.f30384c = str;
            this.f30385d = l10;
            this.f30386e = str2;
            this.f30387f = str3;
            this.f30388g = str4;
            this.f30389h = interfaceC5074l;
            this.f30390i = str5;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new C38451(this.f30384c, this.f30385d, this.f30386e, this.f30387f, this.f30388g, this.f30389h, this.f30390i, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((C38451) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:31:0x00c2, code lost:
        
            if (r0 == r9) goto L32;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v14, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v27, types: [T, com.stepos.policy.sdk.bean.PolicyNewestResponse] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r25) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 480
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.C38451.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {1, 8, 0})
    @InterfaceC4112d(c = "com.stepos.policy.sdk.PolicyManager$getPolicyHistoryList$1", f = "PolicyManager.kt", l = {2239, 2249}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$getPolicyHistoryList$1, reason: invalid class name and case insensitive filesystem */
    public static final class C38461 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public Object f30399a;

        /* renamed from: b, reason: collision with root package name */
        public int f30400b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f30401c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f30402d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f30403e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f30404f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ InterfaceC5074l<PolicySdkResultBean, PolicySdkResultBean> f30405g;

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ String f30406h;

        /* renamed from: i, reason: collision with root package name */
        public final /* synthetic */ long f30407i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C38461(String str, String str2, String str3, String str4, InterfaceC5074l<? super PolicySdkResultBean, PolicySdkResultBean> interfaceC5074l, String str5, long j10, InterfaceC4014c<? super C38461> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.f30401c = str;
            this.f30402d = str2;
            this.f30403e = str3;
            this.f30404f = str4;
            this.f30405g = interfaceC5074l;
            this.f30406h = str5;
            this.f30407i = j10;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new C38461(this.f30401c, this.f30402d, this.f30403e, this.f30404f, this.f30405g, this.f30406h, this.f30407i, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((C38461) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:29:0x00ba, code lost:
        
            if (r0 == r8) goto L30;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v12, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v27, types: [T, com.stepos.policy.sdk.bean.PolicyHistoryListResponse] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r25) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 397
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.C38461.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @InterfaceC4112d(c = "com.stepos.policy.sdk.PolicyManager", f = "PolicyManager.kt", l = {371}, m = "getPolicyOperate")
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: com.stepos.policy.sdk.PolicyManager$getPolicyOperate$1, reason: invalid class name and case insensitive filesystem */
    public static final class C38471 extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f30416a;

        /* renamed from: c, reason: collision with root package name */
        public int f30418c;

        public C38471(InterfaceC4014c<? super C38471> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f30416a = obj;
            this.f30418c |= Integer.MIN_VALUE;
            return PolicyManager.this.getPolicyOperate(null, this);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {1, 8, 0})
    @InterfaceC4112d(c = "com.stepos.policy.sdk.PolicyManager$getPolicyServiceConfig$1", f = "PolicyManager.kt", l = {2623, 2633}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$getPolicyServiceConfig$1, reason: invalid class name and case insensitive filesystem */
    public static final class C38481 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public Object f30419a;

        /* renamed from: b, reason: collision with root package name */
        public int f30420b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f30421c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f30422d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f30423e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ InterfaceC5074l<PolicySdkResultBean, PolicySdkResultBean> f30424f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f30425g;

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ Context f30426h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C38481(String str, String str2, String str3, InterfaceC5074l<? super PolicySdkResultBean, PolicySdkResultBean> interfaceC5074l, String str4, Context context, InterfaceC4014c<? super C38481> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.f30421c = str;
            this.f30422d = str2;
            this.f30423e = str3;
            this.f30424f = interfaceC5074l;
            this.f30425g = str4;
            this.f30426h = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new C38481(this.f30421c, this.f30422d, this.f30423e, this.f30424f, this.f30425g, this.f30426h, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((C38481) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:27:0x00ae, code lost:
        
            if (r0 == r8) goto L28;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v11, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v28, types: [T, com.stepos.policy.sdk.bean.PolicyServiceConfigResponse] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r22) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 402
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.C38481.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"com/stepos/policy/sdk/PolicyManager$h", "Lstepos/support/v7/app/q$h;", "Landroid/content/DialogInterface;", C3081a.FOCUS_DIALOG_NAME, "", "alwaysDeny", "allow", "LY8/t;", "onPermissionClick", "(Landroid/content/DialogInterface;ZZ)V", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class h implements q.h {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f30434a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f30435b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f30436c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f30437d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f30438e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String[] f30439f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f30440g;

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ q.h f30441h;

        public h(boolean z10, Context context, String str, String str2, String str3, String[] strArr, String str4, q.h hVar) {
            this.f30434a = z10;
            this.f30435b = context;
            this.f30436c = str;
            this.f30437d = str2;
            this.f30438e = str3;
            this.f30439f = strArr;
            this.f30440g = str4;
            this.f30441h = hVar;
        }

        @Override // stepos.support.v7.app.q.h
        public void onPermissionClick(DialogInterface dialog, boolean alwaysDeny, boolean allow) {
            if (allow && this.f30434a) {
                PolicyManager.autoUploadRecord(this.f30435b, this.f30436c, this.f30437d, this.f30438e, this.f30439f, this.f30440g, "2");
            }
            this.f30441h.onPermissionClick(dialog, alwaysDeny, allow);
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"com/stepos/policy/sdk/PolicyManager$i", "Lstepos/support/v7/app/q$h;", "Landroid/content/DialogInterface;", C3081a.FOCUS_DIALOG_NAME, "", "alwaysDeny", "allow", "LY8/t;", "onPermissionClick", "(Landroid/content/DialogInterface;ZZ)V", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class i implements q.h {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f30442a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f30443b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f30444c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f30445d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String[] f30446e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f30447f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ q.h f30448g;

        public i(Context context, String str, String str2, String str3, String[] strArr, String str4, q.h hVar) {
            this.f30442a = context;
            this.f30443b = str;
            this.f30444c = str2;
            this.f30445d = str3;
            this.f30446e = strArr;
            this.f30447f = str4;
            this.f30448g = hVar;
        }

        @Override // stepos.support.v7.app.q.h
        public void onPermissionClick(DialogInterface dialog, boolean alwaysDeny, boolean allow) {
            String str = allow ? "2" : "0";
            if (allow) {
                PolicyManager.autoUploadRecord(this.f30442a, this.f30443b, this.f30444c, this.f30445d, this.f30446e, this.f30447f, str);
            }
            this.f30448g.onPermissionClick(dialog, alwaysDeny, allow);
        }
    }

    @InterfaceC4112d(c = "com.stepos.policy.sdk.PolicyManager", f = "PolicyManager.kt", l = {AMapException.CODE_AMAP_CLIENT_NULLPOINT_EXCEPTION}, m = "initPolicyNewestPath")
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: com.stepos.policy.sdk.PolicyManager$initPolicyNewestPath$1, reason: invalid class name and case insensitive filesystem */
    public static final class C38501 extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public Object f30449a;

        /* renamed from: b, reason: collision with root package name */
        public Object f30450b;

        /* renamed from: c, reason: collision with root package name */
        public Object f30451c;

        /* renamed from: d, reason: collision with root package name */
        public Object f30452d;

        /* renamed from: e, reason: collision with root package name */
        public Object f30453e;

        /* renamed from: f, reason: collision with root package name */
        public Object f30454f;

        /* renamed from: g, reason: collision with root package name */
        public /* synthetic */ Object f30455g;

        /* renamed from: h, reason: collision with root package name */
        public int f30456h;

        public C38501(InterfaceC4014c<? super C38501> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f30455g = obj;
            this.f30456h |= Integer.MIN_VALUE;
            return PolicyManager.initPolicyNewestPath(null, null, null, this);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {1, 8, 0})
    @InterfaceC4112d(c = "com.stepos.policy.sdk.PolicyManager$initSDK$1", f = "PolicyManager.kt", l = {293, 294}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$initSDK$1, reason: invalid class name and case insensitive filesystem */
    public static final class C38511 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f30457a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f30458b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C38511(Context context, InterfaceC4014c<? super C38511> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.f30458b = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new C38511(this.f30458b, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((C38511) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0041, code lost:
        
            if (r5.loadCloudPolicyUidCategoryMap(r1, r4) == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) throws java.lang.Throwable {
            /*
                r4 = this;
                java.lang.Object r0 = f9.C4063a.g()
                int r1 = r4.f30457a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1e
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                kotlin.C4849c.b(r5)
                goto L44
            L12:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L1a:
                kotlin.C4849c.b(r5)
                goto L2e
            L1e:
                kotlin.C4849c.b(r5)
                com.stepos.policy.sdk.PolicyManager r5 = com.stepos.policy.sdk.PolicyManager.INSTANCE
                android.content.Context r1 = r4.f30458b
                r4.f30457a = r3
                java.lang.Object r5 = r5.getAgreeStatus(r1, r4)
                if (r5 != r0) goto L2e
                goto L43
            L2e:
                java.lang.Number r5 = (java.lang.Number) r5
                int r5 = r5.intValue()
                com.stepos.policy.sdk.util.PolicySdkNetworkGate.updateAgreeStatusCache(r5)
                com.stepos.policy.sdk.PolicyManager r5 = com.stepos.policy.sdk.PolicyManager.INSTANCE
                android.content.Context r1 = r4.f30458b
                r4.f30457a = r2
                java.lang.Object r4 = com.stepos.policy.sdk.PolicyManager.access$loadCloudPolicyUidCategoryMap(r5, r1, r4)
                if (r4 != r0) goto L44
            L43:
                return r0
            L44:
                Y8.t r4 = Y8.t.f7040a
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.C38511.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {1, 8, 0})
    @InterfaceC4112d(c = "com.stepos.policy.sdk.PolicyManager$initSDK$2", f = "PolicyManager.kt", l = {305}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$initSDK$2, reason: invalid class name and case insensitive filesystem */
    public static final class C38522 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f30459a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f30460b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ HashMap<String, String> f30461c;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {1, 8, 0})
        @InterfaceC4112d(c = "com.stepos.policy.sdk.PolicyManager$initSDK$2$1", f = "PolicyManager.kt", l = {318}, m = "invokeSuspend")
        /* renamed from: com.stepos.policy.sdk.PolicyManager$initSDK$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

            /* renamed from: a, reason: collision with root package name */
            public Object f30462a;

            /* renamed from: b, reason: collision with root package name */
            public Object f30463b;

            /* renamed from: c, reason: collision with root package name */
            public int f30464c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ Context f30465d;

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ HashMap<String, String> f30466e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Context context, HashMap<String, String> map, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
                super(2, interfaceC4014c);
                this.f30465d = context;
                this.f30466e = map;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
                return new AnonymousClass1(this.f30465d, this.f30466e, interfaceC4014c);
            }

            @Override // p9.p
            public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
                return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x005f  */
            /* JADX WARN: Removed duplicated region for block: B:15:0x00b3  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0096 -> B:14:0x0099). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
                /*
                    r9 = this;
                    java.lang.Object r0 = f9.C4063a.g()
                    int r1 = r9.f30464c
                    java.lang.String r2 = " *************** policyKey = "
                    r3 = 1
                    java.lang.String r4 = "initSDK"
                    if (r1 == 0) goto L24
                    if (r1 != r3) goto L1c
                    java.lang.Object r1 = r9.f30463b
                    java.lang.String r1 = (java.lang.String) r1
                    java.lang.Object r5 = r9.f30462a
                    java.util.Iterator r5 = (java.util.Iterator) r5
                    kotlin.C4849c.b(r10)
                    goto L99
                L1c:
                    java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                    java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                    r9.<init>(r10)
                    throw r9
                L24:
                    kotlin.C4849c.b(r10)
                    com.stepos.policy.sdk.PolicyManager r10 = com.stepos.policy.sdk.PolicyManager.INSTANCE
                    r1 = 0
                    r10.setSyncLocalFileFinished(r1)
                    com.stepos.policy.sdk.util.PolicySdkLogUtils$Companion r1 = com.stepos.policy.sdk.util.PolicySdkLogUtils.INSTANCE
                    java.lang.StringBuilder r5 = new java.lang.StringBuilder
                    r5.<init>()
                    java.lang.String r6 = "syncLocalFileFinished start time = "
                    r5.append(r6)
                    long r6 = java.lang.System.currentTimeMillis()
                    r5.append(r6)
                    java.lang.String r5 = r5.toString()
                    r1.d(r4, r5)
                    android.content.Context r1 = r9.f30465d
                    java.util.HashMap<java.lang.String, java.lang.String> r5 = r9.f30466e
                    com.stepos.policy.sdk.PolicyManager.access$selfCheckLocalAssets(r10, r1, r5)
                    java.util.HashMap<java.lang.String, java.lang.String> r10 = r9.f30466e
                    java.util.Set r10 = r10.entrySet()
                    java.util.Iterator r10 = r10.iterator()
                    r5 = r10
                L59:
                    boolean r10 = r5.hasNext()
                    if (r10 == 0) goto Lb3
                    java.lang.Object r10 = r5.next()
                    java.util.Map$Entry r10 = (java.util.Map.Entry) r10
                    java.lang.Object r1 = r10.getKey()
                    java.lang.String r1 = (java.lang.String) r1
                    java.lang.Object r10 = r10.getValue()
                    java.lang.String r10 = (java.lang.String) r10
                    com.stepos.policy.sdk.util.PolicySdkLogUtils$Companion r6 = com.stepos.policy.sdk.util.PolicySdkLogUtils.INSTANCE
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder
                    r7.<init>()
                    r7.append(r2)
                    r7.append(r1)
                    java.lang.String r8 = " start***************"
                    r7.append(r8)
                    java.lang.String r7 = r7.toString()
                    r6.d(r4, r7)
                    android.content.Context r6 = r9.f30465d
                    r9.f30462a = r5
                    r9.f30463b = r1
                    r9.f30464c = r3
                    java.lang.Object r10 = com.stepos.policy.sdk.PolicyManager.initPolicyNewestPath(r6, r10, r1, r9)
                    if (r10 != r0) goto L99
                    return r0
                L99:
                    com.stepos.policy.sdk.util.PolicySdkLogUtils$Companion r10 = com.stepos.policy.sdk.util.PolicySdkLogUtils.INSTANCE
                    java.lang.StringBuilder r6 = new java.lang.StringBuilder
                    r6.<init>()
                    r6.append(r2)
                    r6.append(r1)
                    java.lang.String r1 = " end ***************"
                    r6.append(r1)
                    java.lang.String r1 = r6.toString()
                    r10.d(r4, r1)
                    goto L59
                Lb3:
                    com.stepos.policy.sdk.PolicyManager r10 = com.stepos.policy.sdk.PolicyManager.INSTANCE
                    r10.setSyncLocalFileFinished(r3)
                    com.stepos.policy.sdk.util.PolicySdkLogUtils$Companion r10 = com.stepos.policy.sdk.util.PolicySdkLogUtils.INSTANCE
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.lang.String r1 = ">>> DONE syncLocalFileFinished=true, storage="
                    r0.append(r1)
                    android.content.Context r1 = r9.f30465d
                    java.io.File r1 = r1.getDataDir()
                    if (r1 == 0) goto Ld1
                    java.lang.String r1 = r1.getPath()
                    goto Ld2
                Ld1:
                    r1 = 0
                Ld2:
                    r0.append(r1)
                    java.lang.String r1 = ", categories="
                    r0.append(r1)
                    java.util.HashMap<java.lang.String, java.lang.String> r9 = r9.f30466e
                    java.util.Set r9 = r9.keySet()
                    r0.append(r9)
                    java.lang.String r9 = r0.toString()
                    r10.i(r4, r9)
                    Y8.t r9 = Y8.t.f7040a
                    return r9
                */
                throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.C38522.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C38522(Context context, HashMap<String, String> map, InterfaceC4014c<? super C38522> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.f30460b = context;
            this.f30461c = map;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new C38522(this.f30460b, this.f30461c, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((C38522) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.f30459a;
            if (i10 == 0) {
                C4849c.b(obj);
                I iB = Y.b();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f30460b, this.f30461c, null);
                this.f30459a = 1;
                if (C1056g.j(iB, anonymousClass1, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            return t.f7040a;
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"com/stepos/policy/sdk/PolicyManager$j", "Lstepos/support/v7/app/q$h;", "Landroid/content/DialogInterface;", C3081a.FOCUS_DIALOG_NAME, "", "alwaysDeny", "allow", "LY8/t;", "onPermissionClick", "(Landroid/content/DialogInterface;ZZ)V", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class j implements q.h {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f30467a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f30468b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f30469c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f30470d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String[] f30471e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f30472f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ q.h f30473g;

        public j(Context context, String str, String str2, String str3, String[] strArr, String str4, q.h hVar) {
            this.f30467a = context;
            this.f30468b = str;
            this.f30469c = str2;
            this.f30470d = str3;
            this.f30471e = strArr;
            this.f30472f = str4;
            this.f30473g = hVar;
        }

        @Override // stepos.support.v7.app.q.h
        public void onPermissionClick(DialogInterface dialog, boolean alwaysDeny, boolean allow) {
            String str = allow ? "2" : "0";
            if (allow) {
                PolicyManager.autoUploadRecord(this.f30467a, this.f30468b, this.f30469c, this.f30470d, this.f30471e, this.f30472f, str);
            }
            this.f30473g.onPermissionClick(dialog, alwaysDeny, allow);
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"com/stepos/policy/sdk/PolicyManager$k", "Lcom/stepos/policy/sdk/dialog/PolicyPermissionDialogBuilder$OnPermissionClickListener;", "Landroid/content/DialogInterface;", C3081a.FOCUS_DIALOG_NAME, "", "alwaysDeny", "allow", "LY8/t;", "onPermissionClick", "(Landroid/content/DialogInterface;ZZ)V", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class k implements PolicyPermissionDialogBuilder.OnPermissionClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef<stepos.support.v7.app.c> f30474a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PolicyPermissionDialogBuilder.OnPermissionClickListener f30475b;

        public k(Ref$ObjectRef<stepos.support.v7.app.c> ref$ObjectRef, PolicyPermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
            this.f30474a = ref$ObjectRef;
            this.f30475b = onPermissionClickListener;
        }

        @Override // com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.OnPermissionClickListener
        public void onPermissionClick(DialogInterface dialog, boolean alwaysDeny, boolean allow) {
            try {
                stepos.support.v7.app.c cVar = this.f30474a.f34820a;
                View viewFindViewById = cVar != null ? cVar.findViewById(R$id.stepos_permission_dialog_checkbox_first) : null;
                kotlin.jvm.internal.p.g(viewFindViewById, "null cannot be cast to non-null type android.widget.CheckBox");
                this.f30475b.onPermissionClick(dialog, ((CheckBox) viewFindViewById).isChecked(), allow);
            } catch (Exception unused) {
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"com/stepos/policy/sdk/PolicyManager$l", "Lcom/stepos/policy/sdk/dialog/PolicyPermissionDialogBuilder$OnPermissionClickListener;", "Landroid/content/DialogInterface;", C3081a.FOCUS_DIALOG_NAME, "", "alwaysDeny", "allow", "LY8/t;", "onPermissionClick", "(Landroid/content/DialogInterface;ZZ)V", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class l implements PolicyPermissionDialogBuilder.OnPermissionClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef<stepos.support.v7.app.c> f30476a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PolicyPermissionDialogBuilder.OnPermissionClickListener f30477b;

        public l(Ref$ObjectRef<stepos.support.v7.app.c> ref$ObjectRef, PolicyPermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
            this.f30476a = ref$ObjectRef;
            this.f30477b = onPermissionClickListener;
        }

        @Override // com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.OnPermissionClickListener
        public void onPermissionClick(DialogInterface dialog, boolean alwaysDeny, boolean allow) {
            try {
                stepos.support.v7.app.c cVar = this.f30476a.f34820a;
                View viewFindViewById = cVar != null ? cVar.findViewById(R$id.stepos_permission_dialog_checkbox_first) : null;
                kotlin.jvm.internal.p.g(viewFindViewById, "null cannot be cast to non-null type android.widget.CheckBox");
                boolean zIsChecked = ((CheckBox) viewFindViewById).isChecked();
                stepos.support.v7.app.c cVar2 = this.f30476a.f34820a;
                View viewFindViewById2 = cVar2 != null ? cVar2.findViewById(R$id.stepos_permission_dialog_checkbox_second) : null;
                kotlin.jvm.internal.p.g(viewFindViewById2, "null cannot be cast to non-null type android.widget.CheckBox");
                this.f30477b.onPermissionClick(dialog, allow, zIsChecked, ((CheckBox) viewFindViewById2).isChecked());
            } catch (Exception unused) {
            }
        }
    }

    @InterfaceC4112d(c = "com.stepos.policy.sdk.PolicyManager", f = "PolicyManager.kt", l = {404}, m = "loadCloudPolicyUidCategoryMap")
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: com.stepos.policy.sdk.PolicyManager$loadCloudPolicyUidCategoryMap$1, reason: invalid class name and case insensitive filesystem */
    public static final class C38531 extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f30478a;

        /* renamed from: c, reason: collision with root package name */
        public int f30480c;

        public C38531(InterfaceC4014c<? super C38531> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f30478a = obj;
            this.f30480c |= Integer.MIN_VALUE;
            return PolicyManager.this.loadCloudPolicyUidCategoryMap(null, this);
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"com/stepos/policy/sdk/PolicyManager$m", "Lkotlin/coroutines/a;", "LUa/J;", "Lkotlin/coroutines/d;", "context", "", "exception", "LY8/t;", "handleException", "(Lkotlin/coroutines/d;Ljava/lang/Throwable;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class m extends kotlin.coroutines.a implements J {
        public m(J.Companion companion) {
            super(companion);
        }

        @Override // Ua.J
        public void handleException(kotlin.coroutines.d context, Throwable exception) {
            PolicySdkLogUtils.INSTANCE.d("exceptionHandler", context.get(CoroutineName.INSTANCE) + " 处理异常 ：" + exception);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {1, 8, 0})
    @InterfaceC4112d(c = "com.stepos.policy.sdk.PolicyManager$persistCloudPolicyUidCategoryMap$1", f = "PolicyManager.kt", l = {425}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$persistCloudPolicyUidCategoryMap$1, reason: invalid class name and case insensitive filesystem */
    public static final class C38541 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f30481a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f30482b;

        @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/datastore/preferences/core/MutablePreferences;", "prefs", "LY8/t;", "<anonymous>", "(Landroidx/datastore/preferences/core/MutablePreferences;)V"}, k = 3, mv = {1, 8, 0})
        @InterfaceC4112d(c = "com.stepos.policy.sdk.PolicyManager$persistCloudPolicyUidCategoryMap$1$1", f = "PolicyManager.kt", l = {}, m = "invokeSuspend")
        /* renamed from: com.stepos.policy.sdk.PolicyManager$persistCloudPolicyUidCategoryMap$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C03611 extends SuspendLambda implements p<MutablePreferences, InterfaceC4014c<? super t>, Object> {

            /* renamed from: a, reason: collision with root package name */
            public int f30483a;

            /* renamed from: b, reason: collision with root package name */
            public /* synthetic */ Object f30484b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ String f30485c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C03611(String str, InterfaceC4014c<? super C03611> interfaceC4014c) {
                super(2, interfaceC4014c);
                this.f30485c = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
                C03611 c03611 = new C03611(this.f30485c, interfaceC4014c);
                c03611.f30484b = obj;
                return c03611;
            }

            @Override // p9.p
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public final Object invoke(MutablePreferences mutablePreferences, InterfaceC4014c<? super t> interfaceC4014c) {
                return ((C03611) create(mutablePreferences, interfaceC4014c)).invokeSuspend(t.f7040a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                C4063a.g();
                if (this.f30483a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
                MutablePreferences mutablePreferences = (MutablePreferences) this.f30484b;
                a.C0079a<String> c0079aC = com.stepos.policy.sdk.d.c();
                String json = this.f30485c;
                kotlin.jvm.internal.p.h(json, "json");
                mutablePreferences.i(c0079aC, json);
                return t.f7040a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C38541(Context context, InterfaceC4014c<? super C38541> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.f30482b = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new C38541(this.f30482b, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((C38541) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.f30481a;
            try {
                if (i10 == 0) {
                    C4849c.b(obj);
                    String json = new Gson().toJson(PolicyCloudPolicyIndex.snapshot());
                    J0.d dVarG = com.stepos.policy.sdk.d.g(this.f30482b);
                    C03611 c03611 = new C03611(json, null);
                    this.f30481a = 1;
                    if (PreferencesKt.a(dVarG, c03611, this) == objG) {
                        return objG;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    C4849c.b(obj);
                }
            } catch (Exception e10) {
                PolicySdkLogUtils.INSTANCE.e("CloudPolicyIndex", "persist failed: " + e10);
            }
            return t.f7040a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {1, 8, 0})
    @InterfaceC4112d(c = "com.stepos.policy.sdk.PolicyManager$reTryUploadRecord$1", f = "PolicyManager.kt", l = {1132, 1135}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$reTryUploadRecord$1, reason: invalid class name and case insensitive filesystem */
    public static final class C38551 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f30486a;

        /* renamed from: b, reason: collision with root package name */
        public int f30487b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f30488c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ PolicyManager f30489d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C38551(Context context, PolicyManager policyManager, InterfaceC4014c<? super C38551> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.f30488c = context;
            this.f30489d = policyManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new C38551(this.f30488c, this.f30489d, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((C38551) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x0086  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
            /*
                r8 = this;
                java.lang.Object r0 = f9.C4063a.g()
                int r1 = r8.f30487b
                java.lang.String r2 = "isNeedReTry= "
                java.lang.String r3 = "reTryUploadRecord"
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L24
                if (r1 == r5) goto L20
                if (r1 != r4) goto L18
                int r0 = r8.f30486a
                kotlin.C4849c.b(r9)
                goto L62
            L18:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L20:
                kotlin.C4849c.b(r9)
                goto L34
            L24:
                kotlin.C4849c.b(r9)
                com.stepos.policy.sdk.PolicyManager r9 = com.stepos.policy.sdk.PolicyManager.INSTANCE
                android.content.Context r1 = r8.f30488c
                r8.f30487b = r5
                java.lang.Object r9 = r9.getPolicyOperate(r1, r8)
                if (r9 != r0) goto L34
                goto L60
            L34:
                java.lang.Boolean r9 = (java.lang.Boolean) r9
                boolean r9 = r9.booleanValue()
                r1 = r9 ^ 1
                com.stepos.policy.sdk.util.PolicySdkLogUtils$Companion r6 = com.stepos.policy.sdk.util.PolicySdkLogUtils.INSTANCE
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>()
                r7.append(r2)
                r7.append(r1)
                java.lang.String r7 = r7.toString()
                r6.d(r3, r7)
                if (r9 != 0) goto Lb0
                com.stepos.policy.sdk.PolicyManager r9 = com.stepos.policy.sdk.PolicyManager.INSTANCE
                android.content.Context r6 = r8.f30488c
                r8.f30486a = r1
                r8.f30487b = r4
                java.lang.Object r9 = r9.getPolicyOperateJson(r6, r8)
                if (r9 != r0) goto L61
            L60:
                return r0
            L61:
                r0 = r1
            L62:
                java.lang.String r9 = (java.lang.String) r9
                if (r9 == 0) goto Lb0
                int r1 = r9.length()
                if (r1 <= 0) goto Lb0
                com.google.gson.Gson r1 = new com.google.gson.Gson
                r1.<init>()
                java.lang.Class<com.stepos.policy.sdk.bean.PolicyRecordRequest> r4 = com.stepos.policy.sdk.bean.PolicyRecordRequest.class
                java.lang.Object r9 = r1.fromJson(r9, r4)
                com.stepos.policy.sdk.bean.PolicyRecordRequest r9 = (com.stepos.policy.sdk.bean.PolicyRecordRequest) r9
                com.stepos.policy.sdk.util.PolicySdkLogUtils$Companion r1 = com.stepos.policy.sdk.util.PolicySdkLogUtils.INSTANCE
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                r4.append(r2)
                if (r0 == 0) goto L86
                goto L87
            L86:
                r5 = 0
            L87:
                r4.append(r5)
                java.lang.String r0 = r4.toString()
                r1.d(r3, r0)
                com.stepos.policy.sdk.PolicyManager r0 = com.stepos.policy.sdk.PolicyManager.INSTANCE
                java.lang.String r1 = r0.getMAppId()
                java.lang.String r2 = r0.getMAppSecret()
                java.lang.String r0 = r0.getMAppVersionName()
                java.lang.String r3 = "policyRecordRequest"
                kotlin.jvm.internal.p.h(r9, r3)
                com.stepos.policy.sdk.PolicyManager$reTryUploadRecord$1$1 r3 = new com.stepos.policy.sdk.PolicyManager$reTryUploadRecord$1$1
                com.stepos.policy.sdk.PolicyManager r4 = r8.f30489d
                android.content.Context r8 = r8.f30488c
                r3.<init>()
                com.stepos.policy.sdk.PolicyManager.uploadPolicyOperateRecord(r1, r2, r0, r9, r3)
            Lb0:
                Y8.t r8 = Y8.t.f7040a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.C38551.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @InterfaceC4112d(c = "com.stepos.policy.sdk.PolicyManager", f = "PolicyManager.kt", l = {128}, m = "resolveSignSecret")
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: com.stepos.policy.sdk.PolicyManager$resolveSignSecret$1, reason: invalid class name and case insensitive filesystem */
    public static final class C38561 extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public Object f30496a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f30497b;

        /* renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f30498c;

        /* renamed from: e, reason: collision with root package name */
        public int f30500e;

        public C38561(InterfaceC4014c<? super C38561> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f30498c = obj;
            this.f30500e |= Integer.MIN_VALUE;
            return PolicyManager.this.resolveSignSecret(null, null, null, false, this);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {1, 8, 0})
    @InterfaceC4112d(c = "com.stepos.policy.sdk.PolicyManager$saveAgreeStatus$1", f = "PolicyManager.kt", l = {379}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$saveAgreeStatus$1, reason: invalid class name and case insensitive filesystem */
    public static final class C38571 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f30501a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f30502b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f30503c;

        @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/datastore/preferences/core/MutablePreferences;", "policy_sdk_data", "LY8/t;", "<anonymous>", "(Landroidx/datastore/preferences/core/MutablePreferences;)V"}, k = 3, mv = {1, 8, 0})
        @InterfaceC4112d(c = "com.stepos.policy.sdk.PolicyManager$saveAgreeStatus$1$1", f = "PolicyManager.kt", l = {}, m = "invokeSuspend")
        /* renamed from: com.stepos.policy.sdk.PolicyManager$saveAgreeStatus$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C03641 extends SuspendLambda implements p<MutablePreferences, InterfaceC4014c<? super t>, Object> {

            /* renamed from: a, reason: collision with root package name */
            public int f30504a;

            /* renamed from: b, reason: collision with root package name */
            public /* synthetic */ Object f30505b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ int f30506c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C03641(int i10, InterfaceC4014c<? super C03641> interfaceC4014c) {
                super(2, interfaceC4014c);
                this.f30506c = i10;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
                C03641 c03641 = new C03641(this.f30506c, interfaceC4014c);
                c03641.f30505b = obj;
                return c03641;
            }

            @Override // p9.p
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public final Object invoke(MutablePreferences mutablePreferences, InterfaceC4014c<? super t> interfaceC4014c) {
                return ((C03641) create(mutablePreferences, interfaceC4014c)).invokeSuspend(t.f7040a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                C4063a.g();
                if (this.f30504a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
                ((MutablePreferences) this.f30505b).i(com.stepos.policy.sdk.d.b(), C4109a.f(this.f30506c));
                return t.f7040a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C38571(Context context, int i10, InterfaceC4014c<? super C38571> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.f30502b = context;
            this.f30503c = i10;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new C38571(this.f30502b, this.f30503c, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((C38571) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.f30501a;
            try {
                if (i10 == 0) {
                    C4849c.b(obj);
                    J0.d dVarG = com.stepos.policy.sdk.d.g(this.f30502b);
                    C03641 c03641 = new C03641(this.f30503c, null);
                    this.f30501a = 1;
                    if (PreferencesKt.a(dVarG, c03641, this) == objG) {
                        return objG;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    C4849c.b(obj);
                }
            } catch (Exception e10) {
                PolicySdkLogUtils.INSTANCE.e("savePolicyCategoryVersion", "error =" + e10 + ' ');
            }
            return t.f7040a;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/datastore/preferences/core/MutablePreferences;", "policy_sdk_data", "LY8/t;", "<anonymous>", "(Landroidx/datastore/preferences/core/MutablePreferences;)V"}, k = 3, mv = {1, 8, 0})
    @InterfaceC4112d(c = "com.stepos.policy.sdk.PolicyManager$saveDataStoreString$2", f = "PolicyManager.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$saveDataStoreString$2, reason: invalid class name and case insensitive filesystem */
    public static final class C38582 extends SuspendLambda implements p<MutablePreferences, InterfaceC4014c<? super t>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f30507a;

        /* renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f30508b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a.C0079a<String> f30509c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f30510d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C38582(a.C0079a<String> c0079a, String str, InterfaceC4014c<? super C38582> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.f30509c = c0079a;
            this.f30510d = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            C38582 c38582 = new C38582(this.f30509c, this.f30510d, interfaceC4014c);
            c38582.f30508b = obj;
            return c38582;
        }

        @Override // p9.p
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object invoke(MutablePreferences mutablePreferences, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((C38582) create(mutablePreferences, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.f30507a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            MutablePreferences mutablePreferences = (MutablePreferences) this.f30508b;
            a.C0079a<String> c0079a = this.f30509c;
            String str = this.f30510d;
            if (str == null) {
                str = "";
            }
            mutablePreferences.i(c0079a, str);
            return t.f7040a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {1, 8, 0})
    @InterfaceC4112d(c = "com.stepos.policy.sdk.PolicyManager$saveLocalCategoryMd5$1", f = "PolicyManager.kt", l = {2583}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$saveLocalCategoryMd5$1, reason: invalid class name and case insensitive filesystem */
    public static final class C38591 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f30511a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f30512b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f30513c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Context f30514d;

        @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/datastore/preferences/core/MutablePreferences;", "policy_sdk_data", "LY8/t;", "<anonymous>", "(Landroidx/datastore/preferences/core/MutablePreferences;)V"}, k = 3, mv = {1, 8, 0})
        @InterfaceC4112d(c = "com.stepos.policy.sdk.PolicyManager$saveLocalCategoryMd5$1$1", f = "PolicyManager.kt", l = {}, m = "invokeSuspend")
        /* renamed from: com.stepos.policy.sdk.PolicyManager$saveLocalCategoryMd5$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C03651 extends SuspendLambda implements p<MutablePreferences, InterfaceC4014c<? super t>, Object> {

            /* renamed from: a, reason: collision with root package name */
            public int f30515a;

            /* renamed from: b, reason: collision with root package name */
            public /* synthetic */ Object f30516b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ String f30517c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ String f30518d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C03651(String str, String str2, InterfaceC4014c<? super C03651> interfaceC4014c) {
                super(2, interfaceC4014c);
                this.f30517c = str;
                this.f30518d = str2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
                C03651 c03651 = new C03651(this.f30517c, this.f30518d, interfaceC4014c);
                c03651.f30516b = obj;
                return c03651;
            }

            @Override // p9.p
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public final Object invoke(MutablePreferences mutablePreferences, InterfaceC4014c<? super t> interfaceC4014c) {
                return ((C03651) create(mutablePreferences, interfaceC4014c)).invokeSuspend(t.f7040a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                C4063a.g();
                if (this.f30515a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
                ((MutablePreferences) this.f30516b).i(M0.c.f("local_" + this.f30517c), this.f30518d);
                return t.f7040a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C38591(String str, String str2, Context context, InterfaceC4014c<? super C38591> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.f30512b = str;
            this.f30513c = str2;
            this.f30514d = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new C38591(this.f30512b, this.f30513c, this.f30514d, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((C38591) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.f30511a;
            try {
                if (i10 == 0) {
                    C4849c.b(obj);
                    PolicySdkLogUtils.INSTANCE.d("saveLocalCategoryMd5", "the " + this.f30512b + " save local md5 is " + this.f30513c);
                    String str = this.f30513c;
                    if (str != null && str.length() != 0) {
                        J0.d dVarG = com.stepos.policy.sdk.d.g(this.f30514d);
                        C03651 c03651 = new C03651(this.f30512b, this.f30513c, null);
                        this.f30511a = 1;
                        if (PreferencesKt.a(dVarG, c03651, this) == objG) {
                            return objG;
                        }
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    C4849c.b(obj);
                }
            } catch (Exception e10) {
                PolicySdkLogUtils.INSTANCE.e("saveLocalCategoryMd5", "error =" + e10 + ' ');
            }
            return t.f7040a;
        }
    }

    @InterfaceC4112d(c = "com.stepos.policy.sdk.PolicyManager", f = "PolicyManager.kt", l = {345, 349}, m = "savePolicyOperate")
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: com.stepos.policy.sdk.PolicyManager$savePolicyOperate$1, reason: invalid class name and case insensitive filesystem */
    public static final class C38601 extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public Object f30519a;

        /* renamed from: b, reason: collision with root package name */
        public Object f30520b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f30521c;

        /* renamed from: d, reason: collision with root package name */
        public /* synthetic */ Object f30522d;

        /* renamed from: f, reason: collision with root package name */
        public int f30524f;

        public C38601(InterfaceC4014c<? super C38601> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f30522d = obj;
            this.f30524f |= Integer.MIN_VALUE;
            return PolicyManager.this.savePolicyOperate(null, false, null, this);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/datastore/preferences/core/MutablePreferences;", "policy_sdk_data", "LY8/t;", "<anonymous>", "(Landroidx/datastore/preferences/core/MutablePreferences;)V"}, k = 3, mv = {1, 8, 0})
    @InterfaceC4112d(c = "com.stepos.policy.sdk.PolicyManager$savePolicyOperate$2", f = "PolicyManager.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$savePolicyOperate$2, reason: invalid class name and case insensitive filesystem */
    public static final class C38612 extends SuspendLambda implements p<MutablePreferences, InterfaceC4014c<? super t>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f30525a;

        /* renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f30526b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f30527c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C38612(boolean z10, InterfaceC4014c<? super C38612> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.f30527c = z10;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            C38612 c38612 = new C38612(this.f30527c, interfaceC4014c);
            c38612.f30526b = obj;
            return c38612;
        }

        @Override // p9.p
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object invoke(MutablePreferences mutablePreferences, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((C38612) create(mutablePreferences, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.f30525a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            ((MutablePreferences) this.f30526b).i(com.stepos.policy.sdk.d.e(), C4109a.a(this.f30527c));
            return t.f7040a;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/datastore/preferences/core/MutablePreferences;", "policy_sdk_data", "LY8/t;", "<anonymous>", "(Landroidx/datastore/preferences/core/MutablePreferences;)V"}, k = 3, mv = {1, 8, 0})
    @InterfaceC4112d(c = "com.stepos.policy.sdk.PolicyManager$savePolicyOperate$3", f = "PolicyManager.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$savePolicyOperate$3, reason: invalid class name */
    public static final class AnonymousClass3 extends SuspendLambda implements p<MutablePreferences, InterfaceC4014c<? super t>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f30528a;

        /* renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f30529b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f30530c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(String str, InterfaceC4014c<? super AnonymousClass3> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.f30530c = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.f30530c, interfaceC4014c);
            anonymousClass3.f30529b = obj;
            return anonymousClass3;
        }

        @Override // p9.p
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object invoke(MutablePreferences mutablePreferences, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass3) create(mutablePreferences, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.f30528a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            MutablePreferences mutablePreferences = (MutablePreferences) this.f30529b;
            a.C0079a<String> c0079aF = com.stepos.policy.sdk.d.f();
            String str = this.f30530c;
            if (str == null) {
                str = "";
            }
            mutablePreferences.i(c0079aF, str);
            return t.f7040a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {1, 8, 0})
    @InterfaceC4112d(c = "com.stepos.policy.sdk.PolicyManager$uploadPolicyOperateRecord$1", f = "PolicyManager.kt", l = {504, 513}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$uploadPolicyOperateRecord$1, reason: invalid class name and case insensitive filesystem */
    public static final class C38621 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public Object f30531a;

        /* renamed from: b, reason: collision with root package name */
        public int f30532b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f30533c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f30534d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ InterfaceC5074l<PolicySdkResultBean, t> f30535e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ PolicyRecordRequest f30536f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f30537g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C38621(String str, String str2, InterfaceC5074l<? super PolicySdkResultBean, t> interfaceC5074l, PolicyRecordRequest policyRecordRequest, String str3, InterfaceC4014c<? super C38621> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.f30533c = str;
            this.f30534d = str2;
            this.f30535e = interfaceC5074l;
            this.f30536f = policyRecordRequest;
            this.f30537g = str3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new C38621(this.f30533c, this.f30534d, this.f30535e, this.f30536f, this.f30537g, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((C38621) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x00aa, code lost:
        
            if (r0 == r8) goto L27;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v12, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v2 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r21) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 362
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.C38621.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {1, 8, 0})
    @InterfaceC4112d(c = "com.stepos.policy.sdk.PolicyManager$uploadRecordToCleanServiceData$1", f = "PolicyManager.kt", l = {1282}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$uploadRecordToCleanServiceData$1, reason: invalid class name and case insensitive filesystem */
    public static final class C38641 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public Object f30545a;

        /* renamed from: b, reason: collision with root package name */
        public int f30546b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f30547c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String[] f30548d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f30549e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f30550f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f30551g;

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ String f30552h;

        /* renamed from: i, reason: collision with root package name */
        public final /* synthetic */ String f30553i;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ ArrayList<DeleteInfoBean> f30554j;

        /* renamed from: k, reason: collision with root package name */
        public final /* synthetic */ String f30555k;

        /* renamed from: l, reason: collision with root package name */
        public final /* synthetic */ String f30556l;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ String f30557m;

        /* renamed from: n, reason: collision with root package name */
        public final /* synthetic */ InterfaceC5074l<PolicySdkResultBean, t> f30558n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C38641(Context context, String[] strArr, String str, String str2, String str3, String str4, String str5, ArrayList<DeleteInfoBean> arrayList, String str6, String str7, String str8, InterfaceC5074l<? super PolicySdkResultBean, t> interfaceC5074l, InterfaceC4014c<? super C38641> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.f30547c = context;
            this.f30548d = strArr;
            this.f30549e = str;
            this.f30550f = str2;
            this.f30551g = str3;
            this.f30552h = str4;
            this.f30553i = str5;
            this.f30554j = arrayList;
            this.f30555k = str6;
            this.f30556l = str7;
            this.f30557m = str8;
            this.f30558n = interfaceC5074l;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new C38641(this.f30547c, this.f30548d, this.f30549e, this.f30550f, this.f30551g, this.f30552h, this.f30553i, this.f30554j, this.f30555k, this.f30556l, this.f30557m, this.f30558n, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((C38641) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            PolicyRecordRequest policyRecordRequest;
            PolicyRecordRequest policyRecordRequest2;
            ArrayList<DeleteInfoBean> arrayList;
            Object objG = C4063a.g();
            int i10 = this.f30546b;
            if (i10 == 0) {
                C4849c.b(obj);
                PolicyRecordRequest policyRecordRequestCreateRecordRequest = PolicyManager.createRecordRequest(this.f30547c, this.f30548d, this.f30549e, this.f30550f);
                policyRecordRequestCreateRecordRequest.setVerify_type(this.f30551g);
                policyRecordRequestCreateRecordRequest.setServiceName(this.f30552h);
                policyRecordRequestCreateRecordRequest.setValidateCode(this.f30553i);
                if (!kotlin.jvm.internal.p.d(this.f30551g, "0") && (arrayList = this.f30554j) != null && arrayList.size() > 0) {
                    policyRecordRequestCreateRecordRequest.setDeleteInfoList(this.f30554j);
                }
                if (!kotlin.jvm.internal.p.d(this.f30551g, "1") && !kotlin.jvm.internal.p.d(this.f30551g, "3")) {
                    policyRecordRequest2 = policyRecordRequestCreateRecordRequest;
                    PolicySdkLogUtils.INSTANCE.d("uploadRecordToCleanServiceData", "verifyType " + this.f30551g + " | policyRecordRequest.deleteInfoList = " + policyRecordRequest2.getDeleteInfoList());
                    PolicyManager.uploadRecordByCustomRecordRequest(this.f30547c, this.f30555k, this.f30556l, this.f30557m, policyRecordRequest2, this.f30558n);
                    return t.f7040a;
                }
                PolicyManager policyManager = PolicyManager.INSTANCE;
                Context context = this.f30547c;
                a.C0079a<String> c0079aD = com.stepos.policy.sdk.d.d();
                this.f30545a = policyRecordRequestCreateRecordRequest;
                this.f30546b = 1;
                Object dataStoreString = policyManager.getDataStoreString(context, c0079aD, this);
                if (dataStoreString == objG) {
                    return objG;
                }
                policyRecordRequest = policyRecordRequestCreateRecordRequest;
                obj = dataStoreString;
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                policyRecordRequest = (PolicyRecordRequest) this.f30545a;
                C4849c.b(obj);
            }
            String str = (String) obj;
            if (str != null && !TextUtils.isEmpty(str)) {
                ArrayList<DeleteInfoBean> deleteInfoBeanByGson = PolicySdkToolsUtils.INSTANCE.getDeleteInfoBeanByGson(str);
                PolicySdkLogUtils.INSTANCE.d("uploadRecordToCleanServiceData", "commonDeleteInfoList = " + deleteInfoBeanByGson);
                policyRecordRequest.setDeleteInfoList(F.p1(F.S0(policyRecordRequest.getDeleteInfoList(), deleteInfoBeanByGson)));
            }
            policyRecordRequest2 = policyRecordRequest;
            PolicySdkLogUtils.INSTANCE.d("uploadRecordToCleanServiceData", "verifyType " + this.f30551g + " | policyRecordRequest.deleteInfoList = " + policyRecordRequest2.getDeleteInfoList());
            PolicyManager.uploadRecordByCustomRecordRequest(this.f30547c, this.f30555k, this.f30556l, this.f30557m, policyRecordRequest2, this.f30558n);
            return t.f7040a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {1, 8, 0})
    @InterfaceC4112d(c = "com.stepos.policy.sdk.PolicyManager$uploadRecordWithoutSecureService$1", f = "PolicyManager.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$uploadRecordWithoutSecureService$1, reason: invalid class name and case insensitive filesystem */
    public static final class C38651 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f30559a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f30560b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String[] f30561c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f30562d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f30563e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f30564f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f30565g;

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ String f30566h;

        /* renamed from: i, reason: collision with root package name */
        public final /* synthetic */ ArrayList<DeleteInfoBean> f30567i;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ String f30568j;

        /* renamed from: k, reason: collision with root package name */
        public final /* synthetic */ String f30569k;

        /* renamed from: l, reason: collision with root package name */
        public final /* synthetic */ String f30570l;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ InterfaceC5074l<PolicySdkResultBean, t> f30571m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C38651(Context context, String[] strArr, String str, String str2, String str3, String str4, String str5, ArrayList<DeleteInfoBean> arrayList, String str6, String str7, String str8, InterfaceC5074l<? super PolicySdkResultBean, t> interfaceC5074l, InterfaceC4014c<? super C38651> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.f30560b = context;
            this.f30561c = strArr;
            this.f30562d = str;
            this.f30563e = str2;
            this.f30564f = str3;
            this.f30565g = str4;
            this.f30566h = str5;
            this.f30567i = arrayList;
            this.f30568j = str6;
            this.f30569k = str7;
            this.f30570l = str8;
            this.f30571m = interfaceC5074l;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new C38651(this.f30560b, this.f30561c, this.f30562d, this.f30563e, this.f30564f, this.f30565g, this.f30566h, this.f30567i, this.f30568j, this.f30569k, this.f30570l, this.f30571m, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((C38651) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            ArrayList<DeleteInfoBean> arrayList;
            C4063a.g();
            if (this.f30559a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            PolicyRecordRequest policyRecordRequestCreateRecordRequest = PolicyManager.createRecordRequest(this.f30560b, this.f30561c, this.f30562d, this.f30563e);
            policyRecordRequestCreateRecordRequest.setVerify_type(this.f30564f);
            policyRecordRequestCreateRecordRequest.setServiceName(this.f30565g);
            policyRecordRequestCreateRecordRequest.setValidateCode(this.f30566h);
            if (!kotlin.jvm.internal.p.d(this.f30564f, "0") && (arrayList = this.f30567i) != null && arrayList.size() > 0) {
                policyRecordRequestCreateRecordRequest.setDeleteInfoList(this.f30567i);
            }
            PolicySdkLogUtils.INSTANCE.d("uploadRecordToCleanServiceData", "verifyType " + this.f30564f + " | policyRecordRequest.deleteInfoList = " + policyRecordRequestCreateRecordRequest.getDeleteInfoList());
            PolicyManager.uploadRecordByCustomRecordRequest(this.f30560b, this.f30568j, this.f30569k, this.f30570l, policyRecordRequestCreateRecordRequest, this.f30571m);
            return t.f7040a;
        }
    }

    static {
        String channelToBrand = PolicySdkToolsUtils.INSTANCE.getChannelToBrand();
        companyCode = channelToBrand;
        brand = channelToBrand;
        model = "";
        osVersion = "";
        exceptionHandler = new m(J.INSTANCE);
    }

    private PolicyManager() {
    }

    private final boolean assetExists(Context context, String assetName) throws IOException {
        try {
            context.getAssets().open(assetName).close();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1, types: [T, com.stepos.policy.sdk.bean.PolicyRecordRequest] */
    public static final void autoUploadRecord(final Context context, String appId, String appSecret, String versionName, String[] categoryList, String userId, String operationType) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(appId, "appId");
        kotlin.jvm.internal.p.i(appSecret, "appSecret");
        kotlin.jvm.internal.p.i(versionName, "versionName");
        kotlin.jvm.internal.p.i(categoryList, "categoryList");
        kotlin.jvm.internal.p.i(operationType, "operationType");
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.f34820a = createRecordRequest(context, categoryList, userId, operationType);
        if (PolicySdkNetworkUtil.isNetworkAvailable(context)) {
            uploadPolicyOperateRecord(appId, appSecret, versionName, (PolicyRecordRequest) ref$ObjectRef.f34820a, new InterfaceC5074l<PolicySdkResultBean, t>() { // from class: com.stepos.policy.sdk.PolicyManager.autoUploadRecord.1

                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {1, 8, 0})
                @InterfaceC4112d(c = "com.stepos.policy.sdk.PolicyManager$autoUploadRecord$1$1", f = "PolicyManager.kt", l = {1343}, m = "invokeSuspend")
                /* renamed from: com.stepos.policy.sdk.PolicyManager$autoUploadRecord$1$1, reason: invalid class name and collision with other inner class name */
                public static final class C03591 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

                    /* renamed from: a, reason: collision with root package name */
                    public int f30285a;

                    /* renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ PolicySdkResultBean f30286b;

                    /* renamed from: c, reason: collision with root package name */
                    public final /* synthetic */ Ref$ObjectRef<PolicyRecordRequest> f30287c;

                    /* renamed from: d, reason: collision with root package name */
                    public final /* synthetic */ Context f30288d;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public C03591(PolicySdkResultBean policySdkResultBean, Ref$ObjectRef<PolicyRecordRequest> ref$ObjectRef, Context context, InterfaceC4014c<? super C03591> interfaceC4014c) {
                        super(2, interfaceC4014c);
                        this.f30286b = policySdkResultBean;
                        this.f30287c = ref$ObjectRef;
                        this.f30288d = context;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
                        return new C03591(this.f30286b, this.f30287c, this.f30288d, interfaceC4014c);
                    }

                    @Override // p9.p
                    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
                        return ((C03591) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) throws Throwable {
                        String json;
                        boolean z10;
                        Object objG = C4063a.g();
                        int i10 = this.f30285a;
                        if (i10 == 0) {
                            C4849c.b(obj);
                            PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.INSTANCE;
                            companion.d("autoUploadRecord", "policySdkResultBean.code " + this.f30286b.getCode());
                            if (this.f30286b.getCode() == 0) {
                                json = "";
                                z10 = true;
                            } else {
                                json = new Gson().toJson(this.f30287c.f34820a);
                                kotlin.jvm.internal.p.h(json, "gson.toJson(policyRecordRequest)");
                                z10 = false;
                            }
                            companion.d("autoUploadRecord", "isOperateSuccess " + z10);
                            PolicyManager policyManager = PolicyManager.INSTANCE;
                            Context context = this.f30288d;
                            this.f30285a = 1;
                            if (policyManager.savePolicyOperate(context, z10, json, this) == objG) {
                                return objG;
                            }
                        } else {
                            if (i10 != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            C4849c.b(obj);
                        }
                        return t.f7040a;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final void a(PolicySdkResultBean policySdkResultBean) {
                    kotlin.jvm.internal.p.i(policySdkResultBean, "policySdkResultBean");
                    C1060i.d(C1073o0.f6391a, PolicyManager.INSTANCE.getExceptionHandler(), null, new C03591(policySdkResultBean, ref$ObjectRef, context, null), 2, null);
                }

                @Override // p9.InterfaceC5074l
                public /* bridge */ /* synthetic */ t invoke(PolicySdkResultBean policySdkResultBean) {
                    a(policySdkResultBean);
                    return t.f7040a;
                }
            });
        } else {
            C1060i.d(C1073o0.f6391a, exceptionHandler, null, new AnonymousClass2(ref$ObjectRef, context, null), 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x004c -> B:22:0x004f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object awaitSyncLocalFileFinished(e9.InterfaceC4014c<? super Y8.t> r10) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r10 instanceof com.stepos.policy.sdk.PolicyManager.C38371
            if (r0 == 0) goto L13
            r0 = r10
            com.stepos.policy.sdk.PolicyManager$awaitSyncLocalFileFinished$1 r0 = (com.stepos.policy.sdk.PolicyManager.C38371) r0
            int r1 = r0.f30295d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f30295d = r1
            goto L18
        L13:
            com.stepos.policy.sdk.PolicyManager$awaitSyncLocalFileFinished$1 r0 = new com.stepos.policy.sdk.PolicyManager$awaitSyncLocalFileFinished$1
            r0.<init>(r10)
        L18:
            java.lang.Object r9 = r0.f30293b
            java.lang.Object r10 = f9.C4063a.g()
            int r1 = r0.f30295d
            r2 = 200(0xc8, double:9.9E-322)
            r4 = 1
            if (r1 == 0) goto L35
            if (r1 != r4) goto L2d
            long r5 = r0.f30292a
            kotlin.C4849c.b(r9)
            goto L4f
        L2d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L35:
            kotlin.C4849c.b(r9)
            r5 = 0
        L3a:
            boolean r9 = com.stepos.policy.sdk.PolicyManager.syncLocalFileFinished
            if (r9 != 0) goto L51
            r7 = 10000(0x2710, double:4.9407E-320)
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 >= 0) goto L51
            r0.f30292a = r5
            r0.f30295d = r4
            java.lang.Object r9 = Ua.U.a(r2, r0)
            if (r9 != r10) goto L4f
            return r10
        L4f:
            long r5 = r5 + r2
            goto L3a
        L51:
            Y8.t r9 = Y8.t.f7040a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.awaitSyncLocalFileFinished(e9.c):java.lang.Object");
    }

    public static final void checkNewestPolicy(Context context, boolean isAutoRecord, String appId, String appSecret, String language, String category, String versionName, InterfaceC5074l<? super PolicySdkResultBean, t> callBackPolicyResult) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(appId, "appId");
        kotlin.jvm.internal.p.i(appSecret, "appSecret");
        kotlin.jvm.internal.p.i(language, "language");
        kotlin.jvm.internal.p.i(category, "category");
        kotlin.jvm.internal.p.i(versionName, "versionName");
        kotlin.jvm.internal.p.i(callBackPolicyResult, "callBackPolicyResult");
        C1060i.d(C1073o0.f6391a, exceptionHandler, null, new C38381(context, category, language, isAutoRecord, appId, appSecret, versionName, callBackPolicyResult, null), 2, null);
    }

    public static final String copyPolicyFile(Context context, String category, String toPath) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(category, "category");
        kotlin.jvm.internal.p.i(toPath, "toPath");
        PolicySdkFileUtils.Companion companion = PolicySdkFileUtils.INSTANCE;
        PolicyNewestPathResultBean policyNewestPathResultBeanIsNewestPolicyFileIsExists = companion.isNewestPolicyFileIsExists(context, category);
        PolicySdkLogUtils.Companion companion2 = PolicySdkLogUtils.INSTANCE;
        companion2.d("copyPolicyFile", "policyNewestPathResultBean.isExists = " + policyNewestPathResultBeanIsNewestPolicyFileIsExists.getIsExists());
        String strCopyPolicyFile = policyNewestPathResultBeanIsNewestPolicyFileIsExists.getIsExists() ? companion.copyPolicyFile(policyNewestPathResultBeanIsNewestPolicyFileIsExists.getNewestPolicyPath(), toPath) : "";
        companion2.d("copyPolicyFile", "successPath = " + strCopyPolicyFile);
        return strCopyPolicyFile;
    }

    private final q createReGrantDialogBuilder(final Context context, final boolean methodType, boolean secondaryConfirmation, String title, final String privacyPolicyName, final String category, q.h permissionDialogClickListener) {
        q qVar = new q(context);
        qVar.o(privacyPolicyName).i(title).n(permissionDialogClickListener).p(secondaryConfirmation).r(new View.OnClickListener() { // from class: com.stepos.policy.sdk.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PolicyManager.createReGrantDialogBuilder$lambda$8(context, methodType, privacyPolicyName, category, view);
            }
        });
        return qVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createReGrantDialogBuilder$lambda$8(Context context, boolean z10, String privacyPolicyName, String category, View view) {
        kotlin.jvm.internal.p.i(context, "$context");
        kotlin.jvm.internal.p.i(privacyPolicyName, "$privacyPolicyName");
        kotlin.jvm.internal.p.i(category, "$category");
        openPolicyMethod(context, z10, privacyPolicyName, category);
    }

    public static final PolicyRecordRequest createRecordRequest(Context context, String[] categoryList, String userId, String operationType) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(categoryList, "categoryList");
        kotlin.jvm.internal.p.i(operationType, "operationType");
        PolicyRecordRequest policyRecordRequest = new PolicyRecordRequest();
        if (readAndroidIdEnabled) {
            String androidId = Settings.System.getString(context.getContentResolver(), "android_id");
            kotlin.jvm.internal.p.h(androidId, "androidId");
            policyRecordRequest.setBusinessId(androidId);
        }
        policyRecordRequest.setType("phone");
        if (userId != null) {
            policyRecordRequest.setUseId(userId);
        }
        ArrayList arrayList = new ArrayList();
        for (String str : categoryList) {
            PolicyRecordBaseInfo policyRecordBaseInfo = new PolicyRecordBaseInfo(null, null, null, 7, null);
            policyRecordBaseInfo.setVersion(PolicySdkFileUtils.INSTANCE.getPolicyVersion(context, str));
            policyRecordBaseInfo.setCategory(str);
            arrayList.add(policyRecordBaseInfo);
        }
        policyRecordRequest.setBaseInfoList(arrayList);
        policyRecordRequest.setOperation(operationType);
        return policyRecordRequest;
    }

    public static final void encryptCustomDeleteInfoListBySecure(Context context, final ArrayList<CustomDeleteInfoBean> customDeleteInfoList, final InterfaceC5074l<? super ArrayList<DeleteInfoBean>, t> callBackPolicyResult) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(customDeleteInfoList, "customDeleteInfoList");
        kotlin.jvm.internal.p.i(callBackPolicyResult, "callBackPolicyResult");
        final ArrayList arrayList = new ArrayList();
        WithdrawalManager.INSTANCE.encryptCustomDeleteInfoListBySecure(context, customDeleteInfoList, new InterfaceC5074l<DeleteInfoBean, t>() { // from class: com.stepos.policy.sdk.PolicyManager.encryptCustomDeleteInfoListBySecure.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            public final void a(DeleteInfoBean deleteInfoBean) {
                kotlin.jvm.internal.p.i(deleteInfoBean, "deleteInfoBean");
                PolicyManager policyManager = PolicyManager.INSTANCE;
                ArrayList<DeleteInfoBean> arrayList2 = arrayList;
                ArrayList<CustomDeleteInfoBean> arrayList3 = customDeleteInfoList;
                InterfaceC5074l<ArrayList<DeleteInfoBean>, t> interfaceC5074l = callBackPolicyResult;
                arrayList2.add(deleteInfoBean);
                if (arrayList2.size() == arrayList3.size()) {
                    interfaceC5074l.invoke(arrayList2);
                }
            }

            @Override // p9.InterfaceC5074l
            public /* bridge */ /* synthetic */ t invoke(DeleteInfoBean deleteInfoBean) {
                a(deleteInfoBean);
                return t.f7040a;
            }
        });
    }

    public static final ArrayList<DeleteInfoBean> encryptDeleteInfoWithoutSecureService(Context context, ArrayList<DeleteInfoEncryptMultiBean> customDeleteInfoList) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(customDeleteInfoList, "customDeleteInfoList");
        return WithdrawalManagerWithoutSecureService.INSTANCE.getEncryptByDeleteInfoList(context, customDeleteInfoList);
    }

    public static final void encryptMultiDeleteListBySecure(Context context, final ArrayList<DeleteInfoEncryptMultiBean> customDeleteInfoList, final InterfaceC5074l<? super ArrayList<DeleteInfoBean>, t> callBackPolicyResult) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(customDeleteInfoList, "customDeleteInfoList");
        kotlin.jvm.internal.p.i(callBackPolicyResult, "callBackPolicyResult");
        final ArrayList arrayList = new ArrayList();
        WithdrawalManager.INSTANCE.encryptMultiCustomDeleteInfoListBySecure(context, customDeleteInfoList, new InterfaceC5074l<DeleteInfoBean, t>() { // from class: com.stepos.policy.sdk.PolicyManager.encryptMultiDeleteListBySecure.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            public final void a(DeleteInfoBean deleteInfoBean) {
                kotlin.jvm.internal.p.i(deleteInfoBean, "deleteInfoBean");
                PolicyManager policyManager = PolicyManager.INSTANCE;
                ArrayList<DeleteInfoBean> arrayList2 = arrayList;
                ArrayList<DeleteInfoEncryptMultiBean> arrayList3 = customDeleteInfoList;
                InterfaceC5074l<ArrayList<DeleteInfoBean>, t> interfaceC5074l = callBackPolicyResult;
                arrayList2.add(deleteInfoBean);
                if (arrayList2.size() == arrayList3.size()) {
                    interfaceC5074l.invoke(arrayList2);
                }
            }

            @Override // p9.InterfaceC5074l
            public /* bridge */ /* synthetic */ t invoke(DeleteInfoBean deleteInfoBean) {
                a(deleteInfoBean);
                return t.f7040a;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PolicyNewestPathResultBean findNewestPolicyFile(Context context, String category) {
        Context contextResolvePolicyContext = resolvePolicyContext(context);
        PolicySdkFileUtils.Companion companion = PolicySdkFileUtils.INSTANCE;
        PolicyNewestPathResultBean policyNewestPathResultBeanIsNewestPolicyFileIsExists = companion.isNewestPolicyFileIsExists(contextResolvePolicyContext, category);
        if (!policyNewestPathResultBeanIsNewestPolicyFileIsExists.getIsExists()) {
            Context alternateContext = isDeviceProtectedStorageContext(contextResolvePolicyContext) ? context.getApplicationContext() : context.getApplicationContext().createDeviceProtectedStorageContext();
            kotlin.jvm.internal.p.h(alternateContext, "alternateContext");
            PolicyNewestPathResultBean policyNewestPathResultBeanIsNewestPolicyFileIsExists2 = companion.isNewestPolicyFileIsExists(alternateContext, category);
            if (policyNewestPathResultBeanIsNewestPolicyFileIsExists2.getIsExists()) {
                PolicySdkLogUtils.INSTANCE.d("PolicyManager", "findNewestPolicyFile fallback hit: " + policyNewestPathResultBeanIsNewestPolicyFileIsExists2.getNewestPolicyPath());
                return policyNewestPathResultBeanIsNewestPolicyFileIsExists2;
            }
        }
        return policyNewestPathResultBeanIsNewestPolicyFileIsExists;
    }

    public static final void getCommonDeleteInfoList(Context mContext, String businessType, int deleteType) {
        kotlin.jvm.internal.p.i(mContext, "mContext");
        kotlin.jvm.internal.p.i(businessType, "businessType");
        final Context context = (Context) new WeakReference(mContext.getApplicationContext()).get();
        WithdrawalManager.INSTANCE.getCommonDeleteInfoListBySecure(mContext, businessType, deleteType, new InterfaceC5074l<String, t>() { // from class: com.stepos.policy.sdk.PolicyManager.getCommonDeleteInfoList.1

            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {1, 8, 0})
            @InterfaceC4112d(c = "com.stepos.policy.sdk.PolicyManager$getCommonDeleteInfoList$1$1", f = "PolicyManager.kt", l = {2457}, m = "invokeSuspend")
            /* renamed from: com.stepos.policy.sdk.PolicyManager$getCommonDeleteInfoList$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C03601 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

                /* renamed from: a, reason: collision with root package name */
                public int f30361a;

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ String f30362b;

                /* renamed from: c, reason: collision with root package name */
                public final /* synthetic */ Context f30363c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C03601(String str, Context context, InterfaceC4014c<? super C03601> interfaceC4014c) {
                    super(2, interfaceC4014c);
                    this.f30362b = str;
                    this.f30363c = context;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
                    return new C03601(this.f30362b, this.f30363c, interfaceC4014c);
                }

                @Override // p9.p
                public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
                    return ((C03601) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object objG = C4063a.g();
                    int i10 = this.f30361a;
                    if (i10 == 0) {
                        C4849c.b(obj);
                        PolicySdkLogUtils.INSTANCE.d("getCommonDeleteInfoList", "result = " + this.f30362b);
                        Context context = this.f30363c;
                        if (context != null) {
                            PolicyManager policyManager = PolicyManager.INSTANCE;
                            a.C0079a<String> c0079aD = com.stepos.policy.sdk.d.d();
                            String str = this.f30362b;
                            this.f30361a = 1;
                            if (policyManager.saveDataStoreString(context, c0079aD, str, this) == objG) {
                                return objG;
                            }
                        }
                    } else {
                        if (i10 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        C4849c.b(obj);
                    }
                    return t.f7040a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // p9.InterfaceC5074l
            public /* bridge */ /* synthetic */ t invoke(String str) {
                invoke2(str);
                return t.f7040a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String deleteInfoListJson) {
                kotlin.jvm.internal.p.i(deleteInfoListJson, "deleteInfoListJson");
                PolicyManager policyManager = PolicyManager.INSTANCE;
                C1060i.d(policyManager.getLifecycleScope(), policyManager.getExceptionHandler(), null, new C03601(deleteInfoListJson, context, null), 2, null);
            }
        });
    }

    private final String getLocalCategoryMd5(Context context, String category) {
        return (String) C1058h.b(null, new C38431(context, category, null), 1, null);
    }

    public static final void getPolicyByVersion(String appId, String appSecret, String language, Long versionId, String versionName, InterfaceC5074l<? super PolicySdkResultBean, PolicySdkResultBean> callBackPolicyResult) {
        kotlin.jvm.internal.p.i(appId, "appId");
        kotlin.jvm.internal.p.i(appSecret, "appSecret");
        kotlin.jvm.internal.p.i(language, "language");
        kotlin.jvm.internal.p.i(callBackPolicyResult, "callBackPolicyResult");
        C1060i.d(C1073o0.f6391a, exceptionHandler, null, new C38441(versionId, versionName, appId, appSecret, callBackPolicyResult, language, null), 2, null);
    }

    public static final void getPolicyData(String appId, String appSecret, String language, String category, Long version, String versionName, InterfaceC5074l<? super PolicySdkResultBean, t> callBackPolicyResult) {
        kotlin.jvm.internal.p.i(appId, "appId");
        kotlin.jvm.internal.p.i(appSecret, "appSecret");
        kotlin.jvm.internal.p.i(language, "language");
        kotlin.jvm.internal.p.i(callBackPolicyResult, "callBackPolicyResult");
        C1060i.d(C1073o0.f6391a, exceptionHandler, null, new C38451(category, version, versionName, appId, appSecret, callBackPolicyResult, language, null), 2, null);
    }

    public static final void getPolicyHistoryList(String appId, String appSecret, String language, String category, long version, String versionName, InterfaceC5074l<? super PolicySdkResultBean, PolicySdkResultBean> callBackPolicyResult) {
        kotlin.jvm.internal.p.i(appId, "appId");
        kotlin.jvm.internal.p.i(appSecret, "appSecret");
        kotlin.jvm.internal.p.i(language, "language");
        kotlin.jvm.internal.p.i(callBackPolicyResult, "callBackPolicyResult");
        C1060i.d(C1073o0.f6391a, exceptionHandler, null, new C38461(category, versionName, appId, appSecret, callBackPolicyResult, language, version, null), 2, null);
    }

    public static final String getPolicyHistoryUrl(String appId, String category, long version, String language) {
        kotlin.jvm.internal.p.i(appId, "appId");
        kotlin.jvm.internal.p.i(category, "category");
        kotlin.jvm.internal.p.i(language, "language");
        String str = "https://policy-h5.stepaos.com/?appId=" + appId + "&category=" + category + "&version=" + version + "&language=" + language;
        PolicySdkLogUtils.INSTANCE.d("getPolicyHistoryUrl", str);
        return str;
    }

    public static final PolicySdkResultBean getPolicyNewestPath(Context context, String category) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(category, "category");
        PolicySdkResultBean policySdkResultBean = new PolicySdkResultBean();
        PolicyNewestPathResultBean policyNewestPathResultBeanFindNewestPolicyFile = INSTANCE.findNewestPolicyFile(context, category);
        PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.INSTANCE;
        companion.d("getNewestPolicyPath", "getNewestPolicyPath");
        companion.d("getNewestPolicyPath", " policyNewestPathResultBean.isExists " + policyNewestPathResultBeanFindNewestPolicyFile + ".isExists");
        if (!policyNewestPathResultBeanFindNewestPolicyFile.getIsExists()) {
            policySdkResultBean.setCode(-1);
            return policySdkResultBean;
        }
        PolicySdkFileUtils.Companion companion2 = PolicySdkFileUtils.INSTANCE;
        policySdkResultBean.setPolicyNewestPath(companion2.renameFileNameByMd5(policyNewestPathResultBeanFindNewestPolicyFile.getNewestPolicyPath()));
        companion.d("getNewestPolicyPath", " policyNewestPath result= " + policySdkResultBean.getPolicyNewestPath());
        try {
            String name = new File(policySdkResultBean.getPolicyNewestPath()).getName();
            kotlin.jvm.internal.p.h(name, "myFile.name");
            PolicyFileDataResultBean policyDataFromFileName = companion2.getPolicyDataFromFileName(name);
            Long lValueOf = policyDataFromFileName != null ? Long.valueOf(policyDataFromFileName.getVersion()) : null;
            policySdkResultBean.setCode(0);
            if (lValueOf != null) {
                policySdkResultBean.setPolicyNewestVersion(lValueOf.longValue());
            }
            return policySdkResultBean;
        } catch (Exception unused) {
            policySdkResultBean.setCode(-1);
            return policySdkResultBean;
        }
    }

    public static final PolicySdkResultBean getPolicyNewestPathByCustom(Context context, String category) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(category, "category");
        PolicySdkLogUtils.INSTANCE.d("getPolicyNewestPathByCustom", " initSDKByDeviceProtectedStorageContext= " + initSDKByDeviceProtectedStorageContext);
        return getPolicyNewestPath(context, category);
    }

    public static final void getPolicyServiceConfig(Context context, String appId, String appSecret, String language, String versionName, InterfaceC5074l<? super PolicySdkResultBean, PolicySdkResultBean> callBackPolicyResult) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(appId, "appId");
        kotlin.jvm.internal.p.i(appSecret, "appSecret");
        kotlin.jvm.internal.p.i(language, "language");
        kotlin.jvm.internal.p.i(callBackPolicyResult, "callBackPolicyResult");
        C1060i.d(C1073o0.f6391a, exceptionHandler, null, new C38481(versionName, appId, appSecret, callBackPolicyResult, language, context, null), 2, null);
    }

    public static final void getPrivateDeleteInfoList(Context context, String appId, String businessType, int deleteType, final InterfaceC5074l<? super ArrayList<DeleteInfoBean>, t> callBackPolicyResult) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(appId, "appId");
        kotlin.jvm.internal.p.i(businessType, "businessType");
        kotlin.jvm.internal.p.i(callBackPolicyResult, "callBackPolicyResult");
        WithdrawalManager.INSTANCE.getPrivateDeleteInfoListBySecure(context, appId, businessType, deleteType, new InterfaceC5074l<ArrayList<DeleteInfoBean>, t>() { // from class: com.stepos.policy.sdk.PolicyManager.getPrivateDeleteInfoList.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            public final void a(ArrayList<DeleteInfoBean> arrayList) {
                PolicyManager policyManager = PolicyManager.INSTANCE;
                InterfaceC5074l<ArrayList<DeleteInfoBean>, t> interfaceC5074l = callBackPolicyResult;
                PolicySdkLogUtils.INSTANCE.d("getPrivateDeleteInfoList", "result = " + arrayList);
                interfaceC5074l.invoke(arrayList);
            }

            @Override // p9.InterfaceC5074l
            public /* bridge */ /* synthetic */ t invoke(ArrayList<DeleteInfoBean> arrayList) {
                a(arrayList);
                return t.f7040a;
            }
        });
    }

    public static final boolean getReadAndroidIdEnabled() {
        return readAndroidIdEnabled;
    }

    public static /* synthetic */ void getReadAndroidIdEnabled$annotations() {
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0184 A[Catch: Exception -> 0x019b, TryCatch #0 {Exception -> 0x019b, blocks: (B:50:0x016a, B:52:0x0184, B:54:0x018e, B:56:0x0193), top: B:60:0x016a }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0193 A[Catch: Exception -> 0x019b, TRY_LEAVE, TryCatch #0 {Exception -> 0x019b, blocks: (B:50:0x016a, B:52:0x0184, B:54:0x018e, B:56:0x0193), top: B:60:0x016a }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object initPolicyNewestPath(android.content.Context r19, java.lang.String r20, java.lang.String r21, e9.InterfaceC4014c<? super com.stepos.policy.sdk.bean.PolicySdkResultBean> r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 415
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.initPolicyNewestPath(android.content.Context, java.lang.String, java.lang.String, e9.c):java.lang.Object");
    }

    public static final void initSDK(Context context, String appId, String appSecret, String versionName, HashMap<String, String> policyCategoryMap) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(appId, "appId");
        kotlin.jvm.internal.p.i(appSecret, "appSecret");
        kotlin.jvm.internal.p.i(versionName, "versionName");
        kotlin.jvm.internal.p.i(policyCategoryMap, "policyCategoryMap");
        PolicySdkRetrofitCreator.INSTANCE.init(context);
        mAppId = appId;
        mAppSecret = appSecret;
        PolicyAppSecretResolver.INSTANCE.reset(mAppSecret);
        mAppVersionName = versionName;
        PolicySdkToolsUtils.Companion companion = PolicySdkToolsUtils.INSTANCE;
        model = companion.getSystemModel(context);
        osVersion = companion.getSystemVersion(context);
        Context contextResolvePolicyContext = resolvePolicyContext(context);
        localAssetsCategoryPathMap = policyCategoryMap;
        try {
            C1058h.b(null, new C38511(contextResolvePolicyContext, null), 1, null);
        } catch (Exception e10) {
            PolicySdkLogUtils.INSTANCE.e("initSDK", "load agreeStatus/uidMap failed: " + e10);
        }
        PolicySdkLogUtils.Companion companion2 = PolicySdkLogUtils.INSTANCE;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("policyCategoryMap=");
        sb2.append(policyCategoryMap);
        sb2.append(", policyContext=");
        File dataDir = contextResolvePolicyContext.getDataDir();
        sb2.append(dataDir != null ? dataDir.getPath() : null);
        companion2.d("initSDK", sb2.toString());
        C1060i.d(C1073o0.f6391a, exceptionHandler, null, new C38522(contextResolvePolicyContext, policyCategoryMap, null), 2, null);
    }

    private final boolean isDeviceProtectedStorageContext(Context context) {
        String path;
        File dataDir = context.getDataDir();
        return (dataDir == null || (path = dataDir.getPath()) == null || !H.g0(path, "user_de", false, 2, null)) ? false : true;
    }

    public static final boolean isSupportSecureService(Context context, int versionCode) {
        kotlin.jvm.internal.p.i(context, "context");
        return INSTANCE.getSecureServiceVersionCode(context) >= versionCode;
    }

    public static final boolean isSupportSecureService31(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        try {
            int secureServiceVersionCode = INSTANCE.getSecureServiceVersionCode(context);
            PolicySdkLogUtils.INSTANCE.d("PolicyManager", "com.stepos.secureservice versionCode : " + secureServiceVersionCode + ' ');
            return secureServiceVersionCode >= 11000031;
        } catch (Exception e10) {
            PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.INSTANCE;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("exception : ");
            e10.getMessage();
            t tVar = t.f7040a;
            sb2.append(e10);
            companion.e("PolicyManager", sb2.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object loadCloudPolicyUidCategoryMap(android.content.Context r6, e9.InterfaceC4014c<? super Y8.t> r7) throws java.lang.Throwable {
        /*
            r5 = this;
            java.lang.String r0 = "CloudPolicyIndex"
            boolean r1 = r7 instanceof com.stepos.policy.sdk.PolicyManager.C38531
            if (r1 == 0) goto L15
            r1 = r7
            com.stepos.policy.sdk.PolicyManager$loadCloudPolicyUidCategoryMap$1 r1 = (com.stepos.policy.sdk.PolicyManager.C38531) r1
            int r2 = r1.f30480c
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.f30480c = r2
            goto L1a
        L15:
            com.stepos.policy.sdk.PolicyManager$loadCloudPolicyUidCategoryMap$1 r1 = new com.stepos.policy.sdk.PolicyManager$loadCloudPolicyUidCategoryMap$1
            r1.<init>(r7)
        L1a:
            java.lang.Object r5 = r1.f30478a
            java.lang.Object r7 = f9.C4063a.g()
            int r2 = r1.f30480c
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.C4849c.b(r5)
            goto L4c
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            kotlin.C4849c.b(r5)
            J0.d r5 = com.stepos.policy.sdk.d.a(r6)
            Xa.b r5 = r5.getData()
            com.stepos.policy.sdk.PolicyManager$loadCloudPolicyUidCategoryMap$$inlined$map$1 r6 = new com.stepos.policy.sdk.PolicyManager$loadCloudPolicyUidCategoryMap$$inlined$map$1
            r6.<init>()
            r1.f30480c = r3
            java.lang.Object r5 = Xa.d.y(r6, r1)
            if (r5 != r7) goto L4c
            return r7
        L4c:
            java.lang.String r5 = (java.lang.String) r5
            if (r5 == 0) goto Lae
            boolean r6 = La.H.x0(r5)
            if (r6 == 0) goto L57
            goto Lae
        L57:
            com.stepos.policy.sdk.PolicyManager$loadCloudPolicyUidCategoryMap$type$1 r6 = new com.stepos.policy.sdk.PolicyManager$loadCloudPolicyUidCategoryMap$type$1     // Catch: java.lang.Exception -> L70
            r6.<init>()     // Catch: java.lang.Exception -> L70
            java.lang.reflect.Type r6 = r6.getType()     // Catch: java.lang.Exception -> L70
            com.google.gson.Gson r7 = new com.google.gson.Gson     // Catch: java.lang.Exception -> L70
            r7.<init>()     // Catch: java.lang.Exception -> L70
            java.lang.Object r5 = r7.fromJson(r5, r6)     // Catch: java.lang.Exception -> L70
            java.util.Map r5 = (java.util.Map) r5     // Catch: java.lang.Exception -> L70
            if (r5 != 0) goto L72
            Y8.t r5 = Y8.t.f7040a     // Catch: java.lang.Exception -> L70
            return r5
        L70:
            r5 = move-exception
            goto L95
        L72:
            com.stepos.policy.sdk.util.PolicyCloudPolicyIndex.putAll(r5)     // Catch: java.lang.Exception -> L70
            com.stepos.policy.sdk.util.PolicySdkLogUtils$Companion r6 = com.stepos.policy.sdk.util.PolicySdkLogUtils.INSTANCE     // Catch: java.lang.Exception -> L70
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L70
            r7.<init>()     // Catch: java.lang.Exception -> L70
            java.lang.String r1 = "loaded "
            r7.append(r1)     // Catch: java.lang.Exception -> L70
            int r5 = r5.size()     // Catch: java.lang.Exception -> L70
            r7.append(r5)     // Catch: java.lang.Exception -> L70
            java.lang.String r5 = " uid→category from DataStore"
            r7.append(r5)     // Catch: java.lang.Exception -> L70
            java.lang.String r5 = r7.toString()     // Catch: java.lang.Exception -> L70
            r6.d(r0, r5)     // Catch: java.lang.Exception -> L70
            goto Lab
        L95:
            com.stepos.policy.sdk.util.PolicySdkLogUtils$Companion r6 = com.stepos.policy.sdk.util.PolicySdkLogUtils.INSTANCE
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r1 = "load failed: "
            r7.append(r1)
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            r6.e(r0, r5)
        Lab:
            Y8.t r5 = Y8.t.f7040a
            return r5
        Lae:
            Y8.t r5 = Y8.t.f7040a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.loadCloudPolicyUidCategoryMap(android.content.Context, e9.c):java.lang.Object");
    }

    @SuppressLint({"SuspiciousIndentation"})
    public static final PolicySdkResultBean openPolicyDataByBrowser(Context context, String category, String title) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(category, "category");
        kotlin.jvm.internal.p.i(title, "title");
        PolicySdkResultBean policyNewestPathByCustom = getPolicyNewestPathByCustom(context, category);
        PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.INSTANCE;
        companion.d("PolicyManager", "openPolicyDataByBrowser " + policyNewestPathByCustom.getPolicyNewestPath() + '}');
        PolicyCheckLogUtils.Companion companion2 = PolicyCheckLogUtils.INSTANCE;
        companion2.i("openPolicy", ">>> START category=" + category + " method=BROWSER syncDone=" + syncLocalFileFinished);
        if (policyNewestPathByCustom.getCode() == 0) {
            String policyNewestPath = policyNewestPathByCustom.getPolicyNewestPath();
            companion.d("PolicyManager", "openPolicyDataByBrowser policyNewestPath path = " + policyNewestPath + ' ');
            Uri uriForFile = androidx.core.content.b.getUriForFile(context, context.getPackageName() + ".PolicySdk.FileProvider", new File(policyNewestPath));
            if (uriForFile != null) {
                PolicySdkToolsUtils.INSTANCE.startBrowser(context, uriForFile);
            }
            companion2.i("openPolicy", ">>> END category=" + category + " code=SUCCESS 已唤起浏览器 path=" + policyNewestPath);
            return policyNewestPathByCustom;
        }
        companion2.e("openPolicy", ">>> END category=" + category + " code=FAILED 未打开页面(无反应)");
        companion2.e("openPolicy", "原因: 本地无 " + category + " 缓存文件; syncDone=" + syncLocalFileFinished + "; code=" + policyNewestPathByCustom.getCode());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("建议: 1)确认 assets 有对应 ");
        sb2.append(category);
        sb2.append("_x.html 且 initSDK 已 put(\"");
        sb2.append(category);
        sb2.append("\",...); 2)syncDone=false 时查启动自检(selfCheck)是否有 ⚠️ 缺文件导致同步中断; 3)确认打开与登记的 category 完全一致");
        companion2.e("openPolicy", sb2.toString());
        return policyNewestPathByCustom;
    }

    @SuppressLint({"SuspiciousIndentation"})
    public static final PolicySdkResultBean openPolicyDataByWebView(Context context, String category, String title) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(category, "category");
        kotlin.jvm.internal.p.i(title, "title");
        PolicySdkResultBean policyNewestPathByCustom = getPolicyNewestPathByCustom(context, category);
        PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.INSTANCE;
        companion.d("PolicyManager", "openPolicyDataByWebView " + policyNewestPathByCustom.getPolicyNewestPath() + '}');
        PolicyCheckLogUtils.Companion companion2 = PolicyCheckLogUtils.INSTANCE;
        companion2.i("openPolicy", ">>> START category=" + category + " method=IN_APP syncDone=" + syncLocalFileFinished);
        if (policyNewestPathByCustom.getCode() != 0) {
            companion2.e("openPolicy", ">>> END category=" + category + " code=FAILED 未打开页面(无反应)");
            companion2.e("openPolicy", "原因: 本地无 " + category + " 缓存文件; syncDone=" + syncLocalFileFinished + "; code=" + policyNewestPathByCustom.getCode());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("建议: 1)确认 assets 有对应 ");
            sb2.append(category);
            sb2.append("_x.html 且 initSDK 已 put(\"");
            sb2.append(category);
            sb2.append("\",...); 2)syncDone=false 时查启动自检(selfCheck)是否有 ⚠️ 缺文件导致同步中断; 3)确认打开与登记的 category 完全一致");
            companion2.e("openPolicy", sb2.toString());
            return policyNewestPathByCustom;
        }
        String policyNewestPath = policyNewestPathByCustom.getPolicyNewestPath();
        Uri uriForFile = androidx.core.content.b.getUriForFile(context, context.getPackageName() + ".PolicySdk.FileProvider", new File(policyNewestPath));
        companion.d("PolicyManager", "save sucessful path = " + policyNewestPath + ' ');
        String string = uriForFile.toString();
        kotlin.jvm.internal.p.h(string, "contentUri.toString()");
        if (!syncLocalFileFinished && localAssetsCategoryPathMap.containsKey(category) && localAssetsCategoryPathMap.get(category) != null && !kotlin.jvm.internal.p.d("", localAssetsCategoryPathMap.get(category))) {
            string = String.valueOf(localAssetsCategoryPathMap.get(category));
        }
        companion.d("openPolicyDataByWebView", "initSDK syncLocalFileFinished " + syncLocalFileFinished + " |  policyPath = " + string);
        PolicyHtmlViewerActivity.INSTANCE.openPolicy(context, string, title, null);
        companion2.i("openPolicy", ">>> END category=" + category + " code=SUCCESS 已打开页面 path=" + string);
        return policyNewestPathByCustom;
    }

    public static final PolicySdkResultBean openPolicyMethod(Context context, boolean methodType, String title, String category) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(title, "title");
        kotlin.jvm.internal.p.i(category, "category");
        return methodType ? openPolicyDataByWebView(context, category, title) : openPolicyDataByBrowser(context, category, title);
    }

    private final void persistCloudPolicyUidCategoryMap(Context context) {
        C1060i.d(C1073o0.f6391a, exceptionHandler, null, new C38541(context, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reTryUploadRecord(Context context) {
        C1060i.d(C1073o0.f6391a, exceptionHandler, null, new C38551(context, this, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void rememberCloudPolicyUidCategory(android.content.Context r3, java.lang.String r4, java.lang.String r5, java.lang.String r6) {
        /*
            r2 = this;
            if (r5 == 0) goto L36
            boolean r0 = La.H.x0(r5)
            if (r0 == 0) goto L9
            goto L36
        L9:
            r0 = 0
            if (r6 == 0) goto L19
            boolean r1 = La.H.x0(r6)
            if (r1 != 0) goto L13
            goto L14
        L13:
            r6 = r0
        L14:
            if (r6 != 0) goto L17
            goto L19
        L17:
            r0 = r6
            goto L27
        L19:
            if (r4 != 0) goto L1d
            java.lang.String r4 = ""
        L1d:
            com.stepos.policy.sdk.bean.CloudPolicyUrlInfo r4 = com.stepos.policy.sdk.util.PolicyHtmlLinkHandler.parseCloudPolicyUrl(r4)
            if (r4 == 0) goto L27
            java.lang.String r0 = r4.getPolicyUid()
        L27:
            if (r0 == 0) goto L36
            boolean r4 = La.H.x0(r0)
            if (r4 == 0) goto L30
            goto L36
        L30:
            com.stepos.policy.sdk.util.PolicyCloudPolicyIndex.put(r0, r5)
            r2.persistCloudPolicyUidCategoryMap(r3)
        L36:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.rememberCloudPolicyUidCategory(android.content.Context, java.lang.String, java.lang.String, java.lang.String):void");
    }

    public static final Context resolvePolicyContext(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        if (INSTANCE.isDeviceProtectedStorageContext(context)) {
            initSDKByDeviceProtectedStorageContext = true;
            return context;
        }
        if (!initSDKByDeviceProtectedStorageContext) {
            return context;
        }
        Context contextCreateDeviceProtectedStorageContext = context.getApplicationContext().createDeviceProtectedStorageContext();
        kotlin.jvm.internal.p.h(contextCreateDeviceProtectedStorageContext, "{\n            context.ap…torageContext()\n        }");
        return contextCreateDeviceProtectedStorageContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object resolveSignSecret(java.lang.String r5, java.lang.String r6, java.lang.String r7, boolean r8, e9.InterfaceC4014c<? super java.lang.String> r9) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r9 instanceof com.stepos.policy.sdk.PolicyManager.C38561
            if (r0 == 0) goto L13
            r0 = r9
            com.stepos.policy.sdk.PolicyManager$resolveSignSecret$1 r0 = (com.stepos.policy.sdk.PolicyManager.C38561) r0
            int r1 = r0.f30500e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f30500e = r1
            goto L18
        L13:
            com.stepos.policy.sdk.PolicyManager$resolveSignSecret$1 r0 = new com.stepos.policy.sdk.PolicyManager$resolveSignSecret$1
            r0.<init>(r9)
        L18:
            java.lang.Object r4 = r0.f30498c
            java.lang.Object r9 = f9.C4063a.g()
            int r1 = r0.f30500e
            r2 = 1
            if (r1 == 0) goto L38
            if (r1 != r2) goto L30
            boolean r8 = r0.f30497b
            java.lang.Object r5 = r0.f30496a
            r7 = r5
            java.lang.String r7 = (java.lang.String) r7
            kotlin.C4849c.b(r4)
            goto L4a
        L30:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L38:
            kotlin.C4849c.b(r4)
            com.stepos.policy.sdk.util.PolicyAppSecretResolver r4 = com.stepos.policy.sdk.util.PolicyAppSecretResolver.INSTANCE
            r0.f30496a = r7
            r0.f30497b = r8
            r0.f30500e = r2
            java.lang.Object r4 = r4.resolveForSign(r5, r6, r0)
            if (r4 != r9) goto L4a
            return r9
        L4a:
            java.lang.String r4 = (java.lang.String) r4
            int r5 = r4.length()
            if (r5 <= 0) goto L55
            com.stepos.policy.sdk.PolicyManager.mAppSecret = r4
            return r4
        L55:
            boolean r5 = com.stepos.policy.sdk.util.PolicySdkNetworkGate.shouldBlock()
            if (r5 == 0) goto L5e
            java.lang.String r5 = "未同意前禁网且无 initSDK 兜底"
            goto L60
        L5e:
            java.lang.String r5 = "换密钥失败且无 initSDK 兜底"
        L60:
            if (r8 == 0) goto L65
            java.lang.String r6 = "，已返回本地缓存"
            goto L67
        L65:
            java.lang.String r6 = ""
        L67:
            com.stepos.policy.sdk.util.PolicySdkLogUtils$Companion r8 = com.stepos.policy.sdk.util.PolicySdkLogUtils.INSTANCE
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r7)
            java.lang.String r7 = " 未发出: "
            r9.append(r7)
            r9.append(r5)
            r9.append(r6)
            java.lang.String r5 = r9.toString()
            java.lang.String r6 = "AppSecret"
            r8.w(r6, r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.resolveSignSecret(java.lang.String, java.lang.String, java.lang.String, boolean, e9.c):java.lang.Object");
    }

    public static /* synthetic */ Object resolveSignSecret$default(PolicyManager policyManager, String str, String str2, String str3, boolean z10, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            z10 = false;
        }
        return policyManager.resolveSignSecret(str, str2, str3, z10, interfaceC4014c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object saveDataStoreString(Context context, a.C0079a<String> c0079a, String str, InterfaceC4014c<? super t> interfaceC4014c) {
        PolicySdkLogUtils.INSTANCE.d("saveDataStoreString", ' ' + c0079a + " | dataStoreValue =" + str + ' ');
        Object objA = PreferencesKt.a(com.stepos.policy.sdk.d.g(context), new C38582(c0079a, str, null), interfaceC4014c);
        return objA == C4063a.g() ? objA : t.f7040a;
    }

    private final void saveLocalCategoryMd5(Context context, String category, String md5) {
        C1060i.d(C1073o0.f6391a, exceptionHandler, null, new C38591(category, md5, context, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x009c, code lost:
    
        if (androidx.datastore.preferences.core.PreferencesKt.a(r6, r7, r0) == r10) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object savePolicyOperate(android.content.Context r7, boolean r8, java.lang.String r9, e9.InterfaceC4014c<? super Y8.t> r10) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r10 instanceof com.stepos.policy.sdk.PolicyManager.C38601
            if (r0 == 0) goto L13
            r0 = r10
            com.stepos.policy.sdk.PolicyManager$savePolicyOperate$1 r0 = (com.stepos.policy.sdk.PolicyManager.C38601) r0
            int r1 = r0.f30524f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f30524f = r1
            goto L18
        L13:
            com.stepos.policy.sdk.PolicyManager$savePolicyOperate$1 r0 = new com.stepos.policy.sdk.PolicyManager$savePolicyOperate$1
            r0.<init>(r10)
        L18:
            java.lang.Object r6 = r0.f30522d
            java.lang.Object r10 = f9.C4063a.g()
            int r1 = r0.f30524f
            r2 = 2
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L44
            if (r1 == r3) goto L35
            if (r1 != r2) goto L2d
            kotlin.C4849c.b(r6)
            goto L9f
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            boolean r8 = r0.f30521c
            java.lang.Object r7 = r0.f30520b
            r9 = r7
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r7 = r0.f30519a
            android.content.Context r7 = (android.content.Context) r7
            kotlin.C4849c.b(r6)
            goto L7f
        L44:
            kotlin.C4849c.b(r6)
            com.stepos.policy.sdk.util.PolicySdkLogUtils$Companion r6 = com.stepos.policy.sdk.util.PolicySdkLogUtils.INSTANCE
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r5 = "isOperateSuccess ="
            r1.append(r5)
            r1.append(r8)
            java.lang.String r5 = " |operateJson = "
            r1.append(r5)
            r1.append(r9)
            java.lang.String r1 = r1.toString()
            java.lang.String r5 = "savePolicyOperate"
            r6.d(r5, r1)
            J0.d r6 = com.stepos.policy.sdk.d.a(r7)
            com.stepos.policy.sdk.PolicyManager$savePolicyOperate$2 r1 = new com.stepos.policy.sdk.PolicyManager$savePolicyOperate$2
            r1.<init>(r8, r4)
            r0.f30519a = r7
            r0.f30520b = r9
            r0.f30521c = r8
            r0.f30524f = r3
            java.lang.Object r6 = androidx.datastore.preferences.core.PreferencesKt.a(r6, r1, r0)
            if (r6 != r10) goto L7f
            goto L9e
        L7f:
            if (r8 != 0) goto La2
            if (r9 == 0) goto La2
            int r6 = r9.length()
            if (r6 <= 0) goto La2
            J0.d r6 = com.stepos.policy.sdk.d.a(r7)
            com.stepos.policy.sdk.PolicyManager$savePolicyOperate$3 r7 = new com.stepos.policy.sdk.PolicyManager$savePolicyOperate$3
            r7.<init>(r9, r4)
            r0.f30519a = r4
            r0.f30520b = r4
            r0.f30524f = r2
            java.lang.Object r6 = androidx.datastore.preferences.core.PreferencesKt.a(r6, r7, r0)
            if (r6 != r10) goto L9f
        L9e:
            return r10
        L9f:
            Y8.t r6 = Y8.t.f7040a
            return r6
        La2:
            Y8.t r6 = Y8.t.f7040a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.savePolicyOperate(android.content.Context, boolean, java.lang.String, e9.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void selfCheckLocalAssets(Context context, HashMap<String, String> policyCategoryMap) {
        try {
            PolicyCheckLogUtils.INSTANCE.i("selfCheck", ">>> START categories=" + policyCategoryMap.keySet());
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, String> entry : policyCategoryMap.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (value.length() == 0) {
                    arrayList.add(key);
                    PolicyCheckLogUtils.INSTANCE.w("selfCheck", "category=" + key + " ⚠️ localPath 为空");
                } else if (H.g0(value, "file:////android_asset", false, 2, null)) {
                    String strT = D.T(value, "file:////android_asset/", "", false, 4, null);
                    if (assetExists(context, strT)) {
                        PolicyCheckLogUtils.INSTANCE.i("selfCheck", "category=" + key + " asset=" + strT + " present=true");
                    } else {
                        arrayList.add(key);
                        PolicyCheckLogUtils.INSTANCE.w("selfCheck", "category=" + key + " asset=" + strT + " present=FALSE ⚠️ 缺失会中断同步(其后 category 不再同步)且该 category 无法本地打开");
                    }
                } else {
                    arrayList.add(key);
                    PolicyCheckLogUtils.INSTANCE.w("selfCheck", "category=" + key + " ⚠️ localPath 格式错误(需 file:////android_asset/ 四斜杠): " + value);
                }
            }
            if (arrayList.isEmpty()) {
                PolicyCheckLogUtils.INSTANCE.i("selfCheck", ">>> END 自检通过 ok=" + policyCategoryMap.keySet());
                return;
            }
            PolicyCheckLogUtils.INSTANCE.w("selfCheck", ">>> END 自检发现问题 problems=" + arrayList + " 请补齐对应 assets 或从 policyCategoryMap 移除未使用的 category");
        } catch (Exception e10) {
            PolicyCheckLogUtils.INSTANCE.e("selfCheck", "自检异常: " + e10.getMessage());
        }
    }

    public static final void setReadAndroidIdEnabled(boolean z10) {
        readAndroidIdEnabled = z10;
    }

    public static final stepos.support.v7.app.c showCustomPolicyDialog(Context context, boolean secondaryConfirmation, String[] permissionKey, String[] permissionSummary, String title, CharSequence reminder, CharSequence customTerms, PolicyPermissionDialogBuilder.OnPermissionClickListener permissionDialogClickListener) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(title, "title");
        kotlin.jvm.internal.p.i(customTerms, "customTerms");
        kotlin.jvm.internal.p.i(permissionDialogClickListener, "permissionDialogClickListener");
        PolicyPermissionDialogBuilder policyPermissionDialogBuilder = new PolicyPermissionDialogBuilder(context);
        policyPermissionDialogBuilder.setAppName(title).setOnPermissionListener(new a(context, permissionDialogClickListener)).setSecondaryConfirmation(secondaryConfirmation).setCustomTerms(customTerms);
        if (reminder != null && !TextUtils.isEmpty(reminder)) {
            policyPermissionDialogBuilder.setReminder(reminder);
        }
        if (permissionKey != null && permissionSummary != null) {
            policyPermissionDialogBuilder.setPermission(permissionKey, permissionSummary);
        }
        return policyPermissionDialogBuilder.create();
    }

    public static final stepos.support.v7.app.c showCustomPolicyDialogAndUploadRecord(Context context, boolean secondaryConfirmation, String[] permissionKey, String[] permissionSummary, String title, CharSequence reminder, CharSequence customTerms, String appId, String appSecret, String versionName, String[] categoryList, String userId, PolicyPermissionDialogBuilder.OnPermissionClickListener permissionDialogClickListener) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(title, "title");
        kotlin.jvm.internal.p.i(customTerms, "customTerms");
        kotlin.jvm.internal.p.i(appId, "appId");
        kotlin.jvm.internal.p.i(appSecret, "appSecret");
        kotlin.jvm.internal.p.i(versionName, "versionName");
        kotlin.jvm.internal.p.i(categoryList, "categoryList");
        kotlin.jvm.internal.p.i(permissionDialogClickListener, "permissionDialogClickListener");
        PolicyPermissionDialogBuilder policyPermissionDialogBuilder = new PolicyPermissionDialogBuilder(context);
        policyPermissionDialogBuilder.setAppName(title).setOnPermissionListener(new b(context, appId, appSecret, versionName, categoryList, userId, permissionDialogClickListener)).setSecondaryConfirmation(secondaryConfirmation).setCustomTerms(customTerms);
        if (reminder != null && !TextUtils.isEmpty(reminder)) {
            policyPermissionDialogBuilder.setReminder(reminder);
        }
        if (permissionKey != null && permissionSummary != null) {
            policyPermissionDialogBuilder.setPermission(permissionKey, permissionSummary);
        }
        return policyPermissionDialogBuilder.create();
    }

    public static final stepos.support.v7.app.c showCustomPolicyThreeButtonDialogAndUploadRecord(Context context, boolean secondaryConfirmation, String[] permissionKey, String[] permissionSummary, String title, CharSequence reminder, CharSequence customTerms, String appId, String appSecret, String versionName, String[] categoryList, String userId, PolicyPermissionDialogBuilder.OnPermissionClickListener fullAgreeListener, q.h basicListener) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(title, "title");
        kotlin.jvm.internal.p.i(customTerms, "customTerms");
        kotlin.jvm.internal.p.i(appId, "appId");
        kotlin.jvm.internal.p.i(appSecret, "appSecret");
        kotlin.jvm.internal.p.i(versionName, "versionName");
        kotlin.jvm.internal.p.i(categoryList, "categoryList");
        kotlin.jvm.internal.p.i(fullAgreeListener, "fullAgreeListener");
        kotlin.jvm.internal.p.i(basicListener, "basicListener");
        PolicyPermissionDialogBuilder policyPermissionDialogBuilder = new PolicyPermissionDialogBuilder(context);
        policyPermissionDialogBuilder.setDark(PolicyHtmlDisplayAdapter.isDarkMode(context));
        policyPermissionDialogBuilder.setAppName(title).setOnPermissionListener(new c()).setSecondaryConfirmation(secondaryConfirmation).setCustomTerms(customTerms);
        if (reminder != null && !TextUtils.isEmpty(reminder)) {
            policyPermissionDialogBuilder.setReminder(reminder);
        }
        if (permissionKey != null && permissionSummary != null) {
            policyPermissionDialogBuilder.setPermission(permissionKey, permissionSummary);
        }
        return policyPermissionDialogBuilder.createThreeButton(new d(context, appId, appSecret, versionName, categoryList, userId, fullAgreeListener, basicListener));
    }

    public static final q showDialogByCustomThemeViewBuilder(Context context, int theme, String title, CharSequence customTerms, String customNegativeButtonText, String customPositiveButtonText, q.h permissionDialogClickListener) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(title, "title");
        kotlin.jvm.internal.p.i(customTerms, "customTerms");
        kotlin.jvm.internal.p.i(customNegativeButtonText, "customNegativeButtonText");
        kotlin.jvm.internal.p.i(customPositiveButtonText, "customPositiveButtonText");
        kotlin.jvm.internal.p.i(permissionDialogClickListener, "permissionDialogClickListener");
        q qVar = new q(context);
        qVar.i(title).n(permissionDialogClickListener).m(customTerms).k(customNegativeButtonText).l(customPositiveButtonText);
        return qVar;
    }

    public static final stepos.support.v7.app.c showDialogByCustomView(Context context, String title, CharSequence customTerms, String customNegativeButtonText, String customPositiveButtonText, q.h permissionDialogClickListener) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(title, "title");
        kotlin.jvm.internal.p.i(customTerms, "customTerms");
        kotlin.jvm.internal.p.i(customNegativeButtonText, "customNegativeButtonText");
        kotlin.jvm.internal.p.i(customPositiveButtonText, "customPositiveButtonText");
        kotlin.jvm.internal.p.i(permissionDialogClickListener, "permissionDialogClickListener");
        q qVarShowDialogByCustomViewBuilder = showDialogByCustomViewBuilder(context, title, customTerms, customNegativeButtonText, customPositiveButtonText, "2", permissionDialogClickListener);
        if (qVarShowDialogByCustomViewBuilder != null) {
            return qVarShowDialogByCustomViewBuilder.e();
        }
        return null;
    }

    public static final stepos.support.v7.app.c showDialogByCustomViewAndUploadRecord(Context context, String title, CharSequence customTerms, String customNegativeButtonText, String customPositiveButtonText, String appId, String appSecret, String versionName, String[] categoryList, String userId, String operationType, q.h permissionDialogClickListener) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(title, "title");
        kotlin.jvm.internal.p.i(customTerms, "customTerms");
        kotlin.jvm.internal.p.i(customNegativeButtonText, "customNegativeButtonText");
        kotlin.jvm.internal.p.i(customPositiveButtonText, "customPositiveButtonText");
        kotlin.jvm.internal.p.i(appId, "appId");
        kotlin.jvm.internal.p.i(appSecret, "appSecret");
        kotlin.jvm.internal.p.i(versionName, "versionName");
        kotlin.jvm.internal.p.i(categoryList, "categoryList");
        kotlin.jvm.internal.p.i(operationType, "operationType");
        kotlin.jvm.internal.p.i(permissionDialogClickListener, "permissionDialogClickListener");
        q qVarShowDialogUploadRecordBuilder = showDialogUploadRecordBuilder(context, title, customTerms, customNegativeButtonText, customPositiveButtonText, appId, appSecret, versionName, categoryList, userId, operationType, permissionDialogClickListener);
        if (qVarShowDialogUploadRecordBuilder != null) {
            return qVarShowDialogUploadRecordBuilder.e();
        }
        return null;
    }

    public static final q showDialogByCustomViewBuilder(Context context, String title, CharSequence customTerms, String customNegativeButtonText, String customPositiveButtonText, String operationType, q.h permissionDialogClickListener) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(title, "title");
        kotlin.jvm.internal.p.i(customTerms, "customTerms");
        kotlin.jvm.internal.p.i(customNegativeButtonText, "customNegativeButtonText");
        kotlin.jvm.internal.p.i(customPositiveButtonText, "customPositiveButtonText");
        kotlin.jvm.internal.p.i(operationType, "operationType");
        kotlin.jvm.internal.p.i(permissionDialogClickListener, "permissionDialogClickListener");
        q qVar = new q(context);
        qVar.i(title).n(new e(operationType, context, permissionDialogClickListener)).m(customTerms).k(customNegativeButtonText).l(customPositiveButtonText);
        return qVar;
    }

    public static final q showDialogByCustomViewBuilderRecord(Context context, String title, CharSequence customTerms, String customNegativeButtonText, String customPositiveButtonText, String appId, String appSecret, String versionName, String[] categoryList, String userId, q.h permissionDialogClickListener) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(title, "title");
        kotlin.jvm.internal.p.i(customTerms, "customTerms");
        kotlin.jvm.internal.p.i(customNegativeButtonText, "customNegativeButtonText");
        kotlin.jvm.internal.p.i(customPositiveButtonText, "customPositiveButtonText");
        kotlin.jvm.internal.p.i(appId, "appId");
        kotlin.jvm.internal.p.i(appSecret, "appSecret");
        kotlin.jvm.internal.p.i(versionName, "versionName");
        kotlin.jvm.internal.p.i(categoryList, "categoryList");
        kotlin.jvm.internal.p.i(permissionDialogClickListener, "permissionDialogClickListener");
        return new q(context).i(title).n(new f(context, appId, appSecret, versionName, categoryList, userId, permissionDialogClickListener)).m(customTerms).k(customNegativeButtonText).l(customPositiveButtonText);
    }

    public static final q showDialogUploadRecordBuilder(Context context, String title, CharSequence customTerms, String customNegativeButtonText, String customPositiveButtonText, String appId, String appSecret, String versionName, String[] categoryList, String userId, String operationType, q.h permissionDialogClickListener) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(title, "title");
        kotlin.jvm.internal.p.i(customTerms, "customTerms");
        kotlin.jvm.internal.p.i(customNegativeButtonText, "customNegativeButtonText");
        kotlin.jvm.internal.p.i(customPositiveButtonText, "customPositiveButtonText");
        kotlin.jvm.internal.p.i(appId, "appId");
        kotlin.jvm.internal.p.i(appSecret, "appSecret");
        kotlin.jvm.internal.p.i(versionName, "versionName");
        kotlin.jvm.internal.p.i(categoryList, "categoryList");
        kotlin.jvm.internal.p.i(operationType, "operationType");
        kotlin.jvm.internal.p.i(permissionDialogClickListener, "permissionDialogClickListener");
        q qVar = new q(context);
        qVar.i(title).n(new g(operationType, context, appId, appSecret, versionName, categoryList, userId, permissionDialogClickListener)).m(customTerms).k(customNegativeButtonText).l(customPositiveButtonText);
        return qVar;
    }

    public static final stepos.support.v7.app.c showNewestDialogAndUploadRecord(Context context, String dialogTitle, String appId, String appSecret, String versionName, String[] categoryList, String userId, boolean isRecord, CharSequence customTerms, String btnNegative, String btnPositive, q.h permissionDialogClickListener) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(dialogTitle, "dialogTitle");
        kotlin.jvm.internal.p.i(appId, "appId");
        kotlin.jvm.internal.p.i(appSecret, "appSecret");
        kotlin.jvm.internal.p.i(versionName, "versionName");
        kotlin.jvm.internal.p.i(categoryList, "categoryList");
        kotlin.jvm.internal.p.i(customTerms, "customTerms");
        kotlin.jvm.internal.p.i(btnNegative, "btnNegative");
        kotlin.jvm.internal.p.i(btnPositive, "btnPositive");
        kotlin.jvm.internal.p.i(permissionDialogClickListener, "permissionDialogClickListener");
        q qVar = new q(context);
        qVar.i(dialogTitle).n(new h(isRecord, context, appId, appSecret, versionName, categoryList, userId, permissionDialogClickListener)).m(customTerms).k(btnNegative).l(btnPositive);
        return qVar.e();
    }

    public static final stepos.support.v7.app.c showReGrantDialog(Context context, boolean methodType, boolean secondaryConfirmation, String title, String privacyPolicyName, String category, q.h permissionDialogClickListener) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(title, "title");
        kotlin.jvm.internal.p.i(privacyPolicyName, "privacyPolicyName");
        kotlin.jvm.internal.p.i(category, "category");
        kotlin.jvm.internal.p.i(permissionDialogClickListener, "permissionDialogClickListener");
        return INSTANCE.createReGrantDialogBuilder(context, methodType, secondaryConfirmation, title, privacyPolicyName, category, permissionDialogClickListener).e();
    }

    public static final stepos.support.v7.app.c showReGrantDialogAndUploadRecord(Context context, boolean methodType, boolean secondaryConfirmation, String title, String privacyPolicyName, String category, String appId, String appSecret, String versionName, String[] categoryList, String userId, q.h permissionDialogClickListener) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(title, "title");
        kotlin.jvm.internal.p.i(privacyPolicyName, "privacyPolicyName");
        kotlin.jvm.internal.p.i(category, "category");
        kotlin.jvm.internal.p.i(appId, "appId");
        kotlin.jvm.internal.p.i(appSecret, "appSecret");
        kotlin.jvm.internal.p.i(versionName, "versionName");
        kotlin.jvm.internal.p.i(categoryList, "categoryList");
        kotlin.jvm.internal.p.i(permissionDialogClickListener, "permissionDialogClickListener");
        return INSTANCE.createReGrantDialogBuilder(context, methodType, secondaryConfirmation, title, privacyPolicyName, category, new i(context, appId, appSecret, versionName, categoryList, userId, permissionDialogClickListener)).e();
    }

    public static final stepos.support.v7.app.c showReGrantTwoPolicyDialog(final Context context, final boolean methodType, boolean secondaryConfirmation, String title, final String userPrivacyPolicyName, final String userCategory, String privacyPolicyName, String category, q.h permissionDialogClickListener) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(title, "title");
        kotlin.jvm.internal.p.i(userPrivacyPolicyName, "userPrivacyPolicyName");
        kotlin.jvm.internal.p.i(userCategory, "userCategory");
        kotlin.jvm.internal.p.i(privacyPolicyName, "privacyPolicyName");
        kotlin.jvm.internal.p.i(category, "category");
        kotlin.jvm.internal.p.i(permissionDialogClickListener, "permissionDialogClickListener");
        q qVarCreateReGrantDialogBuilder = INSTANCE.createReGrantDialogBuilder(context, methodType, secondaryConfirmation, title, privacyPolicyName, category, permissionDialogClickListener);
        qVarCreateReGrantDialogBuilder.q(userPrivacyPolicyName);
        qVarCreateReGrantDialogBuilder.s(new View.OnClickListener() { // from class: com.stepos.policy.sdk.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PolicyManager.showReGrantTwoPolicyDialog$lambda$7(context, methodType, userPrivacyPolicyName, userCategory, view);
            }
        });
        return qVarCreateReGrantDialogBuilder.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showReGrantTwoPolicyDialog$lambda$7(Context context, boolean z10, String userPrivacyPolicyName, String userCategory, View view) {
        kotlin.jvm.internal.p.i(context, "$context");
        kotlin.jvm.internal.p.i(userPrivacyPolicyName, "$userPrivacyPolicyName");
        kotlin.jvm.internal.p.i(userCategory, "$userCategory");
        openPolicyMethod(context, z10, userPrivacyPolicyName, userCategory);
    }

    public static final stepos.support.v7.app.c showReGrantTwoPolicyDialogAndUploadRecord(final Context context, final boolean methodType, boolean secondaryConfirmation, String title, final String userPrivacyPolicyName, final String userCategory, String privacyPolicyName, String category, String appId, String appSecret, String versionName, String[] categoryList, String userId, q.h permissionDialogClickListener) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(title, "title");
        kotlin.jvm.internal.p.i(userPrivacyPolicyName, "userPrivacyPolicyName");
        kotlin.jvm.internal.p.i(userCategory, "userCategory");
        kotlin.jvm.internal.p.i(privacyPolicyName, "privacyPolicyName");
        kotlin.jvm.internal.p.i(category, "category");
        kotlin.jvm.internal.p.i(appId, "appId");
        kotlin.jvm.internal.p.i(appSecret, "appSecret");
        kotlin.jvm.internal.p.i(versionName, "versionName");
        kotlin.jvm.internal.p.i(categoryList, "categoryList");
        kotlin.jvm.internal.p.i(permissionDialogClickListener, "permissionDialogClickListener");
        q qVarCreateReGrantDialogBuilder = INSTANCE.createReGrantDialogBuilder(context, methodType, secondaryConfirmation, title, privacyPolicyName, category, new j(context, appId, appSecret, versionName, categoryList, userId, permissionDialogClickListener));
        qVarCreateReGrantDialogBuilder.q(userPrivacyPolicyName);
        qVarCreateReGrantDialogBuilder.s(new View.OnClickListener() { // from class: com.stepos.policy.sdk.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PolicyManager.showReGrantTwoPolicyDialogAndUploadRecord$lambda$6(context, methodType, userPrivacyPolicyName, userCategory, view);
            }
        });
        return qVarCreateReGrantDialogBuilder.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showReGrantTwoPolicyDialogAndUploadRecord$lambda$6(Context context, boolean z10, String userPrivacyPolicyName, String userCategory, View view) {
        kotlin.jvm.internal.p.i(context, "$context");
        kotlin.jvm.internal.p.i(userPrivacyPolicyName, "$userPrivacyPolicyName");
        kotlin.jvm.internal.p.i(userCategory, "$userCategory");
        openPolicyMethod(context, z10, userPrivacyPolicyName, userCategory);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [T, stepos.support.v7.app.c] */
    /* JADX WARN: Type inference failed for: r4v8, types: [T, stepos.support.v7.app.c] */
    /* JADX WARN: Type inference failed for: r4v9, types: [T, stepos.support.v7.app.c] */
    public static final stepos.support.v7.app.c showWithdrawalAndCleanServiceDataDialog(Context context, String title, CharSequence customTerms, String customNegativeButtonText, String customPositiveButtonText, String checkButtonMessage, PolicyPermissionDialogBuilder.OnPermissionClickListener permissionDialogClickListener) throws Resources.NotFoundException {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(title, "title");
        kotlin.jvm.internal.p.i(customTerms, "customTerms");
        kotlin.jvm.internal.p.i(customNegativeButtonText, "customNegativeButtonText");
        kotlin.jvm.internal.p.i(customPositiveButtonText, "customPositiveButtonText");
        kotlin.jvm.internal.p.i(checkButtonMessage, "checkButtonMessage");
        kotlin.jvm.internal.p.i(permissionDialogClickListener, "permissionDialogClickListener");
        PolicyPermissionDialogBuilder policyPermissionDialogBuilder = new PolicyPermissionDialogBuilder(context);
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        policyPermissionDialogBuilder.setAppName(title).setOnPermissionListener(new k(ref$ObjectRef, permissionDialogClickListener)).setCustomTerms(customTerms).setShowAlmostDenyBtn(true).setCustomNegativeButtonText(customNegativeButtonText).setCustomPositiveButtonText(customPositiveButtonText).setCancelable(true).setCheckEnableConfirmBtn(true);
        ref$ObjectRef.f34820a = policyPermissionDialogBuilder.create();
        ?? Create = policyPermissionDialogBuilder.create();
        ref$ObjectRef.f34820a = Create;
        ?? InitWithdrawalCleanDataOneCheckBox = PolicySdkToolsUtils.INSTANCE.initWithdrawalCleanDataOneCheckBox(context, Create, checkButtonMessage);
        ref$ObjectRef.f34820a = InitWithdrawalCleanDataOneCheckBox;
        return InitWithdrawalCleanDataOneCheckBox;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [T, stepos.support.v7.app.c] */
    /* JADX WARN: Type inference failed for: r8v1, types: [T, stepos.support.v7.app.c] */
    public static final stepos.support.v7.app.c showWithdrawalAndCleanServiceDataDialogByAccount(Context context, boolean hasLogin, String title, CharSequence customTerms, String customNegativeButtonText, String customPositiveButtonText, String checkButtonMessage, String secondCheckButtonMessage, PolicyPermissionDialogBuilder.OnPermissionClickListener permissionDialogClickListener) throws Resources.NotFoundException {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(title, "title");
        kotlin.jvm.internal.p.i(customTerms, "customTerms");
        kotlin.jvm.internal.p.i(customNegativeButtonText, "customNegativeButtonText");
        kotlin.jvm.internal.p.i(customPositiveButtonText, "customPositiveButtonText");
        kotlin.jvm.internal.p.i(checkButtonMessage, "checkButtonMessage");
        kotlin.jvm.internal.p.i(secondCheckButtonMessage, "secondCheckButtonMessage");
        kotlin.jvm.internal.p.i(permissionDialogClickListener, "permissionDialogClickListener");
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        PolicyPermissionDialogBuilder policyPermissionDialogBuilder = new PolicyPermissionDialogBuilder(context);
        policyPermissionDialogBuilder.setAppName(title).setOnPermissionListener(new l(ref$ObjectRef, permissionDialogClickListener)).setCustomTerms(customTerms).setShowAlmostDenyBtn(true).setCustomNegativeButtonText(customNegativeButtonText).setCustomPositiveButtonText(customPositiveButtonText).setCancelable(true).setCheckEnableConfirmBtn(true);
        ?? Create = policyPermissionDialogBuilder.create();
        ref$ObjectRef.f34820a = Create;
        ?? InitWithdrawalCleanDataTwoCheckBox = PolicySdkToolsUtils.INSTANCE.initWithdrawalCleanDataTwoCheckBox(context, Create, hasLogin, checkButtonMessage, secondCheckButtonMessage);
        ref$ObjectRef.f34820a = InitWithdrawalCleanDataTwoCheckBox;
        return InitWithdrawalCleanDataTwoCheckBox;
    }

    public static final void uploadPolicyOperateRecord(String appId, String appSecret, String versionName, PolicyRecordRequest policyRecordRequest, InterfaceC5074l<? super PolicySdkResultBean, t> callBackPolicyResult) {
        kotlin.jvm.internal.p.i(appId, "appId");
        kotlin.jvm.internal.p.i(appSecret, "appSecret");
        kotlin.jvm.internal.p.i(versionName, "versionName");
        kotlin.jvm.internal.p.i(policyRecordRequest, "policyRecordRequest");
        kotlin.jvm.internal.p.i(callBackPolicyResult, "callBackPolicyResult");
        C1060i.d(C1073o0.f6391a, exceptionHandler, null, new C38621(appId, appSecret, callBackPolicyResult, policyRecordRequest, versionName, null), 2, null);
    }

    public static final void uploadRecordByCustomRecordRequest(Context context, String appId, String appSecret, String versionName, PolicyRecordRequest policyRecordRequest, final InterfaceC5074l<? super PolicySdkResultBean, t> callBackPolicyResult) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(appId, "appId");
        kotlin.jvm.internal.p.i(appSecret, "appSecret");
        kotlin.jvm.internal.p.i(versionName, "versionName");
        kotlin.jvm.internal.p.i(policyRecordRequest, "policyRecordRequest");
        kotlin.jvm.internal.p.i(callBackPolicyResult, "callBackPolicyResult");
        if (PolicySdkNetworkUtil.isNetworkAvailable(context)) {
            uploadPolicyOperateRecord(appId, appSecret, versionName, policyRecordRequest, new InterfaceC5074l<PolicySdkResultBean, t>() { // from class: com.stepos.policy.sdk.PolicyManager.uploadRecordByCustomRecordRequest.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                public final void a(PolicySdkResultBean policySdkResultBean) {
                    kotlin.jvm.internal.p.i(policySdkResultBean, "policySdkResultBean");
                    PolicySdkLogUtils.INSTANCE.d("uploadRecordToCleanServiceData", "policySdkResultBean.code " + policySdkResultBean.getCode());
                    callBackPolicyResult.invoke(policySdkResultBean);
                }

                @Override // p9.InterfaceC5074l
                public /* bridge */ /* synthetic */ t invoke(PolicySdkResultBean policySdkResultBean) {
                    a(policySdkResultBean);
                    return t.f7040a;
                }
            });
        }
    }

    public static final void uploadRecordToCleanServiceData(Context context, String serviceName, String validateCode, String verifyType, ArrayList<DeleteInfoBean> deleteInfoBeanList, String appId, String appSecret, String versionName, String[] categoryList, String userId, String operationType, InterfaceC5074l<? super PolicySdkResultBean, t> callBackPolicyResult) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(serviceName, "serviceName");
        kotlin.jvm.internal.p.i(validateCode, "validateCode");
        kotlin.jvm.internal.p.i(verifyType, "verifyType");
        kotlin.jvm.internal.p.i(appId, "appId");
        kotlin.jvm.internal.p.i(appSecret, "appSecret");
        kotlin.jvm.internal.p.i(versionName, "versionName");
        kotlin.jvm.internal.p.i(categoryList, "categoryList");
        kotlin.jvm.internal.p.i(operationType, "operationType");
        kotlin.jvm.internal.p.i(callBackPolicyResult, "callBackPolicyResult");
        C1060i.d(scope, exceptionHandler, null, new C38641(context, categoryList, userId, operationType, verifyType, serviceName, validateCode, deleteInfoBeanList, appId, appSecret, versionName, callBackPolicyResult, null), 2, null);
    }

    public static final void uploadRecordWithoutSecureService(Context context, String serviceName, String validateCode, String verifyType, ArrayList<DeleteInfoBean> deleteInfoBeanList, String appId, String appSecret, String versionName, String[] categoryList, String userId, String operationType, InterfaceC5074l<? super PolicySdkResultBean, t> callBackPolicyResult) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(serviceName, "serviceName");
        kotlin.jvm.internal.p.i(validateCode, "validateCode");
        kotlin.jvm.internal.p.i(verifyType, "verifyType");
        kotlin.jvm.internal.p.i(appId, "appId");
        kotlin.jvm.internal.p.i(appSecret, "appSecret");
        kotlin.jvm.internal.p.i(versionName, "versionName");
        kotlin.jvm.internal.p.i(categoryList, "categoryList");
        kotlin.jvm.internal.p.i(operationType, "operationType");
        kotlin.jvm.internal.p.i(callBackPolicyResult, "callBackPolicyResult");
        C1060i.d(scope, exceptionHandler, null, new C38651(context, categoryList, userId, operationType, verifyType, serviceName, validateCode, deleteInfoBeanList, appId, appSecret, versionName, callBackPolicyResult, null), 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getAgreeStatus(android.content.Context r5, e9.InterfaceC4014c<? super java.lang.Integer> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.stepos.policy.sdk.PolicyManager.C38411
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.policy.sdk.PolicyManager$getAgreeStatus$1 r0 = (com.stepos.policy.sdk.PolicyManager.C38411) r0
            int r1 = r0.f30359c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f30359c = r1
            goto L18
        L13:
            com.stepos.policy.sdk.PolicyManager$getAgreeStatus$1 r0 = new com.stepos.policy.sdk.PolicyManager$getAgreeStatus$1
            r0.<init>(r6)
        L18:
            java.lang.Object r4 = r0.f30357a
            java.lang.Object r6 = f9.C4063a.g()
            int r1 = r0.f30359c
            r2 = 1
            if (r1 == 0) goto L31
            if (r1 != r2) goto L29
            kotlin.C4849c.b(r4)
            goto L4a
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.C4849c.b(r4)
            J0.d r4 = com.stepos.policy.sdk.d.a(r5)
            Xa.b r4 = r4.getData()
            com.stepos.policy.sdk.PolicyManager$getAgreeStatus$$inlined$map$1 r5 = new com.stepos.policy.sdk.PolicyManager$getAgreeStatus$$inlined$map$1
            r5.<init>()
            r0.f30359c = r2
            java.lang.Object r4 = Xa.d.y(r5, r0)
            if (r4 != r6) goto L4a
            return r6
        L4a:
            java.lang.Integer r4 = (java.lang.Integer) r4
            if (r4 == 0) goto L53
            int r4 = r4.intValue()
            goto L54
        L53:
            r4 = 0
        L54:
            java.lang.Integer r4 = g9.C4109a.f(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.getAgreeStatus(android.content.Context, e9.c):java.lang.Object");
    }

    public final String getBrand() {
        return brand;
    }

    public final String getCompanyCode() {
        return companyCode;
    }

    public final String getCustomPolicyCSSFileName() {
        return customPolicyCSSFileName;
    }

    public final Object getDataStoreString(Context context, final a.C0079a<String> c0079a, InterfaceC4014c<? super String> interfaceC4014c) {
        final Xa.b data = com.stepos.policy.sdk.d.g(context).getData();
        return Xa.d.y(new Xa.b<String>() { // from class: com.stepos.policy.sdk.PolicyManager$getDataStoreString$$inlined$map$1

            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", UxipConstants.f30680s, "LY8/t;", "emit", "(Ljava/lang/Object;Le9/c;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
            /* renamed from: com.stepos.policy.sdk.PolicyManager$getDataStoreString$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements Xa.c {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ Xa.c f30254a;

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ a.C0079a f30255b;

                @InterfaceC4112d(c = "com.stepos.policy.sdk.PolicyManager$getDataStoreString$$inlined$map$1$2", f = "PolicyManager.kt", l = {223}, m = "emit")
                @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                /* renamed from: com.stepos.policy.sdk.PolicyManager$getDataStoreString$$inlined$map$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {

                    /* renamed from: a, reason: collision with root package name */
                    public /* synthetic */ Object f30256a;

                    /* renamed from: b, reason: collision with root package name */
                    public int f30257b;

                    public AnonymousClass1(InterfaceC4014c interfaceC4014c) {
                        super(interfaceC4014c);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f30256a = obj;
                        this.f30257b |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(Xa.c cVar, a.C0079a c0079a) {
                    this.f30254a = cVar;
                    this.f30255b = c0079a;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // Xa.c
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r5, e9.InterfaceC4014c r6) throws java.lang.Throwable {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof com.stepos.policy.sdk.PolicyManager$getDataStoreString$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.stepos.policy.sdk.PolicyManager$getDataStoreString$$inlined$map$1$2$1 r0 = (com.stepos.policy.sdk.PolicyManager$getDataStoreString$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.f30257b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f30257b = r1
                        goto L18
                    L13:
                        com.stepos.policy.sdk.PolicyManager$getDataStoreString$$inlined$map$1$2$1 r0 = new com.stepos.policy.sdk.PolicyManager$getDataStoreString$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.f30256a
                        java.lang.Object r1 = f9.C4063a.g()
                        int r2 = r0.f30257b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.C4849c.b(r6)
                        goto L47
                    L29:
                        java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                        java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                        r4.<init>(r5)
                        throw r4
                    L31:
                        kotlin.C4849c.b(r6)
                        Xa.c r6 = r4.f30254a
                        M0.a r5 = (M0.a) r5
                        M0.a$a r4 = r4.f30255b
                        java.lang.Object r4 = r5.b(r4)
                        r0.f30257b = r3
                        java.lang.Object r4 = r6.emit(r4, r0)
                        if (r4 != r1) goto L47
                        return r1
                    L47:
                        Y8.t r4 = Y8.t.f7040a
                        return r4
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager$getDataStoreString$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, e9.c):java.lang.Object");
                }
            }

            @Override // Xa.b
            public Object collect(Xa.c<? super String> cVar, InterfaceC4014c interfaceC4014c2) {
                Object objCollect = data.collect(new AnonymousClass2(cVar, c0079a), interfaceC4014c2);
                return objCollect == C4063a.g() ? objCollect : t.f7040a;
            }
        }, interfaceC4014c);
    }

    public final J getExceptionHandler() {
        return exceptionHandler;
    }

    public final boolean getInitSDKByDeviceProtectedStorageContext() {
        return initSDKByDeviceProtectedStorageContext;
    }

    public final M getLifecycleScope() {
        return lifecycleScope;
    }

    public final HashMap<String, String> getLocalAssetsCategoryPathMap() {
        return localAssetsCategoryPathMap;
    }

    public final String getMAppId() {
        return mAppId;
    }

    public final String getMAppSecret() {
        return mAppSecret;
    }

    public final String getMAppVersionName() {
        return mAppVersionName;
    }

    public final String getModel() {
        return model;
    }

    public final String getOsVersion() {
        return osVersion;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getPolicyOperate(android.content.Context r5, e9.InterfaceC4014c<? super java.lang.Boolean> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.stepos.policy.sdk.PolicyManager.C38471
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.policy.sdk.PolicyManager$getPolicyOperate$1 r0 = (com.stepos.policy.sdk.PolicyManager.C38471) r0
            int r1 = r0.f30418c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f30418c = r1
            goto L18
        L13:
            com.stepos.policy.sdk.PolicyManager$getPolicyOperate$1 r0 = new com.stepos.policy.sdk.PolicyManager$getPolicyOperate$1
            r0.<init>(r6)
        L18:
            java.lang.Object r4 = r0.f30416a
            java.lang.Object r6 = f9.C4063a.g()
            int r1 = r0.f30418c
            r2 = 1
            if (r1 == 0) goto L31
            if (r1 != r2) goto L29
            kotlin.C4849c.b(r4)
            goto L4a
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.C4849c.b(r4)
            J0.d r4 = com.stepos.policy.sdk.d.a(r5)
            Xa.b r4 = r4.getData()
            com.stepos.policy.sdk.PolicyManager$getPolicyOperate$$inlined$map$1 r5 = new com.stepos.policy.sdk.PolicyManager$getPolicyOperate$$inlined$map$1
            r5.<init>()
            r0.f30418c = r2
            java.lang.Object r4 = Xa.d.y(r5, r0)
            if (r4 != r6) goto L4a
            return r6
        L4a:
            java.lang.Boolean r5 = g9.C4109a.a(r2)
            boolean r4 = kotlin.jvm.internal.p.d(r4, r5)
            java.lang.Boolean r4 = g9.C4109a.a(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.getPolicyOperate(android.content.Context, e9.c):java.lang.Object");
    }

    public final Object getPolicyOperateJson(Context context, InterfaceC4014c<? super String> interfaceC4014c) {
        final Xa.b data = com.stepos.policy.sdk.d.g(context).getData();
        return Xa.d.y(new Xa.b<String>() { // from class: com.stepos.policy.sdk.PolicyManager$getPolicyOperateJson$$inlined$map$1

            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", UxipConstants.f30680s, "LY8/t;", "emit", "(Ljava/lang/Object;Le9/c;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
            /* renamed from: com.stepos.policy.sdk.PolicyManager$getPolicyOperateJson$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements Xa.c {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ Xa.c f30272a;

                @InterfaceC4112d(c = "com.stepos.policy.sdk.PolicyManager$getPolicyOperateJson$$inlined$map$1$2", f = "PolicyManager.kt", l = {223}, m = "emit")
                @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                /* renamed from: com.stepos.policy.sdk.PolicyManager$getPolicyOperateJson$$inlined$map$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {

                    /* renamed from: a, reason: collision with root package name */
                    public /* synthetic */ Object f30273a;

                    /* renamed from: b, reason: collision with root package name */
                    public int f30274b;

                    public AnonymousClass1(InterfaceC4014c interfaceC4014c) {
                        super(interfaceC4014c);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f30273a = obj;
                        this.f30274b |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(Xa.c cVar) {
                    this.f30272a = cVar;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // Xa.c
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r5, e9.InterfaceC4014c r6) throws java.lang.Throwable {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof com.stepos.policy.sdk.PolicyManager$getPolicyOperateJson$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.stepos.policy.sdk.PolicyManager$getPolicyOperateJson$$inlined$map$1$2$1 r0 = (com.stepos.policy.sdk.PolicyManager$getPolicyOperateJson$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.f30274b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f30274b = r1
                        goto L18
                    L13:
                        com.stepos.policy.sdk.PolicyManager$getPolicyOperateJson$$inlined$map$1$2$1 r0 = new com.stepos.policy.sdk.PolicyManager$getPolicyOperateJson$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.f30273a
                        java.lang.Object r1 = f9.C4063a.g()
                        int r2 = r0.f30274b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.C4849c.b(r6)
                        goto L49
                    L29:
                        java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                        java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                        r4.<init>(r5)
                        throw r4
                    L31:
                        kotlin.C4849c.b(r6)
                        Xa.c r4 = r4.f30272a
                        M0.a r5 = (M0.a) r5
                        M0.a$a r6 = com.stepos.policy.sdk.d.f()
                        java.lang.Object r5 = r5.b(r6)
                        r0.f30274b = r3
                        java.lang.Object r4 = r4.emit(r5, r0)
                        if (r4 != r1) goto L49
                        return r1
                    L49:
                        Y8.t r4 = Y8.t.f7040a
                        return r4
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager$getPolicyOperateJson$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, e9.c):java.lang.Object");
                }
            }

            @Override // Xa.b
            public Object collect(Xa.c<? super String> cVar, InterfaceC4014c interfaceC4014c2) {
                Object objCollect = data.collect(new AnonymousClass2(cVar), interfaceC4014c2);
                return objCollect == C4063a.g() ? objCollect : t.f7040a;
            }
        }, interfaceC4014c);
    }

    public final M getScope() {
        return scope;
    }

    public final int getSecureServiceVersionCode(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        int i10 = context.getApplicationContext().getPackageManager().getPackageInfo("com.stepos.secureservice", 128).versionCode;
        PolicySdkLogUtils.INSTANCE.d("PolicyManager", "com.stepos.secureservice versionCode : " + i10 + ' ');
        return i10;
    }

    public final boolean getSyncLocalFileFinished() {
        return syncLocalFileFinished;
    }

    public final void saveAgreeStatus(Context context, int status) {
        kotlin.jvm.internal.p.i(context, "context");
        PolicySdkNetworkGate.updateAgreeStatusCache(status);
        C1060i.d(C1073o0.f6391a, exceptionHandler, null, new C38571(context, status, null), 2, null);
    }

    public final void setBrand(String str) {
        kotlin.jvm.internal.p.i(str, "<set-?>");
        brand = str;
    }

    public final void setCompanyCode(String str) {
        kotlin.jvm.internal.p.i(str, "<set-?>");
        companyCode = str;
    }

    public final void setCustomPolicyCSSFileName(String str) {
        kotlin.jvm.internal.p.i(str, "<set-?>");
        customPolicyCSSFileName = str;
    }

    public final void setInitSDKByDeviceProtectedStorageContext(boolean z10) {
        initSDKByDeviceProtectedStorageContext = z10;
    }

    public final void setLocalAssetsCategoryPathMap(HashMap<String, String> map) {
        kotlin.jvm.internal.p.i(map, "<set-?>");
        localAssetsCategoryPathMap = map;
    }

    public final void setMAppId(String str) {
        kotlin.jvm.internal.p.i(str, "<set-?>");
        mAppId = str;
    }

    public final void setMAppSecret(String str) {
        kotlin.jvm.internal.p.i(str, "<set-?>");
        mAppSecret = str;
    }

    public final void setMAppVersionName(String str) {
        kotlin.jvm.internal.p.i(str, "<set-?>");
        mAppVersionName = str;
    }

    public final void setModel(String str) {
        kotlin.jvm.internal.p.i(str, "<set-?>");
        model = str;
    }

    public final void setOsVersion(String str) {
        kotlin.jvm.internal.p.i(str, "<set-?>");
        osVersion = str;
    }

    public final void setSyncLocalFileFinished(boolean z10) {
        syncLocalFileFinished = z10;
    }
}
