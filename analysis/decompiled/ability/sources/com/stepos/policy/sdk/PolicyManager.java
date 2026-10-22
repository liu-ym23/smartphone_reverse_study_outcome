package com.stepos.policy.sdk;

import C7.r;
import D7.v;
import F9.M;
import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.core.content.FileProvider;
import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKeys;
import androidx.datastore.preferences.core.PreferencesKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.stepos.ability.mcpserver.model.McpErrorCode;
import com.stepos.aiengine.args.QueryAlgorithmBundle;
import com.stepos.aiengine.update.AlgorithmUpdateBundle;
import com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity;
import com.stepos.policy.sdk.bean.CustomDeleteInfoBean;
import com.stepos.policy.sdk.bean.DeleteInfoBean;
import com.stepos.policy.sdk.bean.DeleteInfoEncryptMultiBean;
import com.stepos.policy.sdk.bean.PolicyData;
import com.stepos.policy.sdk.bean.PolicyFileDataResultBean;
import com.stepos.policy.sdk.bean.PolicyHistoryListResponse;
import com.stepos.policy.sdk.bean.PolicyNewestPathResultBean;
import com.stepos.policy.sdk.bean.PolicyRecordBaseInfo;
import com.stepos.policy.sdk.bean.PolicyRecordRequest;
import com.stepos.policy.sdk.bean.PolicySdkResultBean;
import com.stepos.policy.sdk.bean.PolicyServiceConfigBean;
import com.stepos.policy.sdk.bean.PolicyServiceConfigResponse;
import com.stepos.policy.sdk.bean.PolicyVersionResponse;
import com.stepos.policy.sdk.config.PolicySdkErrorCode;
import com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder;
import com.stepos.policy.sdk.manager.WithdrawalManager;
import com.stepos.policy.sdk.manager.WithdrawalManagerWithoutSecureService;
import com.stepos.policy.sdk.net.PolicySdkRetrofitCreator;
import com.stepos.policy.sdk.util.PolicyCheckLogUtils;
import com.stepos.policy.sdk.util.PolicyCloudPolicyIndex;
import com.stepos.policy.sdk.util.PolicyHtmlDisplayAdapter;
import com.stepos.policy.sdk.util.PolicySdkFileUtils;
import com.stepos.policy.sdk.util.PolicySdkLogUtils;
import com.stepos.policy.sdk.util.PolicySdkNetworkGate;
import com.stepos.policy.sdk.util.PolicySdkNetworkUtil;
import com.stepos.policy.sdk.util.PolicySdkStringUtils;
import com.stepos.policy.sdk.util.PolicySdkToolsUtils;
import com.stepos.policy.sdk.util.ReadClipboardUtils;
import j9.t;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.C1704W;
import m9.C1730w;
import m9.InterfaceC1731x;
import m9.InterfaceC1733z;
import m9.r0;
import qa.L;
import s9.C1923c;
import stepos.support.v7.app.DialogInterfaceC1961j;
import stepos.support.v7.app.P;
import stepos.support.v7.app.S;

@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b3\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\bJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\bJ+\u0010\u0017\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0015H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0019\u0010\u0010J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u000bH\u0082@ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010\"\u001a\u00020!2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0006H\u0002¢\u0006\u0004\b\"\u0010#J;\u0010'\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\"\u0010&\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060$j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`%H\u0002¢\u0006\u0004\b'\u0010(J\u001f\u0010*\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u0006H\u0002¢\u0006\u0004\b*\u0010+JS\u0010/\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u00062\"\u0010&\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060$j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`%H\u0007¢\u0006\u0004\b/\u00100J-\u00103\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u00101\u001a\u00020\t2\b\u00102\u001a\u0004\u0018\u00010\u0006H\u0082@ø\u0001\u0000¢\u0006\u0004\b3\u00104J\u001b\u00105\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0082@ø\u0001\u0000¢\u0006\u0004\b5\u0010\bJ\u0017\u00106\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b6\u0010\rJ5\u00109\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u00107\u001a\u0004\u0018\u00010\u00062\b\u0010 \u001a\u0004\u0018\u00010\u00062\b\u00108\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b9\u0010:J'\u0010<\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00062\u0006\u0010;\u001a\u00020\u0006H\u0007¢\u0006\u0004\b<\u0010=JC\u0010C\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u00062\u0006\u0010?\u001a\u00020>2\u0012\u0010B\u001a\u000e\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020\u000b0@H\u0007¢\u0006\u0004\bC\u0010DJ\u0089\u0001\u0010Q\u001a\u0004\u0018\u00010P2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010E\u001a\u00020\t2\u0006\u0010F\u001a\u00020\t2\u0006\u0010G\u001a\u00020\u00062\u0006\u0010H\u001a\u00020\u00062\u0006\u0010I\u001a\u00020\u00062\u0006\u0010J\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u00062\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00060K2\b\u0010M\u001a\u0004\u0018\u00010\u00062\u0006\u0010O\u001a\u00020NH\u0007¢\u0006\u0004\bQ\u0010RJY\u0010S\u001a\u0004\u0018\u00010P2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010E\u001a\u00020\t2\u0006\u0010F\u001a\u00020\t2\u0006\u0010G\u001a\u00020\u00062\u0006\u0010H\u001a\u00020\u00062\u0006\u0010I\u001a\u00020\u00062\u0006\u0010J\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00062\u0006\u0010O\u001a\u00020NH\u0007¢\u0006\u0004\bS\u0010TJG\u0010V\u001a\u00020U2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010E\u001a\u00020\t2\u0006\u0010F\u001a\u00020\t2\u0006\u0010G\u001a\u00020\u00062\u0006\u0010J\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00062\u0006\u0010O\u001a\u00020NH\u0002¢\u0006\u0004\bV\u0010WJy\u0010X\u001a\u0004\u0018\u00010P2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010E\u001a\u00020\t2\u0006\u0010F\u001a\u00020\t2\u0006\u0010G\u001a\u00020\u00062\u0006\u0010J\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u00062\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00060K2\b\u0010M\u001a\u0004\u0018\u00010\u00062\u0006\u0010O\u001a\u00020NH\u0007¢\u0006\u0004\bX\u0010YJI\u0010Z\u001a\u0004\u0018\u00010P2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010E\u001a\u00020\t2\u0006\u0010F\u001a\u00020\t2\u0006\u0010G\u001a\u00020\u00062\u0006\u0010J\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00062\u0006\u0010O\u001a\u00020NH\u0007¢\u0006\u0004\bZ\u0010[Jy\u0010b\u001a\u0004\u0018\u00010P2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\\\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u00062\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00060K2\b\u0010M\u001a\u0004\u0018\u00010\u00062\u0006\u0010]\u001a\u00020\t2\u0006\u0010_\u001a\u00020^2\u0006\u0010`\u001a\u00020\u00062\u0006\u0010a\u001a\u00020\u00062\u0006\u0010O\u001a\u00020NH\u0007¢\u0006\u0004\bb\u0010cJy\u0010g\u001a\u0004\u0018\u00010U2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010G\u001a\u00020\u00062\u0006\u0010_\u001a\u00020^2\u0006\u0010d\u001a\u00020\u00062\u0006\u0010e\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u00062\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00060K2\b\u0010M\u001a\u0004\u0018\u00010\u00062\u0006\u0010f\u001a\u00020\u00062\u0006\u0010O\u001a\u00020NH\u0007¢\u0006\u0004\bg\u0010hJI\u0010k\u001a\u0004\u0018\u00010P2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010G\u001a\u00020\u00062\u0006\u0010_\u001a\u00020^2\u0006\u0010d\u001a\u00020\u00062\u0006\u0010e\u001a\u00020\u00062\u0006\u0010i\u001a\u00020\u00062\u0006\u0010O\u001a\u00020jH\u0007¢\u0006\u0004\bk\u0010lJY\u0010o\u001a\u0004\u0018\u00010P2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010m\u001a\u00020\t2\u0006\u0010G\u001a\u00020\u00062\u0006\u0010_\u001a\u00020^2\u0006\u0010d\u001a\u00020\u00062\u0006\u0010e\u001a\u00020\u00062\u0006\u0010i\u001a\u00020\u00062\u0006\u0010n\u001a\u00020\u00062\u0006\u0010O\u001a\u00020jH\u0007¢\u0006\u0004\bo\u0010pJy\u0010q\u001a\u0004\u0018\u00010P2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010G\u001a\u00020\u00062\u0006\u0010_\u001a\u00020^2\u0006\u0010d\u001a\u00020\u00062\u0006\u0010e\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u00062\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00060K2\b\u0010M\u001a\u0004\u0018\u00010\u00062\u0006\u0010f\u001a\u00020\u00062\u0006\u0010O\u001a\u00020NH\u0007¢\u0006\u0004\bq\u0010rJA\u0010s\u001a\u0004\u0018\u00010P2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010G\u001a\u00020\u00062\u0006\u0010_\u001a\u00020^2\u0006\u0010d\u001a\u00020\u00062\u0006\u0010e\u001a\u00020\u00062\u0006\u0010O\u001a\u00020NH\u0007¢\u0006\u0004\bs\u0010tJI\u0010u\u001a\u0004\u0018\u00010U2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010G\u001a\u00020\u00062\u0006\u0010_\u001a\u00020^2\u0006\u0010d\u001a\u00020\u00062\u0006\u0010e\u001a\u00020\u00062\u0006\u0010f\u001a\u00020\u00062\u0006\u0010O\u001a\u00020NH\u0007¢\u0006\u0004\bu\u0010vJI\u0010x\u001a\u0004\u0018\u00010U2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010w\u001a\u00020\u000e2\u0006\u0010G\u001a\u00020\u00062\u0006\u0010_\u001a\u00020^2\u0006\u0010d\u001a\u00020\u00062\u0006\u0010e\u001a\u00020\u00062\u0006\u0010O\u001a\u00020NH\u0007¢\u0006\u0004\bx\u0010yJq\u0010z\u001a\u0004\u0018\u00010U2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010G\u001a\u00020\u00062\u0006\u0010_\u001a\u00020^2\u0006\u0010d\u001a\u00020\u00062\u0006\u0010e\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u00062\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00060K2\b\u0010M\u001a\u0004\u0018\u00010\u00062\u0006\u0010O\u001a\u00020NH\u0007¢\u0006\u0004\bz\u0010{J7\u0010|\u001a\u00020>2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00060K2\b\u0010M\u001a\u0004\u0018\u00010\u00062\u0006\u0010f\u001a\u00020\u0006H\u0007¢\u0006\u0004\b|\u0010}J\u0017\u0010~\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b~\u0010\rJ¡\u0001\u0010\u0086\u0001\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u007f\u001a\u00020\u00062\u0007\u0010\u0080\u0001\u001a\u00020\u00062\u0007\u0010\u0081\u0001\u001a\u00020\u00062\u001f\u0010\u0085\u0001\u001a\u001a\u0012\u0005\u0012\u00030\u0083\u0001\u0018\u00010\u0082\u0001j\f\u0012\u0005\u0012\u00030\u0083\u0001\u0018\u0001`\u0084\u00012\u0006\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u00062\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00060K2\b\u0010M\u001a\u0004\u0018\u00010\u00062\u0006\u0010f\u001a\u00020\u00062\u0012\u0010B\u001a\u000e\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020\u000b0@H\u0007¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001JN\u0010\u0088\u0001\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u00062\u0006\u0010?\u001a\u00020>2\u0012\u0010B\u001a\u000e\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020\u000b0@H\u0007¢\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001J¡\u0001\u0010\u008a\u0001\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u007f\u001a\u00020\u00062\u0007\u0010\u0080\u0001\u001a\u00020\u00062\u0007\u0010\u0081\u0001\u001a\u00020\u00062\u001f\u0010\u0085\u0001\u001a\u001a\u0012\u0005\u0012\u00030\u0083\u0001\u0018\u00010\u0082\u0001j\f\u0012\u0005\u0012\u00030\u0083\u0001\u0018\u0001`\u0084\u00012\u0006\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u00062\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00060K2\b\u0010M\u001a\u0004\u0018\u00010\u00062\u0006\u0010f\u001a\u00020\u00062\u0012\u0010B\u001a\u000e\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020\u000b0@H\u0007¢\u0006\u0006\b\u008a\u0001\u0010\u0087\u0001JR\u0010\u008b\u0001\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u00062\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00060K2\b\u0010M\u001a\u0004\u0018\u00010\u00062\u0006\u0010f\u001a\u00020\u0006H\u0007¢\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001J\u0099\u0001\u0010\u0090\u0001\u001a\u0004\u0018\u00010P2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\t2\u000f\u0010\u008d\u0001\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010K2\u000f\u0010\u008e\u0001\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010K2\u0006\u0010G\u001a\u00020\u00062\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010^2\u0006\u0010_\u001a\u00020^2\u0006\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u00062\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00060K2\b\u0010M\u001a\u0004\u0018\u00010\u00062\u0006\u0010O\u001a\u00020jH\u0007¢\u0006\u0006\b\u0090\u0001\u0010\u0091\u0001J£\u0001\u0010\u0094\u0001\u001a\u0004\u0018\u00010P2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\t2\u000f\u0010\u008d\u0001\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010K2\u000f\u0010\u008e\u0001\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010K2\u0006\u0010G\u001a\u00020\u00062\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010^2\u0006\u0010_\u001a\u00020^2\u0006\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u00062\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00060K2\b\u0010M\u001a\u0004\u0018\u00010\u00062\u0007\u0010\u0092\u0001\u001a\u00020j2\u0007\u0010\u0093\u0001\u001a\u00020NH\u0007¢\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001Ji\u0010\u0096\u0001\u001a\u0004\u0018\u00010P2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\t2\u000f\u0010\u008d\u0001\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010K2\u000f\u0010\u008e\u0001\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010K2\u0006\u0010G\u001a\u00020\u00062\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010^2\u0006\u0010_\u001a\u00020^2\u0006\u0010O\u001a\u00020jH\u0007¢\u0006\u0006\b\u0096\u0001\u0010\u0097\u0001J`\u0010\u009a\u0001\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0007\u0010\u0098\u0001\u001a\u00020\t2\u0006\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0007\u0010\u0099\u0001\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u00062\u0012\u0010B\u001a\u000e\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020\u000b0@H\u0007¢\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001J\"\u0010\u009c\u0001\u001a\u00020A2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0006H\u0007¢\u0006\u0006\b\u009c\u0001\u0010\u009d\u0001J\"\u0010\u009e\u0001\u001a\u00020A2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0006H\u0007¢\u0006\u0006\b\u009e\u0001\u0010\u009d\u0001J1\u0010 \u0001\u001a\u00020A2\u0006\u0010\u0005\u001a\u00020\u00042\t\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u00062\u0006\u0010 \u001a\u00020\u0006H\u0087@ø\u0001\u0000¢\u0006\u0006\b \u0001\u0010¡\u0001J*\u0010¢\u0001\u001a\u00020A2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00062\u0006\u0010G\u001a\u00020\u0006H\u0007¢\u0006\u0006\b¢\u0001\u0010£\u0001J2\u0010¤\u0001\u001a\u00020A2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010E\u001a\u00020\t2\u0006\u0010G\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0006H\u0007¢\u0006\u0006\b¤\u0001\u0010¥\u0001J*\u0010¦\u0001\u001a\u00020A2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00062\u0006\u0010G\u001a\u00020\u0006H\u0007¢\u0006\u0006\b¦\u0001\u0010£\u0001J_\u0010©\u0001\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0007\u0010\u0099\u0001\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010\u00062\n\u0010¨\u0001\u001a\u0005\u0018\u00010§\u00012\b\u0010.\u001a\u0004\u0018\u00010\u00062\u0012\u0010B\u001a\u000e\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020\u000b0@H\u0007¢\u0006\u0006\b©\u0001\u0010ª\u0001J]\u0010«\u0001\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0007\u0010\u0099\u0001\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010\u00062\b\u0010¨\u0001\u001a\u00030§\u00012\b\u0010.\u001a\u0004\u0018\u00010\u00062\u0012\u0010B\u001a\u000e\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020A0@H\u0007¢\u0006\u0006\b«\u0001\u0010¬\u0001JU\u0010®\u0001\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0007\u0010\u0099\u0001\u001a\u00020\u00062\n\u0010\u00ad\u0001\u001a\u0005\u0018\u00010§\u00012\b\u0010.\u001a\u0004\u0018\u00010\u00062\u0012\u0010B\u001a\u000e\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020A0@H\u0007¢\u0006\u0006\b®\u0001\u0010¯\u0001J5\u0010°\u0001\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00062\b\u0010¨\u0001\u001a\u00030§\u00012\u0007\u0010\u0099\u0001\u001a\u00020\u0006H\u0007¢\u0006\u0006\b°\u0001\u0010±\u0001J7\u0010³\u0001\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u00152\t\u0010²\u0001\u001a\u0004\u0018\u00010\u0006H\u0082@ø\u0001\u0000¢\u0006\u0006\b³\u0001\u0010´\u0001J-\u0010¸\u0001\u001a\u00020\u000b2\u0007\u0010µ\u0001\u001a\u00020\u00042\u0007\u0010¶\u0001\u001a\u00020\u00062\u0007\u0010·\u0001\u001a\u00020\u000eH\u0007¢\u0006\u0006\b¸\u0001\u0010¹\u0001J`\u0010º\u0001\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u00062\u0007\u0010¶\u0001\u001a\u00020\u00062\u0007\u0010·\u0001\u001a\u00020\u000e2*\u0010B\u001a&\u0012\u001c\u0012\u001a\u0012\u0005\u0012\u00030\u0083\u0001\u0018\u00010\u0082\u0001j\f\u0012\u0005\u0012\u00030\u0083\u0001\u0018\u0001`\u0084\u0001\u0012\u0004\u0012\u00020\u000b0@H\u0007¢\u0006\u0006\bº\u0001\u0010»\u0001J_\u0010¾\u0001\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u001b\u0010½\u0001\u001a\u0016\u0012\u0005\u0012\u00030¼\u00010\u0082\u0001j\n\u0012\u0005\u0012\u00030¼\u0001`\u0084\u00012&\u0010B\u001a\"\u0012\u0018\u0012\u0016\u0012\u0005\u0012\u00030\u0083\u00010\u0082\u0001j\n\u0012\u0005\u0012\u00030\u0083\u0001`\u0084\u0001\u0012\u0004\u0012\u00020\u000b0@H\u0007¢\u0006\u0006\b¾\u0001\u0010¿\u0001J_\u0010Á\u0001\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u001b\u0010½\u0001\u001a\u0016\u0012\u0005\u0012\u00030À\u00010\u0082\u0001j\n\u0012\u0005\u0012\u00030À\u0001`\u0084\u00012&\u0010B\u001a\"\u0012\u0018\u0012\u0016\u0012\u0005\u0012\u00030\u0083\u00010\u0082\u0001j\n\u0012\u0005\u0012\u00030\u0083\u0001`\u0084\u0001\u0012\u0004\u0012\u00020\u000b0@H\u0007¢\u0006\u0006\bÁ\u0001\u0010¿\u0001J\u0019\u0010Â\u0001\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0005\bÂ\u0001\u0010\u001dJ#\u0010Ä\u0001\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0007\u0010Ã\u0001\u001a\u00020\u000eH\u0007¢\u0006\u0006\bÄ\u0001\u0010Å\u0001J-\u0010Ç\u0001\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00062\t\u0010Æ\u0001\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0006\bÇ\u0001\u0010È\u0001J\"\u0010É\u0001\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0006H\u0002¢\u0006\u0006\bÉ\u0001\u0010Ê\u0001JQ\u0010Ë\u0001\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0007\u0010\u0099\u0001\u001a\u00020\u00062\b\u0010.\u001a\u0004\u0018\u00010\u00062\u0012\u0010B\u001a\u000e\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020A0@H\u0007¢\u0006\u0006\bË\u0001\u0010Ì\u0001JK\u0010Í\u0001\u001a\u0016\u0012\u0005\u0012\u00030\u0083\u00010\u0082\u0001j\n\u0012\u0005\u0012\u00030\u0083\u0001`\u0084\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u001b\u0010½\u0001\u001a\u0016\u0012\u0005\u0012\u00030À\u00010\u0082\u0001j\n\u0012\u0005\u0012\u00030À\u0001`\u0084\u0001H\u0007¢\u0006\u0006\bÍ\u0001\u0010Î\u0001R\u001d\u0010Ð\u0001\u001a\u00030Ï\u00018\u0006¢\u0006\u0010\n\u0006\bÐ\u0001\u0010Ñ\u0001\u001a\u0006\bÒ\u0001\u0010Ó\u0001R)\u0010Ô\u0001\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÔ\u0001\u0010Õ\u0001\u001a\u0006\bÖ\u0001\u0010×\u0001\"\u0006\bØ\u0001\u0010Ù\u0001R)\u0010Ú\u0001\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÚ\u0001\u0010Õ\u0001\u001a\u0006\bÛ\u0001\u0010×\u0001\"\u0006\bÜ\u0001\u0010Ù\u0001R)\u0010Ý\u0001\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÝ\u0001\u0010Õ\u0001\u001a\u0006\bÞ\u0001\u0010×\u0001\"\u0006\bß\u0001\u0010Ù\u0001R)\u0010à\u0001\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bà\u0001\u0010Õ\u0001\u001a\u0006\bá\u0001\u0010×\u0001\"\u0006\bâ\u0001\u0010Ù\u0001R)\u0010ã\u0001\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bã\u0001\u0010ä\u0001\u001a\u0006\bå\u0001\u0010æ\u0001\"\u0006\bç\u0001\u0010è\u0001R5\u0010é\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060$8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bé\u0001\u0010ê\u0001\u001a\u0006\bë\u0001\u0010ì\u0001\"\u0006\bí\u0001\u0010î\u0001R\u001d\u0010ï\u0001\u001a\u00030Ï\u00018\u0006¢\u0006\u0010\n\u0006\bï\u0001\u0010Ñ\u0001\u001a\u0006\bð\u0001\u0010Ó\u0001R)\u0010ñ\u0001\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bñ\u0001\u0010Õ\u0001\u001a\u0006\bò\u0001\u0010×\u0001\"\u0006\bó\u0001\u0010Ù\u0001R)\u0010ô\u0001\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bô\u0001\u0010Õ\u0001\u001a\u0006\bõ\u0001\u0010×\u0001\"\u0006\bö\u0001\u0010Ù\u0001R)\u0010÷\u0001\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b÷\u0001\u0010Õ\u0001\u001a\u0006\bø\u0001\u0010×\u0001\"\u0006\bù\u0001\u0010Ù\u0001R)\u0010ú\u0001\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bú\u0001\u0010Õ\u0001\u001a\u0006\bû\u0001\u0010×\u0001\"\u0006\bü\u0001\u0010Ù\u0001R)\u0010ý\u0001\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bý\u0001\u0010ä\u0001\u001a\u0006\bþ\u0001\u0010æ\u0001\"\u0006\bÿ\u0001\u0010è\u0001R\u0018\u0010\u0080\u0002\u001a\u00030§\u00018\u0002X\u0082T¢\u0006\b\n\u0006\b\u0080\u0002\u0010\u0081\u0002R\u0018\u0010\u0082\u0002\u001a\u00030§\u00018\u0002X\u0082T¢\u0006\b\n\u0006\b\u0082\u0002\u0010\u0081\u0002R\u001d\u0010\u0084\u0002\u001a\u00030\u0083\u00028\u0006¢\u0006\u0010\n\u0006\b\u0084\u0002\u0010\u0085\u0002\u001a\u0006\b\u0086\u0002\u0010\u0087\u0002\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0088\u0002"}, d2 = {"Lcom/stepos/policy/sdk/PolicyManager;", "", AppAgent.CONSTRUCT, "()V", "Landroid/content/Context;", "context", "", "getPolicyOperateJson", "(Landroid/content/Context;LH7/c;)Ljava/lang/Object;", "", "getPolicyOperate", "LC7/r;", "saveReadClipboardStatus", "(Landroid/content/Context;)V", "", "getReadClipboardStatus", "(Landroid/content/Context;)I", "status", "saveAgreeStatus", "(Landroid/content/Context;I)V", "getAgreeStatus", "Landroidx/datastore/preferences/core/Preferences$Key;", "dataStoreKey", "getDataStoreString", "(Landroid/content/Context;Landroidx/datastore/preferences/core/Preferences$Key;LH7/c;)Ljava/lang/Object;", "getSecureServiceVersionCode", "resolvePolicyContext", "(Landroid/content/Context;)Landroid/content/Context;", "isDeviceProtectedStorageContext", "(Landroid/content/Context;)Z", "awaitSyncLocalFileFinished", "(LH7/c;)Ljava/lang/Object;", QueryAlgorithmBundle.KEY_CATEGORY, "Lcom/stepos/policy/sdk/bean/PolicyNewestPathResultBean;", "findNewestPolicyFile", "(Landroid/content/Context;Ljava/lang/String;)Lcom/stepos/policy/sdk/bean/PolicyNewestPathResultBean;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "policyCategoryMap", "selfCheckLocalAssets", "(Landroid/content/Context;Ljava/util/HashMap;)V", "assetName", "assetExists", "(Landroid/content/Context;Ljava/lang/String;)Z", "appId", "appSecret", "versionName", "initSDK", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;)V", "isOperateSuccess", "operateJson", "savePolicyOperate", "(Landroid/content/Context;ZLjava/lang/String;LH7/c;)Ljava/lang/Object;", "loadCloudPolicyUidCategoryMap", "persistCloudPolicyUidCategoryMap", "policyUrl", "policyUid", "rememberCloudPolicyUidCategory", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toPath", "copyPolicyFile", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "Lcom/stepos/policy/sdk/bean/PolicyRecordRequest;", "policyRecordRequest", "Lkotlin/Function1;", "Lcom/stepos/policy/sdk/bean/PolicySdkResultBean;", "callBackPolicyResult", "uploadPolicyOperateRecord", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/policy/sdk/bean/PolicyRecordRequest;LS7/k;)V", "methodType", "secondaryConfirmation", "title", "userPrivacyPolicyName", "userCategory", "privacyPolicyName", "", "categoryList", "userId", "Lstepos/support/v7/app/P;", "permissionDialogClickListener", "Lstepos/support/v7/app/j;", "showReGrantTwoPolicyDialogAndUploadRecord", "(Landroid/content/Context;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Lstepos/support/v7/app/P;)Lstepos/support/v7/app/j;", "showReGrantTwoPolicyDialog", "(Landroid/content/Context;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lstepos/support/v7/app/P;)Lstepos/support/v7/app/j;", "Lstepos/support/v7/app/S;", "createReGrantDialogBuilder", "(Landroid/content/Context;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lstepos/support/v7/app/P;)Lstepos/support/v7/app/S;", "showReGrantDialogAndUploadRecord", "(Landroid/content/Context;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Lstepos/support/v7/app/P;)Lstepos/support/v7/app/j;", "showReGrantDialog", "(Landroid/content/Context;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lstepos/support/v7/app/P;)Lstepos/support/v7/app/j;", "dialogTitle", "isRecord", "", "customTerms", "btnNegative", "btnPositive", "showNewestDialogAndUploadRecord", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;ZLjava/lang/CharSequence;Ljava/lang/String;Ljava/lang/String;Lstepos/support/v7/app/P;)Lstepos/support/v7/app/j;", "customNegativeButtonText", "customPositiveButtonText", "operationType", "showDialogUploadRecordBuilder", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/CharSequence;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lstepos/support/v7/app/P;)Lstepos/support/v7/app/S;", "checkButtonMessage", "Lcom/stepos/policy/sdk/dialog/PolicyPermissionDialogBuilder$OnPermissionClickListener;", "showWithdrawalAndCleanServiceDataDialog", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/CharSequence;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/policy/sdk/dialog/PolicyPermissionDialogBuilder$OnPermissionClickListener;)Lstepos/support/v7/app/j;", "hasLogin", "secondCheckButtonMessage", "showWithdrawalAndCleanServiceDataDialogByAccount", "(Landroid/content/Context;ZLjava/lang/String;Ljava/lang/CharSequence;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/policy/sdk/dialog/PolicyPermissionDialogBuilder$OnPermissionClickListener;)Lstepos/support/v7/app/j;", "showDialogByCustomViewAndUploadRecord", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/CharSequence;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lstepos/support/v7/app/P;)Lstepos/support/v7/app/j;", "showDialogByCustomView", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/CharSequence;Ljava/lang/String;Ljava/lang/String;Lstepos/support/v7/app/P;)Lstepos/support/v7/app/j;", "showDialogByCustomViewBuilder", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/CharSequence;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lstepos/support/v7/app/P;)Lstepos/support/v7/app/S;", "theme", "showDialogByCustomThemeViewBuilder", "(Landroid/content/Context;ILjava/lang/String;Ljava/lang/CharSequence;Ljava/lang/String;Ljava/lang/String;Lstepos/support/v7/app/P;)Lstepos/support/v7/app/S;", "showDialogByCustomViewBuilderRecord", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/CharSequence;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Lstepos/support/v7/app/P;)Lstepos/support/v7/app/S;", "createRecordRequest", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/policy/sdk/bean/PolicyRecordRequest;", "reTryUploadRecord", "serviceName", "validateCode", "verifyType", "Ljava/util/ArrayList;", "Lcom/stepos/policy/sdk/bean/DeleteInfoBean;", "Lkotlin/collections/ArrayList;", "deleteInfoBeanList", "uploadRecordWithoutSecureService", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;LS7/k;)V", "uploadRecordByCustomRecordRequest", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/policy/sdk/bean/PolicyRecordRequest;LS7/k;)V", "uploadRecordToCleanServiceData", "autoUploadRecord", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "permissionKey", "permissionSummary", NotificationCompat.CATEGORY_REMINDER, "showCustomPolicyDialogAndUploadRecord", "(Landroid/content/Context;Z[Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Lcom/stepos/policy/sdk/dialog/PolicyPermissionDialogBuilder$OnPermissionClickListener;)Lstepos/support/v7/app/j;", "fullAgreeListener", "basicListener", "showCustomPolicyThreeButtonDialogAndUploadRecord", "(Landroid/content/Context;Z[Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Lcom/stepos/policy/sdk/dialog/PolicyPermissionDialogBuilder$OnPermissionClickListener;Lstepos/support/v7/app/P;)Lstepos/support/v7/app/j;", "showCustomPolicyDialog", "(Landroid/content/Context;Z[Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Lcom/stepos/policy/sdk/dialog/PolicyPermissionDialogBuilder$OnPermissionClickListener;)Lstepos/support/v7/app/j;", "isAutoRecord", "language", "checkNewestPolicy", "(Landroid/content/Context;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;LS7/k;)V", "getPolicyNewestPathByCustom", "(Landroid/content/Context;Ljava/lang/String;)Lcom/stepos/policy/sdk/bean/PolicySdkResultBean;", "getPolicyNewestPath", "localPath", "initPolicyNewestPath", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "openPolicyDataByWebView", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/policy/sdk/bean/PolicySdkResultBean;", "openPolicyMethod", "(Landroid/content/Context;ZLjava/lang/String;Ljava/lang/String;)Lcom/stepos/policy/sdk/bean/PolicySdkResultBean;", "openPolicyDataByBrowser", "", "version", "getPolicyData", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;LS7/k;)V", "getPolicyHistoryList", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;LS7/k;)V", "versionId", "getPolicyByVersion", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;LS7/k;)V", "getPolicyHistoryUrl", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)Ljava/lang/String;", "dataStoreValue", "saveDataStoreString", "(Landroid/content/Context;Landroidx/datastore/preferences/core/Preferences$Key;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "mContext", "businessType", "deleteType", "getCommonDeleteInfoList", "(Landroid/content/Context;Ljava/lang/String;I)V", "getPrivateDeleteInfoList", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILS7/k;)V", "Lcom/stepos/policy/sdk/bean/CustomDeleteInfoBean;", "customDeleteInfoList", "encryptCustomDeleteInfoListBySecure", "(Landroid/content/Context;Ljava/util/ArrayList;LS7/k;)V", "Lcom/stepos/policy/sdk/bean/DeleteInfoEncryptMultiBean;", "encryptMultiDeleteListBySecure", "isSupportSecureService31", "versionCode", "isSupportSecureService", "(Landroid/content/Context;I)Z", "md5", "saveLocalCategoryMd5", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "getLocalCategoryMd5", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;", "getPolicyServiceConfig", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;LS7/k;)V", "encryptDeleteInfoWithoutSecureService", "(Landroid/content/Context;Ljava/util/ArrayList;)Ljava/util/ArrayList;", "Lm9/z;", "lifecycleScope", "Lm9/z;", "getLifecycleScope", "()Lm9/z;", "mAppId", "Ljava/lang/String;", "getMAppId", "()Ljava/lang/String;", "setMAppId", "(Ljava/lang/String;)V", "mAppSecret", "getMAppSecret", "setMAppSecret", "mAppVersionName", "getMAppVersionName", "setMAppVersionName", "customPolicyCSSFileName", "getCustomPolicyCSSFileName", "setCustomPolicyCSSFileName", "syncLocalFileFinished", "Z", "getSyncLocalFileFinished", "()Z", "setSyncLocalFileFinished", "(Z)V", "localAssetsCategoryPathMap", "Ljava/util/HashMap;", "getLocalAssetsCategoryPathMap", "()Ljava/util/HashMap;", "setLocalAssetsCategoryPathMap", "(Ljava/util/HashMap;)V", "scope", "getScope", "companyCode", "getCompanyCode", "setCompanyCode", "brand", "getBrand", "setBrand", AlgorithmUpdateBundle.KEY_SUFFIX_MODEL, "getModel", "setModel", "osVersion", "getOsVersion", "setOsVersion", "initSDKByDeviceProtectedStorageContext", "getInitSDKByDeviceProtectedStorageContext", "setInitSDKByDeviceProtectedStorageContext", "SYNC_LOCAL_FILE_MAX_WAIT_MS", "J", "SYNC_LOCAL_FILE_POLL_MS", "Lm9/x;", "exceptionHandler", "Lm9/x;", "getExceptionHandler", "()Lm9/x;", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PolicyManager {
    public static final PolicyManager INSTANCE = new PolicyManager();
    private static final long SYNC_LOCAL_FILE_MAX_WAIT_MS = 10000;
    private static final long SYNC_LOCAL_FILE_POLL_MS = 200;
    private static String brand;
    private static String companyCode;
    private static String customPolicyCSSFileName;
    private static final InterfaceC1731x exceptionHandler;
    private static boolean initSDKByDeviceProtectedStorageContext;
    private static final InterfaceC1733z lifecycleScope;
    private static HashMap<String, String> localAssetsCategoryPathMap;
    private static String mAppId;
    private static String mAppSecret;
    private static String mAppVersionName;
    private static String model;
    private static String osVersion;
    private static final InterfaceC1733z scope;
    private static boolean syncLocalFileFinished;

    @J7.c(c = "com.stepos.policy.sdk.PolicyManager$autoUploadRecord$2", f = "PolicyManager.kt", l = {1349}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: com.stepos.policy.sdk.PolicyManager$autoUploadRecord$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements S7.n {

        /* renamed from: a, reason: collision with root package name */
        public int f3892a;
        public final /* synthetic */ Ref$ObjectRef b;
        public final /* synthetic */ Context c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Ref$ObjectRef ref$ObjectRef, Context context, H7.c cVar) {
            super(2, cVar);
            this.b = ref$ObjectRef;
            this.c = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c create(Object obj, H7.c cVar) {
            return new AnonymousClass2(this.b, this.c, cVar);
        }

        @Override // S7.n
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass2) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.f3892a;
            if (i == 0) {
                kotlin.b.b(obj);
                String json = new Gson().toJson(this.b.f4920a);
                PolicyManager policyManager = PolicyManager.INSTANCE;
                this.f3892a = 1;
                if (policyManager.savePolicyOperate(this.c, false, json, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
            }
            return r.f317a;
        }
    }

    @J7.c(c = "com.stepos.policy.sdk.PolicyManager", f = "PolicyManager.kt", l = {149}, m = "awaitSyncLocalFileFinished")
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: com.stepos.policy.sdk.PolicyManager$awaitSyncLocalFileFinished$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11151 extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public long f3893a;
        public /* synthetic */ Object b;
        public int d;

        public C11151(H7.c cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return PolicyManager.this.awaitSyncLocalFileFinished(this);
        }
    }

    @J7.c(c = "com.stepos.policy.sdk.PolicyManager$checkNewestPolicy$1", f = "PolicyManager.kt", l = {1553, 1607}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: com.stepos.policy.sdk.PolicyManager$checkNewestPolicy$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11161 extends SuspendLambda implements S7.n {

        /* renamed from: a, reason: collision with root package name */
        public Ref$ObjectRef f3894a;
        public PolicyNewestPathResultBean b;
        public Ref$ObjectRef c;
        public int d;
        public final /* synthetic */ Context e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ boolean h;
        public final /* synthetic */ String i;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ String f3895j;
        public final /* synthetic */ String k;
        public final /* synthetic */ S7.k l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11161(Context context, String str, String str2, boolean z10, String str3, String str4, String str5, S7.k kVar, H7.c cVar) {
            super(2, cVar);
            this.e = context;
            this.f = str;
            this.g = str2;
            this.h = z10;
            this.i = str3;
            this.f3895j = str4;
            this.k = str5;
            this.l = kVar;
        }

        public static final void c(Ref$ObjectRef ref$ObjectRef, S7.k kVar, String str, String str2) {
            PolicySdkLogUtils.INSTANCE.logCheckNewestResult((PolicySdkResultBean) ref$ObjectRef.f4920a, str, str2);
            kVar.invoke(ref$ObjectRef.f4920a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c create(Object obj, H7.c cVar) {
            return new C11161(this.e, this.f, this.g, this.h, this.i, this.f3895j, this.k, this.l, cVar);
        }

        @Override // S7.n
        public final Object invoke(Object obj, Object obj2) {
            return ((C11161) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
        }

        /* JADX WARN: Removed duplicated region for block: B:110:0x0331  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x014c  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r26) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 1062
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.C11161.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @J7.c(c = "com.stepos.policy.sdk.PolicyManager", f = "PolicyManager.kt", l = {398}, m = "getAgreeStatus")
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: com.stepos.policy.sdk.PolicyManager$getAgreeStatus$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11191 extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f3899a;
        public int c;

        public C11191(H7.c cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f3899a = obj;
            this.c |= Integer.MIN_VALUE;
            return PolicyManager.this.getAgreeStatus(null, this);
        }
    }

    @J7.c(c = "com.stepos.policy.sdk.PolicyManager$getLocalCategoryMd5$1", f = "PolicyManager.kt", l = {2581}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "", "<anonymous>", "(Lm9/z;)Ljava/lang/String;"}, k = 3, mv = {1, 8, 0})
    /* renamed from: com.stepos.policy.sdk.PolicyManager$getLocalCategoryMd5$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11211 extends SuspendLambda implements S7.n {

        /* renamed from: a, reason: collision with root package name */
        public int f3902a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11211(Context context, String str, H7.c cVar) {
            super(2, cVar);
            this.b = context;
            this.c = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c create(Object obj, H7.c cVar) {
            return new C11211(this.b, this.c, cVar);
        }

        @Override // S7.n
        public final Object invoke(Object obj, Object obj2) {
            return ((C11211) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.f3902a;
            if (i == 0) {
                kotlin.b.b(obj);
                e eVar = new e(m.a(this.b).getData(), this.c, 1);
                this.f3902a = 1;
                obj = kotlinx.coroutines.flow.d.h(eVar, this);
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
            }
            String strValueOf = String.valueOf(obj);
            return strValueOf.equals("null") ? "" : strValueOf;
        }
    }

    @J7.c(c = "com.stepos.policy.sdk.PolicyManager$getPolicyByVersion$1", f = "PolicyManager.kt", l = {2314}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: com.stepos.policy.sdk.PolicyManager$getPolicyByVersion$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11221 extends SuspendLambda implements S7.n {

        /* renamed from: a, reason: collision with root package name */
        public PolicySdkResultBean f3903a;
        public int b;
        public final /* synthetic */ Long c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ S7.k g;
        public final /* synthetic */ String h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11221(Long l, String str, String str2, String str3, S7.k kVar, String str4, H7.c cVar) {
            super(2, cVar);
            this.c = l;
            this.d = str;
            this.e = str2;
            this.f = str3;
            this.g = kVar;
            this.h = str4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c create(Object obj, H7.c cVar) {
            return new C11221(this.c, this.d, this.e, this.f, this.g, this.h, cVar);
        }

        @Override // S7.n
        public final Object invoke(Object obj, Object obj2) {
            return ((C11221) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v17, types: [S7.k] */
        /* JADX WARN: Type inference failed for: r15v0, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r15v1 */
        /* JADX WARN: Type inference failed for: r15v5, types: [com.stepos.policy.sdk.bean.PolicySdkResultBean, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r15v6 */
        /* JADX WARN: Type inference failed for: r15v7 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            String str;
            S7.k kVar;
            String str2;
            Object objW;
            PolicyData data;
            String str3 = this.e;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.b;
            S7.k kVar2 = this.g;
            ?? r15 = "PolicyManager";
            String str4 = "return policySdkResultBean = : ";
            try {
                try {
                } catch (Throwable th) {
                    th = th;
                    str4 = r15;
                }
            } catch (Throwable th2) {
                th = th2;
            }
            if (i == 0) {
                kotlin.b.b(obj);
                PolicySdkResultBean policySdkResultBean = new PolicySdkResultBean();
                if (this.c == null || this.d == null) {
                    policySdkResultBean.setCode(PolicySdkErrorCode.PARAMETER_ERROR);
                    PolicySdkLogUtils.INSTANCE.e("PolicyManager", "return policySdkResultBean = : " + policySdkResultBean.getCode());
                    kVar2.invoke(policySdkResultBean);
                    return r.f317a;
                }
                Ref$LongRef ref$LongRef = new Ref$LongRef();
                ref$LongRef.f4919a = System.currentTimeMillis();
                Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                str = "PolicyManager";
                try {
                    ref$ObjectRef.f4920a = PolicySdkToolsUtils.INSTANCE.getAppSign(str3, this.f, ref$LongRef.f4919a);
                    u9.d dVar = AbstractC1691I.f5315a;
                    u9.c cVar = u9.c.f6743a;
                    kVar = kVar2;
                    str2 = "return policySdkResultBean = : ";
                    PolicySdkResultBean policySdkResultBean2 = policySdkResultBean;
                    PolicyManager$getPolicyByVersion$1$response$1 policyManager$getPolicyByVersion$1$response$1 = new PolicyManager$getPolicyByVersion$1$response$1(str3, ref$ObjectRef, ref$LongRef, this.h, this.c, this.d, null);
                    this.f3903a = policySdkResultBean2;
                    this.b = 1;
                    objW = AbstractC1683A.w(cVar, policyManager$getPolicyByVersion$1$response$1, this);
                    r15 = policySdkResultBean2;
                    if (objW == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    str4 = str;
                    PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.INSTANCE;
                    StringBuilder sb = new StringBuilder("exception : ");
                    th.getMessage();
                    sb.append(th);
                    companion.e(str4, sb.toString());
                    return r.f317a;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                PolicySdkResultBean policySdkResultBean3 = this.f3903a;
                kotlin.b.b(obj);
                kVar = kVar2;
                str = "PolicyManager";
                r15 = policySdkResultBean3;
                str2 = "return policySdkResultBean = : ";
                objW = obj;
            }
            L l = (L) objW;
            PolicySdkLogUtils.Companion companion2 = PolicySdkLogUtils.INSTANCE;
            String str5 = str;
            companion2.d(str5, "response" + l);
            Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            M m = l.f5644a;
            Object obj2 = l.b;
            if (m.c()) {
                companion2.d(str5, "response isSuccessful");
                companion2.d(str5, "response.code()=" + l.f5644a.d);
                companion2.d(str5, "response.body() =" + obj2);
                PolicyVersionResponse policyVersionResponse = (PolicyVersionResponse) obj2;
                if (policyVersionResponse != null) {
                    ref$ObjectRef2.f4920a = policyVersionResponse;
                }
            } else {
                companion2.d(str5, "response failed");
            }
            r15.setCode(0);
            PolicyVersionResponse policyVersionResponse2 = (PolicyVersionResponse) ref$ObjectRef2.f4920a;
            if (policyVersionResponse2 != null && (data = policyVersionResponse2.getData()) != null) {
                r15.setPolicyData(data);
            }
            companion2.e(str5, str2 + r15.getCode());
            kVar.invoke(r15);
            return r.f317a;
        }
    }

    @J7.c(c = "com.stepos.policy.sdk.PolicyManager$getPolicyData$1", f = "PolicyManager.kt", l = {2139}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: com.stepos.policy.sdk.PolicyManager$getPolicyData$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11231 extends SuspendLambda implements S7.n {

        /* renamed from: a, reason: collision with root package name */
        public PolicySdkResultBean f3905a;
        public int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Long d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ S7.k h;
        public final /* synthetic */ String i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11231(String str, Long l, String str2, String str3, String str4, S7.k kVar, String str5, H7.c cVar) {
            super(2, cVar);
            this.c = str;
            this.d = l;
            this.e = str2;
            this.f = str3;
            this.g = str4;
            this.h = kVar;
            this.i = str5;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c create(Object obj, H7.c cVar) {
            return new C11231(this.c, this.d, this.e, this.f, this.g, this.h, this.i, cVar);
        }

        @Override // S7.n
        public final Object invoke(Object obj, Object obj2) {
            return ((C11231) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
        }

        /* JADX WARN: Can't wrap try/catch for region: R(10:0|2|(1:80)|(1:(3:5|6|7)(2:11|12))(3:13|14|(4:74|79|77|78)(17:20|21|88|22|23|82|24|25|94|26|27|92|28|29|84|30|(1:32)))|33|86|(7:90|35|(1:58)(6:39|40|41|(1:43)|46|(4:48|(1:52)|53|(1:55)))|59|60|61|79)(0)|77|78|(1:(0))) */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x0104, code lost:
        
            r0 = th;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:58:0x013b A[Catch: all -> 0x0104, TryCatch #3 {all -> 0x0104, blocks: (B:41:0x00fa, B:43:0x0101, B:46:0x0109, B:48:0x010f, B:50:0x0119, B:52:0x011f, B:53:0x0129, B:55:0x012f, B:59:0x0146, B:58:0x013b), top: B:86:0x00c3 }] */
        /* JADX WARN: Type inference failed for: r0v25, types: [java.lang.StringBuilder] */
        /* JADX WARN: Type inference failed for: r3v0, types: [S7.k] */
        /* JADX WARN: Type inference failed for: r3v1 */
        /* JADX WARN: Type inference failed for: r3v5, types: [boolean] */
        /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r4v1 */
        /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.Object] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r24) {
            /*
                Method dump skipped, instructions count: 449
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.C11231.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @J7.c(c = "com.stepos.policy.sdk.PolicyManager$getPolicyHistoryList$1", f = "PolicyManager.kt", l = {2234}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: com.stepos.policy.sdk.PolicyManager$getPolicyHistoryList$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11241 extends SuspendLambda implements S7.n {

        /* renamed from: a, reason: collision with root package name */
        public PolicySdkResultBean f3907a;
        public int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ S7.k g;
        public final /* synthetic */ String h;
        public final /* synthetic */ long i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11241(String str, String str2, String str3, String str4, S7.k kVar, String str5, long j5, H7.c cVar) {
            super(2, cVar);
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = str4;
            this.g = kVar;
            this.h = str5;
            this.i = j5;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c create(Object obj, H7.c cVar) {
            return new C11241(this.c, this.d, this.e, this.f, this.g, this.h, this.i, cVar);
        }

        @Override // S7.n
        public final Object invoke(Object obj, Object obj2) {
            return ((C11241) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            String str;
            String str2;
            S7.k kVar;
            PolicySdkResultBean policySdkResultBean;
            String str3;
            String str4;
            String str5;
            Object objW;
            String str6 = this.e;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.b;
            S7.k kVar2 = this.g;
            String str7 = "PolicyManager";
            try {
                try {
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Throwable th2) {
                th = th2;
                str = str7;
            }
            if (i == 0) {
                kotlin.b.b(obj);
                PolicySdkResultBean policySdkResultBean2 = new PolicySdkResultBean();
                if (this.c == null || this.d == null) {
                    policySdkResultBean2.setCode(PolicySdkErrorCode.PARAMETER_ERROR);
                    PolicySdkLogUtils.INSTANCE.e("PolicyManager", "return policySdkResultBean = : " + policySdkResultBean2.getCode());
                    kVar2.invoke(policySdkResultBean2);
                    return r.f317a;
                }
                Ref$LongRef ref$LongRef = new Ref$LongRef();
                ref$LongRef.f4919a = System.currentTimeMillis();
                Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                ref$ObjectRef.f4920a = PolicySdkToolsUtils.INSTANCE.getAppSign(str6, this.f, ref$LongRef.f4919a);
                u9.d dVar = AbstractC1691I.f5315a;
                u9.c cVar = u9.c.f6743a;
                str7 = this.c;
                try {
                    str2 = "return policySdkResultBean = : ";
                    kVar = kVar2;
                    policySdkResultBean = policySdkResultBean2;
                    str3 = "PolicyManager";
                    str4 = "response.body() =";
                    str5 = "response.code()=";
                    try {
                        PolicyManager$getPolicyHistoryList$1$response$1 policyManager$getPolicyHistoryList$1$response$1 = new PolicyManager$getPolicyHistoryList$1$response$1(str6, ref$ObjectRef, str7, ref$LongRef, this.h, this.i, this.d, null);
                        this.f3907a = policySdkResultBean;
                        this.b = 1;
                        objW = AbstractC1683A.w(cVar, policyManager$getPolicyHistoryList$1$response$1, this);
                        if (objW == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        str = str3;
                        PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.INSTANCE;
                        StringBuilder sb = new StringBuilder("exception : ");
                        th.getMessage();
                        sb.append(th);
                        companion.e(str, sb.toString());
                        return r.f317a;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    str = "PolicyManager";
                    PolicySdkLogUtils.Companion companion2 = PolicySdkLogUtils.INSTANCE;
                    StringBuilder sb2 = new StringBuilder("exception : ");
                    th.getMessage();
                    sb2.append(th);
                    companion2.e(str, sb2.toString());
                    return r.f317a;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                PolicySdkResultBean policySdkResultBean3 = this.f3907a;
                kotlin.b.b(obj);
                str3 = "PolicyManager";
                str2 = "return policySdkResultBean = : ";
                str4 = "response.body() =";
                str5 = "response.code()=";
                kVar = kVar2;
                policySdkResultBean = policySdkResultBean3;
                objW = obj;
            }
            L l = (L) objW;
            PolicySdkLogUtils.Companion companion3 = PolicySdkLogUtils.INSTANCE;
            String str8 = str3;
            companion3.d(str8, "response" + l);
            Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            M m = l.f5644a;
            Object obj2 = l.b;
            if (m.c()) {
                companion3.d(str8, "response isSuccessful");
                companion3.d(str8, str5 + l.f5644a.d);
                companion3.d(str8, str4 + obj2);
                PolicyHistoryListResponse policyHistoryListResponse = (PolicyHistoryListResponse) obj2;
                if (policyHistoryListResponse != null) {
                    ref$ObjectRef2.f4920a = policyHistoryListResponse;
                }
            } else {
                companion3.d(str8, "response failed");
            }
            policySdkResultBean.setCode(0);
            PolicyHistoryListResponse policyHistoryListResponse2 = (PolicyHistoryListResponse) ref$ObjectRef2.f4920a;
            if (policyHistoryListResponse2 != null) {
                policySdkResultBean.setPolicyHistoryListResponse(policyHistoryListResponse2);
            }
            companion3.e(str8, str2 + policySdkResultBean.getCode());
            kVar.invoke(policySdkResultBean);
            return r.f317a;
        }
    }

    @J7.c(c = "com.stepos.policy.sdk.PolicyManager", f = "PolicyManager.kt", l = {338}, m = "getPolicyOperate")
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: com.stepos.policy.sdk.PolicyManager$getPolicyOperate$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11251 extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f3909a;
        public int c;

        public C11251(H7.c cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f3909a = obj;
            this.c |= Integer.MIN_VALUE;
            return PolicyManager.this.getPolicyOperate(null, this);
        }
    }

    @J7.c(c = "com.stepos.policy.sdk.PolicyManager$getPolicyServiceConfig$1", f = "PolicyManager.kt", l = {2606}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: com.stepos.policy.sdk.PolicyManager$getPolicyServiceConfig$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11261 extends SuspendLambda implements S7.n {

        /* renamed from: a, reason: collision with root package name */
        public PolicySdkResultBean f3910a;
        public int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ S7.k f;
        public final /* synthetic */ String g;
        public final /* synthetic */ Context h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11261(String str, String str2, String str3, S7.k kVar, String str4, Context context, H7.c cVar) {
            super(2, cVar);
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = kVar;
            this.g = str4;
            this.h = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c create(Object obj, H7.c cVar) {
            return new C11261(this.c, this.d, this.e, this.f, this.g, this.h, cVar);
        }

        @Override // S7.n
        public final Object invoke(Object obj, Object obj2) {
            return ((C11261) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r12v0, types: [S7.k] */
        /* JADX WARN: Type inference failed for: r14v0, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r14v1 */
        /* JADX WARN: Type inference failed for: r14v4, types: [com.stepos.policy.sdk.bean.PolicySdkResultBean, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r14v5 */
        /* JADX WARN: Type inference failed for: r14v6 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            String str;
            String str2;
            Object objW;
            List<PolicyServiceConfigBean> data;
            String str3 = this.d;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.b;
            ?? r12 = this.f;
            ?? r14 = "PolicyManager";
            try {
                try {
                } catch (Throwable th) {
                    th = th;
                    str = r14;
                }
            } catch (Throwable th2) {
                th = th2;
            }
            if (i == 0) {
                kotlin.b.b(obj);
                PolicySdkResultBean policySdkResultBean = new PolicySdkResultBean();
                if (this.c == null) {
                    policySdkResultBean.setCode(PolicySdkErrorCode.PARAMETER_ERROR);
                    PolicySdkLogUtils.INSTANCE.e("PolicyManager", "return policySdkResultBean = : " + policySdkResultBean.getCode());
                    r12.invoke(policySdkResultBean);
                    return r.f317a;
                }
                Ref$LongRef ref$LongRef = new Ref$LongRef();
                ref$LongRef.f4919a = System.currentTimeMillis();
                Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                str2 = "PolicyManager";
                try {
                    ref$ObjectRef.f4920a = PolicySdkToolsUtils.INSTANCE.getAppSign(str3, this.e, ref$LongRef.f4919a);
                    u9.d dVar = AbstractC1691I.f5315a;
                    u9.c cVar = u9.c.f6743a;
                    PolicySdkResultBean policySdkResultBean2 = policySdkResultBean;
                    PolicyManager$getPolicyServiceConfig$1$response$1 policyManager$getPolicyServiceConfig$1$response$1 = new PolicyManager$getPolicyServiceConfig$1$response$1(str3, ref$ObjectRef, ref$LongRef, this.g, this.c, null);
                    this.f3910a = policySdkResultBean2;
                    this.b = 1;
                    objW = AbstractC1683A.w(cVar, policyManager$getPolicyServiceConfig$1$response$1, this);
                    r14 = policySdkResultBean2;
                    if (objW == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    str = str2;
                    PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.INSTANCE;
                    StringBuilder sb = new StringBuilder("exception : ");
                    th.getMessage();
                    sb.append(th);
                    companion.e(str, sb.toString());
                    return r.f317a;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                PolicySdkResultBean policySdkResultBean3 = this.f3910a;
                kotlin.b.b(obj);
                str2 = "PolicyManager";
                r14 = policySdkResultBean3;
                objW = obj;
            }
            L l = (L) objW;
            PolicySdkLogUtils.Companion companion2 = PolicySdkLogUtils.INSTANCE;
            String str4 = str2;
            companion2.d(str4, "response" + l);
            Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            M m = l.f5644a;
            Object obj2 = l.b;
            if (m.c()) {
                companion2.d(str4, "response isSuccessful");
                companion2.d(str4, "response.code()=" + l.f5644a.d);
                companion2.d(str4, "response.body() =" + obj2);
                PolicyServiceConfigResponse policyServiceConfigResponse = (PolicyServiceConfigResponse) obj2;
                if (policyServiceConfigResponse != null) {
                    ref$ObjectRef2.f4920a = policyServiceConfigResponse;
                }
            } else {
                companion2.d(str4, "response failed");
            }
            r14.setCode(0);
            PolicyServiceConfigResponse policyServiceConfigResponse2 = (PolicyServiceConfigResponse) ref$ObjectRef2.f4920a;
            if (policyServiceConfigResponse2 != null && (data = policyServiceConfigResponse2.getData()) != null) {
                Context context = this.h;
                r14.setPolicyServiceConfigList(data);
                r14.setDeleteInfoBeanList(PolicySdkStringUtils.INSTANCE.getDeleteInfoListFromServiceConfig(context, data));
            }
            companion2.d(str4, "return policySdkResultBean = : " + r14.getCode());
            r12.invoke(r14);
            return r.f317a;
        }
    }

    @J7.c(c = "com.stepos.policy.sdk.PolicyManager$getReadClipboardStatus$1", f = "PolicyManager.kt", l = {367}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "", "<anonymous>", "(Lm9/z;)I"}, k = 3, mv = {1, 8, 0})
    /* renamed from: com.stepos.policy.sdk.PolicyManager$getReadClipboardStatus$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11281 extends SuspendLambda implements S7.n {

        /* renamed from: a, reason: collision with root package name */
        public int f3913a;
        public final /* synthetic */ Context b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11281(Context context, H7.c cVar) {
            super(2, cVar);
            this.b = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c create(Object obj, H7.c cVar) {
            return new C11281(this.b, cVar);
        }

        @Override // S7.n
        public final Object invoke(Object obj, Object obj2) {
            return ((C11281) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.f3913a;
            if (i == 0) {
                kotlin.b.b(obj);
                c cVar = new c(m.a(this.b).getData(), 3);
                this.f3913a = 1;
                obj = kotlinx.coroutines.flow.d.h(cVar, this);
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
            }
            Integer num = (Integer) obj;
            return num == null ? new Integer(ReadClipboardUtils.READ_CLIPBOARD_PERMISSION_DISAGREE) : num;
        }
    }

    @J7.c(c = "com.stepos.policy.sdk.PolicyManager", f = "PolicyManager.kt", l = {1900}, m = "initPolicyNewestPath")
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: com.stepos.policy.sdk.PolicyManager$initPolicyNewestPath$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11291 extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public Context f3914a;
        public String b;
        public String c;
        public PolicySdkResultBean d;
        public PolicyNewestPathResultBean e;
        public String f;
        public /* synthetic */ Object g;
        public int h;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.g = obj;
            this.h |= Integer.MIN_VALUE;
            return PolicyManager.initPolicyNewestPath(null, null, null, this);
        }
    }

    @J7.c(c = "com.stepos.policy.sdk.PolicyManager$initSDK$1", f = "PolicyManager.kt", l = {260, 261}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: com.stepos.policy.sdk.PolicyManager$initSDK$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11301 extends SuspendLambda implements S7.n {

        /* renamed from: a, reason: collision with root package name */
        public int f3915a;
        public final /* synthetic */ Context b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11301(Context context, H7.c cVar) {
            super(2, cVar);
            this.b = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c create(Object obj, H7.c cVar) {
            return new C11301(this.b, cVar);
        }

        @Override // S7.n
        public final Object invoke(Object obj, Object obj2) {
            return ((C11301) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x003d, code lost:
        
            if (r6.loadCloudPolicyUidCategoryMap(r2, r5) == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
                int r1 = r5.f3915a
                android.content.Context r2 = r5.b
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L1e
                if (r1 == r4) goto L1a
                if (r1 != r3) goto L12
                kotlin.b.b(r6)
                goto L40
            L12:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L1a:
                kotlin.b.b(r6)
                goto L2c
            L1e:
                kotlin.b.b(r6)
                com.stepos.policy.sdk.PolicyManager r6 = com.stepos.policy.sdk.PolicyManager.INSTANCE
                r5.f3915a = r4
                java.lang.Object r6 = r6.getAgreeStatus(r2, r5)
                if (r6 != r0) goto L2c
                goto L3f
            L2c:
                java.lang.Number r6 = (java.lang.Number) r6
                int r6 = r6.intValue()
                com.stepos.policy.sdk.util.PolicySdkNetworkGate.updateAgreeStatusCache(r6)
                com.stepos.policy.sdk.PolicyManager r6 = com.stepos.policy.sdk.PolicyManager.INSTANCE
                r5.f3915a = r3
                java.lang.Object r5 = com.stepos.policy.sdk.PolicyManager.access$loadCloudPolicyUidCategoryMap(r6, r2, r5)
                if (r5 != r0) goto L40
            L3f:
                return r0
            L40:
                C7.r r5 = C7.r.f317a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.C11301.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @J7.c(c = "com.stepos.policy.sdk.PolicyManager$initSDK$2", f = "PolicyManager.kt", l = {272}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: com.stepos.policy.sdk.PolicyManager$initSDK$2, reason: invalid class name and case insensitive filesystem */
    public static final class C11312 extends SuspendLambda implements S7.n {

        /* renamed from: a, reason: collision with root package name */
        public int f3916a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ HashMap c;

        @J7.c(c = "com.stepos.policy.sdk.PolicyManager$initSDK$2$1", f = "PolicyManager.kt", l = {285}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
        /* renamed from: com.stepos.policy.sdk.PolicyManager$initSDK$2$1, reason: invalid class name */
        final class AnonymousClass1 extends SuspendLambda implements S7.n {

            /* renamed from: a, reason: collision with root package name */
            public Iterator f3917a;
            public String b;
            public int c;
            public final /* synthetic */ Context d;
            public final /* synthetic */ HashMap e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Context context, HashMap map, H7.c cVar) {
                super(2, cVar);
                this.d = context;
                this.e = map;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c create(Object obj, H7.c cVar) {
                return new AnonymousClass1(this.d, this.e, cVar);
            }

            @Override // S7.n
            public final Object invoke(Object obj, Object obj2) {
                return ((AnonymousClass1) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0055  */
            /* JADX WARN: Removed duplicated region for block: B:15:0x00a4  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x008a -> B:14:0x008d). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r12) {
                /*
                    r11 = this;
                    kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
                    int r1 = r11.c
                    java.lang.String r2 = " *************** policyKey = "
                    java.util.HashMap r3 = r11.e
                    android.content.Context r4 = r11.d
                    r5 = 1
                    java.lang.String r6 = "initSDK"
                    if (r1 == 0) goto L23
                    if (r1 != r5) goto L1b
                    java.lang.String r1 = r11.b
                    java.util.Iterator r7 = r11.f3917a
                    java.util.Iterator r7 = (java.util.Iterator) r7
                    kotlin.b.b(r12)
                    goto L8d
                L1b:
                    java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                    java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                    r11.<init>(r12)
                    throw r11
                L23:
                    kotlin.b.b(r12)
                    com.stepos.policy.sdk.PolicyManager r12 = com.stepos.policy.sdk.PolicyManager.INSTANCE
                    r1 = 0
                    r12.setSyncLocalFileFinished(r1)
                    com.stepos.policy.sdk.util.PolicySdkLogUtils$Companion r1 = com.stepos.policy.sdk.util.PolicySdkLogUtils.INSTANCE
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder
                    java.lang.String r8 = "syncLocalFileFinished start time = "
                    r7.<init>(r8)
                    long r8 = java.lang.System.currentTimeMillis()
                    r7.append(r8)
                    java.lang.String r7 = r7.toString()
                    r1.d(r6, r7)
                    com.stepos.policy.sdk.PolicyManager.access$selfCheckLocalAssets(r12, r4, r3)
                    java.util.Set r12 = r3.entrySet()
                    java.util.Iterator r12 = r12.iterator()
                    r7 = r12
                L4f:
                    boolean r12 = r7.hasNext()
                    if (r12 == 0) goto La4
                    java.lang.Object r12 = r7.next()
                    java.util.Map$Entry r12 = (java.util.Map.Entry) r12
                    java.lang.Object r1 = r12.getKey()
                    java.lang.String r1 = (java.lang.String) r1
                    java.lang.Object r12 = r12.getValue()
                    java.lang.String r12 = (java.lang.String) r12
                    com.stepos.policy.sdk.util.PolicySdkLogUtils$Companion r8 = com.stepos.policy.sdk.util.PolicySdkLogUtils.INSTANCE
                    java.lang.StringBuilder r9 = new java.lang.StringBuilder
                    r9.<init>(r2)
                    r9.append(r1)
                    java.lang.String r10 = " start***************"
                    r9.append(r10)
                    java.lang.String r9 = r9.toString()
                    r8.d(r6, r9)
                    r8 = r7
                    java.util.Iterator r8 = (java.util.Iterator) r8
                    r11.f3917a = r8
                    r11.b = r1
                    r11.c = r5
                    java.lang.Object r12 = com.stepos.policy.sdk.PolicyManager.initPolicyNewestPath(r4, r12, r1, r11)
                    if (r12 != r0) goto L8d
                    return r0
                L8d:
                    com.stepos.policy.sdk.util.PolicySdkLogUtils$Companion r12 = com.stepos.policy.sdk.util.PolicySdkLogUtils.INSTANCE
                    java.lang.StringBuilder r8 = new java.lang.StringBuilder
                    r8.<init>(r2)
                    r8.append(r1)
                    java.lang.String r1 = " end ***************"
                    r8.append(r1)
                    java.lang.String r1 = r8.toString()
                    r12.d(r6, r1)
                    goto L4f
                La4:
                    com.stepos.policy.sdk.PolicyManager r11 = com.stepos.policy.sdk.PolicyManager.INSTANCE
                    r11.setSyncLocalFileFinished(r5)
                    com.stepos.policy.sdk.util.PolicySdkLogUtils$Companion r11 = com.stepos.policy.sdk.util.PolicySdkLogUtils.INSTANCE
                    java.lang.StringBuilder r12 = new java.lang.StringBuilder
                    java.lang.String r0 = ">>> DONE syncLocalFileFinished=true, storage="
                    r12.<init>(r0)
                    java.io.File r0 = r4.getDataDir()
                    if (r0 == 0) goto Lbd
                    java.lang.String r0 = r0.getPath()
                    goto Lbe
                Lbd:
                    r0 = 0
                Lbe:
                    r12.append(r0)
                    java.lang.String r0 = ", categories="
                    r12.append(r0)
                    java.util.Set r0 = r3.keySet()
                    r12.append(r0)
                    java.lang.String r12 = r12.toString()
                    r11.i(r6, r12)
                    C7.r r11 = C7.r.f317a
                    return r11
                */
                throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.C11312.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11312(Context context, HashMap map, H7.c cVar) {
            super(2, cVar);
            this.b = context;
            this.c = map;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c create(Object obj, H7.c cVar) {
            return new C11312(this.b, this.c, cVar);
        }

        @Override // S7.n
        public final Object invoke(Object obj, Object obj2) {
            return ((C11312) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.f3916a;
            if (i == 0) {
                kotlin.b.b(obj);
                u9.d dVar = AbstractC1691I.f5315a;
                u9.c cVar = u9.c.f6743a;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.b, this.c, null);
                this.f3916a = 1;
                if (AbstractC1683A.w(cVar, anonymousClass1, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
            }
            return r.f317a;
        }
    }

    @J7.c(c = "com.stepos.policy.sdk.PolicyManager", f = "PolicyManager.kt", l = {McpErrorCode.TOOL_NOT_FOUND}, m = "loadCloudPolicyUidCategoryMap")
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: com.stepos.policy.sdk.PolicyManager$loadCloudPolicyUidCategoryMap$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11321 extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f3918a;
        public int c;

        public C11321(H7.c cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f3918a = obj;
            this.c |= Integer.MIN_VALUE;
            return PolicyManager.this.loadCloudPolicyUidCategoryMap(null, this);
        }
    }

    @J7.c(c = "com.stepos.policy.sdk.PolicyManager$persistCloudPolicyUidCategoryMap$1", f = "PolicyManager.kt", l = {TypedValues.CycleType.TYPE_WAVE_PHASE}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: com.stepos.policy.sdk.PolicyManager$persistCloudPolicyUidCategoryMap$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11331 extends SuspendLambda implements S7.n {

        /* renamed from: a, reason: collision with root package name */
        public int f3919a;
        public final /* synthetic */ Context b;

        @J7.c(c = "com.stepos.policy.sdk.PolicyManager$persistCloudPolicyUidCategoryMap$1$1", f = "PolicyManager.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/datastore/preferences/core/MutablePreferences;", "prefs", "LC7/r;", "<anonymous>", "(Landroidx/datastore/preferences/core/MutablePreferences;)V"}, k = 3, mv = {1, 8, 0})
        /* renamed from: com.stepos.policy.sdk.PolicyManager$persistCloudPolicyUidCategoryMap$1$1, reason: invalid class name and collision with other inner class name */
        final class C01521 extends SuspendLambda implements S7.n {

            /* renamed from: a, reason: collision with root package name */
            public /* synthetic */ Object f3920a;
            public final /* synthetic */ String b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01521(String str, H7.c cVar) {
                super(2, cVar);
                this.b = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c create(Object obj, H7.c cVar) {
                C01521 c01521 = new C01521(this.b, cVar);
                c01521.f3920a = obj;
                return c01521;
            }

            @Override // S7.n
            public final Object invoke(Object obj, Object obj2) {
                C01521 c01521 = (C01521) create((MutablePreferences) obj, (H7.c) obj2);
                r rVar = r.f317a;
                c01521.invokeSuspend(rVar);
                return rVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                kotlin.b.b(obj);
                MutablePreferences mutablePreferences = (MutablePreferences) this.f3920a;
                Preferences.Key key = m.h;
                String json = this.b;
                kotlin.jvm.internal.k.e(json, "json");
                mutablePreferences.set(key, json);
                return r.f317a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11331(Context context, H7.c cVar) {
            super(2, cVar);
            this.b = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c create(Object obj, H7.c cVar) {
            return new C11331(this.b, cVar);
        }

        @Override // S7.n
        public final Object invoke(Object obj, Object obj2) {
            return ((C11331) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.f3919a;
            try {
                if (i == 0) {
                    kotlin.b.b(obj);
                    String json = new Gson().toJson(PolicyCloudPolicyIndex.snapshot());
                    DataStore dataStoreA = m.a(this.b);
                    C01521 c01521 = new C01521(json, null);
                    this.f3919a = 1;
                    if (PreferencesKt.edit(dataStoreA, c01521, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    kotlin.b.b(obj);
                }
            } catch (Exception e) {
                PolicySdkLogUtils.INSTANCE.e("CloudPolicyIndex", "persist failed: " + e);
            }
            return r.f317a;
        }
    }

    @J7.c(c = "com.stepos.policy.sdk.PolicyManager$reTryUploadRecord$1", f = "PolicyManager.kt", l = {1130, 1133}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: com.stepos.policy.sdk.PolicyManager$reTryUploadRecord$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11341 extends SuspendLambda implements S7.n {

        /* renamed from: a, reason: collision with root package name */
        public int f3921a;
        public int b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ PolicyManager d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11341(PolicyManager policyManager, Context context, H7.c cVar) {
            super(2, cVar);
            this.c = context;
            this.d = policyManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c create(Object obj, H7.c cVar) {
            return new C11341(this.d, this.c, cVar);
        }

        @Override // S7.n
        public final Object invoke(Object obj, Object obj2) {
            return ((C11341) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x007c  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
                int r1 = r9.b
                java.lang.String r2 = "isNeedReTry= "
                java.lang.String r3 = "reTryUploadRecord"
                r4 = 2
                android.content.Context r5 = r9.c
                r6 = 1
                if (r1 == 0) goto L24
                if (r1 == r6) goto L20
                if (r1 != r4) goto L18
                int r0 = r9.f3921a
                kotlin.b.b(r10)
                goto L5b
            L18:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r10)
                throw r9
            L20:
                kotlin.b.b(r10)
                goto L32
            L24:
                kotlin.b.b(r10)
                com.stepos.policy.sdk.PolicyManager r10 = com.stepos.policy.sdk.PolicyManager.INSTANCE
                r9.b = r6
                java.lang.Object r10 = r10.getPolicyOperate(r5, r9)
                if (r10 != r0) goto L32
                goto L59
            L32:
                java.lang.Boolean r10 = (java.lang.Boolean) r10
                boolean r10 = r10.booleanValue()
                r1 = r10 ^ 1
                com.stepos.policy.sdk.util.PolicySdkLogUtils$Companion r7 = com.stepos.policy.sdk.util.PolicySdkLogUtils.INSTANCE
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                r8.<init>(r2)
                r8.append(r1)
                java.lang.String r8 = r8.toString()
                r7.d(r3, r8)
                if (r10 != 0) goto La4
                com.stepos.policy.sdk.PolicyManager r10 = com.stepos.policy.sdk.PolicyManager.INSTANCE
                r9.f3921a = r1
                r9.b = r4
                java.lang.Object r10 = r10.getPolicyOperateJson(r5, r9)
                if (r10 != r0) goto L5a
            L59:
                return r0
            L5a:
                r0 = r1
            L5b:
                java.lang.String r10 = (java.lang.String) r10
                if (r10 == 0) goto La4
                int r1 = r10.length()
                if (r1 <= 0) goto La4
                com.google.gson.Gson r1 = new com.google.gson.Gson
                r1.<init>()
                java.lang.Class<com.stepos.policy.sdk.bean.PolicyRecordRequest> r4 = com.stepos.policy.sdk.bean.PolicyRecordRequest.class
                java.lang.Object r10 = r1.fromJson(r10, r4)
                com.stepos.policy.sdk.bean.PolicyRecordRequest r10 = (com.stepos.policy.sdk.bean.PolicyRecordRequest) r10
                com.stepos.policy.sdk.util.PolicySdkLogUtils$Companion r1 = com.stepos.policy.sdk.util.PolicySdkLogUtils.INSTANCE
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>(r2)
                if (r0 == 0) goto L7c
                goto L7d
            L7c:
                r6 = 0
            L7d:
                r4.append(r6)
                java.lang.String r0 = r4.toString()
                r1.d(r3, r0)
                com.stepos.policy.sdk.PolicyManager r0 = com.stepos.policy.sdk.PolicyManager.INSTANCE
                java.lang.String r1 = r0.getMAppId()
                java.lang.String r2 = r0.getMAppSecret()
                java.lang.String r0 = r0.getMAppVersionName()
                java.lang.String r3 = "policyRecordRequest"
                kotlin.jvm.internal.k.e(r10, r3)
                com.stepos.policy.sdk.PolicyManager$reTryUploadRecord$1$1 r3 = new com.stepos.policy.sdk.PolicyManager$reTryUploadRecord$1$1
                com.stepos.policy.sdk.PolicyManager r9 = r9.d
                r3.<init>()
                com.stepos.policy.sdk.PolicyManager.uploadPolicyOperateRecord(r1, r2, r0, r10, r3)
            La4:
                C7.r r9 = C7.r.f317a
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.C11341.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @J7.c(c = "com.stepos.policy.sdk.PolicyManager$saveAgreeStatus$1", f = "PolicyManager.kt", l = {379}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: com.stepos.policy.sdk.PolicyManager$saveAgreeStatus$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11351 extends SuspendLambda implements S7.n {

        /* renamed from: a, reason: collision with root package name */
        public int f3924a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ int c;

        @J7.c(c = "com.stepos.policy.sdk.PolicyManager$saveAgreeStatus$1$1", f = "PolicyManager.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/datastore/preferences/core/MutablePreferences;", "policy_sdk_data", "LC7/r;", "<anonymous>", "(Landroidx/datastore/preferences/core/MutablePreferences;)V"}, k = 3, mv = {1, 8, 0})
        /* renamed from: com.stepos.policy.sdk.PolicyManager$saveAgreeStatus$1$1, reason: invalid class name and collision with other inner class name */
        final class C01551 extends SuspendLambda implements S7.n {

            /* renamed from: a, reason: collision with root package name */
            public /* synthetic */ Object f3925a;
            public final /* synthetic */ int b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01551(int i, H7.c cVar) {
                super(2, cVar);
                this.b = i;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c create(Object obj, H7.c cVar) {
                C01551 c01551 = new C01551(this.b, cVar);
                c01551.f3925a = obj;
                return c01551;
            }

            @Override // S7.n
            public final Object invoke(Object obj, Object obj2) {
                C01551 c01551 = (C01551) create((MutablePreferences) obj, (H7.c) obj2);
                r rVar = r.f317a;
                c01551.invokeSuspend(rVar);
                return rVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                kotlin.b.b(obj);
                ((MutablePreferences) this.f3925a).set(m.f, new Integer(this.b));
                return r.f317a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11351(Context context, int i, H7.c cVar) {
            super(2, cVar);
            this.b = context;
            this.c = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c create(Object obj, H7.c cVar) {
            return new C11351(this.b, this.c, cVar);
        }

        @Override // S7.n
        public final Object invoke(Object obj, Object obj2) {
            return ((C11351) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.f3924a;
            try {
                if (i == 0) {
                    kotlin.b.b(obj);
                    DataStore dataStoreA = m.a(this.b);
                    C01551 c01551 = new C01551(this.c, null);
                    this.f3924a = 1;
                    if (PreferencesKt.edit(dataStoreA, c01551, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    kotlin.b.b(obj);
                }
            } catch (Exception e) {
                PolicySdkLogUtils.INSTANCE.e("savePolicyCategoryVersion", "error =" + e + ' ');
            }
            return r.f317a;
        }
    }

    @J7.c(c = "com.stepos.policy.sdk.PolicyManager$saveDataStoreString$2", f = "PolicyManager.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/datastore/preferences/core/MutablePreferences;", "policy_sdk_data", "LC7/r;", "<anonymous>", "(Landroidx/datastore/preferences/core/MutablePreferences;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: com.stepos.policy.sdk.PolicyManager$saveDataStoreString$2, reason: invalid class name and case insensitive filesystem */
    public static final class C11362 extends SuspendLambda implements S7.n {

        /* renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f3926a;
        public final /* synthetic */ Preferences.Key b;
        public final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11362(Preferences.Key key, String str, H7.c cVar) {
            super(2, cVar);
            this.b = key;
            this.c = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c create(Object obj, H7.c cVar) {
            C11362 c11362 = new C11362(this.b, this.c, cVar);
            c11362.f3926a = obj;
            return c11362;
        }

        @Override // S7.n
        public final Object invoke(Object obj, Object obj2) {
            C11362 c11362 = (C11362) create((MutablePreferences) obj, (H7.c) obj2);
            r rVar = r.f317a;
            c11362.invokeSuspend(rVar);
            return rVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            kotlin.b.b(obj);
            MutablePreferences mutablePreferences = (MutablePreferences) this.f3926a;
            String str = this.c;
            if (str == null) {
                str = "";
            }
            mutablePreferences.set(this.b, str);
            return r.f317a;
        }
    }

    @J7.c(c = "com.stepos.policy.sdk.PolicyManager$saveLocalCategoryMd5$1", f = "PolicyManager.kt", l = {2562}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: com.stepos.policy.sdk.PolicyManager$saveLocalCategoryMd5$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11371 extends SuspendLambda implements S7.n {

        /* renamed from: a, reason: collision with root package name */
        public int f3927a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Context d;

        @J7.c(c = "com.stepos.policy.sdk.PolicyManager$saveLocalCategoryMd5$1$1", f = "PolicyManager.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/datastore/preferences/core/MutablePreferences;", "policy_sdk_data", "LC7/r;", "<anonymous>", "(Landroidx/datastore/preferences/core/MutablePreferences;)V"}, k = 3, mv = {1, 8, 0})
        /* renamed from: com.stepos.policy.sdk.PolicyManager$saveLocalCategoryMd5$1$1, reason: invalid class name and collision with other inner class name */
        final class C01561 extends SuspendLambda implements S7.n {

            /* renamed from: a, reason: collision with root package name */
            public /* synthetic */ Object f3928a;
            public final /* synthetic */ String b;
            public final /* synthetic */ String c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01561(String str, String str2, H7.c cVar) {
                super(2, cVar);
                this.b = str;
                this.c = str2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c create(Object obj, H7.c cVar) {
                C01561 c01561 = new C01561(this.b, this.c, cVar);
                c01561.f3928a = obj;
                return c01561;
            }

            @Override // S7.n
            public final Object invoke(Object obj, Object obj2) {
                C01561 c01561 = (C01561) create((MutablePreferences) obj, (H7.c) obj2);
                r rVar = r.f317a;
                c01561.invokeSuspend(rVar);
                return rVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                kotlin.b.b(obj);
                ((MutablePreferences) this.f3928a).set(PreferencesKeys.stringKey("local_" + this.b), this.c);
                return r.f317a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11371(Context context, String str, String str2, H7.c cVar) {
            super(2, cVar);
            this.b = str;
            this.c = str2;
            this.d = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c create(Object obj, H7.c cVar) {
            return new C11371(this.d, this.b, this.c, cVar);
        }

        @Override // S7.n
        public final Object invoke(Object obj, Object obj2) {
            return ((C11371) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.f3927a;
            try {
            } catch (Exception e) {
                PolicySdkLogUtils.INSTANCE.e("saveLocalCategoryMd5", "error =" + e + ' ');
            }
            if (i == 0) {
                kotlin.b.b(obj);
                PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.INSTANCE;
                String str = this.b;
                String str2 = this.c;
                companion.d("saveLocalCategoryMd5", B7.a.n("the ", str, " save local md5 is ", str2));
                if (str2 != null) {
                    if (str2.length() != 0) {
                        DataStore dataStoreA = m.a(this.d);
                        C01561 c01561 = new C01561(str, str2, null);
                        this.f3927a = 1;
                        if (PreferencesKt.edit(dataStoreA, c01561, this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                }
                return r.f317a;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
            return r.f317a;
        }
    }

    @J7.c(c = "com.stepos.policy.sdk.PolicyManager", f = "PolicyManager.kt", l = {312, TypedValues.AttributesType.TYPE_PATH_ROTATE}, m = "savePolicyOperate")
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: com.stepos.policy.sdk.PolicyManager$savePolicyOperate$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11381 extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public Context f3929a;
        public String b;
        public boolean c;
        public /* synthetic */ Object d;
        public int f;

        public C11381(H7.c cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            return PolicyManager.this.savePolicyOperate(null, false, null, this);
        }
    }

    @J7.c(c = "com.stepos.policy.sdk.PolicyManager$savePolicyOperate$2", f = "PolicyManager.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/datastore/preferences/core/MutablePreferences;", "policy_sdk_data", "LC7/r;", "<anonymous>", "(Landroidx/datastore/preferences/core/MutablePreferences;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: com.stepos.policy.sdk.PolicyManager$savePolicyOperate$2, reason: invalid class name and case insensitive filesystem */
    public static final class C11392 extends SuspendLambda implements S7.n {

        /* renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f3930a;
        public final /* synthetic */ boolean b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11392(boolean z10, H7.c cVar) {
            super(2, cVar);
            this.b = z10;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c create(Object obj, H7.c cVar) {
            C11392 c11392 = new C11392(this.b, cVar);
            c11392.f3930a = obj;
            return c11392;
        }

        @Override // S7.n
        public final Object invoke(Object obj, Object obj2) {
            C11392 c11392 = (C11392) create((MutablePreferences) obj, (H7.c) obj2);
            r rVar = r.f317a;
            c11392.invokeSuspend(rVar);
            return rVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            kotlin.b.b(obj);
            ((MutablePreferences) this.f3930a).set(m.c, Boolean.valueOf(this.b));
            return r.f317a;
        }
    }

    @J7.c(c = "com.stepos.policy.sdk.PolicyManager$savePolicyOperate$3", f = "PolicyManager.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/datastore/preferences/core/MutablePreferences;", "policy_sdk_data", "LC7/r;", "<anonymous>", "(Landroidx/datastore/preferences/core/MutablePreferences;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: com.stepos.policy.sdk.PolicyManager$savePolicyOperate$3, reason: invalid class name */
    public static final class AnonymousClass3 extends SuspendLambda implements S7.n {

        /* renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f3931a;
        public final /* synthetic */ String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(String str, H7.c cVar) {
            super(2, cVar);
            this.b = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c create(Object obj, H7.c cVar) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.b, cVar);
            anonymousClass3.f3931a = obj;
            return anonymousClass3;
        }

        @Override // S7.n
        public final Object invoke(Object obj, Object obj2) {
            AnonymousClass3 anonymousClass3 = (AnonymousClass3) create((MutablePreferences) obj, (H7.c) obj2);
            r rVar = r.f317a;
            anonymousClass3.invokeSuspend(rVar);
            return rVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            kotlin.b.b(obj);
            MutablePreferences mutablePreferences = (MutablePreferences) this.f3931a;
            Preferences.Key key = m.d;
            String str = this.b;
            if (str == null) {
                str = "";
            }
            mutablePreferences.set(key, str);
            return r.f317a;
        }
    }

    @J7.c(c = "com.stepos.policy.sdk.PolicyManager$saveReadClipboardStatus$1", f = "PolicyManager.kt", l = {348}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: com.stepos.policy.sdk.PolicyManager$saveReadClipboardStatus$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11401 extends SuspendLambda implements S7.n {

        /* renamed from: a, reason: collision with root package name */
        public int f3932a;
        public final /* synthetic */ Context b;

        @J7.c(c = "com.stepos.policy.sdk.PolicyManager$saveReadClipboardStatus$1$1", f = "PolicyManager.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/datastore/preferences/core/MutablePreferences;", "policy_sdk_data", "LC7/r;", "<anonymous>", "(Landroidx/datastore/preferences/core/MutablePreferences;)V"}, k = 3, mv = {1, 8, 0})
        /* renamed from: com.stepos.policy.sdk.PolicyManager$saveReadClipboardStatus$1$1, reason: invalid class name and collision with other inner class name */
        final class C01571 extends SuspendLambda implements S7.n {

            /* renamed from: a, reason: collision with root package name */
            public /* synthetic */ Object f3933a;

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c create(Object obj, H7.c cVar) {
                C01571 c01571 = new C01571(2, cVar);
                c01571.f3933a = obj;
                return c01571;
            }

            @Override // S7.n
            public final Object invoke(Object obj, Object obj2) {
                C01571 c01571 = (C01571) create((MutablePreferences) obj, (H7.c) obj2);
                r rVar = r.f317a;
                c01571.invokeSuspend(rVar);
                return rVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                kotlin.b.b(obj);
                ((MutablePreferences) this.f3933a).set(m.e, new Integer(ReadClipboardUtils.READ_CLIPBOARD_PERMISSION_AGREE));
                return r.f317a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11401(Context context, H7.c cVar) {
            super(2, cVar);
            this.b = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c create(Object obj, H7.c cVar) {
            return new C11401(this.b, cVar);
        }

        @Override // S7.n
        public final Object invoke(Object obj, Object obj2) {
            return ((C11401) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.f3932a;
            try {
                if (i == 0) {
                    kotlin.b.b(obj);
                    DataStore dataStoreA = m.a(this.b);
                    C01571 c01571 = new C01571(2, null);
                    this.f3932a = 1;
                    if (PreferencesKt.edit(dataStoreA, c01571, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    kotlin.b.b(obj);
                }
            } catch (Exception e) {
                PolicySdkLogUtils.INSTANCE.e("savePolicyCategoryVersion", "error =" + e + ' ');
            }
            return r.f317a;
        }
    }

    @J7.c(c = "com.stepos.policy.sdk.PolicyManager$uploadPolicyOperateRecord$1", f = "PolicyManager.kt", l = {TypedValues.PositionType.TYPE_PERCENT_Y}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: com.stepos.policy.sdk.PolicyManager$uploadPolicyOperateRecord$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11411 extends SuspendLambda implements S7.n {

        /* renamed from: a, reason: collision with root package name */
        public PolicySdkResultBean f3934a;
        public int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ PolicyRecordRequest e;
        public final /* synthetic */ S7.k f;
        public final /* synthetic */ String g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11411(String str, String str2, PolicyRecordRequest policyRecordRequest, S7.k kVar, String str3, H7.c cVar) {
            super(2, cVar);
            this.c = str;
            this.d = str2;
            this.e = policyRecordRequest;
            this.f = kVar;
            this.g = str3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c create(Object obj, H7.c cVar) {
            return new C11411(this.c, this.d, this.e, this.f, this.g, cVar);
        }

        @Override // S7.n
        public final Object invoke(Object obj, Object obj2) {
            return ((C11411) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0096 A[Catch: Exception -> 0x00d8, TryCatch #5 {Exception -> 0x00d8, blocks: (B:28:0x0079, B:30:0x0096, B:32:0x00c9, B:34:0x00d1, B:38:0x00dc), top: B:73:0x0079 }] */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00eb A[Catch: Exception -> 0x00e9, TRY_LEAVE, TryCatch #4 {Exception -> 0x00e9, blocks: (B:40:0x00e4, B:43:0x00eb), top: B:71:0x0094 }] */
        /* JADX WARN: Type inference failed for: r3v11 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r19) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 318
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.C11411.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @J7.c(c = "com.stepos.policy.sdk.PolicyManager$uploadRecordToCleanServiceData$1", f = "PolicyManager.kt", l = {1280}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: com.stepos.policy.sdk.PolicyManager$uploadRecordToCleanServiceData$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11431 extends SuspendLambda implements S7.n {

        /* renamed from: a, reason: collision with root package name */
        public PolicyRecordRequest f3937a;
        public int b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ String[] d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;
        public final /* synthetic */ String i;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ ArrayList f3938j;
        public final /* synthetic */ String k;
        public final /* synthetic */ String l;
        public final /* synthetic */ String m;
        public final /* synthetic */ S7.k n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11431(Context context, String[] strArr, String str, String str2, String str3, String str4, String str5, ArrayList arrayList, String str6, String str7, String str8, S7.k kVar, H7.c cVar) {
            super(2, cVar);
            this.c = context;
            this.d = strArr;
            this.e = str;
            this.f = str2;
            this.g = str3;
            this.h = str4;
            this.i = str5;
            this.f3938j = arrayList;
            this.k = str6;
            this.l = str7;
            this.m = str8;
            this.n = kVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c create(Object obj, H7.c cVar) {
            return new C11431(this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.f3938j, this.k, this.l, this.m, this.n, cVar);
        }

        @Override // S7.n
        public final Object invoke(Object obj, Object obj2) {
            return ((C11431) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws JsonSyntaxException {
            PolicyRecordRequest policyRecordRequest;
            PolicyRecordRequest policyRecordRequest2;
            ArrayList arrayList;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.b;
            Context context = this.c;
            String str = this.g;
            if (i == 0) {
                kotlin.b.b(obj);
                PolicyRecordRequest policyRecordRequestCreateRecordRequest = PolicyManager.createRecordRequest(context, this.d, this.e, this.f);
                policyRecordRequestCreateRecordRequest.setVerify_type(str);
                policyRecordRequestCreateRecordRequest.setServiceName(this.h);
                policyRecordRequestCreateRecordRequest.setValidateCode(this.i);
                if (!str.equals("0") && (arrayList = this.f3938j) != null && arrayList.size() > 0) {
                    policyRecordRequestCreateRecordRequest.setDeleteInfoList(arrayList);
                }
                if (!str.equals("1") && !str.equals("3")) {
                    policyRecordRequest2 = policyRecordRequestCreateRecordRequest;
                    PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.INSTANCE;
                    StringBuilder sbV = B7.a.v("verifyType ", str, " | policyRecordRequest.deleteInfoList = ");
                    sbV.append(policyRecordRequest2.getDeleteInfoList());
                    companion.d("uploadRecordToCleanServiceData", sbV.toString());
                    PolicyManager.uploadRecordByCustomRecordRequest(context, this.k, this.l, this.m, policyRecordRequest2, this.n);
                    return r.f317a;
                }
                PolicyManager policyManager = PolicyManager.INSTANCE;
                Preferences.Key<String> key = m.g;
                this.f3937a = policyRecordRequestCreateRecordRequest;
                this.b = 1;
                Object dataStoreString = policyManager.getDataStoreString(context, key, this);
                if (dataStoreString == coroutineSingletons) {
                    return coroutineSingletons;
                }
                policyRecordRequest = policyRecordRequestCreateRecordRequest;
                obj = dataStoreString;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                policyRecordRequest = this.f3937a;
                kotlin.b.b(obj);
            }
            String str2 = (String) obj;
            if (str2 != null && !TextUtils.isEmpty(str2)) {
                ArrayList<DeleteInfoBean> deleteInfoBeanByGson = PolicySdkToolsUtils.INSTANCE.getDeleteInfoBeanByGson(str2);
                PolicySdkLogUtils.INSTANCE.d("uploadRecordToCleanServiceData", "commonDeleteInfoList = " + deleteInfoBeanByGson);
                policyRecordRequest.setDeleteInfoList(v.g1(v.Q0(deleteInfoBeanByGson, policyRecordRequest.getDeleteInfoList())));
            }
            policyRecordRequest2 = policyRecordRequest;
            PolicySdkLogUtils.Companion companion2 = PolicySdkLogUtils.INSTANCE;
            StringBuilder sbV2 = B7.a.v("verifyType ", str, " | policyRecordRequest.deleteInfoList = ");
            sbV2.append(policyRecordRequest2.getDeleteInfoList());
            companion2.d("uploadRecordToCleanServiceData", sbV2.toString());
            PolicyManager.uploadRecordByCustomRecordRequest(context, this.k, this.l, this.m, policyRecordRequest2, this.n);
            return r.f317a;
        }
    }

    @J7.c(c = "com.stepos.policy.sdk.PolicyManager$uploadRecordWithoutSecureService$1", f = "PolicyManager.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: com.stepos.policy.sdk.PolicyManager$uploadRecordWithoutSecureService$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11441 extends SuspendLambda implements S7.n {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f3939a;
        public final /* synthetic */ String[] b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ ArrayList h;
        public final /* synthetic */ String i;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ String f3940j;
        public final /* synthetic */ String k;
        public final /* synthetic */ S7.k l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11441(Context context, String[] strArr, String str, String str2, String str3, String str4, String str5, ArrayList arrayList, String str6, String str7, String str8, S7.k kVar, H7.c cVar) {
            super(2, cVar);
            this.f3939a = context;
            this.b = strArr;
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = str4;
            this.g = str5;
            this.h = arrayList;
            this.i = str6;
            this.f3940j = str7;
            this.k = str8;
            this.l = kVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c create(Object obj, H7.c cVar) {
            return new C11441(this.f3939a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.f3940j, this.k, this.l, cVar);
        }

        @Override // S7.n
        public final Object invoke(Object obj, Object obj2) {
            C11441 c11441 = (C11441) create((InterfaceC1733z) obj, (H7.c) obj2);
            r rVar = r.f317a;
            c11441.invokeSuspend(rVar);
            return rVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ArrayList arrayList;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            kotlin.b.b(obj);
            PolicyRecordRequest policyRecordRequestCreateRecordRequest = PolicyManager.createRecordRequest(this.f3939a, this.b, this.c, this.d);
            String str = this.e;
            policyRecordRequestCreateRecordRequest.setVerify_type(str);
            policyRecordRequestCreateRecordRequest.setServiceName(this.f);
            policyRecordRequestCreateRecordRequest.setValidateCode(this.g);
            if (!kotlin.jvm.internal.k.b(str, "0") && (arrayList = this.h) != null && arrayList.size() > 0) {
                policyRecordRequestCreateRecordRequest.setDeleteInfoList(arrayList);
            }
            PolicySdkLogUtils.INSTANCE.d("uploadRecordToCleanServiceData", "verifyType " + str + " | policyRecordRequest.deleteInfoList = " + policyRecordRequestCreateRecordRequest.getDeleteInfoList());
            PolicyManager.uploadRecordByCustomRecordRequest(this.f3939a, this.i, this.f3940j, this.k, policyRecordRequestCreateRecordRequest, this.l);
            return r.f317a;
        }
    }

    static {
        r0 r0VarC = AbstractC1683A.c();
        u9.d dVar = AbstractC1691I.f5315a;
        lifecycleScope = new C1923c(z2.l.H(r0VarC, s9.k.f6003a));
        mAppId = "";
        mAppSecret = "";
        mAppVersionName = "";
        customPolicyCSSFileName = "";
        localAssetsCategoryPathMap = new HashMap<>();
        scope = AbstractC1683A.b(z2.l.H(AbstractC1683A.c(), u9.c.f6743a));
        String channelToBrand = PolicySdkToolsUtils.INSTANCE.getChannelToBrand();
        companyCode = channelToBrand;
        brand = channelToBrand;
        model = "";
        osVersion = "";
        exceptionHandler = new com.stepos.ability.service.b(C1730w.f5337a, 1);
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

    public static final void autoUploadRecord(final Context context, String appId, String appSecret, String versionName, String[] categoryList, String userId, String operationType) {
        kotlin.jvm.internal.k.f(context, "context");
        kotlin.jvm.internal.k.f(appId, "appId");
        kotlin.jvm.internal.k.f(appSecret, "appSecret");
        kotlin.jvm.internal.k.f(versionName, "versionName");
        kotlin.jvm.internal.k.f(categoryList, "categoryList");
        kotlin.jvm.internal.k.f(operationType, "operationType");
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.f4920a = createRecordRequest(context, categoryList, userId, operationType);
        if (PolicySdkNetworkUtil.isNetworkAvailable(context)) {
            uploadPolicyOperateRecord(appId, appSecret, versionName, (PolicyRecordRequest) ref$ObjectRef.f4920a, new S7.k() { // from class: com.stepos.policy.sdk.PolicyManager.autoUploadRecord.1

                @J7.c(c = "com.stepos.policy.sdk.PolicyManager$autoUploadRecord$1$1", f = "PolicyManager.kt", l = {1341}, m = "invokeSuspend")
                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
                /* renamed from: com.stepos.policy.sdk.PolicyManager$autoUploadRecord$1$1, reason: invalid class name and collision with other inner class name */
                final class C01501 extends SuspendLambda implements S7.n {

                    /* renamed from: a, reason: collision with root package name */
                    public int f3891a;
                    public final /* synthetic */ PolicySdkResultBean b;
                    public final /* synthetic */ Ref$ObjectRef c;
                    public final /* synthetic */ Context d;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public C01501(PolicySdkResultBean policySdkResultBean, Ref$ObjectRef ref$ObjectRef, Context context, H7.c cVar) {
                        super(2, cVar);
                        this.b = policySdkResultBean;
                        this.c = ref$ObjectRef;
                        this.d = context;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final H7.c create(Object obj, H7.c cVar) {
                        return new C01501(this.b, this.c, this.d, cVar);
                    }

                    @Override // S7.n
                    public final Object invoke(Object obj, Object obj2) {
                        return ((C01501) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        String json;
                        boolean z10;
                        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                        int i = this.f3891a;
                        if (i == 0) {
                            kotlin.b.b(obj);
                            PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.INSTANCE;
                            StringBuilder sb = new StringBuilder("policySdkResultBean.code ");
                            PolicySdkResultBean policySdkResultBean = this.b;
                            sb.append(policySdkResultBean.getCode());
                            companion.d("autoUploadRecord", sb.toString());
                            if (policySdkResultBean.getCode() == 0) {
                                json = "";
                                z10 = true;
                            } else {
                                json = new Gson().toJson(this.c.f4920a);
                                kotlin.jvm.internal.k.e(json, "gson.toJson(policyRecordRequest)");
                                z10 = false;
                            }
                            companion.d("autoUploadRecord", "isOperateSuccess " + z10);
                            PolicyManager policyManager = PolicyManager.INSTANCE;
                            this.f3891a = 1;
                            if (policyManager.savePolicyOperate(this.d, z10, json, this) == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            kotlin.b.b(obj);
                        }
                        return r.f317a;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // S7.k
                public final Object invoke(Object obj) {
                    PolicySdkResultBean policySdkResultBean = (PolicySdkResultBean) obj;
                    kotlin.jvm.internal.k.f(policySdkResultBean, "policySdkResultBean");
                    AbstractC1683A.n(C1704W.f5321a, PolicyManager.INSTANCE.getExceptionHandler(), new C01501(policySdkResultBean, ref$ObjectRef, context, null), 2);
                    return r.f317a;
                }
            });
            return;
        }
        AbstractC1683A.n(C1704W.f5321a, exceptionHandler, new AnonymousClass2(ref$ObjectRef, context, null), 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x004a -> B:22:0x004d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object awaitSyncLocalFileFinished(H7.c<? super C7.r> r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof com.stepos.policy.sdk.PolicyManager.C11151
            if (r0 == 0) goto L13
            r0 = r10
            com.stepos.policy.sdk.PolicyManager$awaitSyncLocalFileFinished$1 r0 = (com.stepos.policy.sdk.PolicyManager.C11151) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            com.stepos.policy.sdk.PolicyManager$awaitSyncLocalFileFinished$1 r0 = new com.stepos.policy.sdk.PolicyManager$awaitSyncLocalFileFinished$1
            r0.<init>(r10)
        L18:
            java.lang.Object r9 = r0.b
            kotlin.coroutines.intrinsics.CoroutineSingletons r10 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r0.d
            r2 = 200(0xc8, double:9.9E-322)
            r4 = 1
            if (r1 == 0) goto L33
            if (r1 != r4) goto L2b
            long r5 = r0.f3893a
            kotlin.b.b(r9)
            goto L4d
        L2b:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L33:
            kotlin.b.b(r9)
            r5 = 0
        L38:
            boolean r9 = com.stepos.policy.sdk.PolicyManager.syncLocalFileFinished
            if (r9 != 0) goto L4f
            r7 = 10000(0x2710, double:4.9407E-320)
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 >= 0) goto L4f
            r0.f3893a = r5
            r0.d = r4
            java.lang.Object r9 = kotlinx.coroutines.a.f(r2, r0)
            if (r9 != r10) goto L4d
            return r10
        L4d:
            long r5 = r5 + r2
            goto L38
        L4f:
            C7.r r9 = C7.r.f317a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.awaitSyncLocalFileFinished(H7.c):java.lang.Object");
    }

    public static final void checkNewestPolicy(Context context, boolean isAutoRecord, String appId, String appSecret, String language, String category, String versionName, S7.k callBackPolicyResult) {
        kotlin.jvm.internal.k.f(context, "context");
        kotlin.jvm.internal.k.f(appId, "appId");
        kotlin.jvm.internal.k.f(appSecret, "appSecret");
        kotlin.jvm.internal.k.f(language, "language");
        kotlin.jvm.internal.k.f(category, "category");
        kotlin.jvm.internal.k.f(versionName, "versionName");
        kotlin.jvm.internal.k.f(callBackPolicyResult, "callBackPolicyResult");
        AbstractC1683A.n(C1704W.f5321a, exceptionHandler, new C11161(context, category, language, isAutoRecord, appId, appSecret, versionName, callBackPolicyResult, null), 2);
    }

    public static final String copyPolicyFile(Context context, String category, String toPath) {
        kotlin.jvm.internal.k.f(context, "context");
        kotlin.jvm.internal.k.f(category, "category");
        kotlin.jvm.internal.k.f(toPath, "toPath");
        PolicySdkFileUtils.Companion companion = PolicySdkFileUtils.INSTANCE;
        PolicyNewestPathResultBean policyNewestPathResultBeanIsNewestPolicyFileIsExists = companion.isNewestPolicyFileIsExists(context, category);
        PolicySdkLogUtils.Companion companion2 = PolicySdkLogUtils.INSTANCE;
        companion2.d("copyPolicyFile", "policyNewestPathResultBean.isExists = " + policyNewestPathResultBeanIsNewestPolicyFileIsExists.getIsExists());
        String strCopyPolicyFile = policyNewestPathResultBeanIsNewestPolicyFileIsExists.getIsExists() ? companion.copyPolicyFile(policyNewestPathResultBeanIsNewestPolicyFileIsExists.getNewestPolicyPath(), toPath) : "";
        companion2.d("copyPolicyFile", "successPath = " + strCopyPolicyFile);
        return strCopyPolicyFile;
    }

    private final S createReGrantDialogBuilder(Context context, boolean methodType, boolean secondaryConfirmation, String title, String privacyPolicyName, String category, P permissionDialogClickListener) {
        S s5 = new S(context);
        s5.m = privacyPolicyName;
        s5.c = title;
        s5.f6235j = permissionDialogClickListener;
        s5.l = secondaryConfirmation;
        s5.f = new a(context, methodType, privacyPolicyName, category, 0);
        return s5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createReGrantDialogBuilder$lambda$8(Context context, boolean z10, String privacyPolicyName, String category, View view) {
        kotlin.jvm.internal.k.f(context, "$context");
        kotlin.jvm.internal.k.f(privacyPolicyName, "$privacyPolicyName");
        kotlin.jvm.internal.k.f(category, "$category");
        openPolicyMethod(context, z10, privacyPolicyName, category);
    }

    public static final PolicyRecordRequest createRecordRequest(Context context, String[] categoryList, String userId, String operationType) {
        kotlin.jvm.internal.k.f(context, "context");
        kotlin.jvm.internal.k.f(categoryList, "categoryList");
        kotlin.jvm.internal.k.f(operationType, "operationType");
        String androidId = Settings.System.getString(context.getContentResolver(), "android_id");
        PolicyRecordRequest policyRecordRequest = new PolicyRecordRequest();
        kotlin.jvm.internal.k.e(androidId, "androidId");
        policyRecordRequest.setBusinessId(androidId);
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

    public static final void encryptCustomDeleteInfoListBySecure(Context context, final ArrayList<CustomDeleteInfoBean> customDeleteInfoList, final S7.k callBackPolicyResult) {
        kotlin.jvm.internal.k.f(context, "context");
        kotlin.jvm.internal.k.f(customDeleteInfoList, "customDeleteInfoList");
        kotlin.jvm.internal.k.f(callBackPolicyResult, "callBackPolicyResult");
        final ArrayList arrayList = new ArrayList();
        WithdrawalManager.INSTANCE.encryptCustomDeleteInfoListBySecure(context, customDeleteInfoList, new S7.k() { // from class: com.stepos.policy.sdk.PolicyManager.encryptCustomDeleteInfoListBySecure.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public final Object invoke(Object obj) {
                DeleteInfoBean deleteInfoBean = (DeleteInfoBean) obj;
                kotlin.jvm.internal.k.f(deleteInfoBean, "deleteInfoBean");
                PolicyManager policyManager = PolicyManager.INSTANCE;
                ArrayList arrayList2 = arrayList;
                arrayList2.add(deleteInfoBean);
                if (arrayList2.size() == customDeleteInfoList.size()) {
                    callBackPolicyResult.invoke(arrayList2);
                }
                return r.f317a;
            }
        });
    }

    public static final ArrayList<DeleteInfoBean> encryptDeleteInfoWithoutSecureService(Context context, ArrayList<DeleteInfoEncryptMultiBean> customDeleteInfoList) {
        kotlin.jvm.internal.k.f(context, "context");
        kotlin.jvm.internal.k.f(customDeleteInfoList, "customDeleteInfoList");
        return WithdrawalManagerWithoutSecureService.INSTANCE.getEncryptByDeleteInfoList(context, customDeleteInfoList);
    }

    public static final void encryptMultiDeleteListBySecure(Context context, final ArrayList<DeleteInfoEncryptMultiBean> customDeleteInfoList, final S7.k callBackPolicyResult) {
        kotlin.jvm.internal.k.f(context, "context");
        kotlin.jvm.internal.k.f(customDeleteInfoList, "customDeleteInfoList");
        kotlin.jvm.internal.k.f(callBackPolicyResult, "callBackPolicyResult");
        final ArrayList arrayList = new ArrayList();
        WithdrawalManager.INSTANCE.encryptMultiCustomDeleteInfoListBySecure(context, customDeleteInfoList, new S7.k() { // from class: com.stepos.policy.sdk.PolicyManager.encryptMultiDeleteListBySecure.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public final Object invoke(Object obj) {
                DeleteInfoBean deleteInfoBean = (DeleteInfoBean) obj;
                kotlin.jvm.internal.k.f(deleteInfoBean, "deleteInfoBean");
                PolicyManager policyManager = PolicyManager.INSTANCE;
                ArrayList arrayList2 = arrayList;
                arrayList2.add(deleteInfoBean);
                if (arrayList2.size() == customDeleteInfoList.size()) {
                    callBackPolicyResult.invoke(arrayList2);
                }
                return r.f317a;
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
            kotlin.jvm.internal.k.e(alternateContext, "alternateContext");
            PolicyNewestPathResultBean policyNewestPathResultBeanIsNewestPolicyFileIsExists2 = companion.isNewestPolicyFileIsExists(alternateContext, category);
            if (policyNewestPathResultBeanIsNewestPolicyFileIsExists2.getIsExists()) {
                PolicySdkLogUtils.INSTANCE.d("PolicyManager", "findNewestPolicyFile fallback hit: " + policyNewestPathResultBeanIsNewestPolicyFileIsExists2.getNewestPolicyPath());
                return policyNewestPathResultBeanIsNewestPolicyFileIsExists2;
            }
        }
        return policyNewestPathResultBeanIsNewestPolicyFileIsExists;
    }

    public static final void getCommonDeleteInfoList(Context mContext, String businessType, int deleteType) {
        kotlin.jvm.internal.k.f(mContext, "mContext");
        kotlin.jvm.internal.k.f(businessType, "businessType");
        final Context context = (Context) new WeakReference(mContext.getApplicationContext()).get();
        WithdrawalManager.INSTANCE.getCommonDeleteInfoListBySecure(mContext, businessType, deleteType, new S7.k() { // from class: com.stepos.policy.sdk.PolicyManager.getCommonDeleteInfoList.1

            @J7.c(c = "com.stepos.policy.sdk.PolicyManager$getCommonDeleteInfoList$1$1", f = "PolicyManager.kt", l = {2436}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
            /* renamed from: com.stepos.policy.sdk.PolicyManager$getCommonDeleteInfoList$1$1, reason: invalid class name and collision with other inner class name */
            final class C01511 extends SuspendLambda implements S7.n {

                /* renamed from: a, reason: collision with root package name */
                public int f3901a;
                public final /* synthetic */ String b;
                public final /* synthetic */ Context c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C01511(String str, Context context, H7.c cVar) {
                    super(2, cVar);
                    this.b = str;
                    this.c = context;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final H7.c create(Object obj, H7.c cVar) {
                    return new C01511(this.b, this.c, cVar);
                }

                @Override // S7.n
                public final Object invoke(Object obj, Object obj2) {
                    return ((C01511) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                    int i = this.f3901a;
                    if (i == 0) {
                        kotlin.b.b(obj);
                        PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.INSTANCE;
                        StringBuilder sb = new StringBuilder("result = ");
                        String str = this.b;
                        sb.append(str);
                        companion.d("getCommonDeleteInfoList", sb.toString());
                        Context context = this.c;
                        if (context != null) {
                            PolicyManager policyManager = PolicyManager.INSTANCE;
                            Preferences.Key key = m.g;
                            this.f3901a = 1;
                            if (policyManager.saveDataStoreString(context, key, str, this) == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        kotlin.b.b(obj);
                    }
                    return r.f317a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public final Object invoke(Object obj) {
                String deleteInfoListJson = (String) obj;
                kotlin.jvm.internal.k.f(deleteInfoListJson, "deleteInfoListJson");
                PolicyManager policyManager = PolicyManager.INSTANCE;
                AbstractC1683A.n(policyManager.getLifecycleScope(), policyManager.getExceptionHandler(), new C01511(deleteInfoListJson, context, null), 2);
                return r.f317a;
            }
        });
    }

    private final String getLocalCategoryMd5(Context context, String category) {
        return (String) AbstractC1683A.r(EmptyCoroutineContext.f4908a, new C11211(context, category, null));
    }

    public static final void getPolicyByVersion(String appId, String appSecret, String language, Long versionId, String versionName, S7.k callBackPolicyResult) {
        kotlin.jvm.internal.k.f(appId, "appId");
        kotlin.jvm.internal.k.f(appSecret, "appSecret");
        kotlin.jvm.internal.k.f(language, "language");
        kotlin.jvm.internal.k.f(callBackPolicyResult, "callBackPolicyResult");
        AbstractC1683A.n(C1704W.f5321a, exceptionHandler, new C11221(versionId, versionName, appId, appSecret, callBackPolicyResult, language, null), 2);
    }

    public static final void getPolicyData(String appId, String appSecret, String language, String category, Long version, String versionName, S7.k callBackPolicyResult) {
        kotlin.jvm.internal.k.f(appId, "appId");
        kotlin.jvm.internal.k.f(appSecret, "appSecret");
        kotlin.jvm.internal.k.f(language, "language");
        kotlin.jvm.internal.k.f(callBackPolicyResult, "callBackPolicyResult");
        AbstractC1683A.n(C1704W.f5321a, exceptionHandler, new C11231(category, version, versionName, appId, appSecret, callBackPolicyResult, language, null), 2);
    }

    public static final void getPolicyHistoryList(String appId, String appSecret, String language, String category, long version, String versionName, S7.k callBackPolicyResult) {
        kotlin.jvm.internal.k.f(appId, "appId");
        kotlin.jvm.internal.k.f(appSecret, "appSecret");
        kotlin.jvm.internal.k.f(language, "language");
        kotlin.jvm.internal.k.f(callBackPolicyResult, "callBackPolicyResult");
        AbstractC1683A.n(C1704W.f5321a, exceptionHandler, new C11241(category, versionName, appId, appSecret, callBackPolicyResult, language, version, null), 2);
    }

    public static final String getPolicyHistoryUrl(String appId, String category, long version, String language) {
        kotlin.jvm.internal.k.f(appId, "appId");
        kotlin.jvm.internal.k.f(category, "category");
        kotlin.jvm.internal.k.f(language, "language");
        StringBuilder sb = new StringBuilder("https://policy-h5.stepos.com/?appId=");
        androidx.constraintlayout.core.dsl.a.A(sb, appId, "&category=", category, "&version=");
        sb.append(version);
        sb.append("&language=");
        sb.append(language);
        String string = sb.toString();
        PolicySdkLogUtils.INSTANCE.d("getPolicyHistoryUrl", string);
        return string;
    }

    public static final PolicySdkResultBean getPolicyNewestPath(Context context, String category) {
        kotlin.jvm.internal.k.f(context, "context");
        kotlin.jvm.internal.k.f(category, "category");
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
            kotlin.jvm.internal.k.e(name, "myFile.name");
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
        kotlin.jvm.internal.k.f(context, "context");
        kotlin.jvm.internal.k.f(category, "category");
        PolicySdkLogUtils.INSTANCE.d("getPolicyNewestPathByCustom", " initSDKByDeviceProtectedStorageContext= " + initSDKByDeviceProtectedStorageContext);
        return getPolicyNewestPath(context, category);
    }

    public static final void getPolicyServiceConfig(Context context, String appId, String appSecret, String language, String versionName, S7.k callBackPolicyResult) {
        kotlin.jvm.internal.k.f(context, "context");
        kotlin.jvm.internal.k.f(appId, "appId");
        kotlin.jvm.internal.k.f(appSecret, "appSecret");
        kotlin.jvm.internal.k.f(language, "language");
        kotlin.jvm.internal.k.f(callBackPolicyResult, "callBackPolicyResult");
        AbstractC1683A.n(C1704W.f5321a, exceptionHandler, new C11261(versionName, appId, appSecret, callBackPolicyResult, language, context, null), 2);
    }

    public static final void getPrivateDeleteInfoList(Context context, String appId, String businessType, int deleteType, final S7.k callBackPolicyResult) {
        kotlin.jvm.internal.k.f(context, "context");
        kotlin.jvm.internal.k.f(appId, "appId");
        kotlin.jvm.internal.k.f(businessType, "businessType");
        kotlin.jvm.internal.k.f(callBackPolicyResult, "callBackPolicyResult");
        WithdrawalManager.INSTANCE.getPrivateDeleteInfoListBySecure(context, appId, businessType, deleteType, new S7.k() { // from class: com.stepos.policy.sdk.PolicyManager.getPrivateDeleteInfoList.1
            {
                super(1);
            }

            @Override // S7.k
            public final Object invoke(Object obj) {
                ArrayList arrayList = (ArrayList) obj;
                PolicyManager policyManager = PolicyManager.INSTANCE;
                PolicySdkLogUtils.INSTANCE.d("getPrivateDeleteInfoList", "result = " + arrayList);
                callBackPolicyResult.invoke(arrayList);
                return r.f317a;
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0139 A[Catch: Exception -> 0x0151, TryCatch #0 {Exception -> 0x0151, blocks: (B:47:0x011f, B:49:0x0139, B:51:0x0144, B:53:0x0149), top: B:57:0x011f }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0149 A[Catch: Exception -> 0x0151, TRY_LEAVE, TryCatch #0 {Exception -> 0x0151, blocks: (B:47:0x011f, B:49:0x0139, B:51:0x0144, B:53:0x0149), top: B:57:0x011f }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object initPolicyNewestPath(android.content.Context r10, java.lang.String r11, java.lang.String r12, H7.c<? super com.stepos.policy.sdk.bean.PolicySdkResultBean> r13) {
        /*
            Method dump skipped, instructions count: 341
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.initPolicyNewestPath(android.content.Context, java.lang.String, java.lang.String, H7.c):java.lang.Object");
    }

    public static final void initSDK(Context context, String appId, String appSecret, String versionName, HashMap<String, String> policyCategoryMap) throws Throwable {
        kotlin.jvm.internal.k.f(context, "context");
        kotlin.jvm.internal.k.f(appId, "appId");
        kotlin.jvm.internal.k.f(appSecret, "appSecret");
        kotlin.jvm.internal.k.f(versionName, "versionName");
        kotlin.jvm.internal.k.f(policyCategoryMap, "policyCategoryMap");
        PolicySdkRetrofitCreator.INSTANCE.init(context);
        mAppId = appId;
        mAppSecret = appSecret;
        mAppVersionName = versionName;
        PolicySdkToolsUtils.Companion companion = PolicySdkToolsUtils.INSTANCE;
        model = companion.getSystemModel(context);
        osVersion = companion.getSystemVersion(context);
        Context contextResolvePolicyContext = resolvePolicyContext(context);
        localAssetsCategoryPathMap = policyCategoryMap;
        try {
            AbstractC1683A.r(EmptyCoroutineContext.f4908a, new C11301(contextResolvePolicyContext, null));
        } catch (Exception e) {
            PolicySdkLogUtils.INSTANCE.e("initSDK", "load agreeStatus/uidMap failed: " + e);
        }
        PolicySdkLogUtils.Companion companion2 = PolicySdkLogUtils.INSTANCE;
        StringBuilder sb = new StringBuilder("policyCategoryMap=");
        sb.append(policyCategoryMap);
        sb.append(", policyContext=");
        File dataDir = contextResolvePolicyContext.getDataDir();
        sb.append(dataDir != null ? dataDir.getPath() : null);
        companion2.d("initSDK", sb.toString());
        AbstractC1683A.n(C1704W.f5321a, exceptionHandler, new C11312(contextResolvePolicyContext, policyCategoryMap, null), 2);
    }

    private final boolean isDeviceProtectedStorageContext(Context context) {
        String path;
        File dataDir = context.getDataDir();
        return (dataDir == null || (path = dataDir.getPath()) == null || !j9.m.h0(path, "user_de", false)) ? false : true;
    }

    public static final boolean isSupportSecureService(Context context, int versionCode) {
        kotlin.jvm.internal.k.f(context, "context");
        return INSTANCE.getSecureServiceVersionCode(context) >= versionCode;
    }

    public static final boolean isSupportSecureService31(Context context) {
        kotlin.jvm.internal.k.f(context, "context");
        try {
            int secureServiceVersionCode = INSTANCE.getSecureServiceVersionCode(context);
            PolicySdkLogUtils.INSTANCE.d("PolicyManager", "com.stepos.secureservice versionCode : " + secureServiceVersionCode + ' ');
            return secureServiceVersionCode >= 11000031;
        } catch (Exception e) {
            PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.INSTANCE;
            StringBuilder sb = new StringBuilder("exception : ");
            e.getMessage();
            sb.append(e);
            companion.e("PolicyManager", sb.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object loadCloudPolicyUidCategoryMap(android.content.Context r7, H7.c<? super C7.r> r8) {
        /*
            r6 = this;
            java.lang.String r0 = "CloudPolicyIndex"
            java.lang.String r1 = "loaded "
            boolean r2 = r8 instanceof com.stepos.policy.sdk.PolicyManager.C11321
            if (r2 == 0) goto L17
            r2 = r8
            com.stepos.policy.sdk.PolicyManager$loadCloudPolicyUidCategoryMap$1 r2 = (com.stepos.policy.sdk.PolicyManager.C11321) r2
            int r3 = r2.c
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L17
            int r3 = r3 - r4
            r2.c = r3
            goto L1c
        L17:
            com.stepos.policy.sdk.PolicyManager$loadCloudPolicyUidCategoryMap$1 r2 = new com.stepos.policy.sdk.PolicyManager$loadCloudPolicyUidCategoryMap$1
            r2.<init>(r8)
        L1c:
            java.lang.Object r6 = r2.f3918a
            kotlin.coroutines.intrinsics.CoroutineSingletons r8 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r3 = r2.c
            r4 = 1
            if (r3 == 0) goto L33
            if (r3 != r4) goto L2b
            kotlin.b.b(r6)
            goto L4d
        L2b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L33:
            kotlin.b.b(r6)
            androidx.datastore.core.DataStore r6 = com.stepos.policy.sdk.m.a(r7)
            p9.c r6 = r6.getData()
            com.stepos.policy.sdk.c r7 = new com.stepos.policy.sdk.c
            r3 = 4
            r7.<init>(r6, r3)
            r2.c = r4
            java.lang.Object r6 = kotlinx.coroutines.flow.d.h(r7, r2)
            if (r6 != r8) goto L4d
            return r8
        L4d:
            java.lang.String r6 = (java.lang.String) r6
            C7.r r7 = C7.r.f317a
            if (r6 == 0) goto La3
            boolean r8 = j9.m.s0(r6)
            if (r8 == 0) goto L5a
            goto La3
        L5a:
            com.stepos.policy.sdk.PolicyManager$loadCloudPolicyUidCategoryMap$type$1 r8 = new com.stepos.policy.sdk.PolicyManager$loadCloudPolicyUidCategoryMap$type$1     // Catch: java.lang.Exception -> L8f
            r8.<init>()     // Catch: java.lang.Exception -> L8f
            java.lang.reflect.Type r8 = r8.getType()     // Catch: java.lang.Exception -> L8f
            com.google.gson.Gson r2 = new com.google.gson.Gson     // Catch: java.lang.Exception -> L8f
            r2.<init>()     // Catch: java.lang.Exception -> L8f
            java.lang.Object r6 = r2.fromJson(r6, r8)     // Catch: java.lang.Exception -> L8f
            java.util.Map r6 = (java.util.Map) r6     // Catch: java.lang.Exception -> L8f
            if (r6 != 0) goto L71
            goto La3
        L71:
            com.stepos.policy.sdk.util.PolicyCloudPolicyIndex.putAll(r6)     // Catch: java.lang.Exception -> L8f
            com.stepos.policy.sdk.util.PolicySdkLogUtils$Companion r8 = com.stepos.policy.sdk.util.PolicySdkLogUtils.INSTANCE     // Catch: java.lang.Exception -> L8f
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L8f
            r2.<init>(r1)     // Catch: java.lang.Exception -> L8f
            int r6 = r6.size()     // Catch: java.lang.Exception -> L8f
            r2.append(r6)     // Catch: java.lang.Exception -> L8f
            java.lang.String r6 = " uid→category from DataStore"
            r2.append(r6)     // Catch: java.lang.Exception -> L8f
            java.lang.String r6 = r2.toString()     // Catch: java.lang.Exception -> L8f
            r8.d(r0, r6)     // Catch: java.lang.Exception -> L8f
            return r7
        L8f:
            r6 = move-exception
            com.stepos.policy.sdk.util.PolicySdkLogUtils$Companion r8 = com.stepos.policy.sdk.util.PolicySdkLogUtils.INSTANCE
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "load failed: "
            r1.<init>(r2)
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            r8.e(r0, r6)
        La3:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.loadCloudPolicyUidCategoryMap(android.content.Context, H7.c):java.lang.Object");
    }

    @SuppressLint({"SuspiciousIndentation"})
    public static final PolicySdkResultBean openPolicyDataByBrowser(Context context, String category, String title) {
        kotlin.jvm.internal.k.f(context, "context");
        kotlin.jvm.internal.k.f(category, "category");
        kotlin.jvm.internal.k.f(title, "title");
        PolicySdkResultBean policyNewestPathByCustom = getPolicyNewestPathByCustom(context, category);
        PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.INSTANCE;
        companion.d("PolicyManager", "openPolicyDataByBrowser " + policyNewestPathByCustom.getPolicyNewestPath() + '}');
        PolicyCheckLogUtils.Companion companion2 = PolicyCheckLogUtils.INSTANCE;
        StringBuilder sbV = B7.a.v(">>> START category=", category, " method=BROWSER syncDone=");
        sbV.append(syncLocalFileFinished);
        companion2.i("openPolicy", sbV.toString());
        if (policyNewestPathByCustom.getCode() != 0) {
            companion2.e("openPolicy", ">>> END category=" + category + " code=FAILED 未打开页面(无反应)");
            StringBuilder sbV2 = B7.a.v("原因: 本地无 ", category, " 缓存文件; syncDone=");
            sbV2.append(syncLocalFileFinished);
            sbV2.append("; code=");
            sbV2.append(policyNewestPathByCustom.getCode());
            companion2.e("openPolicy", sbV2.toString());
            StringBuilder sb = new StringBuilder("建议: 1)确认 assets 有对应 ");
            sb.append(category);
            companion2.e("openPolicy", androidx.constraintlayout.core.dsl.a.j(sb, "_x.html 且 initSDK 已 put(\"", category, "\",...); 2)syncDone=false 时查启动自检(selfCheck)是否有 ⚠️ 缺文件导致同步中断; 3)确认打开与登记的 category 完全一致"));
            return policyNewestPathByCustom;
        }
        String policyNewestPath = policyNewestPathByCustom.getPolicyNewestPath();
        companion.d("PolicyManager", "openPolicyDataByBrowser policyNewestPath path = " + policyNewestPath + ' ');
        Uri uriForFile = FileProvider.getUriForFile(context, context.getPackageName() + ".PolicySdk.FileProvider", new File(policyNewestPath));
        if (uriForFile != null) {
            PolicySdkToolsUtils.INSTANCE.startBrowser(context, uriForFile);
        }
        companion2.i("openPolicy", B7.a.n(">>> END category=", category, " code=SUCCESS 已唤起浏览器 path=", policyNewestPath));
        return policyNewestPathByCustom;
    }

    @SuppressLint({"SuspiciousIndentation"})
    public static final PolicySdkResultBean openPolicyDataByWebView(Context context, String category, String title) {
        kotlin.jvm.internal.k.f(context, "context");
        kotlin.jvm.internal.k.f(category, "category");
        kotlin.jvm.internal.k.f(title, "title");
        PolicySdkResultBean policyNewestPathByCustom = getPolicyNewestPathByCustom(context, category);
        PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.INSTANCE;
        companion.d("PolicyManager", "openPolicyDataByWebView " + policyNewestPathByCustom.getPolicyNewestPath() + '}');
        PolicyCheckLogUtils.Companion companion2 = PolicyCheckLogUtils.INSTANCE;
        StringBuilder sbV = B7.a.v(">>> START category=", category, " method=IN_APP syncDone=");
        sbV.append(syncLocalFileFinished);
        companion2.i("openPolicy", sbV.toString());
        if (policyNewestPathByCustom.getCode() != 0) {
            companion2.e("openPolicy", ">>> END category=" + category + " code=FAILED 未打开页面(无反应)");
            StringBuilder sbV2 = B7.a.v("原因: 本地无 ", category, " 缓存文件; syncDone=");
            sbV2.append(syncLocalFileFinished);
            sbV2.append("; code=");
            sbV2.append(policyNewestPathByCustom.getCode());
            companion2.e("openPolicy", sbV2.toString());
            StringBuilder sb = new StringBuilder("建议: 1)确认 assets 有对应 ");
            sb.append(category);
            companion2.e("openPolicy", androidx.constraintlayout.core.dsl.a.j(sb, "_x.html 且 initSDK 已 put(\"", category, "\",...); 2)syncDone=false 时查启动自检(selfCheck)是否有 ⚠️ 缺文件导致同步中断; 3)确认打开与登记的 category 完全一致"));
            return policyNewestPathByCustom;
        }
        String policyNewestPath = policyNewestPathByCustom.getPolicyNewestPath();
        Uri uriForFile = FileProvider.getUriForFile(context, context.getPackageName() + ".PolicySdk.FileProvider", new File(policyNewestPath));
        companion.d("PolicyManager", "save sucessful path = " + policyNewestPath + ' ');
        String string = uriForFile.toString();
        kotlin.jvm.internal.k.e(string, "contentUri.toString()");
        if (!syncLocalFileFinished && localAssetsCategoryPathMap.containsKey(category) && localAssetsCategoryPathMap.get(category) != null && !"".equals(localAssetsCategoryPathMap.get(category))) {
            string = String.valueOf(localAssetsCategoryPathMap.get(category));
        }
        companion.d("openPolicyDataByWebView", "initSDK syncLocalFileFinished " + syncLocalFileFinished + " |  policyPath = " + string);
        PolicyHtmlViewerActivity.INSTANCE.openPolicy(context, string, title, null);
        companion2.i("openPolicy", B7.a.n(">>> END category=", category, " code=SUCCESS 已打开页面 path=", string));
        return policyNewestPathByCustom;
    }

    public static final PolicySdkResultBean openPolicyMethod(Context context, boolean methodType, String title, String category) {
        kotlin.jvm.internal.k.f(context, "context");
        kotlin.jvm.internal.k.f(title, "title");
        kotlin.jvm.internal.k.f(category, "category");
        return methodType ? openPolicyDataByWebView(context, category, title) : openPolicyDataByBrowser(context, category, title);
    }

    private final void persistCloudPolicyUidCategoryMap(Context context) {
        AbstractC1683A.n(C1704W.f5321a, exceptionHandler, new C11331(context, null), 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reTryUploadRecord(Context context) {
        AbstractC1683A.n(C1704W.f5321a, exceptionHandler, new C11341(this, context, null), 2);
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
            boolean r0 = j9.m.s0(r5)
            if (r0 == 0) goto L9
            goto L36
        L9:
            r0 = 0
            if (r6 == 0) goto L19
            boolean r1 = j9.m.s0(r6)
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
            boolean r4 = j9.m.s0(r0)
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
        kotlin.jvm.internal.k.f(context, "context");
        if (INSTANCE.isDeviceProtectedStorageContext(context)) {
            initSDKByDeviceProtectedStorageContext = true;
            return context;
        }
        if (!initSDKByDeviceProtectedStorageContext) {
            return context;
        }
        Context contextCreateDeviceProtectedStorageContext = context.getApplicationContext().createDeviceProtectedStorageContext();
        kotlin.jvm.internal.k.e(contextCreateDeviceProtectedStorageContext, "{\n            context.ap…torageContext()\n        }");
        return contextCreateDeviceProtectedStorageContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object saveDataStoreString(Context context, Preferences.Key<String> key, String str, H7.c<? super r> cVar) {
        PolicySdkLogUtils.INSTANCE.d("saveDataStoreString", " " + key + " | dataStoreValue =" + str + ' ');
        Object objEdit = PreferencesKt.edit(m.a(context), new C11362(key, str, null), cVar);
        return objEdit == CoroutineSingletons.f4909a ? objEdit : r.f317a;
    }

    private final void saveLocalCategoryMd5(Context context, String category, String md5) {
        AbstractC1683A.n(C1704W.f5321a, exceptionHandler, new C11371(context, category, md5, null), 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object savePolicyOperate(android.content.Context r8, boolean r9, java.lang.String r10, H7.c<? super C7.r> r11) {
        /*
            r7 = this;
            boolean r0 = r11 instanceof com.stepos.policy.sdk.PolicyManager.C11381
            if (r0 == 0) goto L13
            r0 = r11
            com.stepos.policy.sdk.PolicyManager$savePolicyOperate$1 r0 = (com.stepos.policy.sdk.PolicyManager.C11381) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f = r1
            goto L18
        L13:
            com.stepos.policy.sdk.PolicyManager$savePolicyOperate$1 r0 = new com.stepos.policy.sdk.PolicyManager$savePolicyOperate$1
            r0.<init>(r11)
        L18:
            java.lang.Object r7 = r0.d
            kotlin.coroutines.intrinsics.CoroutineSingletons r11 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r0.f
            C7.r r2 = C7.r.f317a
            r3 = 2
            r4 = 1
            r5 = 0
            if (r1 == 0) goto L3f
            if (r1 == r4) goto L35
            if (r1 != r3) goto L2d
            kotlin.b.b(r7)
            return r2
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L35:
            boolean r9 = r0.c
            java.lang.String r10 = r0.b
            android.content.Context r8 = r0.f3929a
            kotlin.b.b(r7)
            goto L77
        L3f:
            kotlin.b.b(r7)
            com.stepos.policy.sdk.util.PolicySdkLogUtils$Companion r7 = com.stepos.policy.sdk.util.PolicySdkLogUtils.INSTANCE
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r6 = "isOperateSuccess ="
            r1.<init>(r6)
            r1.append(r9)
            java.lang.String r6 = " |operateJson = "
            r1.append(r6)
            r1.append(r10)
            java.lang.String r1 = r1.toString()
            java.lang.String r6 = "savePolicyOperate"
            r7.d(r6, r1)
            androidx.datastore.core.DataStore r7 = com.stepos.policy.sdk.m.a(r8)
            com.stepos.policy.sdk.PolicyManager$savePolicyOperate$2 r1 = new com.stepos.policy.sdk.PolicyManager$savePolicyOperate$2
            r1.<init>(r9, r5)
            r0.f3929a = r8
            r0.b = r10
            r0.c = r9
            r0.f = r4
            java.lang.Object r7 = androidx.datastore.preferences.core.PreferencesKt.edit(r7, r1, r0)
            if (r7 != r11) goto L77
            goto L96
        L77:
            if (r9 != 0) goto L97
            if (r10 == 0) goto L97
            int r7 = r10.length()
            if (r7 <= 0) goto L97
            androidx.datastore.core.DataStore r7 = com.stepos.policy.sdk.m.a(r8)
            com.stepos.policy.sdk.PolicyManager$savePolicyOperate$3 r8 = new com.stepos.policy.sdk.PolicyManager$savePolicyOperate$3
            r8.<init>(r10, r5)
            r0.f3929a = r5
            r0.b = r5
            r0.f = r3
            java.lang.Object r7 = androidx.datastore.preferences.core.PreferencesKt.edit(r7, r8, r0)
            if (r7 != r11) goto L97
        L96:
            return r11
        L97:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.savePolicyOperate(android.content.Context, boolean, java.lang.String, H7.c):java.lang.Object");
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
                } else if (j9.m.h0(value, "file:////android_asset", false)) {
                    String strC0 = t.c0(value, "file:////android_asset/", "");
                    if (assetExists(context, strC0)) {
                        PolicyCheckLogUtils.INSTANCE.i("selfCheck", "category=" + key + " asset=" + strC0 + " present=true");
                    } else {
                        arrayList.add(key);
                        PolicyCheckLogUtils.INSTANCE.w("selfCheck", "category=" + key + " asset=" + strC0 + " present=FALSE ⚠️ 缺失会中断同步(其后 category 不再同步)且该 category 无法本地打开");
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
        } catch (Exception e) {
            PolicyCheckLogUtils.INSTANCE.e("selfCheck", "自检异常: " + e.getMessage());
        }
    }

    public static final DialogInterfaceC1961j showCustomPolicyDialog(Context context, boolean secondaryConfirmation, String[] permissionKey, String[] permissionSummary, String title, CharSequence reminder, CharSequence customTerms, PolicyPermissionDialogBuilder.OnPermissionClickListener permissionDialogClickListener) {
        kotlin.jvm.internal.k.f(context, "context");
        kotlin.jvm.internal.k.f(title, "title");
        kotlin.jvm.internal.k.f(customTerms, "customTerms");
        kotlin.jvm.internal.k.f(permissionDialogClickListener, "permissionDialogClickListener");
        PolicyPermissionDialogBuilder policyPermissionDialogBuilder = new PolicyPermissionDialogBuilder(context);
        policyPermissionDialogBuilder.setAppName(title).setOnPermissionListener(new f(context, permissionDialogClickListener)).setSecondaryConfirmation(secondaryConfirmation).setCustomTerms(customTerms);
        if (reminder != null && !TextUtils.isEmpty(reminder)) {
            policyPermissionDialogBuilder.setReminder(reminder);
        }
        if (permissionKey != null && permissionSummary != null) {
            policyPermissionDialogBuilder.setPermission(permissionKey, permissionSummary);
        }
        return policyPermissionDialogBuilder.create();
    }

    public static final DialogInterfaceC1961j showCustomPolicyDialogAndUploadRecord(Context context, boolean secondaryConfirmation, String[] permissionKey, String[] permissionSummary, String title, CharSequence reminder, CharSequence customTerms, String appId, String appSecret, String versionName, String[] categoryList, String userId, PolicyPermissionDialogBuilder.OnPermissionClickListener permissionDialogClickListener) {
        kotlin.jvm.internal.k.f(context, "context");
        kotlin.jvm.internal.k.f(title, "title");
        kotlin.jvm.internal.k.f(customTerms, "customTerms");
        kotlin.jvm.internal.k.f(appId, "appId");
        kotlin.jvm.internal.k.f(appSecret, "appSecret");
        kotlin.jvm.internal.k.f(versionName, "versionName");
        kotlin.jvm.internal.k.f(categoryList, "categoryList");
        kotlin.jvm.internal.k.f(permissionDialogClickListener, "permissionDialogClickListener");
        PolicyPermissionDialogBuilder policyPermissionDialogBuilder = new PolicyPermissionDialogBuilder(context);
        policyPermissionDialogBuilder.setAppName(title).setOnPermissionListener(new g(context, appId, appSecret, versionName, categoryList, userId, permissionDialogClickListener)).setSecondaryConfirmation(secondaryConfirmation).setCustomTerms(customTerms);
        if (reminder != null && !TextUtils.isEmpty(reminder)) {
            policyPermissionDialogBuilder.setReminder(reminder);
        }
        if (permissionKey != null && permissionSummary != null) {
            policyPermissionDialogBuilder.setPermission(permissionKey, permissionSummary);
        }
        return policyPermissionDialogBuilder.create();
    }

    public static final DialogInterfaceC1961j showCustomPolicyThreeButtonDialogAndUploadRecord(Context context, boolean secondaryConfirmation, String[] permissionKey, String[] permissionSummary, String title, CharSequence reminder, CharSequence customTerms, String appId, String appSecret, String versionName, String[] categoryList, String userId, PolicyPermissionDialogBuilder.OnPermissionClickListener fullAgreeListener, P basicListener) {
        kotlin.jvm.internal.k.f(context, "context");
        kotlin.jvm.internal.k.f(title, "title");
        kotlin.jvm.internal.k.f(customTerms, "customTerms");
        kotlin.jvm.internal.k.f(appId, "appId");
        kotlin.jvm.internal.k.f(appSecret, "appSecret");
        kotlin.jvm.internal.k.f(versionName, "versionName");
        kotlin.jvm.internal.k.f(categoryList, "categoryList");
        kotlin.jvm.internal.k.f(fullAgreeListener, "fullAgreeListener");
        kotlin.jvm.internal.k.f(basicListener, "basicListener");
        PolicyPermissionDialogBuilder policyPermissionDialogBuilder = new PolicyPermissionDialogBuilder(context);
        policyPermissionDialogBuilder.setDark(PolicyHtmlDisplayAdapter.isDarkMode(context));
        policyPermissionDialogBuilder.setAppName(title).setOnPermissionListener(new h()).setSecondaryConfirmation(secondaryConfirmation).setCustomTerms(customTerms);
        if (reminder != null && !TextUtils.isEmpty(reminder)) {
            policyPermissionDialogBuilder.setReminder(reminder);
        }
        if (permissionKey != null && permissionSummary != null) {
            policyPermissionDialogBuilder.setPermission(permissionKey, permissionSummary);
        }
        return policyPermissionDialogBuilder.createThreeButton(new i(context, appId, appSecret, versionName, categoryList, userId, fullAgreeListener, basicListener));
    }

    public static final S showDialogByCustomThemeViewBuilder(Context context, int theme, String title, CharSequence customTerms, String customNegativeButtonText, String customPositiveButtonText, P permissionDialogClickListener) {
        kotlin.jvm.internal.k.f(context, "context");
        kotlin.jvm.internal.k.f(title, "title");
        kotlin.jvm.internal.k.f(customTerms, "customTerms");
        kotlin.jvm.internal.k.f(customNegativeButtonText, "customNegativeButtonText");
        kotlin.jvm.internal.k.f(customPositiveButtonText, "customPositiveButtonText");
        kotlin.jvm.internal.k.f(permissionDialogClickListener, "permissionDialogClickListener");
        S s5 = new S(context);
        s5.c = title;
        s5.f6235j = permissionDialogClickListener;
        s5.k = customTerms;
        s5.o = customNegativeButtonText;
        s5.p = customPositiveButtonText;
        return s5;
    }

    public static final DialogInterfaceC1961j showDialogByCustomView(Context context, String title, CharSequence customTerms, String customNegativeButtonText, String customPositiveButtonText, P permissionDialogClickListener) {
        kotlin.jvm.internal.k.f(context, "context");
        kotlin.jvm.internal.k.f(title, "title");
        kotlin.jvm.internal.k.f(customTerms, "customTerms");
        kotlin.jvm.internal.k.f(customNegativeButtonText, "customNegativeButtonText");
        kotlin.jvm.internal.k.f(customPositiveButtonText, "customPositiveButtonText");
        kotlin.jvm.internal.k.f(permissionDialogClickListener, "permissionDialogClickListener");
        S sShowDialogByCustomViewBuilder = showDialogByCustomViewBuilder(context, title, customTerms, customNegativeButtonText, customPositiveButtonText, "2", permissionDialogClickListener);
        if (sShowDialogByCustomViewBuilder != null) {
            return sShowDialogByCustomViewBuilder.a();
        }
        return null;
    }

    public static final DialogInterfaceC1961j showDialogByCustomViewAndUploadRecord(Context context, String title, CharSequence customTerms, String customNegativeButtonText, String customPositiveButtonText, String appId, String appSecret, String versionName, String[] categoryList, String userId, String operationType, P permissionDialogClickListener) {
        kotlin.jvm.internal.k.f(context, "context");
        kotlin.jvm.internal.k.f(title, "title");
        kotlin.jvm.internal.k.f(customTerms, "customTerms");
        kotlin.jvm.internal.k.f(customNegativeButtonText, "customNegativeButtonText");
        kotlin.jvm.internal.k.f(customPositiveButtonText, "customPositiveButtonText");
        kotlin.jvm.internal.k.f(appId, "appId");
        kotlin.jvm.internal.k.f(appSecret, "appSecret");
        kotlin.jvm.internal.k.f(versionName, "versionName");
        kotlin.jvm.internal.k.f(categoryList, "categoryList");
        kotlin.jvm.internal.k.f(operationType, "operationType");
        kotlin.jvm.internal.k.f(permissionDialogClickListener, "permissionDialogClickListener");
        S sShowDialogUploadRecordBuilder = showDialogUploadRecordBuilder(context, title, customTerms, customNegativeButtonText, customPositiveButtonText, appId, appSecret, versionName, categoryList, userId, operationType, permissionDialogClickListener);
        if (sShowDialogUploadRecordBuilder != null) {
            return sShowDialogUploadRecordBuilder.a();
        }
        return null;
    }

    public static final S showDialogByCustomViewBuilder(Context context, String title, CharSequence customTerms, String customNegativeButtonText, String customPositiveButtonText, String operationType, P permissionDialogClickListener) {
        kotlin.jvm.internal.k.f(context, "context");
        kotlin.jvm.internal.k.f(title, "title");
        kotlin.jvm.internal.k.f(customTerms, "customTerms");
        kotlin.jvm.internal.k.f(customNegativeButtonText, "customNegativeButtonText");
        kotlin.jvm.internal.k.f(customPositiveButtonText, "customPositiveButtonText");
        kotlin.jvm.internal.k.f(operationType, "operationType");
        kotlin.jvm.internal.k.f(permissionDialogClickListener, "permissionDialogClickListener");
        S s5 = new S(context);
        s5.c = title;
        s5.f6235j = new A5.c(operationType, context, permissionDialogClickListener, 8);
        s5.k = customTerms;
        s5.o = customNegativeButtonText;
        s5.p = customPositiveButtonText;
        return s5;
    }

    public static final S showDialogByCustomViewBuilderRecord(Context context, String title, CharSequence customTerms, String customNegativeButtonText, String customPositiveButtonText, String appId, String appSecret, String versionName, String[] categoryList, String userId, P permissionDialogClickListener) {
        kotlin.jvm.internal.k.f(context, "context");
        kotlin.jvm.internal.k.f(title, "title");
        kotlin.jvm.internal.k.f(customTerms, "customTerms");
        kotlin.jvm.internal.k.f(customNegativeButtonText, "customNegativeButtonText");
        kotlin.jvm.internal.k.f(customPositiveButtonText, "customPositiveButtonText");
        kotlin.jvm.internal.k.f(appId, "appId");
        kotlin.jvm.internal.k.f(appSecret, "appSecret");
        kotlin.jvm.internal.k.f(versionName, "versionName");
        kotlin.jvm.internal.k.f(categoryList, "categoryList");
        kotlin.jvm.internal.k.f(permissionDialogClickListener, "permissionDialogClickListener");
        S s5 = new S(context);
        s5.c = title;
        s5.f6235j = new j(context, appId, appSecret, versionName, categoryList, userId, permissionDialogClickListener, 0);
        s5.k = customTerms;
        s5.o = customNegativeButtonText;
        s5.p = customPositiveButtonText;
        return s5;
    }

    public static final S showDialogUploadRecordBuilder(Context context, String title, CharSequence customTerms, String customNegativeButtonText, String customPositiveButtonText, String appId, String appSecret, String versionName, String[] categoryList, String userId, String operationType, P permissionDialogClickListener) {
        kotlin.jvm.internal.k.f(context, "context");
        kotlin.jvm.internal.k.f(title, "title");
        kotlin.jvm.internal.k.f(customTerms, "customTerms");
        kotlin.jvm.internal.k.f(customNegativeButtonText, "customNegativeButtonText");
        kotlin.jvm.internal.k.f(customPositiveButtonText, "customPositiveButtonText");
        kotlin.jvm.internal.k.f(appId, "appId");
        kotlin.jvm.internal.k.f(appSecret, "appSecret");
        kotlin.jvm.internal.k.f(versionName, "versionName");
        kotlin.jvm.internal.k.f(categoryList, "categoryList");
        kotlin.jvm.internal.k.f(operationType, "operationType");
        kotlin.jvm.internal.k.f(permissionDialogClickListener, "permissionDialogClickListener");
        S s5 = new S(context);
        s5.c = title;
        C5.f fVar = new C5.f();
        fVar.f302a = operationType;
        fVar.b = context;
        fVar.c = appId;
        fVar.d = appSecret;
        fVar.e = versionName;
        fVar.f = categoryList;
        fVar.g = userId;
        fVar.h = permissionDialogClickListener;
        s5.f6235j = fVar;
        s5.k = customTerms;
        s5.o = customNegativeButtonText;
        s5.p = customPositiveButtonText;
        return s5;
    }

    public static final DialogInterfaceC1961j showNewestDialogAndUploadRecord(Context context, String dialogTitle, String appId, String appSecret, String versionName, String[] categoryList, String userId, boolean isRecord, CharSequence customTerms, String btnNegative, String btnPositive, P permissionDialogClickListener) {
        kotlin.jvm.internal.k.f(context, "context");
        kotlin.jvm.internal.k.f(dialogTitle, "dialogTitle");
        kotlin.jvm.internal.k.f(appId, "appId");
        kotlin.jvm.internal.k.f(appSecret, "appSecret");
        kotlin.jvm.internal.k.f(versionName, "versionName");
        kotlin.jvm.internal.k.f(categoryList, "categoryList");
        kotlin.jvm.internal.k.f(customTerms, "customTerms");
        kotlin.jvm.internal.k.f(btnNegative, "btnNegative");
        kotlin.jvm.internal.k.f(btnPositive, "btnPositive");
        kotlin.jvm.internal.k.f(permissionDialogClickListener, "permissionDialogClickListener");
        S s5 = new S(context);
        s5.c = dialogTitle;
        s5.f6235j = new G6.f(isRecord, context, appId, appSecret, versionName, categoryList, userId, permissionDialogClickListener);
        s5.k = customTerms;
        s5.o = btnNegative;
        s5.p = btnPositive;
        return s5.a();
    }

    public static final DialogInterfaceC1961j showReGrantDialog(Context context, boolean methodType, boolean secondaryConfirmation, String title, String privacyPolicyName, String category, P permissionDialogClickListener) {
        kotlin.jvm.internal.k.f(context, "context");
        kotlin.jvm.internal.k.f(title, "title");
        kotlin.jvm.internal.k.f(privacyPolicyName, "privacyPolicyName");
        kotlin.jvm.internal.k.f(category, "category");
        kotlin.jvm.internal.k.f(permissionDialogClickListener, "permissionDialogClickListener");
        return INSTANCE.createReGrantDialogBuilder(context, methodType, secondaryConfirmation, title, privacyPolicyName, category, permissionDialogClickListener).a();
    }

    public static final DialogInterfaceC1961j showReGrantDialogAndUploadRecord(Context context, boolean methodType, boolean secondaryConfirmation, String title, String privacyPolicyName, String category, String appId, String appSecret, String versionName, String[] categoryList, String userId, P permissionDialogClickListener) {
        kotlin.jvm.internal.k.f(context, "context");
        kotlin.jvm.internal.k.f(title, "title");
        kotlin.jvm.internal.k.f(privacyPolicyName, "privacyPolicyName");
        kotlin.jvm.internal.k.f(category, "category");
        kotlin.jvm.internal.k.f(appId, "appId");
        kotlin.jvm.internal.k.f(appSecret, "appSecret");
        kotlin.jvm.internal.k.f(versionName, "versionName");
        kotlin.jvm.internal.k.f(categoryList, "categoryList");
        kotlin.jvm.internal.k.f(permissionDialogClickListener, "permissionDialogClickListener");
        return INSTANCE.createReGrantDialogBuilder(context, methodType, secondaryConfirmation, title, privacyPolicyName, category, new j(context, appId, appSecret, versionName, categoryList, userId, permissionDialogClickListener, 1)).a();
    }

    public static final DialogInterfaceC1961j showReGrantTwoPolicyDialog(Context context, boolean methodType, boolean secondaryConfirmation, String title, String userPrivacyPolicyName, String userCategory, String privacyPolicyName, String category, P permissionDialogClickListener) {
        kotlin.jvm.internal.k.f(context, "context");
        kotlin.jvm.internal.k.f(title, "title");
        kotlin.jvm.internal.k.f(userPrivacyPolicyName, "userPrivacyPolicyName");
        kotlin.jvm.internal.k.f(userCategory, "userCategory");
        kotlin.jvm.internal.k.f(privacyPolicyName, "privacyPolicyName");
        kotlin.jvm.internal.k.f(category, "category");
        kotlin.jvm.internal.k.f(permissionDialogClickListener, "permissionDialogClickListener");
        S sCreateReGrantDialogBuilder = INSTANCE.createReGrantDialogBuilder(context, methodType, secondaryConfirmation, title, privacyPolicyName, category, permissionDialogClickListener);
        sCreateReGrantDialogBuilder.n = userPrivacyPolicyName;
        sCreateReGrantDialogBuilder.g = new a(context, methodType, userPrivacyPolicyName, userCategory, 2);
        return sCreateReGrantDialogBuilder.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showReGrantTwoPolicyDialog$lambda$7(Context context, boolean z10, String userPrivacyPolicyName, String userCategory, View view) {
        kotlin.jvm.internal.k.f(context, "$context");
        kotlin.jvm.internal.k.f(userPrivacyPolicyName, "$userPrivacyPolicyName");
        kotlin.jvm.internal.k.f(userCategory, "$userCategory");
        openPolicyMethod(context, z10, userPrivacyPolicyName, userCategory);
    }

    public static final DialogInterfaceC1961j showReGrantTwoPolicyDialogAndUploadRecord(Context context, boolean methodType, boolean secondaryConfirmation, String title, String userPrivacyPolicyName, String userCategory, String privacyPolicyName, String category, String appId, String appSecret, String versionName, String[] categoryList, String userId, P permissionDialogClickListener) {
        kotlin.jvm.internal.k.f(context, "context");
        kotlin.jvm.internal.k.f(title, "title");
        kotlin.jvm.internal.k.f(userPrivacyPolicyName, "userPrivacyPolicyName");
        kotlin.jvm.internal.k.f(userCategory, "userCategory");
        kotlin.jvm.internal.k.f(privacyPolicyName, "privacyPolicyName");
        kotlin.jvm.internal.k.f(category, "category");
        kotlin.jvm.internal.k.f(appId, "appId");
        kotlin.jvm.internal.k.f(appSecret, "appSecret");
        kotlin.jvm.internal.k.f(versionName, "versionName");
        kotlin.jvm.internal.k.f(categoryList, "categoryList");
        kotlin.jvm.internal.k.f(permissionDialogClickListener, "permissionDialogClickListener");
        S sCreateReGrantDialogBuilder = INSTANCE.createReGrantDialogBuilder(context, methodType, secondaryConfirmation, title, privacyPolicyName, category, new j(context, appId, appSecret, versionName, categoryList, userId, permissionDialogClickListener, 2));
        sCreateReGrantDialogBuilder.n = userPrivacyPolicyName;
        sCreateReGrantDialogBuilder.g = new a(context, methodType, userPrivacyPolicyName, userCategory, 1);
        return sCreateReGrantDialogBuilder.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showReGrantTwoPolicyDialogAndUploadRecord$lambda$6(Context context, boolean z10, String userPrivacyPolicyName, String userCategory, View view) {
        kotlin.jvm.internal.k.f(context, "$context");
        kotlin.jvm.internal.k.f(userPrivacyPolicyName, "$userPrivacyPolicyName");
        kotlin.jvm.internal.k.f(userCategory, "$userCategory");
        openPolicyMethod(context, z10, userPrivacyPolicyName, userCategory);
    }

    public static final DialogInterfaceC1961j showWithdrawalAndCleanServiceDataDialog(Context context, String title, CharSequence customTerms, String customNegativeButtonText, String customPositiveButtonText, String checkButtonMessage, PolicyPermissionDialogBuilder.OnPermissionClickListener permissionDialogClickListener) {
        kotlin.jvm.internal.k.f(context, "context");
        kotlin.jvm.internal.k.f(title, "title");
        kotlin.jvm.internal.k.f(customTerms, "customTerms");
        kotlin.jvm.internal.k.f(customNegativeButtonText, "customNegativeButtonText");
        kotlin.jvm.internal.k.f(customPositiveButtonText, "customPositiveButtonText");
        kotlin.jvm.internal.k.f(checkButtonMessage, "checkButtonMessage");
        kotlin.jvm.internal.k.f(permissionDialogClickListener, "permissionDialogClickListener");
        PolicyPermissionDialogBuilder policyPermissionDialogBuilder = new PolicyPermissionDialogBuilder(context);
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        policyPermissionDialogBuilder.setAppName(title).setOnPermissionListener(new k(ref$ObjectRef, permissionDialogClickListener)).setCustomTerms(customTerms).setShowAlmostDenyBtn(true).setCustomNegativeButtonText(customNegativeButtonText).setCustomPositiveButtonText(customPositiveButtonText).setCancelable(true).setCheckEnableConfirmBtn(true);
        ref$ObjectRef.f4920a = policyPermissionDialogBuilder.create();
        DialogInterfaceC1961j dialogInterfaceC1961jCreate = policyPermissionDialogBuilder.create();
        ref$ObjectRef.f4920a = dialogInterfaceC1961jCreate;
        DialogInterfaceC1961j dialogInterfaceC1961jInitWithdrawalCleanDataOneCheckBox = PolicySdkToolsUtils.INSTANCE.initWithdrawalCleanDataOneCheckBox(context, dialogInterfaceC1961jCreate, checkButtonMessage);
        ref$ObjectRef.f4920a = dialogInterfaceC1961jInitWithdrawalCleanDataOneCheckBox;
        return dialogInterfaceC1961jInitWithdrawalCleanDataOneCheckBox;
    }

    public static final DialogInterfaceC1961j showWithdrawalAndCleanServiceDataDialogByAccount(Context context, boolean hasLogin, String title, CharSequence customTerms, String customNegativeButtonText, String customPositiveButtonText, String checkButtonMessage, String secondCheckButtonMessage, PolicyPermissionDialogBuilder.OnPermissionClickListener permissionDialogClickListener) {
        kotlin.jvm.internal.k.f(context, "context");
        kotlin.jvm.internal.k.f(title, "title");
        kotlin.jvm.internal.k.f(customTerms, "customTerms");
        kotlin.jvm.internal.k.f(customNegativeButtonText, "customNegativeButtonText");
        kotlin.jvm.internal.k.f(customPositiveButtonText, "customPositiveButtonText");
        kotlin.jvm.internal.k.f(checkButtonMessage, "checkButtonMessage");
        kotlin.jvm.internal.k.f(secondCheckButtonMessage, "secondCheckButtonMessage");
        kotlin.jvm.internal.k.f(permissionDialogClickListener, "permissionDialogClickListener");
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        PolicyPermissionDialogBuilder policyPermissionDialogBuilder = new PolicyPermissionDialogBuilder(context);
        policyPermissionDialogBuilder.setAppName(title).setOnPermissionListener(new l(ref$ObjectRef, permissionDialogClickListener)).setCustomTerms(customTerms).setShowAlmostDenyBtn(true).setCustomNegativeButtonText(customNegativeButtonText).setCustomPositiveButtonText(customPositiveButtonText).setCancelable(true).setCheckEnableConfirmBtn(true);
        DialogInterfaceC1961j dialogInterfaceC1961jCreate = policyPermissionDialogBuilder.create();
        ref$ObjectRef.f4920a = dialogInterfaceC1961jCreate;
        DialogInterfaceC1961j dialogInterfaceC1961jInitWithdrawalCleanDataTwoCheckBox = PolicySdkToolsUtils.INSTANCE.initWithdrawalCleanDataTwoCheckBox(context, dialogInterfaceC1961jCreate, hasLogin, checkButtonMessage, secondCheckButtonMessage);
        ref$ObjectRef.f4920a = dialogInterfaceC1961jInitWithdrawalCleanDataTwoCheckBox;
        return dialogInterfaceC1961jInitWithdrawalCleanDataTwoCheckBox;
    }

    public static final void uploadPolicyOperateRecord(String appId, String appSecret, String versionName, PolicyRecordRequest policyRecordRequest, S7.k callBackPolicyResult) {
        kotlin.jvm.internal.k.f(appId, "appId");
        kotlin.jvm.internal.k.f(appSecret, "appSecret");
        kotlin.jvm.internal.k.f(versionName, "versionName");
        kotlin.jvm.internal.k.f(policyRecordRequest, "policyRecordRequest");
        kotlin.jvm.internal.k.f(callBackPolicyResult, "callBackPolicyResult");
        AbstractC1683A.n(C1704W.f5321a, exceptionHandler, new C11411(appId, appSecret, policyRecordRequest, callBackPolicyResult, versionName, null), 2);
    }

    public static final void uploadRecordByCustomRecordRequest(Context context, String appId, String appSecret, String versionName, PolicyRecordRequest policyRecordRequest, final S7.k callBackPolicyResult) {
        kotlin.jvm.internal.k.f(context, "context");
        kotlin.jvm.internal.k.f(appId, "appId");
        kotlin.jvm.internal.k.f(appSecret, "appSecret");
        kotlin.jvm.internal.k.f(versionName, "versionName");
        kotlin.jvm.internal.k.f(policyRecordRequest, "policyRecordRequest");
        kotlin.jvm.internal.k.f(callBackPolicyResult, "callBackPolicyResult");
        if (PolicySdkNetworkUtil.isNetworkAvailable(context)) {
            uploadPolicyOperateRecord(appId, appSecret, versionName, policyRecordRequest, new S7.k() { // from class: com.stepos.policy.sdk.PolicyManager.uploadRecordByCustomRecordRequest.1
                {
                    super(1);
                }

                @Override // S7.k
                public final Object invoke(Object obj) {
                    PolicySdkResultBean policySdkResultBean = (PolicySdkResultBean) obj;
                    kotlin.jvm.internal.k.f(policySdkResultBean, "policySdkResultBean");
                    PolicySdkLogUtils.INSTANCE.d("uploadRecordToCleanServiceData", "policySdkResultBean.code " + policySdkResultBean.getCode());
                    callBackPolicyResult.invoke(policySdkResultBean);
                    return r.f317a;
                }
            });
        }
    }

    public static final void uploadRecordToCleanServiceData(Context context, String serviceName, String validateCode, String verifyType, ArrayList<DeleteInfoBean> deleteInfoBeanList, String appId, String appSecret, String versionName, String[] categoryList, String userId, String operationType, S7.k callBackPolicyResult) {
        kotlin.jvm.internal.k.f(context, "context");
        kotlin.jvm.internal.k.f(serviceName, "serviceName");
        kotlin.jvm.internal.k.f(validateCode, "validateCode");
        kotlin.jvm.internal.k.f(verifyType, "verifyType");
        kotlin.jvm.internal.k.f(appId, "appId");
        kotlin.jvm.internal.k.f(appSecret, "appSecret");
        kotlin.jvm.internal.k.f(versionName, "versionName");
        kotlin.jvm.internal.k.f(categoryList, "categoryList");
        kotlin.jvm.internal.k.f(operationType, "operationType");
        kotlin.jvm.internal.k.f(callBackPolicyResult, "callBackPolicyResult");
        AbstractC1683A.n(scope, exceptionHandler, new C11431(context, categoryList, userId, operationType, verifyType, serviceName, validateCode, deleteInfoBeanList, appId, appSecret, versionName, callBackPolicyResult, null), 2);
    }

    public static final void uploadRecordWithoutSecureService(Context context, String serviceName, String validateCode, String verifyType, ArrayList<DeleteInfoBean> deleteInfoBeanList, String appId, String appSecret, String versionName, String[] categoryList, String userId, String operationType, S7.k callBackPolicyResult) {
        kotlin.jvm.internal.k.f(context, "context");
        kotlin.jvm.internal.k.f(serviceName, "serviceName");
        kotlin.jvm.internal.k.f(validateCode, "validateCode");
        kotlin.jvm.internal.k.f(verifyType, "verifyType");
        kotlin.jvm.internal.k.f(appId, "appId");
        kotlin.jvm.internal.k.f(appSecret, "appSecret");
        kotlin.jvm.internal.k.f(versionName, "versionName");
        kotlin.jvm.internal.k.f(categoryList, "categoryList");
        kotlin.jvm.internal.k.f(operationType, "operationType");
        kotlin.jvm.internal.k.f(callBackPolicyResult, "callBackPolicyResult");
        AbstractC1683A.n(scope, exceptionHandler, new C11441(context, categoryList, userId, operationType, verifyType, serviceName, validateCode, deleteInfoBeanList, appId, appSecret, versionName, callBackPolicyResult, null), 2);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getAgreeStatus(android.content.Context r5, H7.c<? super java.lang.Integer> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.stepos.policy.sdk.PolicyManager.C11191
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.policy.sdk.PolicyManager$getAgreeStatus$1 r0 = (com.stepos.policy.sdk.PolicyManager.C11191) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            com.stepos.policy.sdk.PolicyManager$getAgreeStatus$1 r0 = new com.stepos.policy.sdk.PolicyManager$getAgreeStatus$1
            r0.<init>(r6)
        L18:
            java.lang.Object r4 = r0.f3899a
            kotlin.coroutines.intrinsics.CoroutineSingletons r6 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r0.c
            r2 = 1
            if (r1 == 0) goto L2f
            if (r1 != r2) goto L27
            kotlin.b.b(r4)
            goto L49
        L27:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2f:
            kotlin.b.b(r4)
            androidx.datastore.core.DataStore r4 = com.stepos.policy.sdk.m.a(r5)
            p9.c r4 = r4.getData()
            com.stepos.policy.sdk.c r5 = new com.stepos.policy.sdk.c
            r1 = 0
            r5.<init>(r4, r1)
            r0.c = r2
            java.lang.Object r4 = kotlinx.coroutines.flow.d.h(r5, r0)
            if (r4 != r6) goto L49
            return r6
        L49:
            java.lang.Integer r4 = (java.lang.Integer) r4
            if (r4 == 0) goto L52
            int r4 = r4.intValue()
            goto L53
        L52:
            r4 = 0
        L53:
            java.lang.Integer r5 = new java.lang.Integer
            r5.<init>(r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.getAgreeStatus(android.content.Context, H7.c):java.lang.Object");
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

    public final Object getDataStoreString(Context context, Preferences.Key<String> key, H7.c<? super String> cVar) {
        return kotlinx.coroutines.flow.d.h(new e(m.a(context).getData(), key, 0), cVar);
    }

    public final InterfaceC1731x getExceptionHandler() {
        return exceptionHandler;
    }

    public final boolean getInitSDKByDeviceProtectedStorageContext() {
        return initSDKByDeviceProtectedStorageContext;
    }

    public final InterfaceC1733z getLifecycleScope() {
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
    public final java.lang.Object getPolicyOperate(android.content.Context r5, H7.c<? super java.lang.Boolean> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.stepos.policy.sdk.PolicyManager.C11251
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.policy.sdk.PolicyManager$getPolicyOperate$1 r0 = (com.stepos.policy.sdk.PolicyManager.C11251) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            com.stepos.policy.sdk.PolicyManager$getPolicyOperate$1 r0 = new com.stepos.policy.sdk.PolicyManager$getPolicyOperate$1
            r0.<init>(r6)
        L18:
            java.lang.Object r4 = r0.f3909a
            kotlin.coroutines.intrinsics.CoroutineSingletons r6 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r0.c
            r2 = 1
            if (r1 == 0) goto L2f
            if (r1 != r2) goto L27
            kotlin.b.b(r4)
            goto L49
        L27:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2f:
            kotlin.b.b(r4)
            androidx.datastore.core.DataStore r4 = com.stepos.policy.sdk.m.a(r5)
            p9.c r4 = r4.getData()
            com.stepos.policy.sdk.c r5 = new com.stepos.policy.sdk.c
            r1 = 1
            r5.<init>(r4, r1)
            r0.c = r2
            java.lang.Object r4 = kotlinx.coroutines.flow.d.h(r5, r0)
            if (r4 != r6) goto L49
            return r6
        L49:
            java.lang.Boolean r5 = java.lang.Boolean.TRUE
            boolean r4 = kotlin.jvm.internal.k.b(r4, r5)
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.getPolicyOperate(android.content.Context, H7.c):java.lang.Object");
    }

    public final Object getPolicyOperateJson(Context context, H7.c<? super String> cVar) {
        return kotlinx.coroutines.flow.d.h(new c(m.a(context).getData(), 2), cVar);
    }

    public final int getReadClipboardStatus(Context context) {
        kotlin.jvm.internal.k.f(context, "context");
        return ((Number) AbstractC1683A.r(EmptyCoroutineContext.f4908a, new C11281(context, null))).intValue();
    }

    public final InterfaceC1733z getScope() {
        return scope;
    }

    public final int getSecureServiceVersionCode(Context context) {
        kotlin.jvm.internal.k.f(context, "context");
        int i = context.getApplicationContext().getPackageManager().getPackageInfo("com.stepos.secureservice", 128).versionCode;
        PolicySdkLogUtils.INSTANCE.d("PolicyManager", "com.stepos.secureservice versionCode : " + i + ' ');
        return i;
    }

    public final boolean getSyncLocalFileFinished() {
        return syncLocalFileFinished;
    }

    public final void saveAgreeStatus(Context context, int status) {
        kotlin.jvm.internal.k.f(context, "context");
        PolicySdkNetworkGate.updateAgreeStatusCache(status);
        AbstractC1683A.n(C1704W.f5321a, exceptionHandler, new C11351(context, status, null), 2);
    }

    public final void saveReadClipboardStatus(Context context) {
        kotlin.jvm.internal.k.f(context, "context");
        if (ReadClipboardUtils.READ_CLIPBOARD_PERMISSION_AGREE == getReadClipboardStatus(context)) {
            return;
        }
        AbstractC1683A.n(C1704W.f5321a, exceptionHandler, new C11401(context, null), 2);
    }

    public final void setBrand(String str) {
        kotlin.jvm.internal.k.f(str, "<set-?>");
        brand = str;
    }

    public final void setCompanyCode(String str) {
        kotlin.jvm.internal.k.f(str, "<set-?>");
        companyCode = str;
    }

    public final void setCustomPolicyCSSFileName(String str) {
        kotlin.jvm.internal.k.f(str, "<set-?>");
        customPolicyCSSFileName = str;
    }

    public final void setInitSDKByDeviceProtectedStorageContext(boolean z10) {
        initSDKByDeviceProtectedStorageContext = z10;
    }

    public final void setLocalAssetsCategoryPathMap(HashMap<String, String> map) {
        kotlin.jvm.internal.k.f(map, "<set-?>");
        localAssetsCategoryPathMap = map;
    }

    public final void setMAppId(String str) {
        kotlin.jvm.internal.k.f(str, "<set-?>");
        mAppId = str;
    }

    public final void setMAppSecret(String str) {
        kotlin.jvm.internal.k.f(str, "<set-?>");
        mAppSecret = str;
    }

    public final void setMAppVersionName(String str) {
        kotlin.jvm.internal.k.f(str, "<set-?>");
        mAppVersionName = str;
    }

    public final void setModel(String str) {
        kotlin.jvm.internal.k.f(str, "<set-?>");
        model = str;
    }

    public final void setOsVersion(String str) {
        kotlin.jvm.internal.k.f(str, "<set-?>");
        osVersion = str;
    }

    public final void setSyncLocalFileFinished(boolean z10) {
        syncLocalFileFinished = z10;
    }
}
