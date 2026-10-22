package com.android.server.powerstats;

import android.hardware.power.stats.Channel;
import android.hardware.power.stats.EnergyConsumer;
import android.hardware.power.stats.EnergyConsumerAttribution;
import android.hardware.power.stats.EnergyConsumerResult;
import android.hardware.power.stats.EnergyMeasurement;
import android.hardware.power.stats.PowerEntity;
import android.hardware.power.stats.State;
import android.hardware.power.stats.StateResidency;
import android.hardware.power.stats.StateResidencyResult;
import android.util.Slog;
import android.util.proto.ProtoInputStream;
import android.util.proto.ProtoOutputStream;
import android.util.proto.ProtoUtils;
import android.util.proto.WireTypeMismatchException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ProtoStreamUtils {
    private static final String TAG = null;

    static class ChannelUtils {
        ChannelUtils() {
        }

        public static byte[] getProtoBytes(Channel[] channel) {
            ProtoOutputStream pos = new ProtoOutputStream();
            packProtoMessage(channel, pos);
            return pos.getBytes();
        }

        public static void packProtoMessage(Channel[] channel, ProtoOutputStream pos) {
            if (channel != null) goto L4;
            return;
        L4:
            int i = 0;
        L6:
            if (i >= channel.length) goto L9;
            long token = pos.start(2246267895809L);
            pos.write(1120986464257L, channel[i].id);
            pos.write(1138166333442L, channel[i].name);
            pos.write(1138166333443L, channel[i].subsystem);
            pos.end(token);
            i = i + 1;
            goto L6
        }

        public static void print(Channel[] channel) {
            if (channel != null) goto L4;
            return;
        L4:
            int i = 0;
        L6:
            if (i >= channel.length) goto L9;
            Slog.d(ProtoStreamUtils.m7887$$Nest$sfgetTAG(), "ChannelId: " + channel[i].id + ", ChannelName: " + channel[i].name + ", ChannelSubsystem: " + channel[i].subsystem);
            i = i + 1;
            goto L6
        }

        public static void dumpsys(Channel[] channel, PrintWriter pw) {
            if (channel != null) goto L4;
            return;
        L4:
            int i = 0;
        L6:
            if (i >= channel.length) goto L9;
            pw.println("ChannelId: " + channel[i].id + ", ChannelName: " + channel[i].name + ", ChannelSubsystem: " + channel[i].subsystem);
            i = i + 1;
            goto L6
        }
    }

    static class EnergyConsumerResultUtils {
        EnergyConsumerResultUtils() {
        }

        public static void adjustTimeSinceBootToEpoch(EnergyConsumerResult[] energyConsumerResult, long startWallTime) {
            if (energyConsumerResult != null) goto L4;
            return;
        L4:
            int i = 0;
        L6:
            if (i >= energyConsumerResult.length) goto L9;
            energyConsumerResult[i].timestampMs += startWallTime;
            i = i + 1;
            goto L6
        }

        public static byte[] getProtoBytes(EnergyConsumerResult[] energyConsumerResult, boolean includeAttribution) {
            ProtoOutputStream pos = new ProtoOutputStream();
            packProtoMessage(energyConsumerResult, pos, includeAttribution);
            return pos.getBytes();
        }

        public static void packProtoMessage(EnergyConsumerResult[] energyConsumerResult, ProtoOutputStream pos, boolean includeAttribution) {
            if (energyConsumerResult != null) goto L5;
            return;
        L5:
            int i = 0;
        L7:
            if (i >= energyConsumerResult.length) goto L15;
            long ecrToken = pos.start(2246267895810L);
            pos.write(1120986464257L, energyConsumerResult[i].id);
            pos.write(1112396529666L, energyConsumerResult[i].timestampMs);
            pos.write(1112396529667L, energyConsumerResult[i].energyUWs);
            if (includeAttribution == false) goto L13;
            int attributionLength = energyConsumerResult[i].attribution.length;
            int j = 0;
        L11:
            if (j >= attributionLength) goto L13;
            EnergyConsumerAttribution energyConsumerAttribution = energyConsumerResult[i].attribution[j];
            long ecaToken = pos.start(2246267895812L);
            pos.write(1120986464257L, energyConsumerAttribution.uid);
            pos.write(1112396529666L, energyConsumerAttribution.energyUWs);
            pos.end(ecaToken);
            j = j + 1;
        L13:
            pos.end(ecrToken);
            i = i + 1;
            goto L7
        }

        public static EnergyConsumerResult[] unpackProtoMessage(byte[] data) throws IOException {
            ProtoInputStream pis = new ProtoInputStream(new ByteArrayInputStream(data));
            List<EnergyConsumerResult> energyConsumerResultList = new ArrayList();
        L15:
            int nextField = pis.nextField();     // Catch: WireTypeMismatchException -> L6
            new EnergyConsumerResult();     // Catch: WireTypeMismatchException -> L6
            if (nextField == 2) goto L5;
            if (nextField != (-1)) goto L12;
            return (EnergyConsumerResult[]) energyConsumerResultList.toArray(new EnergyConsumerResult[energyConsumerResultList.size()]);
        L12:
            Slog.e(ProtoStreamUtils.m7887$$Nest$sfgetTAG(), "Unhandled field in proto: " + ProtoUtils.currentFieldToString(pis));     // Catch: WireTypeMismatchException -> L6
            goto L15
        L5:
            long token = pis.start(2246267895810L);     // Catch: WireTypeMismatchException -> L6
            energyConsumerResultList.add(unpackEnergyConsumerResultProto(pis));     // Catch: WireTypeMismatchException -> L6
            pis.end(token);     // Catch: WireTypeMismatchException -> L6
        L14:
            Slog.e(ProtoStreamUtils.m7887$$Nest$sfgetTAG(), "Wire Type mismatch in proto: " + ProtoUtils.currentFieldToString(pis));
            goto L15
        }

        private static EnergyConsumerAttribution unpackEnergyConsumerAttributionProto(ProtoInputStream pis) throws IOException {
            EnergyConsumerAttribution energyConsumerAttribution = new EnergyConsumerAttribution();
        L13:
            switch(pis.nextField()) {
                case -1: goto L11;
                case 0: goto L5;
                case 1: goto L9;
                case 2: goto L8;
                default: goto L5;
            };     // Catch: WireTypeMismatchException -> L6
        L8:
            energyConsumerAttribution.energyUWs = pis.readLong(1112396529666L);     // Catch: WireTypeMismatchException -> L6
            goto L13
        L9:
            energyConsumerAttribution.uid = pis.readInt(1120986464257L);     // Catch: WireTypeMismatchException -> L6
            goto L13
        L11:
            return energyConsumerAttribution;
        L5:
            Slog.e(ProtoStreamUtils.m7887$$Nest$sfgetTAG(), "Unhandled field in EnergyConsumerAttributionProto: " + ProtoUtils.currentFieldToString(pis));     // Catch: WireTypeMismatchException -> L6
        L12:
            Slog.e(ProtoStreamUtils.m7887$$Nest$sfgetTAG(), "Wire Type mismatch in EnergyConsumerAttributionProto: " + ProtoUtils.currentFieldToString(pis));
            goto L13
        }

        private static EnergyConsumerResult unpackEnergyConsumerResultProto(ProtoInputStream pis) throws IOException {
            EnergyConsumerResult energyConsumerResult = new EnergyConsumerResult();
            List<EnergyConsumerAttribution> energyConsumerAttributionList = new ArrayList();
        L16:
            switch(pis.nextField()) {
                case -1: goto L13;
                case 0: goto L5;
                case 1: goto L11;
                case 2: goto L10;
                case 3: goto L9;
                case 4: goto L8;
                default: goto L5;
            };     // Catch: WireTypeMismatchException -> L6
        L5:
            Slog.e(ProtoStreamUtils.m7887$$Nest$sfgetTAG(), "Unhandled field in EnergyConsumerResultProto: " + ProtoUtils.currentFieldToString(pis));     // Catch: WireTypeMismatchException -> L6
            goto L16
        L8:
            long token = pis.start(2246267895812L);     // Catch: WireTypeMismatchException -> L6
            energyConsumerAttributionList.add(unpackEnergyConsumerAttributionProto(pis));     // Catch: WireTypeMismatchException -> L6
            pis.end(token);     // Catch: WireTypeMismatchException -> L6
            goto L16
        L9:
            energyConsumerResult.energyUWs = pis.readLong(1112396529667L);     // Catch: WireTypeMismatchException -> L6
            goto L16
        L10:
            energyConsumerResult.timestampMs = pis.readLong(1112396529666L);     // Catch: WireTypeMismatchException -> L6
            goto L16
        L11:
            energyConsumerResult.id = pis.readInt(1120986464257L);     // Catch: WireTypeMismatchException -> L6
            goto L16
        L13:
            energyConsumerResult.attribution = (EnergyConsumerAttribution[]) energyConsumerAttributionList.toArray(new EnergyConsumerAttribution[energyConsumerAttributionList.size()]);     // Catch: WireTypeMismatchException -> L6
            return energyConsumerResult;
        L15:
            Slog.e(ProtoStreamUtils.m7887$$Nest$sfgetTAG(), "Wire Type mismatch in EnergyConsumerResultProto: " + ProtoUtils.currentFieldToString(pis));
            goto L16
        }

        public static void print(EnergyConsumerResult[] energyConsumerResult) {
            if (energyConsumerResult != null) goto L4;
            return;
        L4:
            int i = 0;
        L6:
            if (i >= energyConsumerResult.length) goto L12;
            EnergyConsumerResult result = energyConsumerResult[i];
            Slog.d(ProtoStreamUtils.m7887$$Nest$sfgetTAG(), "EnergyConsumerId: " + result.id + ", Timestamp (ms): " + result.timestampMs + ", Energy (uWs): " + result.energyUWs);
            int attributionLength = result.attribution.length;
            int j = 0;
        L8:
            if (j >= attributionLength) goto L10;
            EnergyConsumerAttribution attribution = result.attribution[j];
            Slog.d(ProtoStreamUtils.m7887$$Nest$sfgetTAG(), "  UID: " + attribution.uid + "  Energy (uWs): " + attribution.energyUWs);
            j = j + 1;
            goto L8
        L10:
            i = i + 1;
            goto L6
        }
    }

    static class EnergyConsumerUtils {
        EnergyConsumerUtils() {
        }

        public static byte[] getProtoBytes(EnergyConsumer[] energyConsumer) {
            ProtoOutputStream pos = new ProtoOutputStream();
            packProtoMessage(energyConsumer, pos);
            return pos.getBytes();
        }

        public static void packProtoMessage(EnergyConsumer[] energyConsumer, ProtoOutputStream pos) {
            if (energyConsumer != null) goto L4;
            return;
        L4:
            int i = 0;
        L6:
            if (i >= energyConsumer.length) goto L9;
            long token = pos.start(2246267895809L);
            pos.write(1120986464257L, energyConsumer[i].id);
            pos.write(1120986464258L, energyConsumer[i].ordinal);
            pos.write(1120986464259L, energyConsumer[i].type);
            pos.write(1138166333444L, energyConsumer[i].name);
            pos.end(token);
            i = i + 1;
            goto L6
        }

        public static EnergyConsumer[] unpackProtoMessage(byte[] data) throws IOException {
            ProtoInputStream pis = new ProtoInputStream(new ByteArrayInputStream(data));
            List<EnergyConsumer> energyConsumerList = new ArrayList();
        L15:
            int nextField = pis.nextField();     // Catch: WireTypeMismatchException -> L6
            new EnergyConsumer();     // Catch: WireTypeMismatchException -> L6
            if (nextField == 1) goto L5;
            if (nextField != (-1)) goto L12;
            return (EnergyConsumer[]) energyConsumerList.toArray(new EnergyConsumer[energyConsumerList.size()]);
        L12:
            Slog.e(ProtoStreamUtils.m7887$$Nest$sfgetTAG(), "Unhandled field in proto: " + ProtoUtils.currentFieldToString(pis));     // Catch: WireTypeMismatchException -> L6
            goto L15
        L5:
            long token = pis.start(2246267895809L);     // Catch: WireTypeMismatchException -> L6
            energyConsumerList.add(unpackEnergyConsumerProto(pis));     // Catch: WireTypeMismatchException -> L6
            pis.end(token);     // Catch: WireTypeMismatchException -> L6
        L14:
            Slog.e(ProtoStreamUtils.m7887$$Nest$sfgetTAG(), "Wire Type mismatch in proto: " + ProtoUtils.currentFieldToString(pis));
            goto L15
        }

        private static EnergyConsumer unpackEnergyConsumerProto(ProtoInputStream pis) throws IOException {
            EnergyConsumer energyConsumer = new EnergyConsumer();
        L15:
            switch(pis.nextField()) {
                case -1: goto L13;
                case 0: goto L5;
                case 1: goto L11;
                case 2: goto L10;
                case 3: goto L9;
                case 4: goto L8;
                default: goto L5;
            };     // Catch: WireTypeMismatchException -> L6
        L8:
            energyConsumer.name = pis.readString(1138166333444L);     // Catch: WireTypeMismatchException -> L6
            goto L15
        L9:
            energyConsumer.type = (byte) pis.readInt(1120986464259L);     // Catch: WireTypeMismatchException -> L6
            goto L15
        L10:
            energyConsumer.ordinal = pis.readInt(1120986464258L);     // Catch: WireTypeMismatchException -> L6
            goto L15
        L11:
            energyConsumer.id = pis.readInt(1120986464257L);     // Catch: WireTypeMismatchException -> L6
            goto L15
        L13:
            return energyConsumer;
        L5:
            Slog.e(ProtoStreamUtils.m7887$$Nest$sfgetTAG(), "Unhandled field in EnergyConsumerProto: " + ProtoUtils.currentFieldToString(pis));     // Catch: WireTypeMismatchException -> L6
        L14:
            Slog.e(ProtoStreamUtils.m7887$$Nest$sfgetTAG(), "Wire Type mismatch in EnergyConsumerProto: " + ProtoUtils.currentFieldToString(pis));
            goto L15
        }

        public static void print(EnergyConsumer[] energyConsumer) {
            if (energyConsumer != null) goto L4;
            return;
        L4:
            int i = 0;
        L6:
            if (i >= energyConsumer.length) goto L9;
            Slog.d(ProtoStreamUtils.m7887$$Nest$sfgetTAG(), "EnergyConsumerId: " + energyConsumer[i].id + ", Ordinal: " + energyConsumer[i].ordinal + ", Type: " + energyConsumer[i].type + ", Name: " + energyConsumer[i].name);
            i = i + 1;
            goto L6
        }

        public static void dumpsys(EnergyConsumer[] energyConsumer, PrintWriter pw) {
            if (energyConsumer != null) goto L4;
            return;
        L4:
            int i = 0;
        L6:
            if (i >= energyConsumer.length) goto L9;
            pw.println("EnergyConsumerId: " + energyConsumer[i].id + ", Ordinal: " + energyConsumer[i].ordinal + ", Type: " + energyConsumer[i].type + ", Name: " + energyConsumer[i].name);
            i = i + 1;
            goto L6
        }
    }

    static class EnergyMeasurementUtils {
        EnergyMeasurementUtils() {
        }

        public static void adjustTimeSinceBootToEpoch(EnergyMeasurement[] energyMeasurement, long startWallTime) {
            if (energyMeasurement != null) goto L4;
            return;
        L4:
            int i = 0;
        L6:
            if (i >= energyMeasurement.length) goto L9;
            energyMeasurement[i].timestampMs += startWallTime;
            i = i + 1;
            goto L6
        }

        public static byte[] getProtoBytes(EnergyMeasurement[] energyMeasurement) {
            ProtoOutputStream pos = new ProtoOutputStream();
            packProtoMessage(energyMeasurement, pos);
            return pos.getBytes();
        }

        public static void packProtoMessage(EnergyMeasurement[] energyMeasurement, ProtoOutputStream pos) {
            if (energyMeasurement != null) goto L4;
            return;
        L4:
            int i = 0;
        L6:
            if (i >= energyMeasurement.length) goto L9;
            long token = pos.start(2246267895810L);
            pos.write(1120986464257L, energyMeasurement[i].id);
            pos.write(1112396529666L, energyMeasurement[i].timestampMs);
            pos.write(1112396529668L, energyMeasurement[i].durationMs);
            pos.write(1112396529667L, energyMeasurement[i].energyUWs);
            pos.end(token);
            i = i + 1;
            goto L6
        }

        public static EnergyMeasurement[] unpackProtoMessage(byte[] data) throws IOException {
            ProtoInputStream pis = new ProtoInputStream(new ByteArrayInputStream(data));
            List<EnergyMeasurement> energyMeasurementList = new ArrayList();
        L15:
            int nextField = pis.nextField();     // Catch: WireTypeMismatchException -> L6
            new EnergyMeasurement();     // Catch: WireTypeMismatchException -> L6
            if (nextField == 2) goto L5;
            if (nextField != (-1)) goto L12;
            return (EnergyMeasurement[]) energyMeasurementList.toArray(new EnergyMeasurement[energyMeasurementList.size()]);
        L12:
            Slog.e(ProtoStreamUtils.m7887$$Nest$sfgetTAG(), "Unhandled field in proto: " + ProtoUtils.currentFieldToString(pis));     // Catch: WireTypeMismatchException -> L6
            goto L15
        L5:
            long token = pis.start(2246267895810L);     // Catch: WireTypeMismatchException -> L6
            energyMeasurementList.add(unpackEnergyMeasurementProto(pis));     // Catch: WireTypeMismatchException -> L6
            pis.end(token);     // Catch: WireTypeMismatchException -> L6
        L14:
            Slog.e(ProtoStreamUtils.m7887$$Nest$sfgetTAG(), "Wire Type mismatch in proto: " + ProtoUtils.currentFieldToString(pis));
            goto L15
        }

        private static EnergyMeasurement unpackEnergyMeasurementProto(ProtoInputStream pis) throws IOException {
            EnergyMeasurement energyMeasurement = new EnergyMeasurement();
        L15:
            switch(pis.nextField()) {
                case -1: goto L13;
                case 0: goto L5;
                case 1: goto L11;
                case 2: goto L10;
                case 3: goto L9;
                case 4: goto L8;
                default: goto L5;
            };     // Catch: WireTypeMismatchException -> L6
        L8:
            energyMeasurement.durationMs = pis.readLong(1112396529668L);     // Catch: WireTypeMismatchException -> L6
            goto L15
        L9:
            energyMeasurement.energyUWs = pis.readLong(1112396529667L);     // Catch: WireTypeMismatchException -> L6
            goto L15
        L10:
            energyMeasurement.timestampMs = pis.readLong(1112396529666L);     // Catch: WireTypeMismatchException -> L6
            goto L15
        L11:
            energyMeasurement.id = pis.readInt(1120986464257L);     // Catch: WireTypeMismatchException -> L6
            goto L15
        L13:
            return energyMeasurement;
        L5:
            Slog.e(ProtoStreamUtils.m7887$$Nest$sfgetTAG(), "Unhandled field in EnergyMeasurementProto: " + ProtoUtils.currentFieldToString(pis));     // Catch: WireTypeMismatchException -> L6
        L14:
            Slog.e(ProtoStreamUtils.m7887$$Nest$sfgetTAG(), "Wire Type mismatch in EnergyMeasurementProto: " + ProtoUtils.currentFieldToString(pis));
            goto L15
        }

        public static void print(EnergyMeasurement[] energyMeasurement) {
            if (energyMeasurement != null) goto L4;
            return;
        L4:
            int i = 0;
        L6:
            if (i >= energyMeasurement.length) goto L9;
            Slog.d(ProtoStreamUtils.m7887$$Nest$sfgetTAG(), "ChannelId: " + energyMeasurement[i].id + ", Timestamp (ms): " + energyMeasurement[i].timestampMs + ", Duration (ms): " + energyMeasurement[i].durationMs + ", Energy (uWs): " + energyMeasurement[i].energyUWs);
            i = i + 1;
            goto L6
        }
    }

    static class PowerEntityUtils {
        PowerEntityUtils() {
        }

        public static byte[] getProtoBytes(PowerEntity[] powerEntity) {
            ProtoOutputStream pos = new ProtoOutputStream();
            packProtoMessage(powerEntity, pos);
            return pos.getBytes();
        }

        public static void packProtoMessage(PowerEntity[] powerEntity, ProtoOutputStream pos) {
            if (powerEntity != null) goto L4;
            return;
        L4:
            int i = 0;
        L6:
            if (i >= powerEntity.length) goto L14;
            long peToken = pos.start(2246267895809L);
            pos.write(1120986464257L, powerEntity[i].id);
            pos.write(1138166333442L, powerEntity[i].name);
            if (powerEntity[i].states == null) goto L12;
            int statesLength = powerEntity[i].states.length;
            int j = 0;
        L10:
            if (j >= statesLength) goto L12;
            State state = powerEntity[i].states[j];
            long stateToken = pos.start(2246267895811L);
            pos.write(1120986464257L, state.id);
            pos.write(1138166333442L, state.name);
            pos.end(stateToken);
            j = j + 1;
        L12:
            pos.end(peToken);
            i = i + 1;
            goto L6
        }

        public static void print(PowerEntity[] powerEntity) {
            if (powerEntity != null) goto L4;
            return;
        L4:
            int i = 0;
        L6:
            if (i >= powerEntity.length) goto L15;
            Slog.d(ProtoStreamUtils.m7887$$Nest$sfgetTAG(), "powerEntityId: " + powerEntity[i].id + ", powerEntityName: " + powerEntity[i].name);
            if (powerEntity[i].states == null) goto L13;
            int j = 0;
        L11:
            if (j >= powerEntity[i].states.length) goto L13;
            Slog.d(ProtoStreamUtils.m7887$$Nest$sfgetTAG(), "  StateId: " + powerEntity[i].states[j].id + ", StateName: " + powerEntity[i].states[j].name);
            j = j + 1;
        L13:
            i = i + 1;
            goto L6
        }

        public static void dumpsys(PowerEntity[] powerEntity, PrintWriter pw) {
            if (powerEntity != null) goto L4;
            return;
        L4:
            int i = 0;
        L6:
            if (i >= powerEntity.length) goto L15;
            pw.println("PowerEntityId: " + powerEntity[i].id + ", PowerEntityName: " + powerEntity[i].name);
            if (powerEntity[i].states == null) goto L13;
            int j = 0;
        L11:
            if (j >= powerEntity[i].states.length) goto L13;
            pw.println("  StateId: " + powerEntity[i].states[j].id + ", StateName: " + powerEntity[i].states[j].name);
            j = j + 1;
        L13:
            i = i + 1;
            goto L6
        }
    }

    static class StateResidencyResultUtils {
        StateResidencyResultUtils() {
        }

        public static void adjustTimeSinceBootToEpoch(StateResidencyResult[] stateResidencyResult, long startWallTime) {
            if (stateResidencyResult != null) goto L4;
            return;
        L4:
            int i = 0;
        L6:
            if (i >= stateResidencyResult.length) goto L12;
            int stateLength = stateResidencyResult[i].stateResidencyData.length;
            int j = 0;
        L8:
            if (j >= stateLength) goto L10;
            StateResidency stateResidencyData = stateResidencyResult[i].stateResidencyData[j];
            stateResidencyData.lastEntryTimestampMs += startWallTime;
            j = j + 1;
            goto L8
        L10:
            i = i + 1;
            goto L6
        }

        public static byte[] getProtoBytes(StateResidencyResult[] stateResidencyResult) {
            ProtoOutputStream pos = new ProtoOutputStream();
            packProtoMessage(stateResidencyResult, pos);
            return pos.getBytes();
        }

        public static void packProtoMessage(StateResidencyResult[] stateResidencyResult, ProtoOutputStream pos) {
            if (stateResidencyResult != null) goto L5;
            return;
        L5:
            int i = 0;
        L7:
            if (i >= stateResidencyResult.length) goto L13;
            int stateLength = stateResidencyResult[i].stateResidencyData.length;
            long r4 = 2246267895810L;
            long srrToken = pos.start(2246267895810L);
            pos.write(1120986464257L, stateResidencyResult[i].id);
            int j = 0;
        L9:
            if (j >= stateLength) goto L11;
            StateResidency stateResidencyData = stateResidencyResult[i].stateResidencyData[j];
            long srdToken = pos.start(r4);
            pos.write(1120986464257L, stateResidencyData.id);
            pos.write(1112396529666L, stateResidencyData.totalTimeInStateMs);
            pos.write(1112396529667L, stateResidencyData.totalStateEntryCount);
            pos.write(1112396529668L, stateResidencyData.lastEntryTimestampMs);
            pos.end(srdToken);
            j = j + 1;
            r4 = 2246267895810L;
            goto L9
        L11:
            pos.end(srrToken);
            i = i + 1;
            goto L7
        }

        public static StateResidencyResult[] unpackProtoMessage(byte[] data) throws IOException {
            ProtoInputStream pis = new ProtoInputStream(new ByteArrayInputStream(data));
            List<StateResidencyResult> stateResidencyResultList = new ArrayList();
        L15:
            int nextField = pis.nextField();     // Catch: WireTypeMismatchException -> L6
            new StateResidencyResult();     // Catch: WireTypeMismatchException -> L6
            if (nextField == 2) goto L5;
            if (nextField != (-1)) goto L12;
            return (StateResidencyResult[]) stateResidencyResultList.toArray(new StateResidencyResult[stateResidencyResultList.size()]);
        L12:
            Slog.e(ProtoStreamUtils.m7887$$Nest$sfgetTAG(), "Unhandled field in PowerStatsServiceResidencyProto: " + ProtoUtils.currentFieldToString(pis));     // Catch: WireTypeMismatchException -> L6
            goto L15
        L5:
            long token = pis.start(2246267895810L);     // Catch: WireTypeMismatchException -> L6
            stateResidencyResultList.add(unpackStateResidencyResultProto(pis));     // Catch: WireTypeMismatchException -> L6
            pis.end(token);     // Catch: WireTypeMismatchException -> L6
        L14:
            Slog.e(ProtoStreamUtils.m7887$$Nest$sfgetTAG(), "Wire Type mismatch in PowerStatsServiceResidencyProto: " + ProtoUtils.currentFieldToString(pis));
            goto L15
        }

        private static StateResidencyResult unpackStateResidencyResultProto(ProtoInputStream pis) throws IOException {
            StateResidencyResult stateResidencyResult = new StateResidencyResult();
            List<StateResidency> stateResidencyList = new ArrayList();
        L14:
            switch(pis.nextField()) {
                case -1: goto L11;
                case 0: goto L5;
                case 1: goto L9;
                case 2: goto L8;
                default: goto L5;
            };     // Catch: WireTypeMismatchException -> L6
        L5:
            Slog.e(ProtoStreamUtils.m7887$$Nest$sfgetTAG(), "Unhandled field in StateResidencyResultProto: " + ProtoUtils.currentFieldToString(pis));     // Catch: WireTypeMismatchException -> L6
            goto L14
        L8:
            long token = pis.start(2246267895810L);     // Catch: WireTypeMismatchException -> L6
            stateResidencyList.add(unpackStateResidencyProto(pis));     // Catch: WireTypeMismatchException -> L6
            pis.end(token);     // Catch: WireTypeMismatchException -> L6
            goto L14
        L9:
            stateResidencyResult.id = pis.readInt(1120986464257L);     // Catch: WireTypeMismatchException -> L6
            goto L14
        L11:
            stateResidencyResult.stateResidencyData = (StateResidency[]) stateResidencyList.toArray(new StateResidency[stateResidencyList.size()]);     // Catch: WireTypeMismatchException -> L6
            return stateResidencyResult;
        L13:
            Slog.e(ProtoStreamUtils.m7887$$Nest$sfgetTAG(), "Wire Type mismatch in StateResidencyResultProto: " + ProtoUtils.currentFieldToString(pis));
            goto L14
        }

        private static StateResidency unpackStateResidencyProto(ProtoInputStream pis) throws IOException {
            StateResidency stateResidency = new StateResidency();
        L15:
            switch(pis.nextField()) {
                case -1: goto L13;
                case 0: goto L5;
                case 1: goto L11;
                case 2: goto L10;
                case 3: goto L9;
                case 4: goto L8;
                default: goto L5;
            };     // Catch: WireTypeMismatchException -> L6
        L8:
            stateResidency.lastEntryTimestampMs = pis.readLong(1112396529668L);     // Catch: WireTypeMismatchException -> L6
            goto L15
        L9:
            stateResidency.totalStateEntryCount = pis.readLong(1112396529667L);     // Catch: WireTypeMismatchException -> L6
            goto L15
        L10:
            stateResidency.totalTimeInStateMs = pis.readLong(1112396529666L);     // Catch: WireTypeMismatchException -> L6
            goto L15
        L11:
            stateResidency.id = pis.readInt(1120986464257L);     // Catch: WireTypeMismatchException -> L6
            goto L15
        L13:
            return stateResidency;
        L5:
            Slog.e(ProtoStreamUtils.m7887$$Nest$sfgetTAG(), "Unhandled field in StateResidencyProto: " + ProtoUtils.currentFieldToString(pis));     // Catch: WireTypeMismatchException -> L6
        L14:
            Slog.e(ProtoStreamUtils.m7887$$Nest$sfgetTAG(), "Wire Type mismatch in StateResidencyProto: " + ProtoUtils.currentFieldToString(pis));
            goto L15
        }

        public static void print(StateResidencyResult[] stateResidencyResult) {
            if (stateResidencyResult != null) goto L4;
            return;
        L4:
            int i = 0;
        L6:
            if (i >= stateResidencyResult.length) goto L13;
            Slog.d(ProtoStreamUtils.m7887$$Nest$sfgetTAG(), "PowerEntityId: " + stateResidencyResult[i].id);
            int j = 0;
        L9:
            if (j >= stateResidencyResult[i].stateResidencyData.length) goto L11;
            Slog.d(ProtoStreamUtils.m7887$$Nest$sfgetTAG(), "  StateId: " + stateResidencyResult[i].stateResidencyData[j].id + ", TotalTimeInStateMs: " + stateResidencyResult[i].stateResidencyData[j].totalTimeInStateMs + ", TotalStateEntryCount: " + stateResidencyResult[i].stateResidencyData[j].totalStateEntryCount + ", LastEntryTimestampMs: " + stateResidencyResult[i].stateResidencyData[j].lastEntryTimestampMs);
            j = j + 1;
            goto L9
        L11:
            i = i + 1;
            goto L6
        }
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m7887$$Nest$sfgetTAG() {
        return TAG;
    }

    public ProtoStreamUtils() {
    }

    static {
        TAG = ProtoStreamUtils.class.getSimpleName();
    }
}
