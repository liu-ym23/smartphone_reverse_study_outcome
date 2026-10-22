package com.stepos.widget.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.text.method.MovementMethod;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.widget.R;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000Î\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0018\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\bX\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001:\u0002¯\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0012\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010$\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010\u001f\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#R$\u0010'\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010\u0018\u001a\u0004\b(\u0010\u001a\"\u0004\b)\u0010\u001cR$\u0010+\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00101\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u0010\u001f\u001a\u0004\b2\u0010!\"\u0004\b3\u0010#R$\u00105\u001a\u0004\u0018\u0001048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R$\u0010;\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010,\u001a\u0004\b<\u0010.\"\u0004\b=\u00100R\"\u0010>\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u0010\u001f\u001a\u0004\b?\u0010!\"\u0004\b@\u0010#R$\u0010B\u001a\u0004\u0018\u00010A8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR$\u0010H\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010,\u001a\u0004\bI\u0010.\"\u0004\bJ\u00100R$\u0010L\u001a\u0004\u0018\u00010K8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR$\u0010R\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bR\u0010\u0018\u001a\u0004\bS\u0010\u001a\"\u0004\bT\u0010\u001cR$\u0010U\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bU\u0010,\u001a\u0004\bV\u0010.\"\u0004\bW\u00100R$\u0010X\u001a\u0004\u0018\u00010K8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bX\u0010M\u001a\u0004\bY\u0010O\"\u0004\bZ\u0010QR$\u0010[\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b[\u0010\u0018\u001a\u0004\b\\\u0010\u001a\"\u0004\b]\u0010\u001cR$\u0010^\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b^\u0010,\u001a\u0004\b_\u0010.\"\u0004\b`\u00100R$\u0010a\u001a\u0004\u0018\u00010K8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\ba\u0010M\u001a\u0004\bb\u0010O\"\u0004\bc\u0010QR$\u0010d\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bd\u0010\u0018\u001a\u0004\be\u0010\u001a\"\u0004\bf\u0010\u001cR\"\u0010g\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bg\u0010h\u001a\u0004\bi\u0010\b\"\u0004\bj\u0010kR$\u0010m\u001a\u0004\u0018\u00010l8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bm\u0010n\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR$\u0010t\u001a\u0004\u0018\u00010s8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bt\u0010u\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR%\u0010{\u001a\u0004\u0018\u00010z8\u0006@\u0006X\u0086\u000e¢\u0006\u0013\n\u0004\b{\u0010|\u001a\u0004\b}\u0010~\"\u0005\b\u007f\u0010\u0080\u0001R4\u0010\u0082\u0001\u001a\r\u0012\u0006\b\u0001\u0012\u00020*\u0018\u00010\u0081\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0082\u0001\u0010\u0083\u0001\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001\"\u0006\b\u0086\u0001\u0010\u0087\u0001R,\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u0088\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0089\u0001\u0010\u008a\u0001\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001\"\u0006\b\u008d\u0001\u0010\u008e\u0001R,\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u008f\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0090\u0001\u0010\u0091\u0001\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001\"\u0006\b\u0094\u0001\u0010\u0095\u0001R,\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u0096\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0097\u0001\u0010\u0098\u0001\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001\"\u0006\b\u009b\u0001\u0010\u009c\u0001R,\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u0096\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u009d\u0001\u0010\u0098\u0001\u001a\u0006\b\u009d\u0001\u0010\u009a\u0001\"\u0006\b\u009e\u0001\u0010\u009c\u0001R(\u0010\u009f\u0001\u001a\u0004\u0018\u00010K8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u009f\u0001\u0010M\u001a\u0005\b \u0001\u0010O\"\u0005\b¡\u0001\u0010QR,\u0010£\u0001\u001a\u0005\u0018\u00010¢\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b£\u0001\u0010¤\u0001\u001a\u0006\b¥\u0001\u0010¦\u0001\"\u0006\b§\u0001\u0010¨\u0001R,\u0010ª\u0001\u001a\u0005\u0018\u00010©\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bª\u0001\u0010«\u0001\u001a\u0006\b¬\u0001\u0010\u00ad\u0001\"\u0006\b®\u0001\u0010¯\u0001R&\u0010°\u0001\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b°\u0001\u0010h\u001a\u0005\b°\u0001\u0010\b\"\u0005\b±\u0001\u0010kR&\u0010²\u0001\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b²\u0001\u0010h\u001a\u0005\b²\u0001\u0010\b\"\u0005\b³\u0001\u0010kR&\u0010´\u0001\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b´\u0001\u0010\u001f\u001a\u0005\bµ\u0001\u0010!\"\u0005\b¶\u0001\u0010#R,\u0010¸\u0001\u001a\u0005\u0018\u00010·\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¸\u0001\u0010¹\u0001\u001a\u0006\bº\u0001\u0010»\u0001\"\u0006\b¼\u0001\u0010½\u0001R&\u0010¾\u0001\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b¾\u0001\u0010h\u001a\u0005\b¾\u0001\u0010\b\"\u0005\b¿\u0001\u0010kR,\u0010Á\u0001\u001a\u0005\u0018\u00010À\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÁ\u0001\u0010Â\u0001\u001a\u0006\bÃ\u0001\u0010Ä\u0001\"\u0006\bÅ\u0001\u0010Æ\u0001R3\u0010Ç\u0001\u001a\f\u0012\u0005\u0012\u00030À\u0001\u0018\u00010\u0081\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÇ\u0001\u0010È\u0001\u001a\u0006\bÉ\u0001\u0010Ê\u0001\"\u0006\bË\u0001\u0010Ì\u0001R]\u0010Ð\u0001\u001a6\u0012\u0013\u0012\u0011\u0012\u0005\u0012\u00030\u0096\u0001\u0012\u0005\u0012\u00030\u0096\u00010Î\u0001\u0018\u00010Í\u0001j\u001a\u0012\u0013\u0012\u0011\u0012\u0005\u0012\u00030\u0096\u0001\u0012\u0005\u0012\u00030\u0096\u00010Î\u0001\u0018\u0001`Ï\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÐ\u0001\u0010Ñ\u0001\u001a\u0006\bÒ\u0001\u0010Ó\u0001\"\u0006\bÔ\u0001\u0010Õ\u0001R&\u0010Ö\u0001\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bÖ\u0001\u0010h\u001a\u0005\bÖ\u0001\u0010\b\"\u0005\b×\u0001\u0010kR]\u0010Ø\u0001\u001a6\u0012\u0013\u0012\u0011\u0012\u0005\u0012\u00030\u0096\u0001\u0012\u0005\u0012\u00030\u0096\u00010Î\u0001\u0018\u00010Í\u0001j\u001a\u0012\u0013\u0012\u0011\u0012\u0005\u0012\u00030\u0096\u0001\u0012\u0005\u0012\u00030\u0096\u00010Î\u0001\u0018\u0001`Ï\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bØ\u0001\u0010Ñ\u0001\u001a\u0006\bÙ\u0001\u0010Ó\u0001\"\u0006\bÚ\u0001\u0010Õ\u0001R&\u0010Û\u0001\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bÛ\u0001\u0010h\u001a\u0005\bÜ\u0001\u0010\b\"\u0005\bÝ\u0001\u0010kR&\u0010Þ\u0001\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bÞ\u0001\u0010h\u001a\u0005\bß\u0001\u0010\b\"\u0005\bà\u0001\u0010kR(\u0010á\u0001\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bá\u0001\u0010\u0018\u001a\u0005\bâ\u0001\u0010\u001a\"\u0005\bã\u0001\u0010\u001cR&\u0010ä\u0001\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bä\u0001\u0010\u001f\u001a\u0005\bå\u0001\u0010!\"\u0005\bæ\u0001\u0010#R(\u0010ç\u0001\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bç\u0001\u0010,\u001a\u0005\bè\u0001\u0010.\"\u0005\bé\u0001\u00100R(\u0010ê\u0001\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bê\u0001\u0010\u0018\u001a\u0005\bë\u0001\u0010\u001a\"\u0005\bì\u0001\u0010\u001cR&\u0010í\u0001\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bí\u0001\u0010\u001f\u001a\u0005\bî\u0001\u0010!\"\u0005\bï\u0001\u0010#R(\u0010ð\u0001\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bð\u0001\u0010,\u001a\u0005\bñ\u0001\u0010.\"\u0005\bò\u0001\u00100R&\u0010ó\u0001\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bó\u0001\u0010\u001f\u001a\u0005\bô\u0001\u0010!\"\u0005\bõ\u0001\u0010#R(\u0010ö\u0001\u001a\u0004\u0018\u00010K8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bö\u0001\u0010M\u001a\u0005\b÷\u0001\u0010O\"\u0005\bø\u0001\u0010QR(\u0010ù\u0001\u001a\u0004\u0018\u0001048\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bù\u0001\u00106\u001a\u0005\bú\u0001\u00108\"\u0005\bû\u0001\u0010:R&\u0010ü\u0001\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bü\u0001\u0010\u001f\u001a\u0005\bý\u0001\u0010!\"\u0005\bþ\u0001\u0010#R&\u0010ÿ\u0001\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bÿ\u0001\u0010\u001f\u001a\u0005\b\u0080\u0002\u0010!\"\u0005\b\u0081\u0002\u0010#R&\u0010\u0082\u0002\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0082\u0002\u0010\u001f\u001a\u0005\b\u0083\u0002\u0010!\"\u0005\b\u0084\u0002\u0010#R&\u0010\u0085\u0002\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0085\u0002\u0010\u001f\u001a\u0005\b\u0086\u0002\u0010!\"\u0005\b\u0087\u0002\u0010#R&\u0010\u0088\u0002\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0088\u0002\u0010\u001f\u001a\u0005\b\u0089\u0002\u0010!\"\u0005\b\u008a\u0002\u0010#R&\u0010\u008b\u0002\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u008b\u0002\u0010h\u001a\u0005\b\u008c\u0002\u0010\b\"\u0005\b\u008d\u0002\u0010kR&\u0010\u008e\u0002\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u008e\u0002\u0010h\u001a\u0005\b\u008f\u0002\u0010\b\"\u0005\b\u0090\u0002\u0010kR&\u0010\u0091\u0002\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0091\u0002\u0010\u001f\u001a\u0005\b\u0092\u0002\u0010!\"\u0005\b\u0093\u0002\u0010#R&\u0010\u0094\u0002\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0094\u0002\u0010\u001f\u001a\u0005\b\u0095\u0002\u0010!\"\u0005\b\u0096\u0002\u0010#R&\u0010\u0097\u0002\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0097\u0002\u0010\u001f\u001a\u0005\b\u0098\u0002\u0010!\"\u0005\b\u0099\u0002\u0010#R&\u0010\u009a\u0002\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u009a\u0002\u0010\u001f\u001a\u0005\b\u009b\u0002\u0010!\"\u0005\b\u009c\u0002\u0010#R&\u0010\u009d\u0002\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u009d\u0002\u0010h\u001a\u0005\b\u009e\u0002\u0010\b\"\u0005\b\u009f\u0002\u0010kR&\u0010 \u0002\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b \u0002\u0010\u001f\u001a\u0005\b¡\u0002\u0010!\"\u0005\b¢\u0002\u0010#R&\u0010£\u0002\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b£\u0002\u0010h\u001a\u0005\b£\u0002\u0010\b\"\u0005\b¤\u0002\u0010kR&\u0010¥\u0002\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b¥\u0002\u0010h\u001a\u0005\b¦\u0002\u0010\b\"\u0005\b§\u0002\u0010kR,\u0010©\u0002\u001a\u0005\u0018\u00010¨\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b©\u0002\u0010ª\u0002\u001a\u0006\b«\u0002\u0010¬\u0002\"\u0006\b\u00ad\u0002\u0010®\u0002¨\u0006°\u0002"}, d2 = {"Lcom/stepos/widget/dialog/StepOSAlertParams;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "hasAnyButton", "()Z", "Lcom/stepos/widget/dialog/StepOSAlertController;", "controller", "LY8/t;", "apply", "(Lcom/stepos/widget/dialog/StepOSAlertController;)V", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/LayoutInflater;", "getInflater", "()Landroid/view/LayoutInflater;", "Landroid/graphics/drawable/Drawable;", "icon", "Landroid/graphics/drawable/Drawable;", "getIcon", "()Landroid/graphics/drawable/Drawable;", "setIcon", "(Landroid/graphics/drawable/Drawable;)V", "", "iconId", "I", "getIconId", "()I", "setIconId", "(I)V", "iconAttrId", "getIconAttrId", "setIconAttrId", "iconBadge", "getIconBadge", "setIconBadge", "", "title", "Ljava/lang/CharSequence;", "getTitle", "()Ljava/lang/CharSequence;", "setTitle", "(Ljava/lang/CharSequence;)V", "titleMaxLines", "getTitleMaxLines", "setTitleMaxLines", "Landroid/view/View;", "customTitleView", "Landroid/view/View;", "getCustomTitleView", "()Landroid/view/View;", "setCustomTitleView", "(Landroid/view/View;)V", "message", "getMessage", "setMessage", "messageMaxLines", "getMessageMaxLines", "setMessageMaxLines", "Landroid/text/method/MovementMethod;", "messageMovementMethod", "Landroid/text/method/MovementMethod;", "getMessageMovementMethod", "()Landroid/text/method/MovementMethod;", "setMessageMovementMethod", "(Landroid/text/method/MovementMethod;)V", "positiveButtonText", "getPositiveButtonText", "setPositiveButtonText", "Landroid/content/DialogInterface$OnClickListener;", "positiveButtonListener", "Landroid/content/DialogInterface$OnClickListener;", "getPositiveButtonListener", "()Landroid/content/DialogInterface$OnClickListener;", "setPositiveButtonListener", "(Landroid/content/DialogInterface$OnClickListener;)V", "positiveButtonIcon", "getPositiveButtonIcon", "setPositiveButtonIcon", "negativeButtonText", "getNegativeButtonText", "setNegativeButtonText", "negativeButtonListener", "getNegativeButtonListener", "setNegativeButtonListener", "negativeButtonIcon", "getNegativeButtonIcon", "setNegativeButtonIcon", "neutralButtonText", "getNeutralButtonText", "setNeutralButtonText", "neutralButtonListener", "getNeutralButtonListener", "setNeutralButtonListener", "neutralButtonIcon", "getNeutralButtonIcon", "setNeutralButtonIcon", "cancelable", "Z", "getCancelable", "setCancelable", "(Z)V", "Landroid/content/DialogInterface$OnCancelListener;", "onCancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "getOnCancelListener", "()Landroid/content/DialogInterface$OnCancelListener;", "setOnCancelListener", "(Landroid/content/DialogInterface$OnCancelListener;)V", "Landroid/content/DialogInterface$OnDismissListener;", "onDismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "getOnDismissListener", "()Landroid/content/DialogInterface$OnDismissListener;", "setOnDismissListener", "(Landroid/content/DialogInterface$OnDismissListener;)V", "Landroid/content/DialogInterface$OnKeyListener;", "onKeyListener", "Landroid/content/DialogInterface$OnKeyListener;", "getOnKeyListener", "()Landroid/content/DialogInterface$OnKeyListener;", "setOnKeyListener", "(Landroid/content/DialogInterface$OnKeyListener;)V", "", DidiCardProvider.KEY_ITEMS, "[Ljava/lang/CharSequence;", "getItems", "()[Ljava/lang/CharSequence;", "setItems", "([Ljava/lang/CharSequence;)V", "Landroid/widget/ListAdapter;", "adapter", "Landroid/widget/ListAdapter;", "getAdapter", "()Landroid/widget/ListAdapter;", "setAdapter", "(Landroid/widget/ListAdapter;)V", "Landroid/database/Cursor;", "cursor", "Landroid/database/Cursor;", "getCursor", "()Landroid/database/Cursor;", "setCursor", "(Landroid/database/Cursor;)V", "", "labelColumn", "Ljava/lang/String;", "getLabelColumn", "()Ljava/lang/String;", "setLabelColumn", "(Ljava/lang/String;)V", "isCheckedColumn", "setCheckedColumn", "onClickListener", "getOnClickListener", "setOnClickListener", "Landroid/content/DialogInterface$OnMultiChoiceClickListener;", "onCheckboxClickListener", "Landroid/content/DialogInterface$OnMultiChoiceClickListener;", "getOnCheckboxClickListener", "()Landroid/content/DialogInterface$OnMultiChoiceClickListener;", "setOnCheckboxClickListener", "(Landroid/content/DialogInterface$OnMultiChoiceClickListener;)V", "Landroid/widget/AdapterView$OnItemSelectedListener;", "onItemSelectedListener", "Landroid/widget/AdapterView$OnItemSelectedListener;", "getOnItemSelectedListener", "()Landroid/widget/AdapterView$OnItemSelectedListener;", "setOnItemSelectedListener", "(Landroid/widget/AdapterView$OnItemSelectedListener;)V", "isMultiChoice", "setMultiChoice", "isSingleChoice", "setSingleChoice", "checkedItem", "getCheckedItem", "setCheckedItem", "", "checkedItems", "[Z", "getCheckedItems", "()[Z", "setCheckedItems", "([Z)V", "isListItemCenter", "setListItemCenter", "Landroid/content/res/ColorStateList;", "listItemColor", "Landroid/content/res/ColorStateList;", "getListItemColor", "()Landroid/content/res/ColorStateList;", "setListItemColor", "(Landroid/content/res/ColorStateList;)V", "listItemColors", "[Landroid/content/res/ColorStateList;", "getListItemColors", "()[Landroid/content/res/ColorStateList;", "setListItemColors", "([Landroid/content/res/ColorStateList;)V", "Ljava/util/ArrayList;", "Landroid/util/Pair;", "Lkotlin/collections/ArrayList;", "itemData", "Ljava/util/ArrayList;", "getItemData", "()Ljava/util/ArrayList;", "setItemData", "(Ljava/util/ArrayList;)V", "isMultiLines", "setMultiLines", "listItems", "getListItems", "setListItems", "listItemsScrollbarEnabled", "getListItemsScrollbarEnabled", "setListItemsScrollbarEnabled", "hasIconContent", "getHasIconContent", "setHasIconContent", "iconContentLeftIcon", "getIconContentLeftIcon", "setIconContentLeftIcon", "iconContentLeftIconId", "getIconContentLeftIconId", "setIconContentLeftIconId", "iconContentLeftLabel", "getIconContentLeftLabel", "setIconContentLeftLabel", "iconContentRightIcon", "getIconContentRightIcon", "setIconContentRightIcon", "iconContentRightIconId", "getIconContentRightIconId", "setIconContentRightIconId", "iconContentRightLabel", "getIconContentRightLabel", "setIconContentRightLabel", "iconContentSelectedIndex", "getIconContentSelectedIndex", "setIconContentSelectedIndex", "iconContentListener", "getIconContentListener", "setIconContentListener", "view", "getView", "setView", "viewLayoutResId", "getViewLayoutResId", "setViewLayoutResId", "viewSpacingLeft", "getViewSpacingLeft", "setViewSpacingLeft", "viewSpacingTop", "getViewSpacingTop", "setViewSpacingTop", "viewSpacingRight", "getViewSpacingRight", "setViewSpacingRight", "viewSpacingBottom", "getViewSpacingBottom", "setViewSpacingBottom", "viewSpacingSpecified", "getViewSpacingSpecified", "setViewSpacingSpecified", "recycleOnMeasure", "getRecycleOnMeasure", "setRecycleOnMeasure", "gravity", "getGravity", "setGravity", "maxHeight", "getMaxHeight", "setMaxHeight", "highLightButton", "getHighLightButton", "setHighLightButton", "highLightColor", "getHighLightColor", "setHighLightColor", "autoShowSoftInput", "getAutoShowSoftInput", "setAutoShowSoftInput", "buttonLayout", "getButtonLayout", "setButtonLayout", "isGlassEnabled", "setGlassEnabled", "glassEffectSpecified", "getGlassEffectSpecified", "setGlassEffectSpecified", "Ly7/o;", "glassEffect", "Ly7/o;", "getGlassEffect", "()Ly7/o;", "setGlassEffect", "(Ly7/o;)V", "DismissOnClickListener", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StepOSAlertParams {
    private ListAdapter adapter;
    private boolean autoShowSoftInput;
    private int buttonLayout;
    private boolean cancelable;
    private int checkedItem;
    private boolean[] checkedItems;
    private final Context context;
    private Cursor cursor;
    private View customTitleView;
    private y7.o glassEffect;
    private boolean glassEffectSpecified;
    private int gravity;
    private boolean hasIconContent;
    private int highLightButton;
    private int highLightColor;
    private Drawable icon;
    private int iconAttrId;
    private Drawable iconBadge;
    private Drawable iconContentLeftIcon;
    private int iconContentLeftIconId;
    private CharSequence iconContentLeftLabel;
    private DialogInterface.OnClickListener iconContentListener;
    private Drawable iconContentRightIcon;
    private int iconContentRightIconId;
    private CharSequence iconContentRightLabel;
    private int iconContentSelectedIndex;
    private int iconId;
    private final LayoutInflater inflater;
    private String isCheckedColumn;
    private boolean isGlassEnabled;
    private boolean isListItemCenter;
    private boolean isMultiChoice;
    private boolean isMultiLines;
    private boolean isSingleChoice;
    private ArrayList<Pair<String, String>> itemData;
    private CharSequence[] items;
    private String labelColumn;
    private ColorStateList listItemColor;
    private ColorStateList[] listItemColors;
    private ArrayList<Pair<String, String>> listItems;
    private boolean listItemsScrollbarEnabled;
    private int maxHeight;
    private CharSequence message;
    private int messageMaxLines;
    private MovementMethod messageMovementMethod;
    private Drawable negativeButtonIcon;
    private DialogInterface.OnClickListener negativeButtonListener;
    private CharSequence negativeButtonText;
    private Drawable neutralButtonIcon;
    private DialogInterface.OnClickListener neutralButtonListener;
    private CharSequence neutralButtonText;
    private DialogInterface.OnCancelListener onCancelListener;
    private DialogInterface.OnMultiChoiceClickListener onCheckboxClickListener;
    private DialogInterface.OnClickListener onClickListener;
    private DialogInterface.OnDismissListener onDismissListener;
    private AdapterView.OnItemSelectedListener onItemSelectedListener;
    private DialogInterface.OnKeyListener onKeyListener;
    private Drawable positiveButtonIcon;
    private DialogInterface.OnClickListener positiveButtonListener;
    private CharSequence positiveButtonText;
    private boolean recycleOnMeasure;
    private CharSequence title;
    private int titleMaxLines;
    private View view;
    private int viewLayoutResId;
    private int viewSpacingBottom;
    private int viewSpacingLeft;
    private int viewSpacingRight;
    private boolean viewSpacingSpecified;
    private int viewSpacingTop;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/stepos/widget/dialog/StepOSAlertParams$DismissOnClickListener;", "Landroid/content/DialogInterface$OnClickListener;", "<init>", "()V", "Landroid/content/DialogInterface;", C3081a.FOCUS_DIALOG_NAME, "", "which", "LY8/t;", "onClick", "(Landroid/content/DialogInterface;I)V", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class DismissOnClickListener implements DialogInterface.OnClickListener {
        public static final DismissOnClickListener INSTANCE = new DismissOnClickListener();

        private DismissOnClickListener() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialog, int which) {
            if (dialog != null) {
                dialog.dismiss();
            }
        }
    }

    public StepOSAlertParams(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        this.context = context;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        kotlin.jvm.internal.p.h(layoutInflaterFrom, "from(...)");
        this.inflater = layoutInflaterFrom;
        this.titleMaxLines = 2;
        this.messageMaxLines = 2;
        this.cancelable = true;
        this.checkedItem = -1;
        this.listItemsScrollbarEnabled = true;
        this.recycleOnMeasure = true;
        this.highLightColor = 1;
        this.autoShowSoftInput = true;
        this.isGlassEnabled = true;
    }

    private final boolean hasAnyButton() {
        return (this.positiveButtonText == null && this.positiveButtonIcon == null && this.negativeButtonText == null && this.negativeButtonIcon == null && this.neutralButtonText == null && this.neutralButtonIcon == null) ? false : true;
    }

    public final void apply(StepOSAlertController controller) throws Resources.NotFoundException {
        StepOSAlertController stepOSAlertController;
        kotlin.jvm.internal.p.i(controller, "controller");
        controller.setTitleMaxLines(this.titleMaxLines);
        controller.setMessageMaxLines(this.messageMaxLines);
        View view = this.customTitleView;
        if (view != null) {
            controller.setCustomTitle(view);
        } else {
            CharSequence charSequence = this.title;
            if (charSequence != null) {
                controller.setTitle(charSequence);
            }
            Drawable drawable = this.icon;
            if (drawable != null) {
                controller.setIcon(drawable);
            }
            int i10 = this.iconId;
            if (i10 != 0) {
                controller.setIcon(i10);
            }
            int i11 = this.iconAttrId;
            if (i11 != 0) {
                controller.setIcon(controller.getIconAttributeResId(i11));
            }
        }
        controller.setIconBadge(this.iconBadge);
        CharSequence charSequence2 = this.message;
        if (charSequence2 != null) {
            controller.setMessage(charSequence2);
        }
        MovementMethod movementMethod = this.messageMovementMethod;
        if (movementMethod != null) {
            controller.setMessageMovementMethod(movementMethod);
        }
        CharSequence charSequence3 = this.positiveButtonText;
        if (charSequence3 == null && this.positiveButtonIcon == null) {
            stepOSAlertController = controller;
        } else {
            controller.setButton(-1, charSequence3, this.positiveButtonListener, null, this.positiveButtonIcon);
            stepOSAlertController = controller;
        }
        CharSequence charSequence4 = this.negativeButtonText;
        if (charSequence4 != null || this.negativeButtonIcon != null) {
            stepOSAlertController.setButton(-2, charSequence4, this.negativeButtonListener, null, this.negativeButtonIcon);
        }
        CharSequence charSequence5 = this.neutralButtonText;
        if (charSequence5 != null || this.neutralButtonIcon != null) {
            stepOSAlertController.setButton(-3, charSequence5, this.neutralButtonListener, null, this.neutralButtonIcon);
        }
        if (this.items != null || this.cursor != null || this.adapter != null) {
            stepOSAlertController.createListView(this);
            if (!hasAnyButton()) {
                stepOSAlertController.setButton(-2, this.context.getText(R.string.stepos_dialog_cancel), DismissOnClickListener.INSTANCE, null, null);
            }
        }
        if (this.isMultiLines) {
            stepOSAlertController.setMultiLines(true);
            stepOSAlertController.createMultiLinesView(this);
            ArrayList<Pair<String, String>> arrayList = this.itemData;
            stepOSAlertController.setMultiLinesItemCount(arrayList != null ? arrayList.size() : 0);
            stepOSAlertController.setButton(-2, this.context.getText(R.string.stepos_dialog_cancel), DismissOnClickListener.INSTANCE, null, this.negativeButtonIcon);
        }
        if (this.listItems != null) {
            stepOSAlertController.createListItemsView(this);
            if (!hasAnyButton()) {
                stepOSAlertController.setButton(-2, this.context.getText(R.string.stepos_dialog_cancel), DismissOnClickListener.INSTANCE, null, null);
            }
        }
        if (this.hasIconContent) {
            stepOSAlertController.createIconContentView(this);
        }
        View view2 = this.view;
        if (view2 == null) {
            int i12 = this.viewLayoutResId;
            if (i12 != 0) {
                stepOSAlertController.setView(i12);
            }
        } else if (this.viewSpacingSpecified) {
            stepOSAlertController.setView(view2, this.viewSpacingLeft, this.viewSpacingTop, this.viewSpacingRight, this.viewSpacingBottom);
        } else {
            stepOSAlertController.setView(view2);
        }
        stepOSAlertController.setGravity(this.gravity);
        stepOSAlertController.setButtonLayout(this.buttonLayout);
        stepOSAlertController.setGlassEnabled(this.isGlassEnabled);
        if (this.glassEffectSpecified) {
            stepOSAlertController.setGlassEffect(this.glassEffect);
        }
        stepOSAlertController.setMaxHeight(this.maxHeight);
        stepOSAlertController.setHighLightButton(this.highLightButton, this.highLightColor);
        stepOSAlertController.setAutoShowSoftInput(this.autoShowSoftInput);
    }

    public final ListAdapter getAdapter() {
        return this.adapter;
    }

    public final boolean getAutoShowSoftInput() {
        return this.autoShowSoftInput;
    }

    public final int getButtonLayout() {
        return this.buttonLayout;
    }

    public final boolean getCancelable() {
        return this.cancelable;
    }

    public final int getCheckedItem() {
        return this.checkedItem;
    }

    public final boolean[] getCheckedItems() {
        return this.checkedItems;
    }

    public final Context getContext() {
        return this.context;
    }

    public final Cursor getCursor() {
        return this.cursor;
    }

    public final View getCustomTitleView() {
        return this.customTitleView;
    }

    public final y7.o getGlassEffect() {
        return this.glassEffect;
    }

    public final boolean getGlassEffectSpecified() {
        return this.glassEffectSpecified;
    }

    public final int getGravity() {
        return this.gravity;
    }

    public final boolean getHasIconContent() {
        return this.hasIconContent;
    }

    public final int getHighLightButton() {
        return this.highLightButton;
    }

    public final int getHighLightColor() {
        return this.highLightColor;
    }

    public final Drawable getIcon() {
        return this.icon;
    }

    public final int getIconAttrId() {
        return this.iconAttrId;
    }

    public final Drawable getIconBadge() {
        return this.iconBadge;
    }

    public final Drawable getIconContentLeftIcon() {
        return this.iconContentLeftIcon;
    }

    public final int getIconContentLeftIconId() {
        return this.iconContentLeftIconId;
    }

    public final CharSequence getIconContentLeftLabel() {
        return this.iconContentLeftLabel;
    }

    public final DialogInterface.OnClickListener getIconContentListener() {
        return this.iconContentListener;
    }

    public final Drawable getIconContentRightIcon() {
        return this.iconContentRightIcon;
    }

    public final int getIconContentRightIconId() {
        return this.iconContentRightIconId;
    }

    public final CharSequence getIconContentRightLabel() {
        return this.iconContentRightLabel;
    }

    public final int getIconContentSelectedIndex() {
        return this.iconContentSelectedIndex;
    }

    public final int getIconId() {
        return this.iconId;
    }

    public final LayoutInflater getInflater() {
        return this.inflater;
    }

    public final ArrayList<Pair<String, String>> getItemData() {
        return this.itemData;
    }

    public final CharSequence[] getItems() {
        return this.items;
    }

    public final String getLabelColumn() {
        return this.labelColumn;
    }

    public final ColorStateList getListItemColor() {
        return this.listItemColor;
    }

    public final ColorStateList[] getListItemColors() {
        return this.listItemColors;
    }

    public final ArrayList<Pair<String, String>> getListItems() {
        return this.listItems;
    }

    public final boolean getListItemsScrollbarEnabled() {
        return this.listItemsScrollbarEnabled;
    }

    public final int getMaxHeight() {
        return this.maxHeight;
    }

    public final CharSequence getMessage() {
        return this.message;
    }

    public final int getMessageMaxLines() {
        return this.messageMaxLines;
    }

    public final MovementMethod getMessageMovementMethod() {
        return this.messageMovementMethod;
    }

    public final Drawable getNegativeButtonIcon() {
        return this.negativeButtonIcon;
    }

    public final DialogInterface.OnClickListener getNegativeButtonListener() {
        return this.negativeButtonListener;
    }

    public final CharSequence getNegativeButtonText() {
        return this.negativeButtonText;
    }

    public final Drawable getNeutralButtonIcon() {
        return this.neutralButtonIcon;
    }

    public final DialogInterface.OnClickListener getNeutralButtonListener() {
        return this.neutralButtonListener;
    }

    public final CharSequence getNeutralButtonText() {
        return this.neutralButtonText;
    }

    public final DialogInterface.OnCancelListener getOnCancelListener() {
        return this.onCancelListener;
    }

    public final DialogInterface.OnMultiChoiceClickListener getOnCheckboxClickListener() {
        return this.onCheckboxClickListener;
    }

    public final DialogInterface.OnClickListener getOnClickListener() {
        return this.onClickListener;
    }

    public final DialogInterface.OnDismissListener getOnDismissListener() {
        return this.onDismissListener;
    }

    public final AdapterView.OnItemSelectedListener getOnItemSelectedListener() {
        return this.onItemSelectedListener;
    }

    public final DialogInterface.OnKeyListener getOnKeyListener() {
        return this.onKeyListener;
    }

    public final Drawable getPositiveButtonIcon() {
        return this.positiveButtonIcon;
    }

    public final DialogInterface.OnClickListener getPositiveButtonListener() {
        return this.positiveButtonListener;
    }

    public final CharSequence getPositiveButtonText() {
        return this.positiveButtonText;
    }

    public final boolean getRecycleOnMeasure() {
        return this.recycleOnMeasure;
    }

    public final CharSequence getTitle() {
        return this.title;
    }

    public final int getTitleMaxLines() {
        return this.titleMaxLines;
    }

    public final View getView() {
        return this.view;
    }

    public final int getViewLayoutResId() {
        return this.viewLayoutResId;
    }

    public final int getViewSpacingBottom() {
        return this.viewSpacingBottom;
    }

    public final int getViewSpacingLeft() {
        return this.viewSpacingLeft;
    }

    public final int getViewSpacingRight() {
        return this.viewSpacingRight;
    }

    public final boolean getViewSpacingSpecified() {
        return this.viewSpacingSpecified;
    }

    public final int getViewSpacingTop() {
        return this.viewSpacingTop;
    }

    /* renamed from: isCheckedColumn, reason: from getter */
    public final String getIsCheckedColumn() {
        return this.isCheckedColumn;
    }

    /* renamed from: isGlassEnabled, reason: from getter */
    public final boolean getIsGlassEnabled() {
        return this.isGlassEnabled;
    }

    /* renamed from: isListItemCenter, reason: from getter */
    public final boolean getIsListItemCenter() {
        return this.isListItemCenter;
    }

    /* renamed from: isMultiChoice, reason: from getter */
    public final boolean getIsMultiChoice() {
        return this.isMultiChoice;
    }

    /* renamed from: isMultiLines, reason: from getter */
    public final boolean getIsMultiLines() {
        return this.isMultiLines;
    }

    /* renamed from: isSingleChoice, reason: from getter */
    public final boolean getIsSingleChoice() {
        return this.isSingleChoice;
    }

    public final void setAdapter(ListAdapter listAdapter) {
        this.adapter = listAdapter;
    }

    public final void setAutoShowSoftInput(boolean z10) {
        this.autoShowSoftInput = z10;
    }

    public final void setButtonLayout(int i10) {
        this.buttonLayout = i10;
    }

    public final void setCancelable(boolean z10) {
        this.cancelable = z10;
    }

    public final void setCheckedColumn(String str) {
        this.isCheckedColumn = str;
    }

    public final void setCheckedItem(int i10) {
        this.checkedItem = i10;
    }

    public final void setCheckedItems(boolean[] zArr) {
        this.checkedItems = zArr;
    }

    public final void setCursor(Cursor cursor) {
        this.cursor = cursor;
    }

    public final void setCustomTitleView(View view) {
        this.customTitleView = view;
    }

    public final void setGlassEffect(y7.o oVar) {
        this.glassEffect = oVar;
    }

    public final void setGlassEffectSpecified(boolean z10) {
        this.glassEffectSpecified = z10;
    }

    public final void setGlassEnabled(boolean z10) {
        this.isGlassEnabled = z10;
    }

    public final void setGravity(int i10) {
        this.gravity = i10;
    }

    public final void setHasIconContent(boolean z10) {
        this.hasIconContent = z10;
    }

    public final void setHighLightButton(int i10) {
        this.highLightButton = i10;
    }

    public final void setHighLightColor(int i10) {
        this.highLightColor = i10;
    }

    public final void setIcon(Drawable drawable) {
        this.icon = drawable;
    }

    public final void setIconAttrId(int i10) {
        this.iconAttrId = i10;
    }

    public final void setIconBadge(Drawable drawable) {
        this.iconBadge = drawable;
    }

    public final void setIconContentLeftIcon(Drawable drawable) {
        this.iconContentLeftIcon = drawable;
    }

    public final void setIconContentLeftIconId(int i10) {
        this.iconContentLeftIconId = i10;
    }

    public final void setIconContentLeftLabel(CharSequence charSequence) {
        this.iconContentLeftLabel = charSequence;
    }

    public final void setIconContentListener(DialogInterface.OnClickListener onClickListener) {
        this.iconContentListener = onClickListener;
    }

    public final void setIconContentRightIcon(Drawable drawable) {
        this.iconContentRightIcon = drawable;
    }

    public final void setIconContentRightIconId(int i10) {
        this.iconContentRightIconId = i10;
    }

    public final void setIconContentRightLabel(CharSequence charSequence) {
        this.iconContentRightLabel = charSequence;
    }

    public final void setIconContentSelectedIndex(int i10) {
        this.iconContentSelectedIndex = i10;
    }

    public final void setIconId(int i10) {
        this.iconId = i10;
    }

    public final void setItemData(ArrayList<Pair<String, String>> arrayList) {
        this.itemData = arrayList;
    }

    public final void setItems(CharSequence[] charSequenceArr) {
        this.items = charSequenceArr;
    }

    public final void setLabelColumn(String str) {
        this.labelColumn = str;
    }

    public final void setListItemCenter(boolean z10) {
        this.isListItemCenter = z10;
    }

    public final void setListItemColor(ColorStateList colorStateList) {
        this.listItemColor = colorStateList;
    }

    public final void setListItemColors(ColorStateList[] colorStateListArr) {
        this.listItemColors = colorStateListArr;
    }

    public final void setListItems(ArrayList<Pair<String, String>> arrayList) {
        this.listItems = arrayList;
    }

    public final void setListItemsScrollbarEnabled(boolean z10) {
        this.listItemsScrollbarEnabled = z10;
    }

    public final void setMaxHeight(int i10) {
        this.maxHeight = i10;
    }

    public final void setMessage(CharSequence charSequence) {
        this.message = charSequence;
    }

    public final void setMessageMaxLines(int i10) {
        this.messageMaxLines = i10;
    }

    public final void setMessageMovementMethod(MovementMethod movementMethod) {
        this.messageMovementMethod = movementMethod;
    }

    public final void setMultiChoice(boolean z10) {
        this.isMultiChoice = z10;
    }

    public final void setMultiLines(boolean z10) {
        this.isMultiLines = z10;
    }

    public final void setNegativeButtonIcon(Drawable drawable) {
        this.negativeButtonIcon = drawable;
    }

    public final void setNegativeButtonListener(DialogInterface.OnClickListener onClickListener) {
        this.negativeButtonListener = onClickListener;
    }

    public final void setNegativeButtonText(CharSequence charSequence) {
        this.negativeButtonText = charSequence;
    }

    public final void setNeutralButtonIcon(Drawable drawable) {
        this.neutralButtonIcon = drawable;
    }

    public final void setNeutralButtonListener(DialogInterface.OnClickListener onClickListener) {
        this.neutralButtonListener = onClickListener;
    }

    public final void setNeutralButtonText(CharSequence charSequence) {
        this.neutralButtonText = charSequence;
    }

    public final void setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        this.onCancelListener = onCancelListener;
    }

    public final void setOnCheckboxClickListener(DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        this.onCheckboxClickListener = onMultiChoiceClickListener;
    }

    public final void setOnClickListener(DialogInterface.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public final void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.onDismissListener = onDismissListener;
    }

    public final void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.onItemSelectedListener = onItemSelectedListener;
    }

    public final void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        this.onKeyListener = onKeyListener;
    }

    public final void setPositiveButtonIcon(Drawable drawable) {
        this.positiveButtonIcon = drawable;
    }

    public final void setPositiveButtonListener(DialogInterface.OnClickListener onClickListener) {
        this.positiveButtonListener = onClickListener;
    }

    public final void setPositiveButtonText(CharSequence charSequence) {
        this.positiveButtonText = charSequence;
    }

    public final void setRecycleOnMeasure(boolean z10) {
        this.recycleOnMeasure = z10;
    }

    public final void setSingleChoice(boolean z10) {
        this.isSingleChoice = z10;
    }

    public final void setTitle(CharSequence charSequence) {
        this.title = charSequence;
    }

    public final void setTitleMaxLines(int i10) {
        this.titleMaxLines = i10;
    }

    public final void setView(View view) {
        this.view = view;
    }

    public final void setViewLayoutResId(int i10) {
        this.viewLayoutResId = i10;
    }

    public final void setViewSpacingBottom(int i10) {
        this.viewSpacingBottom = i10;
    }

    public final void setViewSpacingLeft(int i10) {
        this.viewSpacingLeft = i10;
    }

    public final void setViewSpacingRight(int i10) {
        this.viewSpacingRight = i10;
    }

    public final void setViewSpacingSpecified(boolean z10) {
        this.viewSpacingSpecified = z10;
    }

    public final void setViewSpacingTop(int i10) {
        this.viewSpacingTop = i10;
    }
}
