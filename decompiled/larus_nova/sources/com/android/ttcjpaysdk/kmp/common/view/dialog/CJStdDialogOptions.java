package com.android.ttcjpaysdk.kmp.common.view.dialog;

import com.autonavi.amap.mapcore.AMapEngineUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u007f\b\u0087\b\u0018\u00002\u00020\u0001B\u008b\u0003\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001f\u001a\u00020\t\u0012\b\b\u0002\u0010 \u001a\u00020\u0003\u0012\b\b\u0002\u0010!\u001a\u00020\u0003\u0012\b\b\u0002\u0010\"\u001a\u00020\u0003\u0012\b\b\u0002\u0010#\u001a\u00020\u0007\u0012\b\b\u0002\u0010$\u001a\u00020\u0007\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010'\u001a\u00020\u0003\u0012\b\b\u0002\u0010(\u001a\u00020\u0003\u0012\b\b\u0002\u0010)\u001a\u00020\t\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+¢\u0006\u0004\b,\u0010-J\t\u0010\u007f\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0080\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0081\u0001\u001a\u00020\u0003HÆ\u0003J\f\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\n\u0010\u0083\u0001\u001a\u00020\tHÆ\u0003J\n\u0010\u0084\u0001\u001a\u00020\tHÆ\u0003J\n\u0010\u0085\u0001\u001a\u00020\u0007HÆ\u0003J\n\u0010\u0086\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0087\u0001\u001a\u00020\u0007HÆ\u0003J\n\u0010\u0088\u0001\u001a\u00020\u0007HÆ\u0003J\n\u0010\u0089\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u008a\u0001\u001a\u00020\u0007HÆ\u0003J\n\u0010\u008b\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u008c\u0001\u001a\u00020\u0007HÆ\u0003J\n\u0010\u008d\u0001\u001a\u00020\u0007HÆ\u0003J\n\u0010\u008e\u0001\u001a\u00020\u0007HÆ\u0003J\n\u0010\u008f\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0090\u0001\u001a\u00020\u0007HÆ\u0003J\n\u0010\u0091\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0092\u0001\u001a\u00020\u0007HÆ\u0003J\n\u0010\u0093\u0001\u001a\u00020\u0007HÆ\u0003J\u0011\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u001bHÆ\u0003¢\u0006\u0002\u0010\\J\u0011\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u001bHÆ\u0003¢\u0006\u0002\u0010\\J\u0011\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u001bHÆ\u0003¢\u0006\u0002\u0010\\J\u0011\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u001bHÆ\u0003¢\u0006\u0002\u0010\\J\n\u0010\u0098\u0001\u001a\u00020\tHÆ\u0003J\n\u0010\u0099\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u009a\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u009b\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u009c\u0001\u001a\u00020\u0007HÆ\u0003J\n\u0010\u009d\u0001\u001a\u00020\u0007HÆ\u0003J\u0011\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u001bHÆ\u0003¢\u0006\u0002\u0010\\J\u0011\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u001bHÆ\u0003¢\u0006\u0002\u0010\\J\n\u0010 \u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010¡\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010¢\u0001\u001a\u00020\tHÆ\u0003J\f\u0010£\u0001\u001a\u0004\u0018\u00010+HÆ\u0003J\u0092\u0003\u0010¤\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u00072\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00072\b\b\u0002\u0010\u0019\u001a\u00020\u00072\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001f\u001a\u00020\t2\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u00032\b\b\u0002\u0010#\u001a\u00020\u00072\b\b\u0002\u0010$\u001a\u00020\u00072\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010'\u001a\u00020\u00032\b\b\u0002\u0010(\u001a\u00020\u00032\b\b\u0002\u0010)\u001a\u00020\t2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+HÆ\u0001¢\u0006\u0003\u0010¥\u0001J\u0015\u0010¦\u0001\u001a\u00020\u00032\t\u0010§\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010¨\u0001\u001a\u00020\tHÖ\u0001J\n\u0010©\u0001\u001a\u00020\u0007HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010/\u001a\u0004\b\u0002\u00100R\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b1\u0010/\u001a\u0004\b\u0004\u00100R\u001c\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b2\u0010/\u001a\u0004\b3\u00100R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b4\u0010/\u001a\u0004\b5\u00106R\u001c\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b7\u0010/\u001a\u0004\b8\u00109R\u001c\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b:\u0010/\u001a\u0004\b;\u00109R\u001c\u0010\u000b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b<\u0010/\u001a\u0004\b=\u00106R\u001c\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b>\u0010/\u001a\u0004\b?\u00100R\u001c\u0010\r\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b@\u0010/\u001a\u0004\bA\u00106R\u001c\u0010\u000e\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bB\u0010/\u001a\u0004\bC\u00106R\u001c\u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bD\u0010/\u001a\u0004\bE\u00100R\u001c\u0010\u0010\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bF\u0010/\u001a\u0004\bG\u00106R\u001c\u0010\u0011\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bH\u0010/\u001a\u0004\bI\u00100R\u001c\u0010\u0012\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bJ\u0010/\u001a\u0004\bK\u00106R\u001c\u0010\u0013\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bL\u0010/\u001a\u0004\bM\u00106R\u001c\u0010\u0014\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bN\u0010/\u001a\u0004\bO\u00106R\u001c\u0010\u0015\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bP\u0010/\u001a\u0004\bQ\u00100R\u001c\u0010\u0016\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bR\u0010/\u001a\u0004\bS\u00106R\u001c\u0010\u0017\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bT\u0010/\u001a\u0004\bU\u00100R\u001c\u0010\u0018\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bV\u0010/\u001a\u0004\bW\u00106R\u001c\u0010\u0019\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bX\u0010/\u001a\u0004\bY\u00106R \u0010\u001a\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010]\u0012\u0004\bZ\u0010/\u001a\u0004\b[\u0010\\R \u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010]\u0012\u0004\b^\u0010/\u001a\u0004\b_\u0010\\R \u0010\u001d\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010]\u0012\u0004\b`\u0010/\u001a\u0004\ba\u0010\\R \u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010]\u0012\u0004\bb\u0010/\u001a\u0004\bc\u0010\\R\u001c\u0010\u001f\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bd\u0010/\u001a\u0004\be\u00109R\u001c\u0010 \u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bf\u0010/\u001a\u0004\bg\u00100R\u001c\u0010!\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bh\u0010/\u001a\u0004\bi\u00100R\u001c\u0010\"\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bj\u0010/\u001a\u0004\bk\u00100R\u001c\u0010#\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bl\u0010/\u001a\u0004\bm\u00106R\u001c\u0010$\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bn\u0010/\u001a\u0004\bo\u00106R \u0010%\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010]\u0012\u0004\bp\u0010/\u001a\u0004\bq\u0010\\R \u0010&\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010]\u0012\u0004\br\u0010/\u001a\u0004\bs\u0010\\R\u001c\u0010'\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bt\u0010/\u001a\u0004\bu\u00100R\u001c\u0010(\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bv\u0010/\u001a\u0004\bw\u00100R\u001c\u0010)\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bx\u0010/\u001a\u0004\by\u00109R&\u0010*\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bz\u0010/\u001a\u0004\b{\u0010|\"\u0004\b}\u0010~¨\u0006ª\u0001"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/view/dialog/CJStdDialogOptions;", "", "isCancelable", "", "isCanceledOnTouchOutside", "showClose", "iconUrl", "", "iconWidthDp", "", "iconHeightDp", "title", "titleBold", "subTitle", "content", "contentCenterHorizontal", "linkTitle", "showInput", "inputHint", "inputTips", "agreementText", "agreementChecked", "checkText", "checkTextChecked", "primaryBtnText", "secondaryBtnText", "primaryBtnTextColor", "", "primaryBtnBgColor", "secondaryBtnTextColor", "secondaryBtnBgColor", "buttonLayoutStyle", "useGradientBackground", "allowDelayDismissPrimaryClick", "primaryBtnLoading", "primaryOpText", "secondaryOpText", "primaryOpTextColor", "secondaryOpTextColor", "primaryOpTextBold", "secondaryOpTextBold", "primaryOpEnableDelay", "callback", "Lcom/android/ttcjpaysdk/kmp/common/view/dialog/ICJStdDialogCallback;", "<init>", "(ZZZLjava/lang/String;IILjava/lang/String;ZLjava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;IZZZLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;ZZILcom/android/ttcjpaysdk/kmp/common/view/dialog/ICJStdDialogCallback;)V", "isCancelable$annotations", "()V", "()Z", "isCanceledOnTouchOutside$annotations", "getShowClose$annotations", "getShowClose", "getIconUrl$annotations", "getIconUrl", "()Ljava/lang/String;", "getIconWidthDp$annotations", "getIconWidthDp", "()I", "getIconHeightDp$annotations", "getIconHeightDp", "getTitle$annotations", "getTitle", "getTitleBold$annotations", "getTitleBold", "getSubTitle$annotations", "getSubTitle", "getContent$annotations", "getContent", "getContentCenterHorizontal$annotations", "getContentCenterHorizontal", "getLinkTitle$annotations", "getLinkTitle", "getShowInput$annotations", "getShowInput", "getInputHint$annotations", "getInputHint", "getInputTips$annotations", "getInputTips", "getAgreementText$annotations", "getAgreementText", "getAgreementChecked$annotations", "getAgreementChecked", "getCheckText$annotations", "getCheckText", "getCheckTextChecked$annotations", "getCheckTextChecked", "getPrimaryBtnText$annotations", "getPrimaryBtnText", "getSecondaryBtnText$annotations", "getSecondaryBtnText", "getPrimaryBtnTextColor$annotations", "getPrimaryBtnTextColor", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getPrimaryBtnBgColor$annotations", "getPrimaryBtnBgColor", "getSecondaryBtnTextColor$annotations", "getSecondaryBtnTextColor", "getSecondaryBtnBgColor$annotations", "getSecondaryBtnBgColor", "getButtonLayoutStyle$annotations", "getButtonLayoutStyle", "getUseGradientBackground$annotations", "getUseGradientBackground", "getAllowDelayDismissPrimaryClick$annotations", "getAllowDelayDismissPrimaryClick", "getPrimaryBtnLoading$annotations", "getPrimaryBtnLoading", "getPrimaryOpText$annotations", "getPrimaryOpText", "getSecondaryOpText$annotations", "getSecondaryOpText", "getPrimaryOpTextColor$annotations", "getPrimaryOpTextColor", "getSecondaryOpTextColor$annotations", "getSecondaryOpTextColor", "getPrimaryOpTextBold$annotations", "getPrimaryOpTextBold", "getSecondaryOpTextBold$annotations", "getSecondaryOpTextBold", "getPrimaryOpEnableDelay$annotations", "getPrimaryOpEnableDelay", "getCallback$annotations", "getCallback", "()Lcom/android/ttcjpaysdk/kmp/common/view/dialog/ICJStdDialogCallback;", "setCallback", "(Lcom/android/ttcjpaysdk/kmp/common/view/dialog/ICJStdDialogCallback;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "copy", "(ZZZLjava/lang/String;IILjava/lang/String;ZLjava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;IZZZLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;ZZILcom/android/ttcjpaysdk/kmp/common/view/dialog/ICJStdDialogCallback;)Lcom/android/ttcjpaysdk/kmp/common/view/dialog/CJStdDialogOptions;", "equals", "other", "hashCode", "toString", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CJStdDialogOptions {
    public static final int $stable = 8;
    private final boolean agreementChecked;
    private final String agreementText;
    private final boolean allowDelayDismissPrimaryClick;
    private final int buttonLayoutStyle;
    private ICJStdDialogCallback callback;
    private final String checkText;
    private final boolean checkTextChecked;
    private final String content;
    private final boolean contentCenterHorizontal;
    private final int iconHeightDp;
    private final String iconUrl;
    private final int iconWidthDp;
    private final String inputHint;
    private final String inputTips;
    private final boolean isCancelable;
    private final boolean isCanceledOnTouchOutside;
    private final String linkTitle;
    private final Long primaryBtnBgColor;
    private final boolean primaryBtnLoading;
    private final String primaryBtnText;
    private final Long primaryBtnTextColor;
    private final int primaryOpEnableDelay;
    private final String primaryOpText;
    private final boolean primaryOpTextBold;
    private final Long primaryOpTextColor;
    private final Long secondaryBtnBgColor;
    private final String secondaryBtnText;
    private final Long secondaryBtnTextColor;
    private final String secondaryOpText;
    private final boolean secondaryOpTextBold;
    private final Long secondaryOpTextColor;
    private final boolean showClose;
    private final boolean showInput;
    private final String subTitle;
    private final String title;
    private final boolean titleBold;
    private final boolean useGradientBackground;

    public CJStdDialogOptions() {
        this(false, false, false, null, 0, 0, null, false, null, null, false, null, false, null, null, null, false, null, false, null, null, null, null, null, null, 0, false, false, false, null, null, null, null, false, false, 0, null, -1, 31, null);
    }

    public static /* synthetic */ CJStdDialogOptions copy$default(CJStdDialogOptions r110, boolean r111, boolean r112, boolean r210, String r211, int r212, int r213, String r214, boolean r215, String r216, String r217, boolean r218, String r219, boolean r310, String r311, String r312, String r313, boolean r314, String r315, boolean r316, String r317, String r318, Long r319, Long r410, Long r411, Long r412, int r413, boolean r414, boolean r415, boolean r416, String r417, String r418, Long r419, Long r510, boolean r511, boolean r512, int r513, ICJStdDialogCallback r514, int r515, int r516, Object r517) {
        if ((r515 & 1) == 0) goto L5;
        boolean r100 = r110.isCancelable;
    L7:
        if ((r515 & 2) == 0) goto L9;
        boolean r101 = r110.isCanceledOnTouchOutside;
    L11:
        if ((r515 & 4) == 0) goto L13;
        boolean r102 = r110.showClose;
    L15:
        if ((r515 & 8) == 0) goto L17;
        String r103 = r110.iconUrl;
    L19:
        if ((r515 & 16) == 0) goto L21;
        int r104 = r110.iconWidthDp;
    L23:
        if ((r515 & 32) == 0) goto L25;
        int r105 = r110.iconHeightDp;
    L27:
        if ((r515 & 64) == 0) goto L29;
        String r106 = r110.title;
    L31:
        if ((r515 & 128) == 0) goto L33;
        boolean r107 = r110.titleBold;
    L35:
        if ((r515 & 256) == 0) goto L37;
        String r113 = r110.subTitle;
    L39:
        if ((r515 & 512) == 0) goto L41;
        String r114 = r110.content;
    L43:
        if ((r515 & 1024) == 0) goto L45;
        boolean r115 = r110.contentCenterHorizontal;
    L47:
        if ((r515 & 2048) == 0) goto L49;
        String r116 = r110.linkTitle;
    L51:
        if ((r515 & 4096) == 0) goto L53;
        boolean r117 = r110.showInput;
    L55:
        if ((r515 & 8192) == 0) goto L57;
        String r118 = r110.inputHint;
    L58:
        String r320 = r118;
        if ((r515 & 16384) == 0) goto L61;
        String r119 = r110.inputTips;
    L62:
        String r321 = r119;
        if ((r515 & 32768) == 0) goto L65;
        String r120 = r110.agreementText;
    L66:
        String r322 = r120;
        if ((r515 & 65536) == 0) goto L69;
        boolean r121 = r110.agreementChecked;
    L70:
        boolean r323 = r121;
        if ((r515 & 131072) == 0) goto L73;
        String r122 = r110.checkText;
    L74:
        String r324 = r122;
        if ((r515 & 262144) == 0) goto L77;
        boolean r123 = r110.checkTextChecked;
    L78:
        boolean r325 = r123;
        if ((r515 & 524288) == 0) goto L81;
        String r124 = r110.primaryBtnText;
    L82:
        String r326 = r124;
        if ((r515 & 1048576) == 0) goto L85;
        String r125 = r110.secondaryBtnText;
    L86:
        String r327 = r125;
        if ((r515 & 2097152) == 0) goto L89;
        Long r126 = r110.primaryBtnTextColor;
    L90:
        Long r328 = r126;
        if ((r515 & 4194304) == 0) goto L93;
        Long r127 = r110.primaryBtnBgColor;
    L94:
        Long r420 = r127;
        if ((r515 & 8388608) == 0) goto L97;
        Long r128 = r110.secondaryBtnTextColor;
    L98:
        Long r421 = r128;
        if ((r515 & 16777216) == 0) goto L101;
        Long r129 = r110.secondaryBtnBgColor;
    L102:
        Long r422 = r129;
        if ((r515 & 33554432) == 0) goto L105;
        int r130 = r110.buttonLayoutStyle;
    L106:
        int r423 = r130;
        if ((r515 & 67108864) == 0) goto L109;
        boolean r131 = r110.useGradientBackground;
    L110:
        boolean r424 = r131;
        if ((r515 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        boolean r132 = r110.allowDelayDismissPrimaryClick;
    L114:
        boolean r425 = r132;
        if ((r515 & 268435456) == 0) goto L117;
        boolean r133 = r110.primaryBtnLoading;
    L118:
        boolean r426 = r133;
        if ((r515 & 536870912) == 0) goto L121;
        String r134 = r110.primaryOpText;
    L122:
        String r427 = r134;
        if ((r515 & 1073741824) == 0) goto L125;
        String r135 = r110.secondaryOpText;
    L127:
        if ((r515 & Integer.MIN_VALUE) == 0) goto L129;
        Long r108 = r110.primaryOpTextColor;
    L130:
        Long r428 = r108;
        if ((r516 & 1) == 0) goto L133;
        Long r109 = r110.secondaryOpTextColor;
    L134:
        Long r518 = r109;
        if ((r516 & 2) == 0) goto L137;
        boolean r136 = r110.primaryOpTextBold;
    L138:
        boolean r519 = r136;
        if ((r516 & 4) == 0) goto L141;
        boolean r137 = r110.secondaryOpTextBold;
    L142:
        boolean r520 = r137;
        if ((r516 & 8) == 0) goto L145;
        int r138 = r110.primaryOpEnableDelay;
    L146:
        int r521 = r138;
        if ((r516 & 16) == 0) goto L149;
        ICJStdDialogCallback r139 = r110.callback;
    L151:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r320, r321, r322, r323, r324, r325, r326, r327, r328, r420, r421, r422, r423, r424, r425, r426, r427, r135, r428, r518, r519, r520, r521, r139);
    L149:
        r139 = r514;
        goto L151
    L145:
        r138 = r513;
        goto L146
    L141:
        r137 = r512;
        goto L142
    L137:
        r136 = r511;
        goto L138
    L133:
        r109 = r510;
        goto L134
    L129:
        r108 = r419;
        goto L130
    L125:
        r135 = r418;
        goto L127
    L121:
        r134 = r417;
        goto L122
    L117:
        r133 = r416;
        goto L118
    L113:
        r132 = r415;
        goto L114
    L109:
        r131 = r414;
        goto L110
    L105:
        r130 = r413;
        goto L106
    L101:
        r129 = r412;
        goto L102
    L97:
        r128 = r411;
        goto L98
    L93:
        r127 = r410;
        goto L94
    L89:
        r126 = r319;
        goto L90
    L85:
        r125 = r318;
        goto L86
    L81:
        r124 = r317;
        goto L82
    L77:
        r123 = r316;
        goto L78
    L73:
        r122 = r315;
        goto L74
    L69:
        r121 = r314;
        goto L70
    L65:
        r120 = r313;
        goto L66
    L61:
        r119 = r312;
        goto L62
    L57:
        r118 = r311;
        goto L58
    L53:
        r117 = r310;
        goto L55
    L49:
        r116 = r219;
        goto L51
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public static /* synthetic */ void getAgreementChecked$annotations() {
    }

    public static /* synthetic */ void getAgreementText$annotations() {
    }

    public static /* synthetic */ void getAllowDelayDismissPrimaryClick$annotations() {
    }

    public static /* synthetic */ void getButtonLayoutStyle$annotations() {
    }

    public static /* synthetic */ void getCallback$annotations() {
    }

    public static /* synthetic */ void getCheckText$annotations() {
    }

    public static /* synthetic */ void getCheckTextChecked$annotations() {
    }

    public static /* synthetic */ void getContent$annotations() {
    }

    public static /* synthetic */ void getContentCenterHorizontal$annotations() {
    }

    public static /* synthetic */ void getIconHeightDp$annotations() {
    }

    public static /* synthetic */ void getIconUrl$annotations() {
    }

    public static /* synthetic */ void getIconWidthDp$annotations() {
    }

    public static /* synthetic */ void getInputHint$annotations() {
    }

    public static /* synthetic */ void getInputTips$annotations() {
    }

    public static /* synthetic */ void getLinkTitle$annotations() {
    }

    public static /* synthetic */ void getPrimaryBtnBgColor$annotations() {
    }

    public static /* synthetic */ void getPrimaryBtnLoading$annotations() {
    }

    public static /* synthetic */ void getPrimaryBtnText$annotations() {
    }

    public static /* synthetic */ void getPrimaryBtnTextColor$annotations() {
    }

    public static /* synthetic */ void getPrimaryOpEnableDelay$annotations() {
    }

    public static /* synthetic */ void getPrimaryOpText$annotations() {
    }

    public static /* synthetic */ void getPrimaryOpTextBold$annotations() {
    }

    public static /* synthetic */ void getPrimaryOpTextColor$annotations() {
    }

    public static /* synthetic */ void getSecondaryBtnBgColor$annotations() {
    }

    public static /* synthetic */ void getSecondaryBtnText$annotations() {
    }

    public static /* synthetic */ void getSecondaryBtnTextColor$annotations() {
    }

    public static /* synthetic */ void getSecondaryOpText$annotations() {
    }

    public static /* synthetic */ void getSecondaryOpTextBold$annotations() {
    }

    public static /* synthetic */ void getSecondaryOpTextColor$annotations() {
    }

    public static /* synthetic */ void getShowClose$annotations() {
    }

    public static /* synthetic */ void getShowInput$annotations() {
    }

    public static /* synthetic */ void getSubTitle$annotations() {
    }

    public static /* synthetic */ void getTitle$annotations() {
    }

    public static /* synthetic */ void getTitleBold$annotations() {
    }

    public static /* synthetic */ void getUseGradientBackground$annotations() {
    }

    public static /* synthetic */ void isCancelable$annotations() {
    }

    public static /* synthetic */ void isCanceledOnTouchOutside$annotations() {
    }

    public final boolean component1() {
        return this.isCancelable;
    }

    public final String component10() {
        return this.content;
    }

    public final boolean component11() {
        return this.contentCenterHorizontal;
    }

    public final String component12() {
        return this.linkTitle;
    }

    public final boolean component13() {
        return this.showInput;
    }

    public final String component14() {
        return this.inputHint;
    }

    public final String component15() {
        return this.inputTips;
    }

    public final String component16() {
        return this.agreementText;
    }

    public final boolean component17() {
        return this.agreementChecked;
    }

    public final String component18() {
        return this.checkText;
    }

    public final boolean component19() {
        return this.checkTextChecked;
    }

    public final boolean component2() {
        return this.isCanceledOnTouchOutside;
    }

    public final String component20() {
        return this.primaryBtnText;
    }

    public final String component21() {
        return this.secondaryBtnText;
    }

    public final Long component22() {
        return this.primaryBtnTextColor;
    }

    public final Long component23() {
        return this.primaryBtnBgColor;
    }

    public final Long component24() {
        return this.secondaryBtnTextColor;
    }

    public final Long component25() {
        return this.secondaryBtnBgColor;
    }

    public final int component26() {
        return this.buttonLayoutStyle;
    }

    public final boolean component27() {
        return this.useGradientBackground;
    }

    public final boolean component28() {
        return this.allowDelayDismissPrimaryClick;
    }

    public final boolean component29() {
        return this.primaryBtnLoading;
    }

    public final boolean component3() {
        return this.showClose;
    }

    public final String component30() {
        return this.primaryOpText;
    }

    public final String component31() {
        return this.secondaryOpText;
    }

    public final Long component32() {
        return this.primaryOpTextColor;
    }

    public final Long component33() {
        return this.secondaryOpTextColor;
    }

    public final boolean component34() {
        return this.primaryOpTextBold;
    }

    public final boolean component35() {
        return this.secondaryOpTextBold;
    }

    public final int component36() {
        return this.primaryOpEnableDelay;
    }

    public final ICJStdDialogCallback component37() {
        return this.callback;
    }

    public final String component4() {
        return this.iconUrl;
    }

    public final int component5() {
        return this.iconWidthDp;
    }

    public final int component6() {
        return this.iconHeightDp;
    }

    public final String component7() {
        return this.title;
    }

    public final boolean component8() {
        return this.titleBold;
    }

    public final String component9() {
        return this.subTitle;
    }

    public final CJStdDialogOptions copy(boolean r410, boolean r411, boolean r412, String r413, int r414, int r415, String r416, boolean r417, String r418, String r419, boolean r510, String r511, boolean r512, String r513, String r514, String r515, boolean r516, String r517, boolean r518, String r519, String r610, Long r611, Long r612, Long r613, Long r614, int r615, boolean r616, boolean r617, boolean r618, String r619, String r710, Long r711, Long r712, boolean r713, boolean r714, int r715, ICJStdDialogCallback r716) {
        Intrinsics.checkNotNullParameter(r416, "title");
        Intrinsics.checkNotNullParameter(r418, "subTitle");
        Intrinsics.checkNotNullParameter(r419, "content");
        Intrinsics.checkNotNullParameter(r511, "linkTitle");
        Intrinsics.checkNotNullParameter(r513, "inputHint");
        Intrinsics.checkNotNullParameter(r514, "inputTips");
        Intrinsics.checkNotNullParameter(r515, "agreementText");
        Intrinsics.checkNotNullParameter(r517, "checkText");
        Intrinsics.checkNotNullParameter(r519, "primaryBtnText");
        Intrinsics.checkNotNullParameter(r610, "secondaryBtnText");
        Intrinsics.checkNotNullParameter(r619, "primaryOpText");
        Intrinsics.checkNotNullParameter(r710, "secondaryOpText");
        return new CJStdDialogOptions(r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612, r613, r614, r615, r616, r617, r618, r619, r710, r711, r712, r713, r714, r715, r716);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CJStdDialogOptions) == true) goto L8;
        return false;
    L8:
        CJStdDialogOptions r101 = (CJStdDialogOptions) r100;
        if (this.isCancelable == r101.isCancelable) goto L12;
        return false;
    L12:
        if (this.isCanceledOnTouchOutside == r101.isCanceledOnTouchOutside) goto L15;
        return false;
    L15:
        if (this.showClose == r101.showClose) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.iconUrl, r101.iconUrl) == true) goto L21;
        return false;
    L21:
        if (this.iconWidthDp == r101.iconWidthDp) goto L24;
        return false;
    L24:
        if (this.iconHeightDp == r101.iconHeightDp) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L30;
        return false;
    L30:
        if (this.titleBold == r101.titleBold) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.subTitle, r101.subTitle) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L39;
        return false;
    L39:
        if (this.contentCenterHorizontal == r101.contentCenterHorizontal) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.linkTitle, r101.linkTitle) == true) goto L45;
        return false;
    L45:
        if (this.showInput == r101.showInput) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.inputHint, r101.inputHint) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.inputTips, r101.inputTips) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.agreementText, r101.agreementText) == true) goto L57;
        return false;
    L57:
        if (this.agreementChecked == r101.agreementChecked) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.checkText, r101.checkText) == true) goto L63;
        return false;
    L63:
        if (this.checkTextChecked == r101.checkTextChecked) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.primaryBtnText, r101.primaryBtnText) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.secondaryBtnText, r101.secondaryBtnText) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.primaryBtnTextColor, r101.primaryBtnTextColor) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.primaryBtnBgColor, r101.primaryBtnBgColor) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.secondaryBtnTextColor, r101.secondaryBtnTextColor) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.secondaryBtnBgColor, r101.secondaryBtnBgColor) == true) goto L84;
        return false;
    L84:
        if (this.buttonLayoutStyle == r101.buttonLayoutStyle) goto L87;
        return false;
    L87:
        if (this.useGradientBackground == r101.useGradientBackground) goto L90;
        return false;
    L90:
        if (this.allowDelayDismissPrimaryClick == r101.allowDelayDismissPrimaryClick) goto L93;
        return false;
    L93:
        if (this.primaryBtnLoading == r101.primaryBtnLoading) goto L96;
        return false;
    L96:
        if (Intrinsics.areEqual(this.primaryOpText, r101.primaryOpText) == true) goto L99;
        return false;
    L99:
        if (Intrinsics.areEqual(this.secondaryOpText, r101.secondaryOpText) == true) goto L102;
        return false;
    L102:
        if (Intrinsics.areEqual(this.primaryOpTextColor, r101.primaryOpTextColor) == true) goto L105;
        return false;
    L105:
        if (Intrinsics.areEqual(this.secondaryOpTextColor, r101.secondaryOpTextColor) == true) goto L108;
        return false;
    L108:
        if (this.primaryOpTextBold == r101.primaryOpTextBold) goto L111;
        return false;
    L111:
        if (this.secondaryOpTextBold == r101.secondaryOpTextBold) goto L114;
        return false;
    L114:
        if (this.primaryOpEnableDelay == r101.primaryOpEnableDelay) goto L117;
        return false;
    L117:
        if (Intrinsics.areEqual(this.callback, r101.callback) == true) goto L119;
        return false;
    L119:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.isCancelable == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.isCanceledOnTouchOutside == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.showClose == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        String r107 = this.iconUrl;
        int r108 = 0;
        if (r107 != null) goto L17;
        int r109 = 0;
    L18:
        int r110 = (((((((r106 + r109) * 31) + this.iconWidthDp) * 31) + this.iconHeightDp) * 31) + this.title.hashCode()) * 31;
        if (this.titleBold == false) goto L21;
        int r111 = 1231;
    L22:
        int r112 = (((((r110 + r111) * 31) + this.subTitle.hashCode()) * 31) + this.content.hashCode()) * 31;
        if (this.contentCenterHorizontal == false) goto L25;
        int r113 = 1231;
    L26:
        int r114 = (((r112 + r113) * 31) + this.linkTitle.hashCode()) * 31;
        if (this.showInput == false) goto L29;
        int r115 = 1231;
    L30:
        int r116 = (((((((r114 + r115) * 31) + this.inputHint.hashCode()) * 31) + this.inputTips.hashCode()) * 31) + this.agreementText.hashCode()) * 31;
        if (this.agreementChecked == false) goto L33;
        int r117 = 1231;
    L34:
        int r118 = (((r116 + r117) * 31) + this.checkText.hashCode()) * 31;
        if (this.checkTextChecked == false) goto L37;
        int r119 = 1231;
    L38:
        int r120 = (((((r118 + r119) * 31) + this.primaryBtnText.hashCode()) * 31) + this.secondaryBtnText.hashCode()) * 31;
        Long r121 = this.primaryBtnTextColor;
        if (r121 != null) goto L41;
        int r122 = 0;
    L42:
        int r123 = (r120 + r122) * 31;
        Long r124 = this.primaryBtnBgColor;
        if (r124 != null) goto L45;
        int r125 = 0;
    L46:
        int r126 = (r123 + r125) * 31;
        Long r127 = this.secondaryBtnTextColor;
        if (r127 != null) goto L49;
        int r128 = 0;
    L50:
        int r129 = (r126 + r128) * 31;
        Long r130 = this.secondaryBtnBgColor;
        if (r130 != null) goto L53;
        int r131 = 0;
    L54:
        int r132 = (((r129 + r131) * 31) + this.buttonLayoutStyle) * 31;
        if (this.useGradientBackground == false) goto L57;
        int r133 = 1231;
    L58:
        int r134 = (r132 + r133) * 31;
        if (this.allowDelayDismissPrimaryClick == false) goto L61;
        int r135 = 1231;
    L62:
        int r136 = (r134 + r135) * 31;
        if (this.primaryBtnLoading == false) goto L65;
        int r137 = 1231;
    L66:
        int r138 = (((((r136 + r137) * 31) + this.primaryOpText.hashCode()) * 31) + this.secondaryOpText.hashCode()) * 31;
        Long r139 = this.primaryOpTextColor;
        if (r139 != null) goto L69;
        int r140 = 0;
    L70:
        int r141 = (r138 + r140) * 31;
        Long r142 = this.secondaryOpTextColor;
        if (r142 != null) goto L73;
        int r143 = 0;
    L74:
        int r144 = (r141 + r143) * 31;
        if (this.primaryOpTextBold == false) goto L77;
        int r145 = 1231;
    L78:
        int r146 = (r144 + r145) * 31;
        if (this.secondaryOpTextBold == true) goto L82;
        r100 = 1237;
    L82:
        int r147 = (((r146 + r100) * 31) + this.primaryOpEnableDelay) * 31;
        ICJStdDialogCallback r148 = this.callback;
        if (r148 == null) goto L87;
        r108 = r148.hashCode();
    L87:
        return r147 + r108;
    L77:
        r145 = 1237;
        goto L78
    L73:
        r143 = r142.hashCode();
        goto L74
    L69:
        r140 = r139.hashCode();
        goto L70
    L65:
        r137 = 1237;
        goto L66
    L61:
        r135 = 1237;
        goto L62
    L57:
        r133 = 1237;
        goto L58
    L53:
        r131 = r130.hashCode();
        goto L54
    L49:
        r128 = r127.hashCode();
        goto L50
    L45:
        r125 = r124.hashCode();
        goto L46
    L41:
        r122 = r121.hashCode();
        goto L42
    L37:
        r119 = 1237;
        goto L38
    L33:
        r117 = 1237;
        goto L34
    L29:
        r115 = 1237;
        goto L30
    L25:
        r113 = 1237;
        goto L26
    L21:
        r111 = 1237;
        goto L22
    L17:
        r109 = r107.hashCode();
        goto L18
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "CJStdDialogOptions(isCancelable=" + this.isCancelable + ", isCanceledOnTouchOutside=" + this.isCanceledOnTouchOutside + ", showClose=" + this.showClose + ", iconUrl=" + this.iconUrl + ", iconWidthDp=" + this.iconWidthDp + ", iconHeightDp=" + this.iconHeightDp + ", title=" + this.title + ", titleBold=" + this.titleBold + ", subTitle=" + this.subTitle + ", content=" + this.content + ", contentCenterHorizontal=" + this.contentCenterHorizontal + ", linkTitle=" + this.linkTitle + ", showInput=" + this.showInput + ", inputHint=" + this.inputHint + ", inputTips=" + this.inputTips + ", agreementText=" + this.agreementText + ", agreementChecked=" + this.agreementChecked + ", checkText=" + this.checkText + ", checkTextChecked=" + this.checkTextChecked + ", primaryBtnText=" + this.primaryBtnText + ", secondaryBtnText=" + this.secondaryBtnText + ", primaryBtnTextColor=" + this.primaryBtnTextColor + ", primaryBtnBgColor=" + this.primaryBtnBgColor + ", secondaryBtnTextColor=" + this.secondaryBtnTextColor + ", secondaryBtnBgColor=" + this.secondaryBtnBgColor + ", buttonLayoutStyle=" + this.buttonLayoutStyle + ", useGradientBackground=" + this.useGradientBackground + ", allowDelayDismissPrimaryClick=" + this.allowDelayDismissPrimaryClick + ", primaryBtnLoading=" + this.primaryBtnLoading + ", primaryOpText=" + this.primaryOpText + ", secondaryOpText=" + this.secondaryOpText + ", primaryOpTextColor=" + this.primaryOpTextColor + ", secondaryOpTextColor=" + this.secondaryOpTextColor + ", primaryOpTextBold=" + this.primaryOpTextBold + ", secondaryOpTextBold=" + this.secondaryOpTextBold + ", primaryOpEnableDelay=" + this.primaryOpEnableDelay + ", callback=" + this.callback + ')';
    }

    public final boolean getAgreementChecked() {
        return this.agreementChecked;
    }

    public final String getAgreementText() {
        return this.agreementText;
    }

    public final boolean getAllowDelayDismissPrimaryClick() {
        return this.allowDelayDismissPrimaryClick;
    }

    public final int getButtonLayoutStyle() {
        return this.buttonLayoutStyle;
    }

    public final ICJStdDialogCallback getCallback() {
        return this.callback;
    }

    public final String getCheckText() {
        return this.checkText;
    }

    public final boolean getCheckTextChecked() {
        return this.checkTextChecked;
    }

    public final String getContent() {
        return this.content;
    }

    public final boolean getContentCenterHorizontal() {
        return this.contentCenterHorizontal;
    }

    public final int getIconHeightDp() {
        return this.iconHeightDp;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final int getIconWidthDp() {
        return this.iconWidthDp;
    }

    public final String getInputHint() {
        return this.inputHint;
    }

    public final String getInputTips() {
        return this.inputTips;
    }

    public final String getLinkTitle() {
        return this.linkTitle;
    }

    public final Long getPrimaryBtnBgColor() {
        return this.primaryBtnBgColor;
    }

    public final boolean getPrimaryBtnLoading() {
        return this.primaryBtnLoading;
    }

    public final String getPrimaryBtnText() {
        return this.primaryBtnText;
    }

    public final Long getPrimaryBtnTextColor() {
        return this.primaryBtnTextColor;
    }

    public final int getPrimaryOpEnableDelay() {
        return this.primaryOpEnableDelay;
    }

    public final String getPrimaryOpText() {
        return this.primaryOpText;
    }

    public final boolean getPrimaryOpTextBold() {
        return this.primaryOpTextBold;
    }

    public final Long getPrimaryOpTextColor() {
        return this.primaryOpTextColor;
    }

    public final Long getSecondaryBtnBgColor() {
        return this.secondaryBtnBgColor;
    }

    public final String getSecondaryBtnText() {
        return this.secondaryBtnText;
    }

    public final Long getSecondaryBtnTextColor() {
        return this.secondaryBtnTextColor;
    }

    public final String getSecondaryOpText() {
        return this.secondaryOpText;
    }

    public final boolean getSecondaryOpTextBold() {
        return this.secondaryOpTextBold;
    }

    public final Long getSecondaryOpTextColor() {
        return this.secondaryOpTextColor;
    }

    public final boolean getShowClose() {
        return this.showClose;
    }

    public final boolean getShowInput() {
        return this.showInput;
    }

    public final String getSubTitle() {
        return this.subTitle;
    }

    public final String getTitle() {
        return this.title;
    }

    public final boolean getTitleBold() {
        return this.titleBold;
    }

    public final boolean getUseGradientBackground() {
        return this.useGradientBackground;
    }

    public final boolean isCancelable() {
        return this.isCancelable;
    }

    public final boolean isCanceledOnTouchOutside() {
        return this.isCanceledOnTouchOutside;
    }

    public final void setCallback(ICJStdDialogCallback r100) {
        this.callback = r100;
    }

    public CJStdDialogOptions(boolean r110, boolean r111, boolean r112, String r113, int r114, int r210, String r211, boolean r212, String r213, String r214, boolean r215, String r216, boolean r217, String r218, String r219, String r310, boolean r311, String r312, boolean r313, String r314, String r315, Long r316, Long r317, Long r318, Long r319, int r410, boolean r411, boolean r412, boolean r413, String r414, String r415, Long r416, Long r417, boolean r418, boolean r419, int r510, ICJStdDialogCallback r511) {
        Intrinsics.checkNotNullParameter(r211, "title");
        Intrinsics.checkNotNullParameter(r213, "subTitle");
        Intrinsics.checkNotNullParameter(r214, "content");
        Intrinsics.checkNotNullParameter(r216, "linkTitle");
        Intrinsics.checkNotNullParameter(r218, "inputHint");
        Intrinsics.checkNotNullParameter(r219, "inputTips");
        Intrinsics.checkNotNullParameter(r310, "agreementText");
        Intrinsics.checkNotNullParameter(r312, "checkText");
        Intrinsics.checkNotNullParameter(r314, "primaryBtnText");
        Intrinsics.checkNotNullParameter(r315, "secondaryBtnText");
        Intrinsics.checkNotNullParameter(r414, "primaryOpText");
        Intrinsics.checkNotNullParameter(r415, "secondaryOpText");
        this.isCancelable = r110;
        this.isCanceledOnTouchOutside = r111;
        this.showClose = r112;
        this.iconUrl = r113;
        this.iconWidthDp = r114;
        this.iconHeightDp = r210;
        this.title = r211;
        this.titleBold = r212;
        this.subTitle = r213;
        this.content = r214;
        this.contentCenterHorizontal = r215;
        this.linkTitle = r216;
        this.showInput = r217;
        this.inputHint = r218;
        this.inputTips = r219;
        this.agreementText = r310;
        this.agreementChecked = r311;
        this.checkText = r312;
        this.checkTextChecked = r313;
        this.primaryBtnText = r314;
        this.secondaryBtnText = r315;
        this.primaryBtnTextColor = r316;
        this.primaryBtnBgColor = r317;
        this.secondaryBtnTextColor = r318;
        this.secondaryBtnBgColor = r319;
        this.buttonLayoutStyle = r410;
        this.useGradientBackground = r411;
        this.allowDelayDismissPrimaryClick = r412;
        this.primaryBtnLoading = r413;
        this.primaryOpText = r414;
        this.secondaryOpText = r415;
        this.primaryOpTextColor = r416;
        this.secondaryOpTextColor = r417;
        this.primaryOpTextBold = r418;
        this.secondaryOpTextBold = r419;
        this.primaryOpEnableDelay = r510;
        this.callback = r511;
    }

    public /* synthetic */ CJStdDialogOptions(boolean r310, boolean r311, boolean r410, String r411, int r412, int r413, String r414, boolean r415, String r416, String r417, boolean r418, String r419, boolean r510, String r511, String r512, String r513, boolean r514, String r515, boolean r516, String r517, String r518, Long r519, Long r610, Long r611, Long r612, int r613, boolean r614, boolean r615, boolean r616, String r617, String r618, Long r619, Long r710, boolean r711, boolean r712, int r713, ICJStdDialogCallback r714, int r715, int r716, DefaultConstructorMarker r717) {
        if ((r715 & 1) == 0) goto L5;
        boolean r100 = false;
    L7:
        if ((r715 & 2) == 0) goto L9;
        boolean r101 = false;
    L11:
        if ((r715 & 4) == 0) goto L13;
        boolean r102 = false;
    L15:
        if ((r715 & 8) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r715 & 16) == 0) goto L21;
        int r104 = 0;
    L23:
        if ((r715 & 32) == 0) goto L25;
        int r105 = 0;
    L27:
        if ((r715 & 64) == 0) goto L29;
        String r106 = "";
    L31:
        if ((r715 & 128) == 0) goto L33;
        boolean r110 = false;
    L35:
        if ((r715 & 256) == 0) goto L37;
        String r111 = "";
    L39:
        if ((r715 & 512) == 0) goto L41;
        String r112 = "";
    L43:
        if ((r715 & 1024) == 0) goto L45;
        boolean r113 = true;
    L47:
        if ((r715 & 2048) == 0) goto L49;
        String r114 = "";
    L51:
        if ((r715 & 4096) == 0) goto L53;
        boolean r107 = false;
    L55:
        if ((r715 & 8192) == 0) goto L57;
        String r108 = "";
    L59:
        if ((r715 & 16384) == 0) goto L61;
        String r115 = "";
    L63:
        if ((r715 & 32768) == 0) goto L65;
        String r116 = "";
    L67:
        if ((r715 & 65536) == 0) goto L69;
        boolean r117 = false;
    L71:
        if ((r715 & 131072) == 0) goto L73;
        String r118 = "";
    L75:
        if ((r715 & 262144) == 0) goto L77;
        boolean r119 = false;
    L79:
        if ((r715 & 524288) == 0) goto L81;
        String r210 = "";
    L83:
        if ((r715 & 1048576) == 0) goto L85;
        String r211 = "";
    L87:
        if ((r715 & 2097152) == 0) goto L89;
        Long r212 = null;
    L91:
        if ((r715 & 4194304) == 0) goto L93;
        Long r213 = null;
    L95:
        if ((r715 & 8388608) == 0) goto L97;
        Long r214 = null;
    L99:
        if ((r715 & 16777216) == 0) goto L101;
        Long r215 = null;
    L103:
        if ((r715 & 33554432) == 0) goto L105;
        int r216 = 0;
    L107:
        if ((r715 & 67108864) == 0) goto L109;
        boolean r217 = false;
    L111:
        if ((r715 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        boolean r218 = false;
    L115:
        if ((r715 & 268435456) == 0) goto L117;
        boolean r219 = false;
    L119:
        if ((r715 & 536870912) == 0) goto L121;
        String r312 = "";
    L123:
        if ((r715 & 1073741824) == 0) goto L125;
        String r313 = "";
    L127:
        if ((r715 & Integer.MIN_VALUE) == 0) goto L129;
        Long r109 = null;
    L131:
        if ((r716 & 1) == 0) goto L133;
        Long r314 = null;
    L135:
        if ((r716 & 2) == 0) goto L137;
        boolean r315 = false;
    L139:
        if ((r716 & 4) == 0) goto L141;
        boolean r316 = false;
    L143:
        if ((r716 & 8) == 0) goto L145;
        int r317 = 0;
    L147:
        if ((r716 & 16) == 0) goto L149;
        ICJStdDialogCallback r318 = null;
    L150:
        this(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r107, r108, r115, r116, r117, r118, r119, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r312, r313, r109, r314, r315, r316, r317, r318);
        return;
    L149:
        r318 = r714;
        goto L150
    L145:
        r317 = r713;
        goto L147
    L141:
        r316 = r712;
        goto L143
    L137:
        r315 = r711;
        goto L139
    L133:
        r314 = r710;
        goto L135
    L129:
        r109 = r619;
        goto L131
    L125:
        r313 = r618;
        goto L127
    L121:
        r312 = r617;
        goto L123
    L117:
        r219 = r616;
        goto L119
    L113:
        r218 = r615;
        goto L115
    L109:
        r217 = r614;
        goto L111
    L105:
        r216 = r613;
        goto L107
    L101:
        r215 = r612;
        goto L103
    L97:
        r214 = r611;
        goto L99
    L93:
        r213 = r610;
        goto L95
    L89:
        r212 = r519;
        goto L91
    L85:
        r211 = r518;
        goto L87
    L81:
        r210 = r517;
        goto L83
    L77:
        r119 = r516;
        goto L79
    L73:
        r118 = r515;
        goto L75
    L69:
        r117 = r514;
        goto L71
    L65:
        r116 = r513;
        goto L67
    L61:
        r115 = r512;
        goto L63
    L57:
        r108 = r511;
        goto L59
    L53:
        r107 = r510;
        goto L55
    L49:
        r114 = r419;
        goto L51
    L45:
        r113 = r418;
        goto L47
    L41:
        r112 = r417;
        goto L43
    L37:
        r111 = r416;
        goto L39
    L33:
        r110 = r415;
        goto L35
    L29:
        r106 = r414;
        goto L31
    L25:
        r105 = r413;
        goto L27
    L21:
        r104 = r412;
        goto L23
    L17:
        r103 = r411;
        goto L19
    L13:
        r102 = r410;
        goto L15
    L9:
        r101 = r311;
        goto L11
    L5:
        r100 = r310;
        goto L7
    }
}
