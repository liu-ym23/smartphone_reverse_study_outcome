package com.stepos.ailauncher.task.detail;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Process;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.DownloadListener;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.Toast;
import androidx.core.view.a0;
import androidx.core.widget.NestedScrollView;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.core.JsonFactory;
import com.stepos.agentframework.uikit.AIMDTextView;
import com.stepos.ailauncher.container.R$attr;
import com.stepos.ailauncher.task.R$color;
import com.stepos.ailauncher.task.R$dimen;
import com.stepos.ailauncher.task.R$id;
import com.stepos.ailauncher.task.R$layout;
import com.stepos.ailauncher.task.R$string;
import com.stepos.ailauncher.task.detail.TaskWebView;
import com.stepos.ame.sdk.SkillStoreKt;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import com.zyql.intenttaskmanager.bean.TaskUIData;
import io.ktor.sse.ServerSentEventKt;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import p7.AppUI;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u0000 \u0095\u00012\u00020\u0001:\u0004\u0096\u0001\u0097\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u0019\u0010\u000e\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0012\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00102\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0019\u0010\nJ\u000f\u0010\u001a\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001a\u0010\nJ\u0019\u0010\u001c\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001e\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010\"\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\fH\u0002¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\fH\u0002¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\bH\u0002¢\u0006\u0004\b&\u0010\nJ\u000f\u0010'\u001a\u00020\bH\u0002¢\u0006\u0004\b'\u0010\nJ\u000f\u0010(\u001a\u00020\u0010H\u0002¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\bH\u0002¢\u0006\u0004\b*\u0010\nJ\u001f\u0010,\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010+\u001a\u00020\u0010H\u0002¢\u0006\u0004\b,\u0010-J\r\u0010.\u001a\u00020\b¢\u0006\u0004\b.\u0010\nJ\r\u0010/\u001a\u00020\b¢\u0006\u0004\b/\u0010\nJ\r\u00101\u001a\u000200¢\u0006\u0004\b1\u00102J\r\u00103\u001a\u000200¢\u0006\u0004\b3\u00102J\u0017\u00105\u001a\u0002002\u0006\u00104\u001a\u00020\fH\u0016¢\u0006\u0004\b5\u00106J\u0015\u00107\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b7\u0010\u001dJ\r\u00108\u001a\u000200¢\u0006\u0004\b8\u00102J\u001d\u0010;\u001a\u00020\b2\u0006\u00109\u001a\u00020\f2\u0006\u0010:\u001a\u00020\f¢\u0006\u0004\b;\u0010<J\u0015\u0010=\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b=\u0010\u001dJ\u0015\u0010?\u001a\u00020\b2\u0006\u0010>\u001a\u00020\u0010¢\u0006\u0004\b?\u0010\u001dJ9\u0010C\u001a\u00020\b2\u0006\u00109\u001a\u00020\f2\u0006\u0010:\u001a\u00020\f2\b\b\u0002\u0010@\u001a\u00020\u00102\u0010\b\u0002\u0010B\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010A¢\u0006\u0004\bC\u0010DJ\r\u0010E\u001a\u00020\b¢\u0006\u0004\bE\u0010\nJ!\u0010H\u001a\u00020\b2\b\u0010F\u001a\u0004\u0018\u00010\u00102\b\u0010G\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\bH\u0010IJ\u001f\u0010L\u001a\u00020\b2\u0006\u0010J\u001a\u00020\u00102\b\u0010K\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\bL\u0010IJ\r\u0010M\u001a\u00020\b¢\u0006\u0004\bM\u0010\nR\u0016\u0010N\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u0014\u0010P\u001a\u00020\u00108\u0002X\u0082D¢\u0006\u0006\n\u0004\bP\u0010QR\u0014\u0010R\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\u0014\u0010U\u001a\u00020T8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\u0014\u0010X\u001a\u00020W8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\u0018\u0010Z\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010]\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010_\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010\u0019R\u0016\u0010`\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u00101R\u0016\u0010a\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u00101R\u0016\u0010b\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010QR*\u0010c\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010A8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bc\u0010d\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR*\u0010i\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010A8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bi\u0010d\u001a\u0004\bj\u0010f\"\u0004\bk\u0010hR*\u0010l\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010A8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bl\u0010d\u001a\u0004\bm\u0010f\"\u0004\bn\u0010hR2\u0010p\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\b\u0018\u00010o8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bp\u0010q\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR0\u0010v\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\b\u0018\u00010o8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bv\u0010q\u001a\u0004\bw\u0010s\"\u0004\bx\u0010uR*\u0010y\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010A8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\by\u0010d\u001a\u0004\bz\u0010f\"\u0004\b{\u0010hR\u0016\u0010|\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u00101R\u0016\u0010}\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b}\u00101R\u0016\u0010~\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b~\u00101R\u0016\u0010\u007f\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u007f\u0010\u0019R4\u0010\u0080\u0001\u001a\u0010\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\b\u0018\u00010o8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0080\u0001\u0010q\u001a\u0005\b\u0081\u0001\u0010s\"\u0005\b\u0082\u0001\u0010uR\u001b\u0010\u0083\u0001\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u001a\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0085\u0001\u0010QR\u001a\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0086\u0001\u0010QR5\u0010\u0089\u0001\u001a \u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0A0\u0087\u0001j\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0A`\u0088\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001R\u0018\u0010\u008b\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008b\u0001\u00101R\u0018\u0010\u008c\u0001\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008c\u0001\u0010\u0019R\u0018\u0010\u008d\u0001\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008d\u0001\u0010\u0019R\u0018\u0010\u008e\u0001\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008e\u0001\u0010\u0019R\u0018\u0010\u008f\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008f\u0001\u00101R.\u0010\u0090\u0001\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010A8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0090\u0001\u0010d\u001a\u0005\b\u0091\u0001\u0010f\"\u0005\b\u0092\u0001\u0010hR\u0016\u0010\u0094\u0001\u001a\u0002008@X\u0080\u0004¢\u0006\u0007\u001a\u0005\b\u0093\u0001\u00102¨\u0006\u0098\u0001"}, d2 = {"Lcom/stepos/ailauncher/task/detail/TaskWebView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "LY8/t;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()V", "Q", "", "httpStatus", "Y", "(Ljava/lang/Integer;)V", "", "url", "o0", "(Ljava/lang/String;)Ljava/lang/String;", "prefix", "Landroid/webkit/WebView;", AppUI.TYPE_WEB, "p0", "(Ljava/lang/String;Landroid/webkit/WebView;)V", "Z", ExifInterface.GPS_DIRECTION_TRUE, "result", "R", "(Ljava/lang/String;)V", "viewportPx", "B", "(I)Ljava/lang/String;", "px", "r0", "(II)Ljava/lang/String;", "a0", "()I", "G", "P", "X", "()Ljava/lang/String;", "h0", "label", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(Landroid/webkit/WebView;Ljava/lang/String;)V", "n0", "m0", "", "I", "()Z", "J", "direction", "canScrollVertically", "(I)Z", ExifInterface.LATITUDE_SOUTH, "D", "topPx", "bottomPx", "g0", "(II)V", "O", "html", "L", "colorHex", "Lkotlin/Function0;", "onApplied", "b0", "(IILjava/lang/String;Lp9/a;)V", "C", "resultSrc", "resultContent", "M", "(Ljava/lang/String;Ljava/lang/String;)V", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "language", "K", "F", "mContext", "Landroid/content/Context;", "TAG", "Ljava/lang/String;", "webviewContainer", "Landroid/widget/FrameLayout;", "Landroidx/core/widget/NestedScrollView;", "scrollView", "Landroidx/core/widget/NestedScrollView;", "Lcom/stepos/agentframework/uikit/AIMDTextView;", "tvMarkdown", "Lcom/stepos/agentframework/uikit/AIMDTextView;", "systemWebView", "Landroid/webkit/WebView;", "Lcom/zyql/intenttaskmanager/bean/TaskUIData;", "appUIData", "Lcom/zyql/intenttaskmanager/bean/TaskUIData;", "isInitWeb", "topSpacerPx", "bottomSpacerPx", "spacerColorHex", "onContentFirstPaint", "Lp9/a;", "getOnContentFirstPaint", "()Lp9/a;", "setOnContentFirstPaint", "(Lp9/a;)V", "onShapeSettled", "getOnShapeSettled", "setOnShapeSettled", "onViewportHeightChanged", "getOnViewportHeightChanged", "setOnViewportHeightChanged", "Lkotlin/Function1;", "onMainFrameLoadFailed", "Lp9/l;", "getOnMainFrameLoadFailed", "()Lp9/l;", "setOnMainFrameLoadFailed", "(Lp9/l;)V", "onTreatedAsDownload", "getOnTreatedAsDownload", "setOnTreatedAsDownload", "onScrollChanged", "getOnScrollChanged", "setOnScrollChanged", "mainFrameNavToken", "mainFrameFailureToken", "traceNavigationId", "shapeSettled", "onPlainFlowDetected", "getOnPlainFlowDetected", "setOnPlainFlowDetected", "lastPlainFlow", "Ljava/lang/Boolean;", "lastSpacerKey", "spacerInFlightKey", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "spacerInFlightCallbacks", "Ljava/util/ArrayList;", "spacerFlightGen", "spacerRejected", "loadedViaData", "externalUrlShowing", "markdownScrollY", "onContentMetricsProbed", "getOnContentMetricsProbed", "setOnContentMetricsProbed", "H", "isLoadedViaData", "Companion", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@SuppressLint({"SetJavaScriptEnabled"})
/* loaded from: classes3.dex */
public final class TaskWebView extends FrameLayout {
    public static final String EDGE_SPACER_TRANSPARENT = "transparent";
    private static final String FORCE_TEXT_SELECT_JS = "(function(){if(document.querySelector('style[data-force-select]'))return;var s=document.createElement('style');s.setAttribute('data-force-select','1');s.innerHTML='html,body,div,article,section,main,table,tr,thead,tbody,tfoot,ol,ul,details{-webkit-user-select:none!important;user-select:none!important;}'+'p,span,td,th,li,pre,code,h1,h2,h3,h4,h5,h6,a,blockquote,em,strong,b,i,u,label,figcaption,dt,dd,mark,small,sub,sup,time,button,input,textarea,select,option,caption,summary{-webkit-user-select:text!important;user-select:text!important;}';(document.head||document.documentElement).appendChild(s);})();";
    private static final String HTML_DATA_BASE_URL = "https://localhost/";
    private static final String JS_BRIDGE_NAME = "NativeBridge";
    public static final String LOCAL_HTML = "file:///android_asset/space_snake.html";
    private static final String PLAIN_FLOW_PROBE_JS = "(function(){var b=document.body,d=document.documentElement;if(!b||!d)return '0:nodoc';var H=window.innerHeight||0;if(H<=0)return '0:noh';var dcs=getComputedStyle(d),bcs=getComputedStyle(b);var bord=(parseFloat(dcs.borderTopWidth)||0)+(parseFloat(dcs.borderBottomWidth)||0);var SH=Math.max(0,Math.max(d.scrollHeight,b.scrollHeight)-bord);if(window.__pfR&&window.__pfH===H&&window.__pfS===SH)return window.__pfR;function nearFull(cs){var h=parseFloat(cs.height),m=parseFloat(cs.minHeight);return m>=H*0.9||(h>=H*0.9&&h<=H*1.15);}function rootNearFull(cs){return nearFull(cs)&&SH<=H*1.15;}var res='1';if(rootNearFull(dcs)||rootNearFull(bcs))res='0:rootvh';else if(SH<=H*1.05)res='0:noscroll,SH='+SH+',H='+H;else{var all=b.querySelectorAll('*'),N=all.length;function risky(){if(b.querySelector('[style*=\"fixed\"],[style*=\"sticky\"]'))return 1;var ss=document.styleSheets;for(var k=0;k<ss.length;k++){var rs;try{rs=ss[k].cssRules;}catch(e){return 1;}if(!rs)continue;for(var r=0;r<rs.length;r++){var t=rs[r].cssText;if(!t)continue;if(t.indexOf('fixed')>=0||t.indexOf('sticky')>=0||t.indexOf('100vh')>=0||t.indexOf('100dvh')>=0)return 1;}}return 0;}if(N>4000)res=risky()?'0:rules,N='+N:'1';else for(var i=0;i<N;i++){var cs=getComputedStyle(all[i]);if(cs.position==='fixed'||cs.position==='sticky'){res='0:'+cs.position+','+all[i].tagName;break;}if(nearFull(cs)){res='0:onescreen,'+all[i].tagName;break;}}}window.__pfH=H;window.__pfS=SH;window.__pfR=res;return res;})();";
    private static final String SELECTION_GUARD_JS = "(function(){if(window.__selectionGuardBound)return;window.__selectionGuardBound=1;var st=null,moved=0,pending=0,SLOP=12,MOVE2=100;function ptInSel(x,y){var sel=window.getSelection();if(!sel||!sel.rangeCount||sel.isCollapsed)return true;var rects=sel.getRangeAt(0).getClientRects();for(var i=0;i<rects.length;i++){var r=rects[i];if(x>=r.left-SLOP&&x<=r.right+SLOP&&y>=r.top-SLOP&&y<=r.bottom+SLOP)return true;}return false;}function guard(){if(moved||!st)return;var sel=window.getSelection();if(!sel||sel.isCollapsed||!sel.toString().trim())return;if(!ptInSel(st.x,st.y))sel.removeAllRanges();}function schedule(){if(pending)return;pending=1;setTimeout(function(){pending=0;guard();},0);}function down(x,y){st={x:x,y:y};moved=0;}function move(x,y){if(!st)return;var dx=x-st.x,dy=y-st.y;if(dx*dx+dy*dy>MOVE2)moved=1;}document.addEventListener('touchstart',function(e){if(e.touches.length)down(e.touches[0].clientX,e.touches[0].clientY);},true);document.addEventListener('touchmove',function(e){if(e.touches.length)move(e.touches[0].clientX,e.touches[0].clientY);},true);document.addEventListener('touchend',schedule,true);document.addEventListener('selectionchange',schedule);})();";
    private final String TAG;
    private TaskUIData appUIData;
    private int bottomSpacerPx;
    private boolean externalUrlShowing;
    private boolean isInitWeb;
    private Boolean lastPlainFlow;
    private String lastSpacerKey;
    private boolean loadedViaData;
    private Context mContext;
    private int mainFrameFailureToken;
    private int mainFrameNavToken;
    private int markdownScrollY;
    private InterfaceC5063a<Y8.t> onContentFirstPaint;
    private InterfaceC5063a<Y8.t> onContentMetricsProbed;
    private InterfaceC5074l<? super Integer, Y8.t> onMainFrameLoadFailed;
    private InterfaceC5074l<? super Boolean, Y8.t> onPlainFlowDetected;
    private InterfaceC5063a<Y8.t> onScrollChanged;
    private InterfaceC5063a<Y8.t> onShapeSettled;
    private InterfaceC5074l<? super String, Y8.t> onTreatedAsDownload;
    private InterfaceC5063a<Y8.t> onViewportHeightChanged;
    private final NestedScrollView scrollView;
    private boolean shapeSettled;
    private String spacerColorHex;
    private int spacerFlightGen;
    private final ArrayList<InterfaceC5063a<Y8.t>> spacerInFlightCallbacks;
    private String spacerInFlightKey;
    private boolean spacerRejected;
    private WebView systemWebView;
    private int topSpacerPx;
    private int traceNavigationId;
    private final AIMDTextView tvMarkdown;
    private final FrameLayout webviewContainer;
    private static final long[] PROBE_DELAYS_MS = {0, 800, com.stepos.ailauncher.speech.tts.l.SAFE_CLOSE_LEAD_MS};
    private static final Set<String> IN_PAGE_SCHEMES = Z8.Y.j("http", "https", Const.STR_FILE, "about");
    private static final Set<String> EXTERNAL_LINK_SCHEMES = Z8.Y.j("http", "https");

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u000b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\t\u0010\nJ'\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0011\u0010\u0006J\u001f\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/ailauncher/task/detail/TaskWebView$b;", "", "<init>", "(Lcom/stepos/ailauncher/task/detail/TaskWebView;)V", "LY8/t;", "goBack", "()V", "", "url", "openExternalLink", "(Ljava/lang/String;)V", "", Parameters.LATITUDE, Parameters.LONGITUDE, "destinationName", "openNavigation", "(DDLjava/lang/String;)V", "requestLocation", "imageUrl", "fileName", "downloadImage", "(Ljava/lang/String;Ljava/lang/String;)V", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class b {
        public b() {
        }

        public static final void d(TaskWebView taskWebView) {
            Toast.makeText(taskWebView.getContext(), taskWebView.getContext().getString(R$string.task_detail_image_saved_to_gallery), 0).show();
        }

        public static final void e(TaskWebView taskWebView) {
            WebView webView = taskWebView.systemWebView;
            if (webView != null && webView.canGoBack()) {
                webView.goBack();
                return;
            }
            Context context = taskWebView.getContext();
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity != null) {
                activity.finish();
            }
        }

        public static final void f(TaskWebView taskWebView) {
            WebView webView = taskWebView.systemWebView;
            if (webView != null) {
                webView.evaluateJavascript("window.onLocationReceived(121.458125, 31.162225)", null);
            }
        }

        @JavascriptInterface
        public final void downloadImage(String imageUrl, String fileName) {
            kotlin.jvm.internal.p.i(imageUrl, "imageUrl");
            kotlin.jvm.internal.p.i(fileName, "fileName");
            com.stepos.ailauncher.common.utils.A aC = com.stepos.ailauncher.common.utils.A.INSTANCE.c();
            Context context = TaskWebView.this.getContext();
            kotlin.jvm.internal.p.h(context, "getContext(...)");
            if (!aC.c(context, imageUrl, fileName)) {
                Log.w(TaskWebView.this.TAG, "downloadImage rejected");
                return;
            }
            WebView webView = TaskWebView.this.systemWebView;
            if (webView != null) {
                final TaskWebView taskWebView = TaskWebView.this;
                webView.post(new Runnable() { // from class: com.stepos.ailauncher.task.detail.Y0
                    @Override // java.lang.Runnable
                    public final void run() {
                        TaskWebView.b.d(taskWebView);
                    }
                });
            }
        }

        @JavascriptInterface
        public final void goBack() {
            WebView webView = TaskWebView.this.systemWebView;
            if (webView != null) {
                final TaskWebView taskWebView = TaskWebView.this;
                webView.post(new Runnable() { // from class: com.stepos.ailauncher.task.detail.W0
                    @Override // java.lang.Runnable
                    public final void run() {
                        TaskWebView.b.e(taskWebView);
                    }
                });
            }
        }

        @JavascriptInterface
        public final void openExternalLink(String url) {
            String lowerCase;
            kotlin.jvm.internal.p.i(url, "url");
            Uri uri = Uri.parse(url);
            Set set = TaskWebView.EXTERNAL_LINK_SCHEMES;
            String scheme = uri.getScheme();
            if (scheme != null) {
                lowerCase = scheme.toLowerCase(Locale.ROOT);
                kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
            } else {
                lowerCase = null;
            }
            if (Z8.F.f0(set, lowerCase)) {
                try {
                    TaskWebView.this.getContext().startActivity(new Intent("android.intent.action.VIEW", uri));
                    return;
                } catch (Throwable th) {
                    Log.w(TaskWebView.this.TAG, "openExternalLink failed", th);
                    return;
                }
            }
            Log.w(TaskWebView.this.TAG, "openExternalLink rejected: scheme=" + uri.getScheme());
        }

        @JavascriptInterface
        public final void openNavigation(double latitude, double longitude, String destinationName) {
            kotlin.jvm.internal.p.i(destinationName, "destinationName");
            try {
                TaskWebView.this.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse("geo:" + latitude + Const.STR_MART_COMMA + longitude + "?q=" + latitude + Const.STR_MART_COMMA + longitude + "(" + destinationName + ")")));
            } catch (Throwable th) {
                Log.w(TaskWebView.this.TAG, "openNavigation failed", th);
            }
        }

        @JavascriptInterface
        public final void requestLocation() {
            WebView webView = TaskWebView.this.systemWebView;
            if (webView != null) {
                final TaskWebView taskWebView = TaskWebView.this;
                webView.post(new Runnable() { // from class: com.stepos.ailauncher.task.detail.X0
                    @Override // java.lang.Runnable
                    public final void run() {
                        TaskWebView.b.f(taskWebView);
                    }
                });
            }
        }
    }

    @Metadata(d1 = {"\u0000O\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ-\u0010\u000e\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0010\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0012\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0012\u0010\u0011J-\u0010\u0015\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J-\u0010\u0019\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ-\u0010\u001e\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"com/stepos/ailauncher/task/detail/TaskWebView$c", "Landroid/webkit/WebViewClient;", "Landroid/webkit/WebView;", "view", "Landroid/webkit/WebResourceRequest;", "request", "", "shouldOverrideUrlLoading", "(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;)Z", "", "url", "Landroid/graphics/Bitmap;", "favicon", "LY8/t;", "onPageStarted", "(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V", "onPageCommitVisible", "(Landroid/webkit/WebView;Ljava/lang/String;)V", "onPageFinished", "Landroid/webkit/WebResourceError;", "error", "onReceivedError", "(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;Landroid/webkit/WebResourceError;)V", "Landroid/webkit/WebResourceResponse;", "errorResponse", "onReceivedHttpError", "(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;Landroid/webkit/WebResourceResponse;)V", "Landroid/webkit/SslErrorHandler;", "handler", "Landroid/net/http/SslError;", "onReceivedSslError", "(Landroid/webkit/WebView;Landroid/webkit/SslErrorHandler;Landroid/net/http/SslError;)V", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c extends WebViewClient {
        public c() {
        }

        public static final void c(TaskWebView taskWebView, WebView webView, long j10) {
            taskWebView.T();
            taskWebView.V(webView, "t" + j10);
        }

        public static final void d(TaskWebView taskWebView, WebView webView) {
            taskWebView.V(webView, "t5000");
        }

        @Override // android.webkit.WebViewClient
        public void onPageCommitVisible(final WebView view, String url) {
            super.onPageCommitVisible(view, url);
            Log.i("PptTrace", "onPageCommitVisible nav=" + TaskWebView.this.traceNavigationId + " url=" + TaskWebView.this.o0(url) + " web=" + (view != null ? Integer.valueOf(System.identityHashCode(view)) : null));
            TaskWebView.this.p0("onPageCommitVisible", view);
            if (!kotlin.jvm.internal.p.d(url, "about:blank") || TaskWebView.this.loadedViaData) {
                if (view != null) {
                    view.evaluateJavascript(TaskWebView.FORCE_TEXT_SELECT_JS, null);
                }
                if (view != null) {
                    view.evaluateJavascript(TaskWebView.SELECTION_GUARD_JS, null);
                }
                TaskWebView.this.Z();
                InterfaceC5063a<Y8.t> onContentFirstPaint = TaskWebView.this.getOnContentFirstPaint();
                if (onContentFirstPaint != null) {
                    onContentFirstPaint.invoke();
                }
                long[] jArr = TaskWebView.PROBE_DELAYS_MS;
                final TaskWebView taskWebView = TaskWebView.this;
                for (final long j10 : jArr) {
                    if (view != null) {
                        view.postDelayed(new Runnable() { // from class: com.stepos.ailauncher.task.detail.Z0
                            @Override // java.lang.Runnable
                            public final void run() {
                                TaskWebView.c.c(taskWebView, view, j10);
                            }
                        }, j10);
                    }
                }
                if (view != null) {
                    final TaskWebView taskWebView2 = TaskWebView.this;
                    view.postDelayed(new Runnable() { // from class: com.stepos.ailauncher.task.detail.a1
                        @Override // java.lang.Runnable
                        public final void run() {
                            TaskWebView.c.d(taskWebView2, view);
                        }
                    }, 5000L);
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            Log.i(TaskWebView.this.TAG, "onPageFinished url=" + (url != null ? La.K.R1(url, com.stepos.ailauncher.chat.wake.circle.F.LOOP_END_FRAME) : null) + " progress=" + (view != null ? Integer.valueOf(view.getProgress()) : null) + " title=" + (view != null ? view.getTitle() : null) + " contentH=" + (view != null ? Integer.valueOf(view.getContentHeight()) : null));
            TaskWebView.this.p0("onPageFinished", view);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            Log.i("PptTrace", "onPageStarted nav=" + TaskWebView.this.traceNavigationId + " url=" + TaskWebView.this.o0(url) + " web=" + (view != null ? Integer.valueOf(System.identityHashCode(view)) : null));
            TaskWebView.this.p0("onPageStarted", view);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            super.onReceivedError(view, request, error);
            String str = TaskWebView.this.TAG;
            Integer numValueOf = error != null ? Integer.valueOf(error.getErrorCode()) : null;
            CharSequence description = error != null ? error.getDescription() : null;
            Log.w(str, "onReceivedError code=" + numValueOf + " desc=" + ((Object) description) + " isMainFrame=" + (request != null ? Boolean.valueOf(request.isForMainFrame()) : null) + " url=" + (request != null ? request.getUrl() : null));
            if (request == null || !request.isForMainFrame()) {
                return;
            }
            TaskWebView.this.Y(null);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
            int statusCode;
            super.onReceivedHttpError(view, request, errorResponse);
            Log.w(TaskWebView.this.TAG, "onReceivedHttpError status=" + (errorResponse != null ? Integer.valueOf(errorResponse.getStatusCode()) : null) + " reason=" + (errorResponse != null ? errorResponse.getReasonPhrase() : null) + " mime=" + (errorResponse != null ? errorResponse.getMimeType() : null) + " encoding=" + (errorResponse != null ? errorResponse.getEncoding() : null) + " headers=" + (errorResponse != null ? errorResponse.getResponseHeaders() : null) + " isMainFrame=" + (request != null ? Boolean.valueOf(request.isForMainFrame()) : null) + " url=" + (request != null ? request.getUrl() : null));
            if (request == null || !request.isForMainFrame() || errorResponse == null || (statusCode = errorResponse.getStatusCode()) < 400) {
                return;
            }
            TaskWebView.this.Y(Integer.valueOf(statusCode));
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            Log.w(TaskWebView.this.TAG, "onReceivedSslError " + error + " url=" + (error != null ? error.getUrl() : null));
            super.onReceivedSslError(view, handler, error);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            String lowerCase;
            kotlin.jvm.internal.p.i(view, "view");
            kotlin.jvm.internal.p.i(request, "request");
            Uri url = request.getUrl();
            Log.i(TaskWebView.this.TAG, "shouldOverrideUrlLoading url=" + url + " isMainFrame=" + request.isForMainFrame());
            Set set = TaskWebView.IN_PAGE_SCHEMES;
            String scheme = url.getScheme();
            if (scheme != null) {
                lowerCase = scheme.toLowerCase(Locale.ROOT);
                kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
            } else {
                lowerCase = null;
            }
            if (Z8.F.f0(set, lowerCase)) {
                return false;
            }
            Log.w(TaskWebView.this.TAG, "block navigation to non-web scheme=" + url.getScheme());
            return true;
        }
    }

    @Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0010\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"com/stepos/ailauncher/task/detail/TaskWebView$d", "Landroid/webkit/WebChromeClient;", "Landroid/webkit/WebView;", "view", "", "newProgress", "LY8/t;", "onProgressChanged", "(Landroid/webkit/WebView;I)V", "Landroid/webkit/ConsoleMessage;", "consoleMessage", "", "onConsoleMessage", "(Landroid/webkit/ConsoleMessage;)Z", "", "title", "onReceivedTitle", "(Landroid/webkit/WebView;Ljava/lang/String;)V", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d extends WebChromeClient {
        public d() {
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            Log.i(TaskWebView.this.TAG, "console[" + (consoleMessage != null ? consoleMessage.messageLevel() : null) + "] " + (consoleMessage != null ? consoleMessage.message() : null) + " @" + (consoleMessage != null ? consoleMessage.sourceId() : null) + ServerSentEventKt.COLON + (consoleMessage != null ? Integer.valueOf(consoleMessage.lineNumber()) : null));
            return super.onConsoleMessage(consoleMessage);
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView view, int newProgress) {
            Log.d(TaskWebView.this.TAG, "onProgressChanged " + newProgress);
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
            Log.i(TaskWebView.this.TAG, "onReceivedTitle title=" + title);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.p.i(context, "context");
        this.TAG = "TaskWebView";
        this.spacerColorHex = "#000000";
        this.mainFrameFailureToken = -1;
        this.spacerInFlightCallbacks = new ArrayList<>(2);
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.view_task_web, (ViewGroup) this, true);
        this.mContext = context;
        View viewFindViewById = viewInflate.findViewById(R$id.webviewContainer);
        kotlin.jvm.internal.p.h(viewFindViewById, "findViewById(...)");
        this.webviewContainer = (FrameLayout) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(R$id.scrollView);
        kotlin.jvm.internal.p.h(viewFindViewById2, "findViewById(...)");
        NestedScrollView nestedScrollView = (NestedScrollView) viewFindViewById2;
        this.scrollView = nestedScrollView;
        View viewFindViewById3 = viewInflate.findViewById(R$id.tvMarkdown);
        kotlin.jvm.internal.p.h(viewFindViewById3, "findViewById(...)");
        this.tvMarkdown = (AIMDTextView) viewFindViewById3;
        nestedScrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.stepos.ailauncher.task.detail.K0
            @Override // android.view.View.OnScrollChangeListener
            public final void onScrollChange(View view, int i10, int i11, int i12, int i13) {
                TaskWebView.m(this.f28464a, view, i10, i11, i12, i13);
            }
        });
    }

    public static final void E(TaskWebView taskWebView) {
        taskWebView.scrollView.scrollTo(0, taskWebView.markdownScrollY);
    }

    public static final boolean N(TaskWebView taskWebView, String url) {
        kotlin.jvm.internal.p.i(url, "url");
        if (!La.D.X(url, "http://", false, 2, null) && !La.D.X(url, "https://", false, 2, null)) {
            return false;
        }
        taskWebView.S(url);
        return true;
    }

    public static final void U(TaskWebView taskWebView, String str) {
        boolean zD = kotlin.jvm.internal.p.d(str != null ? La.H.E1(str, JsonFactory.DEFAULT_QUOTE_CHAR) : null, "1");
        if (!kotlin.jvm.internal.p.d(taskWebView.lastPlainFlow, Boolean.valueOf(zD))) {
            taskWebView.lastPlainFlow = Boolean.valueOf(zD);
            Log.i(taskWebView.TAG, "probePlainFlow plainFlow=" + zD + " raw=" + str + " (false = viewport-anchored, host insets webview)");
            InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l = taskWebView.onPlainFlowDetected;
            if (interfaceC5074l != null) {
                interfaceC5074l.invoke(Boolean.valueOf(zD));
            }
        }
        InterfaceC5063a<Y8.t> interfaceC5063a = taskWebView.onContentMetricsProbed;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
        taskWebView.Q();
    }

    public static final void W(String str, TaskWebView taskWebView, WebView webView, String str2) {
        Log.i("PptTrace", "domProbe label=" + str + " nav=" + taskWebView.traceNavigationId + " web=" + System.identityHashCode(webView) + " result=" + str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void c0(TaskWebView taskWebView, int i10, int i11, String str, InterfaceC5063a interfaceC5063a, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            str = "#000000";
        }
        if ((i12 & 8) != 0) {
            interfaceC5063a = null;
        }
        taskWebView.b0(i10, i11, str, interfaceC5063a);
    }

    public static final void d0(final TaskWebView taskWebView, final int i10, String str, final WebView webView, String str2) {
        taskWebView.R(str2);
        if (i10 != taskWebView.spacerFlightGen) {
            return;
        }
        final ArrayList arrayList = new ArrayList(taskWebView.spacerInFlightCallbacks);
        taskWebView.spacerInFlightCallbacks.clear();
        taskWebView.spacerInFlightKey = null;
        taskWebView.lastSpacerKey = str;
        if (arrayList.isEmpty()) {
            return;
        }
        webView.postOnAnimation(new Runnable() { // from class: com.stepos.ailauncher.task.detail.O0
            @Override // java.lang.Runnable
            public final void run() {
                TaskWebView.e0(i10, taskWebView, webView, arrayList);
            }
        });
    }

    public static final void e0(final int i10, final TaskWebView taskWebView, WebView webView, final ArrayList arrayList) {
        if (i10 != taskWebView.spacerFlightGen) {
            return;
        }
        webView.postOnAnimation(new Runnable() { // from class: com.stepos.ailauncher.task.detail.Q0
            @Override // java.lang.Runnable
            public final void run() {
                TaskWebView.f0(i10, taskWebView, arrayList);
            }
        });
    }

    public static final void f0(int i10, TaskWebView taskWebView, ArrayList arrayList) {
        if (i10 == taskWebView.spacerFlightGen) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((InterfaceC5063a) it.next()).invoke();
            }
        }
    }

    public static final androidx.core.view.a0 i0(View view, androidx.core.view.a0 insets) {
        kotlin.jvm.internal.p.i(view, "<unused var>");
        kotlin.jvm.internal.p.i(insets, "insets");
        return new a0.a(insets).b(a0.o.b(), t0.e.f41976e).a();
    }

    public static final void j0(WebView webView, TaskWebView taskWebView, View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        InterfaceC5063a<Y8.t> interfaceC5063a;
        int i18 = i12 - i10;
        int i19 = i13 - i11;
        int i20 = i16 - i14;
        int i21 = i17 - i15;
        if (i18 != i20 || i19 != i21 || i11 != i15) {
            int iIdentityHashCode = System.identityHashCode(webView);
            ViewGroup.LayoutParams layoutParams = webView.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
            Integer numValueOf = marginLayoutParams != null ? Integer.valueOf(marginLayoutParams.topMargin) : null;
            Log.i("PptTrace", "layout systemWeb=" + iIdentityHashCode + " new=" + i18 + "x" + i19 + " old=" + i20 + "x" + i21 + " top=" + i11 + " oldTop=" + i15 + " margin=" + numValueOf + " nav=" + taskWebView.traceNavigationId);
        }
        if (i19 == i21 || (interfaceC5063a = taskWebView.onViewportHeightChanged) == null) {
            return;
        }
        interfaceC5063a.invoke();
    }

    public static final void k0(TaskWebView taskWebView, View view, int i10, int i11, int i12, int i13) {
        InterfaceC5063a<Y8.t> interfaceC5063a = taskWebView.onScrollChanged;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
    }

    public static final void l0(TaskWebView taskWebView, String str, String str2, String str3, String str4, long j10) {
        InterfaceC5074l<? super String, Y8.t> interfaceC5074l;
        Log.w(taskWebView.TAG, "DownloadListener triggered — WebView treated response as download, NOT rendering page. url=" + (str != null ? La.K.R1(str, com.stepos.ailauncher.chat.wake.circle.F.LOOP_END_FRAME) : null) + " mime=" + str4 + " contentDisposition=" + str3 + " len=" + j10);
        if (str == null || (interfaceC5074l = taskWebView.onTreatedAsDownload) == null) {
            return;
        }
        interfaceC5074l.invoke(str);
    }

    public static final void m(TaskWebView taskWebView, View view, int i10, int i11, int i12, int i13) {
        InterfaceC5063a<Y8.t> interfaceC5063a = taskWebView.onScrollChanged;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
    }

    public static /* synthetic */ void q0(TaskWebView taskWebView, String str, WebView webView, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            webView = taskWebView.systemWebView;
        }
        taskWebView.p0(str, webView);
    }

    public final void A() {
        this.mainFrameNavToken++;
        this.mainFrameFailureToken = -1;
        this.shapeSettled = false;
    }

    public final String B(int viewportPx) {
        String str;
        if ((this.topSpacerPx > 0 || this.bottomSpacerPx > 0) && viewportPx <= 0) {
            return null;
        }
        if (kotlin.jvm.internal.p.d(this.spacerColorHex, EDGE_SPACER_TRANSPARENT)) {
            str = "background-color:transparent;background-image:linear-gradient(transparent,transparent);";
        } else {
            str = "background-color:" + this.spacerColorHex + Const.STR_MART_SEMICOLON;
        }
        String strR0 = r0(this.topSpacerPx, viewportPx);
        String strR02 = r0(this.bottomSpacerPx, viewportPx);
        String str2 = this.spacerColorHex;
        return "(function(){var d=document.documentElement;if(!d)return '';var TV=" + strR0 + ",BV=" + strR02 + ";var s=document.getElementById('__edge_spacer_style');if(!(TV>0||BV>0)){if(s&&s.parentNode)s.parentNode.removeChild(s);return '';}var fresh=!s,pre=fresh?d.scrollHeight:0;if(!s){s=document.createElement('style');s.id='__edge_spacer_style';(document.head||d).appendChild(s);}s.textContent='html{box-sizing:border-box!important;" + str + "'+'border-top:'+TV+'vh solid " + str2 + "!important;'+'border-bottom:'+BV+'vh solid " + str2 + "!important;}';if(!fresh)return '';var cs=getComputedStyle(d);var need=(parseFloat(cs.borderTopWidth)||0)+(parseFloat(cs.borderBottomWidth)||0);return (d.scrollHeight-pre)>=need*0.9?'1':'0';})();";
    }

    public final void C() {
        c0(this, 0, 0, this.spacerColorHex, null, 8, null);
    }

    public final boolean D() {
        WebSettings settings;
        if (!this.externalUrlShowing) {
            return false;
        }
        this.externalUrlShowing = false;
        WebView webView = this.systemWebView;
        if (webView != null && (settings = webView.getSettings()) != null) {
            settings.setAllowFileAccess(true);
            settings.setAllowFileAccessFromFileURLs(true);
            settings.setAllowUniversalAccessFromFileURLs(true);
            settings.setMixedContentMode(0);
        }
        WebView webView2 = this.systemWebView;
        if (webView2 != null) {
            webView2.addJavascriptInterface(new b(), JS_BRIDGE_NAME);
        }
        WebView webView3 = this.systemWebView;
        if (webView3 != null) {
            webView3.loadUrl("about:blank");
        }
        m0();
        this.scrollView.post(new Runnable() { // from class: com.stepos.ailauncher.task.detail.P0
            @Override // java.lang.Runnable
            public final void run() {
                TaskWebView.E(this.f28482a);
            }
        });
        return true;
    }

    public final void F() {
        WebView webView = this.systemWebView;
        if (webView != null) {
            com.stepos.ailauncher.common.memory.d.INSTANCE.w("webview");
            webView.destroy();
        }
        this.systemWebView = null;
    }

    public final void G() {
        if (this.isInitWeb) {
            return;
        }
        P();
        this.webviewContainer.setVisibility(0);
        h0();
        this.isInitWeb = true;
        Log.i(this.TAG, "initWeb done");
    }

    /* renamed from: H, reason: from getter */
    public final boolean getLoadedViaData() {
        return this.loadedViaData;
    }

    public final boolean I() {
        return this.scrollView.getVisibility() != 0 && this.webviewContainer.getVisibility() == 0;
    }

    public final boolean J() {
        WebView webView;
        if (!I() || kotlin.jvm.internal.p.d(this.lastPlainFlow, Boolean.FALSE) || (webView = this.systemWebView) == null) {
            return false;
        }
        return webView.canScrollVertically(1) || webView.canScrollVertically(-1);
    }

    public final void K(String content, String language) throws Resources.NotFoundException {
        kotlin.jvm.internal.p.i(content, "content");
        if (content.length() == 0) {
            return;
        }
        m0();
        this.tvMarkdown.setSelectionEnabled(true);
        this.tvMarkdown.setCodeBlockSelectable(true);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.artifact_detail_code_padding_horizontal);
        this.tvMarkdown.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        this.tvMarkdown.R0(content, language);
        this.tvMarkdown.X0();
    }

    public final void L(String html) {
        kotlin.jvm.internal.p.i(html, "html");
        int i10 = this.traceNavigationId + 1;
        this.traceNavigationId = i10;
        Log.i("PptTrace", "loadHtmlData nav=" + i10 + " len=" + html.length() + " head=" + La.D.T(La.K.R1(html, 120), "\n", "\\n", false, 4, null));
        q0(this, "loadHtmlData.before", null, 2, null);
        G();
        n0();
        this.loadedViaData = true;
        this.lastPlainFlow = null;
        Z();
        this.spacerRejected = false;
        A();
        WebView webView = this.systemWebView;
        if (webView != null) {
            webView.loadDataWithBaseURL(HTML_DATA_BASE_URL, html, "text/html", "UTF-8", null);
        }
    }

    public final void M(String resultSrc, String resultContent) throws Resources.NotFoundException {
        if (resultContent == null || resultContent.length() == 0) {
            return;
        }
        m0();
        this.tvMarkdown.setTextColor(a0());
        this.tvMarkdown.S0(2, 16.0f);
        this.tvMarkdown.Q0(0.0f, 1.2f);
        this.tvMarkdown.setSelectionEnabled(true);
        this.tvMarkdown.setTableHorizontalScrollEnabled(true);
        this.tvMarkdown.setCodeBlockMaxHeight(0);
        this.tvMarkdown.setCodeBlockSelectable(true);
        this.tvMarkdown.setOnLinkClick(new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.detail.R0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(TaskWebView.N(this.f28487a, (String) obj));
            }
        });
        int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.artifact_detail_markdown_padding_horizontal);
        this.tvMarkdown.setPadding(dimensionPixelSize, 0, dimensionPixelSize, getResources().getDimensionPixelSize(R$dimen.artifact_detail_markdown_padding_bottom));
        this.tvMarkdown.setMarkdown(resultContent);
        this.tvMarkdown.X0();
    }

    public final void O(String url) {
        kotlin.jvm.internal.p.i(url, "url");
        int i10 = this.traceNavigationId + 1;
        this.traceNavigationId = i10;
        Log.i("PptTrace", "loadUrl nav=" + i10 + " url=" + o0(url) + " totalLen=" + url.length());
        q0(this, "loadUrl.before", null, 2, null);
        G();
        n0();
        this.loadedViaData = false;
        this.lastPlainFlow = null;
        Z();
        this.spacerRejected = false;
        A();
        WebView webView = this.systemWebView;
        if (webView != null) {
            webView.loadUrl(url);
        }
    }

    public final void P() {
        int iMyUid = Process.myUid();
        int iMyPid = Process.myPid();
        boolean z10 = iMyUid == 1000;
        Log.i(this.TAG, "runtimeEnv uid=" + iMyUid + " pid=" + iMyPid + " isSystemUid=" + z10 + " selinux=" + X());
        try {
            PackageInfo currentWebViewPackage = WebView.getCurrentWebViewPackage();
            Log.i(this.TAG, "systemWebViewProvider pkg=" + (currentWebViewPackage != null ? currentWebViewPackage.packageName : null) + " ver=" + (currentWebViewPackage != null ? currentWebViewPackage.versionName : null));
        } catch (Throwable th) {
            Log.w(this.TAG, "getCurrentWebViewPackage failed", th);
        }
    }

    public final void Q() {
        if (this.shapeSettled) {
            return;
        }
        this.shapeSettled = true;
        InterfaceC5063a<Y8.t> interfaceC5063a = this.onShapeSettled;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
    }

    public final void R(String result) {
        if (!this.spacerRejected && this.loadedViaData && kotlin.jvm.internal.p.d(this.lastPlainFlow, Boolean.TRUE)) {
            if (kotlin.jvm.internal.p.d(result != null ? La.H.E1(result, JsonFactory.DEFAULT_QUOTE_CHAR) : null, "0")) {
                this.spacerRejected = true;
                Boolean bool = Boolean.FALSE;
                this.lastPlainFlow = bool;
                Log.i(this.TAG, "edge spacer verify failed → fall back to inset webview");
                InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l = this.onPlainFlowDetected;
                if (interfaceC5074l != null) {
                    interfaceC5074l.invoke(bool);
                }
            }
        }
    }

    public final void S(String url) {
        WebSettings settings;
        kotlin.jvm.internal.p.i(url, "url");
        Log.i(this.TAG, "openExternalUrl in-place url=" + La.K.R1(url, com.stepos.ailauncher.chat.wake.circle.F.LOOP_END_FRAME));
        this.markdownScrollY = this.scrollView.getScrollY();
        this.externalUrlShowing = true;
        G();
        WebView webView = this.systemWebView;
        if (webView != null) {
            webView.removeJavascriptInterface(JS_BRIDGE_NAME);
        }
        WebView webView2 = this.systemWebView;
        if (webView2 != null && (settings = webView2.getSettings()) != null) {
            settings.setAllowFileAccess(false);
            settings.setAllowFileAccessFromFileURLs(false);
            settings.setAllowUniversalAccessFromFileURLs(false);
            settings.setMixedContentMode(2);
        }
        O(url);
    }

    public final void T() {
        if (!this.loadedViaData || this.spacerRejected) {
            InterfaceC5063a<Y8.t> interfaceC5063a = this.onContentMetricsProbed;
            if (interfaceC5063a != null) {
                interfaceC5063a.invoke();
            }
            Q();
            return;
        }
        WebView webView = this.systemWebView;
        if (webView == null) {
            Q();
        } else {
            webView.evaluateJavascript(PLAIN_FLOW_PROBE_JS, new ValueCallback() { // from class: com.stepos.ailauncher.task.detail.M0
                @Override // android.webkit.ValueCallback
                public final void onReceiveValue(Object obj) {
                    TaskWebView.U(this.f28471a, (String) obj);
                }
            });
        }
    }

    public final void V(final WebView web, final String label) {
        web.evaluateJavascript("(function() {\n    var d = document.documentElement;\n    var b = document.body;\n    var vv = window.visualViewport;\n    if (!window.__pptTraceResize) {\n        window.__pptTraceResize = [];\n        function record(type) {\n            var v = window.visualViewport;\n            window.__pptTraceResize.push({\n                type: type,\n                t: Date.now(),\n                iw: window.innerWidth,\n                ih: window.innerHeight,\n                vw: v ? v.width : -1,\n                vh: v ? v.height : -1\n            });\n            if (window.__pptTraceResize.length > 30) {\n                window.__pptTraceResize.shift();\n            }\n        }\n        window.addEventListener('resize', function() { record('window.resize'); });\n        if (window.visualViewport) {\n            window.visualViewport.addEventListener('resize', function() {\n                record('visualViewport.resize');\n            });\n        }\n        record('installed');\n    }\n    return JSON.stringify({\n        href: location.href,\n        innerWidth: window.innerWidth,\n        innerHeight: window.innerHeight,\n        visualWidth: vv ? vv.width : -1,\n        visualHeight: vv ? vv.height : -1,\n        dpr: window.devicePixelRatio,\n        bodyHeight: b ? b.scrollHeight : -1,\n        documentHeight: d ? d.scrollHeight : -1,\n        bodyChildren: b ? b.children.length : -1,\n        allNodes: document.querySelectorAll('*').length,\n        canvas: document.querySelectorAll('canvas').length,\n        // 分开「PDF 真有 N 页」与「viewer 铺了两套/留了 zoomLayer 重影」：\n        // pages 与 canvas 相等且 canvasSizes 父级各不相同 = 服务端页数；\n        // pages 只有一半、canvas 两两同父 = viewer 重影。spacer 标注入是否在场。\n        pages: document.querySelectorAll('.page').length,\n        spacer: !!document.getElementById('__edge_spacer_style'),\n        canvasSizes: Array.prototype.slice.call(\n            document.querySelectorAll('canvas'), 0, 24\n        ).map(function(c) {\n            return c.width + 'x' + c.height + '@' +\n                ((c.parentElement && c.parentElement.className) || '-');\n        }).join('|'),\n        svg: document.querySelectorAll('svg').length,\n        iframe: document.querySelectorAll('iframe').length,\n        img: document.querySelectorAll('img').length,\n        resizeEvents: window.__pptTraceResize\n    });\n})()", new ValueCallback() { // from class: com.stepos.ailauncher.task.detail.L0
            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(Object obj) {
                TaskWebView.W(label, this, web, (String) obj);
            }
        });
    }

    public final String X() {
        try {
            String string = La.H.D1(l9.i.o(new File("/sys/fs/selinux/enforce"), null, 1, null)).toString();
            return kotlin.jvm.internal.p.d(string, "1") ? "enforcing" : kotlin.jvm.internal.p.d(string, "0") ? "permissive" : string;
        } catch (Throwable th) {
            return "unknown(" + th.getClass().getSimpleName() + ")";
        }
    }

    public final void Y(Integer httpStatus) {
        int i10 = this.mainFrameFailureToken;
        int i11 = this.mainFrameNavToken;
        if (i10 == i11) {
            return;
        }
        this.mainFrameFailureToken = i11;
        InterfaceC5074l<? super Integer, Y8.t> interfaceC5074l = this.onMainFrameLoadFailed;
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(httpStatus);
        }
    }

    public final void Z() {
        this.lastSpacerKey = null;
        this.spacerInFlightKey = null;
        this.spacerInFlightCallbacks.clear();
        this.spacerFlightGen++;
    }

    public final int a0() {
        TypedValue typedValue = new TypedValue();
        if (!this.mContext.getTheme().resolveAttribute(R$attr.color_with_wallpaper_main, typedValue, true)) {
            return androidx.core.content.a.c(this.mContext, R$color.task_detail_on_surface);
        }
        int i10 = typedValue.resourceId;
        return i10 != 0 ? androidx.core.content.a.c(this.mContext, i10) : typedValue.data;
    }

    public final void b0(int topPx, int bottomPx, String colorHex, InterfaceC5063a<Y8.t> onApplied) {
        kotlin.jvm.internal.p.i(colorHex, "colorHex");
        this.topSpacerPx = C5685n.f(topPx, 0);
        int iF = C5685n.f(bottomPx, 0);
        this.bottomSpacerPx = iF;
        this.spacerColorHex = colorHex;
        final WebView webView = this.systemWebView;
        if (webView == null) {
            return;
        }
        final String str = this.topSpacerPx + Const.STR_MART_COMMA + iF + Const.STR_MART_COMMA + colorHex + Const.STR_MART_COMMA + webView.getHeight();
        if (kotlin.jvm.internal.p.d(str, this.lastSpacerKey) && this.spacerInFlightKey == null) {
            if (onApplied != null) {
                onApplied.invoke();
                return;
            }
            return;
        }
        if (kotlin.jvm.internal.p.d(str, this.spacerInFlightKey)) {
            if (onApplied != null) {
                this.spacerInFlightCallbacks.add(onApplied);
                return;
            }
            return;
        }
        String strB = B(webView.getHeight());
        if (strB == null) {
            return;
        }
        this.spacerInFlightCallbacks.clear();
        if (onApplied != null) {
            this.spacerInFlightCallbacks.add(onApplied);
        }
        this.spacerInFlightKey = str;
        final int i10 = this.spacerFlightGen + 1;
        this.spacerFlightGen = i10;
        webView.evaluateJavascript(strB, new ValueCallback() { // from class: com.stepos.ailauncher.task.detail.N0
            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(Object obj) {
                TaskWebView.d0(this.f28472a, i10, str, webView, (String) obj);
            }
        });
    }

    @Override // android.view.View
    public boolean canScrollVertically(int direction) {
        WebView webView = this.systemWebView;
        if (this.scrollView.getVisibility() == 0) {
            return this.scrollView.canScrollVertically(direction);
        }
        if (this.webviewContainer.getVisibility() != 0 || webView == null) {
            return super.canScrollVertically(direction);
        }
        if (kotlin.jvm.internal.p.d(this.lastPlainFlow, Boolean.FALSE)) {
            return false;
        }
        return webView.canScrollVertically(direction);
    }

    public final void g0(int topPx, int bottomPx) {
        this.scrollView.setClipToPadding(false);
        this.scrollView.setPadding(0, topPx, 0, bottomPx);
    }

    public final InterfaceC5063a<Y8.t> getOnContentFirstPaint() {
        return this.onContentFirstPaint;
    }

    public final InterfaceC5063a<Y8.t> getOnContentMetricsProbed() {
        return this.onContentMetricsProbed;
    }

    public final InterfaceC5074l<Integer, Y8.t> getOnMainFrameLoadFailed() {
        return this.onMainFrameLoadFailed;
    }

    public final InterfaceC5074l<Boolean, Y8.t> getOnPlainFlowDetected() {
        return this.onPlainFlowDetected;
    }

    public final InterfaceC5063a<Y8.t> getOnScrollChanged() {
        return this.onScrollChanged;
    }

    public final InterfaceC5063a<Y8.t> getOnShapeSettled() {
        return this.onShapeSettled;
    }

    public final InterfaceC5074l<String, Y8.t> getOnTreatedAsDownload() {
        return this.onTreatedAsDownload;
    }

    public final InterfaceC5063a<Y8.t> getOnViewportHeightChanged() {
        return this.onViewportHeightChanged;
    }

    public final void h0() {
        try {
            final WebView webView = new WebView(getContext());
            this.systemWebView = webView;
            com.stepos.ailauncher.common.memory.d.INSTANCE.v("webview");
            Log.i("PptTrace", "createWebView taskWeb=" + System.identityHashCode(this) + " systemWeb=" + System.identityHashCode(webView));
            androidx.core.view.N.u0(webView, new androidx.core.view.A() { // from class: com.stepos.ailauncher.task.detail.S0
                @Override // androidx.core.view.A
                public final androidx.core.view.a0 a(View view, androidx.core.view.a0 a0Var) {
                    return TaskWebView.i0(view, a0Var);
                }
            });
            this.webviewContainer.addView(webView, -1, -1);
            Log.i("PptTrace", "addWebView systemWeb=" + System.identityHashCode(webView) + " parent=" + System.identityHashCode(this.webviewContainer) + " childCount=" + this.webviewContainer.getChildCount());
            webView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.stepos.ailauncher.task.detail.T0
                @Override // android.view.View.OnLayoutChangeListener
                public final void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                    TaskWebView.j0(webView, this, view, i10, i11, i12, i13, i14, i15, i16, i17);
                }
            });
            WebSettings settings = webView.getSettings();
            kotlin.jvm.internal.p.h(settings, "getSettings(...)");
            webView.setBackgroundColor(0);
            webView.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.stepos.ailauncher.task.detail.U0
                @Override // android.view.View.OnScrollChangeListener
                public final void onScrollChange(View view, int i10, int i11, int i12, int i13) {
                    TaskWebView.k0(this.f28493a, view, i10, i11, i12, i13);
                }
            });
            settings.setJavaScriptEnabled(true);
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
            settings.setDomStorageEnabled(true);
            settings.setDefaultTextEncodingName("UTF-8");
            settings.setMixedContentMode(2);
            settings.setAllowFileAccess(true);
            settings.setAllowFileAccessFromFileURLs(false);
            settings.setAllowUniversalAccessFromFileURLs(false);
            settings.setUseWideViewPort(true);
            settings.setLoadWithOverviewMode(true);
            webView.setWebViewClient(new c());
            webView.setWebChromeClient(new d());
            webView.setDownloadListener(new DownloadListener() { // from class: com.stepos.ailauncher.task.detail.V0
                @Override // android.webkit.DownloadListener
                public final void onDownloadStart(String str, String str2, String str3, String str4, long j10) {
                    TaskWebView.l0(this.f28495a, str, str2, str3, str4, j10);
                }
            });
            webView.addJavascriptInterface(new b(), JS_BRIDGE_NAME);
        } catch (Throwable th) {
            Log.e(this.TAG, "system WebView creation FAILED (likely system-uid limitation)", th);
        }
    }

    public final void m0() {
        this.scrollView.setVisibility(0);
        this.webviewContainer.setVisibility(8);
        InterfaceC5063a<Y8.t> interfaceC5063a = this.onScrollChanged;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
    }

    public final void n0() {
        this.webviewContainer.setVisibility(0);
        this.scrollView.setVisibility(8);
        InterfaceC5063a<Y8.t> interfaceC5063a = this.onScrollChanged;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String o0(java.lang.String r4) {
        /*
            r3 = this;
            kotlin.Result$a r3 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L4d
            if (r4 == 0) goto L46
            android.net.Uri r3 = android.net.Uri.parse(r4)     // Catch: java.lang.Throwable -> L4d
            java.lang.String r4 = r3.getHost()     // Catch: java.lang.Throwable -> L4d
            java.lang.String r0 = "-"
            if (r4 != 0) goto L11
            r4 = r0
        L11:
            java.lang.String r1 = r3.getPath()     // Catch: java.lang.Throwable -> L4d
            if (r1 == 0) goto L21
            r2 = 100
            java.lang.String r1 = La.K.S1(r1, r2)     // Catch: java.lang.Throwable -> L4d
            if (r1 != 0) goto L20
            goto L21
        L20:
            r0 = r1
        L21:
            java.lang.String r3 = r3.getQuery()     // Catch: java.lang.Throwable -> L4d
            if (r3 == 0) goto L2c
            int r3 = r3.length()     // Catch: java.lang.Throwable -> L4d
            goto L2d
        L2c:
            r3 = 0
        L2d:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4d
            r1.<init>()     // Catch: java.lang.Throwable -> L4d
            r1.append(r4)     // Catch: java.lang.Throwable -> L4d
            r1.append(r0)     // Catch: java.lang.Throwable -> L4d
            java.lang.String r4 = " queryLen="
            r1.append(r4)     // Catch: java.lang.Throwable -> L4d
            r1.append(r3)     // Catch: java.lang.Throwable -> L4d
            java.lang.String r3 = r1.toString()     // Catch: java.lang.Throwable -> L4d
            if (r3 != 0) goto L48
        L46:
            java.lang.String r3 = "null"
        L48:
            java.lang.Object r3 = kotlin.Result.b(r3)     // Catch: java.lang.Throwable -> L4d
            goto L58
        L4d:
            r3 = move-exception
            kotlin.Result$a r4 = kotlin.Result.INSTANCE
            java.lang.Object r3 = kotlin.C4849c.a(r3)
            java.lang.Object r3 = kotlin.Result.b(r3)
        L58:
            boolean r4 = kotlin.Result.g(r3)
            if (r4 == 0) goto L60
            java.lang.String r3 = "invalid-url"
        L60:
            java.lang.String r3 = (java.lang.String) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.task.detail.TaskWebView.o0(java.lang.String):java.lang.String");
    }

    public final void p0(String prefix, WebView web) {
        int iIdentityHashCode = System.identityHashCode(this);
        Integer numValueOf = web != null ? Integer.valueOf(System.identityHashCode(web)) : null;
        Integer numValueOf2 = web != null ? Integer.valueOf(web.getWidth()) : null;
        Integer numValueOf3 = web != null ? Integer.valueOf(web.getHeight()) : null;
        Integer numValueOf4 = web != null ? Integer.valueOf(web.getTop()) : null;
        Integer numValueOf5 = web != null ? Integer.valueOf(web.getBottom()) : null;
        Float fValueOf = web != null ? Float.valueOf(web.getScale()) : null;
        Integer numValueOf6 = web != null ? Integer.valueOf(web.getContentHeight()) : null;
        Log.i("PptTrace", prefix + " taskWeb=" + iIdentityHashCode + " systemWeb=" + numValueOf + " size=" + numValueOf2 + "x" + numValueOf3 + " top=" + numValueOf4 + " bottom=" + numValueOf5 + " scale=" + fValueOf + " contentH=" + numValueOf6 + " nav=" + this.traceNavigationId + " loadedViaData=" + this.loadedViaData);
    }

    public final String r0(int px, int viewportPx) {
        if (px <= 0 || viewportPx <= 0) {
            return "0";
        }
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str = String.format(Locale.US, "%.4f", Arrays.copyOf(new Object[]{Double.valueOf((px * 100.0d) / viewportPx)}, 1));
        kotlin.jvm.internal.p.h(str, "format(...)");
        return str;
    }

    public final void setOnContentFirstPaint(InterfaceC5063a<Y8.t> interfaceC5063a) {
        this.onContentFirstPaint = interfaceC5063a;
    }

    public final void setOnContentMetricsProbed(InterfaceC5063a<Y8.t> interfaceC5063a) {
        this.onContentMetricsProbed = interfaceC5063a;
    }

    public final void setOnMainFrameLoadFailed(InterfaceC5074l<? super Integer, Y8.t> interfaceC5074l) {
        this.onMainFrameLoadFailed = interfaceC5074l;
    }

    public final void setOnPlainFlowDetected(InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l) {
        this.onPlainFlowDetected = interfaceC5074l;
    }

    public final void setOnScrollChanged(InterfaceC5063a<Y8.t> interfaceC5063a) {
        this.onScrollChanged = interfaceC5063a;
    }

    public final void setOnShapeSettled(InterfaceC5063a<Y8.t> interfaceC5063a) {
        this.onShapeSettled = interfaceC5063a;
    }

    public final void setOnTreatedAsDownload(InterfaceC5074l<? super String, Y8.t> interfaceC5074l) {
        this.onTreatedAsDownload = interfaceC5074l;
    }

    public final void setOnViewportHeightChanged(InterfaceC5063a<Y8.t> interfaceC5063a) {
        this.onViewportHeightChanged = interfaceC5063a;
    }
}
