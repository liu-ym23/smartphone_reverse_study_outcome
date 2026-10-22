package com.tmall.wireless.tangram.dataparser.concrete;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tmall.wireless.tangram.MVHelper;
import com.tmall.wireless.tangram.core.service.ServiceManager;
import com.tmall.wireless.tangram.dataparser.DataParser;
import com.tmall.wireless.tangram.structure.BaseCell;
import com.tmall.wireless.tangram.structure.card.SlideCard;
import com.tmall.wireless.tangram.structure.entitycard.BannerEntityCard;
import com.tmall.wireless.tangram.structure.entitycard.EntityCard;
import com.tmall.wireless.tangram.structure.entitycard.GridEntityCard;
import com.tmall.wireless.tangram.util.LogUtils;
import com.tmall.wireless.tangram.util.Preconditions;
import com.tmall.wireless.tangram.util.Utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class PojoDataParser extends DataParser<JSONArray, Card, BaseCell> {
    private static final String TAG = "PojoDataParser";

    public PojoDataParser() {
    }

    public BaseCell createCell(@NonNull MVHelper r10, @Nullable JSONObject r11, ServiceManager r12) {
        if (r11 == null) goto L38;
        int r13 = r11.optInt("type", -1);
        if (Utils.isCellizedCard(r11) == false) goto L7;
        r13 = Utils.cellizeCard(r13);
    L7:
        if (r10 == null) goto L38;
        if (r10.resolver().getViewClass(r13) == null) goto L38;
        if (r10.resolver().isCompatibleType(r13) == false) goto L17;
        BaseCell r14 = (BaseCell) Utils.newInstance(r10.resolver().getCellClass(r13));
        if (r14 != null) goto L15;
        return null;
    L15:
        r14.serviceManager = r12;
    L36:
        r10.parseCell(r10, r14, r11);
        r14.type = r13;
        return r14;
    L17:
        if (Utils.isCellizedCard(r11) == false) goto L35;
        int r15 = Utils.cardizeCell(r13);
        if (r15 != 1) goto L21;
    L33:
        BaseCell r16 = new GridEntityCard(r13);
    L31:
        r14 = r16;
        r14.serviceManager = r12;
        goto L36
    L21:
        if (r15 == 2) goto L33;
        if (r15 == 3) goto L33;
        if (r15 == 4) goto L33;
        if (r15 == 9) goto L33;
        if (r15 == 10) goto L32;
        r16 = new EntityCard(r13);
        goto L31
    L32:
        r16 = new BannerEntityCard();
        goto L31
    L35:
        r14 = new BaseCell(r13);
        r14.serviceManager = r12;
    L38:
        return null;
    }

    @Override // com.tmall.wireless.tangram.dataparser.DataParser
    @Nullable
    public /* bridge */ /* synthetic */ List<BaseCell> parseComponent(JSONArray r10, ServiceManager r11) {
        return parseComponent2(r10, r11);
    }

    @Override // com.tmall.wireless.tangram.dataparser.DataParser
    public /* bridge */ /* synthetic */ List<Card> parseGroup(JSONArray r10, ServiceManager r11) {
        return parseGroup2(r10, r11);
    }

    @Nullable
    /* JADX INFO: renamed from: parseComponent, reason: avoid collision after fix types in other method */
    public List<BaseCell> parseComponent2(JSONArray r10, ServiceManager r11) {
        return parseComponent(r10, r11, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: parseGroup, reason: avoid collision after fix types in other method */
    public List<Card> parseGroup2(JSONArray r10, final ServiceManager r11) {
        if (r10 == null) goto L41;
        if (r11 == null) goto L41;
        final CardResolver r12 = (CardResolver) r11.getService(CardResolver.class);
        int r13 = 0;
        boolean r14 = true;
        if (r12 == null) goto L8;
        boolean r15 = true;
    L9:
        Preconditions.checkState(r15, "Must register CardResolver into ServiceManager first");
        MVHelper r16 = (MVHelper) r11.getService(MVHelper.class);
        if (r16 != null) goto L13;
        r14 = false;
    L13:
        Preconditions.checkState(r14, "Must register CellResolver into ServiceManager first");
        int r17 = r10.length();
        ArrayList r18 = new ArrayList(r17);
    L14:
        if (r13 >= r17) goto L38;
        JSONObject r19 = r10.optJSONObject(r13);
        if (r19 == null) goto L37;
        int r20 = r19.optInt("type", -1);
        if (r20 < 0) goto L36;
        final Card r21 = r12.create(r20);
        if (r21 == 0) goto L35;
        r21.rowId = r13;
        r21.serviceManager = r11;
        r21.parseWith(r19, r16);
        r21.type = r20;
        if (r21.isValid() == false) goto L37;
        if ((r21 instanceof IDelegateCard) == false) goto L32;
        Iterator<Card> r22 = ((IDelegateCard) r21).getCards(new AnonymousClass1(this, r12, r11, r21)).iterator();
    L27:
        if (r22.hasNext() == false) goto L37;
        Card r23 = r22.next();
        if (r23.isValid() == false) goto L27;
        r18.add(r23);
        goto L27
    L32:
        if (r21.style.slidable == false) goto L34;
        r18.add(new SlideCard(r21));
        goto L37
    L34:
        r18.add(r21);
        goto L37
    L35:
        LogUtils.w(TAG, "Can not generate cardType: " + r20);
        goto L37
    L36:
        LogUtils.w(TAG, "Invalid card type when parse JSON data");
    L37:
        r13 = r13 + 1;
        goto L14
    L38:
        r16.resolver().setCards(r18);
        return r18;
    L8:
        r15 = false;
    L41:
        return new ArrayList();
    }

    @Nullable
    public List<BaseCell> parseComponent(JSONArray r10, ServiceManager r11, Card r12) {
        if (r10 == null) goto L4;
        int r13 = 0;
        boolean r14 = true;
        if (((CardResolver) r11.getService(CardResolver.class)) == null) goto L8;
        boolean r15 = true;
    L9:
        Preconditions.checkState(r15, "Must register CardResolver into ServiceManager first");
        MVHelper r16 = (MVHelper) r11.getService(MVHelper.class);
        if (r16 != null) goto L13;
        r14 = false;
    L13:
        Preconditions.checkState(r14, "Must register CellResolver into ServiceManager first");
        ArrayList r17 = new ArrayList(r10.length());
        int r18 = r10.length();
    L14:
        if (r13 >= r18) goto L21;
        BaseCell r19 = createCell(r16, r10.optJSONObject(r13), r11);
        if (r19 == null) goto L20;
        if (r16.isValid(r19, r11) == false) goto L20;
        r17.add(r19);
    L20:
        r13 = r13 + 1;
        goto L14
    L21:
        return r17;
    L8:
        r15 = false;
        goto L9
    L4:
        return new ArrayList();
    }
}
