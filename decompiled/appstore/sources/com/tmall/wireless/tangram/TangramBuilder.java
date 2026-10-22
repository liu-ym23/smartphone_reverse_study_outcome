package com.tmall.wireless.tangram;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.tmall.wireless.tangram.dataparser.IAdapterBuilder;
import com.tmall.wireless.tangram.dataparser.concrete.BaseCardBinderResolver;
import com.tmall.wireless.tangram.dataparser.concrete.BaseCellBinderResolver;
import com.tmall.wireless.tangram.dataparser.concrete.Card;
import com.tmall.wireless.tangram.dataparser.concrete.CardResolver;
import com.tmall.wireless.tangram.dataparser.concrete.PojoAdapterBuilder;
import com.tmall.wireless.tangram.dataparser.concrete.PojoDataParser;
import com.tmall.wireless.tangram.eventbus.BusSupport;
import com.tmall.wireless.tangram.structure.BaseCell;
import com.tmall.wireless.tangram.structure.card.BannerCard;
import com.tmall.wireless.tangram.structure.card.ColumnCard;
import com.tmall.wireless.tangram.structure.card.DoubleColumnCard;
import com.tmall.wireless.tangram.structure.card.FiveColumnCard;
import com.tmall.wireless.tangram.structure.card.FixCard;
import com.tmall.wireless.tangram.structure.card.FixLinearScrollCard;
import com.tmall.wireless.tangram.structure.card.FloatCard;
import com.tmall.wireless.tangram.structure.card.FlowCard;
import com.tmall.wireless.tangram.structure.card.FourColumnCard;
import com.tmall.wireless.tangram.structure.card.FusionCard;
import com.tmall.wireless.tangram.structure.card.GridCard;
import com.tmall.wireless.tangram.structure.card.LinearCard;
import com.tmall.wireless.tangram.structure.card.LinearScrollCard;
import com.tmall.wireless.tangram.structure.card.OnePlusNCard;
import com.tmall.wireless.tangram.structure.card.PinBottomCard;
import com.tmall.wireless.tangram.structure.card.PinTopCard;
import com.tmall.wireless.tangram.structure.card.ScrollFixCard;
import com.tmall.wireless.tangram.structure.card.SingleColumnCard;
import com.tmall.wireless.tangram.structure.card.StaggeredCard;
import com.tmall.wireless.tangram.structure.card.StickyCard;
import com.tmall.wireless.tangram.structure.card.StickyEndCard;
import com.tmall.wireless.tangram.structure.card.TripleColumnCard;
import com.tmall.wireless.tangram.structure.view.GridEntityCardView;
import com.tmall.wireless.tangram.structure.view.SimpleEmptyView;
import com.tmall.wireless.tangram.structure.viewcreator.ViewHolderCreator;
import com.tmall.wireless.tangram.support.TimerSupport;
import com.tmall.wireless.tangram.util.IInnerImageSetter;
import com.tmall.wireless.tangram.util.ImageUtils;
import com.tmall.wireless.tangram.util.Preconditions;
import com.tmall.wireless.tangram.util.TangramViewMetrics;
import com.tmall.wireless.tangram.util.Utils;
import com.tmall.wireless.tangram.view.BannerView;
import com.tmall.wireless.tangram.view.LinearScrollView;

/* JADX INFO: loaded from: classes4.dex */
public class TangramBuilder {
    public static final int START_EXTENDED_CARD_TYPE = 1024;
    public static final int START_EXTENDED_CELL_TYPE = 1000;
    public static final int TYPE_CAROUSEL = 10;
    public static final int TYPE_CAROUSEL_CELL = -2;
    public static final int TYPE_CAROUSEL_ENTITY = 0;
    public static final int TYPE_DOUBLE_COLUMN = 2;
    public static final int TYPE_DOUBLE_COLUMN_ENTITY = 0;
    public static final int TYPE_EMPTY_VIEW = 0;
    public static final int TYPE_EXTENDED_VIEW = -1;
    public static final int TYPE_FIVE_COLUMN = 9;
    public static final int TYPE_FIVE_COLUMN_ENTITY = 0;
    public static final int TYPE_FIX = 1025;
    public static final int TYPE_FLOAT = 7;
    public static final int TYPE_FLOW = 27;
    public static final int TYPE_FOUR_COLUMN = 4;
    public static final int TYPE_FOUR_COLUMN_ENTITY = 0;
    public static final int TYPE_FUSION_TABS = 24;
    public static final int TYPE_GRID = 1026;
    public static final int TYPE_LINEAR = 1027;
    public static final int TYPE_LINEAR_SCROLL = 29;
    public static final int TYPE_LINEAR_SCROLL_CELL = -3;
    public static final int TYPE_ONE_PLUS_N = 5;
    public static final int TYPE_PIN_BOTTOM = 8;
    public static final int TYPE_PIN_TOP = 23;
    public static final int TYPE_SCROLL_FIX = 28;
    public static final int TYPE_SCROLL_FIX_BANNER = 30;
    public static final int TYPE_SIMPLE_IMAGE = 1;
    public static final int TYPE_SINGLE_COLUMN = 1;
    public static final int TYPE_SINGLE_COLUMN_ENTITY = 0;
    public static final int TYPE_STAGGER = 25;
    public static final int TYPE_STICKY = 20;
    public static final int TYPE_STICKY_END = 22;
    public static final int TYPE_STICKY_START = 21;
    public static final int TYPE_TRIPLE_COLUMN = 3;
    public static final int TYPE_TRIPLE_COLUMN_ENTITY = 0;
    public static final int TYPE_X_COLUMN = 1033;
    private static boolean printLog = false;
    private static boolean sInitialized = false;

    public static final class InnerBuilder {

        @NonNull
        private Context mContext;
        private DefaultResolverRegistry mDefaultResolverRegistry;
        private MVHelper mMVHelper;
        private MVResolver mMVResolver;
        private IAdapterBuilder mPojoAdapterBuilder;

        public InnerBuilder(@NonNull Context r10, DefaultResolverRegistry r11) {
            this.mContext = r10;
            this.mDefaultResolverRegistry = r11;
            this.mMVHelper = r11.getMVHelper();
            this.mPojoAdapterBuilder = new PojoAdapterBuilder();
        }

        public TangramEngine build() {
            TangramEngine r10 = new TangramEngine(this.mContext, new PojoDataParser(), this.mPojoAdapterBuilder);
            r10.register(MVHelper.class, this.mMVHelper);
            r10.register(CardResolver.class, this.mDefaultResolverRegistry.mDefaultCardResolver);
            r10.register(BaseCellBinderResolver.class, this.mDefaultResolverRegistry.mDefaultCellBinderResolver);
            r10.register(BaseCardBinderResolver.class, this.mDefaultResolverRegistry.mDefaultCardBinderResolver);
            r10.register(TimerSupport.class, new TimerSupport());
            r10.register(BusSupport.class, new BusSupport());
            return r10;
        }

        public int getCellTypeCount() {
            DefaultResolverRegistry r10 = this.mDefaultResolverRegistry;
            if (r10 != null) goto L5;
            return 0;
        L5:
            return r10.mDefaultCellBinderResolver.size();
        }

        public void registerCard(int r10, Class<? extends Card> r11) {
            this.mDefaultResolverRegistry.registerCard(r10, r11);
        }

        public <V extends View> void registerCell(int r10, @NonNull Class<? extends BaseCell> r11, @NonNull Class<V> r12) {
            this.mDefaultResolverRegistry.registerCell(r10, r11, r12);
        }

        public void setAdapterBuilder(@NonNull IAdapterBuilder r10) {
            Preconditions.checkNotNull(r10, "newInnerBuilder should not be null");
            this.mPojoAdapterBuilder = r10;
        }

        public <V extends View> void registerCell(int r10, @NonNull Class<? extends BaseCell> r11, @NonNull ViewHolderCreator r12) {
            this.mDefaultResolverRegistry.registerCell(r10, r11, r12);
        }

        public <V extends View> void registerCell(int r10, @NonNull Class<V> r11) {
            this.mDefaultResolverRegistry.registerCell(r10, r11);
        }
    }

    static {
        TYPE_SINGLE_COLUMN_ENTITY = Utils.cellizeCard(1);
        TYPE_DOUBLE_COLUMN_ENTITY = Utils.cellizeCard(2);
        TYPE_TRIPLE_COLUMN_ENTITY = Utils.cellizeCard(3);
        TYPE_FOUR_COLUMN_ENTITY = Utils.cellizeCard(4);
        TYPE_FIVE_COLUMN_ENTITY = Utils.cellizeCard(9);
        TYPE_CAROUSEL_ENTITY = Utils.cellizeCard(10);
    }

    public TangramBuilder() {
    }

    public static void init(@NonNull Context r10, IInnerImageSetter r11) {
        if (sInitialized == false) goto L5;
        return;
    L5:
        boolean r12 = false;
        if (r10 == null) goto L8;
        boolean r13 = true;
    L9:
        Preconditions.checkArgument(r13, "context should not be null");
        if (r11 == null) goto L12;
        r12 = true;
    L12:
        Preconditions.checkArgument(r12, "innerImageSetter should not be null");
        TangramViewMetrics.initWith(r10.getApplicationContext());
        ImageUtils.setImageSetter(r11);
        sInitialized = true;
        return;
    L8:
        r13 = false;
        goto L9
    }

    public static void installDefaultRegistry(@NonNull DefaultResolverRegistry r10) {
        r10.setMVHelper(new MVHelper(new MVResolver()));
        r10.registerCell(-1, Card.PlaceholderCell.class, SimpleEmptyView.class);
        r10.registerCell(0, BaseCell.class, SimpleEmptyView.class);
        r10.registerCell(-2, BannerView.class);
        r10.registerCell(TYPE_SINGLE_COLUMN_ENTITY, GridEntityCardView.class);
        r10.registerCell(TYPE_DOUBLE_COLUMN_ENTITY, GridEntityCardView.class);
        r10.registerCell(TYPE_TRIPLE_COLUMN_ENTITY, GridEntityCardView.class);
        r10.registerCell(TYPE_FOUR_COLUMN_ENTITY, GridEntityCardView.class);
        r10.registerCell(TYPE_FIVE_COLUMN_ENTITY, GridEntityCardView.class);
        r10.registerCell(TYPE_CAROUSEL_ENTITY, BannerView.class);
        r10.registerCell(-3, LinearScrollView.class);
        r10.registerCard(10, BannerCard.class);
        r10.registerCard(1, SingleColumnCard.class);
        r10.registerCard(2, DoubleColumnCard.class);
        r10.registerCard(3, TripleColumnCard.class);
        r10.registerCard(4, FourColumnCard.class);
        r10.registerCard(5, OnePlusNCard.class);
        r10.registerCard(7, FloatCard.class);
        r10.registerCard(8, PinBottomCard.class);
        r10.registerCard(9, FiveColumnCard.class);
        r10.registerCard(20, StickyCard.class);
        r10.registerCard(21, StickyCard.class);
        r10.registerCard(22, StickyEndCard.class);
        r10.registerCard(23, PinTopCard.class);
        r10.registerCard(25, StaggeredCard.class);
        r10.registerCard(24, FusionCard.class);
        r10.registerCard(27, FlowCard.class);
        r10.registerCard(28, ScrollFixCard.class);
        r10.registerCard(29, LinearScrollCard.class);
        r10.registerCard(30, FixLinearScrollCard.class);
        r10.registerCard(TYPE_FIX, FixCard.class);
        r10.registerCard(TYPE_GRID, GridCard.class);
        r10.registerCard(TYPE_LINEAR, LinearCard.class);
        r10.registerCard(TYPE_X_COLUMN, ColumnCard.class);
    }

    public static boolean isInitialized() {
        return sInitialized;
    }

    public static boolean isPrintLog() {
        return printLog;
    }

    @NonNull
    public static InnerBuilder newInnerBuilder(@NonNull Context r10) {
        if (isInitialized() == false) goto L7;
        DefaultResolverRegistry r11 = new DefaultResolverRegistry();
        installDefaultRegistry(r11);
        return new InnerBuilder(r10, r11);
    L7:
        throw new IllegalStateException("Tangram must be init first");
    }

    public static void switchLog(boolean r10) {
        printLog = r10;
    }
}
