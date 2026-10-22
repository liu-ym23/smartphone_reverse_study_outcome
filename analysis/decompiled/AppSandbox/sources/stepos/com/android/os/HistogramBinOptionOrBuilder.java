package stepos.com.android.os;

import com.google.protobuf.MessageLiteOrBuilder;
import stepos.com.android.os.HistogramBinOption;

/* loaded from: classes.dex */
public interface HistogramBinOptionOrBuilder extends MessageLiteOrBuilder {
    HistogramBinOption.BinningStrategyCase getBinningStrategyCase();

    HistogramBinOption.ExplicitBins getExplicitBins();

    HistogramBinOption.GeneratedBins getGeneratedBins();

    boolean hasExplicitBins();

    boolean hasGeneratedBins();
}
