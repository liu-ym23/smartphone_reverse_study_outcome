package com.stepos.ailauncher.foundation.appui.card.provider.didi;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiLiveClickReceiver;
import io.requery.android.database.sqlite.SQLiteDatabase;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\bV\b\u0080\b\u0018\u00002\u00020\u0001B³\u0005\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010,\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010D\u001a\n\u0012\u0004\u0012\u00020C\u0018\u00010\u0017\u0012\n\b\u0002\u0010F\u001a\u0004\u0018\u00010E\u0012\n\b\u0002\u0010H\u001a\u0004\u0018\u00010G\u0012\n\b\u0002\u0010I\u001a\u0004\u0018\u00010G¢\u0006\u0004\bJ\u0010KJ¼\u0005\u0010L\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00172\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010,2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010D\u001a\n\u0012\u0004\u0012\u00020C\u0018\u00010\u00172\n\b\u0002\u0010F\u001a\u0004\u0018\u00010E2\n\b\u0002\u0010H\u001a\u0004\u0018\u00010G2\n\b\u0002\u0010I\u001a\u0004\u0018\u00010GHÆ\u0001¢\u0006\u0004\bL\u0010MJ\u0010\u0010N\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\bN\u0010OJ\u0010\u0010P\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\bP\u0010QJ\u001a\u0010T\u001a\u00020S2\b\u0010R\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\bT\u0010UR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010V\u001a\u0004\bW\u0010OR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010V\u001a\u0004\bX\u0010OR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010V\u001a\u0004\bY\u0010OR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010Z\u001a\u0004\b[\u0010\\R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010V\u001a\u0004\b]\u0010OR\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010V\u001a\u0004\b^\u0010OR\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010V\u001a\u0004\b_\u0010OR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010V\u001a\u0004\b`\u0010OR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010a\u001a\u0004\bb\u0010cR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010a\u001a\u0004\bd\u0010cR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010e\u001a\u0004\bf\u0010gR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010h\u001a\u0004\bi\u0010jR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010k\u001a\u0004\bl\u0010mR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010n\u001a\u0004\bo\u0010pR\"\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010q\u001a\u0004\br\u0010sR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010V\u001a\u0004\bt\u0010OR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010V\u001a\u0004\bu\u0010OR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010V\u001a\u0004\bv\u0010OR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010V\u001a\u0004\bw\u0010OR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010V\u001a\u0004\bx\u0010OR\u001c\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010y\u001a\u0004\bz\u0010{R\u001c\u0010!\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010V\u001a\u0004\b|\u0010OR\u001c\u0010\"\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010V\u001a\u0004\b}\u0010OR\u001c\u0010#\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010V\u001a\u0004\b~\u0010OR\u001c\u0010$\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010V\u001a\u0004\b\u007f\u0010OR\u001d\u0010%\u001a\u0004\u0018\u00010\u001f8\u0006X\u0087\u0004¢\u0006\r\n\u0004\b%\u0010y\u001a\u0005\b\u0080\u0001\u0010{R\u001d\u0010&\u001a\u0004\u0018\u00010\u001f8\u0006X\u0087\u0004¢\u0006\r\n\u0004\b&\u0010y\u001a\u0005\b\u0081\u0001\u0010{R\u001d\u0010'\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\r\n\u0004\b'\u0010V\u001a\u0005\b\u0082\u0001\u0010OR\u001f\u0010)\u001a\u0004\u0018\u00010(8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\b)\u0010\u0083\u0001\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001R\u001f\u0010+\u001a\u0004\u0018\u00010*8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\b+\u0010\u0086\u0001\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001R\u001f\u0010-\u001a\u0004\u0018\u00010,8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\b-\u0010\u0089\u0001\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001R\u001d\u0010.\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\r\n\u0004\b.\u0010V\u001a\u0005\b\u008c\u0001\u0010OR\u001d\u0010/\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\r\n\u0004\b/\u0010V\u001a\u0005\b\u008d\u0001\u0010OR\u001d\u00100\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\r\n\u0004\b0\u0010V\u001a\u0005\b\u008e\u0001\u0010OR\u001d\u00101\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\r\n\u0004\b1\u0010V\u001a\u0005\b\u008f\u0001\u0010OR\u001d\u00102\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\r\n\u0004\b2\u0010V\u001a\u0005\b\u0090\u0001\u0010OR\u001d\u00103\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\r\n\u0004\b3\u0010V\u001a\u0005\b\u0091\u0001\u0010OR\u001d\u00104\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\r\n\u0004\b4\u0010V\u001a\u0005\b\u0092\u0001\u0010OR\u001d\u00105\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\r\n\u0004\b5\u0010V\u001a\u0005\b\u0093\u0001\u0010OR\u001d\u00106\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\r\n\u0004\b6\u0010V\u001a\u0005\b\u0094\u0001\u0010OR\u001d\u00107\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\r\n\u0004\b7\u0010V\u001a\u0005\b\u0095\u0001\u0010OR\u001d\u00108\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\r\n\u0004\b8\u0010V\u001a\u0005\b\u0096\u0001\u0010OR\u001d\u00109\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\r\n\u0004\b9\u0010V\u001a\u0005\b\u0097\u0001\u0010OR\u001d\u0010:\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\r\n\u0004\b:\u0010V\u001a\u0005\b\u0098\u0001\u0010OR\u001d\u0010;\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\r\n\u0004\b;\u0010V\u001a\u0005\b\u0099\u0001\u0010OR\u001d\u0010<\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\r\n\u0004\b<\u0010V\u001a\u0005\b\u009a\u0001\u0010OR\u001d\u0010=\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\r\n\u0004\b=\u0010V\u001a\u0005\b\u009b\u0001\u0010OR\u001d\u0010>\u001a\u0004\u0018\u00010\u001f8\u0006X\u0087\u0004¢\u0006\r\n\u0004\b>\u0010y\u001a\u0005\b\u009c\u0001\u0010{R\u001d\u0010?\u001a\u0004\u0018\u00010\u001f8\u0006X\u0087\u0004¢\u0006\r\n\u0004\b?\u0010y\u001a\u0005\b\u009d\u0001\u0010{R\u001d\u0010@\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\r\n\u0004\b@\u0010V\u001a\u0005\b\u009e\u0001\u0010OR\u001d\u0010A\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\r\n\u0004\bA\u0010V\u001a\u0005\b\u009f\u0001\u0010OR\u001d\u0010B\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\r\n\u0004\bB\u0010V\u001a\u0005\b \u0001\u0010OR#\u0010D\u001a\n\u0012\u0004\u0012\u00020C\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\r\n\u0004\bD\u0010q\u001a\u0005\b¡\u0001\u0010sR\u001f\u0010F\u001a\u0004\u0018\u00010E8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bF\u0010¢\u0001\u001a\u0006\b£\u0001\u0010¤\u0001R\u001f\u0010H\u001a\u0004\u0018\u00010G8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bH\u0010¥\u0001\u001a\u0006\b¦\u0001\u0010§\u0001R\u001f\u0010I\u001a\u0004\u0018\u00010G8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bI\u0010¥\u0001\u001a\u0006\b¨\u0001\u0010§\u0001¨\u0006©\u0001"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/w;", "", "", "title", "subTitle", "iconUrl", "", "statusCode", "statusText", "orderId", "orderNo", "phoneNumberSuffix", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/L;", "from", "to", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/N;", C3081a.FOCUS_MAP_NAME, "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/I;", "driver", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/b0;", "trip", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/Q;", "payment", "", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/P;", DidiCardProvider.KEY_ITEMS, AlipayXuiLiveClickReceiver.EXTRA_APP_LINK, "deepLink", "browserLink", "carModel", "carPlate", "", "distanceKm", "eta", "pickUp", "dropoff", "account", "prepayAmount", "actualPay", "productName", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/S;", "primaryInfo", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/O;", "media", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/Z;", "secondaryInfo", "fromAddress", "toAddress", "etaText", "noteText", "accountTail", "mapImageUrl", "plateNumber", "carImageUrl", "driverName", "driverAvatar", "driverRating", "driverText", "pickupPoint", "carTypeName", "distanceText", "durationText", "estimatedFee", "actualFee", "currency", "feeText", "disclaimer", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/x;", "carTypes", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/j;", "app", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/g;", "action", "secondaryAction", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/L;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/L;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/N;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/I;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/b0;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/Q;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/S;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/O;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/Z;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/j;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/g;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/g;)V", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/L;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/L;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/N;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/I;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/b0;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/Q;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/S;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/O;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/Z;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/j;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/g;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/g;)Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/w;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "Y", "X", "F", "Ljava/lang/Integer;", ExifInterface.LONGITUDE_WEST, "()Ljava/lang/Integer;", "getStatusText", "K", "L", "N", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/L;", "D", "()Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/L;", "Z", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/N;", "H", "()Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/N;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/I;", "u", "()Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/I;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/b0;", "b0", "()Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/b0;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/Q;", "M", "()Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/Q;", "Ljava/util/List;", "G", "()Ljava/util/List;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "q", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "l", "m", "Ljava/lang/Double;", "s", "()Ljava/lang/Double;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "O", "x", "c", "R", Const.INTENT_KEY_BACKGROUND_COMMAND, ExifInterface.GPS_DIRECTION_TRUE, "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/S;", ExifInterface.LATITUDE_SOUTH, "()Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/S;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/O;", "I", "()Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/O;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/Z;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "()Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/Z;", ExifInterface.LONGITUDE_EAST, "a0", "B", "J", Const.INTENT_KEY_UMID, "getMapImageUrl", "Q", "k", "v", "getDriverAvatar", "getDriverRating", "w", "P", "n", "t", "y", "z", "f", "p", "C", "r", "o", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/j;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/j;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/g;", "e", "()Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/g;", "U", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.didi.w, reason: case insensitive filesystem and from toString */
/* loaded from: classes3.dex */
public final /* data */ class DidiBusinessData {

    @SerializedName("account")
    private final String account;

    @SerializedName("accountTail")
    private final String accountTail;

    @SerializedName("action")
    private final DidiAction action;

    @SerializedName("actualFee")
    private final Double actualFee;

    @SerializedName("actualPay")
    private final Double actualPay;

    @SerializedName("app")
    private final DidiAppInfo app;

    @SerializedName(AlipayXuiLiveClickReceiver.EXTRA_APP_LINK)
    private final String appLink;

    @SerializedName("browserLink")
    private final String browserLink;

    @SerializedName("carImageUrl")
    private final String carImageUrl;

    @SerializedName("carModel")
    private final String carModel;

    @SerializedName("carPlate")
    private final String carPlate;

    @SerializedName("carTypeName")
    private final String carTypeName;

    @SerializedName("carTypes")
    private final List<DidiCarType> carTypes;

    @SerializedName("currency")
    private final String currency;

    @SerializedName("deepLink")
    private final String deepLink;

    @SerializedName("disclaimer")
    private final String disclaimer;

    @SerializedName("distanceKm")
    private final Double distanceKm;

    @SerializedName("distanceText")
    private final String distanceText;

    @SerializedName("driver")
    private final DidiDriverInfo driver;

    @SerializedName("driverAvatar")
    private final String driverAvatar;

    @SerializedName("driverName")
    private final String driverName;

    @SerializedName("driverRating")
    private final String driverRating;

    @SerializedName("driverText")
    private final String driverText;

    @SerializedName(alternate = {"dropOff"}, value = "dropoff")
    private final String dropoff;

    @SerializedName("durationText")
    private final String durationText;

    @SerializedName("estimatedFee")
    private final Double estimatedFee;

    @SerializedName("eta")
    private final String eta;

    @SerializedName("etaText")
    private final String etaText;

    @SerializedName("feeText")
    private final String feeText;

    @SerializedName("from")
    private final DidiLocation from;

    @SerializedName("fromAddress")
    private final String fromAddress;

    @SerializedName("iconUrl")
    private final String iconUrl;

    @SerializedName(DidiCardProvider.KEY_ITEMS)
    private final List<DidiOrderItem> items;

    @SerializedName(C3081a.FOCUS_MAP_NAME)
    private final DidiMapInfo map;

    @SerializedName("mapImageUrl")
    private final String mapImageUrl;

    @SerializedName("media")
    private final DidiMediaInfo media;

    @SerializedName("noteText")
    private final String noteText;

    @SerializedName("orderId")
    private final String orderId;

    @SerializedName("orderNo")
    private final String orderNo;

    @SerializedName("payment")
    private final DidiPaymentInfo payment;

    @SerializedName("phoneNumberSuffix")
    private final String phoneNumberSuffix;

    @SerializedName(alternate = {"pickup"}, value = "pickUp")
    private final String pickUp;

    @SerializedName("pickupPoint")
    private final String pickupPoint;

    @SerializedName("plateNumber")
    private final String plateNumber;

    @SerializedName("prepayAmount")
    private final Double prepayAmount;

    @SerializedName("primaryInfo")
    private final DidiPrimaryInfo primaryInfo;

    @SerializedName("productName")
    private final String productName;

    @SerializedName("secondaryAction")
    private final DidiAction secondaryAction;

    @SerializedName("secondaryInfo")
    private final DidiSecondaryInfo secondaryInfo;

    @SerializedName("statusCode")
    private final Integer statusCode;

    @SerializedName("statusText")
    private final String statusText;

    @SerializedName("subTitle")
    private final String subTitle;

    @SerializedName("title")
    private final String title;

    @SerializedName("to")
    private final DidiLocation to;

    @SerializedName("toAddress")
    private final String toAddress;

    @SerializedName("trip")
    private final DidiTripInfo trip;

    public DidiBusinessData() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 16777215, null);
    }

    /* renamed from: A, reason: from getter */
    public final String getEta() {
        return this.eta;
    }

    /* renamed from: B, reason: from getter */
    public final String getEtaText() {
        return this.etaText;
    }

    /* renamed from: C, reason: from getter */
    public final String getFeeText() {
        return this.feeText;
    }

    /* renamed from: D, reason: from getter */
    public final DidiLocation getFrom() {
        return this.from;
    }

    /* renamed from: E, reason: from getter */
    public final String getFromAddress() {
        return this.fromAddress;
    }

    /* renamed from: F, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final List<DidiOrderItem> G() {
        return this.items;
    }

    /* renamed from: H, reason: from getter */
    public final DidiMapInfo getMap() {
        return this.map;
    }

    /* renamed from: I, reason: from getter */
    public final DidiMediaInfo getMedia() {
        return this.media;
    }

    /* renamed from: J, reason: from getter */
    public final String getNoteText() {
        return this.noteText;
    }

    /* renamed from: K, reason: from getter */
    public final String getOrderId() {
        return this.orderId;
    }

    /* renamed from: L, reason: from getter */
    public final String getOrderNo() {
        return this.orderNo;
    }

    /* renamed from: M, reason: from getter */
    public final DidiPaymentInfo getPayment() {
        return this.payment;
    }

    /* renamed from: N, reason: from getter */
    public final String getPhoneNumberSuffix() {
        return this.phoneNumberSuffix;
    }

    /* renamed from: O, reason: from getter */
    public final String getPickUp() {
        return this.pickUp;
    }

    /* renamed from: P, reason: from getter */
    public final String getPickupPoint() {
        return this.pickupPoint;
    }

    /* renamed from: Q, reason: from getter */
    public final String getPlateNumber() {
        return this.plateNumber;
    }

    /* renamed from: R, reason: from getter */
    public final Double getPrepayAmount() {
        return this.prepayAmount;
    }

    /* renamed from: S, reason: from getter */
    public final DidiPrimaryInfo getPrimaryInfo() {
        return this.primaryInfo;
    }

    /* renamed from: T, reason: from getter */
    public final String getProductName() {
        return this.productName;
    }

    /* renamed from: U, reason: from getter */
    public final DidiAction getSecondaryAction() {
        return this.secondaryAction;
    }

    /* renamed from: V, reason: from getter */
    public final DidiSecondaryInfo getSecondaryInfo() {
        return this.secondaryInfo;
    }

    /* renamed from: W, reason: from getter */
    public final Integer getStatusCode() {
        return this.statusCode;
    }

    /* renamed from: X, reason: from getter */
    public final String getSubTitle() {
        return this.subTitle;
    }

    /* renamed from: Y, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: Z, reason: from getter */
    public final DidiLocation getTo() {
        return this.to;
    }

    public final DidiBusinessData a(String title, String subTitle, String iconUrl, Integer statusCode, String statusText, String orderId, String orderNo, String phoneNumberSuffix, DidiLocation from, DidiLocation to, DidiMapInfo map, DidiDriverInfo driver, DidiTripInfo trip, DidiPaymentInfo payment, List<DidiOrderItem> items, String appLink, String deepLink, String browserLink, String carModel, String carPlate, Double distanceKm, String eta, String pickUp, String dropoff, String account, Double prepayAmount, Double actualPay, String productName, DidiPrimaryInfo primaryInfo, DidiMediaInfo media, DidiSecondaryInfo secondaryInfo, String fromAddress, String toAddress, String etaText, String noteText, String accountTail, String mapImageUrl, String plateNumber, String carImageUrl, String driverName, String driverAvatar, String driverRating, String driverText, String pickupPoint, String carTypeName, String distanceText, String durationText, Double estimatedFee, Double actualFee, String currency, String feeText, String disclaimer, List<DidiCarType> carTypes, DidiAppInfo app, DidiAction action, DidiAction secondaryAction) {
        return new DidiBusinessData(title, subTitle, iconUrl, statusCode, statusText, orderId, orderNo, phoneNumberSuffix, from, to, map, driver, trip, payment, items, appLink, deepLink, browserLink, carModel, carPlate, distanceKm, eta, pickUp, dropoff, account, prepayAmount, actualPay, productName, primaryInfo, media, secondaryInfo, fromAddress, toAddress, etaText, noteText, accountTail, mapImageUrl, plateNumber, carImageUrl, driverName, driverAvatar, driverRating, driverText, pickupPoint, carTypeName, distanceText, durationText, estimatedFee, actualFee, currency, feeText, disclaimer, carTypes, app, action, secondaryAction);
    }

    /* renamed from: a0, reason: from getter */
    public final String getToAddress() {
        return this.toAddress;
    }

    /* renamed from: b0, reason: from getter */
    public final DidiTripInfo getTrip() {
        return this.trip;
    }

    /* renamed from: c, reason: from getter */
    public final String getAccount() {
        return this.account;
    }

    /* renamed from: d, reason: from getter */
    public final String getAccountTail() {
        return this.accountTail;
    }

    /* renamed from: e, reason: from getter */
    public final DidiAction getAction() {
        return this.action;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DidiBusinessData)) {
            return false;
        }
        DidiBusinessData didiBusinessData = (DidiBusinessData) other;
        return kotlin.jvm.internal.p.d(this.title, didiBusinessData.title) && kotlin.jvm.internal.p.d(this.subTitle, didiBusinessData.subTitle) && kotlin.jvm.internal.p.d(this.iconUrl, didiBusinessData.iconUrl) && kotlin.jvm.internal.p.d(this.statusCode, didiBusinessData.statusCode) && kotlin.jvm.internal.p.d(this.statusText, didiBusinessData.statusText) && kotlin.jvm.internal.p.d(this.orderId, didiBusinessData.orderId) && kotlin.jvm.internal.p.d(this.orderNo, didiBusinessData.orderNo) && kotlin.jvm.internal.p.d(this.phoneNumberSuffix, didiBusinessData.phoneNumberSuffix) && kotlin.jvm.internal.p.d(this.from, didiBusinessData.from) && kotlin.jvm.internal.p.d(this.to, didiBusinessData.to) && kotlin.jvm.internal.p.d(this.map, didiBusinessData.map) && kotlin.jvm.internal.p.d(this.driver, didiBusinessData.driver) && kotlin.jvm.internal.p.d(this.trip, didiBusinessData.trip) && kotlin.jvm.internal.p.d(this.payment, didiBusinessData.payment) && kotlin.jvm.internal.p.d(this.items, didiBusinessData.items) && kotlin.jvm.internal.p.d(this.appLink, didiBusinessData.appLink) && kotlin.jvm.internal.p.d(this.deepLink, didiBusinessData.deepLink) && kotlin.jvm.internal.p.d(this.browserLink, didiBusinessData.browserLink) && kotlin.jvm.internal.p.d(this.carModel, didiBusinessData.carModel) && kotlin.jvm.internal.p.d(this.carPlate, didiBusinessData.carPlate) && kotlin.jvm.internal.p.d(this.distanceKm, didiBusinessData.distanceKm) && kotlin.jvm.internal.p.d(this.eta, didiBusinessData.eta) && kotlin.jvm.internal.p.d(this.pickUp, didiBusinessData.pickUp) && kotlin.jvm.internal.p.d(this.dropoff, didiBusinessData.dropoff) && kotlin.jvm.internal.p.d(this.account, didiBusinessData.account) && kotlin.jvm.internal.p.d(this.prepayAmount, didiBusinessData.prepayAmount) && kotlin.jvm.internal.p.d(this.actualPay, didiBusinessData.actualPay) && kotlin.jvm.internal.p.d(this.productName, didiBusinessData.productName) && kotlin.jvm.internal.p.d(this.primaryInfo, didiBusinessData.primaryInfo) && kotlin.jvm.internal.p.d(this.media, didiBusinessData.media) && kotlin.jvm.internal.p.d(this.secondaryInfo, didiBusinessData.secondaryInfo) && kotlin.jvm.internal.p.d(this.fromAddress, didiBusinessData.fromAddress) && kotlin.jvm.internal.p.d(this.toAddress, didiBusinessData.toAddress) && kotlin.jvm.internal.p.d(this.etaText, didiBusinessData.etaText) && kotlin.jvm.internal.p.d(this.noteText, didiBusinessData.noteText) && kotlin.jvm.internal.p.d(this.accountTail, didiBusinessData.accountTail) && kotlin.jvm.internal.p.d(this.mapImageUrl, didiBusinessData.mapImageUrl) && kotlin.jvm.internal.p.d(this.plateNumber, didiBusinessData.plateNumber) && kotlin.jvm.internal.p.d(this.carImageUrl, didiBusinessData.carImageUrl) && kotlin.jvm.internal.p.d(this.driverName, didiBusinessData.driverName) && kotlin.jvm.internal.p.d(this.driverAvatar, didiBusinessData.driverAvatar) && kotlin.jvm.internal.p.d(this.driverRating, didiBusinessData.driverRating) && kotlin.jvm.internal.p.d(this.driverText, didiBusinessData.driverText) && kotlin.jvm.internal.p.d(this.pickupPoint, didiBusinessData.pickupPoint) && kotlin.jvm.internal.p.d(this.carTypeName, didiBusinessData.carTypeName) && kotlin.jvm.internal.p.d(this.distanceText, didiBusinessData.distanceText) && kotlin.jvm.internal.p.d(this.durationText, didiBusinessData.durationText) && kotlin.jvm.internal.p.d(this.estimatedFee, didiBusinessData.estimatedFee) && kotlin.jvm.internal.p.d(this.actualFee, didiBusinessData.actualFee) && kotlin.jvm.internal.p.d(this.currency, didiBusinessData.currency) && kotlin.jvm.internal.p.d(this.feeText, didiBusinessData.feeText) && kotlin.jvm.internal.p.d(this.disclaimer, didiBusinessData.disclaimer) && kotlin.jvm.internal.p.d(this.carTypes, didiBusinessData.carTypes) && kotlin.jvm.internal.p.d(this.app, didiBusinessData.app) && kotlin.jvm.internal.p.d(this.action, didiBusinessData.action) && kotlin.jvm.internal.p.d(this.secondaryAction, didiBusinessData.secondaryAction);
    }

    /* renamed from: f, reason: from getter */
    public final Double getActualFee() {
        return this.actualFee;
    }

    /* renamed from: g, reason: from getter */
    public final Double getActualPay() {
        return this.actualPay;
    }

    /* renamed from: h, reason: from getter */
    public final DidiAppInfo getApp() {
        return this.app;
    }

    public int hashCode() {
        String str = this.title;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.subTitle;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.iconUrl;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.statusCode;
        int iHashCode4 = (iHashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        String str4 = this.statusText;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.orderId;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.orderNo;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.phoneNumberSuffix;
        int iHashCode8 = (iHashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        DidiLocation didiLocation = this.from;
        int iHashCode9 = (iHashCode8 + (didiLocation == null ? 0 : didiLocation.hashCode())) * 31;
        DidiLocation didiLocation2 = this.to;
        int iHashCode10 = (iHashCode9 + (didiLocation2 == null ? 0 : didiLocation2.hashCode())) * 31;
        DidiMapInfo didiMapInfo = this.map;
        int iHashCode11 = (iHashCode10 + (didiMapInfo == null ? 0 : didiMapInfo.hashCode())) * 31;
        DidiDriverInfo didiDriverInfo = this.driver;
        int iHashCode12 = (iHashCode11 + (didiDriverInfo == null ? 0 : didiDriverInfo.hashCode())) * 31;
        DidiTripInfo didiTripInfo = this.trip;
        int iHashCode13 = (iHashCode12 + (didiTripInfo == null ? 0 : didiTripInfo.hashCode())) * 31;
        DidiPaymentInfo didiPaymentInfo = this.payment;
        int iHashCode14 = (iHashCode13 + (didiPaymentInfo == null ? 0 : didiPaymentInfo.hashCode())) * 31;
        List<DidiOrderItem> list = this.items;
        int iHashCode15 = (iHashCode14 + (list == null ? 0 : list.hashCode())) * 31;
        String str8 = this.appLink;
        int iHashCode16 = (iHashCode15 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.deepLink;
        int iHashCode17 = (iHashCode16 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.browserLink;
        int iHashCode18 = (iHashCode17 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.carModel;
        int iHashCode19 = (iHashCode18 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.carPlate;
        int iHashCode20 = (iHashCode19 + (str12 == null ? 0 : str12.hashCode())) * 31;
        Double d10 = this.distanceKm;
        int iHashCode21 = (iHashCode20 + (d10 == null ? 0 : d10.hashCode())) * 31;
        String str13 = this.eta;
        int iHashCode22 = (iHashCode21 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.pickUp;
        int iHashCode23 = (iHashCode22 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.dropoff;
        int iHashCode24 = (iHashCode23 + (str15 == null ? 0 : str15.hashCode())) * 31;
        String str16 = this.account;
        int iHashCode25 = (iHashCode24 + (str16 == null ? 0 : str16.hashCode())) * 31;
        Double d11 = this.prepayAmount;
        int iHashCode26 = (iHashCode25 + (d11 == null ? 0 : d11.hashCode())) * 31;
        Double d12 = this.actualPay;
        int iHashCode27 = (iHashCode26 + (d12 == null ? 0 : d12.hashCode())) * 31;
        String str17 = this.productName;
        int iHashCode28 = (iHashCode27 + (str17 == null ? 0 : str17.hashCode())) * 31;
        DidiPrimaryInfo didiPrimaryInfo = this.primaryInfo;
        int iHashCode29 = (iHashCode28 + (didiPrimaryInfo == null ? 0 : didiPrimaryInfo.hashCode())) * 31;
        DidiMediaInfo didiMediaInfo = this.media;
        int iHashCode30 = (iHashCode29 + (didiMediaInfo == null ? 0 : didiMediaInfo.hashCode())) * 31;
        DidiSecondaryInfo didiSecondaryInfo = this.secondaryInfo;
        int iHashCode31 = (iHashCode30 + (didiSecondaryInfo == null ? 0 : didiSecondaryInfo.hashCode())) * 31;
        String str18 = this.fromAddress;
        int iHashCode32 = (iHashCode31 + (str18 == null ? 0 : str18.hashCode())) * 31;
        String str19 = this.toAddress;
        int iHashCode33 = (iHashCode32 + (str19 == null ? 0 : str19.hashCode())) * 31;
        String str20 = this.etaText;
        int iHashCode34 = (iHashCode33 + (str20 == null ? 0 : str20.hashCode())) * 31;
        String str21 = this.noteText;
        int iHashCode35 = (iHashCode34 + (str21 == null ? 0 : str21.hashCode())) * 31;
        String str22 = this.accountTail;
        int iHashCode36 = (iHashCode35 + (str22 == null ? 0 : str22.hashCode())) * 31;
        String str23 = this.mapImageUrl;
        int iHashCode37 = (iHashCode36 + (str23 == null ? 0 : str23.hashCode())) * 31;
        String str24 = this.plateNumber;
        int iHashCode38 = (iHashCode37 + (str24 == null ? 0 : str24.hashCode())) * 31;
        String str25 = this.carImageUrl;
        int iHashCode39 = (iHashCode38 + (str25 == null ? 0 : str25.hashCode())) * 31;
        String str26 = this.driverName;
        int iHashCode40 = (iHashCode39 + (str26 == null ? 0 : str26.hashCode())) * 31;
        String str27 = this.driverAvatar;
        int iHashCode41 = (iHashCode40 + (str27 == null ? 0 : str27.hashCode())) * 31;
        String str28 = this.driverRating;
        int iHashCode42 = (iHashCode41 + (str28 == null ? 0 : str28.hashCode())) * 31;
        String str29 = this.driverText;
        int iHashCode43 = (iHashCode42 + (str29 == null ? 0 : str29.hashCode())) * 31;
        String str30 = this.pickupPoint;
        int iHashCode44 = (iHashCode43 + (str30 == null ? 0 : str30.hashCode())) * 31;
        String str31 = this.carTypeName;
        int iHashCode45 = (iHashCode44 + (str31 == null ? 0 : str31.hashCode())) * 31;
        String str32 = this.distanceText;
        int iHashCode46 = (iHashCode45 + (str32 == null ? 0 : str32.hashCode())) * 31;
        String str33 = this.durationText;
        int iHashCode47 = (iHashCode46 + (str33 == null ? 0 : str33.hashCode())) * 31;
        Double d13 = this.estimatedFee;
        int iHashCode48 = (iHashCode47 + (d13 == null ? 0 : d13.hashCode())) * 31;
        Double d14 = this.actualFee;
        int iHashCode49 = (iHashCode48 + (d14 == null ? 0 : d14.hashCode())) * 31;
        String str34 = this.currency;
        int iHashCode50 = (iHashCode49 + (str34 == null ? 0 : str34.hashCode())) * 31;
        String str35 = this.feeText;
        int iHashCode51 = (iHashCode50 + (str35 == null ? 0 : str35.hashCode())) * 31;
        String str36 = this.disclaimer;
        int iHashCode52 = (iHashCode51 + (str36 == null ? 0 : str36.hashCode())) * 31;
        List<DidiCarType> list2 = this.carTypes;
        int iHashCode53 = (iHashCode52 + (list2 == null ? 0 : list2.hashCode())) * 31;
        DidiAppInfo didiAppInfo = this.app;
        int iHashCode54 = (iHashCode53 + (didiAppInfo == null ? 0 : didiAppInfo.hashCode())) * 31;
        DidiAction didiAction = this.action;
        int iHashCode55 = (iHashCode54 + (didiAction == null ? 0 : didiAction.hashCode())) * 31;
        DidiAction didiAction2 = this.secondaryAction;
        return iHashCode55 + (didiAction2 != null ? didiAction2.hashCode() : 0);
    }

    /* renamed from: i, reason: from getter */
    public final String getAppLink() {
        return this.appLink;
    }

    /* renamed from: j, reason: from getter */
    public final String getBrowserLink() {
        return this.browserLink;
    }

    /* renamed from: k, reason: from getter */
    public final String getCarImageUrl() {
        return this.carImageUrl;
    }

    /* renamed from: l, reason: from getter */
    public final String getCarModel() {
        return this.carModel;
    }

    /* renamed from: m, reason: from getter */
    public final String getCarPlate() {
        return this.carPlate;
    }

    /* renamed from: n, reason: from getter */
    public final String getCarTypeName() {
        return this.carTypeName;
    }

    public final List<DidiCarType> o() {
        return this.carTypes;
    }

    /* renamed from: p, reason: from getter */
    public final String getCurrency() {
        return this.currency;
    }

    /* renamed from: q, reason: from getter */
    public final String getDeepLink() {
        return this.deepLink;
    }

    /* renamed from: r, reason: from getter */
    public final String getDisclaimer() {
        return this.disclaimer;
    }

    /* renamed from: s, reason: from getter */
    public final Double getDistanceKm() {
        return this.distanceKm;
    }

    /* renamed from: t, reason: from getter */
    public final String getDistanceText() {
        return this.distanceText;
    }

    public String toString() {
        return "DidiBusinessData(title=" + this.title + ", subTitle=" + this.subTitle + ", iconUrl=" + this.iconUrl + ", statusCode=" + this.statusCode + ", statusText=" + this.statusText + ", orderId=" + this.orderId + ", orderNo=" + this.orderNo + ", phoneNumberSuffix=" + this.phoneNumberSuffix + ", from=" + this.from + ", to=" + this.to + ", map=" + this.map + ", driver=" + this.driver + ", trip=" + this.trip + ", payment=" + this.payment + ", items=" + this.items + ", appLink=" + this.appLink + ", deepLink=" + this.deepLink + ", browserLink=" + this.browserLink + ", carModel=" + this.carModel + ", carPlate=" + this.carPlate + ", distanceKm=" + this.distanceKm + ", eta=" + this.eta + ", pickUp=" + this.pickUp + ", dropoff=" + this.dropoff + ", account=" + this.account + ", prepayAmount=" + this.prepayAmount + ", actualPay=" + this.actualPay + ", productName=" + this.productName + ", primaryInfo=" + this.primaryInfo + ", media=" + this.media + ", secondaryInfo=" + this.secondaryInfo + ", fromAddress=" + this.fromAddress + ", toAddress=" + this.toAddress + ", etaText=" + this.etaText + ", noteText=" + this.noteText + ", accountTail=" + this.accountTail + ", mapImageUrl=" + this.mapImageUrl + ", plateNumber=" + this.plateNumber + ", carImageUrl=" + this.carImageUrl + ", driverName=" + this.driverName + ", driverAvatar=" + this.driverAvatar + ", driverRating=" + this.driverRating + ", driverText=" + this.driverText + ", pickupPoint=" + this.pickupPoint + ", carTypeName=" + this.carTypeName + ", distanceText=" + this.distanceText + ", durationText=" + this.durationText + ", estimatedFee=" + this.estimatedFee + ", actualFee=" + this.actualFee + ", currency=" + this.currency + ", feeText=" + this.feeText + ", disclaimer=" + this.disclaimer + ", carTypes=" + this.carTypes + ", app=" + this.app + ", action=" + this.action + ", secondaryAction=" + this.secondaryAction + ")";
    }

    /* renamed from: u, reason: from getter */
    public final DidiDriverInfo getDriver() {
        return this.driver;
    }

    /* renamed from: v, reason: from getter */
    public final String getDriverName() {
        return this.driverName;
    }

    /* renamed from: w, reason: from getter */
    public final String getDriverText() {
        return this.driverText;
    }

    /* renamed from: x, reason: from getter */
    public final String getDropoff() {
        return this.dropoff;
    }

    /* renamed from: y, reason: from getter */
    public final String getDurationText() {
        return this.durationText;
    }

    /* renamed from: z, reason: from getter */
    public final Double getEstimatedFee() {
        return this.estimatedFee;
    }

    public DidiBusinessData(String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, DidiLocation didiLocation, DidiLocation didiLocation2, DidiMapInfo didiMapInfo, DidiDriverInfo didiDriverInfo, DidiTripInfo didiTripInfo, DidiPaymentInfo didiPaymentInfo, List<DidiOrderItem> list, String str8, String str9, String str10, String str11, String str12, Double d10, String str13, String str14, String str15, String str16, Double d11, Double d12, String str17, DidiPrimaryInfo didiPrimaryInfo, DidiMediaInfo didiMediaInfo, DidiSecondaryInfo didiSecondaryInfo, String str18, String str19, String str20, String str21, String str22, String str23, String str24, String str25, String str26, String str27, String str28, String str29, String str30, String str31, String str32, String str33, Double d13, Double d14, String str34, String str35, String str36, List<DidiCarType> list2, DidiAppInfo didiAppInfo, DidiAction didiAction, DidiAction didiAction2) {
        this.title = str;
        this.subTitle = str2;
        this.iconUrl = str3;
        this.statusCode = num;
        this.statusText = str4;
        this.orderId = str5;
        this.orderNo = str6;
        this.phoneNumberSuffix = str7;
        this.from = didiLocation;
        this.to = didiLocation2;
        this.map = didiMapInfo;
        this.driver = didiDriverInfo;
        this.trip = didiTripInfo;
        this.payment = didiPaymentInfo;
        this.items = list;
        this.appLink = str8;
        this.deepLink = str9;
        this.browserLink = str10;
        this.carModel = str11;
        this.carPlate = str12;
        this.distanceKm = d10;
        this.eta = str13;
        this.pickUp = str14;
        this.dropoff = str15;
        this.account = str16;
        this.prepayAmount = d11;
        this.actualPay = d12;
        this.productName = str17;
        this.primaryInfo = didiPrimaryInfo;
        this.media = didiMediaInfo;
        this.secondaryInfo = didiSecondaryInfo;
        this.fromAddress = str18;
        this.toAddress = str19;
        this.etaText = str20;
        this.noteText = str21;
        this.accountTail = str22;
        this.mapImageUrl = str23;
        this.plateNumber = str24;
        this.carImageUrl = str25;
        this.driverName = str26;
        this.driverAvatar = str27;
        this.driverRating = str28;
        this.driverText = str29;
        this.pickupPoint = str30;
        this.carTypeName = str31;
        this.distanceText = str32;
        this.durationText = str33;
        this.estimatedFee = d13;
        this.actualFee = d14;
        this.currency = str34;
        this.feeText = str35;
        this.disclaimer = str36;
        this.carTypes = list2;
        this.app = didiAppInfo;
        this.action = didiAction;
        this.secondaryAction = didiAction2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ DidiBusinessData(String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, DidiLocation didiLocation, DidiLocation didiLocation2, DidiMapInfo didiMapInfo, DidiDriverInfo didiDriverInfo, DidiTripInfo didiTripInfo, DidiPaymentInfo didiPaymentInfo, List list, String str8, String str9, String str10, String str11, String str12, Double d10, String str13, String str14, String str15, String str16, Double d11, Double d12, String str17, DidiPrimaryInfo didiPrimaryInfo, DidiMediaInfo didiMediaInfo, DidiSecondaryInfo didiSecondaryInfo, String str18, String str19, String str20, String str21, String str22, String str23, String str24, String str25, String str26, String str27, String str28, String str29, String str30, String str31, String str32, String str33, Double d13, Double d14, String str34, String str35, String str36, List list2, DidiAppInfo didiAppInfo, DidiAction didiAction, DidiAction didiAction2, int i10, int i11, kotlin.jvm.internal.i iVar) {
        String str37 = (i10 & 1) != 0 ? null : str;
        this(str37, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : num, (i10 & 16) != 0 ? null : str4, (i10 & 32) != 0 ? null : str5, (i10 & 64) != 0 ? null : str6, (i10 & 128) != 0 ? null : str7, (i10 & 256) != 0 ? null : didiLocation, (i10 & 512) != 0 ? null : didiLocation2, (i10 & 1024) != 0 ? null : didiMapInfo, (i10 & 2048) != 0 ? null : didiDriverInfo, (i10 & 4096) != 0 ? null : didiTripInfo, (i10 & com.stepos.agentframework.chatui.longtext.b.THRESHOLD) != 0 ? null : didiPaymentInfo, (i10 & 16384) != 0 ? null : list, (i10 & 32768) != 0 ? null : str8, (i10 & 65536) != 0 ? null : str9, (i10 & SQLiteDatabase.OPEN_SHAREDCACHE) != 0 ? null : str10, (i10 & SQLiteDatabase.OPEN_PRIVATECACHE) != 0 ? null : str11, (i10 & 524288) != 0 ? null : str12, (i10 & 1048576) != 0 ? null : d10, (i10 & 2097152) != 0 ? null : str13, (i10 & 4194304) != 0 ? null : str14, (i10 & 8388608) != 0 ? null : str15, (i10 & 16777216) != 0 ? null : str16, (i10 & Const.FLAG_MUTABLE) != 0 ? null : d11, (i10 & 67108864) != 0 ? null : d12, (i10 & 134217728) != 0 ? null : str17, (i10 & net.sqlcipher.database.SQLiteDatabase.CREATE_IF_NECESSARY) != 0 ? null : didiPrimaryInfo, (i10 & SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING) != 0 ? null : didiMediaInfo, (i10 & 1073741824) != 0 ? null : didiSecondaryInfo, (i10 & Integer.MIN_VALUE) != 0 ? null : str18, (i11 & 1) != 0 ? null : str19, (i11 & 2) != 0 ? null : str20, (i11 & 4) != 0 ? null : str21, (i11 & 8) != 0 ? null : str22, (i11 & 16) != 0 ? null : str23, (i11 & 32) != 0 ? null : str24, (i11 & 64) != 0 ? null : str25, (i11 & 128) != 0 ? null : str26, (i11 & 256) != 0 ? null : str27, (i11 & 512) != 0 ? null : str28, (i11 & 1024) != 0 ? null : str29, (i11 & 2048) != 0 ? null : str30, (i11 & 4096) != 0 ? null : str31, (i11 & com.stepos.agentframework.chatui.longtext.b.THRESHOLD) != 0 ? null : str32, (i11 & 16384) != 0 ? null : str33, (i11 & 32768) != 0 ? null : d13, (i11 & 65536) != 0 ? null : d14, (i11 & SQLiteDatabase.OPEN_SHAREDCACHE) != 0 ? null : str34, (i11 & SQLiteDatabase.OPEN_PRIVATECACHE) != 0 ? null : str35, (i11 & 524288) != 0 ? null : str36, (i11 & 1048576) != 0 ? null : list2, (i11 & 2097152) != 0 ? null : didiAppInfo, (i11 & 4194304) != 0 ? null : didiAction, (i11 & 8388608) != 0 ? null : didiAction2);
    }
}
