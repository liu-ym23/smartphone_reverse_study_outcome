package com.bytedance.android.livesdk.gamecp.impl;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.gamecp.base.core.service.depend.v;
import com.bytedance.android.gamecp.base.core.service.depend.w;
import com.bytedance.android.gamecp.base.core.service.depend.x;
import com.bytedance.android.gamecp.business.downloadview.DownloadUIView;
import com.bytedance.android.livehostapi.business.IHostGameCP;
import com.bytedance.android.livehostapi.business.depend.ISimpleCallback;
import com.bytedance.android.livehostapi.business.depend.gamecp.IAirCompressListener;
import com.bytedance.android.livehostapi.business.depend.gamecp.IDownloadedGameCallback;
import com.bytedance.android.livehostapi.business.depend.gamecp.IFlowTipsDialogListener;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGameAutoDownloadResultCallback;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGameCPDownloadView;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGameCPFmpMonitorService;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGameCPSelectImageCallback;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGameCPTrackService;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGameCPUploadImageCallback;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGameCPWhiteBoxTestService;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGameCancelOrderResultCallback;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGameCpGameService;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGameCpLiveService;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGameDownloadListener;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGameJSBCallerListener;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGameOrderResultCallback;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGamePlayCard;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGamePromoteRankSettingCallback;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGameResDownloadListener;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGameStatusResultCallback;
import com.bytedance.android.livehostapi.business.depend.gamecp.InstalledFinishData;
import com.bytedance.android.livehostapi.business.depend.gamecp.MediaModel;
import com.bytedance.android.livehostapi.business.depend.gamecp.ProgressData;
import com.bytedance.android.livehostapi.business.depend.gamecp.cloudgame.IGameCPCloudGameService;
import com.bytedance.android.livesdkapi.AppLifeCycleMonitor;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.openlive.AsyncInitHelper;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000Ü\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0017\u0018\u00002\u00020\u0001B\t¢\u0006\u0006\b®\u0001\u0010¯\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\fH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0016J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0010H\u0016J(\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001bH\u0016J \u0010!\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001bH\u0016J(\u0010\"\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001bH\u0016J\b\u0010#\u001a\u00020\u0010H\u0016J\u0010\u0010$\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u001fH\u0016J(\u0010'\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0014\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b\u0018\u00010%H\u0016J0\u0010)\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b0%H\u0016J-\u0010-\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010+\u001a\u0004\u0018\u00010*2\b\u0010,\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b-\u0010.J-\u0010/\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010+\u001a\u0004\u0018\u00010*2\b\u0010,\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b/\u0010.J(\u00102\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0014\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0006\u0012\u0004\u0018\u00010100H\u0016J\u001a\u00106\u001a\u00020\u00102\u0006\u00103\u001a\u00020\u001b2\b\u00105\u001a\u0004\u0018\u000104H\u0016J$\u00107\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u00103\u001a\u00020\u001b2\b\u00105\u001a\u0004\u0018\u000104H\u0016J\"\u0010:\u001a\u00020\u00102\u0006\u00103\u001a\u00020\u001b2\u0006\u00109\u001a\u0002082\b\u00105\u001a\u0004\u0018\u000104H\u0016J,\u0010<\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010;\u001a\u0002082\u0006\u00103\u001a\u00020\u001b2\b\u00105\u001a\u0004\u0018\u000104H\u0016J\u0012\u0010=\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J0\u0010@\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0014\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0006\u0012\u0004\u0018\u000101002\u0006\u0010?\u001a\u00020>H\u0016J>\u0010F\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010B\u001a\u0004\u0018\u00010A2\b\u0010D\u001a\u0004\u0018\u00010C2\u0016\u0010E\u001a\u0012\u0012\u0004\u0012\u00020\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010%H\u0016J\b\u0010G\u001a\u000208H\u0016J\"\u0010J\u001a\u0002082\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010(\u001a\u00020H2\u0006\u0010?\u001a\u00020IH\u0016J$\u0010L\u001a\u0002082\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010(\u001a\u00020H2\b\u0010?\u001a\u0004\u0018\u00010KH\u0016J\u001a\u0010M\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010(\u001a\u00020HH\u0016J\"\u0010O\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010(\u001a\u00020H2\u0006\u00105\u001a\u00020NH\u0016J&\u0010M\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010P\u001a\u0004\u0018\u00010\u001b2\b\u0010Q\u001a\u0004\u0018\u00010\u001bH\u0016J4\u0010S\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010P\u001a\u0004\u0018\u00010\u001b2\b\u00109\u001a\u0004\u0018\u00010\u001b2\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00120RH\u0016J\u001a\u0010T\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010(\u001a\u00020HH\u0016J\u001a\u0010U\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010(\u001a\u00020HH\u0016J\u001a\u0010V\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010(\u001a\u00020HH\u0016J6\u0010[\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0W\u0018\u00010Z2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\f\u0010X\u001a\b\u0012\u0004\u0012\u00020\n0W2\u0006\u0010Y\u001a\u000208H\u0016J\u0010\u0010\\\u001a\u0002012\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J,\u0010_\u001a\u00020\u00102\u0006\u0010]\u001a\u0002082\u0006\u0010^\u001a\u00020\u001b2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b0%H\u0016J4\u0010_\u001a\u00020\u00102\u0006\u0010]\u001a\u0002082\u0006\u0010^\u001a\u00020\u001b2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b0%2\u0006\u0010`\u001a\u00020\u0012H\u0016J$\u0010a\u001a\u00020\u00102\u0006\u0010^\u001a\u00020\u001b2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b0%H\u0016J\b\u0010b\u001a\u00020\u0010H\u0016J\u0010\u0010d\u001a\u00020\u00102\u0006\u0010c\u001a\u00020\u0012H\u0016J\u0010\u0010f\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010eH\u0016J\u0012\u0010h\u001a\u00020\u00122\b\u00105\u001a\u0004\u0018\u00010gH\u0016J\n\u0010i\u001a\u0004\u0018\u00010\u001bH\u0016J(\u0010n\u001a\u00020\u00102\u0006\u0010j\u001a\u00020\u001b2\u0006\u0010k\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010m\u001a\u00020lH\u0016J<\u0010q\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010P\u001a\u00020\u001b2\u0006\u0010o\u001a\u00020\u001b2\u0006\u0010Q\u001a\u00020\u001b2\b\u0010(\u001a\u0004\u0018\u00010l2\b\u00105\u001a\u0004\u0018\u00010pH\u0016J4\u0010t\u001a\u00020\u00102\u0006\u0010r\u001a\u00020\u00192\u0006\u0010P\u001a\u00020\u001b2\u0006\u0010Q\u001a\u00020\u001b2\b\u0010(\u001a\u0004\u0018\u00010l2\b\u0010?\u001a\u0004\u0018\u00010sH\u0016J\"\u0010v\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010(\u001a\u00020l2\b\u00105\u001a\u0004\u0018\u00010uH\u0016J(\u0010y\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00192\f\u0010w\u001a\b\u0012\u0004\u0012\u00020l0W2\b\u00105\u001a\u0004\u0018\u00010xH\u0016J$\u0010{\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010(\u001a\u0004\u0018\u00010l2\b\u00105\u001a\u0004\u0018\u00010zH\u0016J\b\u0010}\u001a\u00020|H\u0016J\b\u0010\u007f\u001a\u00020~H\u0016J\f\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0080\u0001H\u0016J\t\u0010\u0082\u0001\u001a\u00020\u0012H\u0016J\"\u0010\u0084\u0001\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010P\u001a\u00020\u001b2\u0007\u00105\u001a\u00030\u0083\u0001H\u0016J\t\u0010\u0085\u0001\u001a\u00020\u0012H\u0016J\n\u0010\u0087\u0001\u001a\u00030\u0086\u0001H\u0016J\n\u0010\u0089\u0001\u001a\u00030\u0088\u0001H\u0016J\f\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008a\u0001H\u0016J\u0013\u0010\u008c\u0001\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\f\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008d\u0001H\u0016J\u0012\u0010\u0090\u0001\u001a\u000b\u0012\u0004\u0012\u000201\u0018\u00010\u008f\u0001H\u0016J\u000b\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u001bH\u0016J'\u0010\u0094\u0001\u001a\u00020\u00102\b\u0010P\u001a\u0004\u0018\u00010\u001b2\t\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u001b2\u0007\u0010?\u001a\u00030\u0093\u0001H\u0016J\u0013\u0010\u0095\u0001\u001a\u00020\u00122\b\u0010P\u001a\u0004\u0018\u00010\u001bH\u0016J\u0013\u0010\u0096\u0001\u001a\u00020\u00122\b\u0010P\u001a\u0004\u0018\u00010\u001bH\u0016J\u0013\u0010\u0097\u0001\u001a\u00020\u00102\b\u0010P\u001a\u0004\u0018\u00010\u001bH\u0016J\t\u0010\u0098\u0001\u001a\u00020\u0010H\u0016J,\u0010\u009a\u0001\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0007\u0010\u0099\u0001\u001a\u0002082\u0006\u0010\u001d\u001a\u00020\u001bH\u0016J\f\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u009b\u0001H\u0016J\u0012\u0010\u009e\u0001\u001a\u00020\u00102\u0007\u0010\u009d\u0001\u001a\u00020\u0012H\u0016J\u0015\u0010¡\u0001\u001a\u0004\u0018\u0001012\b\u0010 \u0001\u001a\u00030\u009f\u0001H\u0016R\u001b\u0010¢\u0001\u001a\u0004\u0018\u00010|8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¢\u0001\u0010£\u0001R\u001c\u0010¤\u0001\u001a\u0005\u0018\u00010\u0086\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¤\u0001\u0010¥\u0001R\u001b\u0010¦\u0001\u001a\u0004\u0018\u00010~8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¦\u0001\u0010§\u0001R\u001c\u0010¨\u0001\u001a\u0005\u0018\u00010\u0088\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¨\u0001\u0010©\u0001R\u001c\u0010ª\u0001\u001a\u0005\u0018\u00010\u008a\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bª\u0001\u0010«\u0001R\u001c\u0010¬\u0001\u001a\u0005\u0018\u00010\u008d\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¬\u0001\u0010\u00ad\u0001¨\u0006°\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/gamecp/impl/LiveHostGameCP;", "Lcom/bytedance/android/livehostapi/business/IHostGameCP;", "Lcom/bytedance/android/gamecp/base/core/service/depend/x;", "progressData", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/ProgressData;", "convertProgressData", "Lcom/bytedance/android/gamecp/base/core/service/depend/v;", "installedFinishData", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/InstalledFinishData;", "convertInstalledFinishData", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/MediaModel;", "liveMediaModel", "Lcom/bytedance/android/gamecp/base/core/service/depend/w;", "convertMediaModel2GameCP", "gameCpMediaMode", "convertMediaModel2Live", "", "init", "", "hasInit", "isAppBackground", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "room", "onAnchorCreatedRoom", "onAnchorExitRoom", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "", "uniqueKey", "source", "onRoomEnter", "", "roomId", "onRoomExit", "onLoadAiPredictor", "stopAiPredictorTimer", "onUnloadAiPredictor", "", "trackParams", "showIntroDialog", "params", "showPromoteListDialog", "Landroid/os/Bundle;", "arguments", "isAnchor", "showGamePromoteDetailDialog", "(Landroid/content/Context;Landroid/os/Bundle;Ljava/lang/Boolean;)V", "showGameOrderDetailDialog", "", "", "showPropsDetailDialog", "from", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGamePromoteRankSettingCallback;", "callback", "getGamePromoteRankSetting", "showGamePromoteRankSetting", "", "status", "setGamePromoteRankSetting", "curItemValue", "showGamePromoteRankSettingDy", "openGameCPPlayerRankInstruction", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGameJSBCallerListener;", "listener", "bindTencentRoleInTest", "Landroid/net/Uri;", "uri", "Landroid/view/View;", "view", "queryItems", "handleHttpSchema", "getDownloadToken", "Lcom/google/gson/JsonObject;", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGameResDownloadListener;", "subscribeDownloadGameRes", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGameDownloadListener;", "subscribeDownloadGame", "downloadGameAction", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IFlowTipsDialogListener;", "downloadGameResAction", "gameId", "enterFrom", "Lcom/bytedance/android/livehostapi/business/depend/ISimpleCallback;", "hasDownloadRecord", "unsubscribeDownloadGame", "unsubscribeDownloadGameRes", "cancelDownloadGame", "", "selected", "selectNumber", "Lio/reactivex/Observable;", "selectImages", "getLynxNestRecyclerView", "scene", "eventName", "logMonitorLinkEvent", "useParamPassing", "dataChannelLinkEvent", "clearLivePromoteIconShowStatus", "show", "livePromoteIconShowChange", "", "getDownloadingGames", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IDownloadedGameCallback;", "getHasDownloadedGame", "getDownloadedGameIconUri", "label", "refer", "Lorg/json/JSONObject;", "adExtraData", "sendAdLog", "gameName", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGameOrderResultCallback;", "orderGame", "ctx", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGameCancelOrderResultCallback;", "cancelOrderGame", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGameCPSelectImageCallback;", "openAlbum", "list", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGameCPUploadImageCallback;", "uploadImage", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGameAutoDownloadResultCallback;", "autoDownloadWhenOnline", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGameCPTrackService;", "getTrackService", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGameCPWhiteBoxTestService;", "getWhiteBoxTestService", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGameCPDownloadView;", "createGameCPDownload", "interceptLiveFloatWindow", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGameStatusResultCallback;", "getGameDownloadStatus", "hasGamePromoteDialogShow", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/cloudgame/IGameCPCloudGameService;", "getCloudGameService", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGameCpLiveService;", "getGameCpLiveService", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGameCpGameService;", "getGameService", "onAnchorRoomContextCreated", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGameCPFmpMonitorService;", "getGameCPFmpMonitorService", "", "getBehaviorList", "getGameCpSdkVersion", "filePath", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IAirCompressListener;", "registerAirCompressListener", "isSupportAirCompress", "isRestoreFailed", "unregisterAirCompressListener", "checkInstallFailPushTips", "uniqueCode", "onWidgetLoaded", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGamePlayCard;", "createGamePlayCard", "degrade", "inDegradeScene", "Lcom/bytedance/live/kmp/core/a;", "liveRoomInstance", "createGameCpInstance", "mTrackService", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGameCPTrackService;", "mCloudGameService", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/cloudgame/IGameCPCloudGameService;", "mWhiteBoxTestService", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGameCPWhiteBoxTestService;", "mGameCpLiveService", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGameCpLiveService;", "mGameCpGameService", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGameCpGameService;", "mGameCPFmpMonitorService", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGameCPFmpMonitorService;", "<init>", "()V", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public class LiveHostGameCP implements IHostGameCP {
    private IGameCPCloudGameService mCloudGameService;
    private IGameCPFmpMonitorService mGameCPFmpMonitorService;
    private IGameCpGameService mGameCpGameService;
    private IGameCpLiveService mGameCpLiveService;
    private IGameCPTrackService mTrackService;
    private IGameCPWhiteBoxTestService mWhiteBoxTestService;

    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public void bindTencentRoleInTest(Context r100, Map<String, Object> r101, IGameJSBCallerListener r102) {
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "listener");
    }

    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public Object createGameCpInstance(com.bytedance.live.kmp.core.a r100) {
        Intrinsics.checkNotNullParameter(r100, "liveRoomInstance");
        return null;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public IGamePlayCard createGamePlayCard() {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public boolean handleHttpSchema(Context r100, Uri r101, View r102, Map<String, String> r103) {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public IGameCPCloudGameService getCloudGameService() {
        if (this.mCloudGameService != null) goto L5;
        this.mCloudGameService = new a();
    L5:
        IGameCPCloudGameService r100 = this.mCloudGameService;
        Intrinsics.checkNotNull(r100);
        return r100;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public IGameCPFmpMonitorService getGameCPFmpMonitorService() {
        if (this.mGameCPFmpMonitorService != null) goto L5;
        this.mGameCPFmpMonitorService = new c();
    L5:
        IGameCPFmpMonitorService r100 = this.mGameCPFmpMonitorService;
        Intrinsics.checkNotNull(r100);
        return r100;
    }

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostGameCP
    public IGameCpLiveService getGameCpLiveService() {
        if (this.mGameCpLiveService != null) goto L5;
        this.mGameCpLiveService = new g();
    L5:
        IGameCpLiveService r100 = this.mGameCpLiveService;
        Intrinsics.checkNotNull(r100);
        return r100;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public IGameCpGameService getGameService() {
        if (this.mGameCpGameService != null) goto L5;
        this.mGameCpGameService = new f();
    L5:
        IGameCpGameService r100 = this.mGameCpGameService;
        Intrinsics.checkNotNull(r100);
        return r100;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public IGameCPTrackService getTrackService() {
        if (this.mTrackService != null) goto L5;
        this.mTrackService = new d();
    L5:
        IGameCPTrackService r100 = this.mTrackService;
        Intrinsics.checkNotNull(r100);
        return r100;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public IGameCPWhiteBoxTestService getWhiteBoxTestService() {
        if (this.mWhiteBoxTestService != null) goto L5;
        this.mWhiteBoxTestService = new e();
    L5:
        IGameCPWhiteBoxTestService r100 = this.mWhiteBoxTestService;
        Intrinsics.checkNotNull(r100);
        return r100;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public boolean hasInit() {
        boolean r100 = com.bytedance.android.livesdk.gamecp.b.f125417a;
        return com.bytedance.android.livesdk.gamecp.b.f125417a;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public boolean isAppBackground() {
        return AppLifeCycleMonitor.INSTANCE.isAppBackground();
    }

    public LiveHostGameCP() {
        jc1.k.l(IHostGameCP.class, this);
        AsyncInitHelper.postNormalTask("GameCPInit", AnonymousClass1.INSTANCE);
    }

    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public void checkInstallFailPushTips() {
        xr.f r100 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r100 == null) goto L6;
        r100.checkInstallFailPushTips();
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public void clearLivePromoteIconShowStatus() {
        xr.f r100 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r100 == null) goto L6;
        r100.clearLivePromoteIconShowStatus();
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public IGameCPDownloadView createGameCPDownload() {
        xr.f r100 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r100 == null) goto L9;
        DownloadUIView r101 = r100.createGameCPDownload();
        if (r101 != null) goto L8;
        return null;
    L8:
        return new b(r101);
    L9:
        return null;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public List<Object> getBehaviorList() {
        xr.f r100 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getBehaviorList();
    }

    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public int getDownloadToken() {
        xr.f r100 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.genDownloadToken();
    }

    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public String getDownloadedGameIconUri() {
        xr.f r100 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getDownloadedGameIconUri();
    }

    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public Set<String> getDownloadingGames() {
        xr.f r100 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getDownloadingGames();
    }

    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public String getGameCpSdkVersion() {
        xr.f r100 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getGameCpSdkVersion();
    }

    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public boolean hasGamePromoteDialogShow() {
        xr.f r100 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.p0();
    }

    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public void init() {
        com.bytedance.android.livesdk.gamecp.b.a();
        boolean r100 = com.bytedance.android.livesdk.gamecp.b.f125417a;
        xr.f r101 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r101 == null) goto L6;
        r101.initJsBridge();
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public boolean interceptLiveFloatWindow() {
        xr.f r100 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.interceptLiveFloatWindow();
    }

    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public void onAnchorExitRoom() {
        xr.f r100 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r100 == null) goto L6;
        r100.onAnchorExitRoom();
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public void stopAiPredictorTimer() {
        xr.f r100 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r100 == null) goto L6;
        r100.stopAiPredictorTimer();
        return;
    }

    private final InstalledFinishData convertInstalledFinishData(v r100) {
        return new InstalledFinishData(r100.f51409a, r100.f51410b);
    }

    private final w convertMediaModel2GameCP(MediaModel r100) {
        w r101 = new w(r100.getId());
        r101.f51416f = r100.getCompressPath();
        r101.f51420j = r100.getDate();
        r101.f51432v = r100.getDateToken();
        r101.f51422l = r100.getDuration();
        r101.f51434x = r100.getEndTime();
        r101.f51436z = r100.getExtraInfo();
        r101.f51415e = r100.getFileLocalUriPath();
        r101.f51419i = r100.getFileName();
        r101.f51423m = r100.getFileSize();
        r101.f51427q = r100.getHeight();
        r101.f51428r = r100.getLatitude();
        r101.f51429s = r100.getLongitude();
        r101.f51424n = r100.getMimeType();
        r101.f51430t = r100.getModify();
        r101.f51431u = r100.getOrientation();
        r101.f51418h = r100.getRelativePath();
        r101.f51413c = r100.getSelectIndex();
        r101.f51414d = r100.getSelectPosition();
        r101.f51412b = r100.getSelectState();
        r101.f51435y = r100.getSpeed();
        r101.f51433w = r100.getStartTime();
        r101.f51425o = r100.getThumbnail();
        r101.f51421k = r100.getType();
        r101.f51417g = r100.getUri();
        r101.f51426p = r100.getWidth();
        return r101;
    }

    private final MediaModel convertMediaModel2Live(w r100) {
        MediaModel r101 = new MediaModel(r100.A);
        r101.setCompressPath(r100.f51416f);
        r101.setDate(r100.f51420j);
        r101.setDateToken(r100.f51432v);
        r101.setDuration(r100.f51422l);
        r101.setEndTime(r100.f51434x);
        r101.setExtraInfo(r100.f51436z);
        r101.setFileLocalUriPath(r100.f51415e);
        r101.setFileName(r100.f51419i);
        r101.setFileSize(r100.f51423m);
        r101.setHeight(r100.f51427q);
        r101.setLatitude(r100.f51428r);
        r101.setLongitude(r100.f51429s);
        r101.setMimeType(r100.f51424n);
        r101.setModify(r100.f51430t);
        r101.setOrientation(r100.f51431u);
        r101.setRelativePath(r100.f51418h);
        r101.setSelectIndex(r100.f51413c);
        r101.setSelectPosition(r100.f51414d);
        r101.setSelectState(r100.f51412b);
        r101.setSpeed(r100.f51435y);
        r101.setStartTime(r100.f51433w);
        r101.setThumbnail(r100.f51425o);
        r101.setType(r100.getType());
        r101.setUri(r100.f51417g);
        r101.setWidth(r100.f51426p);
        return r101;
    }

    private final ProgressData convertProgressData(x r110) {
        int r100 = r110.f51437a;
        int r101 = r110.f51439c;
        return new ProgressData(r100, r110.f51438b, r101, r110.f51440d, r110.f51441e, r110.f51442f, r110.f51443g, r110.f51444h, r110.f51445i, r110.f51447k);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.bytedance.android.livesdk.gamecp.impl.LiveHostGameCP$getHasDownloadedGame$1] */
    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public boolean getHasDownloadedGame(final IDownloadedGameCallback r100) {
        xr.f r101 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r101 != 0) goto L7;
        return false;
    L7:
        return r101.L(new C100301(r100));
    }

    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public Object getLynxNestRecyclerView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        xr.f r101 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r101 == null) goto L7;
        RecyclerView r102 = r101.getLynxNestRecyclerView(r100);
        if (r102 == null) goto L7;
        return r102;
    L7:
        return new RecyclerView(r100);
    }

    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public void inDegradeScene(boolean r100) {
        xr.f r101 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r101 == null) goto L6;
        r101.inDegradeScene(r100);
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public boolean isRestoreFailed(String r100) {
        xr.f r101 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.isRestoreFailed(r100);
    }

    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public boolean isSupportAirCompress(String r100) {
        xr.f r101 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.isSupportAirCompress(r100);
    }

    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public void livePromoteIconShowChange(boolean r100) {
        xr.f r101 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r101 == null) goto L6;
        r101.livePromoteIconShowChange(r100);
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public void onAnchorCreatedRoom(Room r100) {
        Intrinsics.checkNotNullParameter(r100, "room");
        xr.f r101 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r101 == null) goto L6;
        r101.n0(r100.getRoomId());
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public void onAnchorRoomContextCreated(Room r100) {
        xr.f r101 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r101 == null) goto L12;
        if (r100 == null) goto L6;
        long r102 = r100.getRoomId();
    L7:
        if (r100 == null) goto L9;
        String r103 = r100.getAnchorId();
    L10:
        r101.G(r102, r103);
        return;
    L9:
        r103 = null;
        goto L10
    L6:
        r102 = 0;
        goto L7
    }

    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public void onUnloadAiPredictor(long r100) {
        xr.f r101 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r101 == null) goto L6;
        r101.onUnloadAiPredictor(r100);
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public void openGameCPPlayerRankInstruction(Context r100) {
        xr.f r101 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r101 == null) goto L6;
        r101.openGameCPPlayerRankInstruction(r100);
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public void unregisterAirCompressListener(String r100) {
        xr.f r101 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r101 == null) goto L6;
        r101.unregisterAirCompressListener(r100);
        return;
    }

    public static final /* synthetic */ InstalledFinishData access$convertInstalledFinishData(LiveHostGameCP r100, v r101) {
        return r100.convertInstalledFinishData(r101);
    }

    public static final /* synthetic */ MediaModel access$convertMediaModel2Live(LiveHostGameCP r100, w r101) {
        return r100.convertMediaModel2Live(r101);
    }

    public static final /* synthetic */ ProgressData access$convertProgressData(LiveHostGameCP r100, x r101) {
        return r100.convertProgressData(r101);
    }

    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public void cancelDownloadGame(Context r100, JsonObject r101) {
        Intrinsics.checkNotNullParameter(r101, "params");
        xr.f r102 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r102 == null) goto L6;
        r102.cancelDownloadGame(r100, r101);
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public void dataChannelLinkEvent(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        xr.f r102 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r102 == null) goto L6;
        r102.dataChannelLinkEvent(r100, r101);
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public void downloadGameAction(Context r100, JsonObject r101) {
        Intrinsics.checkNotNullParameter(r101, "params");
        xr.f r102 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r102 == null) goto L8;
        xr.b r103 = r102.p1();
        if (r103 == null) goto L9;
        r103.X0(r100, r101, null);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public void getGamePromoteRankSetting(String r100, final IGamePromoteRankSettingCallback r101) {
        Intrinsics.checkNotNullParameter(r100, "from");
        xr.f r102 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r102 == null) goto L6;
        r102.Z(r100, new C100291(r101));
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public void showIntroDialog(Context r100, Map<String, String> r101) {
        xr.f r102 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r102 == null) goto L6;
        r102.showIntroDialog(r100, r101);
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public void showPropsDetailDialog(Context r100, Map<String, Object> r101) {
        Intrinsics.checkNotNullParameter(r101, "params");
        xr.f r102 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r102 == null) goto L6;
        r102.showPropsDetailDialog(r100, r101);
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public void unsubscribeDownloadGame(Context r100, JsonObject r101) {
        Intrinsics.checkNotNullParameter(r101, "params");
        xr.f r102 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r102 == null) goto L6;
        r102.N0(r101);
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public void unsubscribeDownloadGameRes(Context r100, JsonObject r101) {
        Intrinsics.checkNotNullParameter(r101, "params");
        xr.f r102 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r102 == null) goto L6;
        r102.v2(r101);
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public void autoDownloadWhenOnline(Context r100, JSONObject r101, final IGameAutoDownloadResultCallback r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        xr.f r103 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r103 == null) goto L6;
        r103.W1(r100, r101, new C100251(r102));
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public void downloadGameAction(Context r100, String r101, String r102) {
        xr.f r103 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r103 == null) goto L8;
        xr.b r104 = r103.p1();
        if (r104 == null) goto L9;
        r104.j1(r100, r101, r102, 1);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public void downloadGameResAction(Context r100, JsonObject r101, final IFlowTipsDialogListener r102) {
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        xr.f r103 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r103 == null) goto L6;
        r103.q0(r100, r101, new C100271(r102));
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public void getGameDownloadStatus(Context r100, String r101, final IGameStatusResultCallback r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "gameId");
        Intrinsics.checkNotNullParameter(r102, "callback");
        xr.f r103 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r103 == null) goto L6;
        r103.g2(r100, r101, new C100281(r102));
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public void logMonitorLinkEvent(int r100, String r101, Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r101, "eventName");
        Intrinsics.checkNotNullParameter(r102, "params");
        xr.f r103 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r103 == null) goto L6;
        r103.logMonitorLinkEvent(r100, r101, r102, true);
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public void onRoomExit(long r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "uniqueKey");
        Intrinsics.checkNotNullParameter(r102, "source");
        xr.f r103 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r103 == null) goto L6;
        r103.onRoomExit(r100, r101, r102);
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public void openAlbum(Context r100, JSONObject r101, final IGameCPSelectImageCallback r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "params");
        xr.f r103 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r103 == null) goto L6;
        r103.R1(r100, r101, new C100321(r102));
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public void registerAirCompressListener(String r100, String r101, final IAirCompressListener r102) {
        Intrinsics.checkNotNullParameter(r102, "listener");
        xr.f r103 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r103 == null) goto L6;
        r103.y2(r100, r101, new C100341(r102));
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public Observable<List<MediaModel>> selectImages(Context r100, List<? extends MediaModel> r101, int r102) {
        Intrinsics.checkNotNullParameter(r101, "selected");
        ArrayList r103 = new ArrayList();
        Iterator<? extends MediaModel> r104 = r101.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        r103.add(convertMediaModel2GameCP(r104.next()));
        goto L4
    L6:
        xr.f r105 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r105 == null) goto L11;
        Observable<List<w>> r106 = r105.selectImages(r100, r103, r102);
        if (r106 == null) goto L11;
        return r106.map(new C100351(this));
    L11:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.bytedance.android.livesdk.gamecp.impl.LiveHostGameCP$setGamePromoteRankSetting$1] */
    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public void setGamePromoteRankSetting(String r100, int r101, final IGamePromoteRankSettingCallback r102) {
        Intrinsics.checkNotNullParameter(r100, "from");
        xr.f r103 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r103 == 0) goto L6;
        r103.t2(r100, r101, new C100361(r102));
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public void showGameOrderDetailDialog(Context r100, Bundle r101, Boolean r102) {
        xr.f r103 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r103 == null) goto L6;
        r103.showGameOrderDetailDialog(r100, r101, r102);
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public void showGamePromoteDetailDialog(Context r100, Bundle r101, Boolean r102) {
        xr.f r103 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r103 == null) goto L6;
        r103.showGamePromoteDetailDialog(r100, r101, r102);
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public void showGamePromoteRankSetting(Context r100, String r101, final IGamePromoteRankSettingCallback r102) {
        Intrinsics.checkNotNullParameter(r101, "from");
        xr.f r103 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r103 == null) goto L6;
        r103.d1(r100, r101, new C100371(r102));
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public void showPromoteListDialog(Context r100, Room r101, Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r102, "params");
        xr.f r103 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r103 == null) goto L6;
        r103.E1(r100, com.bytedance.android.livesdk.gamecp.utils.b.b(r101), r102);
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public int subscribeDownloadGame(Context r100, JsonObject r101, final IGameDownloadListener r102) {
        Intrinsics.checkNotNullParameter(r101, "params");
        xr.f r103 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r103 != null) goto L7;
        return 0;
    L7:
        return r103.C1(r101, new C100391(this, r102));
    }

    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public int subscribeDownloadGameRes(Context r100, JsonObject r101, final IGameResDownloadListener r102) {
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "listener");
        xr.f r103 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r103 != null) goto L7;
        return 0;
    L7:
        return r103.T(r101, new C100401(this, r102));
    }

    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public void uploadImage(Context r100, List<? extends JSONObject> r101, final IGameCPUploadImageCallback r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "list");
        xr.f r103 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r103 == null) goto L6;
        r103.u0(r100, r101, new C100411(r102));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.bytedance.android.livesdk.gamecp.impl.LiveHostGameCP$hasDownloadRecord$1] */
    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public void hasDownloadRecord(Context r100, String r101, String r102, final ISimpleCallback<Boolean> r103) {
        Intrinsics.checkNotNullParameter(r103, "callback");
        xr.f r104 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r104 == null) goto L8;
        xr.b r105 = r104.p1();
        if (r105 == 0) goto L9;
        r105.F0(r100, r101, r102, new C100311(r103));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public void logMonitorLinkEvent(int r100, String r101, Map<String, String> r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r101, "eventName");
        Intrinsics.checkNotNullParameter(r102, "params");
        xr.f r104 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r104 == null) goto L6;
        r104.logMonitorLinkEvent(r100, r101, r102, r103);
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public void onLoadAiPredictor(Context r100, long r101, String r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "uniqueKey");
        Intrinsics.checkNotNullParameter(r111, "source");
        xr.f r102 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r102 == null) goto L6;
        r102.onLoadAiPredictor(r100, r101, r110, r111);
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public void onRoomEnter(Context r100, Room r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "room");
        Intrinsics.checkNotNullParameter(r111, "uniqueKey");
        Intrinsics.checkNotNullParameter(r112, "source");
        xr.f r101 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r101 == null) goto L6;
        r101.onRoomEnter(r100, r110.getRoomId(), r110.getAnchorId(), r111, r112);
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public void onWidgetLoaded(Context r110, Room r111, int r112, String r113) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r113, "source");
        if (r111 == null) goto L5;
        long r100 = r111.getRoomId();
    L6:
        long r101 = r100;
        StringBuilder r102 = new StringBuilder();
        r102.append(r101);
        r102.append('_');
        r102.append(r112);
        String r103 = r102.toString();
        xr.f r104 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r104 == null) goto L15;
        if (r111 != null) goto L10;
    L12:
        boolean r105 = false;
    L13:
        r104.l2(r110, r101, r103, r113, r105);
        return;
    L10:
        if (r111.isGameRoom() != 1) goto L12;
        r105 = true;
        goto L13
    L15:
        return;
    L5:
        r100 = 0;
        goto L6
    }

    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public void sendAdLog(String r100, String r101, long r110, JSONObject r111) {
        Intrinsics.checkNotNullParameter(r100, "label");
        Intrinsics.checkNotNullParameter(r101, "refer");
        Intrinsics.checkNotNullParameter(r111, "adExtraData");
        xr.f r102 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r102 == null) goto L6;
        r102.sendAdLog(r100, r101, r110, r111);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.bytedance.android.livesdk.gamecp.impl.LiveHostGameCP$showGamePromoteRankSettingDy$1] */
    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public void showGamePromoteRankSettingDy(Context r100, int r101, String r102, final IGamePromoteRankSettingCallback r103) {
        Intrinsics.checkNotNullParameter(r102, "from");
        xr.f r104 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r104 == 0) goto L6;
        r104.n(r100, r101, r102, new C100381(r103));
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public void cancelOrderGame(Context r100, String r101, String r110, JSONObject r111, final IGameCancelOrderResultCallback r112) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        Intrinsics.checkNotNullParameter(r101, "gameId");
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        xr.f r102 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r102 == null) goto L6;
        r102.r0(r100, r101, r110, r111, new C100261(r112));
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostGameCP
    public void orderGame(Context r100, String r110, String r111, String r112, JSONObject r113, final IGameOrderResultCallback r114) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "gameId");
        Intrinsics.checkNotNullParameter(r111, "gameName");
        Intrinsics.checkNotNullParameter(r112, "enterFrom");
        xr.f r101 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r101 == null) goto L6;
        r101.O1(r100, r110, r111, r112, r113, new C100331(r114));
        return;
    }
}
