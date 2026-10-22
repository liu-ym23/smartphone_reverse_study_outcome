package q2;

import android.util.SparseArray;
import com.stepos.familyguard.R;
import com.stepos.policy.sdk.bean.PolicyBasicListVO;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: j, reason: collision with root package name */
    private static final SparseArray<l> f19922j;

    /* renamed from: k, reason: collision with root package name */
    private static final int[] f19923k;

    /* renamed from: l, reason: collision with root package name */
    private static final int[] f19924l = {R.string.fg_role_wife, R.string.fg_role_husband, R.string.fg_role_father, R.string.fg_role_mother, R.string.fg_role_other_male, R.string.fg_role_other_female, R.string.fg_role_son, R.string.fg_role_daughter, R.string.fg_role_qihoo_son, R.string.fg_role_qihoo_daughter};

    /* renamed from: a, reason: collision with root package name */
    public final int f19925a;

    /* renamed from: b, reason: collision with root package name */
    public final int f19926b;

    /* renamed from: c, reason: collision with root package name */
    public final int[] f19927c;

    /* renamed from: d, reason: collision with root package name */
    public final int f19928d;

    /* renamed from: e, reason: collision with root package name */
    public final int f19929e;

    /* renamed from: f, reason: collision with root package name */
    public final int f19930f;

    /* renamed from: g, reason: collision with root package name */
    public final int f19931g;

    /* renamed from: h, reason: collision with root package name */
    public final int f19932h;

    /* renamed from: i, reason: collision with root package name */
    public final int f19933i;

    static {
        int[] iArr = {1, 2, 3, 4, 99, 100, 51, 52, 61, 62};
        f19923k = iArr;
        int[] iArr2 = {R.string.fg_common_he, R.string.fg_common_him, R.string.fg_common_his};
        int[] iArr3 = {R.string.fg_common_she, R.string.fg_common_her, R.string.fg_common_her2};
        int[][] iArr4 = {iArr3, iArr2, iArr2, iArr3, iArr2, iArr3, iArr2, iArr3, iArr2, iArr3};
        int[] iArr5 = {R.color.fg_role_wife_end, R.color.fg_role_husband_end, R.color.fg_role_father_end, R.color.fg_role_mother_end, R.color.fg_role_other_male_end, R.color.fg_role_other_female_end, R.color.fg_role_son_end, R.color.fg_role_daughter_end, R.color.fg_role_son_end, R.color.fg_role_daughter_end};
        int[] iArr6 = {R.drawable.fg_role_gradient_wife, R.drawable.fg_role_gradient_husband, R.drawable.fg_role_gradient_father, R.drawable.fg_role_gradient_mother, R.drawable.fg_role_gradient_other_male, R.drawable.fg_role_gradient_other_female, R.drawable.fg_role_gradient_son, R.drawable.fg_role_gradient_daughter, R.drawable.fg_role_gradient_son, R.drawable.fg_role_gradient_daughter};
        int[] iArr7 = {R.drawable.fg_role_thumb_wife, R.drawable.fg_role_thumb_husband, R.drawable.fg_role_thumb_father, R.drawable.fg_role_thumb_mother, R.drawable.fg_role_thumb_other_male, R.drawable.fg_role_thumb_other_female, R.drawable.fg_role_thumb_son, R.drawable.fg_role_thumb_daughter, R.drawable.fg_role_thumb_son, R.drawable.fg_role_thumb_daughter};
        int[] iArr8 = {R.drawable.fg_role_drawable_wife, R.drawable.fg_role_drawable_husband, R.drawable.fg_role_drawable_father, R.drawable.fg_role_drawable_mother, R.drawable.fg_role_drawable_other_male, R.drawable.fg_role_drawable_other_female, R.drawable.fg_role_drawable_son, R.drawable.fg_role_drawable_daughter, R.drawable.fg_role_drawable_son, R.drawable.fg_role_drawable_daughter};
        int[] iArr9 = {R.drawable.fg_ad_adult, R.drawable.fg_ad_adult, R.drawable.fg_ad_adult, R.drawable.fg_ad_adult, R.drawable.fg_ad_adult, R.drawable.fg_ad_adult, R.drawable.fg_ad_child, R.drawable.fg_ad_child, R.drawable.fg_ad_child, R.drawable.fg_ad_child};
        int[] iArr10 = {R.drawable.fg_role_card_wife, R.drawable.fg_role_card_husband, R.drawable.fg_role_card_father, R.drawable.fg_role_card_mother, R.drawable.fg_role_card_other_male, R.drawable.fg_role_card_other_female, R.drawable.fg_role_card_son, R.drawable.fg_role_card_daughter, R.drawable.fg_role_card_son, R.drawable.fg_role_card_daughter};
        f19922j = new SparseArray<>(iArr.length);
        for (int length = iArr.length - 1; length >= 0; length--) {
            SparseArray<l> sparseArray = f19922j;
            int i5 = f19923k[length];
            sparseArray.append(i5, new l(i5, f19924l[length], iArr4[length], iArr5[length], iArr6[length], iArr7[length], iArr8[length], iArr9[length], iArr10[length]));
        }
    }

    private l(int i5, int i6, int[] iArr, int i7, int i8, int i9, int i10, int i11, int i12) {
        this.f19925a = i5;
        this.f19926b = i6;
        this.f19927c = iArr;
        this.f19928d = i7;
        this.f19929e = i8;
        this.f19930f = i9;
        this.f19931g = i10;
        this.f19932h = i11;
        this.f19933i = i12;
    }

    public static l a(int i5) {
        switch (i5) {
            case 5:
            case 7:
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_BUTTON /* 9 */:
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT /* 11 */:
                i5 = 99;
                break;
            case 6:
            case 8:
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_LINK /* 10 */:
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER /* 12 */:
                i5 = 100;
                break;
        }
        SparseArray<l> sparseArray = f19922j;
        l lVar = sparseArray.get(i5);
        return lVar == null ? sparseArray.get(99) : lVar;
    }

    public static boolean b(int i5) {
        return i5 == 51 || i5 == 52 || i5 == 61 || i5 == 62;
    }
}
