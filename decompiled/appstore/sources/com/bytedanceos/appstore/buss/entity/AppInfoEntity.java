package com.bytedanceos.appstore.buss.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.bytedanceos.appstore.buss.entity.item.AppInfoItem;
import com.bytedanceos.appstore.buss.entity.item.CommonAppItem;
import com.bytedanceos.appstore.buss.utilities.j;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import com.bytedanceos.common.toolbox.c0;
import com.bytedanceos.common.ui.AppPermissionActivity;
import com.google.common.primitives.Ints;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.obric.capabilitykit.common.UiType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import kotlin.text.m;
import kotlin.text.n;
import kotlin.text.o;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Parcelize
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\bi\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bæ\u0004\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010)\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010\"\u0012\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\"\u0012\b\u0010-\u001a\u0004\u0018\u00010.\u0012\u0006\u0010/\u001a\u00020\u0003\u0012\b\u00100\u001a\u0004\u0018\u00010\u0003\u0012\b\u00101\u001a\u0004\u0018\u00010\u0003\u0012\b\u00102\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u00103\u001a\n\u0012\u0004\u0012\u000205\u0018\u000104\u0012\u000e\u00106\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\"\u0012\b\u00107\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u00108\u001a\u00020\u0003\u0012\u0006\u00109\u001a\u00020#\u0012\u0006\u0010:\u001a\u00020#\u0012\b\u0010;\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010<\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010=\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010>\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010?\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010@\u001a\u00020#\u0012\r\u0010A\u001a\t\u0018\u00010B¢\u0006\u0002\bC\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010E\u001a\n\u0012\u0004\u0012\u00020F\u0018\u00010\"\u0012\b\u0010G\u001a\u0004\u0018\u00010#¢\u0006\u0002\u0010HJ\f\u0010¢\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010£\u0001\u001a\u00020\u0003HÆ\u0003J\f\u0010¤\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010¥\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010¦\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010§\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010¨\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010©\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010ª\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010«\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010¬\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010®\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010¯\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010°\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010±\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010²\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010³\u0001\u001a\u00020\u0003HÆ\u0003J\f\u0010´\u0001\u001a\u0004\u0018\u00010\u001dHÆ\u0003J\f\u0010µ\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010¶\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010·\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010¸\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0012\u0010¹\u0001\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"HÆ\u0003J\f\u0010º\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010»\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010¼\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010½\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010¾\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010¿\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0012\u0010À\u0001\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010\"HÆ\u0003J\u0012\u0010Á\u0001\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\"HÆ\u0003J\f\u0010Â\u0001\u001a\u0004\u0018\u00010.HÆ\u0003J\n\u0010Ã\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Ä\u0001\u001a\u00020\u0003HÆ\u0003J\f\u0010Å\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Æ\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Ç\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0012\u0010È\u0001\u001a\n\u0012\u0004\u0012\u000205\u0018\u000104HÆ\u0003J\u0012\u0010É\u0001\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\"HÆ\u0003J\f\u0010Ê\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010Ë\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Ì\u0001\u001a\u00020#HÆ\u0003J\n\u0010Í\u0001\u001a\u00020#HÆ\u0003J\n\u0010Î\u0001\u001a\u00020\u0003HÆ\u0003J\f\u0010Ï\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Ð\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Ñ\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Ò\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Ó\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010Ô\u0001\u001a\u00020#HÆ\u0003J\u0011\u0010Õ\u0001\u001a\t\u0018\u00010B¢\u0006\u0002\bCHÆ\u0003J\f\u0010Ö\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0012\u0010×\u0001\u001a\n\u0012\u0004\u0012\u00020F\u0018\u00010\"HÆ\u0003J\u0012\u0010Ø\u0001\u001a\u0004\u0018\u00010#HÆ\u0003¢\u0006\u0003\u0010\u0089\u0001J\n\u0010Ù\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Ú\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Û\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Ü\u0001\u001a\u00020\u0003HÆ\u0003J\b\u0010Ý\u0001\u001a\u00030Þ\u0001J\b\u0010ß\u0001\u001a\u00030à\u0001Jã\u0005\u0010á\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010*\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010\"2\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\"2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.2\b\b\u0002\u0010/\u001a\u00020\u00032\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u00103\u001a\n\u0012\u0004\u0012\u000205\u0018\u0001042\u0010\b\u0002\u00106\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\"2\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u00108\u001a\u00020\u00032\b\b\u0002\u00109\u001a\u00020#2\b\b\u0002\u0010:\u001a\u00020#2\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010@\u001a\u00020#2\u000f\b\u0002\u0010A\u001a\t\u0018\u00010B¢\u0006\u0002\bC2\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010E\u001a\n\u0012\u0004\u0012\u00020F\u0018\u00010\"2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010#HÆ\u0001¢\u0006\u0003\u0010â\u0001J\n\u0010ã\u0001\u001a\u00020#HÖ\u0001J\u0016\u0010ä\u0001\u001a\u00030å\u00012\t\u0010æ\u0001\u001a\u0004\u0018\u00010BHÖ\u0003J\n\u0010ç\u0001\u001a\u0005\u0018\u00010è\u0001J\n\u0010é\u0001\u001a\u00020#HÖ\u0001J\b\u0010ê\u0001\u001a\u00030å\u0001J\b\u0010ë\u0001\u001a\u00030å\u0001J\n\u0010ì\u0001\u001a\u00020\u0003HÖ\u0001J\u001e\u0010í\u0001\u001a\u00030î\u00012\b\u0010ï\u0001\u001a\u00030ð\u00012\u0007\u0010ñ\u0001\u001a\u00020#HÖ\u0001R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bK\u0010JR\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bL\u0010JR\u0013\u0010&\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bM\u0010JR\u0019\u0010*\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010\"¢\u0006\b\n\u0000\u001a\u0004\bN\u0010OR\u001c\u0010(\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010J\"\u0004\bQ\u0010RR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bS\u0010JR!\u0010A\u001a\t\u0018\u00010B¢\u0006\u0002\bCX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\u001c\u00107\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010J\"\u0004\bY\u0010RR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010JR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b[\u0010JR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010JR\u0011\u0010/\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b]\u0010JR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b^\u0010JR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b_\u0010JR\u0013\u0010=\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b`\u0010JR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\ba\u0010JR\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bb\u0010JR\u0013\u0010-\u001a\u0004\u0018\u00010.¢\u0006\b\n\u0000\u001a\u0004\bc\u0010dR\u0013\u0010$\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\be\u0010JR\u0013\u0010'\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bf\u0010JR\"\u0010E\u001a\n\u0012\u0004\u0012\u00020F\u0018\u00010\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010O\"\u0004\bh\u0010iR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bj\u0010JR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bk\u0010JR\u001a\u00109\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR\u0011\u0010:\u001a\u00020#¢\u0006\b\n\u0000\u001a\u0004\bp\u0010mR\u0011\u0010@\u001a\u00020#¢\u0006\b\n\u0000\u001a\u0004\bq\u0010mR\u0011\u00108\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\br\u0010JR\u001c\u0010s\u001a\u0004\u0018\u00010tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010v\"\u0004\bw\u0010xR\u0019\u0010!\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"¢\u0006\b\n\u0000\u001a\u0004\by\u0010OR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bz\u0010JR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b{\u0010JR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b|\u0010JR\u0013\u0010<\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b}\u0010JR\u0013\u0010%\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b~\u0010JR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u007f\u0010JR\u001a\u00106\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\"¢\u0006\t\n\u0000\u001a\u0005\b\u0080\u0001\u0010OR\u0017\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0081\u0001\u0010JR\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0082\u0001\u0010JR\u001a\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\"¢\u0006\t\n\u0000\u001a\u0005\b\u0083\u0001\u0010OR\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0084\u0001\u0010JR\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0085\u0001\u0010JR\u0014\u0010?\u001a\u0004\u0018\u00010\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0086\u0001\u0010JR\u0012\u0010\u001b\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0087\u0001\u0010JR#\u0010G\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u0015\n\u0003\u0010\u008c\u0001\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001\"\u0006\b\u008a\u0001\u0010\u008b\u0001R\u0014\u00101\u001a\u0004\u0018\u00010\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u008d\u0001\u0010JR\u001e\u00102\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008e\u0001\u0010J\"\u0005\b\u008f\u0001\u0010RR$\u00103\u001a\n\u0012\u0004\u0012\u000205\u0018\u000104X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0090\u0001\u0010O\"\u0005\b\u0091\u0001\u0010iR\u0014\u00100\u001a\u0004\u0018\u00010\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0092\u0001\u0010JR\u0014\u0010>\u001a\u0004\u0018\u00010\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0093\u0001\u0010JR\u0014\u0010;\u001a\u0004\u0018\u00010\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0094\u0001\u0010JR\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0095\u0001\u0010JR\u0014\u0010D\u001a\u0004\u0018\u00010\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0096\u0001\u0010JR\u0014\u0010 \u001a\u0004\u0018\u00010\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0097\u0001\u0010JR\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0098\u0001\u0010JR\u001e\u0010)\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0099\u0001\u0010J\"\u0005\b\u009a\u0001\u0010RR\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u009b\u0001\u0010JR\u001c\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009c\u0001\u0010J\"\u0005\b\u009d\u0001\u0010RR\u001c\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009e\u0001\u0010J\"\u0005\b\u009f\u0001\u0010RR\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\n\n\u0000\u001a\u0006\b \u0001\u0010¡\u0001¨\u0006ò\u0001"}, d2 = {"Lcom/bytedanceos/appstore/buss/entity/AppInfoEntity;", "Landroid/os/Parcelable;", "id", "", "pkg_id", ServerElements.DEVER_ID, "name", ServerElements.CNAME, "version", "version_code", AppPermissionActivity.EXTRA_APP_PKG, ServerElements.FILESIZE, ServerElements.LOGO, ServerElements.BANNER, "draw_logo", "apk_file", "status", "create_time", ServerElements.UPDATE_TIME, ServerElements.LAST_UPDATE_TIME, ServerElements.DEVELOPER, "pay_type", "soft_type", "grade_desc", "py_name", "py_cname", ServerElements.BRIEF, ServerElements.RECMD_BRIEF, ServerElements.VIDEO, "Lcom/bytedanceos/appstore/buss/entity/TvAppInfoVideoEntity;", "draw", "first_pub", "spread", ServerElements.LABEL, "", "", "game_type", "operation_status", "category", "gift_num", "cid", "subCid", ServerElements.CATEGORY_INFO, "Lcom/bytedanceos/appstore/buss/entity/TvAppInfoCategoryInfoEntity;", ServerElements.PRINTSCREEN, "from", "Lcom/bytedanceos/appstore/buss/entity/TvAppInfoFromEntity;", ServerElements.DOWNLOAD_URL, "share_download_url", ServerElements.SCALABLE, ServerElements.SCORES, ServerElements.SCORES_DETAIL, "", "Lcom/bytedanceos/appstore/buss/entity/TvAppInfoScoresDetailEntity;", "permission", ServerElements.COMMENTS, ServerElements.IFGMS, ServerElements.IFCOLLECT, "ifdownload", "size", ServerElements.NEW_FEATURES, ServerElements.FILE_MD5, "signature", "raw_signature", "ifgift", ServerElements.COMMENT, "", "Lkotlinx/parcelize/RawValue;", "source", ServerElements.GAME_GIFT_PACK, "Lcom/bytedanceos/appstore/buss/entity/AppDetailGiftEntity;", "resId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedanceos/appstore/buss/entity/TvAppInfoVideoEntity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/bytedanceos/appstore/buss/entity/TvAppInfoFromEntity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Object;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;)V", "getApk_file", "()Ljava/lang/String;", "getBanner", "getBrief", "getCategory", "getCategory_info", "()Ljava/util/List;", "getCid", "setCid", "(Ljava/lang/String;)V", "getCname", "getComment", "()Ljava/lang/Object;", "setComment", "(Ljava/lang/Object;)V", "getComments", "setComments", "getCreate_time", "getDeveloper", "getDever_id", "getDownload_url", "getDraw", "getDraw_logo", "getFilemd5", "getFilesize", "getFirst_pub", "getFrom", "()Lcom/bytedanceos/appstore/buss/entity/TvAppInfoFromEntity;", "getGame_type", "getGift_num", "getGifts", "setGifts", "(Ljava/util/List;)V", "getGrade_desc", "getId", "getIfcollect", "()I", "setIfcollect", "(I)V", "getIfdownload", "getIfgift", "getIfgms", "item", "Lcom/bytedanceos/appstore/buss/entity/item/AppInfoItem;", "getItem", "()Lcom/bytedanceos/appstore/buss/entity/item/AppInfoItem;", "setItem", "(Lcom/bytedanceos/appstore/buss/entity/item/AppInfoItem;)V", "getLabel", "getLast_update_time", "getLogo", "getName", "getNew_features", "getOperation_status", "getPay_type", "getPermission", "getPkg", "getPkg_id", "getPrintscreen", "getPy_cname", "getPy_name", "getRaw_signature", "getRecmd_brief", "getResId", "()Ljava/lang/Integer;", "setResId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getScalable", "getScores", "setScores", "getScores_detail", "setScores_detail", "getShare_download_url", "getSignature", "getSize", "getSoft_type", "getSource", "getSpread", "getStatus", "getSubCid", "setSubCid", "getUpdate_time", "getVersion", "setVersion", "getVersion_code", "setVersion_code", "getVideo", "()Lcom/bytedanceos/appstore/buss/entity/TvAppInfoVideoEntity;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component4", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component5", "component50", "component51", "component52", "component53", "component54", "component55", "component56", "component57", "component58", "component59", "component6", "component7", "component8", "component9", "convertAppInfo", "Lcom/bytedanceos/common/model/AppInfo;", "convertCommonAppEntity", "Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedanceos/appstore/buss/entity/TvAppInfoVideoEntity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/bytedanceos/appstore/buss/entity/TvAppInfoFromEntity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Object;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;)Lcom/bytedanceos/appstore/buss/entity/AppInfoEntity;", "describeContents", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "getTvGradeWrap", "Lcom/bytedanceos/appstore/buss/entity/TvGradeWrap;", "hashCode", "isFromSmt", "isSystemApp", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAppInfoEntity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppInfoEntity.kt\ncom/bytedanceos/appstore/buss/entity/AppInfoEntity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,246:1\n1#2:247\n*E\n"})
public final class AppInfoEntity implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<AppInfoEntity> CREATOR = null;

    @Nullable
    private final String apk_file;

    @Nullable
    private final String banner;

    @Nullable
    private final String brief;

    @Nullable
    private final String category;

    @Nullable
    private final List<TvAppInfoCategoryInfoEntity> category_info;

    @Nullable
    private String cid;

    @NotNull
    private final String cname;

    @Nullable
    private Object comment;

    @Nullable
    private String comments;

    @Nullable
    private final String create_time;

    @Nullable
    private final String developer;

    @Nullable
    private final String dever_id;

    @NotNull
    private final String download_url;

    @Nullable
    private final String draw;

    @Nullable
    private final String draw_logo;

    @Nullable
    private final String filemd5;

    @NotNull
    private final String filesize;

    @Nullable
    private final String first_pub;

    @Nullable
    private final TvAppInfoFromEntity from;

    @Nullable
    private final String game_type;

    @Nullable
    private final String gift_num;

    @Nullable
    private List<AppDetailGiftEntity> gifts;

    @Nullable
    private final String grade_desc;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @Nullable
    private final String f8427id;
    private int ifcollect;
    private final int ifdownload;
    private final int ifgift;

    @NotNull
    private final String ifgms;

    @Nullable
    private AppInfoItem item;

    @Nullable
    private final List<Integer> label;

    @Nullable
    private final String last_update_time;

    @NotNull
    private final String logo;

    @NotNull
    private final String name;

    @Nullable
    private final String new_features;

    @Nullable
    private final String operation_status;

    @Nullable
    private final String pay_type;

    @Nullable
    private final List<String> permission;

    @SerializedName("package")
    @NotNull
    private final String pkg;

    @Nullable
    private final String pkg_id;

    @Nullable
    private final List<String> printscreen;

    @Nullable
    private final String py_cname;

    @Nullable
    private final String py_name;

    @Nullable
    private final String raw_signature;

    @NotNull
    private final String recmd_brief;

    @Nullable
    private Integer resId;

    @Nullable
    private final String scalable;

    @Nullable
    private String scores;

    @Nullable
    private List<TvAppInfoScoresDetailEntity> scores_detail;

    @Nullable
    private final String share_download_url;

    @Nullable
    private final String signature;

    @Nullable
    private final String size;

    @Nullable
    private final String soft_type;

    @Nullable
    private final String source;

    @Nullable
    private final String spread;

    @Nullable
    private final String status;

    @Nullable
    private String subCid;

    @Nullable
    private final String update_time;

    @NotNull
    private String version;

    @NotNull
    private String version_code;

    @Nullable
    private final TvAppInfoVideoEntity video;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<AppInfoEntity> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AppInfoEntity createFromParcel(@NotNull Parcel r64) {
            q.g(r64, "parcel");
            String r10 = r64.readString();
            String r11 = r64.readString();
            String r12 = r64.readString();
            String r13 = r64.readString();
            String r14 = r64.readString();
            String r15 = r64.readString();
            String r16 = r64.readString();
            String r17 = r64.readString();
            String r18 = r64.readString();
            String r19 = r64.readString();
            String r110 = r64.readString();
            String r111 = r64.readString();
            String r112 = r64.readString();
            String r113 = r64.readString();
            String r114 = r64.readString();
            String r115 = r64.readString();
            String r116 = r64.readString();
            String r20 = r64.readString();
            String r21 = r64.readString();
            String r22 = r64.readString();
            String r23 = r64.readString();
            String r24 = r64.readString();
            String r25 = r64.readString();
            String r26 = r64.readString();
            String r27 = r64.readString();
            if (r64.readInt() != 0) goto L5;
            TvAppInfoVideoEntity r28 = null;
        L6:
            TvAppInfoVideoEntity r29 = r28;
            String r210 = r64.readString();
            String r30 = r64.readString();
            String r31 = r64.readString();
            if (r64.readInt() != 0) goto L9;
            ArrayList r32 = null;
        L13:
            String r34 = r64.readString();
            String r35 = r64.readString();
            String r36 = r64.readString();
            String r37 = r64.readString();
            String r38 = r64.readString();
            String r39 = r64.readString();
            if (r64.readInt() != 0) goto L16;
            ArrayList r33 = null;
        L20:
            ArrayList<String> r41 = r64.createStringArrayList();
            if (r64.readInt() != 0) goto L23;
            TvAppInfoFromEntity r40 = null;
        L24:
            TvAppInfoFromEntity r42 = r40;
            String r43 = r64.readString();
            String r44 = r64.readString();
            String r45 = r64.readString();
            String r46 = r64.readString();
            if (r64.readInt() != 0) goto L27;
            ArrayList r47 = null;
        L31:
            ArrayList<String> r48 = r64.createStringArrayList();
            String r49 = r64.readString();
            String r50 = r64.readString();
            int r51 = r64.readInt();
            int r52 = r64.readInt();
            String r53 = r64.readString();
            String r54 = r64.readString();
            String r55 = r64.readString();
            String r56 = r64.readString();
            String r57 = r64.readString();
            int r58 = r64.readInt();
            Object r59 = r64.readValue(AppInfoEntity.class.getClassLoader());
            String r60 = r64.readString();
            if (r64.readInt() != 0) goto L34;
            ArrayList r61 = null;
        L39:
            if (r64.readInt() != 0) goto L41;
            Integer r62 = null;
        L43:
            return new AppInfoEntity(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114, r115, r116, r20, r21, r22, r23, r24, r25, r26, r27, r29, r210, r30, r31, r32, r34, r35, r36, r37, r38, r39, r33, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62);
        L41:
            r62 = Integer.valueOf(r64.readInt());
            goto L43
        L34:
            int r63 = r64.readInt();
            ArrayList r117 = new ArrayList(r63);
            int r65 = 0;
        L35:
            if (r65 == r63) goto L37;
            r117.add(AppDetailGiftEntity.CREATOR.createFromParcel(r64));
            r65 = r65 + 1;
            r63 = r63;
            goto L35
        L37:
            r61 = r117;
            goto L39
        L27:
            int r66 = r64.readInt();
            ArrayList r118 = new ArrayList(r66);
            int r67 = 0;
        L28:
            if (r67 == r66) goto L30;
            r118.add(TvAppInfoScoresDetailEntity.CREATOR.createFromParcel(r64));
            r67 = r67 + 1;
            r66 = r66;
            goto L28
        L30:
            r47 = r118;
            goto L31
        L23:
            r40 = TvAppInfoFromEntity.CREATOR.createFromParcel(r64);
            goto L24
        L16:
            int r68 = r64.readInt();
            ArrayList r119 = new ArrayList(r68);
            int r69 = 0;
        L17:
            if (r69 == r68) goto L19;
            r119.add(TvAppInfoCategoryInfoEntity.CREATOR.createFromParcel(r64));
            r69 = r69 + 1;
            r68 = r68;
            goto L17
        L19:
            r33 = r119;
            goto L20
        L9:
            int r70 = r64.readInt();
            ArrayList r71 = new ArrayList(r70);
            int r120 = 0;
        L10:
            if (r120 == r70) goto L12;
            r71.add(Integer.valueOf(r64.readInt()));
            r120 = r120 + 1;
            r70 = r70;
            goto L10
        L12:
            r32 = r71;
            goto L13
        L5:
            r28 = TvAppInfoVideoEntity.CREATOR.createFromParcel(r64);
            goto L6
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AppInfoEntity[] newArray(int r10) {
            return new AppInfoEntity[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AppInfoEntity createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AppInfoEntity[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public AppInfoEntity(@Nullable String r13, @Nullable String r14, @Nullable String r15, @NotNull String r16, @NotNull String r17, @NotNull String r18, @NotNull String r19, @NotNull String r20, @NotNull String r21, @NotNull String r22, @Nullable String r23, @Nullable String r24, @Nullable String r25, @Nullable String r26, @Nullable String r27, @Nullable String r28, @Nullable String r29, @Nullable String r30, @Nullable String r31, @Nullable String r32, @Nullable String r33, @Nullable String r34, @Nullable String r35, @Nullable String r36, @NotNull String r37, @Nullable TvAppInfoVideoEntity r38, @Nullable String r39, @Nullable String r40, @Nullable String r41, @Nullable List<Integer> r42, @Nullable String r43, @Nullable String r44, @Nullable String r45, @Nullable String r46, @Nullable String r47, @Nullable String r48, @Nullable List<TvAppInfoCategoryInfoEntity> r49, @Nullable List<String> r50, @Nullable TvAppInfoFromEntity r51, @NotNull String r52, @Nullable String r53, @Nullable String r54, @Nullable String r55, @Nullable List<TvAppInfoScoresDetailEntity> r56, @Nullable List<String> r57, @Nullable String r58, @NotNull String r59, int r60, int r61, @Nullable String r62, @Nullable String r63, @Nullable String r64, @Nullable String r65, @Nullable String r66, int r67, @Nullable Object r68, @Nullable String r69, @Nullable List<AppDetailGiftEntity> r70, @Nullable Integer r71) {
        q.g(r16, "name");
        q.g(r17, ServerElements.CNAME);
        q.g(r18, "version");
        q.g(r19, "version_code");
        q.g(r20, AppPermissionActivity.EXTRA_APP_PKG);
        q.g(r21, ServerElements.FILESIZE);
        q.g(r22, ServerElements.LOGO);
        q.g(r37, ServerElements.RECMD_BRIEF);
        q.g(r52, ServerElements.DOWNLOAD_URL);
        q.g(r59, ServerElements.IFGMS);
        this.f8427id = r13;
        this.pkg_id = r14;
        this.dever_id = r15;
        this.name = r16;
        this.cname = r17;
        this.version = r18;
        this.version_code = r19;
        this.pkg = r20;
        this.filesize = r21;
        this.logo = r22;
        this.banner = r23;
        this.draw_logo = r24;
        this.apk_file = r25;
        this.status = r26;
        this.create_time = r27;
        this.update_time = r28;
        this.last_update_time = r29;
        this.developer = r30;
        this.pay_type = r31;
        this.soft_type = r32;
        this.grade_desc = r33;
        this.py_name = r34;
        this.py_cname = r35;
        this.brief = r36;
        this.recmd_brief = r37;
        this.video = r38;
        this.draw = r39;
        this.first_pub = r40;
        this.spread = r41;
        this.label = r42;
        this.game_type = r43;
        this.operation_status = r44;
        this.category = r45;
        this.gift_num = r46;
        this.cid = r47;
        this.subCid = r48;
        this.category_info = r49;
        this.printscreen = r50;
        this.from = r51;
        this.download_url = r52;
        this.share_download_url = r53;
        this.scalable = r54;
        this.scores = r55;
        this.scores_detail = r56;
        this.permission = r57;
        this.comments = r58;
        this.ifgms = r59;
        this.ifcollect = r60;
        this.ifdownload = r61;
        this.size = r62;
        this.new_features = r63;
        this.filemd5 = r64;
        this.signature = r65;
        this.raw_signature = r66;
        this.ifgift = r67;
        this.comment = r68;
        this.source = r69;
        this.gifts = r70;
        this.resId = r71;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AppInfoEntity copy$default(AppInfoEntity r24, String r25, String r26, String r27, String r28, String r29, String r30, String r31, String r32, String r33, String r34, String r35, String r36, String r37, String r38, String r39, String r40, String r41, String r42, String r43, String r44, String r45, String r46, String r47, String r48, String r49, TvAppInfoVideoEntity r50, String r51, String r52, String r53, List r54, String r55, String r56, String r57, String r58, String r59, String r60, List r61, List r62, TvAppInfoFromEntity r63, String r64, String r65, String r66, String r67, List r68, List r69, String r70, String r71, int r72, int r73, String r74, String r75, String r76, String r77, String r78, int r79, Object r80, String r81, List r82, Integer r83, int r84, int r85, Object r86) {
        if ((r84 & 1) == 0) goto L5;
        String r10 = r24.f8427id;
    L7:
        if ((r84 & 2) == 0) goto L9;
        String r11 = r24.pkg_id;
    L11:
        if ((r84 & 4) == 0) goto L13;
        String r12 = r24.dever_id;
    L15:
        if ((r84 & 8) == 0) goto L17;
        String r13 = r24.name;
    L19:
        if ((r84 & 16) == 0) goto L21;
        String r14 = r24.cname;
    L23:
        if ((r84 & 32) == 0) goto L25;
        String r15 = r24.version;
    L27:
        if ((r84 & 64) == 0) goto L29;
        String r16 = r24.version_code;
    L31:
        if ((r84 & 128) == 0) goto L33;
        String r17 = r24.pkg;
    L35:
        if ((r84 & 256) == 0) goto L37;
        String r18 = r24.filesize;
    L39:
        if ((r84 & 512) == 0) goto L41;
        String r19 = r24.logo;
    L43:
        if ((r84 & 1024) == 0) goto L45;
        String r110 = r24.banner;
    L47:
        if ((r84 & 2048) == 0) goto L49;
        String r111 = r24.draw_logo;
    L51:
        if ((r84 & 4096) == 0) goto L53;
        String r112 = r24.apk_file;
    L54:
        String r310 = r112;
        if ((r84 & 8192) == 0) goto L57;
        String r113 = r24.status;
    L58:
        String r311 = r113;
        if ((r84 & 16384) == 0) goto L61;
        String r114 = r24.create_time;
    L62:
        String r312 = r114;
        if ((r84 & UiType.FLAG_SETTINGS_CARD) == 0) goto L65;
        String r115 = r24.update_time;
    L66:
        String r410 = r115;
        if ((r84 & 65536) == 0) goto L69;
        String r116 = r24.last_update_time;
    L70:
        String r411 = r116;
        if ((r84 & UiType.FLAG_PHONE_CARD) == 0) goto L73;
        String r117 = r24.developer;
    L74:
        String r412 = r117;
        if ((r84 & UiType.FLAG_TIMER_CARD) == 0) goto L77;
        String r118 = r24.pay_type;
    L78:
        String r413 = r118;
        if ((r84 & UiType.FLAG_WIFI_QRCODE_CARD) == 0) goto L81;
        String r119 = r24.soft_type;
    L82:
        String r414 = r119;
        if ((r84 & UiType.FLAG_APP_CHOOSER_CARD) == 0) goto L85;
        String r120 = r24.grade_desc;
    L86:
        String r415 = r120;
        if ((r84 & UiType.FLAG_REMOTE_CARD) == 0) goto L89;
        String r121 = r24.py_name;
    L90:
        String r416 = r121;
        if ((r84 & UiType.FLAG_NO_FEEDBACK) == 0) goto L93;
        String r122 = r24.py_cname;
    L94:
        String r417 = r122;
        if ((r84 & UiType.FLAG_APPLET_CARD) == 0) goto L97;
        String r123 = r24.brief;
    L98:
        String r418 = r123;
        if ((r84 & 16777216) == 0) goto L101;
        String r124 = r24.recmd_brief;
    L102:
        String r419 = r124;
        if ((r84 & 33554432) == 0) goto L105;
        TvAppInfoVideoEntity r125 = r24.video;
    L106:
        TvAppInfoVideoEntity r510 = r125;
        if ((r84 & 67108864) == 0) goto L109;
        String r126 = r24.draw;
    L110:
        String r511 = r126;
        if ((r84 & 134217728) == 0) goto L113;
        String r127 = r24.first_pub;
    L114:
        String r512 = r127;
        if ((r84 & 268435456) == 0) goto L117;
        String r128 = r24.spread;
    L118:
        String r513 = r128;
        if ((r84 & 536870912) == 0) goto L121;
        List r129 = r24.label;
    L122:
        List r514 = r129;
        if ((r84 & Ints.MAX_POWER_OF_TWO) == 0) goto L125;
        String r130 = r24.game_type;
    L127:
        if ((r84 & Integer.MIN_VALUE) == 0) goto L129;
        String r20 = r24.operation_status;
    L130:
        String r515 = r20;
        if ((r85 & 1) == 0) goto L133;
        String r21 = r24.category;
    L134:
        String r516 = r21;
        if ((r85 & 2) == 0) goto L137;
        String r22 = r24.gift_num;
    L138:
        String r517 = r22;
        if ((r85 & 4) == 0) goto L141;
        String r23 = r24.cid;
    L142:
        String r518 = r23;
        if ((r85 & 8) == 0) goto L145;
        String r87 = r24.subCid;
    L146:
        String r610 = r87;
        if ((r85 & 16) == 0) goto L149;
        List r88 = r24.category_info;
    L150:
        List r611 = r88;
        if ((r85 & 32) == 0) goto L153;
        List r89 = r24.printscreen;
    L154:
        List r612 = r89;
        if ((r85 & 64) == 0) goto L157;
        TvAppInfoFromEntity r90 = r24.from;
    L158:
        TvAppInfoFromEntity r613 = r90;
        if ((r85 & 128) == 0) goto L161;
        String r91 = r24.download_url;
    L162:
        String r614 = r91;
        if ((r85 & 256) == 0) goto L165;
        String r92 = r24.share_download_url;
    L166:
        String r615 = r92;
        if ((r85 & 512) == 0) goto L169;
        String r93 = r24.scalable;
    L170:
        String r616 = r93;
        if ((r85 & 1024) == 0) goto L173;
        String r94 = r24.scores;
    L174:
        String r617 = r94;
        if ((r85 & 2048) == 0) goto L177;
        List r95 = r24.scores_detail;
    L178:
        List r618 = r95;
        if ((r85 & 4096) == 0) goto L181;
        List r96 = r24.permission;
    L182:
        List r619 = r96;
        if ((r85 & 8192) == 0) goto L185;
        String r97 = r24.comments;
    L186:
        String r710 = r97;
        if ((r85 & 16384) == 0) goto L189;
        String r98 = r24.ifgms;
    L190:
        String r711 = r98;
        if ((r85 & UiType.FLAG_SETTINGS_CARD) == 0) goto L193;
        int r99 = r24.ifcollect;
    L194:
        int r712 = r99;
        if ((r85 & 65536) == 0) goto L197;
        int r100 = r24.ifdownload;
    L198:
        int r713 = r100;
        if ((r85 & UiType.FLAG_PHONE_CARD) == 0) goto L201;
        String r101 = r24.size;
    L202:
        String r714 = r101;
        if ((r85 & UiType.FLAG_TIMER_CARD) == 0) goto L205;
        String r102 = r24.new_features;
    L206:
        String r715 = r102;
        if ((r85 & UiType.FLAG_WIFI_QRCODE_CARD) == 0) goto L209;
        String r103 = r24.filemd5;
    L210:
        String r716 = r103;
        if ((r85 & UiType.FLAG_APP_CHOOSER_CARD) == 0) goto L213;
        String r104 = r24.signature;
    L214:
        String r717 = r104;
        if ((r85 & UiType.FLAG_REMOTE_CARD) == 0) goto L217;
        String r105 = r24.raw_signature;
    L218:
        String r718 = r105;
        if ((r85 & UiType.FLAG_NO_FEEDBACK) == 0) goto L221;
        int r106 = r24.ifgift;
    L222:
        int r719 = r106;
        if ((r85 & UiType.FLAG_APPLET_CARD) == 0) goto L225;
        Object r107 = r24.comment;
    L226:
        Object r810 = r107;
        if ((r85 & 16777216) == 0) goto L229;
        String r108 = r24.source;
    L230:
        String r811 = r108;
        if ((r85 & 33554432) == 0) goto L233;
        List r109 = r24.gifts;
    L235:
        if ((r85 & 67108864) == 0) goto L237;
        Integer r131 = r24.resId;
    L239:
        return r24.copy(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r310, r311, r312, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510, r511, r512, r513, r514, r130, r515, r516, r517, r518, r610, r611, r612, r613, r614, r615, r616, r617, r618, r619, r710, r711, r712, r713, r714, r715, r716, r717, r718, r719, r810, r811, r109, r131);
    L237:
        r131 = r83;
        goto L239
    L233:
        r109 = r82;
        goto L235
    L229:
        r108 = r81;
        goto L230
    L225:
        r107 = r80;
        goto L226
    L221:
        r106 = r79;
        goto L222
    L217:
        r105 = r78;
        goto L218
    L213:
        r104 = r77;
        goto L214
    L209:
        r103 = r76;
        goto L210
    L205:
        r102 = r75;
        goto L206
    L201:
        r101 = r74;
        goto L202
    L197:
        r100 = r73;
        goto L198
    L193:
        r99 = r72;
        goto L194
    L189:
        r98 = r71;
        goto L190
    L185:
        r97 = r70;
        goto L186
    L181:
        r96 = r69;
        goto L182
    L177:
        r95 = r68;
        goto L178
    L173:
        r94 = r67;
        goto L174
    L169:
        r93 = r66;
        goto L170
    L165:
        r92 = r65;
        goto L166
    L161:
        r91 = r64;
        goto L162
    L157:
        r90 = r63;
        goto L158
    L153:
        r89 = r62;
        goto L154
    L149:
        r88 = r61;
        goto L150
    L145:
        r87 = r60;
        goto L146
    L141:
        r23 = r59;
        goto L142
    L137:
        r22 = r58;
        goto L138
    L133:
        r21 = r57;
        goto L134
    L129:
        r20 = r56;
        goto L130
    L125:
        r130 = r55;
        goto L127
    L121:
        r129 = r54;
        goto L122
    L117:
        r128 = r53;
        goto L118
    L113:
        r127 = r52;
        goto L114
    L109:
        r126 = r51;
        goto L110
    L105:
        r125 = r50;
        goto L106
    L101:
        r124 = r49;
        goto L102
    L97:
        r123 = r48;
        goto L98
    L93:
        r122 = r47;
        goto L94
    L89:
        r121 = r46;
        goto L90
    L85:
        r120 = r45;
        goto L86
    L81:
        r119 = r44;
        goto L82
    L77:
        r118 = r43;
        goto L78
    L73:
        r117 = r42;
        goto L74
    L69:
        r116 = r41;
        goto L70
    L65:
        r115 = r40;
        goto L66
    L61:
        r114 = r39;
        goto L62
    L57:
        r113 = r38;
        goto L58
    L53:
        r112 = r37;
        goto L54
    L49:
        r111 = r36;
        goto L51
    L45:
        r110 = r35;
        goto L47
    L41:
        r19 = r34;
        goto L43
    L37:
        r18 = r33;
        goto L39
    L33:
        r17 = r32;
        goto L35
    L29:
        r16 = r31;
        goto L31
    L25:
        r15 = r30;
        goto L27
    L21:
        r14 = r29;
        goto L23
    L17:
        r13 = r28;
        goto L19
    L13:
        r12 = r27;
        goto L15
    L9:
        r11 = r26;
        goto L11
    L5:
        r10 = r25;
        goto L7
    }

    @Nullable
    public final String component1() {
        return this.f8427id;
    }

    @NotNull
    public final String component10() {
        return this.logo;
    }

    @Nullable
    public final String component11() {
        return this.banner;
    }

    @Nullable
    public final String component12() {
        return this.draw_logo;
    }

    @Nullable
    public final String component13() {
        return this.apk_file;
    }

    @Nullable
    public final String component14() {
        return this.status;
    }

    @Nullable
    public final String component15() {
        return this.create_time;
    }

    @Nullable
    public final String component16() {
        return this.update_time;
    }

    @Nullable
    public final String component17() {
        return this.last_update_time;
    }

    @Nullable
    public final String component18() {
        return this.developer;
    }

    @Nullable
    public final String component19() {
        return this.pay_type;
    }

    @Nullable
    public final String component2() {
        return this.pkg_id;
    }

    @Nullable
    public final String component20() {
        return this.soft_type;
    }

    @Nullable
    public final String component21() {
        return this.grade_desc;
    }

    @Nullable
    public final String component22() {
        return this.py_name;
    }

    @Nullable
    public final String component23() {
        return this.py_cname;
    }

    @Nullable
    public final String component24() {
        return this.brief;
    }

    @NotNull
    public final String component25() {
        return this.recmd_brief;
    }

    @Nullable
    public final TvAppInfoVideoEntity component26() {
        return this.video;
    }

    @Nullable
    public final String component27() {
        return this.draw;
    }

    @Nullable
    public final String component28() {
        return this.first_pub;
    }

    @Nullable
    public final String component29() {
        return this.spread;
    }

    @Nullable
    public final String component3() {
        return this.dever_id;
    }

    @Nullable
    public final List<Integer> component30() {
        return this.label;
    }

    @Nullable
    public final String component31() {
        return this.game_type;
    }

    @Nullable
    public final String component32() {
        return this.operation_status;
    }

    @Nullable
    public final String component33() {
        return this.category;
    }

    @Nullable
    public final String component34() {
        return this.gift_num;
    }

    @Nullable
    public final String component35() {
        return this.cid;
    }

    @Nullable
    public final String component36() {
        return this.subCid;
    }

    @Nullable
    public final List<TvAppInfoCategoryInfoEntity> component37() {
        return this.category_info;
    }

    @Nullable
    public final List<String> component38() {
        return this.printscreen;
    }

    @Nullable
    public final TvAppInfoFromEntity component39() {
        return this.from;
    }

    @NotNull
    public final String component4() {
        return this.name;
    }

    @NotNull
    public final String component40() {
        return this.download_url;
    }

    @Nullable
    public final String component41() {
        return this.share_download_url;
    }

    @Nullable
    public final String component42() {
        return this.scalable;
    }

    @Nullable
    public final String component43() {
        return this.scores;
    }

    @Nullable
    public final List<TvAppInfoScoresDetailEntity> component44() {
        return this.scores_detail;
    }

    @Nullable
    public final List<String> component45() {
        return this.permission;
    }

    @Nullable
    public final String component46() {
        return this.comments;
    }

    @NotNull
    public final String component47() {
        return this.ifgms;
    }

    public final int component48() {
        return this.ifcollect;
    }

    public final int component49() {
        return this.ifdownload;
    }

    @NotNull
    public final String component5() {
        return this.cname;
    }

    @Nullable
    public final String component50() {
        return this.size;
    }

    @Nullable
    public final String component51() {
        return this.new_features;
    }

    @Nullable
    public final String component52() {
        return this.filemd5;
    }

    @Nullable
    public final String component53() {
        return this.signature;
    }

    @Nullable
    public final String component54() {
        return this.raw_signature;
    }

    public final int component55() {
        return this.ifgift;
    }

    @Nullable
    public final Object component56() {
        return this.comment;
    }

    @Nullable
    public final String component57() {
        return this.source;
    }

    @Nullable
    public final List<AppDetailGiftEntity> component58() {
        return this.gifts;
    }

    @Nullable
    public final Integer component59() {
        return this.resId;
    }

    @NotNull
    public final String component6() {
        return this.version;
    }

    @NotNull
    public final String component7() {
        return this.version_code;
    }

    @NotNull
    public final String component8() {
        return this.pkg;
    }

    @NotNull
    public final String component9() {
        return this.filesize;
    }

    @NotNull
    public final AppInfo convertAppInfo() {
        AppInfo r10 = new AppInfo();
        r10.appId = this.f8427id;
        r10.appName = this.name;
        String r11 = this.version_code;     // Catch: NumberFormatException -> L9
        if (r11 == null) goto L11;
        Integer r12 = n.g(r11);     // Catch: NumberFormatException -> L9
        if (r12 == null) goto L11;
        r10.appVersionCode = r12.intValue();     // Catch: NumberFormatException -> L9
    L11:
        r10.appVersionName = this.version;
        r10.appPackageName = this.pkg;
        r10.appIcon = this.logo;
        String r13 = this.scores;
        if (r13 == null) goto L16;
        Float r14 = m.f(r13);
        if (r14 == null) goto L16;
        r10.appScores = r14.floatValue();
    L16:
        r10.appCategoryName = this.category;
        Long r15 = n.i(this.filesize);     // Catch: NumberFormatException -> L21
        if (r15 == null) goto L66;
        r10.appBytes = r15.longValue();     // Catch: NumberFormatException -> L21
    L66:
        String r16 = this.status;     // Catch: NumberFormatException -> L27
        if (r16 == null) goto L29;
        r10.mStatus = c0.b(r16);     // Catch: NumberFormatException -> L27
    L29:
        r10.fileMd5 = this.filemd5;
        r10.mIsNeedGms = q.b(this.ifgms, "1");
        TvAppInfoFromEntity r17 = this.from;
        if (r17 == null) goto L32;
        r10.setFrom(r17.getMark());
    L32:
        r10.appDownloadUrl = this.download_url;
        r10.recmd_brief = this.recmd_brief;
        String r18 = this.source;
        if (r18 != null) goto L35;
    L38:
        r10.appSource = "local";
    L68:
        String r19 = this.soft_type;     // Catch: NumberFormatException -> L45
        if (r19 == null) goto L58;
        Integer r20 = n.g(r19);     // Catch: NumberFormatException -> L45
        if (r20 == null) goto L58;
        r10.mAppType = r20.intValue();     // Catch: NumberFormatException -> L45
    L58:
        List<Integer> r21 = this.label;     // Catch: Exception -> L51
        if (r21 == null) goto L64;
        r10.mLabels.addAll(r21);     // Catch: Exception -> L51
    L64:
        JSONObject r22 = new JSONObject();     // Catch: Exception -> L55
        r22.put(ServerElements.ADS_IMPRESSION, this.permission);     // Catch: Exception -> L55
        r10.mJsonData = r22.toString();     // Catch: Exception -> L55
    L57:
        return r10;
    L55:
        e = move-exception;
        e.printStackTrace();
    L51:
        e = move-exception;
        j.f8856a.d(e);
    L45:
        e = move-exception;
        j.f8856a.d(e);
        r10.mAppType = 0;
        goto L58
    L35:
        if (o.r(r18) == true) goto L38;
        r10.appSource = this.source;
    L27:
        e = move-exception;
        e.printStackTrace();
    L21:
        e = move-exception;
        e.printStackTrace();
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    @NotNull
    public final CommonAppEntity convertCommonAppEntity() {
        CommonAppEntity r10 = new CommonAppEntity();
        r10.setId(this.f8427id);
        r10.setName(this.name);
        String r11 = this.version_code;     // Catch: NumberFormatException -> L9
        if (r11 == null) goto L11;
        Integer r12 = n.g(r11);     // Catch: NumberFormatException -> L9
        if (r12 == null) goto L11;
        r10.setVersion_code(r12.intValue());     // Catch: NumberFormatException -> L9
    L11:
        r10.setVersion(this.version);
        r10.setPkg(this.pkg);
        r10.setLogo(this.logo);
        String r13 = this.scores;
        if (r13 == null) goto L16;
        Float r14 = m.f(r13);
        if (r14 == null) goto L16;
        r10.setScores(r14.floatValue());
    L16:
        r10.setCategory(this.category);
        Long r15 = n.i(this.filesize);     // Catch: NumberFormatException -> L21
        if (r15 == null) goto L48;
        r10.setFilesize(r15.longValue());     // Catch: NumberFormatException -> L21
    L48:
        r10.setStatus(this.status);     // Catch: NumberFormatException -> L25
    L27:
        Integer r16 = n.g(this.ifgms);
        if (r16 == null) goto L30;
        r10.setIfgms(r16.intValue());
    L30:
        TvAppInfoFromEntity r17 = this.from;
        if (r17 == null) goto L33;
        r10.setFrom(r17.getMark());
    L33:
        r10.setDownload_url(this.download_url);
        r10.setRecmd_brief(this.recmd_brief);
        String r18 = this.soft_type;     // Catch: NumberFormatException -> L40
        if (r18 == null) goto L54;
        Integer r19 = n.g(r18);     // Catch: NumberFormatException -> L40
        if (r19 == null) goto L54;
        r10.setSoft_type(r19.intValue());     // Catch: NumberFormatException -> L40
    L54:
        r10.setLabel(this.label);     // Catch: Exception -> L44
    L46:
        r10.setItem(new CommonAppItem(r10));
        return r10;
    L44:
        e = move-exception;
        j.f8856a.d(e);
    L40:
        e = move-exception;
        j.f8856a.d(e);
        r10.setSoft_type(0);
    L25:
        e = move-exception;
        j.f8856a.d(e);
    L21:
        e = move-exception;
        j.f8856a.d(e);
    L9:
        e = move-exception;
        j.f8856a.d(e);
        goto L11
    }

    @NotNull
    public final AppInfoEntity copy(@Nullable String r62, @Nullable String r63, @Nullable String r64, @NotNull String r65, @NotNull String r66, @NotNull String r67, @NotNull String r68, @NotNull String r69, @NotNull String r70, @NotNull String r71, @Nullable String r72, @Nullable String r73, @Nullable String r74, @Nullable String r75, @Nullable String r76, @Nullable String r77, @Nullable String r78, @Nullable String r79, @Nullable String r80, @Nullable String r81, @Nullable String r82, @Nullable String r83, @Nullable String r84, @Nullable String r85, @NotNull String r86, @Nullable TvAppInfoVideoEntity r87, @Nullable String r88, @Nullable String r89, @Nullable String r90, @Nullable List<Integer> r91, @Nullable String r92, @Nullable String r93, @Nullable String r94, @Nullable String r95, @Nullable String r96, @Nullable String r97, @Nullable List<TvAppInfoCategoryInfoEntity> r98, @Nullable List<String> r99, @Nullable TvAppInfoFromEntity r100, @NotNull String r101, @Nullable String r102, @Nullable String r103, @Nullable String r104, @Nullable List<TvAppInfoScoresDetailEntity> r105, @Nullable List<String> r106, @Nullable String r107, @NotNull String r108, int r109, int r110, @Nullable String r111, @Nullable String r112, @Nullable String r113, @Nullable String r114, @Nullable String r115, int r116, @Nullable Object r117, @Nullable String r118, @Nullable List<AppDetailGiftEntity> r119, @Nullable Integer r120) {
        q.g(r65, "name");
        q.g(r66, ServerElements.CNAME);
        q.g(r67, "version");
        q.g(r68, "version_code");
        q.g(r69, AppPermissionActivity.EXTRA_APP_PKG);
        q.g(r70, ServerElements.FILESIZE);
        q.g(r71, ServerElements.LOGO);
        q.g(r86, ServerElements.RECMD_BRIEF);
        q.g(r101, ServerElements.DOWNLOAD_URL);
        q.g(r108, ServerElements.IFGMS);
        return new AppInfoEntity(r62, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73, r74, r75, r76, r77, r78, r79, r80, r81, r82, r83, r84, r85, r86, r87, r88, r89, r90, r91, r92, r93, r94, r95, r96, r97, r98, r99, r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof AppInfoEntity) == true) goto L8;
        return false;
    L8:
        AppInfoEntity r11 = (AppInfoEntity) r10;
        if (q.b(this.f8427id, r11.f8427id) == true) goto L12;
        return false;
    L12:
        if (q.b(this.pkg_id, r11.pkg_id) == true) goto L15;
        return false;
    L15:
        if (q.b(this.dever_id, r11.dever_id) == true) goto L18;
        return false;
    L18:
        if (q.b(this.name, r11.name) == true) goto L21;
        return false;
    L21:
        if (q.b(this.cname, r11.cname) == true) goto L24;
        return false;
    L24:
        if (q.b(this.version, r11.version) == true) goto L27;
        return false;
    L27:
        if (q.b(this.version_code, r11.version_code) == true) goto L30;
        return false;
    L30:
        if (q.b(this.pkg, r11.pkg) == true) goto L33;
        return false;
    L33:
        if (q.b(this.filesize, r11.filesize) == true) goto L36;
        return false;
    L36:
        if (q.b(this.logo, r11.logo) == true) goto L39;
        return false;
    L39:
        if (q.b(this.banner, r11.banner) == true) goto L42;
        return false;
    L42:
        if (q.b(this.draw_logo, r11.draw_logo) == true) goto L45;
        return false;
    L45:
        if (q.b(this.apk_file, r11.apk_file) == true) goto L48;
        return false;
    L48:
        if (q.b(this.status, r11.status) == true) goto L51;
        return false;
    L51:
        if (q.b(this.create_time, r11.create_time) == true) goto L54;
        return false;
    L54:
        if (q.b(this.update_time, r11.update_time) == true) goto L57;
        return false;
    L57:
        if (q.b(this.last_update_time, r11.last_update_time) == true) goto L60;
        return false;
    L60:
        if (q.b(this.developer, r11.developer) == true) goto L63;
        return false;
    L63:
        if (q.b(this.pay_type, r11.pay_type) == true) goto L66;
        return false;
    L66:
        if (q.b(this.soft_type, r11.soft_type) == true) goto L69;
        return false;
    L69:
        if (q.b(this.grade_desc, r11.grade_desc) == true) goto L72;
        return false;
    L72:
        if (q.b(this.py_name, r11.py_name) == true) goto L75;
        return false;
    L75:
        if (q.b(this.py_cname, r11.py_cname) == true) goto L78;
        return false;
    L78:
        if (q.b(this.brief, r11.brief) == true) goto L81;
        return false;
    L81:
        if (q.b(this.recmd_brief, r11.recmd_brief) == true) goto L84;
        return false;
    L84:
        if (q.b(this.video, r11.video) == true) goto L87;
        return false;
    L87:
        if (q.b(this.draw, r11.draw) == true) goto L90;
        return false;
    L90:
        if (q.b(this.first_pub, r11.first_pub) == true) goto L93;
        return false;
    L93:
        if (q.b(this.spread, r11.spread) == true) goto L96;
        return false;
    L96:
        if (q.b(this.label, r11.label) == true) goto L99;
        return false;
    L99:
        if (q.b(this.game_type, r11.game_type) == true) goto L102;
        return false;
    L102:
        if (q.b(this.operation_status, r11.operation_status) == true) goto L105;
        return false;
    L105:
        if (q.b(this.category, r11.category) == true) goto L108;
        return false;
    L108:
        if (q.b(this.gift_num, r11.gift_num) == true) goto L111;
        return false;
    L111:
        if (q.b(this.cid, r11.cid) == true) goto L114;
        return false;
    L114:
        if (q.b(this.subCid, r11.subCid) == true) goto L117;
        return false;
    L117:
        if (q.b(this.category_info, r11.category_info) == true) goto L120;
        return false;
    L120:
        if (q.b(this.printscreen, r11.printscreen) == true) goto L123;
        return false;
    L123:
        if (q.b(this.from, r11.from) == true) goto L126;
        return false;
    L126:
        if (q.b(this.download_url, r11.download_url) == true) goto L129;
        return false;
    L129:
        if (q.b(this.share_download_url, r11.share_download_url) == true) goto L132;
        return false;
    L132:
        if (q.b(this.scalable, r11.scalable) == true) goto L135;
        return false;
    L135:
        if (q.b(this.scores, r11.scores) == true) goto L138;
        return false;
    L138:
        if (q.b(this.scores_detail, r11.scores_detail) == true) goto L141;
        return false;
    L141:
        if (q.b(this.permission, r11.permission) == true) goto L144;
        return false;
    L144:
        if (q.b(this.comments, r11.comments) == true) goto L147;
        return false;
    L147:
        if (q.b(this.ifgms, r11.ifgms) == true) goto L150;
        return false;
    L150:
        if (this.ifcollect == r11.ifcollect) goto L153;
        return false;
    L153:
        if (this.ifdownload == r11.ifdownload) goto L156;
        return false;
    L156:
        if (q.b(this.size, r11.size) == true) goto L159;
        return false;
    L159:
        if (q.b(this.new_features, r11.new_features) == true) goto L162;
        return false;
    L162:
        if (q.b(this.filemd5, r11.filemd5) == true) goto L165;
        return false;
    L165:
        if (q.b(this.signature, r11.signature) == true) goto L168;
        return false;
    L168:
        if (q.b(this.raw_signature, r11.raw_signature) == true) goto L171;
        return false;
    L171:
        if (this.ifgift == r11.ifgift) goto L174;
        return false;
    L174:
        if (q.b(this.comment, r11.comment) == true) goto L177;
        return false;
    L177:
        if (q.b(this.source, r11.source) == true) goto L180;
        return false;
    L180:
        if (q.b(this.gifts, r11.gifts) == true) goto L183;
        return false;
    L183:
        if (q.b(this.resId, r11.resId) == true) goto L185;
        return false;
    L185:
        return true;
    }

    @Nullable
    public final String getApk_file() {
        return this.apk_file;
    }

    @Nullable
    public final String getBanner() {
        return this.banner;
    }

    @Nullable
    public final String getBrief() {
        return this.brief;
    }

    @Nullable
    public final String getCategory() {
        return this.category;
    }

    @Nullable
    public final List<TvAppInfoCategoryInfoEntity> getCategory_info() {
        return this.category_info;
    }

    @Nullable
    public final String getCid() {
        return this.cid;
    }

    @NotNull
    public final String getCname() {
        return this.cname;
    }

    @Nullable
    public final Object getComment() {
        return this.comment;
    }

    @Nullable
    public final String getComments() {
        return this.comments;
    }

    @Nullable
    public final String getCreate_time() {
        return this.create_time;
    }

    @Nullable
    public final String getDeveloper() {
        return this.developer;
    }

    @Nullable
    public final String getDever_id() {
        return this.dever_id;
    }

    @NotNull
    public final String getDownload_url() {
        return this.download_url;
    }

    @Nullable
    public final String getDraw() {
        return this.draw;
    }

    @Nullable
    public final String getDraw_logo() {
        return this.draw_logo;
    }

    @Nullable
    public final String getFilemd5() {
        return this.filemd5;
    }

    @NotNull
    public final String getFilesize() {
        return this.filesize;
    }

    @Nullable
    public final String getFirst_pub() {
        return this.first_pub;
    }

    @Nullable
    public final TvAppInfoFromEntity getFrom() {
        return this.from;
    }

    @Nullable
    public final String getGame_type() {
        return this.game_type;
    }

    @Nullable
    public final String getGift_num() {
        return this.gift_num;
    }

    @Nullable
    public final List<AppDetailGiftEntity> getGifts() {
        return this.gifts;
    }

    @Nullable
    public final String getGrade_desc() {
        return this.grade_desc;
    }

    @Nullable
    public final String getId() {
        return this.f8427id;
    }

    public final int getIfcollect() {
        return this.ifcollect;
    }

    public final int getIfdownload() {
        return this.ifdownload;
    }

    public final int getIfgift() {
        return this.ifgift;
    }

    @NotNull
    public final String getIfgms() {
        return this.ifgms;
    }

    @Nullable
    public final AppInfoItem getItem() {
        return this.item;
    }

    @Nullable
    public final List<Integer> getLabel() {
        return this.label;
    }

    @Nullable
    public final String getLast_update_time() {
        return this.last_update_time;
    }

    @NotNull
    public final String getLogo() {
        return this.logo;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getNew_features() {
        return this.new_features;
    }

    @Nullable
    public final String getOperation_status() {
        return this.operation_status;
    }

    @Nullable
    public final String getPay_type() {
        return this.pay_type;
    }

    @Nullable
    public final List<String> getPermission() {
        return this.permission;
    }

    @NotNull
    public final String getPkg() {
        return this.pkg;
    }

    @Nullable
    public final String getPkg_id() {
        return this.pkg_id;
    }

    @Nullable
    public final List<String> getPrintscreen() {
        return this.printscreen;
    }

    @Nullable
    public final String getPy_cname() {
        return this.py_cname;
    }

    @Nullable
    public final String getPy_name() {
        return this.py_name;
    }

    @Nullable
    public final String getRaw_signature() {
        return this.raw_signature;
    }

    @NotNull
    public final String getRecmd_brief() {
        return this.recmd_brief;
    }

    @Nullable
    public final Integer getResId() {
        return this.resId;
    }

    @Nullable
    public final String getScalable() {
        return this.scalable;
    }

    @Nullable
    public final String getScores() {
        return this.scores;
    }

    @Nullable
    public final List<TvAppInfoScoresDetailEntity> getScores_detail() {
        return this.scores_detail;
    }

    @Nullable
    public final String getShare_download_url() {
        return this.share_download_url;
    }

    @Nullable
    public final String getSignature() {
        return this.signature;
    }

    @Nullable
    public final String getSize() {
        return this.size;
    }

    @Nullable
    public final String getSoft_type() {
        return this.soft_type;
    }

    @Nullable
    public final String getSource() {
        return this.source;
    }

    @Nullable
    public final String getSpread() {
        return this.spread;
    }

    @Nullable
    public final String getStatus() {
        return this.status;
    }

    @Nullable
    public final String getSubCid() {
        return this.subCid;
    }

    @Nullable
    public final TvGradeWrap getTvGradeWrap() {
        Object r10 = this.comment;     // Catch: Exception -> L8
        if (r10 != null) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(String.valueOf(r10)) == true) goto L15;
        return (TvGradeWrap) new Gson().fromJson(String.valueOf(this.comment), TvGradeWrap.class);
    L15:
        return null;
    L8:
        e = move-exception;
        j.f8856a.d(e);
        return null;
    }

    @Nullable
    public final String getUpdate_time() {
        return this.update_time;
    }

    @NotNull
    public final String getVersion() {
        return this.version;
    }

    @NotNull
    public final String getVersion_code() {
        return this.version_code;
    }

    @Nullable
    public final TvAppInfoVideoEntity getVideo() {
        return this.video;
    }

    public int hashCode() {
        String r10 = this.f8427id;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        String r14 = this.pkg_id;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        String r17 = this.dever_id;
        if (r17 != null) goto L13;
        int r18 = 0;
    L14:
        int r19 = (((((((((((((((r16 + r18) * 31) + this.name.hashCode()) * 31) + this.cname.hashCode()) * 31) + this.version.hashCode()) * 31) + this.version_code.hashCode()) * 31) + this.pkg.hashCode()) * 31) + this.filesize.hashCode()) * 31) + this.logo.hashCode()) * 31;
        String r20 = this.banner;
        if (r20 != null) goto L17;
        int r21 = 0;
    L18:
        int r22 = (r19 + r21) * 31;
        String r23 = this.draw_logo;
        if (r23 != null) goto L21;
        int r24 = 0;
    L22:
        int r25 = (r22 + r24) * 31;
        String r26 = this.apk_file;
        if (r26 != null) goto L25;
        int r27 = 0;
    L26:
        int r28 = (r25 + r27) * 31;
        String r29 = this.status;
        if (r29 != null) goto L29;
        int r30 = 0;
    L30:
        int r31 = (r28 + r30) * 31;
        String r32 = this.create_time;
        if (r32 != null) goto L33;
        int r33 = 0;
    L34:
        int r34 = (r31 + r33) * 31;
        String r35 = this.update_time;
        if (r35 != null) goto L37;
        int r36 = 0;
    L38:
        int r37 = (r34 + r36) * 31;
        String r38 = this.last_update_time;
        if (r38 != null) goto L41;
        int r39 = 0;
    L42:
        int r40 = (r37 + r39) * 31;
        String r41 = this.developer;
        if (r41 != null) goto L45;
        int r42 = 0;
    L46:
        int r43 = (r40 + r42) * 31;
        String r44 = this.pay_type;
        if (r44 != null) goto L49;
        int r45 = 0;
    L50:
        int r46 = (r43 + r45) * 31;
        String r47 = this.soft_type;
        if (r47 != null) goto L53;
        int r48 = 0;
    L54:
        int r49 = (r46 + r48) * 31;
        String r50 = this.grade_desc;
        if (r50 != null) goto L57;
        int r51 = 0;
    L58:
        int r52 = (r49 + r51) * 31;
        String r53 = this.py_name;
        if (r53 != null) goto L61;
        int r54 = 0;
    L62:
        int r55 = (r52 + r54) * 31;
        String r56 = this.py_cname;
        if (r56 != null) goto L65;
        int r57 = 0;
    L66:
        int r58 = (r55 + r57) * 31;
        String r59 = this.brief;
        if (r59 != null) goto L69;
        int r60 = 0;
    L70:
        int r61 = (((r58 + r60) * 31) + this.recmd_brief.hashCode()) * 31;
        TvAppInfoVideoEntity r62 = this.video;
        if (r62 != null) goto L73;
        int r63 = 0;
    L74:
        int r64 = (r61 + r63) * 31;
        String r65 = this.draw;
        if (r65 != null) goto L77;
        int r66 = 0;
    L78:
        int r67 = (r64 + r66) * 31;
        String r68 = this.first_pub;
        if (r68 != null) goto L81;
        int r69 = 0;
    L82:
        int r70 = (r67 + r69) * 31;
        String r71 = this.spread;
        if (r71 != null) goto L85;
        int r72 = 0;
    L86:
        int r73 = (r70 + r72) * 31;
        List<Integer> r74 = this.label;
        if (r74 != null) goto L89;
        int r75 = 0;
    L90:
        int r76 = (r73 + r75) * 31;
        String r77 = this.game_type;
        if (r77 != null) goto L93;
        int r78 = 0;
    L94:
        int r79 = (r76 + r78) * 31;
        String r80 = this.operation_status;
        if (r80 != null) goto L97;
        int r81 = 0;
    L98:
        int r82 = (r79 + r81) * 31;
        String r83 = this.category;
        if (r83 != null) goto L101;
        int r84 = 0;
    L102:
        int r85 = (r82 + r84) * 31;
        String r86 = this.gift_num;
        if (r86 != null) goto L105;
        int r87 = 0;
    L106:
        int r88 = (r85 + r87) * 31;
        String r89 = this.cid;
        if (r89 != null) goto L109;
        int r90 = 0;
    L110:
        int r91 = (r88 + r90) * 31;
        String r92 = this.subCid;
        if (r92 != null) goto L113;
        int r93 = 0;
    L114:
        int r94 = (r91 + r93) * 31;
        List<TvAppInfoCategoryInfoEntity> r95 = this.category_info;
        if (r95 != null) goto L117;
        int r96 = 0;
    L118:
        int r97 = (r94 + r96) * 31;
        List<String> r98 = this.printscreen;
        if (r98 != null) goto L121;
        int r99 = 0;
    L122:
        int r100 = (r97 + r99) * 31;
        TvAppInfoFromEntity r101 = this.from;
        if (r101 != null) goto L125;
        int r102 = 0;
    L126:
        int r103 = (((r100 + r102) * 31) + this.download_url.hashCode()) * 31;
        String r104 = this.share_download_url;
        if (r104 != null) goto L129;
        int r105 = 0;
    L130:
        int r106 = (r103 + r105) * 31;
        String r107 = this.scalable;
        if (r107 != null) goto L133;
        int r108 = 0;
    L134:
        int r109 = (r106 + r108) * 31;
        String r110 = this.scores;
        if (r110 != null) goto L137;
        int r111 = 0;
    L138:
        int r112 = (r109 + r111) * 31;
        List<TvAppInfoScoresDetailEntity> r113 = this.scores_detail;
        if (r113 != null) goto L141;
        int r114 = 0;
    L142:
        int r115 = (r112 + r114) * 31;
        List<String> r116 = this.permission;
        if (r116 != null) goto L145;
        int r117 = 0;
    L146:
        int r118 = (r115 + r117) * 31;
        String r119 = this.comments;
        if (r119 != null) goto L149;
        int r120 = 0;
    L150:
        int r121 = (((((((r118 + r120) * 31) + this.ifgms.hashCode()) * 31) + Integer.hashCode(this.ifcollect)) * 31) + Integer.hashCode(this.ifdownload)) * 31;
        String r122 = this.size;
        if (r122 != null) goto L153;
        int r123 = 0;
    L154:
        int r124 = (r121 + r123) * 31;
        String r125 = this.new_features;
        if (r125 != null) goto L157;
        int r126 = 0;
    L158:
        int r127 = (r124 + r126) * 31;
        String r128 = this.filemd5;
        if (r128 != null) goto L161;
        int r129 = 0;
    L162:
        int r130 = (r127 + r129) * 31;
        String r131 = this.signature;
        if (r131 != null) goto L165;
        int r132 = 0;
    L166:
        int r133 = (r130 + r132) * 31;
        String r134 = this.raw_signature;
        if (r134 != null) goto L169;
        int r135 = 0;
    L170:
        int r136 = (((r133 + r135) * 31) + Integer.hashCode(this.ifgift)) * 31;
        Object r137 = this.comment;
        if (r137 != null) goto L173;
        int r138 = 0;
    L174:
        int r139 = (r136 + r138) * 31;
        String r140 = this.source;
        if (r140 != null) goto L177;
        int r141 = 0;
    L178:
        int r142 = (r139 + r141) * 31;
        List<AppDetailGiftEntity> r143 = this.gifts;
        if (r143 != null) goto L181;
        int r144 = 0;
    L182:
        int r145 = (r142 + r144) * 31;
        Integer r146 = this.resId;
        if (r146 == null) goto L187;
        r11 = r146.hashCode();
    L187:
        return r145 + r11;
    L181:
        r144 = r143.hashCode();
        goto L182
    L177:
        r141 = r140.hashCode();
        goto L178
    L173:
        r138 = r137.hashCode();
        goto L174
    L169:
        r135 = r134.hashCode();
        goto L170
    L165:
        r132 = r131.hashCode();
        goto L166
    L161:
        r129 = r128.hashCode();
        goto L162
    L157:
        r126 = r125.hashCode();
        goto L158
    L153:
        r123 = r122.hashCode();
        goto L154
    L149:
        r120 = r119.hashCode();
        goto L150
    L145:
        r117 = r116.hashCode();
        goto L146
    L141:
        r114 = r113.hashCode();
        goto L142
    L137:
        r111 = r110.hashCode();
        goto L138
    L133:
        r108 = r107.hashCode();
        goto L134
    L129:
        r105 = r104.hashCode();
        goto L130
    L125:
        r102 = r101.hashCode();
        goto L126
    L121:
        r99 = r98.hashCode();
        goto L122
    L117:
        r96 = r95.hashCode();
        goto L118
    L113:
        r93 = r92.hashCode();
        goto L114
    L109:
        r90 = r89.hashCode();
        goto L110
    L105:
        r87 = r86.hashCode();
        goto L106
    L101:
        r84 = r83.hashCode();
        goto L102
    L97:
        r81 = r80.hashCode();
        goto L98
    L93:
        r78 = r77.hashCode();
        goto L94
    L89:
        r75 = r74.hashCode();
        goto L90
    L85:
        r72 = r71.hashCode();
        goto L86
    L81:
        r69 = r68.hashCode();
        goto L82
    L77:
        r66 = r65.hashCode();
        goto L78
    L73:
        r63 = r62.hashCode();
        goto L74
    L69:
        r60 = r59.hashCode();
        goto L70
    L65:
        r57 = r56.hashCode();
        goto L66
    L61:
        r54 = r53.hashCode();
        goto L62
    L57:
        r51 = r50.hashCode();
        goto L58
    L53:
        r48 = r47.hashCode();
        goto L54
    L49:
        r45 = r44.hashCode();
        goto L50
    L45:
        r42 = r41.hashCode();
        goto L46
    L41:
        r39 = r38.hashCode();
        goto L42
    L37:
        r36 = r35.hashCode();
        goto L38
    L33:
        r33 = r32.hashCode();
        goto L34
    L29:
        r30 = r29.hashCode();
        goto L30
    L25:
        r27 = r26.hashCode();
        goto L26
    L21:
        r24 = r23.hashCode();
        goto L22
    L17:
        r21 = r20.hashCode();
        goto L18
    L13:
        r18 = r17.hashCode();
        goto L14
    L9:
        r15 = r14.hashCode();
        goto L10
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    public final boolean isFromSmt() {
        String r10 = this.source;
        if (r10 != null) goto L5;
        return true;
    L5:
        if (o.r(r10) == true) goto L11;
        q.b(this.source, "yyb");
        return false;
    L11:
        return true;
    }

    public final boolean isSystemApp() {
        String r10 = this.soft_type;
        if (r10 == null) goto L5;
        Integer r11 = n.g(r10);
    L7:
        if (q.b(this.source, "system") == true) goto L14;
        if (r11 != null) goto L11;
    L13:
        return false;
    L11:
        if (r11.intValue() != 3) goto L13;
    L14:
        return true;
    L5:
        r11 = null;
        goto L7
    }

    public final void setCid(@Nullable String r10) {
        this.cid = r10;
    }

    public final void setComment(@Nullable Object r10) {
        this.comment = r10;
    }

    public final void setComments(@Nullable String r10) {
        this.comments = r10;
    }

    public final void setGifts(@Nullable List<AppDetailGiftEntity> r10) {
        this.gifts = r10;
    }

    public final void setIfcollect(int r10) {
        this.ifcollect = r10;
    }

    public final void setItem(@Nullable AppInfoItem r10) {
        this.item = r10;
    }

    public final void setResId(@Nullable Integer r10) {
        this.resId = r10;
    }

    public final void setScores(@Nullable String r10) {
        this.scores = r10;
    }

    public final void setScores_detail(@Nullable List<TvAppInfoScoresDetailEntity> r10) {
        this.scores_detail = r10;
    }

    public final void setSubCid(@Nullable String r10) {
        this.subCid = r10;
    }

    public final void setVersion(@NotNull String r10) {
        q.g(r10, "<set-?>");
        this.version = r10;
    }

    public final void setVersion_code(@NotNull String r10) {
        q.g(r10, "<set-?>");
        this.version_code = r10;
    }

    @NotNull
    public String toString() {
        return "AppInfoEntity(id=" + this.f8427id + ", pkg_id=" + this.pkg_id + ", dever_id=" + this.dever_id + ", name=" + this.name + ", cname=" + this.cname + ", version=" + this.version + ", version_code=" + this.version_code + ", pkg=" + this.pkg + ", filesize=" + this.filesize + ", logo=" + this.logo + ", banner=" + this.banner + ", draw_logo=" + this.draw_logo + ", apk_file=" + this.apk_file + ", status=" + this.status + ", create_time=" + this.create_time + ", update_time=" + this.update_time + ", last_update_time=" + this.last_update_time + ", developer=" + this.developer + ", pay_type=" + this.pay_type + ", soft_type=" + this.soft_type + ", grade_desc=" + this.grade_desc + ", py_name=" + this.py_name + ", py_cname=" + this.py_cname + ", brief=" + this.brief + ", recmd_brief=" + this.recmd_brief + ", video=" + this.video + ", draw=" + this.draw + ", first_pub=" + this.first_pub + ", spread=" + this.spread + ", label=" + this.label + ", game_type=" + this.game_type + ", operation_status=" + this.operation_status + ", category=" + this.category + ", gift_num=" + this.gift_num + ", cid=" + this.cid + ", subCid=" + this.subCid + ", category_info=" + this.category_info + ", printscreen=" + this.printscreen + ", from=" + this.from + ", download_url=" + this.download_url + ", share_download_url=" + this.share_download_url + ", scalable=" + this.scalable + ", scores=" + this.scores + ", scores_detail=" + this.scores_detail + ", permission=" + this.permission + ", comments=" + this.comments + ", ifgms=" + this.ifgms + ", ifcollect=" + this.ifcollect + ", ifdownload=" + this.ifdownload + ", size=" + this.size + ", new_features=" + this.new_features + ", filemd5=" + this.filemd5 + ", signature=" + this.signature + ", raw_signature=" + this.raw_signature + ", ifgift=" + this.ifgift + ", comment=" + this.comment + ", source=" + this.source + ", gifts=" + this.gifts + ", resId=" + this.resId + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        q.g(r10, "out");
        r10.writeString(this.f8427id);
        r10.writeString(this.pkg_id);
        r10.writeString(this.dever_id);
        r10.writeString(this.name);
        r10.writeString(this.cname);
        r10.writeString(this.version);
        r10.writeString(this.version_code);
        r10.writeString(this.pkg);
        r10.writeString(this.filesize);
        r10.writeString(this.logo);
        r10.writeString(this.banner);
        r10.writeString(this.draw_logo);
        r10.writeString(this.apk_file);
        r10.writeString(this.status);
        r10.writeString(this.create_time);
        r10.writeString(this.update_time);
        r10.writeString(this.last_update_time);
        r10.writeString(this.developer);
        r10.writeString(this.pay_type);
        r10.writeString(this.soft_type);
        r10.writeString(this.grade_desc);
        r10.writeString(this.py_name);
        r10.writeString(this.py_cname);
        r10.writeString(this.brief);
        r10.writeString(this.recmd_brief);
        TvAppInfoVideoEntity r12 = this.video;
        if (r12 != null) goto L5;
        r10.writeInt(0);
    L6:
        r10.writeString(this.draw);
        r10.writeString(this.first_pub);
        r10.writeString(this.spread);
        List<Integer> r13 = this.label;
        if (r13 != null) goto L9;
        r10.writeInt(0);
    L13:
        r10.writeString(this.game_type);
        r10.writeString(this.operation_status);
        r10.writeString(this.category);
        r10.writeString(this.gift_num);
        r10.writeString(this.cid);
        r10.writeString(this.subCid);
        List<TvAppInfoCategoryInfoEntity> r14 = this.category_info;
        if (r14 != null) goto L16;
        r10.writeInt(0);
    L20:
        r10.writeStringList(this.printscreen);
        TvAppInfoFromEntity r15 = this.from;
        if (r15 != null) goto L23;
        r10.writeInt(0);
    L24:
        r10.writeString(this.download_url);
        r10.writeString(this.share_download_url);
        r10.writeString(this.scalable);
        r10.writeString(this.scores);
        List<TvAppInfoScoresDetailEntity> r16 = this.scores_detail;
        if (r16 != null) goto L27;
        r10.writeInt(0);
    L31:
        r10.writeStringList(this.permission);
        r10.writeString(this.comments);
        r10.writeString(this.ifgms);
        r10.writeInt(this.ifcollect);
        r10.writeInt(this.ifdownload);
        r10.writeString(this.size);
        r10.writeString(this.new_features);
        r10.writeString(this.filemd5);
        r10.writeString(this.signature);
        r10.writeString(this.raw_signature);
        r10.writeInt(this.ifgift);
        r10.writeValue(this.comment);
        r10.writeString(this.source);
        List<AppDetailGiftEntity> r17 = this.gifts;
        if (r17 != null) goto L34;
        r10.writeInt(0);
    L38:
        Integer r18 = this.resId;
        if (r18 != null) goto L41;
        r10.writeInt(0);
        return;
    L41:
        r10.writeInt(1);
        r10.writeInt(r18.intValue());
        return;
    L34:
        r10.writeInt(1);
        r10.writeInt(r17.size());
        Iterator<AppDetailGiftEntity> r19 = r17.iterator();
    L36:
        if (r19.hasNext() == false) goto L38;
        r19.next().writeToParcel(r10, r11);
        goto L36
    L27:
        r10.writeInt(1);
        r10.writeInt(r16.size());
        Iterator<TvAppInfoScoresDetailEntity> r20 = r16.iterator();
    L29:
        if (r20.hasNext() == false) goto L31;
        r20.next().writeToParcel(r10, r11);
        goto L29
    L23:
        r10.writeInt(1);
        r15.writeToParcel(r10, r11);
        goto L24
    L16:
        r10.writeInt(1);
        r10.writeInt(r14.size());
        Iterator<TvAppInfoCategoryInfoEntity> r21 = r14.iterator();
    L18:
        if (r21.hasNext() == false) goto L20;
        r21.next().writeToParcel(r10, r11);
        goto L18
    L9:
        r10.writeInt(1);
        r10.writeInt(r13.size());
        Iterator<Integer> r22 = r13.iterator();
    L11:
        if (r22.hasNext() == false) goto L13;
        r10.writeInt(r22.next().intValue());
        goto L11
    L5:
        r10.writeInt(1);
        r12.writeToParcel(r10, r11);
        goto L6
    }

    public /* synthetic */ AppInfoEntity(String r62, String r63, String r64, String r65, String r66, String r67, String r68, String r69, String r70, String r71, String r72, String r73, String r74, String r75, String r76, String r77, String r78, String r79, String r80, String r81, String r82, String r83, String r84, String r85, String r86, TvAppInfoVideoEntity r87, String r88, String r89, String r90, List r91, String r92, String r93, String r94, String r95, String r96, String r97, List r98, List r99, TvAppInfoFromEntity r100, String r101, String r102, String r103, String r104, List r105, List r106, String r107, String r108, int r109, int r110, String r111, String r112, String r113, String r114, String r115, int r116, Object r117, String r118, List r119, Integer r120, int r121, int r122, DefaultConstructorMarker r123) {
        if ((r122 & 16777216) == 0) goto L5;
        String r58 = "local";
    L7:
        if ((r122 & 33554432) == 0) goto L9;
        List r59 = null;
    L10:
        this(r62, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73, r74, r75, r76, r77, r78, r79, r80, r81, r82, r83, r84, r85, r86, r87, r88, r89, r90, r91, r92, r93, r94, r95, r96, r97, r98, r99, r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r58, r59, r120);
        return;
    L9:
        r59 = r119;
        goto L10
    L5:
        r58 = r118;
        goto L7
    }
}
