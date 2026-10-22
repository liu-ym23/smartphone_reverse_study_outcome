package com.tmall.wireless.tangram.structure.card;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tmall.wireless.tangram.MVHelper;
import com.tmall.wireless.tangram.core.service.ServiceManager;
import com.tmall.wireless.tangram.dataparser.concrete.Card;
import com.tmall.wireless.tangram.dataparser.concrete.CardResolver;
import com.tmall.wireless.tangram.dataparser.concrete.Cell;
import com.tmall.wireless.tangram.dataparser.concrete.IDelegateCard;
import com.tmall.wireless.tangram.dataparser.concrete.Style;
import com.tmall.wireless.tangram.dataparser.concrete.WrapperCard;
import com.tmall.wireless.tangram.structure.BaseCell;
import com.tmall.wireless.tangram.structure.style.DelegateStyle;
import com.tmall.wireless.tangram.support.async.CardLoadSupport;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class FusionCard extends Card implements IDelegateCard {

    public static class FusionContentCard extends WrapperCard implements SwipeCard {

        @Nullable
        private SwitchTabHeaderCell mHeaderCell;
        private final int mIndex;

        public FusionContentCard(@NonNull Card r10, @Nullable SwitchTabHeaderCell r11, int r12) {
            super(r10);
            this.mHeaderCell = r11;
            this.mIndex = r12;
        }

        @Override // com.tmall.wireless.tangram.structure.card.SwipeCard
        public int getCurrentIndex() {
            return this.mIndex;
        }

        @Override // com.tmall.wireless.tangram.structure.card.SwipeCard
        public int getTotalPage() {
            SwitchTabHeaderCell r10 = this.mHeaderCell;
            if (r10 != null) goto L5;
            return 0;
        L5:
            return r10.getTotalPage();
        }

        @Override // com.tmall.wireless.tangram.structure.card.SwipeCard
        public void switchTo(int r10) {
            SwitchTabHeaderCell r11 = this.mHeaderCell;
            if (r11 == null) goto L6;
            r11.switchTo(r10);
            return;
        }
    }

    public static final class IndexCache {
        Card card;
        int index;

        public IndexCache(int r10, Card r11) {
            this.index = r10;
            this.card = r11;
        }
    }

    public interface SwitchTabHeaderCell {
        int getTotalPage();

        void setSwitchTabTrigger(SwitchTabTrigger r10);

        void switchTo(int r10);
    }

    public interface SwitchTabTrigger {
        void invalidate(int r10);

        void switchTo(int r10, @NonNull Cell r11, @Nullable Map<String, Object> r12);

        void switchTo(int r10, String r11, @NonNull Cell r12, @Nullable Map<String, Object> r13);
    }

    public interface ViewFactory {
        View create();

        int getDefaultHeight();
    }

    public FusionCard() {
    }

    public static /* synthetic */ ServiceManager access$000(FusionCard r10) {
        return r10.serviceManager;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tmall.wireless.tangram.dataparser.concrete.IDelegateCard
    public List<Card> getCards(final CardResolver r17) {
        ServiceManager r10 = this.serviceManager;
        if (r10 == null) goto L5;
        final CardLoadSupport r11 = (CardLoadSupport) r10.getService(CardLoadSupport.class);
        final MVHelper r12 = (MVHelper) this.serviceManager.getService(MVHelper.class);
        final ViewFactory r13 = (ViewFactory) this.serviceManager.getService(ViewFactory.class);
        if (r11 == null) goto L47;
        if (r12 == null) goto L47;
        if (r17 == null) goto L47;
        Style r14 = this.style;
        if ((r14 instanceof DelegateStyle) == false) goto L45;
        DelegateStyle r15 = (DelegateStyle) r14;
        Card r16 = r17.create(1);
        BaseCell r18 = new BaseCell(0);
        Style r19 = r18.style;
        if (r19 == null) goto L16;
        r19.height = 0;
    L16:
        r16.addCell(r18);
        final Card r110 = r17.create(21);
        BaseCell r20 = this.mCells.get(0);
        this.mCells.remove(0);
        r110.f18212id = this.f18212id + "-tabheader";
        r110.addCell(r20);
        final DelegateStyle.CardInfo r21 = r15.cardInfos.get(0);
        final int r22 = r21.type;
        Card r23 = r17.create(r22);
        r23.type = r21.type;
        r23.f18212id = this.f18212id;
        r23.parseWith(r21.data, r12);
        boolean r24 = r20 instanceof SwitchTabHeaderCell;
        if (r24 == false) goto L19;
        SwitchTabHeaderCell r25 = (SwitchTabHeaderCell) r20;
    L20:
        final Card r111 = new FusionContentCard(r23, r25, 0);
        if (r13 == null) goto L26;
        View r26 = r13.create();
        int r27 = r13.getDefaultHeight();
        if (r26 == null) goto L26;
        if (r27 <= 0) goto L26;
        r111.enablePlaceholderView(r26, r27);
    L26:
        r111.loadMore = true;
        r111.hasMore = true;
        if (TextUtils.isEmpty(r111.load) == false) goto L30;
        r111.load = this.load;
    L30:
        if (TextUtils.isEmpty(r111.load) == false) goto L34;
        return Collections.emptyList();
    L34:
        if (this.mCells.size() <= 0) goto L37;
        r111.addCells(this.mCells);
    L37:
        if (this.mPendingCells.size() <= 0) goto L39;
        r111.addCells(this.mPendingCells);
    L39:
        if (r24 == false) goto L43;
        final SwitchTabHeaderCell r28 = (SwitchTabHeaderCell) r20;
        r28.setSwitchTabTrigger(new AnonymousClass1(this, r111, r17, r22, r21, r12, r28, r13, r110, r11));
        return Arrays.asList(new Card[]{r16, r110, r111});
    L43:
        return Collections.emptyList();
    L19:
        r25 = null;
        goto L20
    L45:
        return Collections.emptyList();
    L47:
        return Collections.emptyList();
    L5:
        return Collections.emptyList();
    }

    @Override // com.tmall.wireless.tangram.dataparser.concrete.Card
    public boolean isValid() {
        if (super.isValid() == true) goto L5;
    L11:
        return false;
    L5:
        if (this.mCells.size() <= 0) goto L11;
        Style r10 = this.style;
        if ((r10 instanceof DelegateStyle) == false) goto L11;
        if (((DelegateStyle) r10).cardInfos.size() <= 0) goto L11;
        return true;
    }

    @Override // com.tmall.wireless.tangram.dataparser.concrete.Card
    public void parseStyle(JSONObject r10) {
        DelegateStyle r11 = new DelegateStyle();
        this.style = r11;
        if (r10 == null) goto L12;
        r11.parseWith(r10);
        Iterator<DelegateStyle.CardInfo> r12 = ((DelegateStyle) this.style).cardInfos.iterator();
    L6:
        if (r12.hasNext() == false) goto L19;
        DelegateStyle.CardInfo r13 = r12.next();
        r13.data.put(Card.KEY_API_LOAD, this.load);     // Catch: JSONException -> L10
        r13.data.put("loadMore", this.loadMore);     // Catch: JSONException -> L10
        r13.data.put(Card.KEY_HAS_MORE, this.hasMore);     // Catch: JSONException -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L6
    L19:
        return;
    }

    @Override // com.tmall.wireless.tangram.dataparser.concrete.Card
    public void parseWith(@NonNull JSONObject r10, @NonNull MVHelper r11) {
        super.parseWith(r10, r11);
    }
}
